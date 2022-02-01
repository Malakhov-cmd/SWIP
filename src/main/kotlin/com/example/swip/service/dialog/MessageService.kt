package com.example.swip.service.dialog

import com.example.swip.domain.dialog.Message
import com.example.swip.domain.user.User
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.dialog.DialogRepo
import com.example.swip.repo.dialog.MemberRepo
import com.example.swip.repo.dialog.MessageRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MessageService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var dialogRepo: DialogRepo,
        @Autowired
        var memberRepo: MemberRepo,
        @Autowired
        var messageRepo: MessageRepo
) {
    fun sendMessage(userId: String, dialogId: Long, memberId: Long, text: String): User {
        val user = userDetailsRepo.findById(userId).get()
        val dialog = dialogRepo.findById(dialogId).get()
        val member = memberRepo.findById(memberId).get()

        val message = Message()
        message.dialog = dialog
        message.author = member
        message.text = text
        message.timeSent = LocalDateTime.now()

        messageRepo.save(message)

        dialog.messageList.add(message)

        dialogRepo.save(dialog)

        return user
    }
}