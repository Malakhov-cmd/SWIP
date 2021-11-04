var app = new Vue({
    el: '#Home',
    template:
        <div>
            <div>
                <b-navbar toggleable="lg" type="dark" variant="dark">
                    <b-navbar-brand href="#">
                        <router-link to="/Home" className="mainNav"> Разумные решения</router-link>
                    </b-navbar-brand>
                    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
                    <b-collapse id="nav-collapse" is-nav>
                        <b-navbar-nav className="ml-auto">
                            <b-nav-item href="#">
                                <router-link to="/Request" className="mainNav">Обращения</router-link>
                            </b-nav-item>
                            <b-nav-item href="#">
                                <router-link to="/Resurs" className="mainNav">Ресурсы</router-link>
                            </b-nav-item>
                            <b-nav-item href="#">
                                <router-link to="/Planning" className="mainNav">Планировщик</router-link>
                            </b-nav-item>
                        </b-navbar-nav>
                    </b-collapse>
                </b-navbar>
            </div>
            <b-container>
                <router-view></router-view>
            </b-container>
        </div>,
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