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
          Интерфейсы в каркасе коллекций Java
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В каркасе коллекций Java определен целый ряд интерфейсов для различных типов коллекций, как показано на
              рисунке.
            </p>

            <p>
              <img src="https://i.stack.imgur.com/XhKOu.jpg"
                   alt="schema" style="max-width: 80%;"/>
            </p>

            <p>
              В рассматриваемом здесь каркасе имеются два основополагающих интерфейса коллекций: Collection и Мар. Для
              ввода элементов в коллекцию служит следующий метод:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">add</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(E element)</span>
</span></pre>
            <p>
              Но отображения содержат пары ''ключ-значение", поэтому для ввода этих пар
              вызывается метод put ():


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function">V <span class="hljs-title" style="color: rgb(37, 127, 173);">put</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(К key, V value)</span>
</span></pre>
            <p>
              Для извлечения элементов из коллекции служит итератор, организующий обращение к ним. А для извлечения
              значений из отображения вызывается метод get ():

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function">V <span class="hljs-title" style="color: rgb(37, 127, 173);">get</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(К key)</span></span></pre>
            <p>
              Список представляет собой упорядоченную коллекцию. Элементы добавляются
              на определенной позиции в контейнере. Доступ к элементу списка осуществляется
              с помощью итератора или по целочисленному индексу. В последнем случае доступ
              оказывается произвольным, поскольку к элементам можно обращаться в любом порядке. А если используется
              итератор, то обращаться к элементам списка можно только по очереди.
            </p>

            <p>
              Для произвольного доступа к элементам списка в интерфейсе L is t определяются
              следующие методы:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">add</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> index, Е element)</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">remove</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                              style="color: rgb(107, 107, 184);">int</span> index)</span>
E <span class="hljs-title" style="color: rgb(37, 127, 173);">get</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> index)</span>
E <span class="hljs-title" style="color: rgb(37, 127, 173);">set</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(<span
                  class="hljs-keyword"
                  style="color: rgb(107, 107, 184);">int</span> index, E element)</span></span></pre>
            <p>
              В интерфейсе L is t l t e r a t o r определяется следующий метод для ввода элемента
              до позиции итератора:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">add</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(E element)</span>
</span></pre>
            <p>
              Откровенно говоря, этот аспект каркаса коллекций спроектирован неудачно. На
              практике имеются две разновидности упорядоченных коллекций с совершенно разными показателями
              производительности. Упорядоченная коллекция на основе массива отличается быстрым произвольным доступом, и
              поэтому методы из интерфейса
              List целесообразно вызывать с целочисленными индексом. А связный список отличается медленным произвольным
              доступом, хотя он и относится к категории упорядоченных коллекций. Поэтому перебирать его элементы лучше
              с помощью итератора. И для этой цели следовало бы предоставить два разных интерфейса.


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (с <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">instanceof</span> RandomAccess)
{
    использовать алгоритм произвольного доступа
}
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span>
{
    использовать алгоритм последовательного доступа
}
</pre>
            <p>
              Интерфейс S e t подобен интерфейсу C o lle c tio n , но поведение его методов
              определено более строго. В частности, метод add () должен отвергать дубликаты
              во множестве. Метод equ als () должен быть определен таким образом, чтобы два
              множества считались одинаковыми, если они содержат одни и те же элементы, но
              не обязательно в одинаковом порядке. А метод hashCode () должен быть определен
              таким образом, чтобы два множества с одинаковыми элементами порождали один
              и тот же хеш-код.

            </p>

            <p>
              Зачем же объявлять отдельные интерфейсы, если сигнатуры их методов совпадают? В принципе не все коллекции
              являются множествами. Поэтому наличие интерфейса Set дает программистам возможность писать методы,
              принимающие только
              множества.

            </p>
            <p>
              В интерфейсах SortedSet и SortedMap становится доступным объект-компаратор,
              применяемый для сортировки, а также определяются методы для получения представлений подмножеств
              коллекций. Об этих представлениях речь пойдет в разделе 9.4.

            </p>
            <p>
              Наконец, в версии Java SE 6 внедрены интерфейсы NavigableSet и NavigableMap,
              содержащие дополнительные методы для поиска и обхода отсортированных множеств и отображений. (В идеальном
              случае эти методы должны быть просто включены в состав интерфейсов SortedSet и SortedMap.) Эти интерфейсы
              реализуются
              в классах TreeSet и ТгееМар.

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
          Почему интерфейс Map находится отдельно от общей структуры?
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
          Почему интерфейс Map находится отдельно от общей структуры?
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
  name: "InterfacesInCarcasCollectionsInJava",
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

      selected: 'Маp не считается часть collection framework',
      options: [
        {
          item: 'Маp не считается часть collection framework',
          name: 'Маp не считается часть collection framework'
        },
        {
          item: 'Структура Map слишком отличается от реализации Collection',
          name: 'Структура Map слишком отличается от реализации Collection'
        },
        {
          item: 'Map помечен как deprecated',
          name: 'Map помечен как deprecated'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/eighthchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[3].task.answer

          window.frontendData.language.chapters[7].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[3].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-8-chapter-2-theme');

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