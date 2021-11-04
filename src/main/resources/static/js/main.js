import Vue from 'vue'
import VueResource from 'vue-resource'
import VueRouter from "vue-router"
import App from "pages/App.vue";
import HomeMain from "./components/Home/HomeMain.vue";
import LanguageMain from "./components/Language/LanguageMain.vue";
import IntellectTrainingMain from "./components/IntellectTraining/IntellectTrainingMain.vue";
import MessageMain from "./components/Message/MessageMain.vue";
import FriendMain from "./components/Friend/FriendMain.vue";
import SettingsMain from "./components/Settings/SettingsMain.vue";
import LoginMain from "./components/Login/LoginMain.vue";

//Глобальная шина событий
Vue.prototype.$eventBus = new Vue();

Vue.config.productionTip = false

const routes = [
    {path: '/home', component: HomeMain},
    {path: '/language' , component: LanguageMain},
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
    render: h => h(App),
}).$mount('#app')
/*var app = new Vue({
    el: '#app',
    template:
        '<div>' +
        '<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>' +
        '<div v-else>' +
        '<div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>' +
        '</div>' +
        ' <a href=""><router-link to="/message-list" class="mainNav">Language</router-link> </a>' +
        '<b-container>' +
            '<router-view></router-view>' +
        '</b-container>' +
        '</div>',
    data: {
        profile: frontendData.profile
    },
    created: function() {
//    messageApi.get().then(result =>
//        result.json().then(data =>
//            data.forEach(message => this.messages.push(message))
//        )
//    )
    },
});*/