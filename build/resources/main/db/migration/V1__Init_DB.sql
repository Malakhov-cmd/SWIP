create sequence hibernate_sequence start 1 increment 1;
create table home_wall
(
    id       int8 not null,
    owner_id varchar(1024),
    primary key (id)
);
create table home_wall_post_comment
(
    id           int8 not null,
    author       varchar(512),
    author_id    varchar(512),
    author_img   varchar(5256),
    comment_date timestamp,
    text         varchar(4096),
    post_id      int8,
    primary key (id)
);
create table home_wall_post_likes
(
    id         int8 not null,
    liker      varchar(512),
    comment_id int8,
    post_id    int8,
    primary key (id)
);
create table home_wall_posts
(
    id         int8 not null,
    author_id  varchar(1024),
    author     varchar(512),
    author_img varchar(5256),
    header     varchar(512),
    post_date  timestamp,
    text       varchar(12000),
    wall_id    int8,
    primary key (id)
);
create table java_chapter_themes_list
(
    java_chapter_themes_list_id int8 not null,
    list_themes_id              int8 not null
);
create table java_language_chapters
(
    java_language_chapters_id int8 not null,
    chapters_id               int8 not null
);
create table java_language_road
(
    id       int8   not null,
    name     varchar(1024),
    progress float8 not null,
    owner_id varchar(512),
    primary key (id)
);
create table java_language_road_chapter
(
    id               int8   not null,
    chapter_progress float8 not null,
    number_chapter   int4,
    lang_id          int8,
    primary key (id)
);
create table java_language_road_task
(
    id                          int8 not null,
    answer                      varchar(4256),
    theme_id                    int8,
    time_on_solution_in_seconds int4 not null,
    try_count                   int4 not null,

    primary key (id)
);
create table java_language_road_themes
(
    id              int8    not null,
    is_finished     boolean not null,
    number          int4,
    chapter_id      int8,
    java_theme_task int8,
    primary key (id)
);
create table post_comments
(
    post_comments_id int8 not null,
    comments_id      int8 not null
);
create table post_comments_likes
(
    post_comments_likes_id int8 not null,
    likes_id               int8 not null
);
create table post_likes
(
    post_likes_id int8 not null,
    likes_id      int8 not null
);
create table posts_list
(
    posts_list_id int8 not null,
    posts_id      int8 not null
);
create table usr
(
    id               varchar(512) not null,
    email            varchar(512),
    last_visit       timestamp,
    locale           varchar(32),
    name             varchar(512),
    userpic          varchar(5256),
    self_description varchar(4096),
    git_link         varchar(2056),
    instagram_link   varchar(2056),
    face_book_link   varchar(2056),
    primary key (id)
);
create table usr_friend_list
(
    usr_friend_list_id varchar(512) not null,
    friend_list_id     int8         not null
);
create table usr_income_friend_list
(
    usr_income_friend_list_id       varchar(512) not null,
    friend_incoming_request_list_id int8         not null
);
create table usr_outgo_friend_list
(
    usr_outgo_friend_list_id        varchar(512) not null,
    friend_outgoing_request_list_id int8         not null
);
create table usr_friend
(
    id            int8 not null,
    friend_id     varchar(512),
    friendemail   varchar(512),
    friendlocale  varchar(36),
    friendname    varchar(512),
    frienduserpic varchar(5256),
    usr_id        varchar(512),
    primary key (id)
);


create table dialog
(
    id int8 not null,
    primary key (id)
);
create table dialog_member
(
    id               int8 not null,
    member_id        varchar(512),
    memberemail      varchar(512),
    memberlocale     varchar(36),
    membername       varchar(512),
    memberuserpic    varchar(5256),
    dialog_member_id int8,
    usr_id           varchar(512),
    primary key (id)
);
create table dialog_members
(
    dialog_members_id int8 not null,
    members_id        int8 not null
);
create table dialog_message
(
    id                       int8 not null,
    text                     varchar(4096),
    time_sent                timestamp,
    dialog_message_member_id int8,
    dialog_message_root_id   int8,
    primary key (id)
);
create table dialog_messages
(
    dialog_messages_id int8 not null,
    message_list_id    int8 not null
);
create table usr_dialog_list
(
    usr_dialog_list_id varchar(255) not null,
    dialog_list_id     int8         not null
);

create table achive
(
    id          int8 not null,
    name        varchar(256),
    description varchar(1024),
    img_link    varchar(5256),
    primary key (id)
);

create table usr_achives_list
(
    usr_achives_list_id varchar(255) not null,
    achives_list_id     int8         not null
);

