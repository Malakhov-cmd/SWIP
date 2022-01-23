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
          Файловый ввод и вывод
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Чтобы прочитать данные из файла, достаточно сконструировать объект типа
              Scanner:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">Scanner in = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(Paths.get(<span
                class="hljs-string" style="color: rgb(168, 255, 96);">"myfile.txt"</span>), <span class="hljs-string"
                                                                                                  style="color: rgb(168, 255, 96);">"UTF-8"</span>);</pre>
            <p>
              Если имя файла содержит знаки обратной косой черты, их следует экранировать дополнительными знаками
              обратной косой черты, как, например: "с:\ \
              m ydirectoryW m yfi l e . t x t ”. После этого можно произвести чтение из файла, используя любые
              упомянутые выше методы из класса Scanner.
            </p>
            <p>
              А для того чтобы записать данные в файл, достаточно сконструировать объект
              типа PrintWriter, указав в его конструкторе имя файла, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">PrintWriter out = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> PrintWriter(<span class="hljs-string"
                                                                                                     style="color: rgb(168, 255, 96);">"myfile.txt"</span>, MUTF-<span
                class="hljs-number" style="color: rgb(255, 115, 253);">8</span><span class="hljs-string"
                                                                                     style="color: rgb(168, 255, 96);">");
</span></pre>
            <p>
              Если файл не существует, он создается. Для вывода в файл можно воспользоваться
              методами print (), println () и printf () точно так же, как это делается для вывода
              на консоль (или в стандартный поток вывода System, out).
            </p>
            <p>
              Как видите, обращаться к файлам так же легко, как и при консольном вводе и выводе в стандартные потоки
              System, in и System, out соответственно. Правда, здесь
              имеется одна уловка: если вы конструируете объект типа Scanner с файлом, который
              еще не существует, или объект типа PrintWriter с именем файла, который не может быть создан, возникает
              исключение. Компилятор Java рассматривает подобные
              исключения как более серьезные, чем, например, исключение при делении на нуль.
              В главе 7 будут рассмотрены различные способы обработки исключений. А до тех
              пор достаточно уведомить компилятор о том, что при файловом вводе и выводе может возникнуть исключение
              типа "файл не найден". Для этого в объявление метода
              main () вводится предложение throws, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(150, 203, 254);">void</span> <span
                class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">throws</span> IOException
</span>{
       Scanner in = <span class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(Paths.get(<span
                  class="hljs-string" style="color: rgb(168, 255, 96);">"myfile.txt"</span>), <span class="hljs-string"
                                                                                                    style="color: rgb(168, 255, 96);">"UTF-8"</span>);
}</pre>
            <p>
              Теперь вы знаете, как читать и записывать текстовые данные в файлы. Более сложные вопросы файлового
              ввода-вывода, в том числе применение различных кодировок
              символов, обработка двоичных данных, чтение каталогов и запись архивных файлов,
              рассматриваются в главе 2 второго тома настоящего издания.
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
          Какая кодировка выбирается по умолчанию при создании Scanner?
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
          Какая кодировка выбирается по умолчанию при создании Scanner?
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "FileInputOutputData",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      selected: 'UTF_8',
      options: [
        {item: 'UTF_8', name: 'UTF_8'},
        {item: 'Win_1251', name: 'Win_1251'},
        {item: 'ASCII', name: 'ASCII'},
        {item: 'System_use', name: 'Используемая системой'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 25,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[24].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[24].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[24].task.answer

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          this.$toasted.error("Неверный ответ", {
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
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[24].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[24].task.answer
    }
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)
    //container.scrollTo(50, 5000)
  }
}
</script>

<style scoped>

</style>