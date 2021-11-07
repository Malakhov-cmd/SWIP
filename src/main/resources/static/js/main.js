import Vue from 'vue'
import VueResource from 'vue-resource'
import VueRouter from "vue-router"
import vuetify from "./plugin/vuetify";
//import './plugin/bootstrap'
import './plugin/bootstrap-vue'
import App from "pages/App.vue";
import HomeMain from "./components/Home/HomeMain.vue";
import LanguageMain from "./components/Language/LanguageMain.vue";
import IntellectTrainingMain from "./components/IntellectTraining/IntellectTrainingMain.vue";
import MessageMain from "./components/Message/MessageMain.vue";
import FriendMain from "./components/Friend/FriendMain.vue";
import SettingsMain from "./components/Settings/SettingsMain.vue";
import LoginMain from "./components/Login/LoginMain.vue";
import test from "./components/Language/Kotlin/Test/test.vue";
import JavaLanguage from "./components/Language/Java/JavaLanguage.vue";
import KotlinLanguage from "./components/Language/Kotlin/KotlinLanguage.vue";
import JSLanguage from "./components/Language/JS/JSLanguage.vue";

//Глобальная шина событий
Vue.prototype.$eventBus = new Vue();

Vue.config.productionTip = false

const routes = [
    {path: '/home', component: HomeMain},
    {path: '/language' , component: LanguageMain},
    {path: '/language/java', component: JavaLanguage},
    {path: '/language/kotlin', component: KotlinLanguage},
    {path: '/language/js', component: JSLanguage},

    //test
    {path: '/language/kotlin/1', component: test},

    {path: '/intellecttraining', component: IntellectTrainingMain},
    {path: '/message', component: MessageMain},
    {path: '/friend', component: FriendMain},
    {path: '/settings', component: SettingsMain},
    {path: '/login', component: LoginMain},
    //{path: '/registration', component: Registration}
]

const router = new VueRouter({
    routes
})

new Vue({
    router,
    vuetify,
    render: h => h(App),
}).$mount('#app')
