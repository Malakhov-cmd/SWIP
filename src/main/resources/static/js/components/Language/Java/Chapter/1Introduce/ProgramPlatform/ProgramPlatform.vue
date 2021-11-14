<template>
  <div class="page-theme">
    <b-jumbotron>

      <template #header>
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

      <div role="group" class="page-theme-form">
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
        <b-form-text id="input-live-help">Введите ваше имя</b-form-text>
      </div>
      <b-btn class="my-b-btn page-theme-btn-submit">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
export default {
  name: "ProgramPlatform",
  computed: {
    nameState() {
      return this.name.length > 2
    }
  },
  data() {
    return {
      name: ''
    }
  }
}
</script>

<style scoped>

</style>