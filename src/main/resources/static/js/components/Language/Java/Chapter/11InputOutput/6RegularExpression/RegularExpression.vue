<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Регулярные выражения" class="theme-level-11-chapter-right"
                    id="java-11-chapter-6-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Совпадение со строкой"
                    path-theme="/language/java/inputoutput/SameWithString"
                    id="java-11-chapter-6-theme-1-subtheme"/>
      <theme-button theme-name="Обнаружение многих совпадений"
                    path-theme="/language/java/inputoutput/FindinManySaneInString"
                    id="java-11-chapter-6-theme-2-subtheme"/>
      <theme-button theme-name="Разбиение строк по разделителям"
                    path-theme="/language/java/inputoutput/ItemingStringToSeparator"
                    id="java-11-chapter-6-theme-3-subtheme"/>
      <theme-button theme-name="Замена совпадений"
                    path-theme="/language/java/inputoutput/ChangingSame"
                    id="java-11-chapter-6-theme-4-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";
export default {
  name: "RegularExpression",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter11Theme6SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-6-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme6SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-6-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme6SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-6-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme6SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-6-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme6SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme6SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme6SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme6SubTheme4.node);

  }
}
</script>

<style scoped>

</style>