package com.example.swip.controller.wall

import com.example.swip.service.postCreation.CommentCreation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home/comment/creation")
class CommentCreationController(
        @Autowired
        var commentCreation: CommentCreation
) {
    @GetMapping
    fun commentCreate(
            @RequestParam(required = true) authorId: String,
            @RequestParam(required = true) postId: Long,
            @RequestParam(required = true) text: String
    ) = commentCreation.createComment(authorId, postId, text)
}