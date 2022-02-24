package com.example.swip.controller.chapterController

import com.example.swip.service.chapters.EighthChapterProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java/eighthchapter/")
class EighthChapterController(
        @Autowired
        var eighthChapterProcessor: EighthChapterProcessor
) {
    @GetMapping()
    fun answersEighthChapter(
            @RequestParam(required = true) numberTheme: Int,
            @RequestParam(required = true) answer: String,
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) timeSpend: Int
    ): String = eighthChapterProcessor.eighthChapterAnswers(numberTheme, answer, userId,timeSpend)
}