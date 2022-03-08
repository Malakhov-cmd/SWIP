<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name="Объявление массивов"
                   path-theme="/language/java/languageconstruction/arrays/introductionarray" id="java-2-chapter-10-them-1-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Цикл в стиле for each"
                   path-theme="/language/java/languageconstruction/arrays/foreach" id="java-2-chapter-10-them-2-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Копирование массивов"
                   path-theme="/language/java/languageconstruction/arrays/copymassive" id="java-2-chapter-10-them-3-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Сортировка массивов"
                   path-theme="/language/java/languageconstruction/arrays/sortingmassive" id="java-2-chapter-10-them-4-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Многомерные массивы"
                   path-theme="/language/java/languageconstruction/arrays/multidimentionalmassive" id="java-2-chapter-10-them-5-subtheme"/>
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
        direction: DIRECTION.LEFT,
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
        direction: DIRECTION.BOTTOM,
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
        direction: DIRECTION.BOTTOM,
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

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme10SubTheme5.node);

    let countProgressLocalTheme = 0

    for (let i = 32; i < 37; i++) {
      if (window.frontendData.language.chapters[1].listThemes[i].finished) {
        let k = i - 31
        document.getElementById("java-2-chapter-10-them-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 2.7;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 13) {
      document.getElementById("java-2-chapter-10-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 13)
        document.getElementById("java-2-chapter-10-theme").setAttribute("style", "background: #28a745; border: green;")
    }
    }
}
</script>

<style scoped>

</style>