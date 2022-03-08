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
          Рекомендации по применению наследования
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В завершение этой главы приведем некоторые рекомендации относительно надлежащего применения очень
              полезного механизма наследования.

            </p>

            <ul>
              <li>
                <p>
                  Размещайте общие операции и поля в суперклассе.
                </p>
                <p>
                  Поле паше было перемещено в класс Person именно для, чтобы не повторять
                  его в классах Employee и Student.
                </p>
              </li>
              <li>
                <p>
                  Старайтесь не пользоваться защищенными полями.

                </p>
                <p>
                  Некоторые разработчики полагают, что следует "на всякий случай" объявлять
                  большинство полей защищенными, чтобы подклассы могли обращаться к ним
                  по мере надобности. Но имеются две веские причины, по которым такой механизм не гарантирует
                  достаточной защиты. Во-первых, множество подклассов неограниченно. Всякий может создать подкласс,
                  производный от данного класса, а затем написать программу, получающую непосредственный доступ к
                  защищенным
                  полям его экземпляра, нарушая инкапсуляцию. И во-вторых, в Java к защищенным полям имеют доступ все
                  классы, находящиеся в том же самом пакете, независимо от того, являются ли они подклассами данного
                  класса или нет. В то же время
                  полезно объявлять защищенными методы, которые не предназначены для общего
                  употребления и должны быть переопределены в подклассах.

                </p>
              </li>
              <li>
                <p>
                  Используйте наследование для моделирования отношений "является".
                </p>
                <p>
                  Наследование позволяет экономить время и труд при разработке программ, но
                  иногда им злоупотребляют. Допустим, требуется создать класс Contractor. У
                  работника, нанимаемого по контракту, имеется свое имя и дата заключения договора, но у него нет
                  оклада. У него почасовая оплата, причем он работает не
                  так давно, чтобы повышать оплату его труда. Ниже показано, как можно сделать
                  класс Contractor подклассом, производным от класса Employee, добавив поле
                  hourlyWage.

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                    class="hljs-title" style="color: rgb(37, 127, 173);">Contractor</span> <span class="hljs-keyword"
                                                                                                 style="color: rgb(107, 107, 184);">extends</span> <span
                    class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
     <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">double</span> hourlyWage;
}
</pre>
                <p>
                  Но это не совсем удачная идея. Ведь в этом случае получается, что каждый
                  работник, нанятый по контракту, имеет и оклал и почасовую оплату. Если вы
                  попробуете реализовать методы для распечатки платежных и налоговых ведомостей, то сразу же проявится
                  недостаток такого подхода. Программа, которую вам придется написать, будет гораздо длиннее той,
                  которую вы могли бы
                  создать, не прибегая к неоправданному наследованию.

                </p>
                <p>
                  Отношение "контрактный работник-постоянный работник" не удовлетворяет
                  критерию "является". Работники, нанятые по контракту, не являются постоянными и относятся к особой
                  категории работников.

                </p>
              </li>
              <li>
                <p>
                  Не пользуйтесь наследованием, если не все методы имеет смысл сделать наследуемыми.
                </p>
                <p>
                  Допустим, требуется создать класс Holiday. Разумеется, праздники — это разновидность календарных
                  дней, а дни можно представить в виде объектов типа
                  GregorianCalendar, поэтому наследование можно применить следующим образом:

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                    class="hljs-title" style="color: rgb(37, 127, 173);">Holiday</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">extends</span> <span
                    class="hljs-title" style="color: rgb(37, 127, 173);">GregorianCalendar</span>(...)
</span></pre>
                <p>
                  К сожалению, множество праздников оказывается незамкнутым при наследовании. Среди открытых методов из
                  класса GregorianCalendar имеется метод
                  add (), который может превратить праздничные дни в будничные следующим
                  образом:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Holiday Christmas;
