<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton theme-name="Область видимости блоков"
                   path-theme="/language/java/languageconstruction/managelogic/placevisibleblock" id="java-2-chapter-8-them-1-subtheme"/>
      <ThemeButton theme-name="Условные операторы"
                   path-theme="/language/java/languageconstruction/managelogic/conditionaloperators" id="java-2-chapter-8-them-2-subtheme"/>
      <ThemeButton theme-name="Неопределенные циклы "
                   path-theme="/language/java/languageconstruction/managelogic/undefindedcycle" id="java-2-chapter-8-them-3-subtheme"/>
      <ThemeButton theme-name="Определенные циклы"
                   path-theme="/language/java/languageconstruction/managelogic/cycle" id="java-2-chapter-8-them-4-subtheme"/>
      <ThemeButton theme-name="Оператор switch"
                   path-theme="/language/java/languageconstruction/managelogic/switch" id="java-2-chapter-8-them-5-subtheme"/>
      <ThemeButton theme-name="Операторы прерывания логики"
                   path-theme="/language/java/languageconstruction/managelogic/breaksoperation" id="java-2-chapter-8-them-6-subtheme"/>
    </div>
    <ChapterButton chapter-name="Управляющая логика" class="theme-level-2-chapter-left" id="java-2-chapter-8-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ManageLogic",
  components: {ChapterButton, ThemeButton},
  mounted() {
   const arrowFromChapter2Theme8SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-them-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme8SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme8SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-them-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme8SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-them-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme8SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-them-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme8SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-them-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme8SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme8SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme8SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme8SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme8SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme8SubTheme6.node);
  }
}
</script>

<style scoped>

</style>