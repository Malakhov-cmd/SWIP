package com.example.swip.controller

import com.example.swip.repo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/java/firstchapter/")
class FirstChapterController(
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
    @GetMapping()
    fun answersFirstChapter(@RequestParam(required = true) numberTheme: Int,
                            @RequestParam(required = true) answer: String,
                            @RequestParam(required = true) userId: String): String {
        firstChapterAnswers(numberTheme, answer, userId)
        return "Слышу вас"
    }

    fun firstChapterAnswers(numberTheme: Int, answer: String, userId: String) {
        val user = userDetailsRepo.findById(userId).get()
        val javaLanguage = javaLanguagesRepo.findByOwner(user)
        val firstChapter = javaLanguage.chapters[0]

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
            }
        }
    }
}