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
          Закрытые методы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              При реализации класса все поля данных делаются закрытыми, поскольку предоставлять к ним доступ из других
              классов весьма рискованно. А как поступить с методами? Для взаимодействия с другими объектами требуются
              открытые методы. Но
              в ряде случаев для вычислений нужны вспомогательные методы. Как правило, эти
              вспомогательные методы не являются частью интерфейса, поэтому указывать при их
              объявлении ключевое слово p u blic нет необходимости. И чаще всего они объявляются как p riv ate, т.е.
              как закрытые. Чтобы сделать метод закрытым, достаточно изменить ключевое слово public на private в его
              объявлении.
            </p>

            <p>
              Сделав метод закрытым, совсем не обязательно сохранять его при переходе к другой реализации. Такой метод
              труднее реализовать, а возможно, он окажется вообще ненужным, если изменится представление данных, что, в
              общем, несущественно.
              Важнее другое: до тех пор, пока метод является закрытым (private), разработчики
              класса могут быть уверены в том, что он никогда не будет использован в операциях,
              выполняемых за пределами класса, а следовательно, они могут просто удалить его.
              Если же метод является открытым (public), его нельзя просто так опустить, поскольку от него может
              зависеть другой код.
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

        private int mark;

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers;

            this.speedPerMiles = this.speedPerKilometers / 1.6;

            this.mark = setMark(this.speedPerKilometers);
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

        private int setMark(double value){
            if (value < 50.0){
                return 3;
            } else {
                if (value > 75.0){
                    return 5;
                } else {
                    return 4;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 65.0);
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
  name: "ClosedMethods",
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

      selected: '1',
      options: [
        {item: '1', name: '1'},
        {item: '3', name: '3'},
        {item: '4', name: '4'},
        {item: '5', name: '5'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 11,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[10].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[10].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[10].task.answer

          window.frontendData.language.chapters[2].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[10].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[10].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[10].task.answer
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

        private int mark;

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers;

            this.speedPerMiles = this.speedPerKilometers / 1.6;

            this.mark = setMark(this.speedPerKilometers);
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

        private int setMark(double value){
            if (value < 50.0){
                return 3;
            } else {
                if (value > 75.0){
                    return 5;
                } else {
                    return 4;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 65.0);
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

    let themeToClose = document.getElementById('java-3-chapter-3-theme-5-subtheme');

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