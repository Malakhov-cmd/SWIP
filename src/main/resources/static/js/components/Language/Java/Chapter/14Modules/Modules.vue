<template>
  <div class="chapter-level-1">
    <chapter-button chapter-name="Модули" class="theme-level-14-chapter-right"
                    id="central-btn-14chapter"/>
    <div class="theme-level-1 theme-level-1-right">
      <theme-button theme-name="Понятие модуля"
                    path-theme="/language/java/module/DeclarationModules"
                    id="java-14-chapter-1-theme"/>
      <theme-button theme-name="Именование модулей"
                    path-theme="/language/java/module/NamingModules"
                    id="java-14-chapter-2-theme"/>
      <theme-button theme-name="Пример модульной программы"
                    path-theme="/language/java/module/ExampleModuleHelloWorld"
                    id="java-14-chapter-3-theme"/>
      <theme-button theme-name="Требования модулей"
                    path-theme="/language/java/module/ReqirementModules"
                    id="java-14-chapter-4-theme"/>
      <theme-button theme-name="Экспорт пакетов"
                    path-theme="/language/java/module/ExportModules"
                    id="java-14-chapter-5-theme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Modules",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-1-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-2-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-3-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-4-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-5-theme"),
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

    if (window.frontendData.language.chapters[11].listThemes[0].finished) {
      document.getElementById("java-14-chapter-1-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[11].listThemes[1].finished) {
      document.getElementById("java-14-chapter-2-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[11].listThemes[2].finished) {
      document.getElementById("java-14-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[11].listThemes[3].finished) {
      document.getElementById("java-14-chapter-4-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[11].listThemes[4].finished) {
      document.getElementById("java-14-chapter-5-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[11].chapterProgress > 0 &&
        window.frontendData.language.chapters[11].chapterProgress < 99) {
      document.getElementById("central-btn-14chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[11].chapterProgress >= 99) {
        document.getElementById("central-btn-14chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[11].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-14chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 12</div></h4>',
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