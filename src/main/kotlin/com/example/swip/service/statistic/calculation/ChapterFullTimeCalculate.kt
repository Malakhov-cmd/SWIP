package com.example.swip.service.statistic.calculation

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
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

    fun calculateTimeOnLanguageOfUser(language: JavaLanguage): MutableList<Int> {
        val timeOnChapterSpend: MutableList<Int> = mutableListOf()

        language.chapters.sortBy { item -> item.numberChapter }

        language.chapters.forEach { chapter ->
            if (ChapterFullTimeCalculate().isChapterAllThemeFinished(chapter)) {
                timeOnChapterSpend.add(calculateSumOfTimeSpendOnChapter(chapter))
            } else {
                timeOnChapterSpend.add(0)
            }
        }

        return timeOnChapterSpend
    }

    private fun calculateSumOfTimeSpendOnChapter(chapter: Chapter): Int {
        var totalTimeSpend = 0

        chapter.listThemes.forEach {
            totalTimeSpend += it.task!!.timeOnSolutionInSeconds
        }

        return totalTimeSpend
    }

    private fun isChapterAllThemeFinished(chapter: Chapter): Boolean {
        return chapter.listThemes
                .stream()
                .allMatch { it.isFinished }
    }
}