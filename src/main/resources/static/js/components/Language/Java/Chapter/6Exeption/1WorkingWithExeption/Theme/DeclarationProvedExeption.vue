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
          Объявление проверяемых исключений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Метод может генерировать исключения, если возникает ситуация, с которой он не
              в состоянии справиться. Идея проста: метод не только сообщает компилятору, какие
              значения он может возвращать, но и предсказывает, какие ошибки могут возникнуть.
              Например, в коде, вводящем данные из файла, можно предположить, что такого
              файла не существует или он пуст. Следовательно, код, предназначенный для ввода
              из файла, должен сообщить компилятору, что он может сгенерировать исключение
              типа IOException.

            </p>

            <p>
              Объявление о том, что данный метод может генерировать исключение, делается
              в его заголовке. Ниже в качестве примера приведено объявление одного из конструкторов класса
              FilelnputStream из стандартной библиотеки. (Подробнее о вводе-выводе речь пойдет в главе 2 второго тома
              настоящего издания.)

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">FilelnputStream</span> <span class="hljs-params"
                                                                                                  style="color: rgb(147, 92, 37);">(String name)</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> FileNotFoundException</span></pre>
            <p>Это объявление означает, что данный конструктор создает объект типа
              FilelnputStream, исходя из параметра name типа String, но в определенных случаях, когда что-нибудь пойдет
              не так, он может также сгенерировать исключение
              типа FileNotFoundException. Если это произойдет, исполняющая система начнет поиск обработчика событий,
              предназначенного для обработки объектов типа
              FileNotFoundException.


            </p>
            <p>
              Cоздавая свой собственный метод, не нужно объявлять все возможные исключения, которые этот метод
              фактически может сгенерировать. Чтобы лучше понять, когда и что следует описывать с помощью оператора
              throws, имейте в виду, что исключение генерируется в следующих четырех случаях.

            </p>
            <ul>
              <li>
                <p>
                  Вызывается метод, генерирующий проверяемое исключение, например конструктор класса FilelnputStream.

                </p>
              </li>
              <li>
                <p>
                  Обнаружена ошибка, и с помощью оператора throw явным образом генерируется проверяемое исключение
                  (оператор throw обсуждается в следующем
                  разделе).

                </p>
              </li>
              <li>
                <p>
                  Обнаружена ошибка программирования, например, в программе присутствует выражение а [ - 1 ] = 0,
                  вследствие чего возникает непроверяемое исключение, например, типа ArraylndexOutOfBoundsException.

                </p>
              </li>
              <li>
                <p>
                  Возникает внутренняя ошибка в виртуальной машине или библиотеке исполняющей системы.

                </p>
              </li>
            </ul>
            <p>
              В двух первых случаях нужно сообщить тем, кто будет пользоваться данным методом, что возможно исключение.
              Зачем? А затем, что любой метод, генерирующий
              исключение, представляет собой потенциально опасное место в прикладной программе. Если своевременно не
              предусмотреть в ней обработку данного типа исключения, то выполнение текущего потока прервется.
            </p>

            <p>
              Объявить, что метод может генерировать исключение, можно, включив в его заголовок описание исключения,
              как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">MyAnimation</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Image <span
        class="hljs-title" style="color: rgb(37, 127, 173);">loadlmage</span> <span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">(String s)</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> IOException
    </span>{
    }
}</pre>
            <p>

              Если же метод может генерировать несколько проверяемых исключений, все они
              должны быть перечислены в его заголовке через запятую следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">MyAnimation</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Image <span
        class="hljs-title" style="color: rgb(37, 127, 173);">loadlmage</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">(String s)</span>
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> FileNotFoundException, EOFException </span>{
    }
}</pre>
            <p>
              Но внутренние ошибки, т.е. исключения, производные от класса Error, объявлять
              не нужно. Такие исключения могут генерироваться любыми методами, а самое главное, что они не поддаются
              никакому контролю.

            </p>
            <p>
              Точно так же совсем не обязательно объявлять непроверяемые исключения, производные от класса
              RuntimeException:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">MyAnimation</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">drawlmage</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">(<span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> i)</span>
            <span class="hljs-keyword"
                  style="color: rgb(107, 107, 184);">throws</span> ArraylndexOutOfBoundsException <span
          class="hljs-comment" style="color: rgb(113, 149, 168);">// не рекомендуется!</span>
    </span>{
    }
}
</pre>
            <p>
              Ответственность за подобные ошибки полностью возлагается на разработчика
              прикладной программы. Так, если вас беспокоит возможность выхода индекса за допустимые границы массива,
              лучше уделите больше внимания предотвращению этой
              исключительной ситуации, вместо того чтобы объявлять о потенциальной опасности
              ее возникновения.

            </p>
            <p>
              Таким образом, в методе должны быть объявлены все проверяемые исключения, которые он может генерировать.
              А непроверяемые исключения находятся вне контроля
              разработчика данного метода (класс Error) или же являются следствием логических
              ошибок, которые не следовало допускать (класс RuntimeException). Если же в объявлении метода не
              сообщается обо всех проверяемых исключениях, компилятор выдаст
              сообщение об ошибке.
            </p>
            <p>
              Разумеется, вместо объявления исключений, как было показано выше, их можно
              перехватывать. В этом случае исключение не генерируется, и объявлять его в операторе throws не нужно.
              Далее в этой главе мы обсудим, что лучше: перехватывать
              исключение самостоятельно или поручить это кому-нибудь другому.
            </p>
            <p>
              Если в объявлении метода указывается, что он может генерировать исключение
              определенного класса, то он может также генерировать исключения его подклассов.
              Например, в конструкторе класса FilelnputStream можно объявить о возможности
              генерирования исключения типа IOException, причем неизвестно, какого именно.
              Это может быть, в частности, простое исключение класса IOException или же объект
              одного из производных от него классов, в том числе класса FileNotFoundException.

            </p>
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
          О чем свидетельствует оператор throws в объявлении метода?
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
          О чем свидетельствует оператор throws в объявлении метода?
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
  name: "DeclarationProvedExeption",
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

      selected: 'В методе содержится нестабильный код',
      options: [
        {item: 'В методе содержится нестабильный код', name: 'В методе содержится нестабильный код'},
        {item: 'Выполнение метода может привести к ошибке', name: 'Выполнение метода может привести к ошибке'},
        {
          item: 'Выполнение метода приводик к возникновению ошибки',
          name: 'Выполнение метода приводик к возникновению ошибки'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/sixthchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[5].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[5].chapterProgress += 10.0
              window.frontendData.language.chapters[5].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[5].listThemes[1].task.answer

          window.frontendData.language.chapters[5].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[5].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[5].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[5].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[5].listThemes[1].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-6-chapter-1-theme-2-subtheme');

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