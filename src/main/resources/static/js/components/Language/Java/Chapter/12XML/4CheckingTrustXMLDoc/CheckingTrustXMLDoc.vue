<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Проверка достоверности XML-документов" class="theme-level-12-chapter-right"
                    id="java-12-chapter-4-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Определения типов документов"
                    path-theme="/language/java/xml/DeclarationDocType"
                    id="java-12-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Схема XML-документов"
                    path-theme="/language/java/xml/SchemaXML"
                    id="java-12-chapter-4-theme-2-subtheme"/>
      <theme-button theme-name="Практический пример применения XML-документов"
                    path-theme="/language/java/xml/PracticUseXMLDocUse"
                    id="java-12-chapter-4-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "CheckingTrustXMLDoc",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter12Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-4-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme4SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-4-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter12Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-12-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-4-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme4SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter12Theme4SubTheme3.node);

  }
}
</script>

<style scoped>

</style>