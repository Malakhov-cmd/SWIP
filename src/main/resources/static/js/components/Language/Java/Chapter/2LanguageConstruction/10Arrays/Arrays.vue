<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name="Объявление массивов"
                   path-theme="/language/java/languageconstruction/arrays/introductionarray" id="java-2-chapter-10-them-1-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Доступ к элементам массива "
                   path-theme="/language/java/languageconstruction/arrays/accesstoelement" id="java-2-chapter-10-them-2-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Цикл в стиле for each"
                   path-theme="/language/java/languageconstruction/arrays/foreach" id="java-2-chapter-10-them-3-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Копирование массивов"
                   path-theme="/language/java/languageconstruction/arrays/copymassive" id="java-2-chapter-10-them-4-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Параметры командной строки"
                   path-theme="/language/java/languageconstruction/arrays/parametherscmd" id="java-2-chapter-10-them-5-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Сортировка массивов"
                   path-theme="/language/java/languageconstruction/arrays/sortingmassive" id="java-2-chapter-10-them-6-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Многомерные массивы"
                   path-theme="/language/java/languageconstruction/arrays/multidimentionalmassive" id="java-2-chapter-10-them-7-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Неровные массивы"
                   path-theme="/language/java/languageconstruction/arrays/unevenmassive" id="java-2-chapter-10-them-8-subtheme"/>
    </div>
    <ChapterButton chapter-name="Массивы" class="theme-level-2-chapter-left" id="java-2-chapter-10-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Arrays",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter2Theme10SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme10SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-them-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme8.node);
  }
}
</script>

<style scoped>

</style>