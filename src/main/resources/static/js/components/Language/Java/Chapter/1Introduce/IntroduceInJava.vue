<template>
  <div class="chapter-level-1 ">
    <div class="theme-level-1">
      <ThemeButton theme-name="Программная платформа" path-theme="/language/java/introduceinjava/programplatform"/>
      <ThemeButton theme-name="История языка" path-theme="/language/java/introduceinjava/history"/>
      <ThemeButton theme-name="Заблуждения о языке" path-theme="/language/java/introduceinjava/delusions"/>
    </div>
    <ChapterButton chapter-name="Введение в язык Java" class="theme-level-1-chapter-left"/>
  </div>
</template>

<script>
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";

export default {
  name: "IntroduceInJava",
  components: {ThemeButton, ChapterButton}
}
</script>

<style scoped>

</style>