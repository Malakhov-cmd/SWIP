package com.example.swip.service.chapters

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.Task
import com.example.swip.domain.Theme
import com.example.swip.domain.component.Language
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
                approvedResult = checkerUserAnswer(javaLanguage.id!!, 0, answer)
            }
            2 -> {
                approvedResult = checkerUserAnswer(javaLanguage.id!!, 1, answer)
            }
            3 -> {
                approvedResult = checkerUserAnswer(javaLanguage.id!!, 2, answer)
            }
        }
        return approvedResult
    }

    private fun checkerUserAnswer(
            languageId: Long,
            themeNumber: Int,
            answer: String): String {
        var result = ""

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[0]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task!!

        result = if (themeNumber == 0) {
            recordSuccess(task, theme, chapter, language, answer)
        } else if (answer == task.answer) {
            recordSuccess(task, theme, chapter, language,answer)
        } else {
            "Incorrect answer"
        }
        return result
    }

    private fun recordSuccess(
            task: Task,
            theme: Theme,
            chapter: Chapter,
            language: JavaLanguage,
            answer: String
            ): String {
        task.answer = answer
        theme.isFinished = true

        chapter.chapterProgress = chapter.chapterProgress + 33.3

        javaLanguagesRepo.save(language)
        chapterRepo.save(chapter)
        themeRepo.save(theme)
        taskRepo.save(task!!)

        return answer
    }
}