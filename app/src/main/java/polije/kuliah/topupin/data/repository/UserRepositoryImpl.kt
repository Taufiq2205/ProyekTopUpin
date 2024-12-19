package polije.kuliah.topupin.data.repository

import android.util.Log
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserData
import polije.kuliah.topupin.data.model.UserLogin
import polije.kuliah.topupin.data.model.UserRegister
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

    override suspend fun getUserProfileFromAPI(userLogin: UserLogin): User? {
        return getProfileFromAPI(userLogin)
    }


    override suspend fun updateUserProfile(userData: UserData) {
        return updateProfileFromAPI(userData)
    }

    override suspend fun postUserRegister(userRegister: UserRegister) {
        return postUserRegisterfromAPI(userRegister)
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
            if (body != null && body.status == "success") {
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

            val checkData = getProfileFromAPI(userLogin)

            if (checkData != null && checkUser(userProfile,checkData)) {
                // If data from API and DB are the same, log it and return the profile from DB
                Log.i("MyTag", "The data from API and DB are the same.")

                return userProfile
            }else{
                Log.d("MyTag","check Data : ${checkData}\nUser Profile : ${userProfile}")
                Log.i("MyTag","The Data Override the DB")
                userProfile = checkData
                userLocalDataSource.clearAll()
                userLocalDataSource.saveUserFromDB(checkData)
            }


        } catch (exception: Exception) {
            Log.e("MyTag", "Error fetching profile: ${exception.message}")
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
    fun checkUser(OldUser : User,newUser:User) : Boolean{
        return OldUser.username == newUser.username
                && OldUser.email == newUser.email
                && OldUser.noHp == newUser.noHp
    }

    suspend fun postUserRegisterfromAPI(userRegister: UserRegister) {
        try {
            userRemoteDataSource.postregister(userRegister)
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
    }

}