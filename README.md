# SWIP

___
**Main info**

Application for learning programming, which includes all the features of a social network

Structuring is the creation of a solid framework on the basis of which the memorization of all the necessary information will be built. An additional criterion is visualization, therefore, a graphical representation of information with a clearly defined structure is necessary. This requirement is met by a diagram - a mental map. A mental map is a diagram used to visually organize information. The mental map is hierarchical and shows the relationship between the parts of the whole.

That is why this application is based on the concept of a dynamic mental map.

**About project**

Program components:

+ Server - responsible for business logic фтв data management.
+ Frontend - responsible for the graphical presentation and dynamic update of the data presented to the user.

**Project components**

    Language:
          panel for choosing a programming language to learn.
          Available languages:
            Java
            Kotlin - in development
            JS - in development

    Home:
          Here you can see basic information about yourself.
          Also here are all your achievements - special merits in
          learning, accrued in the process of successfully completing
          chapters and tasks for them.

          Next, you can see the form for creating a publication on your page.

          Then you'll see your own and others' posts with a marked number of
          likes and a live comment section where you can discuss aspects of
          programming and more.

    Message:
          In the "Message" panel, you can create a conversation with any user
          by searching all network users using the name or id.

          You can also create a dialogue with someone who is already your friend.

          Then you can go to the dialogue and start communication, at any time
          you can delete the dialogue, it will automatically be deleted from 
          your (your) friends.

    Friend:
          In the "Friend" panel, you can add users to your friends list.

          Similarly with adding a dialog, you can make a friend request to any
          user by searching all network users using the name or id.

          Other users can also leave you friend requests, they will be displayed
          in the "INCOMING REQUESTS" submenu. You can accept or reject the application.

          You can cancel your friend request, just go to the "OUTGOING REQUEST"
          submenu and delete the one that is no longer relevant in your opinion.

          When you accept an application or a user accepts yours, a card with 
          information about your friend will be displayed in your friends list.
          You can visit his page by simply clicking on it. On a friend's page, you can do everything that you do on your own.

    Statistic:
          Statistics will contain information about your progress in learning
          languages in a convenient format.

          Here you can find out about the average percentage of correct answers
          for each of the chapters.

          The ratio of the number of attempts per chapter to the total number
          of tasks.

          The ratio of the number of attempts per chapter to the total number
          of tasks.

          Time spent on each chapter

          Comparative charts on the correctness of the answers and the time 
          spent on the decision on your indicators and data from other users.

          Graph of percentage completion for all chapters and the language as
          a whole.   

    Settings:
          На панели "Settings" вы можете узнать информацию о своейм аккаунте.

          Вы можете указать или изменить свои данные: имя, картинка-аватар,
          информация о себе.

          В случае если вы захотите поделиться своими социальными сетями или
          в случае их изменения, вы можете их внести эти данные здесь. Они 
          будут отображаться на вашей странице и в настройках чуть ниже.
**Demonstration of work**

Welcome page for providing instructions on sections?

![img of info page](https://i.ibb.co/7SN6t6k/Intro.png)

Dynamic mind map showing your learning progress:

![img of info page](https://i.ibb.co/gZGrtZ6/MainMap.png)

An example of one of the chapters that opens when you click on the top of the mental map:

![img of info page](https://i.ibb.co/f22sXHv/Example-Of-Task.png)

An example of a correctly completed task at the end of the chapter:

![img of info page](https://i.ibb.co/6tqMnvw/image.png)

User home page:

![img of info page](https://i.ibb.co/6NQnggH/Wall.png)

User post and comment section:

![img of info page](https://i.ibb.co/sVLNrbk/Post.png)

Chat room:

![img of info page](https://i.ibb.co/hFRv9jw/Chat.png)

Statistic page:

![img of info page](https://i.ibb.co/ySxKY4X/Statistic.png)

**Application properties**

Server starts on - http://localhost:9000

Npm server start on -  http://localhost:8000



To enable the frontend side don't forget to run the ``` npm start``` command.