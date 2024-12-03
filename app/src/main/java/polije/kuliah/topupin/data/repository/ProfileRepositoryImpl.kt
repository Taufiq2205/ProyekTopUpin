package polije.kuliah.topupin.data.repository

import android.util.Log
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.model.UserSend
import polije.kuliah.topupin.data.repository.datasource.UserLocalDataSource
import polije.kuliah.topupin.data.repository.datasource.UserRemoteDataSource
import polije.kuliah.topupin.domain.repository.ProfileRepository

import kotlin.math.log

class ProfileRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : ProfileRepository{

    override suspend fun getUserProfile(userSend: UserSend): User? {
        return getProfileFromDB(userSend)

    }override suspend fun getUserProfile(): User? {
        return getProfileFromDB()
    }

    suspend fun getProfileFromAPI(userSend: UserSend):User?{
        var userProfile: User?=null
        try{
            val response = userRemoteDataSource.getUser(userSend)
            val body = response.body()
            Log.i("MyTag","user sending : ${userSend.toString()}")
            Log.i("MyTag",body.toString())
            if(body!=null){
                userProfile = body.user
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return userProfile
    }

    suspend fun getProfileFromDB(userSend: UserSend): User?{
        var userProfile:User?=null
        try {
            userProfile = userLocalDataSource.getUserFromDB(userSend.username)
//            Log.i("MyTag",userProfile.toString())
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(userProfile!=null){
            return userProfile
        }else{
            userProfile = getProfileFromAPI(userSend)
            userLocalDataSource.saveUserFromDB(userProfile)
        }
        return userProfile
    }
    suspend fun getProfileFromDB(): User?{
        var userProfile:User?=null
        try {
            userProfile = userLocalDataSource.getUserFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return userProfile
    }


}