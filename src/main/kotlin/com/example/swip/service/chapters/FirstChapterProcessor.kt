package com.example.swip.service.chapters

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.Task
import com.example.swip.domain.Theme
import com.example.swip.domain.component.Language
import com.example.swip.repo.*
import com.example.swip.repo.achive.AchiveRepo
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
        var taskRepo: TaskRepo,
        @Autowired
        var achiveRepo: AchiveRepo
) {
    fun firstChapterAnswers(
            numberTheme: Int,
            answer: String,
            userId: String,
            timeSpend: Int
    ): String {
        var approvedResult = ""

        val user = userDetailsRepo.findById(userId).get()
        val javaLanguage = javaLanguagesRepo.findByOwner(user)

        javaLanguage.chapters.sortBy { it.numberChapter }

        val firstChapter = javaLanguage.chapters[0]

        firstChapter.listThemes.sortBy { it.number }

        when (numberTheme) {
            1 -> approvedResult = checkerUserAnswer(javaLanguage.id!!, 0, answer, timeSpend)
            2 -> approvedResult = checkerUserAnswer(javaLanguage.id!!, 1, answer, timeSpend)
            3 -> approvedResult = checkerUserAnswer(javaLanguage.id!!, 2, answer, timeSpend)
        }
        return approvedResult
    }

    private fun checkerUserAnswer(
            languageId: Long,
            themeNumber: Int,
            answer: String,
            timeSpend: Int
    ): String {
        var result = ""

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[0]

        val theme = chapter.listThemes[themeNumber]
        val task = theme.task!!

        result = if (themeNumber == 0) {
            recordSuccess(task, theme, chapter, language, answer, timeSpend)
        } else if (answer == task.answer) {
            recordSuccess(task, theme, chapter, language,answer, timeSpend)
        } else {
            task.tryCount = task.tryCount + 1
            task.timeOnSolutionInSeconds = task.timeOnSolutionInSeconds + timeSpend
            taskRepo.save(task)

            "Incorrect answer"
        }
        return result
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

        chapter.chapterProgress = chapter.chapterProgress + 33.3

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

        if (chapter.chapterProgress > 95) {
            if(user.achivesList.stream().filter{ it.name == "endedChapter1"  }.count() == 0L){
                user.achivesList.add(achiveRepo.findByName("endedChapter1"))
                userDetailsRepo.save(user)
            }
        }
    }
}