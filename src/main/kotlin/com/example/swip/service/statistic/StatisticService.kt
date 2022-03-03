package com.example.swip.service.statistic

import com.example.swip.domain.Chapter
import com.example.swip.repo.*
import com.example.swip.service.statistic.DTO.ChapterFullTimeSolution
import com.example.swip.service.statistic.DTO.ChapterPercentCorrectly
import com.example.swip.service.statistic.DTO.ChapterRealTryCountThemeRealCountDTO
import com.example.swip.service.statistic.calculation.ChapterPercentCorrectlyCalculate
import com.example.swip.service.statistic.calculation.ChapterRealTryCountPerThemeNumberCalculate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StatisticService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var javaLanguagesRepo: JavaLanguagesRepo,
        @Autowired
        var chapterRepo: ChapterRepo,
        @Autowired
        var themeRepo: ThemeRepo,
        @Autowired
        var taskRepo: TaskRepo
) {
    fun getChapterPercentCorrectly(userId: String): List<ChapterPercentCorrectly> {
        val chapterPercentCorrectlyListDTO: MutableList<ChapterPercentCorrectly> = mutableListOf()

        val javaLanguageData = javaLanguagesRepo.findByOwner(
                userDetailsRepo.findById(userId).get()
        )

        javaLanguageData.chapters.stream().forEach {
            chapterPercentCorrectlyListDTO
                    .add(ChapterPercentCorrectlyCalculate().createChapterPercentDTO(it))
        }

        return chapterPercentCorrectlyListDTO
    }

    fun getChapterFullTimeSolution(userId: String): List<ChapterFullTimeSolution> {
        val chapterPercentCorrectlyListDTO: MutableList<ChapterFullTimeSolution> = mutableListOf()

        val javaLanguageData = javaLanguagesRepo.findByOwner(
                userDetailsRepo.findById(userId).get()
        )

        javaLanguageData.chapters.stream().forEach {
            chapterPercentCorrectlyListDTO.add(createChapterFullTimeDTO(it))
        }

        return chapterPercentCorrectlyListDTO
    }

    fun getChapterRealTryCountPerThemeCount(userId: String)
    : List<ChapterRealTryCountThemeRealCountDTO> {
        val chapterPercentCorrectlyListDTO: MutableList<ChapterRealTryCountThemeRealCountDTO> = mutableListOf()

        val javaLanguageData = javaLanguagesRepo.findByOwner(
                userDetailsRepo.findById(userId).get()
        )

        javaLanguageData.chapters.stream().forEach {
            chapterPercentCorrectlyListDTO.add(
                    ChapterRealTryCountPerThemeNumberCalculate()
                            .createChapterRealTryCountPerThemeNumberDTO(it)
            )
        }

        return chapterPercentCorrectlyListDTO
    }


    private fun createChapterFullTimeDTO(chapter: Chapter): ChapterFullTimeSolution {
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