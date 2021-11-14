<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Подстроки"
                   path-theme="/language/java/languageconstruction/symbol/substr"
                   id="java-2-chapter-6-them-1-subtheme"/>
      <ThemeButton theme-name="Сцепление строк"
                   path-theme="/language/java/languageconstruction/symbol/concatinationstr"
                   id="java-2-chapter-6-them-2-subtheme"/>
      <ThemeButton theme-name="Принцип постоянства символьных строк"
                   path-theme="/language/java/languageconstruction/symbol/constantlysymbolstr"
                   id="java-2-chapter-6-them-3-subtheme"/>
      <ThemeButton theme-name="Проверка символьных строк на равенство"
                   path-theme="/language/java/languageconstruction/symbol/checkingsymbolequality"
                   id="java-2-chapter-6-them-4-subtheme"/>
      <ThemeButton theme-name="Пустые и нулевые строки"
                   path-theme="/language/java/languageconstruction/symbol/emptyzerostr"
                   id="java-2-chapter-6-them-5-subtheme"/>
      <ThemeButton theme-name="Кодовые точки и единицы"
                   path-theme="/language/java/languageconstruction/symbol/codepoint"
                   id="java-2-chapter-6-them-6-subtheme"/>
      <ThemeButton theme-name="API класса String"
                   path-theme="/language/java/languageconstruction/symbol/apistr"
                   id="java-2-chapter-6-them-7-subtheme"/>
      <ThemeButton theme-name="Построение символьных строк "
                   path-theme="/language/java/languageconstruction/symbol/buildingstr"
                   id="java-2-chapter-6-them-8-subtheme"/>
    </div>
    <ChapterButton chapter-name="Символьные строки" class="theme-level-2-chapter-left" id="java-2-chapter-6-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "SymbolStr",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter2Theme6SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme6SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-them-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme8.node);

  }
}
</script>

<style scoped>

</style>