<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Перехват исключений"
                    path-theme="/language/java/exeption/InterceptionOneExeption"
                    id="java-6-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Оператор try с ресурсами"
                    path-theme="/language/java/exeption/OperatorTryWithResource"
                    id="java-6-chapter-2-theme-2-subtheme"/>
    </div>
    <chapter-button chapter-name="Перехват исключений" class="theme-level-6-chapter-left" id="java-6-chapter-2-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InterceptionExeption",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter6Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme2SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme5.node);

    let countProgressLocalTheme = 0

    for (let i = 3; i < 5; i++) {
      if (window.frontendData.language.chapters[5].listThemes[i].finished) {
        let k = i - 2
        document.getElementById("java-6-chapter-2-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 16.6;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 32) {
      document.getElementById("java-6-chapter-2-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 32)
        document.getElementById("java-6-chapter-2-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>