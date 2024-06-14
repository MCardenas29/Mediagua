package mx.mcardenas.mediagua

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.mcardenas.mediagua.models.User
import mx.mcardenas.mediagua.repositories.UserDao

@Database(entities = [User::class], version = 1)
abstract class MediaguaDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}