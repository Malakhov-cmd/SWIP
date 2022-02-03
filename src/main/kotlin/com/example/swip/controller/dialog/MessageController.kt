package com.example.swip.controller.dialog

import com.example.swip.service.dataChange.DataChangerImgService
import com.example.swip.service.dialog.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dialog/send/message")
class MessageController(
        @Autowired
        var messageService: MessageService
) {
    @GetMapping()
    fun messageSend(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) dialogId: Long,
            @RequestParam(required = true) memberId: Long,
            @RequestParam(required = true) text: String
    ) = messageService.sendMessage(userId, dialogId, memberId, text)
}