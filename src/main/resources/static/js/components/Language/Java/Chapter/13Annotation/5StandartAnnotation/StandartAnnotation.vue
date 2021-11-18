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
        direction: DIRECTION.RIGHT,
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
        direction: DIRECTION.RIGHT,
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

  }
}
</script>

<style scoped>

</style>