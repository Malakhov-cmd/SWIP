<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Синтаксис аннотаций" class="theme-level-13-chapter-right"
                    id="java-13-chapter-4-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Интерфейсы аннотаций"
                    path-theme="/language/java/scenarioandannotation/InterfacesAnnotations"
                    id="java-13-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Аннотирование объявлений"
                    path-theme="/language/java/scenarioandannotation/AnnotationingAnnouncement"
                    id="java-13-chapter-4-theme-2-subtheme"/>
      <theme-button theme-name="Аннотирование в местах употребления типов данных"
                    path-theme="/language/java/scenarioandannotation/AnnotationingInPlaceUseTypes"
                    id="java-13-chapter-4-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "SyntaxAnnotation",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter13Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-4-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-4-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme4SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-4-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });


    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme4SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme4SubTheme4.node);

    let countProgressLocalTheme = 0

    for (let i = 5; i < 8; i++) {
      if (window.frontendData.language.chapters[10].listThemes[i].finished) {
        let k = i - 4
        document.getElementById("java-13-chapter-4-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 9.09;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 26) {
      document.getElementById("java-13-chapter-4-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 26)
        document.getElementById("java-13-chapter-4-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>