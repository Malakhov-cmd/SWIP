package com.example.swip.service.postCreation.like

import com.example.swip.domain.postBoard.like.LikePost
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.postBoard.PostRepo
import com.example.swip.repo.postBoard.like.LikePostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostLike(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var postRepo: PostRepo,
        @Autowired
        var likePostRepo: LikePostRepo
) {
    fun likePost(
            postId: Long, likerId: String
    ): MutableList<LikePost> {
        val liker = userDetailsRepo.findById(likerId).get()
        val post = postRepo.findById(postId).get()

        if(post.likes.stream().filter {
           (it.liker == liker.id)
        }.count() == 0L) {
            val like = LikePost()
            like.post = post
            like.liker = likerId

            likePostRepo.save(like)

            post.likes.add(like)
            postRepo.save(post)
        } else {
            post.likes.removeIf { el -> el.liker == likerId }
            postRepo.save(post)
        }

        return post.likes
    }
}