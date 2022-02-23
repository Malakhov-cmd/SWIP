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
          Обобщенное программирование
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Обобщенные классы представляют собой наиболее значительное изменение
              в программировании на Java с момента выпуска версии 1.0. Появление обобщений
              в версии Java 5.0 SE стало результатом реализации самых первых требований к спецификации Java (Java
              Specification Requests — JSR 14), которые были сформулированы
              еще в 1999 г. Группа экспертов потратила около пяти лет на разработку спецификаций и тестовые реализации.

            </p>

            <p>
              Обобщения понадобились потому, что они позволяют писать более безопасный
              код, который легче читается, чем код, перегруженный переменными типа Object
              и приведениями типов. Обобщения особенно полезны для классов коллекций вроде
              вездесущего класса ArrayList.

            </p>

            <p>Обобщения похожи, по крайней мере, внешне, на шаблоны в C++. В языке C++,
              как и в Java, шаблоны впервые были внедрены для поддержки строго типизированных коллекций. Но с годами им
              были найдены и другие применения. Проработа материал этой главы, вы, возможно, найдете новые, ранее
              неизвестные применения
              обобщениям в своих программах.


            </p>
            <p>Назначение обобщенного программирования

            </p>
            <p>
              Обобщенное программирование означает написание кода, который может быть неоднократно использован с
              объектами самых разных типов. Так, если нет желания программировать отдельные классы для составления
              коллекций из объектов типа String
              и File, достаточно собрать эти объекты в коллекцию, воспользовавшись единственным обобщенным классом
              ArrayList. И это всего лишь один простой пример обобщенного программирования.

            </p>
            <p>
              Фактически класс ArrayList имелся в Java еще до появления обобщенных классов. Итак, исследуем механизм
              обобщенного программирования и его назначение
              как для тех, кто его реализует, так и для тех, кто им пользуется.
            </p>

            <p>
              Преимущества параметров типа
            </p>

            <p>
              До внедрения обобщенных классов в версии Java SE 5.0 обобщенное программирование на Java всегда
              реализовывалось посредством наследования. Так, в классе ArrayList
              просто поддерживался массив ссылок на класс Object следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">ArrayList</span> // до появления обобщенных классов
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Object[] elementData;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Object <span
        class="hljs-title" style="color: rgb(37, 127, 173);">get</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(<span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> i)</span> </span>{ . . . }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">add</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(Object o)</span> </span>{ . . . }
}</pre>
            <p>
              Такой подход порождает две серьезные проблемы. Всякий раз, когда извлекается
              значение, необходимо выполнить приведение типа, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ArrayList files = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ArrayList();
