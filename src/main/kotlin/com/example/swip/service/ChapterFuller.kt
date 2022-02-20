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
                3 -> {
                    fullingThirdChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                4 -> {
                    fullingFourthChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                5 -> {
                    fullingFifthChapter(chapterId!!)
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

        for (i in 1..37) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "It's Java"
                }
                2 -> {
                    task.answer = "Yes"
                }
                3 -> {
                    task.answer = "25"
                }
                4 -> {
                    task.answer = "Infinity"
                }
                5 -> {
                    task.answer = "e"
                }
                6 -> {
                    task.answer = "more"
                }
                7 -> {
                    task.answer = "Type"
                }
                8 -> {
                    task.answer = "Two"
                }
                9 -> {
                    task.answer = "One"
                }
                10 -> {
                    task.answer = "USA"
                }
                11 -> {
                    task.answer = "Two"
                }
                12 -> {
                    task.answer = "double"
                }
                13 -> {
                    task.answer = "less"
                }
                14 -> {
                    task.answer = "Twenty"
                }
                15 -> {
                    task.answer = "Four"
                }
                16 -> {
                    task.answer = "Equal"
                }
                17 -> {
                    task.answer = "Eight"
                }
                18 -> {
                    task.answer = "More"
                }
                19 -> {
                    task.answer = "spaceJava"
                }
                20 -> {
                    task.answer = "Hello_Java_is_Hard_way_"
                }
                21 -> {
                    task.answer = "UniteAddressSpace"
                }
                22 -> {
                    task.answer = "false"
                }
                23 -> {
                    task.answer = "lets_start"
                }
                24 -> {
                    task.answer = "Awesome"
                }
                25 -> {
                    task.answer = "System_use"
                }
                26 -> {
                    task.answer = "Exception"
                }
                27 -> {
                    task.answer = "more"
                }
                28 -> {
                    task.answer = "Five"
                }
                29 -> {
                    task.answer = "Five"
                }
                30 -> {
                    task.answer = "UZB"
                }
                31 -> {
                    task.answer = "Six"
                }
                32 -> {
                    task.answer = "Two"
                }
                33 -> {
                    task.answer = "Exception"
                }
                34 -> {
                    task.answer = "Zero"
                }
                35 -> {
                    task.answer = "FiftyFive"
                }
                36 -> {
                    task.answer = "Twenty"
                }
                37 -> {
                    task.answer = "FortyFive"
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

    fun fullingThirdChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..37) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "Для сокрытия реализации класса"
                }
                2 -> {
                    task.answer = "Экземпляр класса"
                }
                3 -> {
                    task.answer = "Методы"
                }
                4 -> {
                    task.answer = "Проектировать архитектуру под специальные реализации"
                }
                5 -> {
                    task.answer = "15"
                }
                6 -> {
                    task.answer = "2000"
                }
                7 -> {
                    task.answer = "Loe"
                }
                8 -> {
                    task.answer = "90"
                }
                9 -> {
                    task.answer = "56"
                }
                10 -> {
                    task.answer = "Luisa"
                }
                11 -> {
                    task.answer = "4"
                }
                12 -> {
                    task.answer = "Exception"
                }
                13 -> {
                    task.answer = "8.9"
                }
                14 -> {
                    task.answer = "24"
                }
                15 -> {
                    task.answer = "Точкой входа в программу"
                }
                16 -> {
                    task.answer = "216"
                }
                17 -> {
                    task.answer = "Second cube is bigger"
                }
                18 -> {
                    task.answer = "Cube"
                }
                19 -> {
                    task.answer = "Cube"
                }
                20 -> {
                    task.answer = "Использование классов находящихся в других папках"
                }
                21 -> {
                    task.answer = "@author"
                }
                22 -> {
                    task.answer = "Да"
                }
                23 -> {
                    task.answer = "Разбить на несколько классов"
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

    fun fullingFourthChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..37) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "16"
                }
                2 -> {
                    task.answer = "Любое количество"
                }
                3 -> {
                    task.answer = "Square bigger"
                }
                4 -> {
                    task.answer = "Exception"
                }
                5 -> {
                    task.answer = "not acceptable"
                }
                6 -> {
                    task.answer = "8 4"
                }
                7 -> {
                    task.answer = "5"
                }
                8 -> {
                    task.answer = "true"
                }
                9 -> {
                    task.answer = "Для сравния объектов с учетом равенства всех полей"
                }
                10 -> {
                    task.answer = "hash code is equal"
                }
                11 -> {
                    task.answer = "x value is 2 h value is 5"
                }
                12 -> {
                    task.answer = "Для использования примитивных типов в качестве объектов"
                }
                13 -> {
                    task.answer = "Последнем"
                }
                14 -> {
                    task.answer = "Texas"
                }
                15 -> {
                    task.answer = "Излишняя затратность операций"
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

    fun fullingFifthChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..37) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "bigger"
                }
                2 -> {
                    task.answer = "value 16 Instanse of Figure interface"
                }
                3 -> {
                    task.answer = "Equal"
                }
                4 -> {
                    task.answer = "tempAnswer"
                }
                5 -> {
                    task.answer = "tempAnswer"
                }
                6 -> {
                    task.answer = "tempAnswer"
                }
                7 -> {
                    task.answer = "tempAnswer"
                }
                8 -> {
                    task.answer = "tempAnswer"
                }
                9 -> {
                    task.answer = "tempAnswer"
                }
                10 -> {
                    task.answer = "tempAnswer"
                }
                11 -> {
                    task.answer = "tempAnswer"
                }
                12 -> {
                    task.answer = "tempAnswer"
                }
                13 -> {
                    task.answer = "tempAnswer"
                }
                14 -> {
                    task.answer = "tempAnswer"
                }
                15 -> {
                    task.answer = "tempAnswer"
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