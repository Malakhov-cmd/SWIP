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
          Коллекции
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Выбираемые структуры данных могут заметно отличаться как в отношении реализации методов в "естественном
              стиле", так и в отношении производительности. При
              этом возникают следующие вопросы. Требуется ли быстрый поиск среди тысяч (или
              даже миллионов) отсортированных элементов? Нужен ли быстрый ввод и удаление
              элементов в середине упорядоченной последовательности? Требуется ли устанавливать связи между ключами и
              значениями?

            </p>

            <p>
              Выбираемые структуры данных могут заметно отличаться как в отношении реализации методов в "естественном
              стиле", так и в отношении производительности. При
              этом возникают следующие вопросы. Требуется ли быстрый поиск среди тысяч (или
              даже миллионов) отсортированных элементов? Нужен ли быстрый ввод и удаление
              элементов в середине упорядоченной последовательности? Требуется ли устанавливать связи между ключами и
              значениями?

            </p>

            <p>
              Каркас коллекций в Java
            </p>
            <p>
              В первоначальной версии Java предлагался лишь небольшой набор классов
              для наиболее употребительных структур данных: Vector, Stack, Hashtable, BitSet,
              а также интерфейс Enumeration, предоставлявший абстрактный механизм для обращения к элементам,
              находящимся в произвольном контейнере. Безусловно, это было
              мудрое решение, ведь для реализации всеобъемлющей библиотеки классов коллекций требуется время и опыт.

            </p>
            <p>
              После выпуска версии Java SE 1.2 разработчики осознали, что настало время создать полноценный набор
              структур данных. При этом они столкнулись со многими
              противоречивыми требованиями. Они стремились к тому, чтобы библиотека была
              компактной и простой в освоении. Для этого нужно было избежать сложности стандартной библиотеки шаблонов
              (STL) в C++, но в то же время позаимствовать обобщенные алгоритмы, впервые появившиеся в библиотеке STL.
              Кроме того, нужно
              было обеспечить совместимость унаследованных классов коллекций с новой архитектурой. И, как это случается
              со всеми разработчиками библиотек коллекций, им
              приходилось не раз делать нелегкий выбор, находя попутно немало оригинальных
              решений. В этом разделе мы рассмотрим основную структуру каркаса коллекций
              в Java, покажем, как применять их на практике, а также разъясним наиболее противоречивые их особенности.

            </p>
            <p>
              Разделение интерфейсов и реализаций коллекций

            </p>

            <p>
              Как это принято в современных библиотеках структур данных, в рассматриваемой
              здесь библиотеке коллекций Java интерфейсы и реализации разделены. Покажем, каким образом происходит это
              разделение, на примере хорошо известной структуры
              данных — очереди.

            </p>

            <p>
              Интерфейс очереди определяет, что элементы можно добавлять в хвосте очереди,
              удалять их в ее голове, а также выяснять, сколько элементов находится в очереди в данный момент. Очереди
              применяются в тех случаях, когда требуется накапливать объекты и извлекать их по принципу "первым пришел
              — первым обслужен.

            </p>

            <p>
              Самая элементарная форма интерфейса очереди может выглядеть так
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Queue</span>&lt;<span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">E</span>&gt; // простейшая форма интерфейса очереди
        //из стандартной библиотеки
    </span>{
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">add</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(E element)</span></span>;

        Е remove();

        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">size</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span></span>;
    }</pre>
            <p>
              Из интерфейса нельзя ничего узнать, каким образом реализована очередь. В одной из широко распространенных
              реализаций очереди применяется циклический
              массив, а в другой — связный список
            </p>

            <p>
              Каждая реализация может быть выражена классом, реализующим интерфейс
              Queue, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">CircularArrayQueue</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt; <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Queue</span>&lt;<span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">E</span>&gt;
