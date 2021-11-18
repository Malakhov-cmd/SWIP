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
      <theme-button theme-name="Модульные архивные JAR-файлы"
                    path-theme="/language/java/module/ModuleArchiveJAR"
                    id="java-14-chapter-6-theme"/>
      <theme-button theme-name="Автоматические модули"
                    path-theme="/language/java/module/AutoModule"
                    id="java-14-chapter-7-theme"/>
      <theme-button theme-name="Безымянные модули"
                    path-theme="/language/java/module/UnnamedModules"
                    id="java-14-chapter-8-theme"/>
      <theme-button theme-name="Инструментальные средства для работы с модулями"
                    path-theme="/language/java/module/InstrumentalForWorkingWithModules"
                    id="java-14-chapter-9-theme"/>
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
        direction: DIRECTION.RIGHT,
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
        direction: DIRECTION.RIGHT,
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
        direction: DIRECTION.RIGHT,
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
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-6-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-7-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo8Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-8-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo9Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-14chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-14-chapter-9-theme"),
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo6Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo7Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo8Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo9Theme.node);
  }
}
</script>

<style scoped>

</style>