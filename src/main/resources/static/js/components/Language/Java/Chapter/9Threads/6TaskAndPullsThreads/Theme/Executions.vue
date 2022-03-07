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
          Исполнители
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Создание нового потока исполнения — довольно дорогостоящая операция с точки зрения потребляемых ресурсов,
              поскольку она включает в себя взаимодействие
              с операционной системой. Если в программе создается большое количество кратковременных потоков
              исполнения, то имеет смысл использовать пул потоков. В пуле
              потоков содержится целый ряд простаивающих потоков, готовых к запуску. Так, объект типа Runnable
              размещается в пуле, а один из потоков вызывает его метод run ().
              Когда метод run () завершается, его поток не уничтожается, но остается в пуле готовым обслужить новый
              запрос.

            </p>
            <p>
              Другая причина для использования пула потоков заключается в необходимости
              ограничить количество параллельно исполняемых потоков. Создание огромного числа потоков исполнения может
              отрицательно сказаться на производительности и даже
              привести к полному отказу виртуальной машины. Поэтому, если применяется алгоритм, создающий большое
              количество потоков, следует установить фиксированный
              пул потоков, чтобы ограничить общее количество параллельно исполняемых потоков.
            </p>

            <p>
              Пулы потоков исполнения
            </p>

            <p>
              Метод newCachedThreadPool () строит пул потоков, выполняющий каждую задачу немедленно, используя
              существующий простаивающий поток, если он доступен, а иначе — создавая новый поток. Метод
              newFixedThreadPool ()
              строит пул потоков фиксированного размера. Если количество задач превышает
              количество простаивающих потоков, то лишние задачи ставятся в очередь на обслуживание, чтобы быть
              запущенными, когда завершатся текущие исполняемые задачи.
              Метод newSingleThreadExecutor () создает вырожденный пул размером в один поток. Задачи, передаваемые в
              единственный поток, исполняются по очереди. Все три
              упомянутых здесь метода возвращают объект класса ThreadPoolExecutor, реализующего интерфейс
              ExecutorService.

            </p>
            <p>
              Передать задачу типа Runnable или Callable объекту типа ExecutorService
              можно одним из следующих вариантов метода submit ():
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Future&lt;?&gt; submit(Runnable task)
<span class="hljs-function">Future&lt;T&gt; <span class="hljs-title"
                                                  style="color: rgb(37, 127, 173);">submit</span><span
    class="hljs-params" style="color: rgb(147, 92, 37);">(Runnable task, T result)</span>
Future&lt;T&gt; <span class="hljs-title" style="color: rgb(37, 127, 173);">submit</span><span class="hljs-params"
                                                                                              style="color: rgb(147, 92, 37);">(Callable&lt;T&gt; task)</span>
