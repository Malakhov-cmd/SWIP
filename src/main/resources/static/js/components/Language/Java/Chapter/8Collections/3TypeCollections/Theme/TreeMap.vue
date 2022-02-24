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
          Древовидные множества
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Класс TreeSet реализует древовидное множество, подобное хеш-множеству, но
              с одним дополнительным усовершенствованием: древовидное множество представляет собой отсортированную
              коллекцию. В такую коллекцию можно вводить элементы
              в любом порядке. Когда же выполняется перебор ее элементов, извлекаемые из нее
              значения оказываются автоматически отсортированными. Допустим, в такую коллекцию сначала введены три
              символьные строки, а затем перебраны все введенные в нее
              элементы:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">SortedSet&lt;String&gt; sorter = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TreeSet&lt;&gt;();
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// объект типа TreeSet, реализующий отсортированную коллекцию </span>
sorter.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Bob"</span>);
sorter.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Ашу"</span>);
sorter.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Carl"</span>) ;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (String s : sorter) System.println(s);</pre>
            <p>
              Полученные в итоге значения выводятся в отсортированном порядке: Amy, Bob,
              Carl. Как следует из имени класса TreeSet, сортировка обеспечивается древовидной
              структурой данных. (В текущей реализации используется структура так называемого
              красно-черного дерева. Подробное описание древовидных структур данных приведено
              в книге Алгоритмы: построение и анализ. 2-е издание. Томас X. Кормен, Чарльз И. Лейзерсон, Рональд Л.
              Ривест, Клиффорд Штайн (ИД "Вильямс", 2013 г.) Всякий раз при
              вводе элемента в древовидное множество он размещается на правильно отсортированной позиции. Таким
              образом, итератор всегда перебирает элементы такого множества в отсортированном порядке.


            </p>
            <p>
              Ввод элемента в древовидное множество происходит медленнее, чем в хеш-таблицу, но все же намного быстрее,
              чем в требуемое место массива или связного
              списка. Если древовидное множество состоит из п элементов, то в среднем требуется
              log2n сравнений, чтобы найти правильное расположение нового элемента. Так, если
              древовидное множество уже содержит 1000 элементов, для ввода нового элемент потребует около 10 сравнений.
            </p>
            <p>
              Если вернуться к табл. 9.3, то можно прийти к выводу, что вместо хеш-множества
              всегда следует пользоваться древовидным множеством. Ведь для ввода элементов в такое множество,
              по-видимому, не требуется много времени, а его элементы сортируются автоматически. Выбор одной из этих
              разновидностей множеств зависит от характера накапливаемых данных. Так, если данные не нужно сортировать,
              то и нет никаких
              оснований в излишних затратах на их сортировку. Но важнее другое: отсортировать
              некоторые данные в нужном порядке намного сложнее, чем с помощью хеш-функции.
              Хеш-функция должна лишь достаточно равномерно распределять объекты, тогда как
              функция сравнения — различать объекты с абсолютной точностью.

            </p>
            <p>
              Чтобы сделать такое различие конкретным, рассмотрим задачу составления множества прямоугольников. Если
              воспользоваться для этой цели древовидным множеством
              типа TreeSet, то придется предоставить компаратор типа Comparator< Rectangle >.
              Как же сравнить два прямоугольника? Сравнить их по площади нельзя, поскольку
              могут оказаться два прямоугольника с разными координатами, но одинаковой площадью. Порядок сортировки
              древовидного множества должен быть общим. Два любых
              элемента должны быть сравнимы, и результат сравнения может быть нулевым лишь
              в том случае, если сравниваемые элементы равны. Для прямоугольников имеется способ лексикографического
              упорядочения по координатам, но он кажется неестественным и сложным для вычисления. С другой стороны,
              хеш-функция уже определена
              для класса Rectangle и просто хеширует координаты.


            </p>
            <p>
              В примере программы из листинга строятся два древовидных множества объектов типа Item. Первое из них
              сортируется по номеру изделия в каталоге, т.е. в порядке сортировки, выбираемом по умолчанию для объектов
              типа Item. А второе
              множество сортируется по описанию изделия с помощью специального компаратора. Само же изделие и его номер
              описываются в классе Item из листинга.
            </p>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> treeSet;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program sorts a set of item by comparing their descriptions.
 * <span class="hljs-doctag">@version</span> 1.12 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">TreeSetTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      SortedSet&lt;Item&gt; parts = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TreeSet&lt;&gt;();
      parts.add(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Item(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Toaster"</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">1234</span>));
      parts.add(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Item(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Widget"</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">4562</span>));
      parts.add(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Item(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Modem"</span>, <span class="hljs-number" style="color: rgb(147, 92, 37);">9912</span>));
      System.out.println(parts);

      NavigableSet&lt;Item&gt; sortByDescription = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TreeSet&lt;&gt;(
            Comparator.comparing(Item::getDescription));

      sortByDescription.addAll(parts);
      System.out.println(sortByDescription);
   }
}</pre>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> treeSet;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * An item with a description and a part number.
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Item</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Comparable</span>&lt;<span class="hljs-title" style="color: rgb(37, 127, 173);">Item</span>&gt;
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String description;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> partNumber;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Constructs an item.
    *
    * <span class="hljs-doctag">@param</span> aDescription
    *           the item's description
    * <span class="hljs-doctag">@param</span> aPartNumber
    *           the item's part number
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Item</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String aDescription, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> aPartNumber)</span>
   </span>{
      description = aDescription;
      partNumber = aPartNumber;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Gets the description of this item.
    *
    * <span class="hljs-doctag">@return</span> the description
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span class="hljs-title" style="color: rgb(37, 127, 173);">getDescription</span><span class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> description;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span class="hljs-title" style="color: rgb(37, 127, 173);">toString</span><span class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string" style="color: rgb(86, 140, 59);">"[description="</span> + description + <span class="hljs-string" style="color: rgb(86, 140, 59);">", partNumber="</span> + partNumber + <span class="hljs-string" style="color: rgb(86, 140, 59);">"]"</span>;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">equals</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(Object otherObject)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (<span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span> == otherObject) <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span>;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (otherObject == <span class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>) <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (getClass() != otherObject.getClass()) <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
      Item other = (Item) otherObject;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Objects.equals(description, other.description) &amp;&amp; partNumber == other.partNumber;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">hashCode</span><span class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Objects.hash(description, partNumber);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">compareTo</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(Item other)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> diff = Integer.compare(partNumber, other.partNumber);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> diff != <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span> ? diff : description.compareTo(other.description);
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
        Set<Task<String>> taskSet = new TreeSet<>(
                Arrays.asList(
                        new Task<>(1L,"4 * 4", "16")
                )
        );

        Task<String> task1 = new Task<>(2L,"4 + 4", "8");
        Task<String> task2 = new Task<>(3L,"4 + 4", "8");

        taskSet.add(task1);
        taskSet.add(task2);

        taskSet.forEach( taskItem -> {
            System.out.print(taskItem.getAnswer() + " ");
        });

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
  name: "TreeMap",
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
        {item: '16 8', name: '16 8'},
        {item: '16 8 8', name: '16 8 8'},
        {item: '8 16', name: '8 16'},
        {item: '8 16 16', name: '8 16 16'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/eighthchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[7].task.answer

          window.frontendData.language.chapters[7].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[7].task.answer
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
        Set<Task<String>> taskSet = new TreeSet<>(
                Arrays.asList(
                        new Task<>(1L,"4 * 4", "16")
                )
        );

        Task<String> task1 = new Task<>(2L,"4 + 4", "8");
        Task<String> task2 = new Task<>(3L,"4 + 4", "8");

        taskSet.add(task1);
        taskSet.add(task2);

        taskSet.forEach( taskItem -> {
            System.out.print(taskItem.getAnswer() + " ");
        });

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

    let themeToClose = document.getElementById('java-8-chapter-3-theme-4-subtheme');

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