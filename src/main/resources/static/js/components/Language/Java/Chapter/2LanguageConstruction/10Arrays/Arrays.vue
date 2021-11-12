<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Объявление массивов"
                   path-theme="/language/java/languageconstruction/arrays/introductionarray"/>
      <ThemeButton theme-name="Доступ к элементам массива "
                   path-theme="/language/java/languageconstruction/arrays/accesstoelement"/>
      <ThemeButton theme-name="Цикл в стиле for each"
                   path-theme="/language/java/languageconstruction/arrays/foreach"/>
      <ThemeButton theme-name="Копирование массивов"
                   path-theme="/language/java/languageconstruction/arrays/copymassive"/>
      <ThemeButton theme-name="Параметры командной строки"
                   path-theme="/language/java/languageconstruction/arrays/parametherscmd"/>
      <ThemeButton theme-name="Сортировка массивов"
                   path-theme="/language/java/languageconstruction/arrays/sortingmassive"/>
      <ThemeButton theme-name="Многомерные массивы"
                   path-theme="/language/java/languageconstruction/arrays/multidimentionalmassive"/>
      <ThemeButton theme-name="Неровные массивы"
                   path-theme="/language/java/languageconstruction/arrays/unevenmassive"/>
    </div>
    <ChapterButton chapter-name="Массивы" class="theme-level-2-chapter-left"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";

export default {
  name: "Arrays",
  components: {ChapterButton, ThemeButton}
}
</script>

<style scoped>

</style>