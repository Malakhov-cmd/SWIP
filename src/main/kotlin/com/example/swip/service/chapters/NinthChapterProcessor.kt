package com.example.swip.service.chapters

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.Task
import com.example.swip.domain.Theme
import com.example.swip.repo.*
import com.example.swip.repo.achive.AchiveRepo
import com.example.swip.service.groovyCompiler.GroovyCompiler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NinthChapterProcessor(
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
        var groovyCompiler: GroovyCompiler,
        @Autowired
        var achiveRepo: AchiveRepo
) {
    fun ninthChapterAnswers(
            numberTheme: Int,
            answer: String,
            userId: String,
            timeSpend: Int
    ): String {
        var approvedResult = ""

        val user = userDetailsRepo.findById(userId).get()
        val javaLanguage = javaLanguagesRepo.findByOwner(user)

        javaLanguage.chapters.sortBy { it.numberChapter }

        val fourthChapter = javaLanguage.chapters[8]

        fourthChapter.listThemes.sortBy { it.number }

        approvedResult = checkerUserAnswerIfDefaultBehavior(javaLanguage.id!!, numberTheme - 1, answer, timeSpend)
        return approvedResult
    }

    private fun checkerUserAnswerIfDefaultBehavior(
            languageId: Long,
            themeNumber: Int,
            answer: String,
            timeSpend: Int
    ): String {
        val result: String

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[8]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task!!
        result = if (answer == task.answer) {
            recordSuccess(task, theme, chapter, language, answer, timeSpend)
        } else {
            task.tryCount = task.tryCount + 1
            task.timeOnSolutionInSeconds = task.timeOnSolutionInSeconds + timeSpend
            taskRepo.save(task)

            "Incorrect answer"
        }
        return result
    }

    private fun checkerUserAnswerCompileTask(
            languageId: Long,
            themeNumber: Int,
            answer: String,
            timeSpend: Int
    ): String {
        var result = ""

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[8]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task!!

        val compiledValue = groovyCompiler.execute(answer)

        if (compiledValue == task.answer) {
            result = recordSuccess(task, theme, chapter, language, answer, timeSpend)
        } else {
            task.tryCount = task.tryCount + 1
            task.timeOnSolutionInSeconds = task.timeOnSolutionInSeconds + timeSpend
            taskRepo.save(task)

            result = "Incorrect answer"
        }
        return result
    }

    private fun checkerUserAnswerWithoutCheck(
            languageId: Long,
            themeNumber: Int,
            answer: String,
            timeSpend: Int
    ): String {
        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[8]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task

        return recordSuccess(task!!, theme, chapter, language, answer, timeSpend)
    }

    private fun recordSuccess(
            task: Task,
            theme: Theme,
            chapter: Chapter,
            language: JavaLanguage,
            answer: String,
            timeSpend: Int
    ): String {
        task.answer = answer

        task.timeOnSolutionInSeconds = task.timeOnSolutionInSeconds + timeSpend
        task.tryCount = task.tryCount + 1

        theme.isFinished = true

        chapter.chapterProgress = chapter.chapterProgress + 4.54

        javaLanguagesRepo.save(language)
        chapterRepo.save(chapter)
        themeRepo.save(theme)
        taskRepo.save(task)

        checkToAddAchive(chapter, language.owner!!.id)

        return answer
    }

    private fun checkToAddAchive(
            chapter: Chapter,
            userId: String,
    ) {
        val user = userDetailsRepo.findById(userId).get()

        if (chapter.chapterProgress > 99) {
            if(user.achivesList.stream().filter{ it.name == "endedChapter9"  }.count() == 0L){
                user.achivesList.add(achiveRepo.findByName("endedChapter9"))
                userDetailsRepo.save(user)
            }
        }
    }
}