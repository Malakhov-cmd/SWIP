<template>
  <div class="chapter-level-1">
    <chapter-button chapter-name="Потоки" class="theme-level-9-chapter-right"
                    id="central-btn-9chapter"/>
    <div class="theme-level-1 theme-level-1-right">
      <theme-button theme-name="Назначение потоков"
                    path-theme="/language/java/threads/DeclarationThread"
                    id="java-9-chapter-1-theme"/>
      <condition-threads/>
      <properties-thread/>
      <sinchronization/>
      <task-and-pulls-threads/>
      <asinchronized-calk/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ConditionThreads from "./2ConditionThreads/ConditionThreads.vue";
import PropertiesThread from "./3PropertiesThread/PropertiesThread.vue";
import Sinchronization from "./4Sinchronization/Sinchronization.vue";
import TaskAndPullsThreads from "./6TaskAndPullsThreads/TaskAndPullsThreads.vue";
import AsinchronizedCalk from "./7AsinchronizedCalk/AsinchronizedCalk.vue";

export default {
  name: "Threads",
  components: {
    AsinchronizedCalk,
    TaskAndPullsThreads,
    Sinchronization,
    PropertiesThread,
    ConditionThreads,
    ChapterButton, ThemeButton
  },
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-9chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-1-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-9chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-2-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-9chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-3-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-9chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-4-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-9chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-6-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-9chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-7-theme"),
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo6Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo7Theme.node);

    if (window.frontendData.language.chapters[8].listThemes[0].finished) {
      document.getElementById("java-9-chapter-1-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[8].chapterProgress > 0 &&
        window.frontendData.language.chapters[8].chapterProgress < 99) {
      document.getElementById("central-btn-9chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[8].chapterProgress >= 99) {
        document.getElementById("central-btn-9chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[8].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-9chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 9</div></h4>',
        content: '<div class="popover-body"><div class="popover-body-text">' + dataPopover + '</div></div>',
        trigger: 'hover',
        placement: 'right',
        html: true
      });
    });


  }
}
</script>

<style scoped>

</style>