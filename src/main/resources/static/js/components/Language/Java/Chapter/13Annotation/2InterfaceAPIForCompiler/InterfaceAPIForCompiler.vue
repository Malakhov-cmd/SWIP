<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Прикладной интерфейс API для компилятора" class="theme-level-13-chapter-right"
                    id="java-13-chapter-2-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Вызов компилятора"
                    path-theme="/language/java/scenarioandannotation/CallCompile"
                    id="java-13-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Запуск заданий на компиляцию"
                    path-theme="/language/java/scenarioandannotation/LaunchTaskOnCompile"
                    id="java-13-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Фиксация диагностики"
                    path-theme="/language/java/scenarioandannotation/FicsationDiagnostic"
                    id="java-13-chapter-2-theme-3-subtheme"/>
      <theme-button theme-name="Чтение исходных файлов из оперативной памяти"
                    path-theme="/language/java/scenarioandannotation/ReadSourceCodeFromOperMemory"
                    id="java-13-chapter-2-theme-4-subtheme"/>
      <theme-button theme-name="Запись байт-кодов в оперативную память"
                    path-theme="/language/java/scenarioandannotation/WriteBityCodeOnOperMemory"
                    id="java-13-chapter-2-theme-5-subtheme"/>
      <theme-button theme-name="Пример динамического генерирования кода Java"
                    path-theme="/language/java/scenarioandannotation/ExampleDiagnosticGeneratedJavaCode"
                    id="java-13-chapter-2-theme-6-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InterfaceAPIForCompiler",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter13Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme2SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme2SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme2SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme-6-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme2SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme2SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme2SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme2SubTheme6.node);

  }
}
</script>

<style scoped>

</style>