<template>
  <div class="profile-main">
    <div class="profile-header">
      <div class="p-4 p-md-5 mb-4 text-white row neomorphism profile-header-content">
        <div class="profile-header-avatar">
          <img class="profile-header-avatar-img"
               width="175" height="170"
               :src="userProfilePhoto"/>
        </div>
        <div class="col-md-6 px-0">
          <h1 class="display-4 fst-italic">{{userName}}</h1>
            <p class="lead my-3 profile-header-description-txt">{{userSelfDescription}}</p>
            <p class="lead mb-0 profile-header-description-txt"><a href="#" class="text-white fw-bold">Continue reading...</a></p>
        </div>
      </div>
    </div>
    <div class="profile-achieves neomorphism">
      <b-carousel
          id="carousel-1"
          v-model="slide"
          :interval="4000"
          controls
          indicators
          background="#ababab"
          img-width="1024"
          img-height="480"
          style="text-shadow: 1px 1px 2px #333;"
          @sliding-start="onSlideStart"
          @sliding-end="onSlideEnd"
      >
        <!-- Text slides with image -->
        <b-carousel-slide
            caption="First slide"
            text="Nulla vitae elit libero, a pharetra augue mollis interdum."
            img-src="https://picsum.photos/1024/480/?image=52"
        ></b-carousel-slide>

        <!-- Slides with custom text -->
        <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
          <h1>Hello world!</h1>
        </b-carousel-slide>

        <!-- Slides with image only -->
        <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>

        <!-- Slides with img slot -->
        <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
        <b-carousel-slide>
          <template #img>
            <img
                class="d-block img-fluid w-100"
                width="1024"
                height="480"
                src="https://picsum.photos/1024/480/?image=55"
                alt="image slot"
            >
          </template>
        </b-carousel-slide>

        <!-- Slide with blank fluid image to maintain slide aspect ratio -->
        <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eros felis, tincidunt
            a tincidunt eget, convallis vel est. Ut pellentesque ut lacus vel interdum.
          </p>
        </b-carousel-slide>
      </b-carousel>

      <p class="mt-4" hidden>
        Slide #: {{ slide }}<br>
        Sliding: {{ sliding }}
      </p>
    </div>
    <div class="profile-main-content language-container">
      <div class="profile-create-post neomorphism">
        <div>
          <p class="lead my-3">Создайте ваш собственный пост</p>
          <div class="profile-create-post-header">

            <b-form-input v-model="postHeader" placeholder="Введите заголовок"></b-form-input>
            <div class="mt-2">Value: {{ postHeader }}</div>
          </div>
          <div class="profile-create-post-text-area">
            <b-form-textarea v-model="postTest" debounce="500" rows="3" max-rows="5" placeholder="Введите текст поста"></b-form-textarea>
            <pre class="mt-2 mb-0">{{ postTest }}</pre>
          </div>
          <b-btn class="my-b-btn">Создать
          </b-btn>
        </div>
      </div>

    </div>
    <div class="profile-footer"></div>
  </div>
</template>

<script>
export default {
  name: "HomeMain",
  data() {
    return {
      userName: "",
      userSelfDescription: "",
      userProfilePhoto: "",
      slide: 0,
      sliding: null,
      postTest: '',
      postHeader: ''
    }
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    }
  },
  mounted() {
    this.userName = window.frontendData.profile.name
    this.userSelfDescription = "Software developer"
    this.userProfilePhoto = frontendData.profile.userpic
  }
}
</script>

<style scoped>

</style>