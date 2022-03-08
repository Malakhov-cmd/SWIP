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
          Пакеты
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Язык Java позволяет объединять классы в наборы, называемые пакетами. Пакеты
              облегчают организацию работы и позволяют отделить классы, созданные одним разработчиком, от классов,
              разработанных другими. Стандартная библиотека Java содержит большое количество пакетов, в том числе
              java.lang, java.util, java.net и т.д.
              Стандартные пакеты Java представляют собой иерархические структуры. Подобно
              каталогам на диске компьютера, пакеты мшут быть вложены один в другой. Все стандартные пакеты относятся к
              иерархиям пакетов java и javax.

            </p>
            <p>
              ЯПакеты служат в основном для обеспечения однозначности имен классов. Допустим,
              двух программистов осенила блестящая идея создать класс Employee. Если оба класса
              будут находиться в разных пакетах, конфликт имен не возникнет. Чтобы обеспечить
              абсолютную однозначность имени пакета, рекомендуется использовать доменное имя
              компании в Интернете, записанное в обратном порядке (оно по определению единственное в своем роде). В
              составе пакета можно создавать подпакеты и использовать
              их в разных проектах. Рассмотрим в качестве примера домен horstmann.com, зарегистрированный автором
              данной книги. Записав это имя в обратном порядке, можно
              использовать его как название пакета — com.horstmann. В дальнейшем в этом пакете
              можно создать подпакет, например com. horstmann. core java.

            </p>
            <p>
              Единственная цель вложенных пакетов — гарантировать однозначность имен.
              С точки зрения компилятора между вложенными пакетами отсутствует какая-либо
              связь. Например, пакеты java.util и java.util, jar вообще не связаны друг с другом. Каждый из них
              представляет собой независимую коллекцию классов.

            </p>
            <p>
              Импорт классов
            </p>

            <p>
              классе могут использоваться все классы из собственного пакета и все открытые
              классы из других пакетов. Доступ к классам из других пакетов можно получить двумя способами. Во-первых,
              перед именем каждого класса можно указать полное имя
              пакета, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">}ava.time.LocalDate today = java.time.LocalDate.now() </pre>

            <p>
              Очевидно, что этот способ не совсем удобен. Второй, более простой и распространенный способ
              предусматривает применение ключевого слова import. В этом случае
              имя пакета указывать перед именем класса необязательно.
            </p>
            <p>
              Импортировать можно как один конкретный класс, так и пакет в целом. Операторы import следует разместить в
              начале исходного файла (после всех операторов
              package). Например, все классы из пакета java.time можно импортировать следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;</pre>

            <p>
              После этого имя пакета не указывается, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">LocalDate today = LocalDate.now();
</pre>
            <p>
              Отдельный класс можно также импортировать из пакета следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.LocalDate;</pre>

            <p>
              Проще импортировать все классы, например, из пакета java.time.*. На объем
              кода это не оказывает никакого влияния. Но если указать импортируемый класс явным образом, то читающему
              исходный код программы станет ясно, какие именно
              классы будут в ней использоваться.
            </p>
            <p>
              Следует, однако, иметь в виду, что оператор import со звездочкой можно применять для импорта только
              одного пакета. Но нельзя использовать оператор import
              java . * или import ja v a . * . *, чтобы импортировать все пакеты, имена которых содержат префикс jav
              a. В большинстве случаев импортируется весь пакет, независимо от его размера. Единственный случай, когда
              следует обратить особое внимание
              на пакет, возникает при конфликте имен. Например, оба пакета, java.util и java ,
              sql, содержат класс Date. Допустим, разрабатывается программа, в которой оба эти
              пакета импортируются следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.sql.*;
</pre>
            <p>
              Если теперь попытаться воспользоваться классом Date, возникнет ошибка компиляции:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Date today; <span
                class="hljs-comment"
                style="color: rgb(113, 149, 168);">// ОШИБКА: неясно, какой именно выбрать пакет:</span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// java.util.Date или java.sql.date?</span>
</pre>
            <p>
              Компилятор не в состоянии определить, какой именно класс Date требуется
              в программе. Разрешить это затруднение можно, добавив уточняющий оператор
              import следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.sql.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.Date;</pre>
            <p>
              А что, если на самом деле нужны оба класса Date? В этом случае нужно указать
              полное имя пакета перед именем каждого класса, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">java.util.Date deadline = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> java.util.Date();
java.sql.Date today = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> java.sql.Date();
</pre>

            <p>
              Обнаружение классов в пакетах входит в обязанности компилятора. В байт-кодах,
              находящихся в файлах классов, всегда содержатся полные имена пакетов.
            </p>
            <p>
              Статический импорт
            </p>
            <p>
              Имеется форма оператора import, позволяющая импортировать не только классы, но и статические методы и
              поля. Допустим, в начале исходного файла введена
              следующая строка кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> java.lang.System.*;</pre>
            <p>
              Это позволит использовать статические методы и поля, определенные в классе
              System, не указывая имени класса:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">out.println(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Goodbye, World!"</span>); <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// вместо System.out</span>
exit(O); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// вместо System.exit</span></pre>

            <p>
              Ввод классов в пакеты
            </p>
            <p>
              Чтобы ввести класс в пакет, следует указать имя пакета в начале исходного файла
              перед определением класса. Например, исходный файл Employee. java из листинга начинается следующими
              строками кода:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.corejava;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Employee</span>
</span>{
    ...
}</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> com.horstmann.corejava.*;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// the Employee class is defined in that package</span>

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(107, 107, 184);">static</span> java.lang.System.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of packages.
 * <span class="hljs-doctag">@version</span> 1.11 2004-02-19
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">PackageTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// because of the import statement, we don't have to use </span>
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// com.horstmann.corejava.Employee here</span>
      Employee harry = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">50000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1989</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">10</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>);

      harry.raiseSalary(<span class="hljs-number" style="color: rgb(147, 92, 37);">5</span>);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// because of the static import statement, we don't have to use System.out here</span>
      out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"name="</span> + harry.getName() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span> + harry.getSalary());
   }
}
</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.corejava;

<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// the classes in this file are part of this package</span>

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;

<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// import statements come after the package statement</span>

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * <span class="hljs-doctag">@version</span> 1.11 2015-05-08
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> LocalDate hireDay;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String name, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary, <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">int</span> year, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> month, <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> day)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.salary = salary;
      hireDay = LocalDate.of(year, month, day);
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

   <span class="hljs-function"><span class="hljs-keyword"
                                     style="color: rgb(107, 107, 184);">public</span> LocalDate <span class="hljs-title"
                                                                                                      style="color: rgb(37, 127, 173);">getHireDay</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> hireDay;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">raiseSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">double</span> byPercent)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> raise = salary * byPercent / <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100</span>;
      salary += raise;
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
          Для чего нужны пакеты?
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
          Для чего нужны пакеты?
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
  name: "Packets",
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

      selected: 'Дополнительная маркировка для класса',
      options: [
        {item: 'Дополнительная маркировка для класса', name: 'Дополнительная маркировка для класса'},
        {item: 'Использование классов находящихся в других папках', name: 'Использование классов находящихся в других папках'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 20,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[19].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[19].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[19].task.answer

          window.frontendData.language.chapters[2].listThemes[19].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[19].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[19].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[19].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[19].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[19].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[19].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-7-theme');

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