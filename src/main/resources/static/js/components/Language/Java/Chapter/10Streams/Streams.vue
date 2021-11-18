<template>
  <div class="chapter-level-1">
    <chapter-button chapter-name="Streams" class="theme-level-10-chapter-right"
                    id="central-btn-10chapter"/>
    <div class="theme-level-1 theme-level-1-right">
      <theme-button theme-name="От итерации к потоковым операциям"
                    path-theme="/language/java/streams/FromInterationToStreams"
                    id="java-10-chapter-1-theme"/>
      <theme-button theme-name="Создание потока данных"
                    path-theme="/language/java/streams/CreationStreams"
                    id="java-10-chapter-2-theme"/>
      <theme-button theme-name="Методы filter(), map() и flatMap()"
                    path-theme="/language/java/streams/MethodsFilterMapFlatMap"
                    id="java-10-chapter-3-theme"/>
      <theme-button theme-name="Извлечение подпотоков и объединение потоков данных"
                    path-theme="/language/java/streams/ExtractionSubStreamsAndAddingData"
                    id="java-10-chapter-4-theme"/>
      <theme-button theme-name="Другие операции преобразования потоков данных"
                    path-theme="/language/java/streams/AnotherOperarionOnStreams"
                    id="java-10-chapter-5-theme"/>
      <theme-button theme-name="Простые методы сведения"
                    path-theme="/language/java/streams/SimpleMethodsGrouping"
                    id="java-10-chapter-6-theme"/>
      <type-optional/>
      <theme-button theme-name="Накопление результатов"
                    path-theme="/language/java/streams/AccumulationResults"
                    id="java-10-chapter-8-theme"/>
      <theme-button theme-name="Накопление результатов в отображениях"
                    path-theme="/language/java/streams/AccumulationInReflection"
                    id="java-10-chapter-9-theme"/>
      <theme-button theme-name="Группирование и разделение"
                    path-theme="/language/java/streams/GroupingAndRegrouping"
                    id="java-10-chapter-10-theme"/>
      <theme-button theme-name="Нисходящие коллекторы"
                    path-theme="/language/java/streams/DowingCollectors"
                    id="java-10-chapter-11-theme"/>
      <theme-button theme-name="Операции сведения"
                    path-theme="/language/java/streams/AddingOperation"
                    id="java-10-chapter-12-theme"/>
      <theme-button theme-name="Потоки данных примитивных типов"
                    path-theme="/language/java/streams/SimpleTypeStreams"
                    id="java-10-chapter-13-theme"/>
      <theme-button theme-name=" Параллельные потоки данных"
                    path-theme="/language/java/streams/ParallelStreamsData"
                    id="java-10-chapter-14-theme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import TypeOptional from "./7TypeOptional/TypeOptional.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Streams",
  components: {TypeOptional, ChapterButton, ThemeButton},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-1-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-2-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-3-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-4-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-5-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-6-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo8Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-8-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo9Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-9-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo10Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-10-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo11Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-11-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo12Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-12-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo13Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-13-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo14Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-14-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo1Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo2Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo4Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo5Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo6Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo7Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo8Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo9Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo10Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo11Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo12Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo13Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo14Theme.node);

  }
}
</script>

<style scoped>

</style>