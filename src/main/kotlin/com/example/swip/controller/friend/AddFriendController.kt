package com.example.swip.controller.friend

import com.example.swip.service.friend.FriendAdder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home/friend/add")
class AddFriendController(
        @Autowired
        var friendAdder: FriendAdder
) {
    @GetMapping
    fun addFriend(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendId: String
    ) = friendAdder.friendAdd(userId, friendId)

    @GetMapping("/incomes")
    fun addFriendIncomes(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendId: String
    ) = friendAdder.friendAddFromIncomes(userId, friendId)
}