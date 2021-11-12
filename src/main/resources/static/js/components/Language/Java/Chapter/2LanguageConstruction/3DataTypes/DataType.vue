<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Целочисленные типы данных"
                   path-theme="/language/java/languageconstruction/datatype/int"/>
      <ThemeButton theme-name="Числовые типы данных с плавающей точкой"
                   path-theme="/language/java/languageconstruction/datatype/float"/>
      <ThemeButton theme-name="Тип данных char"
                   path-theme="/language/java/languageconstruction/datatype/char"/>
      <ThemeButton theme-name="Тип данных boolean"
                   path-theme="/language/java/languageconstruction/datatype/boolean"/>
    </div>
    <ChapterButton chapter-name="Типы данных" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "DataType",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>