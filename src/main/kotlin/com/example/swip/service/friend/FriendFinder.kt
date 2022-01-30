package com.example.swip.service.friend

import com.example.swip.domain.user.User
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FriendFinder(
        @Autowired
        var userDetailsRepo: UserDetailsRepo
) {
    fun findUserByName(friendName: String): MutableList<User> {
        return userDetailsRepo.findByName(friendName)
    }

    fun findUserById(friendId: String): Optional<User> {
        return userDetailsRepo.findById(friendId)
    }
}