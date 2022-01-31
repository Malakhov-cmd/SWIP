package com.example.swip.service.postCreation

import com.example.swip.domain.postBoard.Comment
import com.example.swip.domain.postBoard.Post
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.postBoard.CommentRepo
import com.example.swip.repo.postBoard.PostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommentCreation(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var postRepo: PostRepo,
        @Autowired
        var commentRepo: CommentRepo
) {
    fun createComment(
            authorId: String,
            postId: Long,
            text: String
    ): Post {
        val post = postRepo.findById(postId).get()

        val author = userDetailsRepo.findById(authorId).get()

        val comment = Comment()

        comment.post = post
        comment.author = author.name!!
        comment.authorImg = author.userpic!!
        comment.authorId = authorId
        comment.text = text
        comment.commentDate = LocalDateTime.now()

        commentRepo.save(comment)

        post.comments.add(comment)

        postRepo.save(post)

        post.comments.sortByDescending {
            it.id
        }

        return post
    }
}