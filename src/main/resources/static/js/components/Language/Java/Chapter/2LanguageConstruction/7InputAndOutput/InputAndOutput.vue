<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name="Чтение вводимых данных"
                   path-theme="/language/java/languageconstruction/inputoutput/readinputdata"
                   id="java-2-chapter-7-them-1-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Файловый ввод и вывод"
                   path-theme="/language/java/languageconstruction/inputoutput/fileoutputdata"
                   id="java-2-chapter-7-them-2-subtheme"/>
    </div>
    <ChapterButton chapter-name="Ввод и вывод" class="theme-level-2-chapter-left" id="java-2-chapter-7-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InputAndOutput",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter2Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-7-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-7-them-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-7-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-7-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme7SubTheme2.node);

    let countProgressLocalTheme = 0

    for (let i = 23; i < 25; i++) {
      if (window.frontendData.language.chapters[1].listThemes[i].finished) {
        let k = i - 22
        document.getElementById("java-2-chapter-7-them-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 2.7;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 5) {
      document.getElementById("java-2-chapter-7-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 5)
        document.getElementById("java-2-chapter-7-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>