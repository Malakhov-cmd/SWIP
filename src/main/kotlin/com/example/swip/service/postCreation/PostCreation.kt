package com.example.swip.service.postCreation

import com.example.swip.domain.postBoard.HomeWall
import com.example.swip.domain.postBoard.Post
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.postBoard.HomeWallRepo
import com.example.swip.repo.postBoard.PostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PostCreation(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var homeWallRepo: HomeWallRepo,
        @Autowired
        var postRepo: PostRepo
) {
    fun createPost(
            wallId: Long,
            authorId: String,
            header: String,
            text: String
    ): HomeWall {
        val author = userDetailsRepo.findById(authorId).get()
        val wall = homeWallRepo.findById(wallId).get()

        val newPost = Post()
        newPost.wall = wall
        newPost.authorId = authorId
        newPost.author = author.name!!
        newPost.authorImg = author.userpic!!
        newPost.header = header
        newPost.text = text

        newPost.postDate = LocalDateTime.now()

        postRepo.save(newPost)

        wall.posts.add(newPost)
        homeWallRepo.save(wall)

        wall.posts.sortByDescending { it.postDate }

        return wall
    }
}