<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <carcas-collections-in-java/>
      <theme-button theme-name="Интерфейсы в каркасе коллекций Java"
                    path-theme="/language/java/collections/InterfacesInCarcasCollectionsInJava" id="java-8-chapter-2-theme"/>
      <type-collections/>
      <reflections/>
    </div>
    <chapter-button chapter-name="Коллекции" class="theme-level-1-chapter-left"
                    id="central-btn-8chapter"/>
  </div>
</template>

<script>
import CarcasCollectionsInJava from "./1CarcasCollectionsInJava/CarcasCollectionsInJava.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import TypeCollections from "./3TypeCollections/TypeCollections.vue";
import Reflections from "./4Reflection/Reflections.vue";
import Algorithms from "./5Algorithms/Algorithms.vue";
import InherinceCollections from "./6InherinceCollections/InherinceCollections.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ChapterButton from "../../../Blocks/ChapterButton.vue";

export default {
  name: "Collections",
  components: {
    ChapterButton,
    InherinceCollections, Algorithms, Reflections, TypeCollections, ThemeButton, CarcasCollectionsInJava
  },
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-8chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-8chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-8chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-8chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });


    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo1Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo2Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo4Theme.node);

    if (window.frontendData.language.chapters[7].listThemes[4].finished) {
      document.getElementById("java-8-chapter-2-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[7].chapterProgress > 0 &&
        window.frontendData.language.chapters[7].chapterProgress < 99) {
      document.getElementById("central-btn-8chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[7].chapterProgress >= 99) {
        document.getElementById("central-btn-8chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[7].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-8chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 8</div></h4>',
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