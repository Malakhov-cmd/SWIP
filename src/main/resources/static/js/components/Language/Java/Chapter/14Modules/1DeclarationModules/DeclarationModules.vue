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
          Понятие модуля
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Основными стандартными блоками в ООП служат классы, обеспечивающие
              инкапсуляцию. Закрытые функциональные средства класса вроде методов могут
              быть доступны в коде только по специальному разрешению. В связи с этим возникает вопрос о правах доступа.
              Та к, если закрытая переменная изменилась, то
              можно выявить всех, кто мог быть тому виной. А есл и требуется видоизменить
              :!акрытое предстаиление, то должно бып, заранее извест1ю, на какие методы это
              окажет воздействие.
            </p>

            <p>
              Более крупное организационное группирование в Java обеспечивают па кеты,
              представляющие собой коллекцию классов. Пакеты обеспечивают также соответствующий уровень инкапсуляции.
              Любое функциональное средство (как открытое, так и закрытое) доступно в пакете только из методов,
              находящихся в том же
              самом пакете.
            </p>

            <p>
              Но в крупных системах такого уроиня управления доступом явно недостаточно. Любое функциональное средство,
              которое является открытым, т.е. доступным
              :1а пределами па кета, оказывается доступным поиск>Ду. Допустим, требуется видоизменить или исключить
              редко испол1,:1уемое функционал 1,ное средство. Если
              оно является открытым, то очень трудно предвидеть последствия такого изменения. На это препятствие
              натолкнулись в свое время разработчики платформы
              Java . Комплект JDK стрем ительно ра:шивался в течение более двадцати лет, но
              некоторые его функциональные средства явно устарели. Характерным тому примером служит архитектура CORBA.
              Вряд ли кто-нибуд1, из разработчиков вспомнит, когда пользовался пакетом org . omg . co rba в последний
              раз, хотя он неизменно включался в комплект JDK иплоп, до версии Java 1 0. Начиная с версии Java
              1 1, тем немногим ра зработчикам, кому этот пакет все еще может понадобип,ся,
              придется ввести требующиеся архивные JАR-файлы в свои проекты.
            </p>
            <p>
              А как насчет пакета j ava. awt? Ведь он вряд ли потребуется в серверном приложении, за искл ючением
              класса j ava . awt . DataFlavo r, применяемого в реали
              :ыции SOAP - протокола для веб-служб на основе XML.

            </p>

            <p>
              Столкнувшись с проблемой растущего как снеж11ый ком объема кода, разработчики платформы Java решили, что
              им необходим ка кой-то мехавизм структурировавия, обеспечивающий больший контроль 11ад кодом. С этой
              целью они
              проанализировали существующие модульные системы (1 1апример, OSGi) и нашли их непригодными для решения
              стоявшей перед ними :iадачи. Поэтому они
              разработали новую систему под 1ызва11ием /ava Platform Module System, которая теперь входит в состав
              языка и виртуальной маши11ы J ava. Эга модульная система
              была успешно использована для модуляризации прикладного интерфейса Java
              АР!, и вы можете при желании прибегнуть к ней в своих приложениях.
            </p>
            <p>
              Модуль на платформе Java состоит из следующих частей.
            </p>
            <ul>
              <li>
                <p>
                  Коллекция пакетов.
                </p>
              </li>
              <li>
                <p>
                  Дополнительные файлы ресурсов и прочие фа йлы, включая платформев110-ориентированные библиотеки .
                </p>
              </li>
              <li>
                <p>
                  Список па кетов, доступных в модуле.
                </p>
              </li>
              <li>
                <p>
                  Список всех модулей, от которых зависит да нный модул1,.
                </p>
              </li>
            </ul>
            <p>
              Инкапсуляция и зависимости соблюдаются на платформе Java ка к во время
              компиляции, так и при выполнении в виртуалыюй машине. А зачем вообще
              рассматривать применение модульной системы на платформе Java в собственных
              программах, если можно придерживаться традиционного подхода к архивным
              JАR-файлам, доступным по пути к классам? Применение модульной системы
              на платформе Java дает следующие преимущества .
            </p>
            <ul>
              <li>
                <p>
                  Строгая инкапсуляция. Доступ к конкретным пакетам можно контролировать, ве особевно беспокояс�, о
                  поддержавии кода, который не предназначается для общего употреблевия.
                </p>
              </li>
              <li>
                <p>
                  Надежная конфигурация. Позволяет избежать та ких затруднений, связанных с путями к общедоступ11ым
                  классам, как дублирование или отсутствие
                  классов.
                </p>
              </li>
            </ul>
            <p>
              Тем ве менее имеется ряд вопросов, которые модул r,ная система на платформе Java не в состоянии
              разрешить. К их ч ислу опюсится контроль версий
              модулей, отсутствие возможности указывать конкретную версию требующегося
              модуля или применять нескол ько версий модуля в одной и той же прикладной
              программе. Но для того чтобы восполь:юваться этими стол�, желанными 1юзможностям11, придется обратип,ся к
              другим механизмам вместо модул1,ной системы
              на платформе Java .
            </p>

            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
              Хорстманном.
            </div>
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Для чего может потребоваться добавления модулей в программу?
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
          Для чего может потребоваться добавления модулей в программу?
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
  name: "DeclarationModules",
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

      selected: 'Для разбиения большео числа классов по сущностям',
      options: [
        {
          item: 'Для разбиения большео числа классов по сущностям',
          name: 'Для разбиения большео числа классов по сущностям'
        },
        {
          item: 'Для разграничения логических структур (компонентов) в больших приложениях',
          name: 'Для разграничения логических структур (компонентов) в больших приложениях'
        },
        {
          item: 'Для объединения с другими приложениями',
          name: 'Для объединения с другими приложениями'
        },
        {
          item: 'Все вышеперечисленное',
          name: 'Все вышеперечисленное'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/twelfthchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[11].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[11].chapterProgress += 20
              window.frontendData.language.chapters[11].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[11].listThemes[0].task.answer

          window.frontendData.language.chapters[11].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[11].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[11].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[11].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[11].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-14-chapter-1-theme');

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