<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Классификация исключений"
                    path-theme="/language/java/exeption/ClassificationExeption"
                    id="java-7-chapter-5-theme-1-subtheme"/>
      <theme-button theme-name="Объявление проверяемых исключений"
                    path-theme="/language/java/exeption/DeclarationProvedExeption"
                    id="java-7-chapter-5-theme-2-subtheme"/>
      <theme-button theme-name="Порядок генерирования исключений"
                    path-theme="/language/java/exeption/OrderGenerationExeption"
                    id="java-7-chapter-5-theme-3-subtheme"/>
      <theme-button theme-name="Создание классов исключений"
                    path-theme="/language/java/exeption/CreationClassesExeption"
                    id="java-7-chapter-5-theme-4-subtheme"/>
    </div>
    <chapter-button chapter-name="Обобщенный код и виртуальная машина" class="theme-level-7-chapter-left" id="java-7-chapter-5-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "GenericCodeAndVirtualMachine",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter7Theme5SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter7Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter7Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter7Theme5SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme4.node);

  }
}
</script>

<style scoped>

</style>