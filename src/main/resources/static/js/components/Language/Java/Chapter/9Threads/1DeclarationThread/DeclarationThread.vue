<template>
  <div class="page-theme">
    <b-jumbotron>

      <template #header>
        <router-link to="/Language" class="back-redirect-router-link"
                     v-on:click="this.$eventBus.$emit('redirectToJavaRoad')">
          <div class="cl-btn-redirectToLanguage">
          </div>
        </router-link>
        <div class="page-theme-name">
          Потоки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Вам, вероятно, хорошо известна многозадачность используемой вами операционной системы — возможность
              одновременно выполнять несколько программ. Например, вы можете печатать во время редактирования документа
              или приема электронной почты. Вполне возможно, что ваш современный компьютер оснащен не одним
              центральным процессором, но число одновременно выполняющихся процессов не
              ограничивается количеством процессоров. Операционная система выделяет время
              процессора квантами для каждого процесса, создавая впечатление параллельного
              выполнения программ.

            </p>

            <p>
              Многопоточные программы расширяют принцип многозадачности, перенося его
              на один уровень ниже, чтобы отдельные приложения могли выполнять многие задачи одновременно. Каждая
              задача обычно называется потоком исполнения, или иначе
              потоком управления. Программы, способные одновременно выполнять больше одного потока исполнения,
              называются многопоточными.
            </p>

            <p>
              Так в чем же отличие между многими процессами и потоками исполнения? Оно
              состоит в следующем: если у каждого процесса имеется собственный набор переменных, то потоки исполнения
              могут разделять одни и те же общие данные. Это кажется
              несколько рискованным, и на самом деле так оно и есть, как станет ясно далее в этой
              главе. Но разделяемые переменные обеспечивают более высокую эффективность взаимодействия потоков
              исполнения и облегчают связь между ними. Кроме того, в некоторых операционных системах потоки исполнения
              являются более "легковесными",
              чем процессы, — они требуют меньших издержек на свое создание и уничтожение
              по сравнению с процессами.
            </p>
            <p>
              Многопоточная обработка имеет исключительную практическую ценность. Например, браузер должен уметь
              одновременно загружать многие изображения.
              Веб-серверу нужно обслуживать параллельные запросы. Программы с ГПИ имеют
              отдельные потоки исполнения для сбора событий в пользовательском интерфейсе из
              среды операционной системы. В этой главе речь пойдет о том, как внедрять многопоточные возможности в
              прикладные программы на Java.

            </p>

            <p>
              Следует, однако, иметь в виду, что многопоточная обработка может оказаться
              очень сложным делом. В этой главе будут рассмотрены все инструментальные средства, которые, скоре всего,
              понадобятся прикладным программистам. Но для более
              сложного программирования на системном уровне рекомендуется обратиться к таким основательным
              первоисточникам, как, например, книга Брайана Гоетца (Brian
              Goetz) Java Concurrency in Practice (издательство Addison-Wesley Professional, 2006 r.)
            </p>
            <p>
              Ниже приведена простая процедура для исполнения задачи в отдельном потоке.
            </p>
            <ul>
              <li>
                <p>
                  Введите код выполняемой задачи в тело метода run () из класса, реализующего интерфейс Runnable. Этот
                  интерфейс очень прост и содержит следующий
                  единственный метод:

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                                   style="color: rgb(37, 127, 173);">Runnable</span></span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">run</span><span class="hljs-params"
                                                                            style="color: rgb(147, 92, 37);">()</span></span>;
}</pre>
              </li>
              <li>
                <p>
                  Интерфейс Runnable является функциональным, и поэтому его экземпляр
                  можно создать с помощью лямбда-выражения следующим образом
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Runnable г = () -&gt; { код задачи } ;</pre>
              </li>
              <li>
                <p>
                  Сконструируйте объект типа Thread из объекта г типа Runnable, как показано
                  ниже.

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Thread t = <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Thread(г);
</pre>
              </li>
              <li>
                <p>
                  Запустите поток на исполнение следующим образом
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">t.start ();
</pre>
              </li>
            </ul>

            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 1.", написанной Кейем С.
              Хорстманном.
            </div>
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Чем является интерфейс Runnable?
        </label>

        <div class="answers-input-option">
          <b-form-radio-group
              v-model="selected"
              :options="options"
              class="mb-3"
              value-field="item"
              text-field="name"
              disabled-field="notEnabled"
          ></b-form-radio-group>
        </div>

        <!-- This is a form text block (formerly known as help block) -->
        <b-form-text id="input-live-help">Выберите один из вариантов ответа</b-form-text>
      </div>

      <div v-show="!showInput">
        <label class="page-theme-question-text">
          Чем является интерфейс Runnable?
        </label>
        <p class="page-theme-theory-text">
          Ваш ответ: {{ answer }}
        </p>
      </div>

      <div class="box animate" style="" v-show="animationOn">Успех</div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false

export default {
  name: "DeclarationThread",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,

      timeStarted: 0,
      timeEndeded: 0,
      timeSpended: 0,

      selected: 'Интерфейсом декларирующим общие принципы работы многопочного исполнения',
      options: [
        {
          item: 'Интерфейсом декларирующим общие принципы работы многопочного исполнения',
          name: 'Интерфейсом декларирующим общие принципы работы многопочного исполнения'
        },
        {
          item: 'Функциональным интерфейсом',
          name: 'Функциональным интерфейсом'
        },
        {
          item: 'Интерфейсом содержащие необходимые дефолтные методы',
          name: 'Интерфейсом содержащие необходимые дефолтные методы'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/ninthchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[0].task.answer

          window.frontendData.language.chapters[8].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[0].task.tryCount + ".", {
            theme: "toasted-primary",
            position: 'top-right',
            duration: 5000,
            fullWidth: false,
            action: {
              text: 'Cancel',
              onClick: (e, toastObject) => {
                toastObject.goAway(0);
              }
            },
          })
          clearInterval(interval)
        }
      }, 1000)
    }
  },
  mounted() {
    if (window.frontendData.language.chapters[8].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-1-theme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if (pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>