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
          Итераторы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В состав интерфейса Iterator входят три метода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Iterator</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt;
    </span>{
        Е next();
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">hasNext</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">()</span></span>;
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">remove</span><span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">()</span></span>;
    }</pre>
            <p>
              Многократно вызывая метод next (), можно обратиться к каждому элементу коллекции по очереди. Но если
              будет достигнут конец коллекции, то метод next () сгенерирует исключение типа NoSuchElementException.
              Поэтому перед вызовом метода next () следует вызывать метод hasNext (). Этот метод возвращает логическое
              значение true, если у объекта итератора все еще имеются объекты, к которым можно
              обратиться. Если же требуется перебрать все элементы коллекции, то следует запросить итератор, продолжая
              вызывать метод next () до тех пор, пока метод hasNext ()
              возвращает логическое значение true. В приведенном ниже примере показано, как
              все это реализуется непосредственно в коде.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    Collection&lt;String&gt; с = . . .;
    Iterator&lt;String&gt; iter = с.iterator();
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (iter.hasNext())
    {
        String element = iter.nextO;
        сделать что-нибудь с элементом element
    }</pre>
            <p>
              Тот же самый код можно написать более компактно, организовав цикл в стиле
              for each следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (String element : с)
{
    сделать что-нибудь с элементом element
}
</pre>
            <p>
              Компилятор просто преобразует цикл в стиле for each в цикл с итератором.
              Цикл в стиле for each подходит для любых объектов, класс которых реализует интерфейс Iterable со
              следующим единственным методом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Iterable</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt;
</span>{
    <span class="hljs-function">Iterator&lt;E&gt; <span class="hljs-title"
                                                        style="color: rgb(37, 127, 173);">iterator</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;
}</pre>
            <p>
              Интерфейс Collection расширяет интерфейс Iterable. Поэтому цикл в стиле
              for each подходит для обращения к элементам любой коллекции из стандартной
              библиотеки.

            </p>
            <p>
              Начиная с версии Java SE 8, для перебора элементов коллекции можно даже не организовывать цикл. Для этого
              достаточно вызвать метод forEachRemaining () с лямбда-выражением, где употребляется элемент коллекции.
              Это лямбда-выражение вызывается
              с каждым из элементов до тех пор, пока их больше не останется в коллекции:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">iterator.forEachRemaining(element -&gt;
      сделать что-нибудь с элементом element) ;
</pre>
            <p>
              Порядок, в котором перебираются элементы, зависит от типа коллекции. Так,
              если осуществляется перебор элементов коллекции типа ArrayList, итератор начинает его с нулевого индекса,
              увеличивая последнее значение на каждом шаге итерации. Но если осуществляется перебор элементов коллекции
              типа Hash Set, то они
              получаются в совершенно случайном порядке. Можно быть уверенным лишь в том,
              что за время итерации будут перебраны все элементы коллекции, хотя нельзя сделать никаких предположений
              относительно порядка их следования. Обычно это не
              особенно важно, потому что порядок не имеет значения при таких вычислениях, как,
              например, подсчет суммы или количества совпадений.

            </p>
            <p>
              Имеется принципиальное отличие между итераторами из библиотеки коллекций
              в Java и других библиотек. В традиционных библиотеках коллекций, как, например,
              Standard Template Library в C++, итераторы моделируются по индексам массива. Имея
              такой итератор, можно найти элемент, находящийся на данной позиции в массиве,
              подобно тому, как находится элемент массива а [ i ], если имеется индекс i. Независимо от способа поиска
              элементов коллекции, итератор можно передвинуть на следующую позицию. Эта операция аналогична приращению
              индекса i++ без поиска.
              Но итераторы в Java действуют иначе. Поиск элементов в коллекции и изменение их
              позиции тесно взаимосвязаны. Единственный способ найти элемент — вызвать метод
              next (), а в ходе поиска происходит переход на следующую позицию.
            </p>
            <p>
              Напротив, итераторы в Java следует представлять себе так, как будто они находятся между элементами
              коллекции. Когда вызывается метод next (), итератор перескакивает следующий элемент и возвращает ссылку
              на тот элемент, который он только
              что прошел (рис. 9.3).

            </p>
            <p>
              Метод remove () из интерфейса Iterator удаляет элемент, который был возвращен при последнем вызове метода
              next (). Во многих случаях это имеет смысл, поскольку нужно проанализировать элемент, прежде чем решаться
              на его удаление. Но
              если требуется удалить элемент, находящийся на определенной позиции, то сначала
              придется его пройти. В приведенном ниже примере показано, как удалить первый
              элемент из коллекции символьных строк.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Iterator&lt;String&gt; it = с.iterator();
it.next(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// пройти первый элемент коллекции</span>
it.remove(); / / а теперь удалить его</pre>
            <p>
              Но важнее то, что между вызовами методов next () и remove () существует определенная связь. В частности,
              вызывать метод remove () не разрешается, если перед
              ним не был вызван метод next (). Если же попытаться сделать это, будет сгенерировано исключение типа
              IllegalStateException. А если из коллекции требуется
              удалить два соседних элемента, то нельзя просто вызвать метод remove () два раза
              подряд, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">it.remove();
it.remove(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span></pre>
            <p>
              Вместо этого нужно сначала вызвать метод next (), чтобы пройти удаляемый элемент, а затем удалить его,
              как следует из приведенного ниже примера кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">it.remove();
it.next();
it.remove(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Допустимо!</span></pre>
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
          Зачем был создан интерфейс Iterator< E >?
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
          Зачем был создан интерфейс Iterator< E >?
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
  name: "Iterator",
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

      selected: 'Для формирования различных коллекций',
      options: [
        {
          item: 'Для формирования различных коллекций',
          name: 'Для формирования различных коллекций'
        },
        {
          item: 'Для инициализации в конструкторе коллекций',
          name: 'Для инициализации в конструкторе коллекций'
        },
        {
          item: 'Декларация принципов обхода коллекций',
          name: 'Декларация принципов обхода коллекций'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/eighthchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[2].task.answer

          window.frontendData.language.chapters[7].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[2].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-8-chapter-1-theme-3-subtheme');

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