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
          Классы перечислений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как упоминалось в главе 3, начиная с версии Java SE 5.0, в Java поддерживаются
              перечислимые типы. Ниже приведен характерный пример применения перечислимых типов в коде.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">enum</span> Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };</pre>

            <p>
              Тип, объявленный подобным образом, на самом деле представляет собой класс.
              Допускается существование всего четырех экземпляров указанного класса перечисления. Другие объекты в
              таком классе создать нельзя.
            </p>
            <p>
              Таким образом, для проверки перечислимых значений на равенство совсем не
              обязательно использовать метод equals (). Для этой цели вполне подойдет операция — . По желанию в классы
              перечислимых типов можно добавить конструкторы,
              методы и поля. Очевидно, что конструкторы мшут вызываться только при создании
              констант перечислимого типа. Ниже приведен соответствующий тому пример.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">enum</span> Size
{
    SMALL(<span class="hljs-string" style="color: rgb(86, 140, 59);">"S"</span>), MEDIUM(<span class="hljs-string"
                                                                                               style="color: rgb(86, 140, 59);">"M"</span>), LARGE(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"L"</span>), EXTRA_LARGE(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"XL"</span>);
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String abbreviation;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Size</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(String abbreviation)</span>
    </span>{ <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.abbreviation = abbreviation; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getAbbreviation</span><span class="hljs-params"
                                                                                         style="color: rgb(147, 92, 37);">()</span> </span>{ <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> abbreviation; }
}</pre>
            <p>
              Все перечислимые типы реализуются с помощью подклассов, производных
              от класса Enum. Они наследуют от этого класса ряд методов. Наиболее часто применяется метод toStringO,
              возвращающий имя константы перечислимого типа.
              Так, при вызове метода Size. SMALL. toString () возвращается символьная строка
              "SMALL". Статический метод valueOf () выполняет действия, противоположные методу toStringO. Например, в
              результате выполнения приведенной ниже строки
              кода переменной s будет присвоено значение Size. SMALL.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Size s = (Size) Enum.valueOf(Size.class, <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"SMALL"</span>);
</pre>
            <p>
              Каждый перечислимый тип содержит статический метод values (), который возвращает массив всех перечислимых
              значений. Так, в результате следующего вызова:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Size [] values = Size.values()</pre>
            <p>
              возвращается массив констант перечислимого типа Size. SMALL, Size.MEDIUM,
              Size.LARGE и Size.EXTRA_LARGE.

            </p>
            <p>
              Метод ordinal () возвращает позицию константы в объявлении перечислимого
              типа, начиная с нуля. Например, в результате вызова Size.MEDIUM.ordinal () возвратится значение 1.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">hashCode</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Objects.hash(name, salary, hireDay);
}
</pre>
            <p>
              Методы equals () и hashCode () должны быть совместимы: если в результате вызова х .equals (у)
              возвращается логическое значение true, то и результаты вызовов
              . hashCode () и у . hashCode () также должны совпадать. Так, если в методе Employee.
              equals () сравниваются идентификационные номера работников, то при вычислении
              хеш-кода методу hashCode () также потребуются идентификационные номера, но не
              имя работника и не адрес памяти, занимаемой соответствующим объектом.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> enums;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates enumerated types.
 * <span class="hljs-doctag">@version</span> 1.0 2004-05-24
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">EnumTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Scanner in = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Scanner(System.in);
      System.out.print(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) "</span>);
      String input = in.next().toUpperCase();
      Size size = Enum.valueOf(Size.class, input);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"size="</span> + size);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"abbreviation="</span> + size.getAbbreviation());
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (size == Size.EXTRA_LARGE)
         System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Good job--you paid attention to the _."</span>);
   }
}

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">enum</span> Size
{
   SMALL(<span class="hljs-string" style="color: rgb(86, 140, 59);">"S"</span>), MEDIUM(<span class="hljs-string"
                                                                                              style="color: rgb(86, 140, 59);">"M"</span>), LARGE(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"L"</span>), EXTRA_LARGE(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"XL"</span>);

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Size</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String abbreviation)</span> </span>{ <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.abbreviation = abbreviation; }
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getAbbreviation</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span> </span>{ <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> abbreviation; }

   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String abbreviation;
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
        System.out.println(States.values()[1].getState());
    }
}

public enum States {
    Cal("California"),
    Tex("Texas"),
    Alb("Alabama");

    private String state;

    States(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
  name: "EnumClasses",
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

      selected: 'California',
      options: [
        {item: 'California', name: 'California'},
        {item: 'Texas', name: 'Texas'},
        {item: 'Alabama', name: 'Alabama'},
        {item: 'NPE', name: 'NPE'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 14,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[13].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[13].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[13].task.answer

          window.frontendData.language.chapters[3].listThemes[13].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[13].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[13].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[13].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[13].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[13].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[13].task.answer
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
        System.out.println(States.values()[1].getState());
    }
}

public enum States {
    Cal("California"),
    Tex("Texas"),
    Alb("Alabama");

    private String state;

    States(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    let themeToClose = document.getElementById('java-4-chapter-6-theme');

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