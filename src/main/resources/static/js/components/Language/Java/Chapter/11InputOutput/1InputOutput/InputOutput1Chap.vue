<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Потоки ввода-вывода" class="theme-level-11-chapter-right"
                    id="java-11-chapter-1-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Чтение и запись байтов"
                    path-theme="/language/java/inputoutput/ReadAndWriteBites"
                    id="java-11-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Полный комплект потоков ввода-вывода"
                    path-theme="/language/java/inputoutput/FullComplectInputOutputStreams"
                    id="java-11-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Сочетание фильтров потоков ввода-вывода"
                    path-theme="/language/java/inputoutput/MixingFiltersStreamsInputOutput"
                    id="java-11-chapter-1-theme-3-subtheme"/>
      <theme-button theme-name="Ввод-вывод текста"
                    path-theme="/language/java/inputoutput/InputOutputText"
                    id="java-11-chapter-1-theme-4-subtheme"/>
      <theme-button theme-name="Вывод текста"
                    path-theme="/language/java/inputoutput/OutputText"
                    id="java-11-chapter-1-theme-5-subtheme"/>
      <theme-button theme-name="Ввод текста"
                    path-theme="/language/java/inputoutput/InputText"
                    id="java-11-chapter-1-theme-6-subtheme"/>
      <theme-button theme-name="Сохранение объектов в текстовом формате"
                    path-theme="/language/java/inputoutput/SaveObjectInTextFormat"
                    id="java-11-chapter-1-theme-7-subtheme"/>
      <theme-button theme-name="Кодировки символов"
                    path-theme="/language/java/inputoutput/CodingSymbols"
                    id="java-11-chapter-1-theme-8-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InputOutput1Chap",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter11Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-6-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-7-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme1SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-1-theme-8-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme1SubTheme8.node);

  }
}
</script>

<style scoped>

</style>