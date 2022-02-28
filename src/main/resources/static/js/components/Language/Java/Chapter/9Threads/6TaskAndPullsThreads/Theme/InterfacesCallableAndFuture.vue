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
          Интерфейсы Callable и Future
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Интерфейс Runnable инкапсулирует задачу, выполняющуюся асинхронно. Его
              можно рассматривать как асинхронный метод без параметров и возвращаемого значения. А интерфейс Callable
              подобен интерфейсу Runnable, но в нем предусмотрен возврат значения. Интерфейс Callable относится к
              параметризованному типу
              и имеет единственный метод call (), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Callable</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">V</span>&gt;
</span>{
     <span class="hljs-function">V <span class="hljs-title" style="color: rgb(37, 127, 173);">call</span><span
         class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                              style="color: rgb(107, 107, 184);">throws</span> Exception</span>;
}
</pre>
            <p>
              Параметр типа обозначает тип возвращаемого значения. Например, интерфейс
              Callable< Integer > представляет асинхронное вычисление, в результате которого
              возвращается объект типа Integer. А сохранение результатов асинхронного вычисления обеспечивает интерфейс
              Future. В частности, вычисление можно начать, предоставив кому-нибудь другому объект типа Future, а затем
              просто забыть о нем.
              Владелец объекта типа Future может получить результат, когда он будет готов. В интерфейсе F u ture
              объявляются следующие методы

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Future</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">V</span>&gt;
</span>{
   <span class="hljs-function">V <span class="hljs-title" style="color: rgb(37, 127, 173);">get</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">throws</span> . . .</span>;
   <span class="hljs-function">V <span class="hljs-title" style="color: rgb(37, 127, 173);">get</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">long</span> timeout, TimeUnit unit)</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> . . .</span>;
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">cancel</span><span class="hljs-params"
                                                                               style="color: rgb(147, 92, 37);">(<span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> maylnterrupt)</span></span>;
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">isCancelled</span><span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">()</span></span>;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> isDoneO;
}</pre>
            <p>
              При вызове первого метода get () блокировка устанавливается до тех пор, пока
              не завершится вычисление. Второй метод g e t () генерирует исключение типа
              TimeoutException, если время ожидания истекает до завершения вычислений. Если
              же прерывается поток, в котором выполняется вычисление, оба метода генерируют
              исключение типа I n t e r r u p t e d E x c e p t i o n . А если вычисление уже завершено, то метод get
              () сразу же возвращает управление. Метод is Done () возвращает логическое
              значение false, если вычисление продолжается, и логическое значение true, если
              оно завершено.
            </p>

            <p>
              Вычисление можно прервать, вызвав метод c a n c e l (). Если вычисление еще не начато, оно отменяется и
              вообще не начнется. Если же вычисление уже выполняется, оно
              прерывается, когда параметр метода m a y l n t e r r u p t () имеет логическое значение true.
              Класс-оболочка F u t u r e T a s k служит удобным механизмом для превращения интерфейса C a l l a b l e
              одновременно в интерфейсы F u t u r e и Runnable, реализуя оба эти
              интерфейса. В приведенном ниже коде демонстрируется характерный тому пример.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Callable&lt;Integer&gt; myComputation = . . .;
FutureTask&lt;Integer&gt; task = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FutureTask&lt;Integer&gt;(myComputation);
Thread t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Thread(task); <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// это интерфейс Runnable </span>
t. start();
Integer result = task.getO; <span class="hljs-comment"
                                  style="color: rgb(113, 149, 168);">// а это интерфейс Future</span></pre>

            <p>
              В примере программы из листинга 14.10 описанные выше понятия демонстрируются непосредственно в коде. Эта
              программа действует аналогично программе из предыдущего примера, где находятся файлы, содержащие ключевое
              слово. Но в данном
              случае просто подсчитывается количество файлов, соответствующих критерию поиска.
              Таким образом, выполняется долгосрочная задача, результатом которой является целочисленное значение,
              например, типа Callable< I n t e g e r > , как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">MatchCounter</span> <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Callable</span>&lt;<span class="hljs-title"
                                                                                              style="color: rgb(37, 127, 173);">Integer</span>&gt;
