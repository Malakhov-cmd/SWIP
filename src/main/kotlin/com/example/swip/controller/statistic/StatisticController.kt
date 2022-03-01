package com.example.swip.controller.statistic

import com.example.swip.service.statistic.DTO.ChapterPercentCorrectly
import com.example.swip.service.statistic.StatisticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java/statistic/")
class StatisticController(
        @Autowired
        var statisticService: StatisticService
) {
    @GetMapping()
    fun answersTenhthChapter(
            @RequestParam(required = true) userId: String,
    ): List<ChapterPercentCorrectly> = statisticService.getChapterPercentCorrectly(userId)
}