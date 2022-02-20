<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <interfaces/>
      <lyambda/>
      <inner-classes/>
    </div>
    <chapter-button chapter-name="Интерфейсы, лямбда-выражения и внутренние классы" class="theme-level-1-chapter-left"
                    id="central-btn-5chapter"/>
  </div>
</template>

<script>
import Interfaces from "./1Interfaces/Interfaces.vue";
import Lyambda from "./2Lyambda/Lyambda.vue";
import InnerClasses from "./3InnerClasses/InnerClasses.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InterfaceLyambdaAndInner",
  components: {ChapterButton, InnerClasses, Lyambda, Interfaces},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-5chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-5chapter"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-5chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
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

    if (window.frontendData.language.chapters[4].chapterProgress > 0 &&
        window.frontendData.language.chapters[4].chapterProgress < 98) {
      document.getElementById("central-btn-5chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[4].chapterProgress >= 98) {
        document.getElementById("central-btn-5chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[4].chapterProgress
      let dataPopover
      if (progress > 98) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-5chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 5</div></h4>',
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