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
          Внутренние классы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Внутренним называется один класс, определенный в другом классе. А зачем он
              вообще нужен? На то имеются следующие причины.
            </p>
            <ul>
              <li>
                <p>
                  бъект внутреннего класса имеет доступ к данным объекта, в котором он определен, включая закрытые
                  данные.
                </p>
              </li>
              <li>
                <p>
                  Внутренний класс можно скрыть от других классов того же пакета.
                </p>
              </li>
              <li>
                <p>
                  нонимный внутренний класс оказывается удобным в тех случаях, когда требуется определить обратный
                  вызов в процессе выполнения программы, не прибегая к необходимости писать много кода.
                </p>
              </li>
            </ul>
            <p>
              Довольно сложная тема внутренних классов в этом разделе будет обсуждаться
              в следующем порядке.

            </p>

            <ul>
              <li>
                <p>
                  Сначала будет рассмотрен простой пример внутреннего класса, способного обращаться к полям экземпляра
                  внешнего класса.
                </p>
              </li>
              <li>
                <p>
                  Затем будут обсуждаться специальные синтаксические правила, применяемые
                  при объявлении внутренних классов.
                </p>
              </li>
              <li>
                <p>
                  После этого рассматриваются локальные внутренние классы, способные обращаться к локальным переменным
                  в области действия объемлющего класса.
                </p>
              </li>
              <li>
                <p>
                  Затем будет введено понятие анонимного внутреннего класса и показано, как
                  пользоваться такими классами при организации обратных вызовов.
                </p>
              </li>
              <li>
                <p>
                  И наконец, будет показано, как пользоваться статическими внутренними классами для формирования
                  вложенных вспомогательных классов.
                </p>
              </li>
            </ul>
            <p>
              Доступ к состоянию объекта с помощью внутреннего класса
            </p>
            <p>Синтаксис, применяемый для внутренних классов, довольно сложен. Поэтому,
              для того чтобы продемонстрировать применение внутренних классов, рассмотрим
              простой, хотя и надуманный в какой-то степени пример. Итак, реорганизуем класс
              TimerTest из рассмотренного ранее примера, чтобы сформировать из него класс
              TalkingClock. Для организации работы "говорящих часов" применяются два параметра: интервал между
              последовательными сообщениями и признак, позволяющий
              включать или отключать звуковой сигнал. Соответствующий код приведен ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">TalkingClock</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> interval;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">boolean</span> beep;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">TalkingClock</span><span class="hljs-params"
                                                                                      style="color: rgb(147, 92, 37);">(<span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> interval, <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">boolean</span> beep)</span> </span>{ . . .}

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">start</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . .}

    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">TimePrinter</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                  style="color: rgb(37, 127, 173);">ActionListener</span>
    // внутренний класс
    </span>{
    }
}</pre>
            <p>
              Обратите внимание на то, что класс TimePrinter теперь расположен в классе TalkingClock. Это не означает,
              что каждый экземпляр класса TalkingClock
              содержит поле типа TimePrinter. Как станет ясно в дальнейшем, объекты типа
              TimePrinter создаются методами из класса TalkingClock. Рассмотрим класс
              TimePrinter более подробно. В приведенном ниже коде обратите внимание на то,
              что в методе actionPerformed () признак beep проверяется перед тем, как воспроизвести звуковой сигнал.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">TimePrinter</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                style="color: rgb(37, 127, 173);">ActionListener</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">actionPerformed</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span> </span>{
        Date now = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date();
        System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"At the tone, the time is"</span> + now);
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (beep) Toolkit.getDefaultToolkit().beep();
    }
}</pre>

            <p>
              А теперь начинается самое интересное. Нетрудно заметить, что в классе
              TimePrinter отсутствует поле beep. Вместо этого метод actionPerformed () обращается к соответствующему
              полю объекта типа TalkingClock. А это уже нечто новое.
              Обычно метод обращается к полям объекта. Но оказывается, что внутренний класс
              имеет доступ не только к своим полям, но и к полям создавшего его объекта, т.е. экземпляра внешнего
              класса.
            </p>
            <p>
              В определении внутреннего класса эта ссылка не присутствует явно. Чтобы продемонстрировать, каким образом
              она действует, введем в код ссылку outer. Тогда метод
              actionPerformed () будет выглядеть следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">actionPerformed</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span> </span>{
        Date now = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date();
        System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"At the tone, the time is "</span> + now);
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (outer.beep) {
            Toolkit.getDefaultToolkit().beep();
        }
    }</pre>
            <p>
              Ссылка на объект внешнего класса задается в конструкторе. Компилятор видоизменяет все конструкторы
              внутреннего класса, добавляя параметр для ссылки на внешний класс. А поскольку конструкторы в классе
              TalkingClock не определены, то
              компилятор автоматически формирует конструктор без аргументов, генерируя код,
              подобный следующему:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">TimePrinter</span> <span class="hljs-params"
                                                                                              style="color: rgb(147, 92, 37);">(TalkingClock clock)</span> <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// автоматически генерируемый код </span>