Christmas.add(Calendar.DAY_OF_MONTH, <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>);</pre>
                <p>
                  Следовательно, наследование в данном случае не подходит. Следует, однако,
                  иметь в виду, что подобные затруднения не возникают, если используется класс
                  Local Date. Этот класс является неизменяемым, и поэтому в нем отсутствует
                  метод, способный превратить праздничный день в будничный.

                </p>
              </li>
              <li>
                <p>
                  Переопределяя метод, не изменяйте его предполагаемое поведение
                </p>

                <p>
                  Принцип подстановки распространяется не только на синтаксис, но и на поведение, что важнее. При
                  переопределении метода не следует без особых на то
                  причин изменять его поведение. В этом компилятор вам не поможет. Ведь он
                  не в состоянии проверить, оправдано ли переопределение метода. Допустим,
                  требуется устранить упомянутый выше недостаток метода add () из класса
                  Holiday, переопределив этот метод таким образом, чтобы он, например, не
                  выполнял никаких действий или же возвращал следующий праздничный день.
                  Но такое переопределение нарушает принцип подстановки. При выполнении
                  приведенной ниже последовательности операторов пользователь вправе ожидать вполне определенного
                  поведения и соответствующего результата, независимо от того, является ли объект х экземпляром класса
                  GregorianCalendar или
                  Holiday.

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> dl = х.get(Calendar.DAY_OF_MONTH);
x.add(Calendar.DAY_OF_MONTH, <span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>);
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> d2 = x.get(Calendar.DAY_OF_MONTH);
System.out.println(d2 - dl);</pre>
                <p>
                  Безусловно, такой поход содержит камень преткновения. Разные пользователи посчитают естественным
                  различное поведение программы. Так, по мнению
                  некоторых, принцип подстановки требует, чтобы в методе Manager. equals ()
                  не учитывалась премия в поле bonus, поскольку она игнорируется в методе
                  Employee. equals (). Подобные споры могут длиться бесконечно и не дать никакого результата. Поэтому,
                  принимая конкретное решение, следует руководствоваться теми целями, для которых создается программа.
                </p>
              </li>
              <li>
                <p>
                  Пользуйтесь принципом полиморфизма, а не данными о типе.

                </p>
                <p>
                  Вспомните о принципе полиморфизма, как только увидите код, имеющий следующий вид:

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (х типа <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">1</span>)
действие<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>(х);
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span> <span class="hljs-keyword"
                                                                                style="color: rgb(107, 107, 184);">if</span> (х типа <span
                      class="hljs-number" style="color: rgb(147, 92, 37);">2</span>)
действие<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>(х);</pre>
                <p>
                  Имеют ли дейст вие_1 и дейст вие_2 общий характер? Если имеют, то поместите соответствующие методы в
                  общий суперкласс или интерфейс обоих типов. Тогда можно просто сделать приведенный ниже вызов и
                  выполнить правильное действие с помощью механизма динамического связывания, присущего полиморфизму.
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">х .действие();
</pre>
                <p>
                  Код, в котором применяется принцип полиморфизма или реализован интерфейс, намного легче сопровождать
                  и расширять, чем код, изобилующий проверками типов
                </p>
              </li>
              <li>
                <p>
                  Не злоупотребляйте механизмом рефлексии.
                </p>
                <p>
                  Механизм рефлексии позволяет создавать программы с высоким уровнем
                  абстракции, где поля и методы определяются во время выполнения. Такая
                  возможность чрезвычайно полезна для системного программирования, но
                  для прикладного — практически не нужна. Рефлексия — очень хрупкий механизм, поскольку компилятор не
                  может помочь в обнаружении ошибок. Все
                  ошибки проявляются во время выполнения программы и приводят к возникновению исключени
                </p>
              </li>
            </ul>

            <p>
              В этой главе было показано, каким образом в Java поддерживаются основные понятия и принципы ООП: классы,
              наследование и полиморфизм. А в следующей главе мы затронем две более сложные темы, которые очень важны
              для эффективного
              программирования на Java: интерфейсы и лямбда-выражения
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
          Почему не стоит использовать рефлексию?
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
          Почему не стоит использовать рефлексию?
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
  name: "RecomendationUseInheritance",
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

      selected: 'Усложнение кодовой базы',
      options: [
        {
          item: 'Усложнение кодовой базы',
          name: 'Усложнение кодовой базы'
        },
        {
          item: 'Излишняя затратность операций',
          name: 'Излишняя затратность операций'
        },
        {
          item: 'Непредсказуемость результата',
          name: 'Непредсказуемость результата'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fourthchapter/', {
        params: {
          numberTheme: 15,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[14].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[14].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[14].task.answer

          window.frontendData.language.chapters[3].listThemes[14].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[14].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[14].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[14].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[14].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[14].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[14].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-4-chapter-7-theme');

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