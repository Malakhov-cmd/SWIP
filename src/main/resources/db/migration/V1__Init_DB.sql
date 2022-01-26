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
    author       varchar(256),
    author_id    varchar(512),
    author_img   varchar(4096),
    comment_date timestamp,
    text         varchar(255),
    post_id      int8,
    primary key (id)
);
create table home_wall_post_likes
(
    id         int8 not null,
    liker      varchar(255),
    comment_id int8,
    post_id    int8,
    primary key (id)
);
create table home_wall_posts
(
    id         int8 not null,
    author_id  varchar(1024),
    author     varchar(512),
    author_img varchar(4096),
    header     varchar(255),
    post_date  timestamp,
    text       varchar(255),
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
    id       int8 not null,
    answer   varchar(4256),
    theme_id int8,
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
    id         varchar(1024) not null,
    email      varchar(512),
    last_visit timestamp,
    locale     varchar(255),
    name       varchar(1024),
    userpic    varchar(4096),
    primary key (id)
);
create table usr_friend_list
(
    usr_friend_list_id varchar(255) not null,
    friend_list_id     varchar(255) not null
);
create table usr_income_friend_list
(
    usr_income_friend_list_id       varchar(255) not null,
    friend_incoming_request_list_id varchar(255) not null
);
create table usr_outgo_friend_list
(
    usr_outgo_friend_list_id        varchar(255) not null,
    friend_outgoing_request_list_id varchar(255) not null
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
/*alter table usr_friend_list
    drop constraint UK_bg4twtbywjtlllf1rvcv96not;*/
alter table usr_friend_list
    add constraint UK_bg4twtbywjtlllf1rvcv96not unique (friend_list_id);
/*alter table usr_income_friend_list
    drop constraint UK_4tsscvmx290pud48d5mbxsl2g;*/
alter table usr_income_friend_list
    add constraint UK_4tsscvmx290pud48d5mbxsl2g unique (friend_incoming_request_list_id);
/*alter table usr_outgo_friend_list
    drop constraint UK_c0mmup4i9qvj11t25k0hd3tic;*/
alter table usr_outgo_friend_list
    add constraint UK_c0mmup4i9qvj11t25k0hd3tic unique (friend_outgoing_request_list_id);
alter table usr_friend_list
    add constraint FKspnqk93q2y6j28ewo9cx2o113 foreign key (friend_list_id) references usr;
alter table usr_friend_list
    add constraint FKoenri9gqv7qej7kpli6m0pj1 foreign key (usr_friend_list_id) references usr;
alter table usr_income_friend_list
    add constraint FKc4gqe11x093nq44nwmluxhbwo foreign key (friend_incoming_request_list_id) references usr;
alter table usr_income_friend_list
    add constraint FK8q14eq5v4r2i0he1rs87sj6w9 foreign key (usr_income_friend_list_id) references usr;
alter table usr_outgo_friend_list
    add constraint FKimmms0kya09jo735is778wdjf foreign key (friend_outgoing_request_list_id) references usr;
alter table usr_outgo_friend_list
    add constraint FKmpwcq5hqc560614ifxff8idfk foreign key (usr_outgo_friend_list_id) references usr;