<template>
  <v-fab-transition>
      <b-btn class="my-b-btn">
        <router-link :to='pathTheme'>{{themeName}}</router-link>
      </b-btn>
  </v-fab-transition>
</template>

<script>
export default {
  props: ['themeName', 'pathTheme'],
  name: "ThemeButton"
}
</script>

<style scoped>

</style>