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
          Объекты блокировки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Имеются два механизма для защиты блока кода от параллельного доступа. В языке Java для этой цели
              предусмотрено ключевое слово synchronized, а в версии Java
              SE 5.0 появился еще и класс ReentrantLock. Ключевое слово synchronized автоматически обеспечивает
              блокировку, как и связанное с ней "условие", которое удобно указывать в большинстве случаев, когда
              требуется явная блокировка. Но понять ключевое
              слово synchronized проще, если рассмотреть блокировки и условия по отдельности.
              В библиотеке java.util.concurrent предоставляются отдельные классы для реализации этих основополагающих
              механизмов.
            </p>
            <p>
              Защита блока кода средствами класса ReentrantLock в общих чертах выглядит
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    myLock.lock(); <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// объект типа R e e n tra n tL o c k</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
    {
        критический раздел кода
    }
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
    {
        myLock.unlock(); <span class="hljs-comment"
                               style="color: rgb(113, 149, 168);">// непременно снять блокировку,</span>
                        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// даже если генерируется исключение</span>
    }</pre>
            <p>
              Такая конструкция гарантирует, что только один поток исполнения в единицу
              времени сможет войти в критический раздел кода. Как только один поток исполнения заблокирует объект
              блокировки, никакой другой поток не сможет обойти вызов
              метода lock (). И если другие потоки исполнения попытаются вызвать метод lock (),
              то они будут деактивизированы до тех пор, пока первый поток не снимет блокировку
              с объекта блокировки.
            </p>

            <p>
              Воспользуемся блокировкой для защиты метода transfer () из класса Bank, как
              показано ниже
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Bank</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Lock bankLock = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ReentrantLock(); <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// объект класса </span>

    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ReentrantLock, реализующего интерфейс Lock</span>
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">transfer</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                    style="color: rgb(107, 107, 184);">int</span> from, <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">int</span> amount)</span> </span>{
        bankLock.lock();
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" %10.2f from %d to %d"</span>, amount, from, to);
            accounts[to] += amount;
            System.out.printf(
                    <span class="hljs-string" style="color: rgb(86, 140, 59);">" Total Balance: %10.2f%n"</span>, getTotalBalance());
        } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span> {
            bankLock.unlock();
        }
    }
}</pre>
            <p>
              Допустим, в одном потоке исполнения вызывается метод transfer () и до его завершения этот поток
              приостанавливается, а во втором потоке исполнения также вызывается метод transfer (). Второй поток не
              сможет захватить блокировку и останется заблокированным при вызове метода lock (). Напротив, он будет
              деактивизирован
              и вынужден ждать до тех пор, пока выполнение метода transfer () не завершится
              в первом потоке. И только тогда, когда первый поток снимет блокировку, второй поток сможет продолжить
              свое исполнение.
            </p>
            <p>
              Опробуйте описанный выше механизм синхронизации потоков исполнения, введя блокирующий код в метод
              transfer () и запустив рассматриваемую здесь программу снова. Можете прогонять ее бесконечно, но общий
              баланс банка на этот раз
              не будет нарушен.

            </p>
            <p>
              Следует, однако, иметь в виду, что у каждого объекта типа Bank имеется свой
              собственный объект типа ReentrantLock. Если два потока исполнения попытаются
              обратиться к одному и тому же объекту типа Bank, блокировка послужит для сериализации доступа. Но если
              два потока исполнения обращаются к разным объектам
              типа Bank, то каждый из них захватывает свою блокировку и ни один из потоков не
              блокируется. Так и должно быть, потому что потоки исполнения никак не мешают
              друг другу, оперируя разными экземплярами класса Bank.

            </p>
            <p>
              Блокировка называется реентерабельной, потому что поток исполнения может повторно захватывать блокировку,
              которой он уже владеет. Для блокировки предусмотрен счетчик захватов, отслеживающий вложенные вызовы
              метода lock (). И для каждого вызова lock() в потоке должен быть вызван метод unlock(), чтобы, в конце
              концов, снять блокировку. Благодаря этому средству код, защищенный блокировкой,
              может вызывать другой метод, использующий ту же самую блокировку.

            </p>

            <p>
              Например, метод transfer () вызывает метод getTotalBalance (), который также блокирует объект bankLock, у
              которого теперь значение счетчика захватов равно
              2. Когда метод getTotalBalance () завершается, значение счетчика захватов возвращается к 1. При выходе из
              метода transfer () счетчик захватов имеет значение О,
              и поток исполнения снимает блокировку.

            </p>
            <p>
              Как правило, требуется защищать блоки кода, обновляющие и проверяющие разделяемый потоками объект. Тогда
              можно не сомневаться, что эти операции завершатся, прежде чем тот же самый объект сможет быть использован
              в другом потоке
              исполнения.
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
          Что произойдет если не вызвать метод unlock()?
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
          Что произойдет если не вызвать метод unlock()?
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
  name: "BlockingObject",
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

      selected: 'Автоматичекое снятие блокировки',
      options: [
        {
          item: 'Автоматичекое снятие блокировки',
          name: 'Автоматичекое снятие блокировки'
        },
        {
          item: 'Блокировка не будет снята и останется за потоком вызвавшим метод lock()',
          name: 'Блокировка не будет снята и останется за потоком вызвавшим метод lock()'
        },
        {
          item: 'Блокировка будет снята и рандомный поток получит доступ к объекту',
          name: 'Блокировка будет снята и рандомный поток получит доступ к объекту'
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
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[8].task.answer

          window.frontendData.language.chapters[8].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[8].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[8].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-2-subtheme');

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