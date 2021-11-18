<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Тип Optional" class="theme-level-10-chapter-right"
                    id="java-10-chapter-7-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Получение необязательных значений"
                    path-theme="/language/java/streams/GettingUnnesaryResults"
                    id="java-10-chapter-7-theme-1-subtheme"/>
      <theme-button theme-name="Употребление необязательных значений"
                    path-theme="/language/java/streams/UsingUnnesary"
                    id="java-10-chapter-7-theme-2-subtheme"/>
      <theme-button theme-name="Конвейеризация необязательных значений"
                    path-theme="/language/java/streams/FactoryUnnessary"
                    id="java-10-chapter-7-theme-3-subtheme"/>
      <theme-button theme-name="Как не следует обрабатывать необязательные значения"
                    path-theme="/language/java/streams/WarningProcessingUnnessasary"
                    id="java-10-chapter-7-theme-4-subtheme"/>
      <theme-button theme-name="Формирование необязательных значений"
                    path-theme="/language/java/streams/FormingUnnessasary"
                    id="java-10-chapter-7-theme-5-subtheme"/>
      <theme-button theme-name="Преобразование типа Optional в поток данных"
                    path-theme="/language/java/streams/OptinalToStream"
                    id="java-10-chapter-7-theme-6-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "TypeOptional",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter10Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-6-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme6.node);

  }
}
</script>

<style scoped>

</style>