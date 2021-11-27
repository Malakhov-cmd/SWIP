package com.example.swip.controller

import com.example.swip.repo.*
import com.example.swip.service.FirstChapterProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/java/firstchapter/")
class FirstChapterController(
        @Autowired
        var firstChapterProcessor: FirstChapterProcessor
) {
    @GetMapping()
    fun answersFirstChapter(@RequestParam(required = true) numberTheme: Int,
                            @RequestParam(required = true) answer: String,
                            @RequestParam(required = true) userId: String): String = firstChapterProcessor.firstChapterAnswers(numberTheme, answer, userId)
}