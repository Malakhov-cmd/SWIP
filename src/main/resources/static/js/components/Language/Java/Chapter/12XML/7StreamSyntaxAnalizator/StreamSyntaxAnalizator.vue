<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Потоковые синтаксические анализаторы" class="theme-level-12-chapter-right"
                    id="java-12-chapter-7-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Применение SAX-анализатора"
                    path-theme="/language/java/xml/SAXAnalizator"
                    id="java-12-chapter-7-theme-1-subtheme"/>
      <theme-button theme-name="Применение StAX-анализатора"
                    path-theme="/language/java/xml/STAXAnalizator"
                    id="java-12-chapter-7-theme-2-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "StreamSyntaxAnalizator",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter12Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-7-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-7-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme7SubTheme2.node);

  }
}
</script>

<style scoped>

</style>