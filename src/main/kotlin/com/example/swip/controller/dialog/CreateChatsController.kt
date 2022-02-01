package com.example.swip.controller.dialog

import com.example.swip.service.dialog.CreateChatsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dialog/create")
class CreateChatsController(
        @Autowired
        var createChatsService: CreateChatsService
) {
    @GetMapping()
    fun createChat(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) members: String
    ) = createChatsService.createChat(userId, members)
}