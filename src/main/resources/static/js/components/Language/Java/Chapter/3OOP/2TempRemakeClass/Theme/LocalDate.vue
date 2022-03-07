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
          Класс LocaiDate из библиотеки Java
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В предыдущих примерах использовался класс Date, входящий в состав стандартной библиотеки Java. Экземпляр
              класса Date находится в состоянии, которое отражает конкретный момент времени.
            </p>
            <p>Пользуясь классом Date, совсем не обязательно знать формат даты. Тем не менее
              время в этом классе представлено количеством миллисекунд (положительным или
              отрицательным), отсчитанным от фиксированного момента времени, так называемого начала эпохи, т.е. от
              момента времени 00:00:00 UTC, 1 января 1970 г. Сокращение
              UTC означает Universal Coordinated Time (Универсальное скоординированное время) — научный стандарт
              времени. Стандарт UTC применяется наряду с более известным стандартом GMT (Greenwich Mean Time — среднее
              время по Гринвичу).</p>

            <p>Но класс Date не очень удобен для манипулирования датами. Разработчики библиотеки Java посчитали, что
              представление даты, например "December 31, 1999,
              23:59:59", является совершенно произвольным и должно зависеть от календаря.
              Данное конкретное представление подчиняется григорианскому календарю, самому распространенному в мире. Но
              тот же самый момент времени совершенно иначе
              представляется в китайском или еврейском лунном календаре, не говоря уже о календаре, которым будут
              пользоваться потенциальные потребители с Марса.
            </p>

            <p>Разработчики библиотеки Java решили отделить вопросы, связанные с отслеживанием моментов времени, от
              вопросов их представления. Таким образом, стандартная библиотека Java содержит два отдельных класса:
              класс Date, представляющий
              момент времени, и класс LocaiDate , выражающий даты в привычном календарном
              представлении. В версии Java SE 8 внедрено немало других классов для манипулирования различными
              характеристиками даты и времени, как поясняется в главе 6
              второго тома настоящего издания.</p>

            <p>Отделение измерения времени от календарей является грамотным решением,
              вполне отвечающим принципам ООП.

            </p>

            <p>Для построения объектов класса LocaiDate нужно пользоваться не его конструктором, а статическими
              фабричными методами, автоматически вызывающими соответующие конструкторы. Так, в следующем выражении:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">LocaiDate.now()
</pre>
            <p>создается новый объект, представляющий дату построения этого объекта.
            </p>

            <p>Безусловно, построенный объект желательно сохранить в объектной переменной,
              как показано ниже.</p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">LocalDate newYearsEve = LocalDate.of(<span
                class="hljs-number" style="color: rgb(159, 113, 60);">1999</span>, <span class="hljs-number"
                                                                                         style="color: rgb(159, 113, 60);">12</span>, <span
                class="hljs-number" style="color: rgb(159, 113, 60);">31</span>);
</pre>
            <p>
              Имея в своем распоряжении объект типа LocalDate, можно определить год, месяц и день с помощью методов
              getYear (), getMonthValue () и getDayOfMonth (), как
              демонстрируется в следующем примере кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> year = newYearsEve.getYear(); <span
                class="hljs-comment" style="color: rgb(120, 135, 125);">// 1999 г.</span>
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> month = newYearsEve.getMonthValue(); <span
                  class="hljs-comment" style="color: rgb(120, 135, 125);">// 12-й месяц</span>
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> day = newYearsEve.getDayOfMonth(); <span
                  class="hljs-comment" style="color: rgb(120, 135, 125);">// 31-е число</span>
</pre>
            <p>
              На первый взгляд, в этом нет никакого смысла, поскольку те же самые значения
              даты использовались для построения объекта. Но иногда можно воспользоваться датой, вычисленной иным
              способом, чтобы вызвать упомянутые выше методы
              и получить дополнительные сведения об этой дате. Например, с помощью метода
              plusDays () можно получить новый объект типа LocalDate, отстоящий во времени
              на заданное количество дней от объекта, к которому этот метод применяется:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">LocalDate aThousandDaysLater = newYearsEve.plusDays(<span
                class="hljs-number" style="color: rgb(159, 113, 60);">1000</span>);
year = aThousandDaysLater.getYear(); <span class="hljs-comment" style="color: rgb(120, 135, 125);">// 2002 r. </span>
month = aThousandDaysLater.getMonthValue(); <span class="hljs-comment"
                                                  style="color: rgb(120, 135, 125);">// 9-й месяц </span>
day = aThousandDaysLater.getDayOfMonth(); <span class="hljs-comment"
                                                style="color: rgb(120, 135, 125);">// 26-е число</span></pre>
            <p>
              В классе LocalDate инкапсулированы поля экземпляра для хранения заданной
              даты. Не заглянув в исходный код этого класса, нельзя узнать, каким образом в нем
              представлена дата. Но ведь назначение такой инкапсуляции в том и состоит, что
              пользователю класса LocalDate вообще не нужно об этом знать. Ему важнее знать
              о тех методах, которые доступны в этом классе.
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
public class Test {
    public static void main(String[] args) {
        LocalDate newYearsEve = LocalDate.of(1999, 12, 31);
        newYearsEve = newYearsEve.plusDays(31L);
        System.out.println(newYearsEve.getYear());
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
  name: "LocalDate",
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

      selected: '1999',
      options: [
        {item: '1999', name: '1999'},
        {item: '2000', name: '2000'},
        {item: '2001', name: '2001'},
        {item: '1', name: '1'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 6,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[5].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[5].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[5].task.answer

          window.frontendData.language.chapters[2].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[5].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[2].listThemes[5].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[5].task.answer
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
        `public class Test {
    public static void main(String[] args) {
        LocalDate newYearsEve = LocalDate.of(1999, 12, 31);
        newYearsEve = newYearsEve.plusDays(31L);
        System.out.println(newYearsEve.getYear());
    }
}
      `)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-2-theme-2-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if(pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>