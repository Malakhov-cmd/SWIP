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
          Простая программа на Java
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Рассмотрим самую простую программу, какую только можно написать на Java.
              В процессе выполнения она лишь выводит сообщение на консоль.
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">FirstSample</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(String[] args)</span>
    </span>{
        System.out.println(<span class="hljs-string"
                                 style="color: rgb(86, 140, 59);">"We will not use'Hello, World!'"</span>);
    }
}</pre>

            <p>Этому примеру стоит посвятить столько времени, сколько потребуется, чтобы привыкнуть к особенностям
              языка и рассмотреть характерные черты программ
              на Java, которые будут еще не раз встречаться во всех приложениях. Прежде всего
              следует обратить внимание на то, что в языке Java учитывается регистр символов. Так,
              если вы перепутаете их (например, наберете Main вместо main), рассматриваемая
              здесь программа выполняться не будет.
            </p>
            <p>
              А теперь проанализируем исходный код данной программы построчно. Ключевое слово p u blic называется
              модификатором доступа. Такие модификаторы управляют обращением к коду из других частей программы. Более
              подробно этот вопрос
              будет рассматриваться в главе 5. Ключевое слово c la s s напоминает нам, что все
              элементы программ на Java находятся в составе классов. Классы будут подробно обсуждаться в следующей
              главе, а до тех пор будем считать их некими контейнерами,
              в которых реализована программная логика, определяющая порядок работы приложения. Классы являются
              стандартными блоками, из которых состоят все приложения
              и аплеты, написанные на Java. Все, что имеется в программе на Java, должно находиться внутри класса.
            </p>
            <p>
              <i>
                Язык Java легко выучить.
              </i>
            </p>
            <p>После ключевого слова <i>class</i>> следует имя класса. Правила составления имен классов не слишком
              строги.
              Имя должно начинаться с буквы, а остальная его часть может
              представлять собой произвольное сочетание букв и цифр. Длина имени не ограничена. В качестве имени класса
              нельзя использовать зарезервированные слова языка Java
              (например, <i>public или class</i>). (Список зарезервированных слов приведен в приложении к этому тому
              данной книги.)
            </p>
            <p>
              Согласно принятым условным обозначениям, имя класса должно начинаться
              с прописной буквы (именно так сформировано имя <i>FirstSample</i>). Если имя состоит
              из нескольких слов, каждое из них должно начинаться с прописной буквы. (Это так
              называемое смешанное написание в "верблюжьем стиле" — <i>CamelCase</i>.)
            </p>
            <p>Файл, содержащий исходный текст, должен называться так же, как и открытый
              (public) класс, и иметь расширение <b>.java</b>. Таким образом, код рассматриваемого
              здесь класса следует разместить в файле <i>FirstSample.java</i>. (Как упоминалось выше,
              регистр символов непременно учитывается, поэтому имя <i>firstsample.java</i> для обозначения исходного
              файла
              рассматриваемой здесь программы не годится.)
            </p>
            <p>
              Если вы правильно назвали файл и не допустили ошибок в исходном тексте программы, то в результате
              компиляции получите файл, содержащий байт-код данного
              класса. Компилятор Java автоматически назовет этот файл <i>FirstSample.class</i> и сохранит его в том же
              каталоге, где находится исходный файл. Осталось лишь запустить
              программу на выполнение с помощью загрузчика Java, набрав следующую команду:
              <b>java FirstSample</b>
            </p>
            <p>(Расширение . class не указывается!) При выполнении этой программы на экран
              выводится символьная строка <i>"We will not use ’Hello, World’!"</i> (Мы не будем пользоваться избитой
              фразой
              "Здравствуй, мир!").
            </p>
            <p>Когда для запуска скомпилированной программы на выполнение используется
              команда
              <b>java ИмяКласса</b></p>
            <p>
              виртуальная машина Java всегда начинает свою работу с выполнения метода <i>main</i> ()
              указанного класса (Термином метод в Java принято обозначать функцию.) Следовательно, для нормального
              выполнения программы в классе должен присутствовать
              метод <i>main()</i>. Разумеется, в класс можно добавить и другие методы и вызывать их из
              метода<i>main()</i>.
            </p>
            <p>Обратите внимание на фигурные скобки в исходном коде рассматриваемой здесь
              программы. В Java, так же, как и в C/C++, фигурные скобки используются для выделения блоков программы. В
              языке Java код любого метода должен начинаться с открывающей фигурной скобки ( 0 и завершаться
              закрывающей фигурной скобкой (}).
            </p>
            <p>Стиль расстановки фигурных скобок всегда вызывал споры. Обычно мы стараемся
              располагать скобки одну под другой, выравнивая их с помощью пробелов. А поскольку
              пробелы не имеют значения для компилятора Java, вы можете употреблять какой угодно вам стиль расположения
              фигурных скобок. В дальнейшем, рассматривая различные
              операторы цикла, мы обсудим применение фигурных скобок более подробно</p>
            <p>
              Можете пока что не обращать внимания на ключевые слова static void, считая
              их просто необходимой частью программы на Java. К концу главы 3 вам полностью
              раскроется подлинный смысл этих ключевых слов. А до тех пор запомните, что каждое приложение на Java
              должно непременно содержать метод <i>main()</i>, объявление
              которого приведено ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> ИмяКласса </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(String[] args)</span> </span>{
        операторы программы;
    }
}</pre>
            <p>Обратите внимание на следующий фрагмент кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">{
    System.out.println(<span class="hljs-string"
                             style="color: rgb(86, 140, 59);">"We will not use’Hello, World!'"</span>);
}</pre>
            <p>
              Фигурные скобки обозначают начало и конец тела метода, которое в данном
              случае состоит из единственной строки кода. Как и в большинстве других языков
              программирования, операторы Java можно считать равнозначными предложениям
              в обычном языке. В языке Java каждый оператор должен непременно оканчиваться
              точкой с запятой. В частности, символ конца строки не означает конец оператора,
              поэтому оператор может занимать столько строк, сколько потребуется.
            </p>
            <p>В рассматриваемом здесь примере кода при выполнении метода main() на консоль выводится одна текстовая
              строка. Для этой цели используется объект System,
              out и вызывается его метод println(). Обратите внимание на то, что метод отделяется от объекта точкой. В
              общем случае вызов метода в Java принимает приведенную
              ниже синтаксическую форму, что равнозначно вызову функции:
            </p>
            <p>
              <i>
                объект.метод(параметры)
              </i>
            </p>
            <p>В данном примере при вызове метода println () в качестве параметра ему передается символьная строка.
              Этот метод выводит символьную строку на консоль, дополняя ее символом перевода строки. В языке Java, как
              и в C/C++, строковый литерал заключается в двойные кавычки. (Порядок обращения с символьными строками
              будет рассмотрен далее в этой главе.)
            </p>
            <p>Методам в Java, как и функциям в любом другом языке программирования, можно вообще не передавать
              параметры или же передавать один или несколько параметров, которые иногда еще называют аргументами. Даже
              если у метода отсутствуют
              параметры, после его имени обязательно ставят пустые скобки. Например, при вызове метода <i>println()</i>
              без
              параметров на экран выводится пустая строка. Такой вызов
              выглядит следующим образом:
            </p>
            <p>
              <i>
                System.out.println();
              </i>
            </p>
          </div>
          <div class="page-theme-author-text text-white-50">
            Приведенный материал был взят из книги "Java. Библиотека профессионала, том 1.", написанной Кейем С.
            Хорстманном.
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Видоизмените программу так, чтобы она выводила "It's Java"
        </label>

        <textarea id="codeContentId">
