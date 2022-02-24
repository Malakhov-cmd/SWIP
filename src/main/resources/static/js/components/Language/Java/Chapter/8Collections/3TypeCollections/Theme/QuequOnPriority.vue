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
          Очереди по приоритету
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В очередях по приоритету элементы извлекаются в отсортированном порядке после того, как они были введены
              в произвольном порядке. Следовательно, в результате
              каждого вызова метода remove () получается наименьший из элементов, находящихся в очереди. Но в очереди
              по приоритету сортируются не все ее элементы. Если выполняется перебор элементов такой очереди, они
              совсем не обязательно оказываются
              отсортированными. В очереди по приоритету применяется изящная и эффективная
              структура данных — так называемая "куча" — это самоорганизующееся двоичное дерево, в котором операции
              ввода и удаления вызывают перемещение наименьшего
              элемента в корень, не тратя времени на сортировку всех элементов очереди.

            </p>
            <p>
              Подобно древовидному множеству, очередь по приоритету может содержать элементы класса, реализующего
              интерфейс Comparable, или же принимать объект типа
              Comparator, предоставляемый конструктору ее класса. Как правило, очередь по приоритету применяется для
              планирования заданий на выполнение. У каждого задания имеется
              свой приоритет. Задания вводятся в очередь в случайном порядке. Когда новое задание
              может быть запущено на выполнение, наиболее высокоприоритетное задание удаляется
              из очереди. (По традиции приоритет 1 считается наивысшим, поэтому в результате операции удаления из
              очереди извлекается элемент с наименьшим приоритетом.)

            </p>
            <p>
              В примере программы из листинга 9.5 демонстрируется применение очереди
              по приоритету непосредственно в коде. В отличие от перебора элементов древовидного множества, в данном
              примере элементы очереди не перебираются в отсортированном порядке. Но удаление из очереди по приоритету
              всегда касается ее наименьшего элемента.

            </p>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> priorityQueue;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of a priority queue.
 * <span class="hljs-doctag">@version</span> 1.02 2015-06-20
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">PriorityQueueTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      PriorityQueue&lt;LocalDate&gt; pq = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> PriorityQueue&lt;&gt;();
      pq.add(LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1906</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">9</span>)); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// G. Hopper</span>
      pq.add(LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1815</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">10</span>)); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// A. Lovelace</span>
      pq.add(LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1903</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">3</span>)); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// J. von Neumann</span>
      pq.add(LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1910</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">6</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">22</span>)); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// K. Zuse</span>

      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Iterating over elements..."</span>);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (LocalDate date : pq)
         System.out.println(date);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Removing elements..."</span>);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (!pq.isEmpty())
         System.out.println(pq.remove());
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
        Queue<Task<String>> taskQueue = new PriorityQueue<>(
                Arrays.asList(
                        new Task<>(1L,"4 * 4", "16")
                )
        );

        Task<String> task1 = new Task<>(2L,"4 + 4", "8");
        Task<String> task2 = new Task<>(3L,"4 + 4", "8");

        taskQueue.add(task1);
        taskQueue.add(task2);

        System.out.println(taskQueue.element().getId());

    }
}

class Task<T> implements Comparable<Task<T>> {
    private Long id;
    private String question;
    private T answer;

    public Task(Long id, String question, T answer) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Task<T> o) {
        return Long.compare(getId(), o.getId());
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
  name: "QuequOnPriority",
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
        {item: '1', name: '1'},
        {item: '2', name: '2'},
        {item: '3', name: '3'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 10,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[9].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 11.1
              window.frontendData.language.chapters[7].listThemes[9].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[9].task.answer

          window.frontendData.language.chapters[7].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[9].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[9].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[9].task.answer
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
        Queue<Task<String>> taskQueue = new PriorityQueue<>(
                Arrays.asList(
                        new Task<>(1L,"4 * 4", "16")
                )
        );

        Task<String> task1 = new Task<>(2L,"4 + 4", "8");
        Task<String> task2 = new Task<>(3L,"4 + 4", "8");

        taskQueue.add(task1);
        taskQueue.add(task2);

        System.out.println(taskQueue.element().getId());

    }
}

class Task<T> implements Comparable<Task<T>> {
    private Long id;
    private String question;
    private T answer;

    public Task(Long id, String question, T answer) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Task<T> o) {
        return Long.compare(getId(), o.getId());
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

    let themeToClose = document.getElementById('java-8-chapter-3-theme-6-subtheme');

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