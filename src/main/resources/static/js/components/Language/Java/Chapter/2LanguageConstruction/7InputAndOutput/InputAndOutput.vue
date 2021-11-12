<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Чтение вводимых данных"
                   path-theme="/language/java/languageconstruction/inputoutput/readinputdata"/>
      <ThemeButton theme-name=" Форматирование выводимых данных"
                   path-theme="/language/java/languageconstruction/inputoutput/formattingoutputdata"/>
      <ThemeButton theme-name="Файловый ввод и вывод"
                   path-theme="/language/java/languageconstruction/inputoutput/fileoutputdata"/>
    </div>
    <ChapterButton chapter-name="Ввод и вывод" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "InputAndOutput",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>