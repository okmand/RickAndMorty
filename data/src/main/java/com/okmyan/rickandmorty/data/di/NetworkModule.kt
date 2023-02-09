package com.okmyan.rickandmorty.data.di

import android.app.Application
import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.okmyan.rickandmorty.core.scopes.AppScope
import com.okmyan.rickandmorty.data.constants.HttpAttributes.Companion.BASE_URL
import com.okmyan.rickandmorty.data.constants.HttpAttributes.Companion.CONTENT_TYPE
import com.okmyan.rickandmorty.data.interceptors.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun provideNetworkConnectionInterceptor(application: Application): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(application)
    }

    @AppScope
    @Provides
    fun provideOkHttp(interceptor: NetworkConnectionInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @AppScope
    @Provides
    fun provideConverterFactory(): Converter.Factory {
        val contentType = CONTENT_TYPE.toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        return json.asConverterFactory(contentType)
    }

    @AppScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, factory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(factory)
            .client(okHttpClient)
            .build()
    }

}
