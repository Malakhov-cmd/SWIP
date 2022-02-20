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
          Проверка объектов на равенство и наследование
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Каким образом должен действовать метод equ als (), если неявные и явные его
              параметры не принадлежат одному и тому же классу? Это спорный вопрос. В предыдущем примере из метода
              equals () возвращалось логическое значение fa ls e , если
              классы не совпадали полностью. Но многие программисты пользуются следующей
              проверкой:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (!(otherObject <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">instanceof</span> Employee)) <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">false</span>;
</pre>

            <p>При этом остается вероятность, что объект otherObject принадлежит подклассу.
              Поэтому такой подход может стать причиной непредвиденных осложнений. Спецификация Java требует, чтобы
              метод equals () обладал следующими характеристиками.
            </p>
            <ul>
              <li>
                <p>
                  Рефлексивность. При вызове х . equals (х) по любой ненулевой ссылке х должно возвращаться логическое
                  значение true.
                </p>
              </li>
              <li>
                <p>
                  Симметричность. При вызове х . equ als (у) по любым ссылкам х и у должно
                  возвращаться логическое значение tru e тогда и только тогда, когда при вызове
                  у. equals (х) возвращается логическое значение true.

                </p>
              </li>
              <li>
                <p>
                  Транзитивность. Если при вызовах х . eq u als (у) и у . eq u als (z) по любым
                  ссылкам х, у и z возвращается логическое значение tru e , то и при вызове
                  х . equals (z) возвращается логическое значение true.

                </p>
              </li>
              <li>
                <p>
                  Согласованность. Если объекты, на которые делаются ссылки х и у, не изменяются, то при повторном
                  вызове х . equ als (у) должно возвращаться то же самое значение.
                </p>
                <p>
                  При вызове х . equals (n u ll) по любой непустой ссылке х должно возвращаться логическое значение fa
                  ls e
                </p>
              </li>
            </ul>
            <p>
              Обоснованность приведенных выше правил не вызывает сомнений. Так, совершенно очевидно, что результаты
              проверки не должны зависеть от того, делается ли в программе вызов х . equ als (у) или у . equ als (х ).
              Но применение правила симметрии
              имеет свои особенности, если явный и неявный параметры принадлежат разным
              классам. Рассмотрим следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">е.equals(m)</pre>
            <p>
              где объект е принадлежит классу Employee, а объект m — классу Manager, причем
              каждый из них содержит одинаковые имена, зарплату и дату приема на работу. Если
              при вызове е.equals (m) выполняется проверка с помощью операции instanceof,
              то возвращается логическое значение true. Но это означает, что и при обратном вызове m. equals (е) также
              должно возвращаться логическое значение true, поскольку
              правило симметричности не позволяет возвращать логическое значение false или
              генерировать исключение.

            </p>
            <p>
              В итоге класс Manager попадает в затруднительное положение. Его метод equals ()
              должен сравнивать объект данного класса с любым объектом типа Employee без учета
              данных, позволяющих отличить руководящего работника от рядового! И в этом случае операция instanceof
              выглядит менее привлекательно.
            </p>
            <p>
              Некоторые специалисты считают, что проверка с помощью метода getClassO некорректна, поскольку в этом
              случае нарушается принцип подстановки. В подтверждение они приводят метод equals () из класса
              AbstractSet, который проверяет, содержат
              ли два множества одинаковые элементы и расположены ли они в одинаковом порядке.
              Класс AbstractSet выступает в роли суперкласса для классов TreeSet и HashSet, которые не являются
              абстрактными. В этих классах применяются различные алгоритмы
              для обращения к элементам множества. Но на практике требуется иметь возможность
              сравнивать любые два множества, независимо от того, как они реализованы.
            </p>
            <p>
              Следует, однако, признать, что рассматриваемый здесь пример слишком специфичен. В данном случае имело бы
              смысл объявить метод AbstractSet. equals () конечным,
              чтобы нельзя было изменить семантику проверки множеств на равенство. (На самом
              деле при объявлении метода ключевое слово final не указано. Это дает возможность
              подклассам реализовать более эффективный алгоритм проверки на равнозначность.)

            </p>
            <p>
              Таким образом, возникают два разных варианта.
            </p>
            <ul>
              <li>
                <p>
                  Если проверка на равенство реализована в подклассе, правило симметричности требует использовать метод
                  getClass ().

                </p>
              </li>
              <li>
                <p>
                  Если же проверка на равенство производится средствами суперкласса, можно
                  выполнить операцию instanceof. В этом случае возможна ситуация, когда два
                  объекта разных классов будут признаны равными.
                </p>
              </li>
            </ul>
            <p>
              В примере с рядовыми и руководящими работниками два объекта считаются равными, если их поля совпадают.
              Так, если имеются два объекта типа Manager с одинаковыми именами, заработной платой и датой приема на
              работу, но с отличающимися величинами премии, такие объекты следует признать разными. А для этого
              требуется проверка с помощью метода getClass ().

            </p>
            <p>
              Но допустим, что для проверки на равенство используется идентификационный номер работника. Такая проверка
              имеет смысл для всех подклассов. В этом случае можно
              выполнить операцию instanceof и объявить метод Employee.equals () как final.

            </p>
            <p>
              Ниже приведены рекомендации для создания приближающегося к идеалу метода
              equals ().
            </p>

            <ul>
              <li>
                <p>
                  Присвойте явному параметру имя otherObject. Впоследствии его тип нужно
                  будет привести к типу другой переменной под названием other.
                </p>
              </li>
              <li>
                <p>
                  Присвойте явному параметру имя otherObject. Впоследствии его тип нужно

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (<span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">this</span> == otherObject) <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                                style="color: rgb(107, 107, 184);">true</span>;</pre>
                <p>
                  Это выражение составлено лишь в целях оптимизации проверки. Ведь намного
                  быстрее проверить одинаковость ссылок, чем сравнивать поля объектов.
                </p>
              </li>
              <li>
                <p>
                  Выясните, является ли ссылка otherObject пустой (null), как показано ниже.
                  Если она оказывается пустой, следует возвратить логическое значение false.
                  Эту проверку нужно сделать обязательно.
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (otherObject == <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>) <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">return</span> <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
</pre>

              </li>
              <li>
                <p>
                  Сравните классы this и otheObject. Если семантика проверки может измениться в подклассе,
                  воспользуйтесь методом getClass () следующим образом:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (getClass() != otherObject.getClass()) <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                                style="color: rgb(107, 107, 184);">false</span>;</pre>
                <p>
                  Если одна и та же семантика остается справедливой для всех подклассов, произведите проверку с помощью
                  операции instanceof следующим образом:

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (! (otherObject <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">instanceof</span> ИмяКласса)) <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                                style="color: rgb(107, 107, 184);">false</span>;
</pre>
              </li>
              <li>
                <p>
                  Приведите тип объекта otherObject к типу переменной требуемого класса:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ИмяКласса other = (ИмяКласса) otherObject;
</pre>
              </li>
              <li>
                <p>
                  Сравните все поля, как показано ниже. Для полей примитивных типов служит операция = , а для объектных
                  полей — метод Obj e c t s . equals (). Если все
                  поля двух объектов совпадают, возвращается логическое значение tru e, а иначе — логическое значение
                  fa ls e ,
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> поле<span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">1</span> == other.поле!
&amp;&amp; поле<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>.equals(other.поле<span
                      class="hljs-number" style="color: rgb(147, 92, 37);">2</span>)
&amp;&amp;</pre>
              </li>
            </ul>

            <p>
              Если вы переопределяете в подклассе метод equals (), в него следует включить
              вызов super.equals(other).
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
          В каких случаях стоит реализовывать метод equals()?
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
          В каких случаях стоит реализовывать метод equals()?
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
  name: "ExaminationObjectOnEqualAndInheritance",
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

      selected: 'В случае необходимости сравнения простых объектов',
      options: [
        {item: 'В случае необходимости сравнения простых объектов', name: 'В случае необходимости сравнения простых объектов'},
        {item: 'Для надежного сравнения примитивных типов', name: 'Для надежного сравнения примитивных типов'},
        {
          item: 'Для сравния объектов с учетом равенства всех полей',
          name: 'Для сравния объектов с учетом равенства всех полей'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[8].task.answer

          window.frontendData.language.chapters[3].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[8].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[8].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-4-chapter-2-theme-3-subtheme');

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