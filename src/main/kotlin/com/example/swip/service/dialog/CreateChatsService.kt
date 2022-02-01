package com.example.swip.service.dialog

import com.example.swip.domain.dialog.Dialog
import com.example.swip.domain.dialog.Member
import com.example.swip.domain.user.User
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.dialog.DialogRepo
import com.example.swip.repo.dialog.MemberRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateChatsService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var dialogRepo: DialogRepo,
        @Autowired
        var memberRepo: MemberRepo
) {
    private val userIdRegex = """\d*""".toRegex()

    fun createChat(userId: String, members: String): User {
        val sortedMembers = clearDuplicates(parser(members))
        sortedMembers.add(userId)

        operateCreateDialog(sortedMembers)

        return userDetailsRepo.findById(userId).get()
    }

    private fun parser(members: String): MutableList<String> {
        val membersList = mutableListOf<String>()

        if (members.contains(',')) {
           membersList.addAll( userIdRegex.split(","))
        }

        membersList.add(members)
        return membersList
    }

    private fun clearDuplicates(members: MutableList<String>): MutableList<String> {
        val setList: MutableSet<String> = members.toMutableSet()
        return setList.toMutableList()
    }

    private fun operateCreateDialog(members: MutableList<String>) {
        val dialog = dialogRepo.save(Dialog())

        members.forEach {
            val user = userDetailsRepo.findById(it).get()

            val member = Member()

            member.usr = user
            member.memberId = user.id
            member.membername = user.name
            member.memberuserpic = user.userpic
            member.memberemail = user.email
            member.memberlocale = user.locale

            member.dialog = dialog

            memberRepo.save(member)

            dialog.members.add(member)
        }

        dialogRepo.save(dialog)

        members.forEach {
            val user = userDetailsRepo.findById(it).get()
            user.dialogList.add(dialog)

            userDetailsRepo.save(user)
        }
    }
}