</span>{
     <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
         class="hljs-title" style="color: rgb(37, 127, 173);">MatchCounter</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">(File directory, String keyword)</span> </span>{ . . . }
     <span class="hljs-function"><span class="hljs-keyword"
                                       style="color: rgb(107, 107, 184);">public</span> Integer <span class="hljs-title"
                                                                                                      style="color: rgb(37, 127, 173);">call</span><span
         class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// возвращается количество совпадающих файлов</span>
}
</pre>
            <p>
              Далее из объекта класса M a t c h C o u n t e r конструируется объект типа FutureTask,
              который служит для запуска потока исполнения следующим образом:


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">FutureTask&lt;Integer&gt; task = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FutureTask&lt;Integer&gt;(counter);
Thread t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Thread(task);
t.start () ;
</pre>
            <p>
              И, наконец, выводится результат, как показано ниже. Разумеется, при вызове метода get () блокировка
              устанавливается до тех пор, пока не будет готов результат.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.println(task.get() + <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" matching files."</span>);</pre>

            <p>
              В теле метода call () тот же самый механизм применяется рекурсивно. Для каждого подкаталога создается
              новый объект типа M a t h C ounter, и для него запускается
              поток исполнения. Кроме того, объекты типа F u t u r e T a s k накапливаются в списочном массиве типа A r
              r a y L i s t < F u t u r e < I n t e g e r > > . И, наконец, все полученные результаты складываются
              следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Future&lt;Integer&gt; result : results)
    count += result.get();</pre>
            <p>
              count += result.get();
              Как пояснялось выше, при каждом вызове метода get () блокировка устанавливается до тех пор, пока не будет
              готов результат. Разумеется, потоки исполняются параллельно, поэтому не исключено, что результаты будут
              готовы почти одновременно.

            </p>

            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> future;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.io.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.concurrent.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * <span class="hljs-doctag">@version</span> 1.01 2012-01-26
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">FutureTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Scanner(System.in))
      {
         System.out.print(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Enter base directory (e.g. /usr/local/jdk5.0/src): "</span>);
         String directory = in.nextLine();
         System.out.print(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Enter keyword (e.g. volatile): "</span>);
         String keyword = in.nextLine();

         MatchCounter counter = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> MatchCounter(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> File(directory), keyword);
         FutureTask&lt;Integer&gt; task = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FutureTask&lt;&gt;(counter);
         Thread t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Thread(task);
         t.start();
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
         {
            System.out.println(task.get() + <span class="hljs-string" style="color: rgb(86, 140, 59);">" matching files."</span>);
         }
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (ExecutionException e)
         {
            e.printStackTrace();
         }
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (InterruptedException e)
         {
         }
      }
   }
}

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */</span>
<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">MatchCounter</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Callable</span>&lt;<span class="hljs-title" style="color: rgb(37, 127, 173);">Integer</span>&gt;
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> File directory;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String keyword;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Constructs a MatchCounter.
    * <span class="hljs-doctag">@param</span> directory the directory in which to start the search
    * <span class="hljs-doctag">@param</span> keyword the keyword to look for
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">MatchCounter</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(File directory, String keyword)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.directory = directory;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.keyword = keyword;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Integer <span class="hljs-title" style="color: rgb(37, 127, 173);">call</span><span class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> count = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         File[] files = directory.listFiles();
         List&lt;Future&lt;Integer&gt;&gt; results = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ArrayList&lt;&gt;();

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (File file : files)
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (file.isDirectory())
            {
               MatchCounter counter = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> MatchCounter(file, keyword);
               FutureTask&lt;Integer&gt; task = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FutureTask&lt;&gt;(counter);
               results.add(task);
               Thread t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Thread(task);
               t.start();
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span>
            {
               <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (search(file)) count++;
            }

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Future&lt;Integer&gt; result : results)
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
               count += result.get();
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (ExecutionException e)
            {
               e.printStackTrace();
            }
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (InterruptedException e)
      {
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> count;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Searches a file for a given keyword.
    * <span class="hljs-doctag">@param</span> file the file to search
    * <span class="hljs-doctag">@return</span> true if the keyword is contained in the file
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">search</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(File file)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Scanner(file, <span class="hljs-string" style="color: rgb(86, 140, 59);">"UTF-8"</span>))
         {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> found = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (!found &amp;&amp; in.hasNextLine())
            {
               String line = in.nextLine();
               <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (line.contains(keyword)) found = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span>;
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> found;
         }
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException e)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
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
          Какой порядок действий следует выбрать при необходимости получение результата в асинхронном режиме?
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
          Какой порядок действий следует выбрать при необходимости получение результата в асинхронном режиме?
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
  name: "InterfacesCallableAndFuture",
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

      selected: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get()',
      options: [
        {
          item: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get()',
          name: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get()'
        },
        {
          item: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >',
          name: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >'
        },
        {
          item: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >, созадть и запустить Thread',
          name: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >, созадть и запустить Thread'
        },
        {
          item: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >, созадть и запустить Thread, вызвать get()',
          name: 'Определить класс расширяющийся интерфейсом Callable< T >, переопределить переопределить get(), создать объект FutureTask< T >, созадть и запустить Thread, вызвать get()'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/ninthchapter/', {
        params: {
          numberTheme: 17,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[16].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[16].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[16].task.answer

          window.frontendData.language.chapters[8].listThemes[16].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[16].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[16].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[16].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[16].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[16].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[16].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-6-theme-1-subtheme');

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