<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Формирование XML-документов" class="theme-level-12-chapter-right"
                    id="java-12-chapter-8-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="XML-документы без пространств имен"
                    path-theme="/language/java/xml/XMLWithoutSpacenaming"
                    id="java-12-chapter-8-theme-1-subtheme"/>
      <theme-button theme-name="XML-документы с пространствами имен"
                    path-theme="/language/java/xml/XMLWithSpacenaming"
                    id="java-12-chapter-8-theme-2-subtheme"/>
      <theme-button theme-name="Запись XML-документов"
                    path-theme="/language/java/xml/WriteXMLDoc"
                    id="java-12-chapter-8-theme-3-subtheme"/>
      <theme-button theme-name="Запись XML-документов средствами StAX"
                    path-theme="/language/java/xml/WriteXMLViaSTAX"
                    id="java-12-chapter-8-theme-4-subtheme"/>
      <theme-button theme-name="Пример формирования файла в формате SVG"
                    path-theme="/language/java/xml/FormingFileViaSVG"
                    id="java-12-chapter-8-theme-5-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "FormingXMLDoc",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter12Theme8SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-8-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme8SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-8-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme8SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-8-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme8SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-8-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme8SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-8-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme8SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme8SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme8SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme8SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme8SubTheme5.node);

  }
}
</script>

<style scoped>

</style>