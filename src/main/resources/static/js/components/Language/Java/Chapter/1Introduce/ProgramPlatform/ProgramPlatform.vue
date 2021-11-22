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
          Программная платформа Java
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            Java никогда не был только языком.
            Хорошие языки - не редкость, а появление некоторых из них вызвало в свое время
            насrоящую сенсацию в обласrи вычислительной техники. В отличие от них, Java -
            это программная платформа, включающая в себя мощную библиотеку, большой объъем кода, пригодного для
            повторного использования, а также среду для выполнения
            программ, которая обеспечивает безопасносrь, независимость от операционной системы и автоматическую сборку
            "мусора".
            Программисrам нужны языки с четкими синтаксическими правилами и понятной
            семантикой (т.е. определенно не С++). Такому требованию, помимо Java, отвечают
            десятки языков. Некоторые из них даже обеспечивают переносимосrь и сборку "мусора", но их библиотеки
            осrавляют желать много лучшего. В итоге программисrы вынуждены самосrоятельно реализовывать графические
            операции, доступ к сети и базе
            данных и другие часrо встречающиеся процедуры. Java объединяет в себе прекрасный язык, высококачесrвенную
            среду выполнения программ и обширную библиотеку. В результате многие программисrы осrановили свой выбор
            именно на Java.
          </div>
          <div class="page-theme-author-text text-white-50">
            Приведенный материал был взят из книги "Java. Библиотека профессионала, том 1.", написанной Кейем С.
            Хорстманном.
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label for="input-live" class="page-theme-question-text">Что думаете об этом языке?:</label>
        <b-form-input
            id="input-live"
            v-model="name"
            :state="nameState"
            aria-describedby="input-live-help input-live-feedback"
            placeholder="Введите ваше мнение"
            trim
        ></b-form-input>

        <!-- This will only be shown if the preceding input has an invalid state -->
        <b-form-invalid-feedback id="input-live-feedback">
          Enter at least 3 letters
        </b-form-invalid-feedback>

        <!-- This is a form text block (formerly known as help block) -->
        <b-form-text id="input-live-help">Введите ваше мнение</b-form-text>
      </div>

      <div v-show="!showInput">
        <p class="page-theme-theory-text">
          Your answer is: "{{ answer }}"
        </p>
      </div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ProgramPlatform",
  computed: {
    nameState() {
      if (this.name.length > 2){
        const answerPattern = /([A-Za-zА-Яа-я 1-9]{1})*/;

        if(this.name.match(answerPattern)[0].length === this.name.length){
          this.allowSend = true
          return true
        }
      }
      return false
    }
  },
  data() {
    return {
      name: '',
      showInput: true,
      answer: "",
      allowSend: false
    }
  },
  methods: {
    Request() {
      if (this.allowSend === true) {
        axios.get('http://localhost:9000/java/firstchapter/', {
          params: {
            numberTheme: 1,
            answer: this.name,
            userId: window.frontendData.profile.id
          }
        })
            .then(function (response) {
              console.log(response.data);
            })
            .catch(function (error) {
              console.log(error);
            });
        this.showInput = false
      } else {
        console.log("here")
        this._vm.$bvToast.toast(`Toast body content`, {
          title: `Toaster b-toaster-bottom-right`,
          toaster: 'b-toaster-bottom-right',
          solid: true,
          appendToast: true,
          variant: 'warning',
          autoHideDelay: 5000000,
        })
      }
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[0].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[0].listThemes[0].task.answer
    }
  }
}
</script>

<style scoped>

</style>