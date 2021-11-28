package com.example.swip.service

import com.example.swip.repo.*
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
        var taskRepo: TaskRepo
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
                approvedResult = checkerUserAnswerFirstTheme(javaLanguage.id!!, secondChapter.id!!, 0, answer )
            }
            2 -> {
                approvedResult = checkerUserAnswer(javaLanguage.id!!, secondChapter.id!!, 1, answer)
            }
            3 -> {
                approvedResult = checkerUserAnswer(javaLanguage.id!!, secondChapter.id!!, 2, answer)
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
        val chapter = language.chapters[1]

        val theme = chapter.listThemes[themeNumber]
        val taskThree = theme.task
        if (answer.equals(taskThree?.answer)) {
            taskThree?.answer = answer
            theme.isFinished = true

            chapter.chapterProgress = chapter.chapterProgress + 2.2

            javaLanguagesRepo.save(language)
            chapterRepo.save(chapter)
            themeRepo.save(theme)
            taskRepo.save(taskThree!!)

            result = answer
        } else {
            result = "Incorrect answer"
        }
        return result
    }

    fun checkerUserAnswerFirstTheme(languageId: Long,
                          chapterId: Long,
                          themeNumber: Int,
                          answer: String): String {
        var result = ""

        val language = javaLanguagesRepo.findById(languageId).get()
        val chapter = language.chapters[1]

        val theme = chapter.listThemes[themeNumber]
        val taskThree = theme.task

        val correctInputRegex = """System\.out\.println\((\s*)\"It\'s Java(\s*)\"\)\;""".toRegex()

        val tempChecker = correctInputRegex.find(answer)?.value?.length

        if (tempChecker != null) {
            if (tempChecker > 0) {
                taskThree?.answer = answer
                theme.isFinished = true

                chapter.chapterProgress = chapter.chapterProgress + 2.2

                javaLanguagesRepo.save(language)
                chapterRepo.save(chapter)
                themeRepo.save(theme)
                taskRepo.save(taskThree!!)

                result = answer
            } else {
                result = "Incorrect answer"
            }
        }
        return result
    }
}

