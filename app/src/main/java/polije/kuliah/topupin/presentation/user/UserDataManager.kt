package polije.kuliah.topupin.presentation.user

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class UserDataManager(private val context: Context) {
    private val USER_NAME_KEY = stringPreferencesKey("user_name")
    private val USER_PASSWORD = stringPreferencesKey("user_password")

    suspend fun saveCredential(username:String, password:String){
        context.dataStore.edit{ preferences ->
            preferences[USER_NAME_KEY] = username
            preferences[USER_PASSWORD] = password
        }
    }
    fun getUserName(): Flow<String> {
        return context.dataStore.data
            .map { preferences->
                preferences[USER_NAME_KEY] ?: "No Username Found"
            }
    }
    fun getUserPassword():Flow<String>{
        return context.dataStore.data
            .map { preferences ->
                preferences[USER_PASSWORD] ?: "No Password Found"
            }
    }

}