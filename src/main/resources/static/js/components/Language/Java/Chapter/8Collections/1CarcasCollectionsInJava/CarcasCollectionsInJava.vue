<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Разделение интерфейсов и реализаций коллекций "
                    path-theme="/language/java/collections/SeparationsInterfaces"
                    id="java-8-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Интерфейс Collection"
                    path-theme="/language/java/collections/InterfaceCollection"
                    id="java-8-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Итераторы"
                    path-theme="/language/java/collections/Iterator"
                    id="java-8-chapter-1-theme-3-subtheme"/>
    </div>
    <chapter-button chapter-name="Каркас коллекций в Java" class="theme-level-8-chapter-left"
                    id="java-8-chapter-1-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "CarcasCollectionsInJava",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter8Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme1SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-1-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme1SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme1SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme1SubTheme3.node);

  }
}
</script>

<style scoped>

</style>