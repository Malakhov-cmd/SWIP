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
      <type-optional/>
      <theme-button theme-name="Группирование и разделение"
                    path-theme="/language/java/streams/GroupingAndRegrouping"
                    id="java-10-chapter-10-theme"/>
      <theme-button theme-name="Нисходящие коллекторы"
                    path-theme="/language/java/streams/DowingCollectors"
                    id="java-10-chapter-11-theme"/>
      <theme-button theme-name="Операции сведения"
                    path-theme="/language/java/streams/AddingOperation"
                    id="java-10-chapter-12-theme"/>
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
        direction: DIRECTION.TOP,
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
        direction: DIRECTION.TOP,
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
        direction: DIRECTION.TOP,
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
    const arrowFromCentralBtnChapterTo10Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-10chapter"),
        direction: DIRECTION.BOTTOM,
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
        direction: DIRECTION.BOTTOM,
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
        direction: DIRECTION.BOTTOM,
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


    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo1Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo2Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo7Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo10Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo11Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo12Theme.node);

    if (window.frontendData.language.chapters[9].listThemes[0].finished) {
      document.getElementById("java-10-chapter-1-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[9].listThemes[1].finished) {
      document.getElementById("java-10-chapter-2-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[9].listThemes[2].finished) {
      document.getElementById("java-10-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[9].listThemes[6].finished) {
      document.getElementById("java-10-chapter-10-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[9].listThemes[7].finished) {
      document.getElementById("java-10-chapter-11-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[9].listThemes[8].finished) {
      document.getElementById("java-10-chapter-12-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[9].chapterProgress > 0 &&
        window.frontendData.language.chapters[9].chapterProgress < 99) {
      document.getElementById("central-btn-10chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[9].chapterProgress >= 99) {
        document.getElementById("central-btn-10chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[9].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-10chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 10</div></h4>',
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