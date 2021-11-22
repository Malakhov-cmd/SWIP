package com.example.swip.controller

import com.example.swip.repo.JavaLanguagesRepo
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/api/userinfo")
class Userinfo(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var javaLanguagesRepo: JavaLanguagesRepo
) {
    @GetMapping()
    fun getInfo(userId: String) = javaLanguagesRepo.findByOwner(userDetailsRepo.findById(userId).get())
}