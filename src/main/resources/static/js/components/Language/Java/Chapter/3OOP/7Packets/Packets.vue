<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Именование пакетов"
                    path-theme="/language/java/oop/pocket/NamingPackets" id="java-3-chapter-7-theme-1-subtheme"/>
      <theme-button theme-name="Импорт классов"
                    path-theme="/language/java/oop/pocket/ImportClasses" id="java-3-chapter-7-theme-2-subtheme"/>
      <theme-button theme-name="Статический импорт"
                    path-theme="/language/java/oop/pocket/StaticImport" id="java-3-chapter-7-theme-3-subtheme"/>
      <theme-button theme-name="Ввод классов в пакеты"
                    path-theme="/language/java/oop/pocket/IncomeClassesInPacket" id="java-3-chapter-7-theme-4-subtheme"/>
      <theme-button theme-name="Область видимости пакетов"
                    path-theme="/language/java/oop/pocket/AreaOfVisiblePacket" id="java-3-chapter-7-theme-5-subtheme"/>
      <theme-button theme-name="Путь к классам"
                    path-theme="/language/java/oop/pocket/PathToClasses" id="java-3-chapter-7-theme-6-subtheme"/>
      <theme-button theme-name="Указание пути к классам"
                    path-theme="/language/java/oop/pocket/PointingPathToClass" id="java-3-chapter-7-theme-7-subtheme"/>
      </div>
    <chapter-button chapter-name="Пакеты" class="theme-level-3-chapter-left" id="java-3-chapter-7-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Packets",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme7SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme7SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme7SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme7SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme7SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme7SubTheme7.node);

  }
}
</script>

<style scoped>

</style>