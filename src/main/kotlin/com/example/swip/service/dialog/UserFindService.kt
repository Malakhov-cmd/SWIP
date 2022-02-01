package com.example.swip.service.dialog

import com.example.swip.domain.user.User
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserFindService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo
) {
    fun findUserByName(
            userId: String,
            friendName: String
    ) = sorterPotentialUserSearch(userId, userDetailsRepo.findByName(friendName))


    fun findUserById(
            userId: String,
            friendId: String
    ) = sortById(userId, friendId)


    private fun sorterPotentialUserSearch(
            userId: String,
            potentialFriends: MutableList<User>
    ): MutableList<User> {
        potentialFriends.removeIf {
            it.id == userId
        }

        return potentialFriends
    }

    private fun sortById(
            userId: String,
            friendId: String
    ): Optional<User>? {
        if (userId != friendId)
            return userDetailsRepo.findById(friendId)
        return null
    }
}