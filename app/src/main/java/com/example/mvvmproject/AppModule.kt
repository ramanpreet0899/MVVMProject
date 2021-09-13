package com.example.mvvmproject

import android.app.*
import com.example.mvvmproject.db.*
import com.example.mvvmproject.service.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.components.*
import retrofit2.*
import retrofit2.converter.gson.*
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    @Singleton
    @Provides
    fun getServiceInstance(retrofit: Retrofit) : UserService{
        return  retrofit.create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun getRetroInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getAppDb(context: Application): AppDatabase {
        return AppDatabase.getDatabaseInstance(context)
    }

    @Singleton
    @Provides
    fun getUserDao(appDb: AppDatabase): UserDao {
        return appDb.getDao()
    }

    @Singleton
    @Provides
    fun provideUserRepository(service: UserService, dao: UserDao) = UserRepository(service,dao)
}