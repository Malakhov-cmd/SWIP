package com.example.swip.controller.chapterController

import com.example.swip.service.chapters.ElevenChapterProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java/elevenchapter/")
class ElevenChapterController(
        @Autowired
        var elevenChapterProcessor: ElevenChapterProcessor
) {
    @GetMapping()
    fun answersTenhthChapter(
            @RequestParam(required = true) numberTheme: Int,
            @RequestParam(required = true) answer: String,
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) timeSpend: Int
    ): String = elevenChapterProcessor.elevenChapterAnswers(numberTheme, answer, userId,timeSpend)
}