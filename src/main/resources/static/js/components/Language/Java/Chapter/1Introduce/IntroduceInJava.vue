<template>
  <div class="chapter-level-1 ">
    <div class="theme-level-1">
      <ThemeButton class="themes-lvl-1" theme-name="Программная платформа"
                   path-theme="/language/java/introduceinjava/programplatform" id="java-1-chapter-1-theme"/>
      <ThemeButton class="themes-lvl-1" theme-name="История языка" path-theme="/language/java/introduceinjava/history"
                   id="java-1-chapter-2-theme"/>
      <ThemeButton class="themes-lvl-1" theme-name="Заблуждения о языке"
                   path-theme="/language/java/introduceinjava/delusions" id="java-1-chapter-3-theme"/>
    </div>
    <ChapterButton chapter-name="Введение в язык Java" class="theme-level-1-chapter-left" id="central-btn-1chapter"/>
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

    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo1Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo2Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);

    let listTheme = document.getElementsByClassName("themes-lvl-1")
    for (let i = 0; i < listTheme.length; i++) {
      if (window.frontendData.language.chapters[0].listThemes[i].finished) {
        listTheme.item(i).setAttribute("style", "background: #28a745; border: green;");
      }
    }

    if (window.frontendData.language.chapters[0].chapterProgress > 0 &&
        window.frontendData.language.chapters[0].chapterProgress < 99) {
      document.getElementById("central-btn-1chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[0].chapterProgress >= 99){
        document.getElementById("central-btn-1chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }
  }
}
</script>

<style scoped>

</style>