alter table java_chapter_themes_list
    add constraint UK_a3ffkpvrr6wghiuwfkxtdi402 unique (list_themes_id);
alter table java_language_chapters
    add constraint UK_pve9uxtgl1huqc59xf90d33ja unique (chapters_id);
alter table post_comments
    add constraint UK_gq9be62nx9c9hc0uyhakey771 unique (comments_id);
alter table post_comments_likes
    add constraint UK_gh5ewdhe142r0ghaf1admt02a unique (likes_id);
alter table post_likes
    add constraint UK_sut81mbk7x7etpp1sx811wtit unique (likes_id);
alter table posts_list
    add constraint UK_ltkl8gw9ihbjokpe954ijp60e unique (posts_id);
alter table home_wall
    add constraint FKn6vcxmif41nbr3mim5520w48s foreign key (owner_id) references usr;
alter table home_wall_post_comment
    add constraint FKhx0dq29furukg4kcam5r8i2ti foreign key (post_id) references home_wall_posts;
alter table home_wall_post_likes
    add constraint FK8nndvrknijld9kh4arw1qltol foreign key (comment_id) references home_wall_post_comment;
alter table home_wall_post_likes
    add constraint FKoxgj35let8x40spjhdfc3upvv foreign key (post_id) references home_wall_posts;
alter table home_wall_posts
    add constraint FKnas0kl76ttc0cupggn4h77gsn foreign key (wall_id) references home_wall;
alter table java_chapter_themes_list
    add constraint FKdxkmbxbk0pbj1xqv3kkvo57c8 foreign key (list_themes_id) references java_language_road_themes;
alter table java_chapter_themes_list
    add constraint FKjn58blu1u5txswiq93231hk1o foreign key (java_chapter_themes_list_id) references java_language_road_chapter;
alter table java_language_chapters
    add constraint FK5r90hwgy24sdppp6cut7k6n8n foreign key (chapters_id) references java_language_road_chapter;
alter table java_language_chapters
    add constraint FK987f3v3psam3kgu95sq5b0df9 foreign key (java_language_chapters_id) references java_language_road;
alter table java_language_road
    add constraint FKrcwrk805uhtybss0a6prmgm2r foreign key (owner_id) references usr;
alter table java_language_road_chapter
    add constraint FKb93wmtnn6y0ajshfq3tm5atw3 foreign key (lang_id) references java_language_road;
alter table java_language_road_task
    add constraint FK4nfs4wiptvlx3bac01he1p7d foreign key (theme_id) references java_language_road_themes;
alter table java_language_road_themes
    add constraint FKit1kwn5qglo7ioy7i7fb112ga foreign key (chapter_id) references java_language_road_chapter;
alter table java_language_road_themes
    add constraint FKmt3jlbt0cxxm94kte9d93rcco foreign key (java_theme_task) references java_language_road_task;
alter table post_comments
    add constraint FKlohck6f1l1t77c908ta84h5ko foreign key (comments_id) references home_wall_post_comment;
alter table post_comments
    add constraint FKlc9fs0r8m4cfbbd4ue4y2ttny foreign key (post_comments_id) references home_wall_posts;
alter table post_comments_likes
    add constraint FK6pbtjepchuu9mvn1ehjvemfrt foreign key (likes_id) references home_wall_post_likes;
alter table post_comments_likes
    add constraint FK13hxdrwa7mwyubd3tehik5bdt foreign key (post_comments_likes_id) references home_wall_post_comment;
alter table post_likes
    add constraint FK12ygb5j7jfek46u140owmw2sc foreign key (likes_id) references home_wall_post_likes;
alter table post_likes
    add constraint FKm9xtt0tp02y44ed55gwg7t152 foreign key (post_likes_id) references home_wall_posts;
alter table posts_list
    add constraint FK2korod2vk2hgxtmf3lx7w5ftb foreign key (posts_id) references home_wall_posts;
alter table posts_list
    add constraint FKc4egkad93sxsyxkbdv95qpinx foreign key (posts_list_id) references home_wall;
alter table usr_friend_list
    add constraint UK_bg4twtbywjtlllf1rvcv96not unique (friend_list_id);
alter table usr_income_friend_list
    add constraint UK_4tsscvmx290pud48d5mbxsl2g unique (friend_incoming_request_list_id);
alter table usr_outgo_friend_list
    add constraint UK_c0mmup4i9qvj11t25k0hd3tic unique (friend_outgoing_request_list_id);
alter table usr_friend_list
    add constraint FKn2xw2dw92ggide3dekuwyi3bb foreign key (friend_list_id) references usr_friend;