</span></pre>
            <p>
              Пул запускает переданную ему задачу при первом удобном случае. В результате вызова метода submit ()
              возвращается объект типа Future, который можно использовать для опроса состояния задачи. Первый вариант
              метода submit () возвращает объект необычного типа Future< ? >. Он служит для вызова метода isDone (),
              cancel () или isCancelled (). Но по завершении метода get () возвращается только пустое значение null.
              Второй вариант метода submit () также принимает объект типа Runnable, а по завершении метода get (),
              вызываемого для объекта типа
              Future, возвращается заданный объект result. И третий вариант метода submit ()
              принимает объект типа Callable, а возвращаемый объект типа Future получает результат вычисления по его
              готовности.

            </p>

            <p>
              По завершении работы с пулом потоков исполнения следует вызвать метод
              shutdown (). Этот метод инициирует последовательность закрытия пула, после чего
              новые задачи не принимаются на выполнение. По завершении всех задач потоки
              в пуле уничтожаются. В качестве альтернативы можно вызвать метод shutdownNow ( ).
              В этом случае пул отменяет все задачи, которые еще не запущены, пытаясь прервать
              исполняемые потоки.
            </p>

            <p>
              Ниже перечислены действия для организации пула потоков исполнения.
            </p>

            <ul>
              <li>
                <p>
                  Вызовите статический метод newCachedThreadPool () или newFixedThread
                  Pool () из класса Executors.

                </p>
              </li>
              <li>
                <p>
                  Вызовите метод submit () для передачи объектов Runnable или Callable в пул
                  потоков исполнения.

                </p>
              </li>
              <li>
                <p>
                  Полагайтесь на возвращаемые объекты типа Future, чтобы иметь возможность
                  прервать задачу или передать объекты типа Callable.
                </p>
              </li>
              <li>
                <p>
                  Вызовите метод shutdown (), если больше не собираетесь запускать новые задачи.

                </p>
              </li>
            </ul>

            <p>
              В программе из предыдущего примера создается большое количество кратковременных потоков исполнения — по
              одному на каждый каталог. А в примере программы из листинга для запуска задач вместо этого
              используется пул потоков.
              Следует, однако, иметь в виду, что эта программа выводит максимальный размер
              пула, достигнутый во время выполнения. Эти сведения недоступны через интерфейс
              ExecutorService, и поэтому приходится выполнять приведение типа объекта пула
              потоков к классу ThreadPoolExecutor.

            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> threadPool;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.io.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.concurrent.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * <span class="hljs-doctag">@version</span> 1.02 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">ThreadPoolTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> Exception
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in = <span class="hljs-keyword"
                                                                                                   style="color: rgb(107, 107, 184);">new</span> Scanner(System.in))
      {
         System.out.print(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Enter base directory (e.g. /usr/local/jdk5.0/src): "</span>);
         String directory = in.nextLine();
         System.out.print(<span class="hljs-string"
                                style="color: rgb(86, 140, 59);">"Enter keyword (e.g. volatile): "</span>);
         String keyword = in.nextLine();

         ExecutorService pool = Executors.newCachedThreadPool();

         MatchCounter counter = <span class="hljs-keyword"
                                      style="color: rgb(107, 107, 184);">new</span> MatchCounter(<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> File(directory), keyword, pool);
         Future&lt;Integer&gt; result = pool.submit(counter);

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
         {
            System.out.println(result.get() + <span class="hljs-string" style="color: rgb(86, 140, 59);">" matching files."</span>);
         }
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (ExecutionException e)
         {
            e.printStackTrace();
         }
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (InterruptedException e)
         {
         }
         pool.shutdown();

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
         System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"largest pool size="</span> + largestPoolSize);
      }
   }
}

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */</span>
<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">MatchCounter</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">implements</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Callable</span>&lt;<span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">Integer</span>&gt;
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> File directory;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String keyword;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> ExecutorService pool;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> count;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Constructs a MatchCounter.
    * <span class="hljs-doctag">@param</span> directory the directory in which to start the search
    * <span class="hljs-doctag">@param</span> keyword the keyword to look for
    * <span class="hljs-doctag">@param</span> pool the thread pool for submitting subtasks
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">MatchCounter</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(File directory, String keyword, ExecutorService pool)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.directory = directory;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.keyword = keyword;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.pool = pool;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Integer <span
       class="hljs-title" style="color: rgb(37, 127, 173);">call</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">()</span>
   </span>{
      count = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         File[] files = directory.listFiles();
         List&lt;Future&lt;Integer&gt;&gt; results = <span class="hljs-keyword"
                                                           style="color: rgb(107, 107, 184);">new</span> ArrayList&lt;&gt;();

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (File file : files)
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (file.isDirectory())
            {
               MatchCounter counter = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> MatchCounter(file, keyword, pool);
               Future&lt;Integer&gt; result = pool.submit(counter);
               results.add(result);
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
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">search</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(File file)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Scanner(file, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"UTF-8"</span>))
         {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> found = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (!found &amp;&amp; in.hasNextLine())
            {
               String line = in.nextLine();
               <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (line.contains(keyword)) found = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span>;
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> found;
         }
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException e)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">false</span>;
      }
   }
}</pre>
            <p>
              Плановое исполнение потоков
            </p>

            <p>
              В состав интерфейса ScheduledExecutorServi.ee входят методы для планирования
              или многократного выполнения задач. Это — обобщение класса java. util. Time г, позволяющее организовать
              пул потоков исполнения. Методы newScheduledThreadPool ()
              и newSingleThreadScheduledExecutor () из класса Executors возвращают объекты,
              реализующие интерфейс ScheduledExecutorService. Имеется возможность запланировать однократный запуск
              задач типа Runnable или Callable по истечении некоторого времени, а также периодический запуск задач типа
              Runnable. Более подробно
              средства планового выполнения потоков представлены ниже в описании соответствующего прикладного
              программного интерфейса API.
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
          Почему стоит использовать ThreadPools?
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
          Почему стоит использовать ThreadPools?
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
  name: "Executions",
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

      selected: 'Простота реализации',
      options: [
        {
          item: 'Простота реализации',
          name: 'Простота реализации'
        },
        {
          item: 'Меньшая нагрузка на память при выделении потоков',
          name: 'Меньшая нагрузка на память при выделении потоков'
        },
        {
          item: 'Поддержка различных интерфейсов',
          name: 'Поддержка различных интерфейсов'
        },
        {
          item: 'Возможность контролировать количество потоков',
          name: 'Возможность контролировать количество потоков'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/ninthchapter/', {
        params: {
          numberTheme: 18,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[17].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[17].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[17].task.answer

          window.frontendData.language.chapters[8].listThemes[17].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[17].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[17].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[17].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[17].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[17].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[17].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-6-theme-2-subtheme');

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