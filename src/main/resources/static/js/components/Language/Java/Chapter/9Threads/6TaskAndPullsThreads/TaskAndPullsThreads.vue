<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Задачи и пулы потоков исполнения" class="theme-level-9-chapter-right"
                    id="java-9-chapter-6-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Интерфейсы Callable и Future"
                    path-theme="/language/java/threads/InterfacesCallableAndFuture"
                    id="java-9-chapter-6-theme-1-subtheme"/>
      <theme-button theme-name="Исполнители"
                    path-theme="/language/java/threads/Executions"
                    id="java-9-chapter-6-theme-2-subtheme"/>
      <theme-button theme-name="Управление группами задач"
                    path-theme="/language/java/threads/ManagerGroupTask"
                    id="java-9-chapter-6-theme-3-subtheme"/>
      <theme-button theme-name="Архитектура вилочного соединения"
                    path-theme="/language/java/threads/ArchitectureForkLink"
                    id="java-9-chapter-6-theme-4-subtheme"/>
    </div>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "TaskAndPullsThreads",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter9Theme6SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-6-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme6SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-6-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme6SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-6-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme6SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-6-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme6SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme6SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme6SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme6SubTheme4.node);

    let countProgressLocalTheme = 0

    for (let i = 15; i < 19; i++) {
      if (window.frontendData.language.chapters[8].listThemes[i].finished) {
        let k = i - 14
        document.getElementById("java-9-chapter-6-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 8.3;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 24) {
      document.getElementById("java-9-chapter-6-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 24)
        document.getElementById("java-9-chapter-6-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>