alter table usr_friend_list
    add constraint FKoenri9gqv7qej7kpli6m0pj1 foreign key (usr_friend_list_id) references usr;
alter table usr_income_friend_list
    add constraint FKgfhmit7fdnooc7lg272o0p2sr foreign key (friend_incoming_request_list_id) references usr_friend;
alter table usr_income_friend_list
    add constraint FK8q14eq5v4r2i0he1rs87sj6w9 foreign key (usr_income_friend_list_id) references usr;
alter table usr_outgo_friend_list
    add constraint FKqv0frfb2mihekux97x7w7o0pe foreign key (friend_outgoing_request_list_id) references usr_friend;
alter table usr_outgo_friend_list
    add constraint FKmpwcq5hqc560614ifxff8idfk foreign key (usr_outgo_friend_list_id) references usr;
alter table usr_friend
    add constraint FKpl2q8n8rdqym2j2vv2orb1hh7 foreign key (usr_id) references usr;
alter table dialog_members
    add constraint UK_hdflnchpregquwel7h8g8wgxe unique (members_id);
alter table dialog_messages
    add constraint UK_7t5yibq8hoqqr9n51scipcnia unique (message_list_id);
alter table dialog_member
    add constraint FK9r2gfmhysrfxs0332uxoxwa18 foreign key (dialog_member_id) references dialog;
alter table dialog_member
    add constraint FKihkt0ql54c6us9ywfpy93bxln foreign key (usr_id) references usr;
alter table dialog_members
    add constraint FK2bek4um2m8uc9ltdg6w141dho foreign key (members_id) references dialog_member;
alter table dialog_members
    add constraint FKd1b5xnh047u4s97d0pao02eh7 foreign key (dialog_members_id) references dialog;
alter table dialog_message
    add constraint FKsc0asfd5gxoy9lsmmlqqf4oo1 foreign key (dialog_message_member_id) references dialog_member;
alter table dialog_message
    add constraint FK5a49jw1d8ujdhgedx2r7q6pf8 foreign key (dialog_message_root_id) references dialog;
alter table dialog_messages
    add constraint FKrh7jsn8lralw5va90ryyts1kp foreign key (message_list_id) references dialog_message;
alter table dialog_messages
    add constraint FKbex23apu6bfpvev3v246pcar2 foreign key (dialog_messages_id) references dialog;
alter table usr_dialog_list
    add constraint FKq9g0f0oil4mdawy363xhsitlp foreign key (dialog_list_id) references dialog;
alter table usr_dialog_list
    add constraint FK4e9lx2pufd70qkukkvibhs57 foreign key (usr_dialog_list_id) references usr;

alter table usr_achives_list
    add constraint FKgcdbp59mr14wk8yd7t8iku5kp foreign key (achives_list_id) references achive;
alter table usr_achives_list
    add constraint FK1o8gxoggr3ersait8oyi1m1mc foreign key (usr_achives_list_id) references usr;

