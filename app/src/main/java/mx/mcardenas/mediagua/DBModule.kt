package mx.mcardenas.mediagua

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ActivityContext

@Module
object DBModule {
    @Provides
    fun provideMediaguaDB(@ActivityContext context: Context): MediaguaDB {
        return Room.databaseBuilder(context, MediaguaDB::class.java, "mediagua").build()
    }
}