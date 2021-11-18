<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Синхронизация" class="theme-level-9-chapter-right"
                    id="java-9-chapter-4-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Пример состояния гонок"
                    path-theme="/language/java/threads/ExampleRaceCondition"
                    id="java-9-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Объяснение причин, приводящих к состоянию гонок"
                    path-theme="/language/java/threads/ExplanationRaceCondition"
                    id="java-9-chapter-4-theme-2-subtheme"/>
      <theme-button theme-name="Объекты блокировки"
                    path-theme="/language/java/threads/BlockingObject"
                    id="java-9-chapter-4-theme-3-subtheme"/>
      <theme-button theme-name="Объекты условий"
                    path-theme="/language/java/threads/IfBlocks"
                    id="java-9-chapter-4-theme-4-subtheme"/>
      <theme-button theme-name="Ключевое слово synchronized"
                    path-theme="/language/java/threads/KeyWorkSynchrinized"
                    id="java-9-chapter-4-theme-5-subtheme"/>
      <theme-button theme-name="Синхронизированные блоки"
                    path-theme="/language/java/threads/SynchroBlocks"
                    id="java-9-chapter-4-theme-6-subtheme"/>
      <theme-button theme-name="Принцип монитора"
                    path-theme="/language/java/threads/MonitorPrincep"
                    id="java-9-chapter-4-theme-7-subtheme"/>
      <theme-button theme-name="Поля и переменные типа volatile"
                    path-theme="/language/java/threads/TypeVolatile"
                    id="java-9-chapter-4-theme-8-subtheme"/>
      <theme-button theme-name="Поля и переменные типа final"
                    path-theme="/language/java/threads/TypeFinal"
                    id="java-9-chapter-4-theme-9-subtheme"/>
      <theme-button theme-name="Атомарность операций"
                    path-theme="/language/java/threads/AtomicOperation"
                    id="java-9-chapter-4-theme-10-subtheme"/>
      <theme-button theme-name="Взаимные блокировки"
                    path-theme="/language/java/threads/DeadLocks"
                    id="java-9-chapter-4-theme-11-subtheme"/>
      <theme-button theme-name="Локальные переменные в потоках исполнения"
                    path-theme="/language/java/threads/LocalTempsInThread"
                    id="java-9-chapter-4-theme-12-subtheme"/>
      <theme-button theme-name="Причины, по которым методы stop() и suspend() не рекомендованы к применению"
                    path-theme="/language/java/threads/DepricatedMethodsStopAndSuspend"
                    id="java-9-chapter-4-theme-13-subtheme"/>
    </div>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Sinchronization",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter9Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-6-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-7-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-8-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme9 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-9-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme10 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-10-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme11 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-11-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme12 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-12-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme4SubTheme13 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme-13-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme8.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme9.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme10.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme11.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme12.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme4SubTheme13.node);

  }
}
</script>

<style scoped>

</style>