insert into achive (id, name, description, img_link)
VALUES (0, 'startedAchive', 'Вы начали путь освоения программирования. Так держать!',
        'https://ia.wampi.ru/2022/02/28/1094cb0e038b42306.jpg'),
       (1, 'endedChapter1', 'Вы успешно освоили вводную часть. Так держать!',
        'https://ia.wampi.ru/2022/02/28/2e661fa685a5bbbb8.jpg'),
       (2, 'endedChapter2', 'Вы успешно освоили языковые конструкции. Так держать!',
        'https://ie.wampi.ru/2022/02/28/33f43b4bdd1c00b5d.jpg'),
       (3, 'endedChapter3', 'Вы успешно освоили ООП. Так держать!',
        'https://ia.wampi.ru/2022/02/28/4e823c5b6e39b54bd.jpg'),
       (4, 'endedChapter4', 'Вы успешно освоили принцип наследование. Так держать!',
        'https://ia.wampi.ru/2022/02/28/533db8f46853ce655.jpg'),
       (5, 'endedChapter5', 'Вы успешно освоили интерфейсы и функциональный подход. Так держать!',
        'https://ie.wampi.ru/2022/02/28/6fe9a27396124b62d.jpg'),
       (6, 'endedChapter6', 'Вы успешно освоили исключения. Так держать!',
        'https://ia.wampi.ru/2022/02/28/40.jpg'),
       (7, 'endedChapter7', 'Вы успешно освоили обобщенное программирование. Так держать!',
        'https://ie.wampi.ru/2022/02/28/816f15b4720782739.jpg'),
       (8, 'endedChapter8', 'Вы успешно освоили collection framework. Так держать!',
        'https://ie.wampi.ru/2022/02/28/9d209f06877639fa4.jpg'),
       (9, 'endedChapter9', 'Вы успешно освоили потоки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/108e706e81e3574dc0.jpg'),
       (10, 'endedChapter10', 'Вы успешно освоили streams. Так держать!',
        'https://ie.wampi.ru/2022/02/28/1179a40fce42699fcc.jpg'),
       (11, 'endedChapter11', 'Вы успешно освоили потоки ввода вывода. Так держать!',
        'https://ia.wampi.ru/2022/02/28/12bc4d552bf3593022.jpg'),
       (12, 'endedChapter12', 'Вы успешно освоили XML. Так держать!',
        'https://ie.wampi.ru/2022/02/28/1367171b4ac2abdd69.jpg'),
       (13, 'endedChapter13', 'Вы успешно освоили написание сценариев. Так держать!',
        'https://ia.wampi.ru/2022/02/28/40.jpg'),
       (14, 'endedChapter14', 'Вы успешно освоили модули. Так держать!',
        'https://ia.wampi.ru/2022/02/28/1580b7ad716933c2c9.jpg'),
       (15, 'totalEnded25', 'Вы прошли 25 процентов. Так держать!',
        'https://ie.wampi.ru/2022/02/28/16fa836dbb65c8483f.jpg'),
       (16, 'totalEnded50', 'Вы прошли 50 процентов. Так держать!',
        'https://ia.wampi.ru/2022/02/28/17jpg.jpg'),
       (17, 'totalEnded75', 'Вы прошли 75 процентов. Так держать!',
        'https://ie.wampi.ru/2022/02/28/1827fe619b122c9c39.jpg'),
       (18, 'totalEnded100', 'Вы прошли 100 процентов. Так держать!',
        'https://ie.wampi.ru/2022/02/28/19jpg.jpg'),
       (19, 'endedWithoutException1', 'Вы завершили главу 1 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/201a2600a026e64792.jpg'),
       (20, 'endedWithoutException2', 'Вы завершили главу 2 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/219e8695f837132ef6.jpg'),
       (21, 'endedWithoutException3', 'Вы завершили главу 3 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/2208a18dff90fb6223.jpg'),
       (22, 'endedWithoutException4', 'Вы завершили главу 4 без единой ошибки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/2353b33a9f55eccf22.jpg'),
       (23, 'endedWithoutException5', 'Вы завершили главу 5 без единой ошибки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/24.jpg'),
       (24, 'endedWithoutException6', 'Вы завершили главу 6 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/25.jpg'),
       (25, 'endedWithoutException7', 'Вы завершили главу 7 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/2691e0e9515690c7fe.jpg'),
       (26, 'endedWithoutException8', 'Вы завершили главу 8 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/27.jpg'),
       (27, 'endedWithoutException9', 'Вы завершили главу 9 без единой ошибки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/28.jpg'),
       (28, 'endedWithoutException10', 'Вы завершили главу 10 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/29.jpg'),
       (29, 'endedWithoutException11', 'Вы завершили главу 11 без единой ошибки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/30.jpg'),
       (30, 'endedWithoutException12', 'Вы завершили главу 12 без единой ошибки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/312aaf642ece475bb8.jpg'),
       (31, 'endedWithoutException13', 'Вы завершили главу 13 без единой ошибки. Так держать!',
        'https://ie.wampi.ru/2022/02/28/32a81ce347a204aad9.jpg'),
       (32, 'endedWithoutException14', 'Вы завершили главу 14 без единой ошибки. Так держать!',
        'https://ia.wampi.ru/2022/02/28/34.jpg'),
       (33, 'specialAchevi1', 'Специальное достижение номер 1',
        'https://ie.wampi.ru/2022/02/28/33.jpg'),
       (34, 'specialAchevi2', 'Специальное достижение номер 2',
        'https://ie.wampi.ru/2022/02/28/354149cd97ffd80d1b.jpg'),
       (35, 'specialAchevi3', 'Специальное достижение номер 3',
        'https://ia.wampi.ru/2022/02/28/36.jpg'),
       (36, 'specialAchevi4', 'Специальное достижение номер 4',
        'https://ia.wampi.ru/2022/02/28/379de9e4f976f94784.jpg'),
       (37, 'specialAchevi5', 'Специальное достижение номер 5',
        'https://ie.wampi.ru/2022/02/28/3827033bf9d0432c1b.jpg'),
       (38, 'specialAchevi6', 'Специальное достижение номер 6',
        'https://ie.wampi.ru/2022/02/28/39.jpg'),
       (39, 'specialAchevi7', 'Специальное достижение номер 7',
        'https://ia.wampi.ru/2022/02/28/40.jpg');
