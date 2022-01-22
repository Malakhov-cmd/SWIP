package com.example.swip.service.chapters

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.Task
import com.example.swip.domain.Theme
import com.example.swip.repo.*
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
                approvedResult = checkerUserAnswerCompileTask(javaLanguage.id!!, 0, answer)
            }
            2 -> {
                approvedResult = checkerUserAnswerWithoutCheck(javaLanguage.id!!, 1, answer)
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
            19 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 18, answer)
            }
            20 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 19, answer)
            }
            21 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 20, answer)
            }
            22 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 21, answer)
            }
            23 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 22, answer)
            }
            24 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 23, answer)
            }
            25 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 24, answer)
            }
            26 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 25, answer)
            }
            27 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 26, answer)
            }
            28 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 26, answer)
            }
            29 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 28, answer)
            }
            30 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 29, answer)
            }
            31 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 30, answer)
            }
            32 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 31, answer)
            }
            33 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 32, answer)
            }
            34 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 33, answer)
            }
            35 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 34, answer)
            }
            36 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 34, answer)
            }
            37 -> {
                approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, 35, answer)
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

    private fun checkerUserAnswerCompileTask(
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

        if (compiledValue == task?.answer) {
            recordSuccess(task, theme, chapter, language, task.answer!!)
            return answer;
        } else {
            result = "Incorrect answer"
        }
        return result
    }

    private fun checkerUserAnswerWithoutCheck(
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

