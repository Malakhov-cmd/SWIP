package com.example.swip.service.statistic.calculation

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage

class ChapterPercentProgressCalculate {
    fun calculatePercentOfFinishedThemes(chapter: Chapter): Double {
        val totalThemeCount = chapter.listThemes.size
        var actualFinished = 0.0

        chapter.listThemes.forEach { theme ->
            if (theme.isFinished)
                actualFinished++
        }

        return getCalculatedPercent(totalThemeCount, actualFinished)
    }

    private fun getCalculatedPercent(totalThemeCount: Int, finishedTheme: Double): Double {
        return if (finishedTheme == 0.0) 0.0
        else String
                .format("%.2f", ((finishedTheme / totalThemeCount) * 100.0))
                .replace(',', '.')
                .toDouble()
    }

    fun getAbsoluteCompletePercent(language: JavaLanguage): Double {
        var totalFinished = 0.0
        var totalCountTheme = 0

        language.chapters.stream().forEach { chapter ->
            chapter.listThemes.forEach { theme ->
                totalCountTheme++
                if (theme.isFinished)
                    totalFinished++
            }
        }

        return getCalculatedPercent(totalCountTheme, totalFinished)
    }
}