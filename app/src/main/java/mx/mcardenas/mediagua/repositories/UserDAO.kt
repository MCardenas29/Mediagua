package mx.mcardenas.mediagua.repositories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import mx.mcardenas.mediagua.models.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE email = :mail")
    fun getByMail(mail: String): User

    @Query("SELECT count(id) FROM user")
    fun countUsers(): LiveData<Int>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}