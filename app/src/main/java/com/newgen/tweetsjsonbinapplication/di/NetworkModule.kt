package com.newgen.tweetsjsonbinapplication.di

import com.newgen.tweetsjsonbinapplication.api.TweetsAPI
import com.newgen.tweetsjsonbinapplication.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getTweetsAPI(retrofit: Retrofit): TweetsAPI{
        return retrofit.create(TweetsAPI::class.java)
    }
}