// этот класс не из библиотеки
    </span>{
        CircularArrayQueue(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> capacity) { . . .}

        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
            class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                      style="color: rgb(37, 127, 173);">add</span><span
            class="hljs-params" style="color: rgb(147, 92, 37);">(E element)</span> </span>{ . . .}

        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> E <span
            class="hljs-title" style="color: rgb(37, 127, 173);">remove</span><span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">()</span> </span>{ . . .}

        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
            class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                     style="color: rgb(37, 127, 173);">size</span><span
            class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . .}

        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> E[] elements;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">int</span> head;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">int</span> tail;
    }

    <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">LinkedListQueue</span>&lt;<span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">E</span>&gt; <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                        style="color: rgb(37, 127, 173);">Queue</span>&lt;<span
        class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt;
// и этот класс не из библиотеки
    </span>{
        LinkedListQueue() { . . .}

        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
            class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                      style="color: rgb(37, 127, 173);">add</span><span
            class="hljs-params" style="color: rgb(147, 92, 37);">(E element)</span> </span>{ . . .}

        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> E <span
            class="hljs-title" style="color: rgb(37, 127, 173);">remove</span><span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">()</span> <span
            class="hljs-params" style="color: rgb(147, 92, 37);">(...)</span>

        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">int</span> <span
              class="hljs-title" style="color: rgb(37, 127, 173);">size</span><span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">()</span> <span
              class="hljs-params" style="color: rgb(147, 92, 37);">(...)</span>
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Link head</span>;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Link tail;
    }</pre>

            <p>
              Применяя в своей программе очередь, совсем не обязательно знать, какая именно реализация используется для
              построения коллекции. Таким образом, конкретный
              класс имеет смысл использовать только в том случае, если конструируется объект коллекции. А тип
              интерфейса служит лишь для ссылки на коллекцию, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Queue&lt;Customer&gt; expressLane = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> CircularArrayQueueo (<span
                class="hljs-number" style="color: rgb(147, 92, 37);">100</span>) ;
expressLane.add(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Customer(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>));
</pre>

            <p>
              Если придется изменить решение, то при таком подходе нетрудно будет воспользоваться другой реализацией.
              Для этого достаточно внести изменения только в одном месте программы: при вызове конструктора. Так, если
              остановить свой выбор
              на классе LinkedListQueue, код реализации очереди в виде связного списка будет
              выглядеть следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Queue&lt;Customer&gt; expressLane = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LinkedListQueueO () ;
expressLane.add(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Customer(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>));
</pre>

            <p>
              Почему выбирается одна реализация, а не другая? Ведь из самого интерфейса ничего нельзя узнать об
              эффективности реализации. Циклический массив в некотором
              отношении более эффективен, чем связный список, и поэтому ему обычно отдается
              предпочтение. Но, как всегда, за все нужно платить. Циклический массив является
              ограниченной коллекцией, имеющей конечную емкость. Поэтому если неизвестен верхний предел количества
              объектов, которые должна накапливать прикладная программа, то имеет смысл выбрать реализацию очереди на
              основе связного списка.
            </p>
            <p>
              Изучая документацию на прикладной программный интерфейс API, вы непременно обнаружите другой набор
              классов, имена которых начинаются на Abstract,
              как, например, AbstractQueue. Эти классы предназначены для разработчиков библиотек. В том редком случае,
              когда вам потребуется реализовать свой собственный класс
              очереди, вы обнаружите, что сделать это проще, расширив класс AbstractQueue, чем
              реализовывать все методы из интерфейса Queue.
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
          С какой целью используется концепция разделения интерфейсов и реализации коллекций?
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
          С какой целью используется концепция разделения интерфейсов и реализации коллекций?
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
  name: "SeparationsInterfaces",
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

      selected: 'Для выделение общей идеи и декларирования концепций с последующей детальной реализацией',
      options: [
        {item: 'Для выделение общей идеи и декларирования концепций с последующей детальной реализацией', name: 'Для выделение общей идеи и декларирования концепций с последующей детальной реализацией'},
        {item: 'Для предоставления возможности переопределения методов', name: 'Для предоставления возможности переопределения методов'},
        {
          item: 'Для использования возможностей полиморфизма',
          name: 'Для использования возможностей полиморфизма'
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
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[0].task.answer

          window.frontendData.language.chapters[7].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-8-chapter-1-theme-1-subtheme');

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