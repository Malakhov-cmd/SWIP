<template>
  <div class="chapter-level-1 ">
    <div class="theme-level-1">
      <ThemeButton class="themes-lvl-1" theme-name="Программная платформа"
                   path-theme="/language/java/introduceinjava/programplatform"
                   id="java-1-chapter-1-theme"/>
      <ThemeButton class="themes-lvl-1" theme-name="История языка"
                   path-theme="/language/java/introduceinjava/history"
                   id="java-1-chapter-2-theme"/>
      <ThemeButton class="themes-lvl-1"
                   theme-name="Заблуждения о языке"
                   path-theme="/language/java/introduceinjava/delusions"
                   id="java-1-chapter-3-theme"/>
    </div>
    <ChapterButton chapter-name="Введение в язык Java"
                   data-toggle="popover"
                   class="theme-level-1-chapter-left"
                   id="central-btn-1chapter"/>
  </div>
</template>

<script>
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD} from "arrows-svg";

export default {
  name: "IntroduceInJava",
  components: {ThemeButton, ChapterButton},
  mounted() {
    //Инициализация соединитильных линий
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: document.getElementById("central-btn-1chapter"),
      to: document.getElementById("java-1-chapter-1-theme"),
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: document.getElementById("central-btn-1chapter"),
      to: document.getElementById("java-1-chapter-2-theme"),
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: document.getElementById("central-btn-1chapter"),
      to: document.getElementById("java-1-chapter-3-theme"),
      head: {
        func: HEAD.VEE,
      }
    });

    //Добавление их на страницу
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo1Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo2Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);

    //Цветовая индикация пройденных тем
    for (let i = 1; i < 4; i++) {
      if (window.frontendData.language.chapters[0].listThemes[i - 1].finished) {
        document.getElementById("java-1-chapter-" + i + "-theme")
            .setAttribute("style", "background: #28a745; border: green;");
      }
    }

    if (window.frontendData.language.chapters[0].chapterProgress > 0 &&
        window.frontendData.language.chapters[0].chapterProgress < 99) {
      document.getElementById("central-btn-1chapter")
          .setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[0].chapterProgress >= 99) {
        document.getElementById("central-btn-1chapter")
            .setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[0].chapterProgress
      let dataPopover
      if (progress > 90) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + progress
      }
      $("#central-btn-1chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 1</div></h4>',
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