String filename = (String) files.get(<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);</pre>
            <p>
              Более того, в таком коде отсутствует проверка ошибок. Ничто не мешает добавить
              значения любого класса следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">files.add(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> File(<span class="hljs-string"
                                                                                              style="color: rgb(86, 140, 59);">". . ."</span>));</pre>

            <p>
              Этот вызов компилируется и выполняется без ошибок. Но затем попытка привести результат выполнения метода
              get () к типу String приведет к ошибке.
            </p>
            <p>
              Обобщения предлагают лучшее решение: параметры типа. Класс ArrayList теперь
              принимает параметр типа, обозначающий тип элементов коллеции, как показано
              ниже. Благодаря этому код получается более удобочитаемым. Теперь становится сразу
              понятно, что этот конкретный списочный массив содержит объекты типа String.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ArrayList&lt;String&gt; files = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ArrayList&lt;Stnng&gt; () ;</pre>

            <p>
              Данные о типах могут быть полезными и для компилятора. Так, в приведенном
              ниже вызове метода get () никакого приведения типов не требуется. Ведь компилятору известно, что
              возвращаемым типом является String, а не Object.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String filename = files.get(<span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);</pre>

            <p>
              Компилятору также известно, что у метода add () из класса ArrayList< String > имеется параметр типа
              String. Эго намного безопаснее, чем иметь дело с параметром типа
              Object. Теперь компилятор может проконтролировать, не подставлен ли объект неверного типа в исходном
              коде. Например, следующая строка кода не скомпилируется:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">files. add (<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> File(<span class="hljs-string"
                                                                                              style="color: rgb(86, 140, 59);">". . ."</span>)); <span
                class="hljs-comment"
                style="color: rgb(113, 149, 168);">// в коллекцию типа ArrayList&lt;String&gt;</span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// можно вводить только объекты типа String</span></pre>

            <p>
              Ошибка компиляции — это намного лучше, чем исключение в связи с неправильным приведением типов во время
              выполнения. Привлекательность параметров типа
              в том и состоит, что они делают исходный код программы более удобочитаемым
              и безопасным.
            </p>
            <p>
              На кого рассчитано обобщенное программирование

            </p>
            <p>
              Пользоваться такими обобщенными классами, как ArrayList, очень просто. И большинство программирующих на
              Java просто применяют типы вроде
              ArrayList< String >, как будто они являются такой же неотъемлемой частью языка
              Java, как и массивы типа String [ ]. (Разумеется, списочные массивы лучше простых
              массивов, поскольку они допускают автоматическое расширение.)
            </p>
            <p>
              Но реализовать обобщенный класс не так-то просто. Те, кто будет пользоваться
              обобщенным кодом, попытаются подставлять всевозможные классы вместо предусмотренных параметров типа. Они
              надеются, что все будет работать без досадных
              ограничений и запутанных сообщений об ошибках. Поэтому главная задача обобщенно программирующего —
              предвидеть все возможные в дальнейшем варианты
              применения разработанного им обобщенного класса.

            </p>
            <p>
              Насколько трудно этого добиться? Приведем пример типичного затруднения, которое пришлось преодолевать
              разработчикам стандартной библиотеки классов Java.
              Класс ArrayList содержит метод addAll (), предназначенный для добавления элементов из другой коллекции.
              Так, у программиста может возникнуть потребность
              добавить все элементы из коллекции типа ArrayList< Manager > в коллекцию типа
              ArrayList< Employee >. Но обратное, разумеется, недопустимо. Как же разрешить
              один вызов и запретить другой? Создатели Java нашли искусный выход из этого затруднительного положения,
              внедрив понятие подстановочного типа. Подстановочные
              типы довольно абстрактны, но они позволяют разработчику библиотеки сделать методы как можно более
              гибкими.

            </p>
            <p>
              Обобщенное программирование разделяется на три уровня квалификации. На
              элементарном уровне можно просто пользоваться обобщенными классами (как правило, коллекциями типа
              ArrayList, даже не задумываясь, как они работают). Большинство прикладных программистов предпочитают
              оставаться на этом уровне до тех
              пор, пока дело не заладится. Сочетая разные обобщенные классы или же имея дело
              с унаследованным кодом, в котором ничего неизвестно о параметрах типа, можно
              столкнуться с непонятным сообщением об ошибках. В подобной ситуации нужно
              иметь достаточно ясное представление об обобщениях в Java, чтобы устранить неполадку системно, а не
              "методом тыка". И, наконец, можно решиться на реализацию
              своих собственных обобщенных классов и методов.

            </p>
            <p>
              Прикладным программистам, вероятнее всего, не придется писать много обобщенного кода. Разработчики JDK
              уже выполнили самую трудную работу и предусмотрели параметры типа для всех классов коллекций. В связи с
              этим можно сформулировать следующее эмпирическое правило: от применения параметров типа выигрывает
              только тот код, в котором традиционно присутствует много операций приведения
              от самых общих типов, как, например, класс Object или интерфейс Comparable.

            </p>
            <p>
              В этой главе поясняется все, что следует знать для реализации собственного обобщенного кода. Надеемся,
              однако, что читатели воспользуются почерпнутыми из этой
              главы знаниями, прежде всего, для отыскания причин неполадок в своих программах, а также для
              удовлетворения любопытства относительно внутреннего устройства
              параметризованных классов коллекций.
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
          Зачем стоит использовать обощенный стиль программирования?
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
          Зачем стоит использовать обощенный стиль программирования?
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
  name: "DeclarationGeneric",
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

      selected: 'Для использования класса с различными типами',
      options: [
        {item: 'Для использования класса с различными типами', name: 'Для использования класса с различными типами'},
        {item: 'Для упрощение кодовой базы', name: 'Для упрощение кодовой базы'},
        {
          item: 'Для повсеместной оптимизации',
          name: 'Для повсеместной оптимизации'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[0].task.answer

          window.frontendData.language.chapters[6].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-7-chapter-1-theme');

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