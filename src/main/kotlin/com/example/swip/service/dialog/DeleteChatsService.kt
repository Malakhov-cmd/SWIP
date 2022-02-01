package com.example.swip.service.dialog

import com.example.swip.domain.user.User
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.dialog.DialogRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeleteChatsService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var dialogRepo: DialogRepo,
) {
    fun deleteChat(userId: String, dialogId: Long): User {
        val dialog = dialogRepo.findById(dialogId).get()

        dialog.members.forEach { member ->
            val user = userDetailsRepo.findById(member.memberId).get()
            user.dialogList.removeIf {
                it.id == dialogId
            }

            userDetailsRepo.save(user)
        }

        return userDetailsRepo.findById(userId).get()
    }
}