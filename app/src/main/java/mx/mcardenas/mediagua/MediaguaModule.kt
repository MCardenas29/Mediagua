package mx.mcardenas.mediagua

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaguaModule {
    @Provides
    @Singleton
    fun provideMediaguaDatabase(app: Application): MediaguaDatabase {
        return Room.databaseBuilder(app, MediaguaDatabase::class.java, "mediagua").build()
    }
}