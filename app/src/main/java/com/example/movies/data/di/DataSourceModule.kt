package com.example.movies.data.di

import com.example.movies.data.datasource.cache.CacheDataSource
import com.example.movies.data.datasource.cache.impl.CacheDataSourceImpl
import com.example.movies.data.datasource.local.DataBaseDataSource
import com.example.movies.data.datasource.local.impl.DataBaseDataSourceImpl
import com.example.movies.data.datasource.remote.RemoteDataSource
import com.example.movies.data.datasource.remote.impl.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindCacheDataSource(cacheDataSourceImpl: CacheDataSourceImpl): CacheDataSource


    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindDataBaseDataSource(dataBaseDataSourceImpl: DataBaseDataSourceImpl): DataBaseDataSource

}