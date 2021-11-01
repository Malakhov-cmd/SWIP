package com.example.swip.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/api/userinfo")
class Userinfo {
    @GetMapping()
    fun getInfo(principal: Principal): Principal {
        return principal
    }
}