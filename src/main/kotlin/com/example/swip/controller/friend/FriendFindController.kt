package com.example.swip.controller.friend

import com.example.swip.service.friend.FriendFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home/friend/find")
class FriendFindController(
        @Autowired
        var friendFinder: FriendFinder
) {
    @GetMapping("/name")
    fun findByName(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendName: String
    ) = friendFinder.findUserByName(userId, friendName)

    @GetMapping("/id")
    fun findBIdy(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) friendId: String
    ) = friendFinder.findUserById(userId, friendId)
}