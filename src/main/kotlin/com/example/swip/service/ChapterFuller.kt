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
        for (i in 1..12) {
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
                6 -> {
                    fullingSixthChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                7 -> {
                    fullingSeventhChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                8 -> {
                    fullingEighthChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                9 -> {
                    fullingNinthChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                10 -> {
                    fullingTenthChapter(chapterId!!)
                    lang.chapters.add(chapterRepo.findById(chapterId).get())
                }
                11 -> {
                    fullingElevenChapter(chapterId!!)
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

        for (i in 1..23) {
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

        for (i in 1..15) {
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

        for (i in 1..10) {
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
                    task.answer = "x=1 x=3 x=4"
                }
                5 -> {
                    task.answer = "ФИ объявляет один единственный метод"
                }
                6 -> {
                    task.answer = "x=1x=2x=3x=2x=4"
                }
                7 -> {
                    task.answer = "При выделении сабсущности в классе"
                }
                8 -> {
                    task.answer = "4"
                }
                9 -> {
                    task.answer = "First module alredy to work! Second module alredy to work!"
                }
                10 -> {
                    task.answer = "12"
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

    fun fullingSixthChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..6) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "Получение подключения к базе данных"
                }
                2 -> {
                    task.answer = "Выполнение метода может привести к ошибке"
                }
                3 -> {
                    task.answer = "... Wrong answer ..."
                }
                4 -> {
                    task.answer = "null value\n" +
                            "request is proccessed"
                }
                5 -> {
                    task.answer = "Выполнение запроса по созданию и инициализации бд"
                }
                6 -> {
                    task.answer = "Подавление приводит к возникновению непредвиденных последсвий выше по стеку вызовов"
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

    fun fullingSeventhChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..9) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "Для использования класса с различными типами"
                }
                2 -> {
                    task.answer = "16"
                }
                3 -> {
                    task.answer = "4 * 4"
                }
                4 -> {
                    task.answer = "9.9"
                }
                5 -> {
                    task.answer = "Процесс замены < T > на тип Object"
                }
                6 -> {
                    task.answer = "Возвращение типа Object и приведение его к типу присваемой переменной"
                }
                7 -> {
                    task.answer = "Преобразование в тип указанный после ключевого слова extends"
                }
                8 -> {
                    task.answer = "Создавать ограничение по типу \"снизу\""
                }
                9 -> {
                    task.answer = "По степени наследования между типами используемых в обощении"
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

    fun fullingEighthChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..12) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "Для выделение общей идеи и декларирования концепций с последующей детальной реализацией"
                }
                2 -> {
                    task.answer = "Декларацией базовых принципов коллекций"
                }
                3 -> {
                    task.answer = "Декларация принципов обхода коллекций"
                }
                4 -> {
                    task.answer = "Структура Map слишком отличается от реализации Collection"
                }
                5 -> {
                    task.answer = "4 * 4"
                }
                6 -> {
                    task.answer = "16 8"
                }
                7 -> {
                    task.answer = "8 16"
                }
                8 -> {
                    task.answer = "16 8 8"
                }
                9 -> {
                    task.answer = "1 1"
                }
                10 -> {
                    task.answer = "1"
                }
                11 -> {
                    task.answer = "4 + 4"
                }
                12 -> {
                    task.answer = "California Texas Alabama"
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

    fun fullingNinthChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..22) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "Функциональным интерфейсом"
                }
                2 -> {
                    task.answer = "Для подготовки необходимых ресурсов и выделение памяти под поток"
                }
                3 -> {
                    task.answer = "При ситуации когда поток больше чем ядер в процессоврах"
                }
                4 -> {
                    task.answer = "При попытке получить блокировку у объекта, занятого другим потоком"
                }
                5 -> {
                    task.answer = "Метод генерирует исключение вместо контекстного завершения"
                }
                6 -> {
                    task.answer = "Произойдет их принудительное завершение"
                }
                7 -> {
                    task.answer = "Формирование сообщений или выпорлнение других операций перед завершением потока"
                }
                8 -> {
                    task.answer = "Совместная запись суммы в результате перевода со счета на счет несколькими методами"
                }
                9 -> {
                    task.answer = "Блокировка не будет снята и останется за потоком вызвавшим метод lock()"
                }
                10 -> {
                    task.answer = "Дать возможность на захват объекта ожидающим потокам с помощью метода await()"
                }
                11 -> {
                    task.answer = "Synchronized"
                }
                12 -> {
                    task.answer = "Для использования блокировки, которой обладает любой объект в Java"
                }
                13 -> {
                    task.answer = "Установление всех полей с доступом private для ограничения доступа к данным другим потоков"
                }
                14 -> {
                    task.answer = "Чтобы компилятор перед применением значения поля опросил потоки и узнал не изменил ли его другой поток"
                }
                15 -> {
                    task.answer = "Оптимизация вычислений"
                }
                16 -> {
                    task.answer = "Он тратит слишком много ресурсов на закрытие потока"
                }
                17 -> {
                    task.answer = "Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >, созадть и запустить Thread, вызвать get()"
                }
                18 -> {
                    task.answer = "Меньшая нагрузка на память при выделении потоков"
                }
                19 -> {
                    task.answer = "Вычисление где не важен порядок а важен первый результат"
                }
                20 -> {
                    task.answer = "Возможность просто разделять задачи на подзадачи и получать результат"
                }
                21 -> {
                    task.answer = "Организация последовательного исполнения кода"
                }
                22 -> {
                    task.answer = "Для вызова функции f в другом потоке"
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

    fun fullingTenthChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..9) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = "2"
                }
                2 -> {
                    task.answer = "3"
                }
                3 -> {
                    task.answer = "1"
                }
                4 -> {
                    task.answer = "3"
                }
                5 -> {
                    task.answer = "16 32 8"
                }
                6 -> {
                    task.answer = "16 32 8 0"
                }
                7 -> {
                    task.answer = "4 + 4 4 * 4"
                }
                8 -> {
                    task.answer = "Samsung 340 Google 500 Apple 450"
                }
                9 -> {
                    task.answer = "2330"
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

    fun fullingElevenChapter(chapterId: Long){
        val chapter: Chapter = chapterRepo.findById(chapterId).get()

        for (i in 1..9) {
            val theme = Theme()
            theme.chapter = chapter
            theme.number = i
            theme.isFinished = false

            val themeId = themeRepo.save(theme).id

            val task = Task()
            task.theme = themeRepo.findById(themeId!!).get()
            when (i) {
                1 -> {
                    task.answer = ""
                }
                2 -> {
                    task.answer = ""
                }
                3 -> {
                    task.answer = ""
                }
                4 -> {
                    task.answer = ""
                }
                5 -> {
                    task.answer = ""
                }
                6 -> {
                    task.answer = ""
                }
                7 -> {
                    task.answer = ""
                }
                8 -> {
                    task.answer = ""
                }
                9 -> {
                    task.answer = ""
                }
                10 -> {
                    task.answer = ""
                }
                11 -> {
                    task.answer = ""
                }
                12 -> {
                    task.answer = ""
                }
                13 -> {
                    task.answer = ""
                }
                14 -> {
                    task.answer = ""
                }
                15 -> {
                    task.answer = ""
                }
                16 -> {
                    task.answer = ""
                }
                17 -> {
                    task.answer = ""
                }
                18 -> {
                    task.answer = ""
                }
                19 -> {
                    task.answer = ""
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