<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Вставка комментариев"
                    path-theme="/language/java/oop/comments/AddingComments" id="java-3-chapter-9-theme-1-subtheme"/>
      <theme-button theme-name="Комментарии к классам"
                    path-theme="/language/java/oop/comments/ClassComment" id="java-3-chapter-9-theme-2-subtheme"/>
      <theme-button theme-name="Комментарии к методам"
                    path-theme="/language/java/oop/comments/MethodComment" id="java-3-chapter-9-theme-3-subtheme"/>
      <theme-button theme-name="Комментарии к полям"
                    path-theme="/language/java/oop/comments/FieldComment" id="java-3-chapter-9-theme-4-subtheme"/>
      <theme-button theme-name="Комментарии общего характера"
                    path-theme="/language/java/oop/comments/CommonComment" id="java-3-chapter-9-theme-5-subtheme"/>
      <theme-button theme-name="Комментарии к пакетам"
                    path-theme="/language/java/oop/comments/PacketComments" id="java-3-chapter-9-theme-6-subtheme"/>
      <theme-button theme-name="Извлечение комментариев"
                    path-theme="/language/java/oop/comments/RetrievalComment" id="java-3-chapter-9-theme-7-subtheme"/>
      </div>
    <chapter-button chapter-name="Конструирование объектов" class="theme-level-3-chapter-left" id="java-3-chapter-9-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";

export default {
  name: "DocumentringComments",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme9SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme9SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme9SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme9SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme9SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme9SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme9SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme7.node);
  }
}
</script>

<style scoped>

</style>