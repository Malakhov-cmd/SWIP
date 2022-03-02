<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Применение аннотаций" class="theme-level-13-chapter-right"
                    id="java-13-chapter-3-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Введение в аннотации"
                    path-theme="/language/java/scenarioandannotation/IntroInAnnotation"
                    id="java-13-chapter-3-theme-1-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "UseAnnotation",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter13Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });


    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme3SubTheme1.node);

    let countProgressLocalTheme = 0

    for (let i = 4; i < 5; i++) {
      if (window.frontendData.language.chapters[10].listThemes[i].finished) {
        let k = i - 3
        document.getElementById("java-13-chapter-3-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 11.1;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 30) {
      document.getElementById("java-13-chapter-3-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 30)
        document.getElementById("java-13-chapter-3-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>