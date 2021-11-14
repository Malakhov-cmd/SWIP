<template>
  <div id="app">
    <Started/>
  </div>
</template>

<script>
//import axios from "axios";
import Vuetify from "vuetify";
import Started from "../components/Starter.vue";

export default {
  name: 'App',
  vuetify: new Vuetify(),
  components: {
    Started
  },
  mounted() {
  }
}
</script>

<style scoped>
#app{
  min-height: 100vh;
}
</style>