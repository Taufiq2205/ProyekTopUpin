package polije.kuliah.topupin.data.repository.datasourceImpl.user

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import polije.kuliah.topupin.data.db.UserDAO
import polije.kuliah.topupin.data.model.User
import polije.kuliah.topupin.data.repository.datasource.user.UserLocalDataSource

class UserLocalDataSourceImpl(private val userDao:UserDAO) : UserLocalDataSource {

    override suspend fun getUserFromDB(username:String): User {
        return userDao.getUser(username)
    }

    override suspend fun getUserFromDB(): User {
        return userDao.getMainUser()
    }



    override suspend fun saveUserFromDB(user: User?) {
        CoroutineScope(Dispatchers.IO).launch {
            if (user != null) {
                userDao.saveUser(user)
            }else {
                Log.i("MyTag", "User is null, skipping save operation.")
            }
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteAllUser()
        }
    }
}