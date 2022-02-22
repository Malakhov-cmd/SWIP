<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <working-with-exeption/>
      <interception-exeption/>
      <theme-button theme-name="Рекомендации по обработке исключений"
                    path-theme="/language/java/exeption/RecomendationWorkWithExeption" id="java-6-chapter-3-theme"/>
    </div>
    <chapter-button chapter-name="Исключения, утверждения и протоколирование " class="theme-level-1-chapter-left"
                    id="central-btn-6chapter"/>
  </div>
</template>

<script>
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import WorkingWithExeption from "./1WorkingWithExeption/WorkingWithExeption.vue";
import InterceptionExeption from "./2InterceptionExeption/InterceptionExeption.vue";

export default {
  name: "Exeption",
  components: {InterceptionExeption, WorkingWithExeption, ChapterButton, ThemeButton},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-6chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-6chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-6chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-3-theme"),
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

    if (window.frontendData.language.chapters[5].listThemes[5].finished) {
      document.getElementById("java-6-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[5].chapterProgress > 0 &&
        window.frontendData.language.chapters[5].chapterProgress < 98) {
      document.getElementById("central-btn-6chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[5].chapterProgress >= 98) {
        document.getElementById("central-btn-6chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[5].chapterProgress
      let dataPopover
      if (progress > 98) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-6chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 6</div></h4>',
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