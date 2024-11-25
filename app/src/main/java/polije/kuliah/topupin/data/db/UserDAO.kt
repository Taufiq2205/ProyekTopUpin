package polije.kuliah.topupin.data.db

import android.provider.ContactsContract.Data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import polije.kuliah.topupin.data.model.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: User)
    @Query("DELETE FROM user_data")
    suspend fun deleteAllUser()
    @Query("SELECT * FROM user_data WHERE username=:username")
    suspend fun getUser(username:String):User
}