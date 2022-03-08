<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name=" Математические функции и константы"
                   path-theme="/language/java/languageconstruction/operations/mathfunction"
                   id="java-2-chapter-5-them-2-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Преобразование числовых типов"
                   path-theme="/language/java/languageconstruction/operations/transformationdigittype"
                   id="java-2-chapter-5-them-3-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Приведение типов"
                   path-theme="/language/java/languageconstruction/operations/bringingtype"
                   id="java-2-chapter-5-them-4-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Сочетание арифметических операций с присваиванием"
                   path-theme="/language/java/languageconstruction/operations/combinationarithmetoper"
                   id="java-2-chapter-5-them-5-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Операции инкремента и декремента"
                   path-theme="/language/java/languageconstruction/operations/incrementdecrement"
                   id="java-2-chapter-5-them-6-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name=" Операции отношения и логические операции "
                   path-theme="/language/java/languageconstruction/operations/relationshionshipoperation"
                   id="java-2-chapter-5-them-7-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Поразрядные логические операции"
                   path-theme="/language/java/languageconstruction/operations/bitwise"
                   id="java-2-chapter-5-them-8-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Круглые скобки и иерархия операций"
                   path-theme="/language/java/languageconstruction/operations/hierarchyoperation"
                   id="java-2-chapter-5-them-9-subtheme"/>
    </div>
    <ChapterButton chapter-name="Операции" class="theme-level-2-chapter-left" id="java-2-chapter-5-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Operation",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter2Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme5SubTheme9 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-them-9-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme8.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme5SubTheme9.node);

    let countProgressLocalTheme = 0

    for (let i = 10; i < 18; i++) {
      if (window.frontendData.language.chapters[1].listThemes[i].finished) {
        let k = i - 8
        document.getElementById("java-2-chapter-5-them-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 2.7;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 21) {
      document.getElementById("java-2-chapter-5-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 21)
        document.getElementById("java-2-chapter-5-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>