package polije.kuliah.topupin.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import polije.kuliah.topupin.data.model.User


@Database(entities = [User::class],
    exportSchema = false,
    version = 1)
abstract class TopUpinDatabase  : RoomDatabase(){
    abstract fun UserDao():UserDAO
}