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
          Целочисленные типы данных
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Целочисленные типы данных служат для представления как положительных, так
              и отрицательных чисел без дробной части. В языке Java имеются четыре целочисленных типа. Все они
              представлены в табл.
            </p>

            <div>
              <b-table :bordered="true" hover :items="items" class="page-theme-theory-text" caption-top></b-table>
            </div>

            <p>Как правило, наиболее удобным оказывается тип in t. Так, если требуется представить в числовом виде
              количество обитателей планеты, то нет никакой нужды прибегать к типу lo n g . Типы byte и sh o rt
              используются, главным образом, в специальных
              приложениях, например, при низкоуровневой обработке файлов или ради экономии
              памяти при формировании больших массивов данных, когда во главу угла ставится
              размер информационного хранилища.
            </p>
            <p>
              В языке Java диапазоны допустимых значений целочисленных типов не зависят
              от машины, на которой выполняется программа. Это существенно упрощает перенос
              программного обеспечения с одной платформы на другую. Сравните данный подход
              с принятым в С и C++, где используется наиболее эффективный тип для каждого конкретного процессора. В
              итоге программа на С, которая отлично работает на 32-разрядном процессоре, может привести к
              целочисленному переполнению в 16-разрядной системе. Но программы на Java должны одинаково работать на
              всех машинах, и поэтому
              диапазоны допустимых значений для различных типов данных фиксированы.
            </p>
            <p>
              Длинные целые числа указываются с суффиксом L (например, 4000000000L),
              шестнадцатеричные числа — с префиксом Ох (например, OxCAFE), восьмеричные
              числа — с префиксом 0. Так, 010 — это десятичное число 8 в восьмеричной форме.
              Такая запись иногда приводит к недоразумениям, поэтому пользоваться восьмеричными числами не
              рекомендуется.
            </p>
            <p>Начиная с версии Java 7 числа можно указывать и в двоичной форме с префиксом
              ОЬ или ОВ. Например, 0 Ы 0 0 1 — это десятичное число 9 в двоичной форме. Кроме
              того, начиная с версии Java 7 числовые литералы можно указывать со знаками подчеркивания, как, например,
              1_000_000 (или 0b111_0100_0010_010(000) для обозначения одного миллиона.
              Знаки подчеркивания добавляются только ради повышения удобочитаемости больших чисел, а компилятор Java
              просто удаляет их.
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
public class FirstSample
{
   public static void main(String[] args)
   {
      int a = 15;
      short b = 10;
      System.out.println(a + b);
   }
}
        </textarea>

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
          Что выведет программа?
        </label>
        <textarea id="codeContentIdAnswered"></textarea>
        <p class="page-theme-theory-text">
          Ваш ответ: {{answer}}
        </p>
      </div>

      <div class="box animate" style="" v-show="animationOn">Успех</div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";
import * as CodeMirror from "codemirror"
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "IntType",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      items: [
        {
          Тип: "int",
          Требуемый_объем_памяти_в_байтах: 4,
          Диапазон_опустимых_значений: 'От -2147483648 ДО 2147483647 (т.е. больше 2 млрд.)\n'
        },
        {
          Тип: "short",
          Требуемый_объем_памяти_в_байтах: 2,
          Диапазон_опустимых_значений: 'От-32768 до 32767\n'
        },
        {
          Тип: "long",
          Требуемый_объем_памяти_в_байтах: 8,
          Диапазон_опустимых_значений: 'От -9223372036854775808 ДО -9223372036854775807\n'
        },
        {
          Тип: "byte",
          Требуемый_объем_памяти_в_байтах: 1,
          Диапазон_опустимых_значений: 'От-128 ДО 127\n'
        }
      ],
      selected: '10',
      options: [
        {item: '10', name: '10'},
        {item: '15', name: '15'},
        {item: '25', name: '25'},
        {item: 'ErrorCompile', name: 'ErrorCompile'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[2].task.answer

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          this.$toasted.error("Неверный ответ", {
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
      setTimeout(() => {
        $('.CodeMirror').each(function(i, el){
          el.CodeMirror.refresh();
        });
      }, 1000)
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[2].task.answer
    }

    this.codeContent = CodeMirror.fromTextArea(document.getElementById('codeContentId'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent = CodeMirror.fromTextArea(document.getElementById('codeContentIdAnswered'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

      this.codeAnsweredContent.setValue(
          `public class FirstSample
{
   public static void main(String[] args)
   {
      int a = 15;
      short b = 10;
      System.out.println(a + b);
   }
}
      `)

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-3-them-1-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if(pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>