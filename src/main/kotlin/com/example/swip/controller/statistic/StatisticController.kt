package com.example.swip.controller.statistic

import com.example.swip.service.statistic.DTO.ChapterFullTimeSolution
import com.example.swip.service.statistic.DTO.ChapterPercentCorrectly
import com.example.swip.service.statistic.DTO.ChapterRealTryCountThemeRealCountDTO
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
    @GetMapping("/percentCorrectly")
    fun chapterPercentCorrectly(
            @RequestParam(required = true) userId: String,
    ): List<ChapterPercentCorrectly> = statisticService.getChapterPercentCorrectly(userId)

    @GetMapping("/tryCountPerThemeNumber")
    fun chapterRealTryCountPerThemeCount(
            @RequestParam(required = true) userId: String,
    ): List<ChapterRealTryCountThemeRealCountDTO> = statisticService.getChapterRealTryCountPerThemeCount(userId)

    @GetMapping("/timeOnChapter")
    fun chapterFullTimeSolution(
            @RequestParam(required = true) userId: String,
    ): List<ChapterFullTimeSolution> = statisticService.getChapterFullTimeSolution(userId)

    @GetMapping("/avaragePercentCorrectly")
    fun averagePercentCorrectly(
            @RequestParam(required = true) userId: String,
    ): List<Double> = statisticService.averagePercentCorrectly(userId)

    @GetMapping("/avarageTimeOnSolution")
    fun avarageTimeOnSolution(
            @RequestParam(required = true) userId: String,
    ): List<Double> = statisticService.averageTimeOnSolution(userId)

    @GetMapping("/percentOfEndinOfChapter")
    fun percentOfEndinOfChapter(
            @RequestParam(required = true) userId: String,
    ): List<Double> = statisticService.percentOfEndingOfChapter(userId)
}