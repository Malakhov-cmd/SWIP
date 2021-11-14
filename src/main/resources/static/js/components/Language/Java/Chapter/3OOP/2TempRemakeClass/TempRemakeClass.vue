<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Объекты и объектные переменные"
                    path-theme="/language/java/oop/tempremake/objectsandobjectstemp" id="java-3-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="LocalDate"
                    path-theme="/language/java/oop/tempremake/localdate" id="java-3-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Модифицирующие методы и методы доступа"
                    path-theme="/language/java/oop/tempremake/configurationmethod" id="java-3-chapter-2-theme-3-subtheme"/>
    </div>
    <chapter-button chapter-name="Применение предопределенных классов" class="theme-level-3-chapter-left" id="java-3-chapter-2-theme"/>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
export default {
  name: "TenpRemakeClass",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter3Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-2-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme2SubTheme3.node);

  }
}
</script>

<style scoped>

</style>