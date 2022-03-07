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
          Метод main ()
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Отметим, что статические методы можно вызывать, не имея ни одного объекта
              данного класса. Например, для того чтобы вызвать метод Math.pow(), объекты типа
              Math не нужны. По той же причине метод main () объявляется как статический:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Application</span> </span>{
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
            class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">void</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">(String[] args)</span> </span>{
            <span class="hljs-comment" style="color: rgb(113, 149, 168);">// здесь создаются объекты</span>
        }
    }</pre>

            <p>
              Метод main () не оперирует никакими объектами. На самом деле при запуске программы еще нет никаких
              объектов. Статический метод main () выполняется
              и конструирует объекты, необходимые программе.
            </p>
            <p>Программа, приведенная в листинге, содержит простую версию класса
              Employee со статическим полем nextld и статическим методом getNextld (). В этой
              программе массив заполняется тремя объектами типа Employee, а затем выводятся
              данные о работниках. И наконец, для демонстрации статического метода на экран
              выводится очередной доступный идентификационный номер.
              Следует заметить, что в классе Employee имеется также статический метод main ()
              для модульного тестирования. Попробуйте выполнить метод main() по командам
              java Employee и java StaticTest.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates static methods.
 * <span class="hljs-doctag">@version</span> 1.01 2004-02-19
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">StaticTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// fill the staff array with three Employee objects</span>
      Employee[] staff = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span>];

      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Tom"</span>, <span class="hljs-number"
                                                                                           style="color: rgb(147, 92, 37);">40000</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Dick"</span>, <span class="hljs-number"
                                                                                            style="color: rgb(147, 92, 37);">60000</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>, <span class="hljs-number"
                                                                                             style="color: rgb(147, 92, 37);">65000</span>);

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// print out information about all Employee objects</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Employee e : staff)
      {
         e.setId();
         System.out.println(<span class="hljs-string"
                                  style="color: rgb(86, 140, 59);">"name="</span> + e.getName() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",id="</span> + e.getId() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span>
               + e.getSalary());
      }

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> n = Employee.getNextId(); <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// calls static method</span>
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Next available id="</span> + n);
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> nextId = <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">1</span>;

   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> id;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String n, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s)</span>
   </span>{
      name = n;
      salary = s;
      id = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> name;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                   style="color: rgb(37, 127, 173);">getSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> salary;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">getId</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> id;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">setId</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      id = nextId; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// set id to next available id</span>
      nextId++;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">int</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getNextId</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> nextId; <span class="hljs-comment"
                                                                                                style="color: rgb(113, 149, 168);">// returns static field</span>
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span> <span
       class="hljs-comment" style="color: rgb(113, 149, 168);">// unit test</span>
   </span>{
      Employee e = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>, <span class="hljs-number"
                                                                                             style="color: rgb(147, 92, 37);">50000</span>);
      System.out.println(e.getName() + <span class="hljs-string" style="color: rgb(86, 140, 59);">" "</span> + e.getSalary());
   }
}
</pre>

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
          Чем является метод main(...)?
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
          Чем является метод main(...)?
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
  name: "MethodMain",
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

      selected: 'Главным методом',
      options: [
        {item: 'Главным методом', name: 'Главным методом'},
        {item: 'Методом в главном классе', name: 'Методом в главном классе'},
        {item: 'Точкой входа в программу', name: 'Точкой входа в программу'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 15,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[14].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[14].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[14].task.answer

          window.frontendData.language.chapters[2].listThemes[14].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[14].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[14].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[14].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[14].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[14].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[14].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-4-theme-3-subtheme');

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