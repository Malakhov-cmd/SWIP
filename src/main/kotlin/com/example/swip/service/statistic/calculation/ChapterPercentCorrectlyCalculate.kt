package com.example.swip.service.statistic.calculation

import com.example.swip.domain.Chapter
import com.example.swip.service.statistic.DTO.ChapterPercentCorrectly

class ChapterPercentCorrectlyCalculate {
    fun createChapterPercentDTO(chapter: Chapter): ChapterPercentCorrectly {
        var totalTryCount = 0.0
        var finishedTheme = 0

        chapter.listThemes.forEach {
            if (it.isFinished) {
                totalTryCount += it.task!!.tryCount
                finishedTheme++
            }
        }

        val newChapterPercentCorrectly = ChapterPercentCorrectly()
        newChapterPercentCorrectly.chapterNumber = chapter.numberChapter!!
        newChapterPercentCorrectly.percentCorrectly = getCalculatedPercent(totalTryCount, finishedTheme)

        return newChapterPercentCorrectly
    }

    private fun getCalculatedPercent(totalTryCount: Double, finishedTheme: Int): Double {
        return if (totalTryCount == 0.0) 0.0
        else String
                .format("%.2f", ((finishedTheme / totalTryCount) * 100.0))
                .replace(',', '.')
                .toDouble()
    }
}