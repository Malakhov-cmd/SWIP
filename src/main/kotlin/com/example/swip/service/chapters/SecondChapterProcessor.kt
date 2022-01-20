package com.example.swip.service.chapters

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.Task
import com.example.swip.domain.Theme
import com.example.swip.repo.*
import com.example.swip.service.ChapterFuller
import com.example.swip.service.groovyCompiler.GroovyCompiler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class SecondChapterProcessor(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var javaLanguagesRepo: JavaLanguagesRepo,
        @Autowired
        var chapterRepo: ChapterRepo,
        @Autowired
        var themeRepo: ThemeRepo,
        @Autowired
        var taskRepo: TaskRepo,
        @Autowired
        var groovyCompiler: GroovyCompiler
) {
    fun secondChapterAnswers(numberTheme: Int, answer: String, userId: String): String {
        var approvedResult = ""

        val user = userDetailsRepo.findById(userId).get()
        val javaLanguage = javaLanguagesRepo.findByOwner(user)

        javaLanguage.chapters.sortBy { it.numberChapter }

        val secondChapter = javaLanguage.chapters[1]

        secondChapter.listThemes.sortBy { it.number }

        when (numberTheme) {
            1 -> {
                approvedResult = checkerUserAnswerFirstTheme(javaLanguage.id!!, 0, answer)
            }
            2 -> {
                approvedResult = checkerUserAnswerSecondTheme(javaLanguage.id!!, 1, answer)
            }
            3 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 2, answer)
            }
            4 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 3, answer)
            }
            5 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 4, answer)
            }
            6 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 5, answer)
            }
            7 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 6, answer)
            }
            8 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 7, answer)
            }
            9 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 8, answer)
            }
            10 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 9, answer)
            }
            11 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 10, answer)
            }
            12 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 11, answer)
            }
            13 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 12, answer)
            }
            14 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 13, answer)
            }
            15 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 14, answer)
            }
            16 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 15, answer)
            }
            17 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 16, answer)
            }
            18 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 17, answer)
            }
        }
        return approvedResult
    }

    private fun checkerUserAnswerIfDefaultBehavior(
            languageId: Long,
            themeNumber: Int,
            answer: String
    ): String {
        val result: String

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[1]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task
        result = if (answer == task?.answer) {
            recordSuccess(task, theme, chapter, language, answer)
        } else {
            "Incorrect answer"
        }
        return result
    }

    private fun checkerUserAnswerFirstTheme(
            languageId: Long,
            themeNumber: Int,
            answer: String
    ): String {
        var result = ""

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[1]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task

        val compiledValue = groovyCompiler.execute(answer)

        if (compiledValue == "It's Java") {
            result = recordSuccess(task!!, theme, chapter, language, answer)
        } else {
            result = "Incorrect answer"
        }
        return result
    }

    private fun checkerUserAnswerSecondTheme(
            languageId: Long,
            themeNumber: Int,
            answer: String
    ): String {
        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[1]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task

        return recordSuccess(task!!, theme, chapter, language, answer);
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

        chapter.chapterProgress = chapter.chapterProgress + 2.2

        javaLanguagesRepo.save(language)
        chapterRepo.save(chapter)
        themeRepo.save(theme)
        taskRepo.save(task)

        return answer
    }
}

