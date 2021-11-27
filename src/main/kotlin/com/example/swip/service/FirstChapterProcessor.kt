package com.example.swip.service

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.repo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FirstChapterProcessor(
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
    fun firstChapterAnswers(numberTheme: Int, answer: String, userId: String): String {
        var approvedResult = ""

        val user = userDetailsRepo.findById(userId).get()
        val javaLanguage = javaLanguagesRepo.findByOwner(user)

        javaLanguage.chapters.sortBy { it.numberChapter }

        val firstChapter = javaLanguage.chapters[0]

        firstChapter.listThemes.sortBy { it.number }

        when (numberTheme) {
            1 -> {
                val themeOne = firstChapter.listThemes[0]
                val taskOne = themeOne.task
                taskOne?.answer = answer
                themeOne.isFinished = true

                firstChapter.chapterProgress = firstChapter.chapterProgress + 33.3

                javaLanguagesRepo.save(javaLanguage)
                chapterRepo.save(firstChapter)
                themeRepo.save(themeOne)
                taskRepo.save(taskOne!!)

                approvedResult = answer
            }
            2 -> {
                approvedResult = checkerUserAnswer(javaLanguage.id!!, firstChapter.id!!, 1, answer)
            }
            3 -> {
                approvedResult = checkerUserAnswer(javaLanguage.id!!, firstChapter.id!!, 2, answer)
            }
        }
        return approvedResult
    }

    fun checkerUserAnswer(languageId: Long,
                          chapterId: Long,
                          themeNumber: Int,
                          answer: String): String {
        var result = ""

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[0]

        val themeThree = chapter.listThemes[themeNumber]
        val taskThree = themeThree.task
        if (answer.equals(taskThree?.answer)) {
            taskThree?.answer = answer
            themeThree.isFinished = true

            chapter.chapterProgress = chapter.chapterProgress + 33.3

            javaLanguagesRepo.save(language)
            chapterRepo.save(chapter)
            themeRepo.save(themeThree)
            taskRepo.save(taskThree!!)

            result = answer
        } else {
            result = "Incorrect answer"
        }
        return result
    }
}