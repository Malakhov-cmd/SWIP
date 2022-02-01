package com.example.swip.controller.dialog

import com.example.swip.service.dialog.UserFindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dialog/find")
class FindUsersController(
        @Autowired
        var userFindService: UserFindService
) {
        @GetMapping("/name")
        fun findByName(
                @RequestParam(required = true) userId: String,
                @RequestParam(required = true) friendName: String
        ) = userFindService.findUserByName(userId, friendName)

        @GetMapping("/id")
        fun findBIdy(
                @RequestParam(required = true) userId: String,
                @RequestParam(required = true) friendId: String
        ) = userFindService.findUserById(userId, friendId)
}