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
          Рекомендации по обработке исключений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Специалисты придерживаются разных мнений относительно обработки исключений. Одни считают, что проверяемые
              исключения — это не более чем досадная помеха, а другие готовы затратить дополнительное время и труд на
              их обработку. На наш
              взгляд, исключения (особенно проверяемые) — полезный механизм, но, применяя
              его, не стоит слишком увлекаться. В этом разделе дается ряд рекомендаций относительно применения и
              обработки исключений в прикладных программах.

            </p>

            <ul>
              <li>
                <p>
                  Обработка исключений не может заменить собой простую проверку
                </p>
                <p>
                  Для иллюстрации этого положения ниже приведен фрагмент кода, в котором
                  используется встроенный класс Stack. В этом коде делается 10 миллионов попыток извлечь элемент из
                  пустого стека. Сначала в нем выясняется, пуст ли стек:

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (!s.empty)) s.pop();</pre>
                <p>
                  Затем элемент принудительно извлекается из стека, независимо от того, пуст ли
                  он или заполнен, как показано ниже. После этого перехватывается исключение
                  типа EmptyStackException, которое предупреждает, что так делать нельзя
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> ()
            {
                s.pop();
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (EmptyStackException е)
            {
            }</pre>
                <p>
                  Время, затраченное на тестовом компьютере для вызова метода
                  isEmpty(), составило 646 миллисекунд, а на перехват исключения типа
                  EmptyStackException — 21739 миллисекунд.

                </p>
                <p>
                  Как видите, перехват исключения занял намного больше времени, чем простая
                  проверка. Из этого следует вывод: пользуйтесь исключениями только в тех случаях, когда это
                  оправданно, что зачастую бывает лишь в исключительных ситуациях.

                </p>
              </li>
              <li>
                <p>
                  Не доводите обработку исключений до абсурдных мелочей.
                </p>
                <p>
                  Многие программисты заключают едва ли не каждый оператор в отдельный
                  блок try. Ниже показано, к чему приводит подобная мелочность при программировании на Java.
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            PrintStream out;
            Stack s;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (i = <span class="hljs-number"
                                                                                                style="color: rgb(147, 92, 37);">0</span>; i &lt; <span
                      class="hljs-number" style="color: rgb(147, 92, 37);">100</span>; i++) {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
                    n = s.pop();
                } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (EmptyStackException e) {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// стек оказался пустым</span>
                }
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
                    out.writelnt(n);
                } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException e) {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// сбой при записи данных в файл</span>
                }
            }</pre>
                <p>
                  При таком подходе объем кода значительно увеличивается. Поэтому хорошенько подумайте о той задаче,
                  которую должна решать ваша программа.
                  В данном случае требуется извлечь из стека 100 чисел и записать их в файл.
                  (Неважно, зачем это нужно, — это всего лишь пример.) Одно только генерирование исключения не является
                  выходом из положения. Ведь если стек пуст,
                  то он не заполнится как по мановению волшебной палочки. А если при записи числовых данных в файл
                  возникает ошибка, то она не исчезнет сама собой. Следовательно, имеет смысл разместить в блоке try
                  весь фрагмент кода
                  для решения поставленной задачи, как показано ниже. Если хотя бы одна из
                  операций в этом блоке даст сбой, можно отказаться от решения всей задачи,
                  а не отдельных ее частей.
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (i = <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">0</span>; i &lt; <span
                      class="hljs-number" style="color: rgb(147, 92, 37);">100</span>; i++) {
                    n = s.pop();
                    out.writelnt(n);
                }
            } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException e) {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// сбой при записи данных в файл</span>
            } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (EmptyStackException е) {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// стек оказался пустым</span>
            }</pre>
                <p>
                  Этот фрагмент кода уже выглядит намного яснее. Он выполняет одно из своих
                  основных назначений — отделяет нормальную обработку данных от обработки
                  исключений.
                </p>
              </li>
              <li>
                <p>
                  Правильно пользуйтесь возможностями, которые предоставляет иерархия наследования исключений.

                </p>
                <p>
                  Не ограничивайтесь генерированием только исключения типа
                  RuntimeException. Найдите подходящий подкласс или создайте собственный.
                  Не перехватывайте исключение типа Throwable. При таком подходе ваш код
                  становится трудным для понимания и сопровождения.

                </p>
                <p>
                  Правильно различайте проверяемые и непроверяемые исключения. Для обработки проверяемых исключений
                  требуются дополнительные усилия, поэтому не применяйте их для уведомления о логических ошибках. (В
                  библиотеке,
                  поддерживающей механизм рефлексии, это правило не соблюдается. Поэтому
                  ее пользователям часто приходится писать код для перехвата тех исключений,
                  которые могут вообще не возникнуть.)

                </p>
                <p>
                  Смело преобразуйте, если требуется, один тип исключения в другой, более
                  подходящий в данной ситуации. Если вы, скажем, выполняете синтаксический
                  анализ целого значения, вводимого из файла, перехватывайте исключение
                  класса NumberFormatException и преобразуйте его в исключение подкласса,
                  производного от класса IOException или MySubsystemException, для последующего генерирования.
                </p>
              </li>
              <li>
                <p>
                  Не подавляйте исключения.

                </p>
                <p>
                  ри программировании на Java существует большой соблазн подавить исключения. Допустим, требуется
                  написать метод, вызывающий другой метод,
                  который может сгенерировать исключение один раз в сто лет. Компилятор
                  предупредит об этом, поскольку исключение не указано в списке оператора
                  throws при объявлении данного метода. Но если нет никакого желания указывать его в списке оператора
                  throws, чтобы компилятор не выдавал сообщения
                  об ошибках во всех методах, вызывающих данный метод, то такое исключение
                  можно просто подавить следующим образом:

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                    class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Image <span
                    class="hljs-title" style="color: rgb(37, 127, 173);">loadlmage</span><span class="hljs-params"
                                                                                               style="color: rgb(147, 92, 37);">(String s)</span>
        </span>{
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                код, способный генерировать проверяемые исключения
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (Exception е)
            {} <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ничего не делать!</span>
        }</pre>
                <p>
                  Теперь код будет скомпилирован. Он будет прекрасно работать, но не в исключительной ситуации. А если
                  она возникнет, то будет просто проигнориров
                  Но если вы все-таки считаете, что подобные исключения важны, приложите
                  усилия для организации их обработки.
                </p>
              </li>
              <li>
                <p>
                  Обнаруживая ошибки, проявляйте необходимую твердость вместо излишней терпимости.

                </p>
                <p>
                  Некоторые программисты избегают генерировать исключения, обнаруживая
                  ошибки. Например, если методу передаются некорректные параметры, они
                  предпочитают возвращать фиктивное значение. Когда, например, стек пуст,
                  программист может предусмотреть возврат из метода Stack.pop () пустого
                  значения null вместо того, чтобы генерировать исключение. На наш взгляд,
                  лучше сгенерировать исключение типа EmptyStackException в той точке, где
                  возникла ошибка, чем исключение типа NullPointerException впоследствии.
                </p>
              </li>
              <li>
                <p>
                  Не бойтесь передавать исключения для обработки в коде, разрабатываемом другими.

                </p>
                <p>
                  Некоторые программисты считают себя обязанными перехватывать все исключения. Вызывая метод,
                  генерирующий некоторое исключение, например конструктор класса FilelnputStream или метод readLine (),
                  они инстинктивно
                  перехватывают исключения, которые могут быть при этом сгенерированы. Но
                  зачастую предпочтительнее передать исключение другому обработчику, а не
                  обрабатывать его самостоятельно, как показано ниже.

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                    class="hljs-function"><span class="hljs-keyword"
                                                style="color: rgb(107, 107, 184);">public</span> <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                              style="color: rgb(37, 127, 173);">readStuff</span><span
                    class="hljs-params" style="color: rgb(147, 92, 37);">(String filename)</span>
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> IOException <span
                      class="hljs-comment" style="color: rgb(113, 149, 168);">// Ничтоже сумняшеся!</span>
        </span>{
            InputStream in = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FilelnputStream(filename);
        }</pre>
                <p>
                  Методы более высокого уровня лучше оснащены средствами уведомления
                  пользователей об ошибках или отмены выполнения неверных операций.
                </p>
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
          Почему не стоит подавлять исключения?
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
          Почему не стоит подавлять исключения?
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
  name: "RecomendationWorkWithExeption",
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

      selected: 'подавление мешает восприятию кода',
      options: [
        {item: 'подавление мешает восприятию кода', name: 'подавление мешает восприятию кода'},
        {item: 'Подавление пораждает скрытые ошибки', name: 'Подавление пораждает скрытые ошибки'},
        {
          item: 'Подавление приводит к возникновению непредвиденных последсвий выше по стеку вызовов',
          name: 'Подавление приводит к возникновению непредвиденных последсвий выше по стеку вызовов'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/sixthchapter/', {
        params: {
          numberTheme: 6,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[5].listThemes[5].task.answer = response.data
              window.frontendData.language.chapters[5].chapterProgress += 16.6
              window.frontendData.language.chapters[5].listThemes[5].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[5].listThemes[5].task.answer

          window.frontendData.language.chapters[5].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[5].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[5].listThemes[5].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[5].listThemes[5].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[5].listThemes[5].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-6-chapter-3-theme');

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