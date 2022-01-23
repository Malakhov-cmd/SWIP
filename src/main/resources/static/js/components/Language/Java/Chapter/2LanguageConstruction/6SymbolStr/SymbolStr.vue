<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name="Подстроки"
                   path-theme="/language/java/languageconstruction/symbol/substr"
                   id="java-2-chapter-6-them-1-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Сцепление строк"
                   path-theme="/language/java/languageconstruction/symbol/concatinationstr"
                   id="java-2-chapter-6-them-2-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Принцип постоянства символьных строк"
                   path-theme="/language/java/languageconstruction/symbol/constantlysymbolstr"
                   id="java-2-chapter-6-them-3-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Проверка символьных строк на равенство"
                   path-theme="/language/java/languageconstruction/symbol/checkingsymbolequality"
                   id="java-2-chapter-6-them-4-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Построение символьных строк "
                   path-theme="/language/java/languageconstruction/symbol/buildingstr"
                   id="java-2-chapter-6-them-5-subtheme"/>
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
        direction: DIRECTION.LEFT,
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
        direction: DIRECTION.BOTTOM,
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
        direction: DIRECTION.BOTTOM,
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

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme6SubTheme5.node);

    let countProgressLocalTheme = 0

    for (let i = 18; i < 23; i++) {
      if (window.frontendData.language.chapters[1].listThemes[i].finished) {
        let k = i - 17
        document.getElementById("java-2-chapter-6-them-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 2.7;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 13) {
      document.getElementById("java-2-chapter-6-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 13)
        document.getElementById("java-2-chapter-6-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>