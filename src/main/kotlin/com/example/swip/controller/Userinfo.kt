package com.example.swip.controller

import com.example.swip.repo.JavaLanguagesRepo
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/userinfo")
class Userinfo(
        @Autowired
        var userDetailsRepo: UserDetailsRepo
) {
    @GetMapping()
    fun addFriend(
            @RequestParam(required = true) userId: String
    ) = userDetailsRepo.findById(userId)
}