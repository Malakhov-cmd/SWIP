package com.example.swip.service

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.Task
import com.example.swip.domain.Theme
import com.example.swip.repo.ChapterRepo
import com.example.swip.repo.JavaLanguagesRepo
import com.example.swip.repo.TaskRepo
import com.example.swip.repo.ThemeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChapterFuller(
        @Autowired
        var javaLanguagesRepo: JavaLanguagesRepo,
        @Autowired
        var chapterRepo: ChapterRepo,
        @Autowired
        var themeRepo: ThemeRepo,
        @Autowired
        var taskRepo: TaskRepo
) {
    fun chapterInitial(langId: Long?) {
        for (i in 1..14) {
            val lang: JavaLanguage = javaLanguagesRepo.findById(langId!!).get()

            val chapter = Chapter()
            chapter.numberChapter = i
            chapter.chapterProgress = 0.0
            chapter.language = lang

            val chapterId = chapterRepo.save(chapter).id

            when (i) {
                1 -> {
                    fullingFirstChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                    javaLanguagesRepo.save(lang)
                }
            }
        }
    }

    fun fullingFirstChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..3) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "Да"
                }
                2 -> {
                    task.answer = "8"
                }
                3 -> {
                    task.answer = "Динамический компилятор"
                }
            }
            val taskId = taskRepo.save(task).id

            val themeSaved = themeRepo.findById(themeId).get()
            themeSaved.task = taskRepo.findById(taskId!!).get()

            themeRepo.save(themeSaved)

            chapter.listThemes.add(themeSaved)

            chapterRepo.save(chapter)
        }
    }
}