<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Манипулирование файлами" class="theme-level-11-chapter-right"
                    id="java-11-chapter-4-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Пути к файлам"
                    path-theme="/language/java/inputoutput/FilePath"
                    id="java-11-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Чтение и запись данных в файлы"
                    path-theme="/language/java/inputoutput/ReadAndWriteInFiles"
                    id="java-11-chapter-4-theme-2-subtheme"/>
      <theme-button theme-name="Создание файлов и каталогов"
                    path-theme="/language/java/inputoutput/CreationFilesAndCatalogies"
                    id="java-11-chapter-4-theme-3-subtheme"/>
      <theme-button theme-name="Копирование, перемещение и удаление файлов"
                    path-theme="/language/java/inputoutput/CopingTempAndDeleteFiles"
                    id="java-11-chapter-4-theme-4-subtheme"/>
      <theme-button theme-name="Получение сведений о файлах"
                    path-theme="/language/java/inputoutput/GettingFileInfo"
                    id="java-11-chapter-4-theme-5-subtheme"/>
      <theme-button theme-name="Обход элементов каталога"
                    path-theme="/language/java/inputoutput/LookingElementCatalogies"
                    id="java-11-chapter-4-theme-6-subtheme"/>
      <theme-button theme-name="Применение потоков каталогов"
                    path-theme="/language/java/inputoutput/UseCatalogiesStreams"
                    id="java-11-chapter-4-theme-7-subtheme"/>
      <theme-button theme-name="Системы ZIP-файлов"
                    path-theme="/language/java/inputoutput/ZIPSystemFiles"
                    id="java-11-chapter-4-theme-8-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ManipulatingFiles",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter11Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-6-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-7-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme4SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-4-theme-8-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme4SubTheme8.node);

  }
}
</script>

<style scoped>

</style>