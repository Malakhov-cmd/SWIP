<template>
  <v-fab-transition>
    <b-btn class="my-b-btn">{{chapterName}}
    </b-btn>
  </v-fab-transition>
</template>

<script>
export default {
  props: ['chapterName'],
  name: "ChapterButton"
}
</script>

<style scoped>

</style>