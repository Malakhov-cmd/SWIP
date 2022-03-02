<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Стандартные аннотации" class="theme-level-13-chapter-right"
                    id="java-13-chapter-5-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Аннотации для компиляции"
                    path-theme="/language/java/scenarioandannotation/AnnotationForCompiling"
                    id="java-13-chapter-5-theme-1-subtheme"/>
      <theme-button theme-name="Аннотации для управления ресурсами"
                    path-theme="/language/java/scenarioandannotation/AnnotationForManageResource"
                    id="java-13-chapter-5-theme-2-subtheme"/>
      <theme-button theme-name="Мета-аннотации"
                    path-theme="/language/java/scenarioandannotation/MetaAnnotation"
                    id="java-13-chapter-5-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";
export default {
  name: "StandartAnnotation",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter13Theme5SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-5-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-5-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-5-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme5SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme5SubTheme3.node);

    let countProgressLocalTheme = 0

    for (let i = 8; i < 11; i++) {
      if (window.frontendData.language.chapters[10].listThemes[i].finished) {
        let k = i - 7
        document.getElementById("java-13-chapter-5-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 9.09;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 26) {
      document.getElementById("java-13-chapter-5-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 26)
        document.getElementById("java-13-chapter-5-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>