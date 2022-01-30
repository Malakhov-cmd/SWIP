package com.example.swip.controller.friend

import com.example.swip.service.friend.DeleteFriend
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home/friend/delete")
class DeleteFriendController(
        @Autowired
        val deleteFriend: DeleteFriend
) {
    @GetMapping
    fun deleteFriend(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendId: String
    ) = deleteFriend.deleteOutgoing(userId, friendId)

    @GetMapping("/from/incomes")
    fun deleteFriendFromIncomes(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendId: String
    ) = deleteFriend.deleteFromIncomes(userId, friendId)

    @GetMapping("/from/friendlist")
    fun deleteFriendFromFriendList(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendId: String
    ) = deleteFriend.deleteFromFriendList(userId, friendId)
}