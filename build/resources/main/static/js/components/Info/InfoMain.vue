<template>
  <div id="home-container">
    <div class="Iam">

      <p>SWIP is</p>
      <b class="Iam-b">
        <div class="innerIam">
          simply than you think<br/>
          faster than you expected<br/>
          the best you deserve
        </div>
      </b>
    </div>

    <div class="row home-instruction">
      <div class="col-4 info-nav-panel">
        <div class="list-group" id="list-tab" role="tablist">
          <button class="btn btn-outline-success list-group-item list-group-item-action active" id="list-home-list"
                  data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">
            Info
          </button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-language-list"
                  data-bs-toggle="list" href="#list-language" role="tab" aria-controls="list-language">
            Language
          </button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-smart-training-list"
                  data-bs-toggle="list" href="#list-smart-training" role="tab" aria-controls="list-smart-training">
            Home
          </button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-message-list"
                  data-bs-toggle="list" href="#list-message" role="tab" aria-controls="list-message">
            Message
          </button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-friend-list"
                  data-bs-toggle="list" href="#list-friend" role="tab" aria-controls="list-friend">
            Friend
          </button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-static-list"
                  data-bs-toggle="list" href="#list-static" role="tab" aria-controls="list-static">
            Statistic
          </button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-setting-list"
                  data-bs-toggle="list" href="#list-setting" role="tab" aria-controls="list-setting">
            Setting
          </button>
        </div>
      </div>
      <div class="col-8 info-content-panel">
        <div class="tab-content" id="nav-tabContent">
          <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
            <p class="info-paragraph">
              На этой панели вы можете узнать о всех возможностях приложения.
            </p>
          </div>
          <div class="tab-pane fade" id="list-language" role="tabpanel" aria-labelledby="list-language-list">
            <p class="info-paragraph">
              На панели "Language" вы можете приступить к изучению и освоению языков программирования
            </p>
            <p class="info-paragraph">
              Языки:
            </p>

            <ul>
              <li>
                <p class="info-paragraph">
                  Java
                </p>
              </li>
              <li>
                <p class="info-paragraph">
                  JS
                </p>
                <p class="info-paragraph">
                  Находится в разработке
                </p>
              </li>
              <li>
                <p class="info-paragraph">
                  Kotlin
                </p>
                <p class="info-paragraph">
                  Находится в разработке
                </p>
              </li>
            </ul>

            <p class="info-paragraph">
              Структурный состав языка:
            </p>

            <ul>
              <li>
                <p class="info-paragraph">
                  Главы
                </p>
                <p class="info-paragraph">
                  Главы разделяют языки на крупные логические части. Ваши результаты записываются, а именно количество
                  попыток и время затраченное на выполнение. Все данные отобразятся на панели "Statistic".
                </p>
              </li>
              <li>
                <p class="info-paragraph">
                  Субглавы
                </p>
                <p class="info-paragraph">
                  Субглавы разделяют главы на более точные компоненты. Они помогают формировать структуру языка на
                  road-map.
                </p>
              </li>
              <li>
                <p class="info-paragraph">
                  Темы
                </p>
                <p class="info-paragraph">
                  Темы содержат теоритический блок и практическое задание с вариантами ответов.
                </p>
              </li>
            </ul>

            <p class="info-paragraph">
              Road-map
            </p>
            <p class="info-paragraph">
              Интеллектуальная карта составленная в виде графа с удобном визуальным отображение. Пройдя тему, вы
              увидете, что ее цвет отобразился зеленым. Незавершенные главы будут подсвечиваться желтым - вы в любой
              момент можете вернуться к изучению этой главы, это не позволит вам потерять фокус и забыть чем вы
              занимались до этого.
            </p>
          </div>
          <div class="tab-pane fade" id="list-smart-training" role="tabpanel"
               aria-labelledby="list-smart-training-list">
            <p class="info-paragraph">
              Это ваша страница.
            </p>
            <p class="info-paragraph">
              Здесь вы можете увидеть основную информацию о себе.
            </p>
            <p class="info-paragraph">
              Также здесь представлены все ваши достижения - особые заслуги в обучении, начисляемые в процессе успешного
              прохождения глав и заданий к ним.
            </p>
            <p class="info-paragraph">
              Далее вы можете увидеть форми для создание публикации на своей странице.
            </p>
            <p class="info-paragraph">
              Затем вы увидете свои и чужие публикации с отмеченным количеством лайков и секции комментариев, рабатающих
              в live режиме, где вы можете обсудить аспекты программирования и прочее.
            </p>
          </div>
          <div class="tab-pane fade" id="list-message" role="tabpanel" aria-labelledby="list-message-list">
            <p class="info-paragraph">
              На панеле "Message" вы можете создать диалог с любым пользователем, выполнив поиск по всем пользователям
              сети, используя имя или id.
            </p>
            <p class="info-paragraph">
              Также вы можете создать диалог с тем, кто уже явяляется вашим другом.
            </p>
            <p class="info-paragraph">
              Затем межете перейти в диалог и начать общение, в любой момент вы можете удалить диалог, он автоматически
              удалится у вашего (ваших) знакомых.
            </p>
            <p class="info-paragraph">
              Соблядайте нормы приличия, не оскорбляйте других пользователей пользователей.
            </p>
          </div>
          <div class="tab-pane fade" id="list-friend" role="tabpanel" aria-labelledby="list-friend-list">
            <p class="info-paragraph">
              На панели "Friend" вы можете добавить пользователей в свой список друзей.
            </p>
            <p class="info-paragraph">
              Аналогично с добавлением диалога, вы можете оставить заявку в друзья любому пользователю, выполнив поиск
              по всем пользователям
              сети, используя имя или id.
            </p>
            <p class="info-paragraph">
              Другие пользователи тоже могут оставлять вам заявки в друзья, они отобразятся в субменю "ВХОДЯЩИЕ ЗАЯВКИ".
              Вы можете принять или отклонить заявку.
            </p>
            <p class="info-paragraph">
              Вы можете отменить свою заявку в друзья, просто зайдите в субменю "ИСХОДЯЩИЕ ЗАЯВКИ" и удалите ту, которая
              больше не актуальна по вашему мнению.
            </p>
            <p class="info-paragraph">
              Когда вы примете завку или пользователь примет вашу, в вашем списке друзей отобразится карточка с
              информацией о вашем друге. Вы можете посетить его страницу просто нажав на нее. На странице друга вы
              можете делать все то же, что и на своей.
            </p>
          </div>
          <div class="tab-pane fade" id="list-static" role="tabpanel" aria-labelledby="list-static-list">
            <p class="info-paragraph">
              Статистика создержит информацию о ваших успехах в освоении языков в удобном формате.
            </p>
            <p class="info-paragraph">
              Здесь вы можете узнать о среднем проценте правильных ответов по каждой из глав.
            </p>
            <p class="info-paragraph">
              Соотношении колиества попыток по главе к общему числу заданий.
            </p>
            <p class="info-paragraph">
              Соотношении колиества попыток по главе к общему числу заданий.
            </p>
            <p class="info-paragraph">
              Время затраченное на каждую главу
            </p>
            <p class="info-paragraph">
              Сравнительные графики по правильности ответов и затраченного времени на решение по вашим показателям и
              данных других пользователей.
            </p>
            <p class="info-paragraph">
              График процентного завершения по всем главам и языку в целом.
            </p>
          </div>
          <div class="tab-pane fade" id="list-setting" role="tabpanel" aria-labelledby="list-setting-list">
            <p class="info-paragraph">
              На панели "Settings" вы можете узнать информацию о своейм аккаунте.
            </p>
            <p class="info-paragraph">
              Вы можете указать или изменить свои данные: имя, картинка-аватар, информация о себе.
            </p>
            <p class="info-paragraph">
              В случае если вы захотите поделиться своими социальными сетями или в случае их изменения, вы можете их
              внести эти данные здесь. Они будут отображаться на вашей странице и в настройках чуть ниже.
            </p>
            <p class="info-paragraph">
              Так же на панеле "Settings" вы можете увидеть подробную информацию о своем аккаунте включая: id, email,
              username и прочее.
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeMain",
  data() {
    return {
      text: `
          Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
          richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
          brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
          tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
          assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore
          wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
          vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic
          synth nesciunt you probably haven't heard of them accusamus labore VHS.
        `
    }
  },
  methods: {
    animationText() {
    }
  },
  mounted() {
    console.log("heheheh")
  }
}
</script>

<style scoped>
</style>