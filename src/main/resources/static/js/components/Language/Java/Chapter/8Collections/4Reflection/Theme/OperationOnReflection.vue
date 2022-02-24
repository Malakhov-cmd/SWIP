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
          Отображения
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Множество — это коллекция, которая позволяет быстро находить существующий
              элемент. Но для того, чтобы найти такой элемент, нужно иметь его точную копию.
              Это не слишком распространенная операция поиска, поскольку, как правило, имеется некоторая ключевая
              информация, по которой требуется найти соответствующий
              элемент. Для этой цели предназначена структура данных типа отображения. В отображении хранятся пары
              "ключ-значение". Следовательно, значение можно найти,
              если предоставить связанный с ним ключ. Например, можно составить и сохранить
              таблицу записей о сотрудниках, где ключами служат идентификаторы сотрудников,
              а значениями — объекты типа Employee. В последующих разделах поясняется, как
              обращаться с отображениями.


            </p>
            <p>
              Основные операции над отображениями

            </p>
            <p>
              В библиотеке коллекций Java предоставляются две реализации отображений общего назначения: классы HashMap
              и ТгееМар, реализующие интерфейс Мар. Хеш-отображение типа HashMap хеширует ключи, а древовидное
              отображение типа ТгееМар
              использует общий порядок ключей для организации поискового дерева. Функции
              хеширования или сравнения применяются только к ключам. Значения, связанные
              с ключами, не хешируются и не сравниваются.

            </p>
            <p>
              Когда же следует применять хеш-отображение, а когда — древовидное отображение? Как и во множествах,
              хеширование выполняется немного быстрее, и поэтому
              хеш-отображение оказывается более предпочтительным, если не требуется перебирать ключи в отсортированном
              порядке. В приведенном ниже примере кода показано, как организовать хеш-отображение для хранения записей
              о работниках.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;String, Employee&gt; staff = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> HashMap&lt;&gt;();
<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// объект класса HashMap, реализующего интерфейс Map</span>
Employee harry = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>);
staff.put(<span class="hljs-string" style="color: rgb(86, 140, 59);">"987-98-9996"</span>, harry);</pre>
            <p>
              Всякий раз, когда объект вводится в отображение, следует указать и его ключ.
              В данном случае ключом является символьная строка, а соответствующим значением — объект типа Employee.
              Чтобы извлечь объект, нужно использовать (а значит
              запомнить) ключ, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String s = <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"987-98-9996"</span>;
е = staff.get(s); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// получить объект h a rry</span></pre>
            <p>
              Если в отображении отсутствуют данные по указанному ключу, то метод get ()
              возвращает пустое значение null. Обрабатывать возвращаемое пустое значение не
              совсем удобно. Иногда для ключей, отсутствующих в отображении, вполне подходит
              значение по умолчанию, и тогда можно воспользоваться методом getOrDefault ()
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;String, Integer&gt; scores = . . .;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> score = scores.getOrDefault(id, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// получить нулевое значение, если идентификатор отсутствует</span>
</pre>
            <p>
              Ключи должны быть однозначными. Нельзя сохранить два значения по одинаковым ключам. Если дважды вызвать
              метод put () с одним и тем же ключом, то второе
              значение заменит первое. По существу, метод put () возвращает предыдущее значение, сохраненное по ключу,
              указанному в качестве его параметра.

            </p>
            <p>
              Метод remove () удаляет элемент из отображения по заданному ключу, а метод
              size () возвращает количество элементов в отображении.
            </p>
            <p>
              Метод remove () удаляет элемент из отображения по заданному ключу, а метод
              size () возвращает количество элементов в отображении.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">scores.forEach((k, v) -&gt;
System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"key="</span> + k + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">", value="</span> + v))</pre>
            <p>
              В примере программы из листинга 9.6 демонстрируется применение отображения непосредственно в коде.
              Сначала в отображение вводится пара "ключ-значение",
              затем из него удаляется один ключ, а следовательно, и связанное с ним значение. Далее изменяется
              значение, связанное с ключом, вызывается метод get () для нахождения значения и выполняется перебор
              множества элементов отображения.

            </p>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> map;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 * <span class="hljs-doctag">@version</span> 1.12 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">MapTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Map&lt;String, Employee&gt; staff = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> HashMap&lt;&gt;();
      staff.put(<span class="hljs-string" style="color: rgb(86, 140, 59);">"144-25-5464"</span>, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Amy Lee"</span>));
      staff.put(<span class="hljs-string" style="color: rgb(86, 140, 59);">"567-24-2546"</span>, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>));
      staff.put(<span class="hljs-string" style="color: rgb(86, 140, 59);">"157-62-7935"</span>, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Gary Cooper"</span>));
      staff.put(<span class="hljs-string" style="color: rgb(86, 140, 59);">"456-62-5527"</span>, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Francesca Cruz"</span>));

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// print all entries</span>

      System.out.println(staff);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// remove an entry</span>

      staff.remove(<span class="hljs-string" style="color: rgb(86, 140, 59);">"567-24-2546"</span>);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// replace an entry</span>

      staff.put(<span class="hljs-string" style="color: rgb(86, 140, 59);">"456-62-5527"</span>, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Francesca Miller"</span>));

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// look up a value</span>

      System.out.println(staff.get(<span class="hljs-string" style="color: rgb(86, 140, 59);">"157-62-7935"</span>));

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// iterate through all entries</span>

      staff.forEach((k, v) -&gt;
         System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"key="</span> + k + <span class="hljs-string" style="color: rgb(86, 140, 59);">", value="</span> + v));
   }
}

</pre>

            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> map;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * A minimalist employee class for testing purposes.
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Constructs an employee with $0 salary.
    * <span class="hljs-doctag">@param</span> n the employee name
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String name)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
      salary = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span class="hljs-title" style="color: rgb(37, 127, 173);">toString</span><span class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string" style="color: rgb(86, 140, 59);">"[name="</span> + name + <span class="hljs-string" style="color: rgb(86, 140, 59);">", salary="</span> + salary + <span class="hljs-string" style="color: rgb(86, 140, 59);">"]"</span>;
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
        Map<Long, Task<String>> taskMap = new HashMap<>();

        Task<String> task1 = new Task<>("4 + 4", "8");
        Task<String> task2 = new Task<>("4 + 4", "8");

        taskMap.put(1L, task1);
        taskMap.put(2L, task2);

        System.out.println(taskMap.get(2L).getQuestion());

    }
}

class Task<T> {
    private String question;
    private T answer;

    public Task( String question, T answer) {

        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
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
  name: "OperationOnReflection",
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
        {item: '4 + 4', name: '4 + 4'},
        {item: '4', name: '4'},
        {item: '8', name: '8'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 11,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[10].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 11.1
              window.frontendData.language.chapters[7].listThemes[10].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[10].task.answer

          window.frontendData.language.chapters[7].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[10].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[10].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[10].task.answer
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
        Map<Long, Task<String>> taskMap = new HashMap<>();

        Task<String> task1 = new Task<>("4 + 4", "8");
        Task<String> task2 = new Task<>("4 + 4", "8");

        taskMap.put(1L, task1);
        taskMap.put(2L, task2);

        System.out.println(taskMap.get(2L).getQuestion());

    }
}

class Task<T> {
    private String question;
    private T answer;

    public Task( String question, T answer) {

        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
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

    let themeToClose = document.getElementById('java-8-chapter-4-theme-1-subtheme');

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