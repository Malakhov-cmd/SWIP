<template>
  <div id="app">
    <Started/>
  </div>
</template>

<script>
//import axios from "axios";
import Vuetify from "vuetify";
import Started from "../components/Starter.vue";
import axios from "axios";

export default {
  name: 'App',
  vuetify: new Vuetify(),
  data() {
    return {
      data: null
    }
  },
  components: {
    Started
  }
}
</script>

<style scoped>
#app{
  min-height: 100vh;
}
</style>