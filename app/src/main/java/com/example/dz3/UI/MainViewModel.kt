package com.example.dz3.UI

import androidx.lifecycle.ViewModel
import com.example.dz3.businesslayer.FriendProvider
import com.example.dz3.datalayer.IAccessor




class MainViewModel : ViewModel() {
    private val accessor = IAccessor.create()
    private val provider = FriendProvider(accessor)

    suspend fun getFriends() = provider.getFriends(100)
    suspend fun getFriend(id:String)=provider.getFriend(id)
}