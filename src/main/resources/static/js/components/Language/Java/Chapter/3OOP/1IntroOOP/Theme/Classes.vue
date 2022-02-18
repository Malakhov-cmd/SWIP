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
          Классы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Объектно-ориентированное программирование (ООП) в настоящее время стало
              доминирующей методикой программирования, вытеснив "структурные" или процедурные подходы, разработанные в
              1970-х годах. Java — это полностью объектноориентированный язык, и для продуктивного программирования на
              нем необходимо
              знать основные принципы ООП.
            </p>
            <p>Объектно-ориентированная программа состоит из объектов. Каждый объект обладает определенными
              функциональными возможностями, предоставляемыми в распоряжение пользователей, а также скрытой
              реализацией. Одни объекты для своих
              программ вы можете взять в готовом виде из библиотеки, другие вам придется спроектировать самостоятельно.
              Строить ли свои объекты или приобретать готовые — зависит от вашего бюджета или времени. Но, как правило,
              до тех пор, пока объекты
              удовлетворяют вашим требованиям, вам не нужно особенно беспокоиться о том, каким образом реализованы их
              функциональные возможности.
            </p>
            <p>Традиционное структурное программирование заключается в разработке набора
              процедур (или алгоритмов) для решения поставленной задачи. Определив эти процедуры, программист должен
              найти подходящий способ хранения данных. Вот почему создатель языка Pascal Никлаус Вирт (Niklaus Wirth)
              назвал свою известную книгу по программированию Алгоритмы + Структуры данных = Программы (Algorithms
              + Data Structures = Programs; издательство Prentice Hall, 1975 г). Обратите внимание
              на то, что в названии этой книги алгоритмы стоят на первом месте, а структуры данных — на втором. Это
              отражает образ мышления программистов того времени. Сначала они решали, как манипулировать данными, а
              затем — какую структуру применить для организации этих данных, чтобы с ними было легче работать. Подход
              ООП
              в корне изменил ситуацию, поставив на первое место данные и лишь на второе — алгоритмы, предназначенные
              для их обработки
            </p>
            <p>Для решения небольших задач процедурный подход оказывается вполне пригодным. Но объекты более
              приспособлены для решения более крупных задач. Рассмотрим в качестве примера небольшой веб-браузер. Его
              реализация может потребовать 2000 процедур, каждая из которых манипулирует набором глобальных данных.
              В стиле ООП та же самая программа может быть составлена всего из 100 классов,
              в каждом из которых в среднем определено по 20 методов (рис. 4.1). Такая структура
              программы гораздо удобнее для программирования. В ней легче находить ошибки.
              Допустим, что данные некоторого объекта находятся в неверном состоянии. Очевидно, что намного легче найти
              причину неполадок среди 20 методов, имеющих доступ
              к данным, чем среди 2000 процедур.
            </p>
            <p>Как следует из примеров программ в предыдущих главах, весь код, написанный
              на Java, находится в классах. Стандартная библиотека Java содержит несколько тысяч
              классов, предназначенных для решения самых разных задач, например, для построения пользовательского
              интерфейса, календарей, установления сетевых соединений
              и т.д. Несмотря на это, программирующие на Java продолжают создавать свои собственные классы, чтобы
              формировать объекты, характерные для разрабатываемого
              приложения, а также приспосабливать классы из стандартной библиотеки под свои
              нужды.

            </p>
            <p>Инкапсуляция (иногда называемая сокрытием информации) — это ключевое понятие для работы с объектами.
              Формально инкапсуляцией считается обычное объединение данных и операций над ними в одном пакете и
              сокрытие данных от других
              объектов. Данные в объекте называются полями экземпляра, а функции и процедуры,
              выполняющие операции над данными, — его методами. В конкретном объекте, т.е.
              экземпляре класса, поля экземпляра имеют определенные значения. Множество этих
              значений называется текущим состоянием объекта. Вызов любого метода для объекта
              может изменить его состояние.

            </p>
            <p>Следует еще раз подчеркнуть, что основной принцип инкапсуляции заключается
              в запрещении прямого доступа к полям экземпляра данного класса из других классов. Программы должны
              взаимодействовать с данными объекта только через методы этого объекта. Инкапсуляция обеспечивает
              внутреннее поведение объектов, что
              имеет решающее значение для повторного их использования и надежности работы
              программ. Это означает, что в классе можно полностью изменить способ хранения
              данных. Но поскольку для манипулирования данными используются одни и те же
              методы, то об этом ничего не известно, да и не особенно важно другим объектам.

            </p>
            <p>Еще один принцип ООП облегчает разработку собственных классов в Java: один
              класс можно построить на основе других классов. В этом случае говорят, что новый
              класс расширяет тот класс, на основе которого он создан. Язык Java, по существу, создан на основе
              "глобального суперкласса", называемого Object. Все остальные объекты расширяют его. В следующей главе мы
              рассмотрим этот вопрос более подробн
            </p>
            <p>Если класс разрабатывается на основе уже существующего, то новый класс содержит все свойства и методы
              расширяемого класса. Кроме того, в него добавляются
              новые методы и поля данных. Расширение класса и получение на его основе нового
              называется наследованием. Более подробно принцип наследования будет рассмотрен
              в следующей главе.
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
         Для чего используется инкапсуляция?
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
          Для чего используется инкапсуляция?
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
  name: "Classes",
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

      selected: 'Для формирования структур',
      options: [
        {item: 'Для формирования структур', name: 'Для формирования структур'},
        {item: 'Для предотвращения кибер атак', name: 'Для предотвращения кибер атак'},
        {item: 'Для сокрытия реализации класса', name: 'Для сокрытия реализации класса'},
        {item: 'Все вышеперечисленное', name: 'Все вышеперечисленное'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[0].task.answer

          window.frontendData.language.chapters[2].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-1-theme-1-subtheme');

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