</span>{
    outer = clock;
}
</pre>
            <p>
              Еще раз обращаем ваше внимание на то, что слово outer не является ключевым
              в Java. Оно используется только для иллюстрации механизма, задействованного во
              внутренних классах.

            </p>
            <p>
              После того как метод start () создаст объект класса TimePrinter, компилятор
              передаст конструктору текущего объекта ссылку this на объект типа TalkingClock
              следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ActionListener listener = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TimePrinter(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>);
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// параметр добавляется автоматически</span></pre>

            <p>
              В листинге приведен исходный код завершенного варианта программы, проверяющей внутренний класс. Если бы
              TimePrinter был обычным классом, он должен был бы получить доступ к признаку beep через открытый метод из
              класса
              TalkingClock. Применение внутреннего класса усовершенствует код, поскольку отпадает необходимость
              предоставлять специальный метод доступа, представляющий
              интерес только для какого-нибудь другого класса
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> innerClass;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.awt.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.awt.event.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.Timer;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of inner classes.
 * <span class="hljs-doctag">@version</span> 1.11 2015-05-12
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">InnerClassTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      TalkingClock clock = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TalkingClock(<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>, <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">true</span>);
      clock.start();

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
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> interval;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">boolean</span> beep;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Constructs a talking clock
    * <span class="hljs-doctag">@param</span> interval the interval between messages (in milliseconds)
    * <span class="hljs-doctag">@param</span> beep true if the clock should beep
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">TalkingClock</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(<span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> interval, <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">boolean</span> beep)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.interval = interval;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.beep = beep;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Starts the clock.
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">start</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      ActionListener listener = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TimePrinter();
      Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(interval, listener);
      t.start();
   }

   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">TimePrinter</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                  style="color: rgb(37, 127, 173);">ActionListener</span>
   </span>{
      <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
          class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">actionPerformed</span><span
          class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span>
      </span>{
         System.out.println(<span class="hljs-string"
                                  style="color: rgb(86, 140, 59);">"At the tone, the time is "</span> + <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date());
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (beep) Toolkit.getDefaultToolkit().beep();
      }
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
          В каких случаях стоит использовать вложенные классы?
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
          В каких случаях стоит использовать вложенные классы?
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
  name: "AccessToConditionToInnerClasses",
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

      selected: 'Ни в каких',
      options: [
        {item: 'Ни в каких', name: 'Ни в каких'},
        {item: 'При выделении сабсущности в классе', name: 'При выделении сабсущности в классе'},
        {
          item: 'В случае ограниченного количества классов',
          name: 'В случае ограниченного количества классов'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[6].task.answer

          window.frontendData.language.chapters[4].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[6].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-5-chapter-3-theme-1-subtheme');

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