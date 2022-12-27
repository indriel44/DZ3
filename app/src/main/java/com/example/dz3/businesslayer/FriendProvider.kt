package com.example.dz3.businesslayer

import com.example.dz3.datalayer.IAccessor
import com.example.dz3.objects.Friend

class FriendProvider(private val accessor: IAccessor) {

    suspend fun getFriends(limit: Int): List<Friend> {
        return accessor.getFriends(limit)
    }

    suspend fun getFriend(id: String): List<Friend> {
        //Log.d("TEST", accessor.getBeer(id).Id())
        return accessor.getFriend(id)
    }
}