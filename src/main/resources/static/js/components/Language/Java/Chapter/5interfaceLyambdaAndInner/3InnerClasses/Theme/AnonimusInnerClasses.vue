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
          Анонимные внутренние классы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Работая с локальными внутренними классами, можно воспользоваться еще одной
              интересной возможностью. Так, если требуется создать единственный объект некоторого класса, этому классу
              можно вообще не присваивать имени. Такой класс называется анонимным внутренним классом, как показано
              ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">start</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">int</span> interval, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">boolean</span> beep)</span>
    </span>{
        ActionListener listener = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ActionListener()
        {
            <span class="hljs-function"><span class="hljs-keyword"
                                              style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">actionPerformed</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span>
            </span>{
                Date now = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> DateO;
                System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"At the tone, the time is "</span> + now);
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(interval, listener);
        t .start();
    }</pre>
            <p>
              Следует признать, что синтаксис анонимных внутренних классов довольно сложен.
              На самом деле приведенный выше фрагмент кода означает следующее: создается новый объект класса,
              реализующего интерфейс ActionListener, где в фигурных скобках {} определен требующийся метод
              actionPerformed (). Ниже приведена общая
              форма определения анонимных внутренних классов.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> СуперТип(параметры конструирования объектов)
{
     методы и данные внутреннего класса
}</pre>
            <p>
              Здесь СуперТип может быть интерфейсом, например ActionListener, и тогда
              внутренний класс реализует данный интерфейс. СуперТип может быть также классом. В этом случае внутренний
              класс расширяет данный суперкласс.
              Анонимный внутренний класс не может иметь конструкторов, поскольку имя конструктора должно совпадать с
              именем класса, а в данном случае у класса отсутствует
              имя. Вместо этого параметры, необходимые для создания объекта, передаются конструктору суперкласса. Так,
              если вложенный класс реализует какой-нибудь интерфейс,
              параметры конструктора можно не указывать. Тем не менее они должны быть указаны в круглых скобках
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ТипИнтерфейса ()
{
     методы и данные
}</pre>
            <p>
              Cледует внимательно и аккуратно проводить различие между созданием нового
              объекта некоторого класса и конструированием объекта анонимного внутреннего
              класса, расширяющего данный класс. Если за скобками со списком параметров, необходимых для создания
              объекта, следует открытая фигурная скобка, то определяется
              анонимный вложенный класс, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Person queen = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Person(<span class="hljs-string"
                                                                                                style="color: rgb(86, 140, 59);">"Mary"</span>);
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// объект типа Person</span>
Person count = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Person(<span class="hljs-string"
                                                                                                     style="color: rgb(86, 140, 59);">"Dracula"</span>) { . . .};
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// объект внутреннего класса, расширяющего класс Person</span></pre>

            <p>
              В листинге приведен исходный код завершенной версии программы, реализующей "говорящие часы", где
              применяется анонимный внутренний класс. Сравнив
              эту версию программы с ее версией из листинга 6.7, можете сами убедиться, что применение анонимного
              внутреннего класса сделало программу немного короче, но не
              проще для понимания, хотя для этого требуются опыт и практика.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> anonymousInnerClass;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.awt.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.awt.event.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.Timer;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates anonymous inner classes.
 * <span class="hljs-doctag">@version</span> 1.11 2015-05-12
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">AnonymousInnerClassTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      TalkingClock clock = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TalkingClock();
      clock.start(<span class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>, <span class="hljs-keyword"
                                                                                                style="color: rgb(107, 107, 184);">true</span>);

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// keep program running until user selects "Ok"</span>
      JOptionPane.showMessageDialog(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Quit program?"</span>);
      System.exit(<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);
   }
}

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * A clock that prints the time in regular intervals.
 */</span>
<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">TalkingClock</span>
</span>{
   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Starts the clock.
    * <span class="hljs-doctag">@param</span> interval the interval between messages (in milliseconds)
    * <span class="hljs-doctag">@param</span> beep true if the clock should beep
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">start</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">int</span> interval, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> beep)</span>
   </span>{
      ActionListener listener = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ActionListener()
         {
            <span class="hljs-function"><span class="hljs-keyword"
                                              style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">actionPerformed</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span>
            </span>{
               System.out.println(<span class="hljs-string"
                                        style="color: rgb(86, 140, 59);">"At the tone, the time is "</span> + <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date());
               <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (beep) Toolkit.getDefaultToolkit().beep();
            }
         };
      Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(interval, listener);
      t.start();
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
public class Test {
    public static void main(String[] args) {
        SomeSecuritySystem generalModule = new SomeSecuritySystem() {
            @Override
            public void startMonitoring() {
                System.out.print("First module alredy to work! ");
            }
        };



        SomeSecuritySystem sqlInjectionModule = new SomeSecuritySystem() {
            @Override
            public void startMonitoring() {
                System.out.print("Second module alredy to work! ");
            }
        };


        generalModule.startMonitoring();
        sqlInjectionModule.startMonitoring();
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
  name: "AnonimusInnerClasses",
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
        {item: 'First module alredy to work!', name: 'First module alredy to work!'},
        {item: 'Second module alredy to work! ', name: 'Second module alredy to work! '},
        {
          item: 'First module alredy to work! Second module alredy to work!',
          name: 'First module alredy to work! Second module alredy to work!'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[8].task.answer

          window.frontendData.language.chapters[4].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[8].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[8].task.answer
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
        SomeSecuritySystem generalModule = new SomeSecuritySystem() {
            @Override
            public void startMonitoring() {
                System.out.print("First module alredy to work! ");
            }
        };



        SomeSecuritySystem sqlInjectionModule = new SomeSecuritySystem() {
            @Override
            public void startMonitoring() {
                System.out.print("Second module alredy to work! ");
            }
        };


        generalModule.startMonitoring();
        sqlInjectionModule.startMonitoring();
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

    let themeToClose = document.getElementById('java-5-chapter-3-theme-3-subtheme');

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