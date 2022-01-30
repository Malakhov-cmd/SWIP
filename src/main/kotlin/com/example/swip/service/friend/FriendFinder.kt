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
    fun findUserByName(
            userId: String,
            friendName: String
    ) = sorterPotentialFriend(userId, userDetailsRepo.findByName(friendName))


    fun findUserById(
            userId: String,
            friendId: String
    ) = sortById(userId, friendId)


    private fun sorterPotentialFriend(
            userId: String,
            potentialFriends: MutableList<User>
    ): MutableList<User> {
        potentialFriends.removeIf {
            it.id == userId
        }

        val user = userDetailsRepo.findById(userId).get()

        user.friendList.stream().forEach { friend ->
            potentialFriends.removeIf {
                it.id == friend.friendId
            }
        }

        user.friendIncomingRequestList.stream().forEach { income ->
            potentialFriends.removeIf {
                it.id == income.friendId
            }
        }

        user.friendOutgoingRequestList.stream().forEach { outgo ->
            potentialFriends.removeIf {
                it.id == outgo.friendId
            }
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