public class FirstSample
{
   public static void main(String[] args)
   {
      System.out.println("We will not use'Hello, World!'");
   }
}
        </textarea>
      </div>

      <div v-show="!showInput">
        <label class="page-theme-question-text">
          Видоизмените программу так, чтобы она выводила "It's Java"
        </label>
        <p class="page-theme-theory-text">
          Ваш ответ:
        </p>
        <textarea id="codeContentIdAnswered"></textarea>
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

let tempAnswer = []
let tempValue = 'public class FirstSample\n' +
    '{\n' +
    '   public static void main(String[] args)\n' +
    '   {\n' +
    '      System.out.println("We will not use\'Hello, World!\'");\n' +
    '   }\n' +
    '}'
let isSendedandrecived = false

export default {
  name: "SimpleProgramExample",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null
    }
  },
  methods: {
    Request() {
      console.log(tempValue)
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 1,
          answer: tempValue,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[0].finished = true

              tempAnswer = response.data

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          this.answer = window.frontendData.language.chapters[1].listThemes[0].task.answer

          this.codeAnsweredContent.setValue(this.answer)

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
      setTimeout(() => {
        $('.CodeMirror').each(function(i, el){
          el.CodeMirror.refresh();
        });
      }, 1000)
    },
  },
  mounted() {

    if (window.frontendData.language.chapters[1].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[0].task.answer
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

    if (this.answer.length !== 0) {
      this.codeContent.setValue(this.answer)
      this.codeAnsweredContent.setValue(this.answer)
    }

    this.codeContent.on('change', function (cm) {
      tempValue = cm.getValue();
    })

    setTimeout(() => {
      $('.CodeMirror').each(function(i, el){
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-1-theme');

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