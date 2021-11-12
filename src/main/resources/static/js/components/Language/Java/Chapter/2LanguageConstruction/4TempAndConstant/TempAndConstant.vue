<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Объявление переменных"
                   path-theme="/language/java/languageconstruction/themeandconstant/introductiontemp"/>
      <ThemeButton theme-name="Инициализация переменных"
                   path-theme="/language/java/languageconstruction/themeandconstant/initializetemp"/>
      <ThemeButton theme-name="Константы"
                   path-theme="/language/java/languageconstruction/themeandconstant/constants"/>
      <ThemeButton theme-name="Перечислимые типы"
                   path-theme="/language/java/languageconstruction/themeandconstant/enum"/>
    </div>
    <ChapterButton chapter-name="Переменные и константы" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "TempAndConstant",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>