package com.example.swip.controller.chapterController

import com.example.swip.service.chapters.FifthChapterProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java/fifthchapter/")
class FifthChapterController(
        @Autowired
        var fifthChapterProcessor: FifthChapterProcessor
) {
    @GetMapping()
    fun answersFifthChapter(
            @RequestParam(required = true) numberTheme: Int,
            @RequestParam(required = true) answer: String,
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) timeSpend: Int
    ): String = fifthChapterProcessor.fifthChapterAnswers(numberTheme, answer, userId,timeSpend)

}