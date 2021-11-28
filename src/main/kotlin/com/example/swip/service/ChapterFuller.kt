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
                }
                2 -> {
                    fullingSecondChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
            }
            javaLanguagesRepo.save(lang)
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

    fun fullingSecondChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..45) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "System.out.println(\"It's Java\");"
                }
                2 -> {
                    task.answer = "Да"
                }
                3 -> {
                    task.answer = "Да"
                }
                4 -> {
                    task.answer = "Да"
                }
                5 -> {
                    task.answer = "Да"
                }
                6 -> {
                    task.answer = "Да"
                }
                7 -> {
                    task.answer = "Да"
                }
                8 -> {
                    task.answer = "Да"
                }
                9 -> {
                    task.answer = "Да"
                }
                10 -> {
                    task.answer = "Да"
                }
                11 -> {
                    task.answer = "Да"
                }
                12 -> {
                    task.answer = "Да"
                }
                13 -> {
                    task.answer = "Да"
                }
                14 -> {
                    task.answer = "Да"
                }
                15 -> {
                    task.answer = "Да"
                }
                16 -> {
                    task.answer = "Д�"
                }
                17 -> {
                    task.answer = "Да"
                }
                18 -> {
                    task.answer = "Да"
                }
                19 -> {
                    task.answer = "Да"
                }
                20 -> {
                    task.answer = "Да"
                }
                21 -> {
                    task.answer = "Да"
                }
                22 -> {
                    task.answer = "Да"
                }
                23 -> {
                    task.answer = "Да"
                }
                24 -> {
                    task.answer = "Да"
                }
                25 -> {
                    task.answer = "Да"
                }
                26 -> {
                    task.answer = "Да"
                }
                27 -> {
                    task.answer = "Да"
                }
                28 -> {
                    task.answer = "Да"
                }
                29 -> {
                    task.answer = "Да"
                }
                30 -> {
                    task.answer = "Да"
                }
                31 -> {
                    task.answer = "Да"
                }
                32 -> {
                    task.answer = "Да"
                }
                33 -> {
                    task.answer = "Да"
                }
                34 -> {
                    task.answer = "Да"
                }
                35 -> {
                    task.answer = "Да"
                }
                36 -> {
                    task.answer = "Да"
                }
                37 -> {
                    task.answer = "Да"
                }
                38 -> {
                    task.answer = "�а"
                }
                39 -> {
                    task.answer = "Да"
                }
                40 -> {
                    task.answer = "Да"
                }
                41 -> {
                    task.answer = "Да"
                }
                42 -> {
                    task.answer = "Да"
                }
                43 -> {
                    task.answer = "Да"
                }
                44 -> {
                    task.answer = "Да"
                }
                45 -> {
                    task.answer = "Да"
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