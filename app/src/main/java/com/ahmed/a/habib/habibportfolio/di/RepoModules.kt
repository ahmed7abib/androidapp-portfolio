package com.ahmed.a.habib.habibportfolio.di

import com.ahmed.a.habib.habibportfolio.data.CvDataRepoImpl
import com.ahmed.a.habib.habibportfolio.domain.CvDataRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModules {

    @Provides
    @Singleton
    fun provideCvDataRepo(): CvDataRepo {
        return CvDataRepoImpl()
    }
}