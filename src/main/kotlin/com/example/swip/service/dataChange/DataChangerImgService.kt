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
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.stereotype.Service

@Service
class DataChangerImgService(
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
    private val regexToImage = """(https?:\/\/)?([\da-z.-]+)\.([a-z.]{2,6})([\/\w .-]*)*\.(jpg|jpeg|png|gif|svg|JPG|PNG|JPEG|GIF|SVG)\/?""".toRegex()

    fun changeImg(userId: String, newIngLink: String): User {
        val user = userDetailsRepo.findById(userId).get()

        if (regexToImage.matches(newIngLink)){
            user.userpic = newIngLink

            changeImgInDialogLists(user, newIngLink)
            changeImgInFriendsLists(user, newIngLink)
            changeImgInWallPosts(user, newIngLink)

            return userDetailsRepo.save(user)
        }

        return user
    }

    private fun changeImgInDialogLists(user: User, newImg: String) {
        user.dialogList.stream().forEach { dialog ->
            dialog.members.forEach {
                if (it.memberId == user.id) {
                    it.memberuserpic = newImg
                    memberRepo.save(it)
                }
            }
            dialogRepo.save(dialog)
        }
    }

    private fun changeImgInFriendsLists(user: User, newImg: String) {
        changeImgInFriendList(user, newImg)
        changeImgInIncomesRequest(user, newImg)
        changeImgInOutgoingRequest(user, newImg)
    }

    private fun changeImgInWallPosts(user: User, newImg: String) {
        val walls = homeWallRepo.findAll()

        walls.stream().forEach { wall ->
            wall.posts.forEach { post ->
                if (post.authorId == user.id) {
                    post.authorImg = newImg
                    postRepo.save(post)
                }
                post.comments.stream().forEach { comment ->
                    if (comment.authorId == user.id) {
                        comment.authorImg = newImg
                        commentRepo.save(comment)
                    }
                }
                postRepo.save(post)
            }
            homeWallRepo.save(wall)
        }
    }

    private fun changeImgInFriendList(user: User, newImg: String) {
        user.friendList.forEach { friendInMyList ->
            val friend = userDetailsRepo.findById(friendInMyList.friendId).get()
            friend.friendList.stream().forEach {
                if (it.friendId == user.id) {
                    it.frienduserpic = newImg
                    friendRepo.save(it)
                }
            }
        }
    }

    private fun changeImgInIncomesRequest(user: User, newImg: String) {
        user.friendIncomingRequestList.forEach { friendIncomingMyList ->
            val friendIncoming = userDetailsRepo.findById(friendIncomingMyList.friendId).get()
            friendIncoming.friendOutgoingRequestList.stream().forEach {
                if (it.friendId == user.id) {
                    it.frienduserpic = newImg
                    friendRepo.save(it)
                }
            }
        }
    }

    private fun changeImgInOutgoingRequest(user: User, newImg: String) {
        user.friendOutgoingRequestList.forEach { friendOutgoingMyList ->
            val friendIncoming = userDetailsRepo.findById(friendOutgoingMyList.friendId).get()
            friendIncoming.friendIncomingRequestList.stream().forEach {
                if (it.friendId == user.id) {
                    it.frienduserpic = newImg
                    friendRepo.save(it)
                }
            }
        }
    }
}