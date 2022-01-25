package com.example.swip.controller.wall

import com.example.swip.service.postCreation.PostCreation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home/post/creation")
class PostCreationController(
        @Autowired
        var postCreation: PostCreation
) {
    @GetMapping
    fun postCreate(
            @RequestParam(required = true) wallId: Long,
            @RequestParam(required = true) authorId: String,
            @RequestParam(required = true) header: String,
            @RequestParam(required = true) text: String
    ) = postCreation.createPost(wallId, authorId, header, text)
}