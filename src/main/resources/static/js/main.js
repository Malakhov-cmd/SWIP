import Vue from 'vue'
import VueResource from 'vue-resource'
import App from "pages/App.vue";


Vue.use(VueResource)

new Vue({
    el: '#app',
    render: a => a(App)
})

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