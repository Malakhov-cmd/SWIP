package com.example.swip.controller.wall

import com.example.swip.service.postCreation.like.PostLike
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home/post/like")
class PostLikeController(
        @Autowired
        var likeService: PostLike
) {
    @GetMapping
    fun postCreate(
            @RequestParam(required = true) postId: Long,
            @RequestParam(required = true) likerId: String,
    ) = likeService.likePost(postId, likerId)
}