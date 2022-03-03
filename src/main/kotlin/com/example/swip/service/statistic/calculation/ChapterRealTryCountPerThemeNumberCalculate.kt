package com.example.swip.service.statistic.calculation

import com.example.swip.domain.Chapter
import com.example.swip.service.statistic.DTO.ChapterRealTryCountThemeRealCountDTO

class ChapterRealTryCountPerThemeNumberCalculate {
    fun createChapterRealTryCountPerThemeNumberDTO(chapter: Chapter): ChapterRealTryCountThemeRealCountDTO {
        var totalTryCount = 0
        var finishedTheme = 0

        chapter.listThemes.forEach {
            if (it.isFinished) {
                totalTryCount += it.task!!.tryCount
                finishedTheme++
            }
        }

        val newRealTryCountPerThemeNumber = ChapterRealTryCountThemeRealCountDTO()
        newRealTryCountPerThemeNumber.chapterNumber = chapter.numberChapter!!
        newRealTryCountPerThemeNumber.chapterRealTryCount = totalTryCount
        newRealTryCountPerThemeNumber.chapterRealThemeCount = finishedTheme

        return newRealTryCountPerThemeNumber
    }
}