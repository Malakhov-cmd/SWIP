package com.example.swip.controller

import com.example.swip.repo.UserDetailsRepo
import com.example.swip.service.api.WallService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/userinfo")
class Userinfo(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var homeWallService: WallService
) {
    @GetMapping()
    fun addFriend(
            @RequestParam(required = true) userId: String
    ) = userDetailsRepo.findById(userId)

    @GetMapping("/wall")
    fun getWallByAuthor(
            @RequestParam(required = true) userId: String
    ) = homeWallService.getSortedWall(userId)
}