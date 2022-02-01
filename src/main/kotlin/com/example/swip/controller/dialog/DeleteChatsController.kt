package com.example.swip.controller.dialog

import com.example.swip.service.dialog.DeleteChatsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dialog/delete")
class DeleteChatsController(
        @Autowired
        var deleteChatsService: DeleteChatsService
) {
    @GetMapping()
    fun deleteChat(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) dialogId: Long
    ) = deleteChatsService.deleteChat(userId, dialogId)
}