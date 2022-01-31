package com.example.swip.controller

import com.example.swip.repo.JavaLanguagesRepo
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.postBoard.HomeWallRepo
import com.example.swip.service.api.WallService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.security.Principal

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