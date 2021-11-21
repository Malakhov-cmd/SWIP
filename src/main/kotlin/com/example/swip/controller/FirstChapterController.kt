package com.example.swip.controller

import com.example.swip.domain.Theme
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java/firstchapter/")
class FirstChapterController {
    @PostMapping("/")
    fun answersFirstChapter(@RequestParam(required = true) numberTheme: Int,
                            @RequestParam(required = true) answer: String): String {
        System.out.println("This is the answers + $numberTheme + $answer ")
        return "Слышу вас"
    }
}