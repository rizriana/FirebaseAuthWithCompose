package com.secondlab.firebaseauthwithcompose.di

import com.google.firebase.auth.FirebaseAuth
import com.secondlab.firebaseauthwithcompose.data.AuthRepository
import com.secondlab.firebaseauthwithcompose.data.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}