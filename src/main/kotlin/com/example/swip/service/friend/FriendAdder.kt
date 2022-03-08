package com.example.swip.service.friend

import com.example.swip.domain.user.User
import com.example.swip.domain.user.typeOfFriends.Friend
import com.example.swip.repo.FriendRepo
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FriendAdder(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var friendRepo: FriendRepo
) {
    fun friendAdd(userId: String, potentialFriendId: String): User {
        val user = userDetailsRepo.findById(userId).get()
        val friend = userDetailsRepo.findById(potentialFriendId)

        try {
            friend.get()
        } catch (e:NoSuchElementException) {
            return user
        }

        //проверка на добавления самого себя
        if (isExecutableSituation(user, friend.get())) {
            return user
        }

        //человек уже во входящих заявках
        if (alreadyInIncoming(user, potentialFriendId)) {
            return isInIncomingOperation(user, friend.get())
        }

        return defaultOperationOperation(user, friend.get())
    }

    fun friendAddFromIncomes(userId: String, potentialFriendId: String): User {
        val user = userDetailsRepo.findById(userId).get()
        val friend = userDetailsRepo.findById(potentialFriendId)

        try {
            friend.get()
        } catch (e:NoSuchElementException) {
            return user
        }

        if (isExecutableSituation(user, friend.get())) {
            return user
        }

        deleteFriendFromIncoming(potentialFriendId, user)
        deleteFromOutgoing(userId, friend.get())

        return addFriendsFromIncome(user, friend.get())
    }

    private fun isExecutableSituation(
            user: User, friend: User
    ): Boolean {
        return friend.id == user.id
                || alreadyInFriend(user, friend.id)
                || alreadyInOutgoing(user, friend.id)
    }

    private fun alreadyInFriend(
            user: User, friendId: String
    ) = user.friendList.stream().anyMatch {
        it.friendId == friendId
    }

    private fun alreadyInOutgoing(
            user: User, friendId: String
    ) = user.friendOutgoingRequestList.stream().anyMatch {
        it.friendId == friendId
    }

    private fun alreadyInIncoming(
            user: User, friendId: String
    ) = user.friendIncomingRequestList.stream().anyMatch {
        it.friendId == friendId
    }

    private fun isInIncomingOperation(user: User, friend: User): User {

        user.friendList.add(createFriendEntities(user, friend))

        deleteFriendFromIncoming(friend.id, user)
        deleteFromOutgoing(user.id ,friend)

        friend.friendList.add(createFriendEntities(friend, user))

        saveEntities(user, friend)

        return user
    }

    private fun defaultOperationOperation(
            user: User, friend: User
    ): User {
        user.friendOutgoingRequestList.add(createFriendEntities(user, friend))
        friend.friendIncomingRequestList.add(createFriendEntities(friend, user))

        saveEntities(user, friend)

        return user
    }

    private fun saveEntities(user: User, friend: User) {
        userDetailsRepo.save(user)
        userDetailsRepo.save(friend)
    }

    private fun createFriendEntities(
            owner: User, friend: User
    ): Friend {
        val newFriend = Friend()

        newFriend.friendId = friend.id
        newFriend.friendname = friend.name
        newFriend.friendemail = friend.email
        newFriend.friendlocale = friend.locale
        newFriend.frienduserpic = friend.userpic

        newFriend.usrOwner = owner

        return friendRepo.save(newFriend)
    }

    private fun deleteFriendFromIncoming(
            friendId: String, user: User){
        user.friendIncomingRequestList.removeIf {
            it.friendId == friendId
        }
    }

    private fun deleteFromOutgoing(
            friendId: String, user: User
    ) {
        user.friendOutgoingRequestList.removeIf {
            it.friendId == friendId
        }
    }

    private fun addFriendsFromIncome(
            user: User, friend: User
    ): User {
        user.friendList.add(createFriendEntities(user, friend))
        friend.friendList.add(createFriendEntities(friend, user))

        saveEntities(user, friend)

        return user
    }
}