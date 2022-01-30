<template>
  <div class="profile-main">

    <div>Пользователь {{ $route.params.id }}</div>

    <div class="profile-header">
      <div class="p-4 p-md-5 mb-4 text-white row neomorphism profile-header-content">
        <div class="profile-header-avatar">
          <img class="profile-header-avatar-img"
               width="175" height="170"
               :src="userProfilePhoto"/>
        </div>
        <div class="col-md-6 px-0">
          <h1 class="display-4 fst-italic">{{ userName }}</h1>
          <p class="lead my-3 profile-header-description-txt">{{ userSelfDescription }}</p>
          <p class="lead mb-0 profile-header-description-txt"><a href="#" class="text-white fw-bold">Continue
            reading...</a></p>
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
          <p class="lead my-3 profile-create-post-welcome-header">
            Создайте ваш собственный пост
          </p>
          <div class="profile-create-post-header">
            <b-form-input v-model="postHeader" placeholder="Введите заголовок"></b-form-input>
          </div>
          <div class="profile-create-post-text-area">
            <b-form-textarea v-model="postTest" debounce="500" rows="3" max-rows="5"
                             placeholder="Введите текст поста"></b-form-textarea>
          </div>
          <b-btn class="my-b-btn" v-on:click="requestCreatePost">Создать
          </b-btn>
        </div>
      </div>

      <div class="profile-main-posts" v-show="existingPost">
        <div class="profile-main-posts-iterable"
             v-for="(value, index) in existingPost? owner.posts: null">
          <div class="profile-post neomorphism">
            <div class="profile-post-header-main-info">
              <div class="profile-post-header-author-info">
                <img class="profile-post-header-author-info-avatar-img"
                     width="75" height="75"
                     :src="value.authorImg"/>
                <div class="profile-post-header-author-info-name">
                  {{ value.author }}
                </div>
              </div>
              <div class="profile-post-header-time-creation">
                {{ value.postDate }}
              </div>
            </div>
            <div>
              <div class="profile-post-header">
                <p class="profile-post-header-txt">{{ value.header }}</p>
              </div>
              <div class="profile-post-text-area">
                <p>{{ value.text }}</p>
              </div>
            </div>
            <div class="profile-post-footer">
              <div class="profile-post-footer-icons-line">
                <div class="profile-post-footer-icons-line-likes">
                  <b-btn class="like-button profile-post-footer-icons"
                         v-on:click="requestLike(value.id, index)">
                    <b-icon-heart-fill font-scale="2"></b-icon-heart-fill> {{value.likes.length}}
                  </b-btn>
                </div>
                <div class="profile-post-footer-icons-line-comments">
                  <div>
                    <b-button class="profile-post-footer-icons"
                              :class="getCollapse(index) ?'collapsed': null"
                              :aria-expanded="getCollapse(index) ?  'false': 'true'"
                              aria-controls="collapse-4"
                              @click="setCollapse(index)"
                    >
                      <b-icon-chat-right-dots-fill font-scale="2"></b-icon-chat-right-dots-fill>
                    </b-button>
                  </div>
                </div>
              </div>
              <div class="profile-post-comment">
                <b-collapse id="collapse-4" :visible="getCollapse(index)" class="mt-2 profile-post-comment">
                  <div class="profile-post-comment-input-new-comment">
                    <b-form-textarea v-model="commentsText[index]" debounce="500" rows="3" max-rows="5"
                                     placeholder="Введите текст комментария"></b-form-textarea>
                    <b-btn class="my-b-btn" v-on:click="requestCreateComment(index)">Оставить</b-btn>
                  </div>
                  <div class="profile-post-comment-section">
                    <div class="profile-comments"
                         v-for="(valueComment, indexComment) in checkCommentExisting(index)? value.comments: null">
                      <div class="profile-comment-data">
                        <div class="profile-comment-data-my-comment"
                             v-show="isMyComment(valueComment.authorId)">
                          <div class="profile-comment-data-my-comment-img-with-message">
                            <img class="profile-comment-data-my-comment-avatar-img"
                                 width="35" height="35"
                                 :src="valueComment.authorImg"/>
                            <div class="bubble-message theme bubble-message-left"
                                 :data-time=valueComment.commentDate>
                              {{ valueComment.text }}
                            </div>
                          </div>
                          {{ valueComment.author }}
                        </div>

                        <div class="profile-comment-data-stranger-comment"
                             v-show="!isMyComment(valueComment.authorId)">
                          <div class="bubble-message theme" :data-time=valueComment.commentDate>
                            {{ valueComment.text }}
                          </div>
                          {{ valueComment.author }}
                        </div>

                        <svg height="0" width="0">
                          <defs>
                            <clipPath id="svgPath">
                              <path fill="#FFFFFF" d="M20,20H0V0H0A20,20,0,0,0,20,20Z"/>
                            </clipPath>
                          </defs>
                        </svg>
                      </div>
                    </div>
                  </div>
                </b-collapse>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="profile-footer"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false
