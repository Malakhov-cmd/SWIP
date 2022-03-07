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
          Архитектура вилочного соединения
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В одних приложениях используется большое количество потоков исполнения, которые в основном простаивают.
              Примером тому может служить веб-сервер, использующий по одному потоку исполнения на каждое соединение. А
              в других приложениях на каждое ядро процессора приходится по одному потоку для исполнения
              таких задач, требующих интенсивных вычислений, как обработка изображений и видеозаписей. Для поддержки
              именно таких приложений в версии Java SE 7 появилась
              архитектура вилочного соединения. Допустим, имеется задача обработки, естественно разделяемая на
              подзадачи следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (problemSize &lt; threshold)
   решить задачу непосредственно
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span>
{
   разделить задачу на подзадачи, решить каждую подзадачу
   рекурсивно и объединить полученные результаты
}</pre>
            <p>
              Примером такой задачи служит обработка изображений. Для увеличения изображения можно преобразовать по
              отдельности верхнюю и нижнюю его половины. Если для подобных операций имеется достаточно свободных
              процессоров, то их
              выполнение можно распараллелить. (Безусловно, для разделения обрабатываемого
              изображения на две половины потребуются дополнительные действия, но это уже
              технические подробности, не имеющие отношения к делу.)

            </p>

            <p>
              Обратимся к более простому примеру. Допустим, требуется подсчитать количество элементов в массиве с
              определенным свойством. Для этого массив разделяется
              на две половины, в каждой из них подсчитываются соответствующие элементы, а затем результаты складываются
            </p>

            <p>
              Чтобы облечь рекурсивные вычисления в форму, пригодную для архитектуры вилочного соединения, сначала
              предоставляется класс, расширяющий класс RecursiveTask
              < T >
              (если результат вычисления относится к типу Т) или же класс RecursiveAction (если
              получение результата не предполагается). Затем переопределяется метод compute ()
              для формирования и вызова подзадач, а также объединения результатов их выполнения.
              Ниже приведен соответствующий пример кода.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Counter</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">RecursiveTask</span>&lt;<span class="hljs-title"
                                                                                                   style="color: rgb(37, 127, 173);">Integer</span>&gt; </span>{
    <span class="hljs-function"><span class="hljs-keyword"
                                      style="color: rgb(107, 107, 184);">protected</span> Integer <span
        class="hljs-title" style="color: rgb(37, 127, 173);">compute</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (to - from &lt; THRESHOLD) {
            решить задачу непосредственно;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span>
            {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> mid = (from + to) / <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">2</span>;
                Counter first = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Counter(values, from, mid, filter);
                Counter second = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Counter(values, mid, to, filter);
                invokeAll(first, second);
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first.join() + second.join();
            }
        }
    }
}</pre>
            <p>
              В данном примере метод invokeAll () получает ряд задач и блоков до тех пор,
              пока их выполнение не будет завершено, а метод join () объединяет полученные результаты. В частности,
              метод join () вызывается для каждой подзадачи, а в итоге возвращается сумма результатов их выполнения.
            </p>
            <p>
              Весь исходный код рассматриваемого здесь примера приведен в листинге
              В самой архитектуре вилочного соединения применяется эффективный эвристический алгоритм для
              уравновешивания рабочей нагрузки на имеющиеся потоки исполнения, называемый перехватом работы. Для
              каждого рабочего потока исполнения
              организуется двухсторонняя очередь выполняемых задач. Рабочий поток исполнения
              размещает подзадачи в голове своей двухсторонней очереди, причем только один поток исполнения имеет
              доступ к голове этой очереди, благодаря чему исключается
              потребность в блокировке потоков. Когда рабочий процесс простаивает, он пытается
              перехватить задачу из хвоста другой двухсторонней очереди, но поскольку в хвосте
              очереди обычно располагаются крупные подзадачи, то потребность в перехвате задач
              возникает редко.

            </p>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> forkJoin;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.concurrent.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.function.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the fork-join framework.
 * <span class="hljs-doctag">@version</span> 1.01 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">ForkJoinTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> SIZE = <span class="hljs-number" style="color: rgb(147, 92, 37);">10000000</span>;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[] numbers = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[SIZE];
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> i = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; SIZE; i++) numbers[i] = Math.random();
      Counter counter = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Counter(numbers, <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>, numbers.length, x -&gt; x &gt; <span class="hljs-number" style="color: rgb(147, 92, 37);">0.5</span>);
      ForkJoinPool pool = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ForkJoinPool();
      pool.invoke(counter);
      System.out.println(counter.join());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Counter</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">RecursiveTask</span>&lt;<span class="hljs-title" style="color: rgb(37, 127, 173);">Integer</span>&gt;
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> THRESHOLD = <span class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[] values;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> from;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> DoublePredicate filter;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-title" style="color: rgb(37, 127, 173);">Counter</span><span class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[] values, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> from, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, DoublePredicate filter)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.values = values;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.from = from;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.to = to;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.filter = filter;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">protected</span> Integer <span class="hljs-title" style="color: rgb(37, 127, 173);">compute</span><span class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (to - from &lt; THRESHOLD)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> count = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> i = from; i &lt; to; i++)
         {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (filter.test(values[i])) count++;
         }
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> count;
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span>
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> mid = (from + to) / <span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>;
         Counter first = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Counter(values, from, mid, filter);
         Counter second = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Counter(values, mid, to, filter);
         invokeAll(first, second);
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first.join() + second.join();
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
          В чем основное удобство использование вилочного соединения?
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
          В чем основное удобство использование вилочного соединения?
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
  name: "ArchitectureForkLink",
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

      selected: 'Возможность использовать предикаты',
      options: [
        {
          item: 'Возможность использовать предикаты',
          name: 'Возможность использовать предикаты'
        },
        {
          item: 'Возможность просто разделять задачи на подзадачи и получать результат',
          name: 'Возможность просто разделять задачи на подзадачи и получать результат'
        },
        {
          item: 'Возможность просто разделять задачи на подзадачи',
          name: 'Возможность просто разделять задачи на подзадачи'
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
          numberTheme: 20,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[19].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[19].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[19].task.answer

          window.frontendData.language.chapters[8].listThemes[19].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[19].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[19].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[19].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[19].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[19].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[19].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-6-theme-3-subtheme');

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