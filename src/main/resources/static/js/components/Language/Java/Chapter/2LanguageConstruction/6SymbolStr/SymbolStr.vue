<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Подстроки"
                   path-theme="/language/java/languageconstruction/symbol/substr"/>
      <ThemeButton theme-name="Сцепление строк"
                   path-theme="/language/java/languageconstruction/symbol/concatinationstr"/>
      <ThemeButton theme-name="Принцип постоянства символьных строк"
                   path-theme="/language/java/languageconstruction/symbol/constantlysymbolstr"/>
      <ThemeButton theme-name="Проверка символьных строк на равенство"
                   path-theme="/language/java/languageconstruction/symbol/checkingsymbolequality"/>
      <ThemeButton theme-name="Пустые и нулевые строки"
                   path-theme="/language/java/languageconstruction/symbol/emptyzerostr"/>
      <ThemeButton theme-name="Кодовые точки и единицы"
                   path-theme="/language/java/languageconstruction/symbol/codepoint"/>
      <ThemeButton theme-name="API класса String"
                   path-theme="/language/java/languageconstruction/symbol/apistr"/>
      <ThemeButton theme-name="Построение символьных строк "
                   path-theme="/language/java/languageconstruction/symbol/buildingstr"/>
    </div>
    <ChapterButton chapter-name="Символьные строки" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "SymbolStr",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>