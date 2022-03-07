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
          Введение в аннотации
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Ан нотация.ми называются дескрипторы, которые разработчики вста вляют
              в свой исходный код, чтобы их можно было обработать соответствующими инструментальными средствами. Эги
              инструментальные средства моrут действовать
              как на уровне исходного кода, так и на уровне файлов классов, в которых компилятор размещает аннотации.
              Аннотации не влияют на способ компиляции
              программ. Компилятор Java генерирует одинаковые инструкции виртуальной
              машины как с аннотациями, так и без них
            </p>

            <p>
              тобы извлечь наибольшую пользу из аннотаций, необходимо выбрать подходящее средство обработки. В исходный
              код следует вводить такие аннотации,
              которые распознаются избранным средством обработки, способным правильно
              интерпретировап, их и выполнять соответствующие действия над исходным кодом. У аннотаций существует
              немало областей применения, поэтому их универсальность может поначалу вызывап, недоразумения. Ниже
              перечислены некоторые из областей применения аннотаций.
            </p>

            <ul>
              <li>
                <p>
                  втоматическое генерирование вспомогательных файлов, например, файлов дескрипторов развертывания или
                  классов информации о компонентах
                  JavaBeans
                </p>
              </li>
              <li>
                <p>
                  Автоматическое генерирование кода для тестирования, протоколирования,
                  семантической обработки транзакций и т.д.
                </p>
              </li>
            </ul>

            <p>
              Начнем обсуждение аннотаций с основных понятий и продемонстрируем их
              практическое применение на конкретном примере, пометив методы как приемники событий для компонентов AWT и
              представив обработчик аннотаций, способный анализировать аннотации и подключать приемники событий. Далее
              мы
              подробно рассмотрим синтаксические правила. На конец, будут продемонстрированы два расширенных примера
              обработки аннотаций: первый - на уровне
              исходного кода, второй - на уровне файлов классов, где библиотека Apache
              Bytecode Engineering Library применяется для вставки дополнительных байт-кодов в аннотированные методы.
            </p>
            <p>
              Ниже приведен пример объявления простой аннотации. В частности, аннотация @Test служит для аннотирования
              метода chec kRandomi nsertions ().
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЫ ic <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">MyClass</span>
</span>{
<span class="hljs-meta" style="color: rgb(147, 92, 37);">@Test</span> puЬ<span class="hljs-function">l ic <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> che ckRandomi nsert i <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">ons</span> <span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span>
}</span></pre>
            <p>
              Аннотация применяется в Java подобно модификатору и размещается перед
              аннотируемым элементом бе.з точки с запятой. (Модификатор - это ключевое
              слово вроде puЫic или static.) Имя каждой аннотации предваряется знаком @
              подобно тому, как это делается в документирующих комментариях, автоматически составляемых в формате
              Javadoc. Но документирующие комментарии в формате Javadoc размещаются между разделителями /** ... * /,
              тогда как аннотации
              являются частью исходного кода .
            </p>
            <p>
              Сама аннотация @Test ничего не делает. Чтобы она смогла приносить какуюто пользу, ей потребуется
              подходящее инструме1пальное средство. Например, инструментальное средство модульного тестирования JUnit 5
              (доступное по адресу
              https : / /j uni t. org /j uni t5/) способно вызвать все помеченные аннотацией @Test
              методы при тестировании класса. Другое инструментальное средство может удалить
              все тестовые методы из файла класса, чтобы исключить их из исходного кода программы после ее
              тестирования. Аннотации могут быть определены вместе со своими э.лементами, как демонстрируется в
              приведенном ниже примере кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@Test</span> (time out =<span class="hljs-string"
                                                                                                 style="color: rgb(86, 140, 59);">"1000"</span>) </pre>

            <p>
              Эти элементы могут обрабатываться инструментальными средствам и, способными обрабатывать аннотации.
              Элементы могут выглядеть и по-другому. Подробнее о них речь пойдет далее в этой главе. Помимо методов,
              аннотациями
              могут снабжаться классы, поля и локальные переменные, а сами аннотации -
              размещаться на тех же местах, где и модификаторы типа puЫic или static.
              Как будет показано в разделе 8.4, аннотациями можно также снабжать пакеты,
              переменные параметров, параметры типа и примеры применения типов данных.
            </p>
            <p>
              Каждая аннотация должна определяться с помощью интерфейса аннотаций.
              Методы такого интерфейса должны соответствовать элементам определяемой им
              аннотации. Например, аннотация @ Test для модульного тестирования средствами JUnit определяется с помощью
              следующего интерфейса :
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@Target</span> (El ementType . METHOD)
<span class="hljs-meta" style="color: rgb(147, 92, 37);">@Retent</span> ion ( Retent i on Policy . RUNT IME )
puЫic <span class="hljs-meta" style="color: rgb(147, 92, 37);">@interface</span> Test
{
    <span class="hljs-function">l ong t <span class="hljs-title" style="color: rgb(37, 127, 173);">imeout</span> <span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> de fault 01</span>;
}</pre>

            <p>
              В объявлении @ i nterface создается конкретный интерфейс Java, а инструментальные средства,
              обрабатывающие аннотации, получают объекты, классы
              которых реализуют сам интерфейс аннотаций. Например, для извлечения элемента t imeout из конкретной
              аннотации Test инструментальное средство вызывает метод t imeout ().
            </p>
            <p>
              Aннотации @Target и @ Re tent i on являются .мета-аннотация.ми. Они помечают аннотацию @ T est, превращая
              ее в такую аннотацию, которая может применяться только к методам и должна сохраняться при загрузке файла
              класса в виртуальную машину. Более подробно они рассматриваются в разделе 8.5.3.
            </p>
            <p>
              В этом разделе были представлены основные понятия метаданных и аннотаций к программам. В следующем
              разделе будет рассмотрен конкретный пример
              обработки аннотаций
            </p>


            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
              Хорстманном.
            </div>
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Для чего нужны аннотации?
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
          Для чего нужны аннотации?
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
  name: "IntroInAnnotation",
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

      selected: 'Для отметки специальных мест кода и их последующей обработке срециальными средствами',
      options: [
        {
          item: 'Для отметки специальных мест кода и их последующей обработке срециальными средствами',
          name: 'Для отметки специальных мест кода и их последующей обработке срециальными средствами'
        },
        {
          item: 'Для упрощения написания кода',
          name: 'Для упрощения написания кода'
        },
        {
          item: 'Для маркировки кода и сигнализации о его назначении',
          name: 'Для маркировки кода и сигнализации о его назначении'
        },
        {
          item: 'Все вышеперечисленное',
          name: 'Все вышеперечисленное'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/elevenchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[4].task.answer

          window.frontendData.language.chapters[10].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[4].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('central-btn-13chapter');

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