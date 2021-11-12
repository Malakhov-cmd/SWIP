<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Область видимости блоков"
                   path-theme="/language/java/languageconstruction/managelogic/placevisibleblock"/>
      <ThemeButton theme-name="Условные операторы"
                   path-theme="/language/java/languageconstruction/managelogic/conditionaloperators"/>
      <ThemeButton theme-name="Неопределенные циклы "
                   path-theme="/language/java/languageconstruction/managelogic/undefindedcycle"/>
      <ThemeButton theme-name="Определенные циклы"
                   path-theme="/language/java/languageconstruction/managelogic/cycle"/>
      <ThemeButton theme-name="Оператор switch"
                   path-theme="/language/java/languageconstruction/managelogic/switch"/>
      <ThemeButton theme-name="Операторы прерывания логики"
                   path-theme="/language/java/languageconstruction/managelogic/breaksoperation"/>
    </div>
    <ChapterButton chapter-name="Управляющая логика" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "ManageLogic",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>