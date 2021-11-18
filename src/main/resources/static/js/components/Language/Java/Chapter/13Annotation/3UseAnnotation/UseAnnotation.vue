<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Применение аннотаций" class="theme-level-13-chapter-right"
                    id="java-13-chapter-3-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Введение в аннотации"
                    path-theme="/language/java/scenarioandannotation/IntroInAnnotation"
                    id="java-13-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Пример аннотирования обработчиков событий"
                    path-theme="/language/java/scenarioandannotation/ExampleAnnotationProcessorEvent"
                    id="java-13-chapter-3-theme-2-subtheme"/>
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
    const arrowFromChapter13Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-3-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme3SubTheme2.node);
  }
}
</script>

<style scoped>

</style>