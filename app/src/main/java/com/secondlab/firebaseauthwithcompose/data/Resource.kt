package com.secondlab.firebaseauthwithcompose.data

sealed class Resource<out R> {
    data class Success<out R>(val results: R) : Resource<R>()
    data class Failure(val exception: Exception) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}
