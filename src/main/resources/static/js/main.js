var app = new Vue({
    el: '#app',
    template:
        '<div>' +
        '<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>' +
        '<div v-else>' +
        '<div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>' +
        '</div>' +
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
});