<template>
  <v-fab-transition>
    <router-link :to='pathTheme'>
      <b-btn class="my-b-btn">{{themeName}}
      </b-btn>
    </router-link>
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