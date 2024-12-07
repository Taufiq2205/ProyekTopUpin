package polije.kuliah.topupin.data.repository

import android.util.Log
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.data.repository.datasource.user.UserLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.user.UserRemoteDataSource
import polije.kuliah.topupin.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUserProfileFromDB(userLogin: UserLogin): User? {
        return getProfileFromDB(userLogin)

    }

    override suspend fun getUserProfileFromDB(): User? {
        return getProfileFromDB()
    }


    override suspend fun updateUserProfile(userData: UserData) {
        return updateProfileFromAPI(userData)
    }


    suspend fun updateProfileFromAPI(userData: UserData) {
        try {
            userRemoteDataSource.updateuser(userData)
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
    }

    suspend fun getProfileFromAPI(userLogin: UserLogin): User? {
        var userProfile: User? = null
        try {
            val response = userRemoteDataSource.getUser(userLogin)
            val body = response.body()
            Log.i("MyTag", "user sending : ${userLogin.toString()}")
            Log.i("MyTag", body.toString())
            if (body != null) {
                userProfile = body.user
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return userProfile
    }

    suspend fun getProfileFromDB(userLogin: UserLogin): User? {
        var userProfile: User? = null

        try {
            // First, check the database for the user profile
            userProfile = userLocalDataSource.getUserFromDB(userLogin.username)

            // If the profile is found in the database, check if it's the same as the API data
            val checkData = getProfileFromAPI(userLogin)

            if (checkData != null && checkData == userProfile) {
                // If data from API and DB are the same, log it and return the profile from DB
                Log.i("MyTag", "The data from API and DB are the same.")
                userProfile = checkData
                userLocalDataSource.clearAll()
                // Save the new profile from API to the database
                userLocalDataSource.saveUserFromDB(userProfile)
                return userProfile
            }


        } catch (exception: Exception) {
            Log.e("MyTag", "Error fetching profile: ${exception.message}")
        }

        // If userProfile is still null, fetch from API and save to DB
        if (userProfile == null) {
            userProfile = getProfileFromAPI(userLogin)
            userLocalDataSource.saveUserFromDB(userProfile)
        }

        return userProfile
    }


    suspend fun getProfileFromDB(): User? {
        var userProfile: User? = null
        try {
            userProfile = userLocalDataSource.getUserFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return userProfile
    }


}