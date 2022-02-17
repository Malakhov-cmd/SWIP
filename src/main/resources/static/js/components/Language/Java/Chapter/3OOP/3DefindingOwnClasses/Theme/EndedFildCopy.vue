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
          Неизменяемые поля экземпляра
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Поля экземпляра можно объявить с помощью ключевого слова final. Такое поле
              должно инициализироваться при создании объекта, т.е. необходимо гарантировать,
              что значение поля будет установлено по завершении каждого конструктора. После
              этого его значение изменить уже нельзя. Например, поле name из класса Employee
              можно объявить неизменяемым, поскольку после создания объекта оно уже не изменяется, а метода setName ()
              для этого не существует,
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">class</span> <span
                class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span>
</span>{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(85, 133, 155);">final</span> String name;
}</pre>
            <p>
              Модификатор final удобно применять при объявлении полей простых типов
              или полей, типы которых задаются неизменяемыми классами. Неизменяемым называется такой класс, методы
              которого не позволяют изменить состояние объекта. Например, неизменяемым является класс String. Если
              класс допускает изменения, то
              ключевое слово final может стать источником недоразумений. Рассмотрим поле
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(85, 133, 155);">final</span> StringBuilder evaluations;</pre>

            <p>
              которое инициализируется в конструкторе класса Employee таким образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">evaluations = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> StringBuilder() ;
</pre>

            <p>
              Ключевое слово final означает, что ссылка на объект, хранящаяся в переменной
              evaluations, вообще не будет делаться на другой объект типа StringBuilder. Но
              в то же время объект может быть изменен следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">void</span> <span class="hljs-title"
                                                                                         style="color: rgb(71, 140, 144);">giveGoldStar</span><span
                class="hljs-params" style="color: rgb(159, 113, 60);">()</span>
</span>{
evaluations.append(LocalDate.now() + <span class="hljs-string" style="color: rgb(72, 153, 99);">": Gold star!\n"</span>);
}</pre>

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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
class Main
{
    static class Horses{
        private long id;
        private String name;
        private Double speedPerKilometers;
        private Double speedPerMiles;

        private final int mark = 4;

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers;

            this.speedPerMiles = this.speedPerKilometers / 1.6;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSpeedPerKilometers() {
            return speedPerKilometers;
        }

        public void setSpeedPerKilometers(Double speedPerKilometers) {
            this.speedPerKilometers = speedPerKilometers;
        }

        public Double getSpeedPerMiles() {
            return speedPerMiles;
        }

        public void setSpeedPerMiles(Double speedPerMiles) {
            this.speedPerMiles = speedPerMiles;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 65.0);
        horses.mark = 8;
        System.out.println(horses.getMark());
    }
}
        </textarea>

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
          Что выведет программа?
        </label>
        <textarea id="codeContentIdAnswered"></textarea>
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
import * as CodeMirror from "codemirror"
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "EndedFildCopy",
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

      selected: 'Exception',
      options: [
        {item: 'Exception', name: 'Exception'},
        {item: '4', name: '4'},
        {item: '8', name: '8'},
        {item: '0', name: '0'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 12,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[11].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 2.7
              window.frontendData.language.chapters[2].listThemes[11].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[11].task.answer

          window.frontendData.language.chapters[2].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[11].task.tryCount + ".", {
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
      setTimeout(() => {
        $('.CodeMirror').each(function (i, el) {
          el.CodeMirror.refresh();
        });
      }, 1000)
    }
  },
  mounted() {
    if (window.frontendData.language.chapters[2].listThemes[11].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[11].task.answer
    }

    this.codeContent = CodeMirror.fromTextArea(document.getElementById('codeContentId'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent = CodeMirror.fromTextArea(document.getElementById('codeContentIdAnswered'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent.setValue(
        `class Main
{
    static class Horses{
        private long id;
        private String name;
        private Double speedPerKilometers;
        private Double speedPerMiles;

        private final int mark = 4;

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers;

            this.speedPerMiles = this.speedPerKilometers / 1.6;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSpeedPerKilometers() {
            return speedPerKilometers;
        }

        public void setSpeedPerKilometers(Double speedPerKilometers) {
            this.speedPerKilometers = speedPerKilometers;
        }

        public Double getSpeedPerMiles() {
            return speedPerMiles;
        }

        public void setSpeedPerMiles(Double speedPerMiles) {
            this.speedPerMiles = speedPerMiles;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 65.0);
        horses.mark = 8;
        System.out.println(horses.getMark());
    }
}`)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-3-theme-11-subtheme');

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