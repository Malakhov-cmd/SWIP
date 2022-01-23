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
            1 -> approvedResult = checkerUserAnswerCompileTask(javaLanguage.id!!, 0, answer)
            2 -> approvedResult = checkerUserAnswerWithoutCheck(javaLanguage.id!!, 1, answer)
            else -> approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, numberTheme - 1, answer)
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
            result = recordSuccess(task, theme, chapter, language, answer)
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

        chapter.chapterProgress = chapter.chapterProgress + 2.7

        javaLanguagesRepo.save(language)
        chapterRepo.save(chapter)
        themeRepo.save(theme)
        taskRepo.save(task)

        return answer
    }
}

