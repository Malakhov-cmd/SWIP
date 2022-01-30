package com.example.swip.repo

import com.example.swip.domain.user.typeOfFriends.Friend
import org.springframework.data.jpa.repository.JpaRepository

interface FriendRepo: JpaRepository<Friend, Long> {
}