package com.example.swip.service.statistic

import com.example.swip.domain.Chapter
import com.example.swip.domain.achive.Achive
import com.example.swip.repo.*
import com.example.swip.service.statistic.DTO.ChapterPercentCorrectly
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.math.round

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
            chapterPercentCorrectlyListDTO.add(createChapterPercentDTO(it))
        }

        return chapterPercentCorrectlyListDTO
    }

    private fun createChapterPercentDTO(chapter: Chapter): ChapterPercentCorrectly {
        var total = 0.0

        chapter.listThemes.forEach {
            if (it.isFinished)
                total += it.task!!.tryCount
        }

        val newChapterPercentCorrectly = ChapterPercentCorrectly()

        newChapterPercentCorrectly.chapterNumber = chapter.numberChapter!!
        if (total == 0.0) newChapterPercentCorrectly.percentCorrectly = 0.0
        else newChapterPercentCorrectly.percentCorrectly = String
                .format("%.2f", ((chapter.listThemes.size / total) * 100.0))
                .replace(',','.')
                .toDouble()

        return newChapterPercentCorrectly
    }
}