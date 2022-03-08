package com.example.swip.service.friend

import com.example.swip.domain.user.User
import com.example.swip.repo.FriendRepo
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeleteFriend(
        @Autowired
        var userDetailsRepo: UserDetailsRepo
) {
    fun deleteOutgoing(userId: String, friendToRemoveFromOutgoing: String): User {
        var user = userDetailsRepo.findById(userId).get()
        val friend = userDetailsRepo.findById(friendToRemoveFromOutgoing)

        friend.ifPresent {
            user = operateRemove(user, friend.get())
        }

        return user
    }

    fun deleteFromIncomes(userId: String, friendToRemoveFromOutgoing: String): User {
        var user = userDetailsRepo.findById(userId).get()
        val friend = userDetailsRepo.findById(friendToRemoveFromOutgoing)

        friend.ifPresent {
            user = operateRemove(user, friend.get())
        }

        return operateRemoveIncomes(user, friend.get())
    }

    fun deleteFromFriendList(userId: String, friendToRemoveFromOutgoing: String): User {
        var user = userDetailsRepo.findById(userId).get()
        val friend = userDetailsRepo.findById(friendToRemoveFromOutgoing)

        friend.ifPresent {
            user = operateRemoveFriendFromFriendList(user, friend.get())
        }

        return user
    }

    private fun operateRemove(
            user: User, friend: User
    ): User {
        user.friendOutgoingRequestList.removeIf {
            it.friendId == friend.id
        }

        friend.friendIncomingRequestList.removeIf {
            it.friendId == user.id
        }

        saveEntities(user, friend)

        return user
    }

    private fun saveEntities(user: User, friend: User) {
        userDetailsRepo.save(user)
        userDetailsRepo.save(friend)
    }

    private fun operateRemoveIncomes(
            user: User, friend: User
    ): User {
        user.friendIncomingRequestList.removeIf {
            it.friendId == friend.id
        }

        friend.friendOutgoingRequestList.removeIf {
            it.friendId == user.id
        }

        saveEntities(user, friend)

        return user
    }

    private fun operateRemoveFriendFromFriendList(
            user: User, friend: User
    ): User {
        user.friendList.removeIf {
            it.friendId == friend.id
        }

        friend.friendList.removeIf {
            it.friendId == user.id
        }

        saveEntities(user, friend)

        return user
    }
}