let tempWallData = null


export default {
  name: "AnotherUserPage",
  data() {
    return {
      owner: null,

      userName: "",
      userSelfDescription: "",
      userProfilePhoto: "",
      slide: 0,
      sliding: null,
      postTest: '',
      postHeader: '',
      existingPost: false,
      existingComment: false,
      currentUser: null,

      commentsText: [],
      expandedArray: []
    }
  },
  computed: {
    id() {
      return this.$route.params.id;
    },
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    },
    getCollapse(index) {
      return this.expandedArray[index]
    },
    setCollapse(index) {
      this.expandedArray[index] = !this.expandedArray[index]
    },
    isMyComment(commentOwner) {
      return commentOwner === window.frontendData.profile.id
    },
    checkCommentExisting(index) {
      return this.owner.posts[index].comments.length > 0;
    },
    requestCreatePost() {
      axios.get('http://localhost:9000/home/post/creation', {
        params: {
          wallId: this.owner.id,
          authorId: window.frontendData.profile.id,
          header: this.postHeader,
          text: this.postTest
        }
      })
          .then(function (response) {
            tempWallData = response.data

            isSendedandrecived = true
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          this.owner = tempWallData
          this.postHeader = ""
          this.postTest = ""

          this.existingPost = true
          this.sortingPost()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestCreateComment(index) {
      axios.get('http://localhost:9000/home/comment/creation', {
        params: {
          authorId: window.frontendData.profile.id,
          postId: this.owner.posts[index].id,
          text: this.commentsText[index]
        }
      })
          .then(function (response) {
            tempWallData.posts[index] = response.data

            isSendedandrecived = true
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          this.owner.posts[index] = tempWallData.posts[index]

          this.commentsText[index] = ''

          this.sortingComments()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestLike(postId, index) {
      axios.get('http://localhost:9000/home/post/like', {
        params: {
          postId: postId,
          likerId: window.frontendData.profile.id,
        }
      })
          .then(function (response) {
            tempWallData.posts[index].likes = response.data

            isSendedandrecived = true
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          this.owner.posts[index].likes = tempWallData.posts[index].likes

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    sortingPost() {
      this.owner.posts.sort(function (a, b) {
        if (a.id < b.id) {
          return 1;
        }
        if (a.id > b.id) {
          return -1;
        }
        return 0;
      });
    },
    sortingComments() {
      for (const comments of this.owner.posts) {
        comments.comments.sort(function (a, b) {
          if (a.id < b.id) {
            return 1;
          }
          if (a.id > b.id) {
            return -1;
          }
          return 0;
        });
      }
    }
  },
  mounted() {
    axios.get('http://localhost:9000/api/userinfo/wall', {
      params: {
        userId: this.id
      }
    })
        .then(function (response) {
          tempWallData = response.data

          isSendedandrecived = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval = setInterval(() => {
      if (isSendedandrecived) {
        isSendedandrecived = false

        this.owner = tempWallData

        this.currentUser = window.frontendData.profile

        this.userName = this.owner.owner.name
        this.userSelfDescription = "Software developer"
        this.userProfilePhoto = this.owner.owner.userpic

        if (this.owner.posts.length > 0) {
          this.existingPost = true
          this.sortingPost()
          this.sortingComments()
        }

        for (let i = 0; i < this.owner.posts.length; i++) {
          this.expandedArray[i] = false
          this.commentsText[i] = ''
        }

        clearInterval(interval)
      }
    }, 200)

    //TODO добавь валидацию + rendering
  }
}
</script>

<style scoped>

</style>