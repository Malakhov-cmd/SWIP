package com.example.swip.service.statistic

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.repo.*
import com.example.swip.service.statistic.DTO.ChapterFullTimeSolution
import com.example.swip.service.statistic.DTO.ChapterPercentCorrectly
import com.example.swip.service.statistic.DTO.ChapterRealTryCountThemeRealCountDTO
import com.example.swip.service.statistic.calculation.ChapterFullTimeCalculate
import com.example.swip.service.statistic.calculation.ChapterPercentCorrectlyCalculate
import com.example.swip.service.statistic.calculation.ChapterRealTryCountPerThemeNumberCalculate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.*

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

        javaLanguageData.chapters.sortBy { item -> item.numberChapter }

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

        javaLanguageData.chapters.sortBy { item -> item.numberChapter }

        javaLanguageData.chapters.stream().forEach {
            chapterPercentCorrectlyListDTO.add(
                    ChapterFullTimeCalculate()
                    .createChapterFullTimeDTO(it)
            )
        }

        return chapterPercentCorrectlyListDTO
    }

    fun getChapterRealTryCountPerThemeCount(userId: String)
            : List<ChapterRealTryCountThemeRealCountDTO> {
        val chapterPercentCorrectlyListDTO: MutableList<ChapterRealTryCountThemeRealCountDTO> = mutableListOf()

        val javaLanguageData = javaLanguagesRepo.findByOwner(
                userDetailsRepo.findById(userId).get()
        )

        javaLanguageData.chapters.sortBy { item -> item.numberChapter }

        javaLanguageData.chapters.stream().forEach {
            chapterPercentCorrectlyListDTO.add(
                    ChapterRealTryCountPerThemeNumberCalculate()
                            .createChapterRealTryCountPerThemeNumberDTO(it)
            )
        }

        return chapterPercentCorrectlyListDTO
    }

    fun averagePercentCorrectly(userId: String)
            : List<Double> {
        val javaLanguage = javaLanguagesRepo.findAll()

        val asynchCalckAveragePercentChapter: Future<List<Double>> = CompletableFuture.supplyAsync {
            val averageValuesPerChapter: MutableList<Double> = mutableListOf(
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0
            )

            javaLanguage.stream().forEach { language ->
                val averageOneUser = ChapterPercentCorrectlyCalculate()
                        .calculateAverageCorrectlyChapterOfOneUser(language)

                for (i in 0..11) {
                    averageValuesPerChapter[i] = averageValuesPerChapter[i] + averageOneUser[i]
                }
            }

            for (i in 0..11) {
                averageValuesPerChapter[i] = String
                        .format("%.2f", (averageValuesPerChapter[i] / javaLanguage.size))
                        .replace(',', '.')
                        .toDouble()
            }

            return@supplyAsync averageValuesPerChapter
        }
        return asynchCalckAveragePercentChapter.get()
    }
}