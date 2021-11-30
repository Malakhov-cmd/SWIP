package com.example.swip.controller

import com.example.swip.service.SecondChapter.SecondChapterProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java/secondchapter/")
class SecondChapterController(
        @Autowired
        var secondChapterProcessor: SecondChapterProcessor
) {
    @GetMapping()
    fun answersSecondChapter(
            @RequestParam(required = true) numberTheme: Int,
            @RequestParam(required = true) answer: String,
            @RequestParam(required = true) userId: String
    ): String = secondChapterProcessor.secondChapterAnswers(numberTheme, answer, userId)
}