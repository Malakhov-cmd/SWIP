import Vue from 'vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// register the plugin on vue
import Toasted from 'vue-toasted';

// Import Bootstrap an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

// you can also pass options, check options reference below
Vue.use(Toasted, {
    iconPack: 'material' // set your iconPack, defaults to material. material|fontawesome|custom-class
})