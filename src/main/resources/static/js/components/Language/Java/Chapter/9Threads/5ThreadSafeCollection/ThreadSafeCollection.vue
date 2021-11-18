<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Потокобезопастные коллекции" class="theme-level-9-chapter-right"
                    id="java-9-chapter-5-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Блокирующие очереди"
                    path-theme="/language/java/threads/BlockingQueue"
                    id="java-9-chapter-5-theme-1-subtheme"/>
      <theme-button theme-name="Эффективные отображения, множества и очереди"
                    path-theme="/language/java/threads/EffictiveReflectionMapAndQueue"
                    id="java-9-chapter-5-theme-2-subtheme"/>
      <theme-button theme-name="Атомарное обновление записей в отображениях"
                    path-theme="/language/java/threads/AtomicUpdateRowInReflections"
                    id="java-9-chapter-5-theme-3-subtheme"/>
      <theme-button theme-name="Групповые операции над параллельными хэш-отображениями"
                    path-theme="/language/java/threads/GroupOperationOnParralelHashMap"
                    id="java-9-chapter-5-theme-4-subtheme"/>
      <theme-button theme-name="Параллельные представления множеств"
                    path-theme="/language/java/threads/ParralelDeclarationMap"
                    id="java-9-chapter-5-theme-5-subtheme"/>
      <theme-button theme-name="Массивы, копируемые при записи"
                    path-theme="/language/java/threads/MassiveCopingOnWriting"
                    id="java-9-chapter-5-theme-6-subtheme"/>
      <theme-button theme-name="Алгоритмы обработки параллельных массивов"
                    path-theme="/language/java/threads/AlgorithmsWorkingOnParralelMassive"
                    id="java-9-chapter-5-theme-7-subtheme"/>
      <theme-button theme-name="Устаревшие потокобезопастные коллекции"
                    path-theme="/language/java/threads/DepricatedThreadSecurity"
                    id="java-9-chapter-5-theme-8-subtheme"/>
    </div>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ThreadSafeCollection",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter9Theme5SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-6-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-7-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme5SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-5-theme-8-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme5SubTheme8.node);

  }
}
</script>

<style scoped>

</style>