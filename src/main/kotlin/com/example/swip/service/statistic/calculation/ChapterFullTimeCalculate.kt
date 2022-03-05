package com.example.swip.service.statistic.calculation

import com.example.swip.domain.Chapter
import com.example.swip.service.statistic.DTO.ChapterFullTimeSolution

class ChapterFullTimeCalculate {
    fun createChapterFullTimeDTO(chapter: Chapter): ChapterFullTimeSolution {
        var totalTimeSpend = 0

        chapter.listThemes.forEach {
            if (it.isFinished) {
                totalTimeSpend += it.task!!.timeOnSolutionInSeconds
            }
        }

        val chapterFullTimeSolution = ChapterFullTimeSolution()
        chapterFullTimeSolution.chapterNumber = chapter.numberChapter!!
        chapterFullTimeSolution.chapterTimeSpend = totalTimeSpend

        return chapterFullTimeSolution
    }
}