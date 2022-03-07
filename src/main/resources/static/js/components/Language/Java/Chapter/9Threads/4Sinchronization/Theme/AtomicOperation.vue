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
          Атомарность операций
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Разделяемые переменные могут быть объявлены как volatile, при условии, что
              над ними не выполняется никаких операций, кроме присваивания. В пакете java,
              util. concurrent. atomic имеется целый ряд классов, в которых эффективно используются команды машинного
              уровня, гарантирующие атомарность других операций
              без применения блокировок. Например, в классе Atomic Integer имеются методы
              incrementAndGet () и decrementAndGet (), атомарно инкрементирующие или декрементирующие целое значение.
              Так, безопасно сформировать последовательность чисел можно следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> AtomicLong nextNumber = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> AtomicLong();
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// В некотором потоке исполнения... </span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> id = nextNumber.incrementAndGet();
</pre>

            <p>
              Метод incrementAndGet () автоматически инкрементирует переменную типа
              AtomicLong и возвращает ее значение после инкрементирования. Это означает, что
              операции получения значения, прибавления 1, установки и получения нового значения переменной не могут
              быть прерваны. Этим гарантируется правильное вычисление и возврат значения даже при одновременном доступе
              к одному и тому же экземпляру из нескольких потоков исполнения.

            </p>

            <p>
              Имеются также методы для автоматической установки, сложения и вычитания
              значений, но если требуется выполнить более сложное их обновление, то придется
              вызвать метод compareAndSet (). Допустим, в нескольких потоках исполнения требуется отслеживать
              наибольшее значение. Приведенный ниже код для этой цели не
              годится.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> AtomicLong largest = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> AtomicLong();
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// В некотором потоке исполнения... </span>
largest.set(Math.max(largest.get(), observed));
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА из-за условия гонок!</span></pre>
            <p>
              Такое обновление не является атомарным. Вместо этого следует вычислять новое
              значение и вызывать метод compareAndSet () в цикле, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">do {
    oldValue = largest.get();
    newValue = Math.max(oldValue, observed);
} <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (!largest.compareAndSet(oldValue, newValue));</pre>

            <p>
              Если переменная largest обновляется и в другом потоке исполнения, то
              вполне возможно, что он одержит верх над текущим потоком. И тогда метод
              compareAndSet () возвратит логическое значение false, не установив новое значение.
              В таком случае будет осуществлена еще одна попытка выполнить приведенный выше
              цикл с целью прочить обновленное значение и попытаться изменить его. И в конечном итоге существующее
              значение будет успешно заменено новым значением. И хотя
              такое применение метода compareAndSet () кажется не совсем удобным, тем не менее, его действие вполне
              согласуется с операцией процессора, которая выполняется
              быстрее, чем при использовании блокировки.

            </p>
            <p>
              Начиная с версии Java SE 8, организовывать подобный цикл больше не нужно.
              Вместо этого достаточно предоставить лямбда-выражение, чтобы требующееся значение обновлялось
              автоматически. Так, в рассматриваемом здесь примере можно сделать один из следующих вызовов:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">largest.updateAndGet(х -&gt; Math.max(x, observed)); </pre>
            <p>
              или
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">largest.accumulateAndGet(observed, Math::max);
</pre>
            <p>
              Метод accumulateAndGet () принимает в качестве одного из аргументов двоичную операцию для объединения
              атомарного значения со значением другого аргумента. Имеются также методы getAndUpdate () и
              getAndAccumulate (), возвращающие
              прежнее значение.
            </p>
            <p>
              При наличии очень большого количества потоков исполнения, где осуществляется доступ к одним и тем же
              атомарным значениям, резко снижается производительность, поскольку для оптимистичных обновлений требуется
              слишком много попыток. В качестве выхода из этого затруднительного положения в версии Java SE 8
              предоставляются классы LongAdder и LongAccumulator. В частности, класс LongAdder
              состоит из нескольких полей, общая сумма значений в которых составляет текущее
              значение. Разные слагаемые этой суммы могут обновляться во многих потоках исполнения, а новые слагаемые
              автоматически предоставляются по мере увеличения
              количества потоков. В общем случае такой подход к параллельным вычислениям оказывается довольно
              эффективным, поскольку суммарное значение не требуется до тех
              пор, пока не будет завершена вся операция в целом. Благодаря этому значительно
              повышается производительность.

            </p>
            <p>
              Если предвидится высокая степень состязательности потоков исполнения за доступ к общим данным, то вместо
              класса AtomicLong следует воспользоваться классом
              LongAdder. Методы в этом классе называются несколько иначе. Так, для инкрементирования счетчика
              вызывается метод increment (), для прибавления величины —
              метод add (), а для извлечения итоговой суммы — метод sum (), как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> LongAdder adder = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LongAdder();
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (...)
        pool.submit(() -&gt; {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (. . .) {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (. . .) adder.increment();
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> total = adder.sum());
        }</pre>
            <p>
              Подобный принцип обобщается в классе LongAccumulator до произвольной операции накопления. Конструктору
              этого класса предоставляется нужная операция,
              а также нейтральный элемент. Для внедрения новых значений вызывается метод
              accumulate (), а для получения текущего значения — метод get (). Так, следующий
              фрагмент кода дает такой же результат, как и приведенный выше, где применялся
              класс LongAdder:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">LongAccumulator adder = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LongAccumulator(Long::sum, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);
     <span class="hljs-comment" style="color: rgb(113, 149, 168);">// В некотором потоке исполнения... </span>
adder.accumulate(value);
</pre>
            <p>
              В накапливающем сумматоре имеются переменные а2, а2, . . ап. Каждая переменная инициализируется
              нейтральным элементом (в данном случае — 0).

            </p>
            <p>
              Когда метод accumulate () вызывается со значением v, одна из этих переменных
              автоматически обновляется следующим образом: а2 * а 2 o p v, где о р — операция
              накопления в инфиксной форме записи. В данном примере в результате вызова метода accumulate ()
              вычисляется сумма а 2 * а 2 + тг для некоторой величины 1.

            </p>
            <p>
              А вызов метода get () приводит к такому результату: а2 о р а 2 о р . . . ор а п. В
              данном примере это сумма всех накапливающих сумматоров а 2 + а 2 + . . . + а п.
            </p>
            <p>
              Если выбрать другую операцию, то можно вычислить максимум или минимум.
              В общем, операция должна быть ассоциативной или коммуникативной. Это означает, что конечный результат не
              должен зависеть от порядка, в котором объединяются
              промежуточные значения.

            </p>
            <p>
              Имеются также классы DoubleAdder и DoubleAccumulator. Они действуют аналогичным образом, только оперируют
              значениями типа double.

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
          По какому соображению при многопоточном доступе предпочтение следует отдать полям типа ...Atomic?
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
          По какому соображению при многопоточном доступе предпочтение следует отдать полям типа ...Atomic?
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
  name: "AtomicOperation",
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

      selected: 'Простоты написания',
      options: [
        {
          item: 'Простоты написания',
          name: 'Простоты написания'
        },
        {
          item: 'Оптимизация вычислений',
          name: 'Оптимизация вычислений'
        },
        {
          item: 'Поддержка многих типов',
          name: 'Поддержка многих типов'
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
          numberTheme: 15,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[14].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[14].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[14].task.answer

          window.frontendData.language.chapters[8].listThemes[14].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[14].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[14].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[14].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[14].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[14].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[14].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-8-subtheme');

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