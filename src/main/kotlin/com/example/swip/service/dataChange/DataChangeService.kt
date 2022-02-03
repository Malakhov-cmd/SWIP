package com.example.swip.service.dataChange

import com.example.swip.domain.user.User
import com.example.swip.repo.FriendRepo
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.dialog.DialogRepo
import com.example.swip.repo.dialog.MemberRepo
import com.example.swip.repo.postBoard.CommentRepo
import com.example.swip.repo.postBoard.HomeWallRepo
import com.example.swip.repo.postBoard.PostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataChangeService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var dialogRepo: DialogRepo,
        @Autowired
        var memberRepo: MemberRepo,
        @Autowired
        var homeWallRepo: HomeWallRepo,
        @Autowired
        var postRepo: PostRepo,
        @Autowired
        var commentRepo: CommentRepo,
        @Autowired
        var friendRepo: FriendRepo
) {
    fun changeName(userId: String, newName: String): User {
        val user = userDetailsRepo.findById(userId).get()

        user.name = newName

        changeNameInDialogLists(user, newName)
        changeNameInFriendsLists(user, newName)
        changeNameInWallPosts(user, newName)

        return userDetailsRepo.save(user)
    }

    private fun changeNameInDialogLists(user: User, newName: String) {
        user.dialogList.stream().forEach { dialog ->
            dialog.members.forEach {
                if (it.memberId == user.id) {
                    it.membername = newName
                    memberRepo.save(it)
                }
            }
            dialogRepo.save(dialog)
        }
    }

    private fun changeNameInFriendsLists(user: User, newName: String) {
        changeNameInFriendList(user, newName)
        changeNameInIncomesRequest(user, newName)
        changeNameInOutgoingRequest(user, newName)
    }

    private fun changeNameInWallPosts(user: User, newName: String) {
        val walls = homeWallRepo.findAll()

        walls.stream().forEach { wall ->
            wall.posts.forEach { post ->
                if (post.authorId == user.id) {
                    post.author = newName
                    postRepo.save(post)
                }
                post.comments.stream().forEach { comment ->
                    if (comment.authorId == user.id) {
                        comment.author = newName
                        commentRepo.save(comment)
                    }
                }
                postRepo.save(post)
            }
            homeWallRepo.save(wall)
        }
    }

    private fun changeNameInFriendList(user: User, newName: String) {
        user.friendList.forEach { friendInMyList ->
            val friend = userDetailsRepo.findById(friendInMyList.friendId).get()
            friend.friendList.stream().forEach {
                if (it.friendId == user.id) {
                    it.friendname = newName
                    friendRepo.save(it)
                }
            }
        }
    }

    private fun changeNameInIncomesRequest(user: User, newName: String) {
        user.friendIncomingRequestList.forEach { friendIncomingMyList ->
            val friendIncoming = userDetailsRepo.findById(friendIncomingMyList.friendId).get()
            friendIncoming.friendOutgoingRequestList.stream().forEach {
                if (it.friendId == user.id) {
                    it.friendname = newName
                    friendRepo.save(it)
                }
            }
        }
    }

    private fun changeNameInOutgoingRequest(user: User, newName: String) {
        user.friendOutgoingRequestList.forEach { friendOutgoingMyList ->
            val friendIncoming = userDetailsRepo.findById(friendOutgoingMyList.friendId).get()
            friendIncoming.friendIncomingRequestList.stream().forEach {
                if (it.friendId == user.id) {
                    it.friendname = newName
                    friendRepo.save(it)
                }
            }
        }
    }
}