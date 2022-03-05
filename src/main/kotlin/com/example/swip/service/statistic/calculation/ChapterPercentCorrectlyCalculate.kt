package com.example.swip.service.statistic.calculation

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
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

    fun calculateAverageCorrectlyChapterOfOneUser(language: JavaLanguage): List<Double> {
        val averagePercentCorrectlyOfOneUser: MutableList<Double> = mutableListOf()

        language.chapters.sortBy { item -> item.numberChapter }

        language.chapters.stream().forEach { chapter ->
            var totalTryCount = 0.0
            var finishedTheme = 0

            chapter.listThemes.forEach { theme ->
                if (theme.isFinished) {
                    totalTryCount += theme.task!!.tryCount
                    finishedTheme++
                }
            }

            averagePercentCorrectlyOfOneUser.add(
                    getCalculatedPercent(totalTryCount, finishedTheme))
        }

        return averagePercentCorrectlyOfOneUser;
    }

    private fun getCalculatedPercent(totalTryCount: Double, finishedTheme: Int): Double {
        return if (totalTryCount == 0.0) 0.0
        else String
                .format("%.2f", ((finishedTheme / totalTryCount) * 100.0))
                .replace(',', '.')
                .toDouble()
    }
}