<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Арифметические операции"
                   path-theme="/language/java/languageconstruction/operations/arithmeticoperation"/>
      <ThemeButton theme-name=" Математические функции и константы"
                   path-theme="/language/java/languageconstruction/operations/mathfunction"/>
      <ThemeButton theme-name="Преобразование числовых типов"
                   path-theme="/language/java/languageconstruction/operations/transformationdigittype"/>
      <ThemeButton theme-name="Приведение типов"
                   path-theme="/language/java/languageconstruction/operations/bringingtype"/>
      <ThemeButton theme-name="Сочетание арифметических операций с присваиванием"
                   path-theme="/language/java/languageconstruction/operations/combinationarithmetoper"/>
      <ThemeButton theme-name="Операции инкремента и декремента"
                   path-theme="/language/java/languageconstruction/operations/incrementdecrement"/>
      <ThemeButton theme-name=" Операции отношения и логические операции "
                   path-theme="/language/java/languageconstruction/operations/relationshionshipoperation"/>
      <ThemeButton theme-name="Поразрядные логические операции"
                   path-theme="/language/java/languageconstruction/operations/bitwise"/>
      <ThemeButton theme-name="Круглые скобки и иерархия операций"
                   path-theme="/language/java/languageconstruction/operations/hierarchyoperation"/>
    </div>
    <ChapterButton chapter-name="Операции" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "Operation",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>