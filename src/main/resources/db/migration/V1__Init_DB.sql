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
VALUES (0, 'startedAchive', 'Вы начали путь освоения программирования. Так держать!', 'https://downloader.disk.yandex.ru/preview/9692b6bb9787b1561d6708649bfe8d18f86d55b2b379994985415f185e299f16/62019056/UVwpJcsUqtSrxIJQ58XvR_-y--Wz5vwVgHzy7jCpOgUJya0qwCN2wwIlpYQ0xWxBN0fMC3jVkMQgDsoL0uuRLA%3D%3D?uid=0&filename=21.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (1, 'endedChapter1', 'Вы успешно освоили вводную часть. Так держать!', 'https://downloader.disk.yandex.ru/preview/c86dd3fff3c1ecc6880763bf2331169b43689e86dedb98f115b2a01330c057e8/62019056/Izb94nG111fQJHJH7F0cS69kMvFS1tR8KdnIFCUI-STQG7W3uzGNA2QolYFMmKB4ofdGDeUhbA3096Ng4doyjA%3D%3D?uid=0&filename=33.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (2, 'endedChapter2', 'Вы успешно освоили языковые конструкции. Так держать!', 'https://downloader.disk.yandex.ru/preview/e8f8f99f6f6b3257c182b362872f7c61698d1d7e3f04f09497be605537d5bad7/62019056/L-IPiRRlTriUlbMP7_w9j3BOhaAoTHW2g_DH2wB_Zd_N3_sMHgX5GNiq4mc3wMal1t-4Uy98H0d_VlbACmIVcQ%3D%3D?uid=0&filename=3.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (3, 'endedChapter3', 'Вы успешно освоили ООП. Так держать!', 'https://downloader.disk.yandex.ru/preview/42e29ab3a1691414c8e2310a0f684ef98eac40a61060a271edc174bc8f66bda5/62019056/o5w99zsVhxzcr370HktBgww4k8FRkjaCaw0K3q64q7hZpWQvmMvvc_-RHKgJIuvpXNXAuk-nh89DoQFipCcdCw%3D%3D?uid=0&filename=19jpg.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (4, 'endedChapter4', 'Вы успешно освоили принцип наследование. Так держать!', 'https://downloader.disk.yandex.ru/preview/6c19536b42c7c70533d971fb5e3fc1257bdd4eb4e08724f3a1ebc0fc400cbb1c/62019056/LVKZOez5Ck6i5f1cyHW7pmrQ8HgRHYmM57L9SNiOFDPqlyUUY4dDXS1TrdzF5Ad8B7YIaT2ifa5AuU-ga-ER2w%3D%3D?uid=0&filename=6.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (5, 'endedChapter5', 'Вы успешно освоили интерфейсы и функциональный подход. Так держать!', 'https://downloader.disk.yandex.ru/preview/f38e247e6ecedf312401ca19da75cc5b76c5669323c90f81833b0ad6e21b47b8/62019056/9BOMZ_HSRZpuPVrQX_yAb__teUnSop_0Y9Hnst2z_qcQ4JdFFdEhZox8xxYIbpeOrPFyIDLka7ORTWW3JbPhXA%3D%3D?uid=0&filename=1.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (6, 'endedChapter6', 'Вы успешно освоили исключения. Так держать!', 'https://downloader.disk.yandex.ru/preview/7289989f0cc128c809f90734d835db3dd971afb36ec7b340f1e325d1fd006be3/62019056/xTJu7CXGT7uCiIbtt3ceYzXwTlH7VVkk3lAKhxuBkJMY8XDsn_aH5oSeh3IxNBIazvGR310Jhe_moKbm_qi9Tg%3D%3D?uid=0&filename=29.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (7, 'endedChapter7', 'Вы успешно освоили обобщенное программирование. Так держать!', 'https://downloader.disk.yandex.ru/preview/4256cbda5bb42dbe316f64bc92551f7553c9254bf4ea7b19935ea496ab4a2148/62019056/KGPJb1qxFJxsF7SnzitjxQZSyXmZF6PVfuR_gdFZuV-YSCnK2m34v8NcdbHamEJmza3RTb67djKVlTAQqsRpGA%3D%3D?uid=0&filename=5.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (8, 'endedChapter8', 'Вы успешно освоили collection framework. Так держать!', 'https://downloader.disk.yandex.ru/preview/097baab8e1b2522ad53becd4f72c6e78264f99f32119b7cd1dab401f36148db6/62019056/5GBu0cOcfLE2keENIi8D4JitwATz6-gISi31vq7KbZkp3no_gWJvYjiOU03E_fYSzBOImTMHYqf0FCV3eI_dAQ%3D%3D?uid=0&filename=7.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (9, 'endedChapter9', 'Вы успешно освоили потоки. Так держать!', 'https://downloader.disk.yandex.ru/preview/b05d522530155d689d574afc7bd87062d523ce9bbf050e84d9f6498f87a65a8c/62019056/-eeeHg3xVs7k2ODPyydlpk35jKvjG8MbMr9fR7vUAYeDFGoo4Dn1hQDhc5dN5MU8mu80G5GotBHpEWktxtUmAA%3D%3D?uid=0&filename=8.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (10, 'endedChapter10', 'Вы успешно освоили streams. Так держать!', 'https://downloader.disk.yandex.ru/preview/3ce6168fb06ea1aa2d5c3fcb743c69a189a81dadba72ea7c22ce9777db2ba754/62019056/2TfYJY6f628jN43cSh9uX5itwATz6-gISi31vq7KbZkGzMaxgXSHPmT9wrTyvTkdjlJlQet2APGMwhDnCbS5Dw%3D%3D?uid=0&filename=4.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (11, 'endedChapter11', 'Вы успешно освоили потоки ввода вывода. Так держать!', 'https://downloader.disk.yandex.ru/preview/232b04d0a02fe12c6e5d89ac16f3abd762b61bd232febbc99e7983dd5868ab49/62019056/jXld1CO38pmJ7fPtfdmhrk35jKvjG8MbMr9fR7vUAYe1ias-hQW4u-1bA0XQgf1kAdxijByYJtpC9XQPZDy53w%3D%3D?uid=0&filename=10.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (12, 'endedChapter12', 'Вы успешно освоили XML. Так держать!', 'https://downloader.disk.yandex.ru/preview/4c3a938d964dddced7f5052e4bd7a9bc4184a35f32d2851344ae16b08c9c113c/62019056/EXRWX8OGVtsqTsFB2_6kk035jKvjG8MbMr9fR7vUAYeWpMCpUg4bcjYlmHaYobtGPGRpyRBTcpjPL5Qy-684zg%3D%3D?uid=0&filename=13.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (13, 'endedChapter13', 'Вы успешно освоили написание сценариев. Так держать!', 'https://downloader.disk.yandex.ru/preview/f6a605efbaecb1d58804ba76c5798091fa18f7b585a27e40e2fafb9123e9e89c/62019056/5GBu0cOcfLE2keENIi8D4JitwATz6-gISi31vq7KbZkp3no_gWJvYjiOU03E_fYSzBOImTMHYqf0FCV3eI_dAQ%3D%3D?uid=0&filename=2.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (14, 'endedChapter14', 'Вы успешно освоили модули. Так держать!', 'https://downloader.disk.yandex.ru/preview/25b6608014a7e5438d3ff80fa8df33c9dbfbc62a9bf6d8cb3b50e499f7f683ed/62019056/rB6Ne-kWpv5NZPg-Bm_4geNIIH46C65VG3XbzuYX3cRP7m-kMUZg25FBJGUh5t4dkZfrxeQWenjGIvidOeI5vw%3D%3D?uid=0&filename=15.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (15, 'totalEnded25', 'Вы прошли 25 процентов. Так держать!', 'https://downloader.disk.yandex.ru/preview/a3a827b3a3bdd9107421b1ea6943438588056d91a72730ba7006a7ccc0894bc2/62019056/Ed-YzqZR1X7HGMGolS6JuONIIH46C65VG3XbzuYX3cROjT_FATBV_kBw-SCrr9tNhGIFFp9IiAhh_Tj8FaOyiw%3D%3D?uid=0&filename=14.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (16, 'totalEnded50', 'Вы прошли 50 процентов. Так держать!', 'https://downloader.disk.yandex.ru/preview/671bf4c455d470fb3ec8c37082870442cee4b722bc730699dfb53091052e8785/62019056/p-f1jM8vLofeTpLYCvmNRpkPF2pQEh9nlUH2ISQ3dNwVTLg7L7bIjWtwVdFThCtYSfr4VsiRq1Q4DTNzp6H5YQ%3D%3D?uid=0&filename=12.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (17, 'totalEnded75', 'Вы прошли 75 процентов. Так держать!', 'https://downloader.disk.yandex.ru/preview/4703ab0d6c716afbd91d664716a5e79a08f6ef2e044b8d1424c30440bd4a61de/62019056/-CXPk9wu71UydjuR3lfXlv-y--Wz5vwVgHzy7jCpOgW-zRilQgeluLFdmusunMK99S-C04TFpAHzmeHbj7mg9w%3D%3D?uid=0&filename=17jpg.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (18, 'totalEnded100', 'Вы прошли 100 процентов. Так держать!', 'https://downloader.disk.yandex.ru/preview/1d777d87785552accea7e452758e07b113c2dd65fa2d4746bc130b9d6570a7ad/62019056/rcumHm0_n-JPeB8yMpvUTuNIIH46C65VG3XbzuYX3cRkmi21HhZU2IVWtcT_gjJPoXHm1TX23xwu0772pHLRxg%3D%3D?uid=0&filename=18.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (19, 'endedWithoutException1', 'Вы завершили главу 1 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/a8e40fdaf493f8f7c58438e0857e1225cab618597a87c76b713a8fe0bd4cd4c8/62019056/LixLwL_V5s8PmyVLXc5fipkPF2pQEh9nlUH2ISQ3dNwLSQ9HMeNWKz_M17g0yUEGvaoLXxLlIGpkmBFywEzNpA%3D%3D?uid=0&filename=9.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (20, 'endedWithoutException2', 'Вы завершили главу 2 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/4a77c7a4584e26a683cbbc60f23bb07465279f47dee8140aa0c063b621933b72/62019056/Djd2VvfmLD-HfVKn6RPoFZkPF2pQEh9nlUH2ISQ3dNz8VPZfBwEe6wzcCchqNGmHiRjSdlayHuqvVYIrlTLALA%3D%3D?uid=0&filename=11.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (21, 'endedWithoutException3', 'Вы завершили главу 3 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/b1f43d01361075aa50f6361686ca296a97ea104bb6e2793a00947d54026d4066/62019056/MljMI1esh-LoOBzDQnrHIv-y--Wz5vwVgHzy7jCpOgVltvsw_a0Yt59R8JWza8Kzq7Zg751Y574OqxZjBCjH_A%3D%3D?uid=0&filename=20.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (22, 'endedWithoutException4', 'Вы завершили главу 4 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/f0d0e4f15b5cf7c90dcf75efeba0454c86a1327ebeee527383d01f0c0613d2bd/62019056/mLkMDgPwexHj-DBXQVKO_ysXuqBFA9x3JytaCkvhtXxXP70hrZwb56ciwaoAxLDkdE1nUeC0392fuvvgDnp0tA%3D%3D?uid=0&filename=24.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (23, 'endedWithoutException5', 'Вы завершили главу 5 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/0726a40437739a8a8c51ebe9d9353aae38136d9456f544817634b8892c9f0e4d/62019056/ww0pCpj2WmeyuRkdmoC-nf-y--Wz5vwVgHzy7jCpOgWwmkR4InmPcAnfy5EyFINDhFq1cu_A_HPDSibqcW0CNw%3D%3D?uid=0&filename=22.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (24, 'endedWithoutException6', 'Вы завершили главу 6 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/de88190491ee8a774c268b0ac6b2896a5b193ed41849df4ff2596876f013e07b/62019056/dLRE5FvvTruaIgqCweddg0d81RHFcz2fXEi_Ww3fsAc3tyNC1PlT9rqT8k6bZXhjQe_2kuZWnQsmx5S3bg7wiQ%3D%3D?uid=0&filename=28.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (25, 'endedWithoutException7', 'Вы завершили главу 7 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/af0d7a05d9bb8e358257347373f01f45084de3b4a9ff0fbb91c4a260c63d6e27/62019056/C0R_jK-arSwtBfJ1q4q6pkd81RHFcz2fXEi_Ww3fsAeTaMHt-OrPhyZg9Ezi7R6glpSslOuaSqaNfSZs_kYeUQ%3D%3D?uid=0&filename=31.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (26, 'endedWithoutException8', 'Вы завершили главу 8 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/5c6475b6aa4152a33d8e74ec95f3b3c4e836790b4eb22aac9cf054bf95301b79/62019056/luDh0VO2X79FyZgJ9cKczUd81RHFcz2fXEi_Ww3fsAc_SyHAZpMOpzv6l_QOctSlnHo_wiIBP37jbEnLWwGa1A%3D%3D?uid=0&filename=32.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (27, 'endedWithoutException9', 'Вы завершили главу 9 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/4426139a3c005dac40a0c3b61afe17cb0b6a8de3b93eb76c87ec60dbee6c091a/62019056/ZYSOPlEeTMTOW0KP4F3_269kMvFS1tR8KdnIFCUI-SQWoYKcJkcU65_B6anrNUw4WsRy6DEYdpjSfjHpqDHhxw%3D%3D?uid=0&filename=26.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (28, 'endedWithoutException10', 'Вы завершили главу 10 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/145391d4b1cf85d6d1f7835213a82ecc5434adb1bff9205dd744087d13f6cb6e/62019056/vvH5zGTiy6rWWNpZJY9bmK9kMvFS1tR8KdnIFCUI-SRpYyUoj8T_n65wYcW8GPpZurBUkFC7FEDoVF0XpZsEYA%3D%3D?uid=0&filename=25.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (29, 'endedWithoutException11', 'Вы завершили главу 11 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/c86bf8774bad2885caa4cefc1c1a883c7938f6e9696bca563bf1f8b75cd91ddf/62019056/LQq_76xl981R7rqq016PfNhJJZr_Q11hHnKjVdXUYVB7YxdR91ul0aoxqahHkMR0lLoVh_HSdpvI8J-81dDHdQ%3D%3D?uid=0&filename=35.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (30, 'endedWithoutException12', 'Вы завершили главу 12 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/63c5de16947200ca182791f9205d0c531378359aa0986b6fc6cb7923c2145566/62019056/MBRGPI1BNr2HRpS7mjoYYLZtuilQQEITQUsdA2fF5q0xXeRJcm1U2s9S50QGfZ0nHY0zcKQ1aFLQhlTq1ZHbzQ%3D%3D?uid=0&filename=36.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (31, 'endedWithoutException13', 'Вы завершили главу 13 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/25f8fab73f2b8a211d7aea7b918a740a61f415fc965b30ec01a54ed2d788d669/62019056/8BME475jyQOFkiVPvUpEjI5g7fL_yHCy0EmJeJtiOCgshTpX5dkjCDPLuDhG7w2lyEd147APtfWrcGaMkyW7eg%3D%3D?uid=0&filename=34.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (32, 'endedWithoutException14', 'Вы завершили главу 14 без единой ошибки. Так держать!', 'https://downloader.disk.yandex.ru/preview/a43ddb0e7920bad298478605d2f181327643172776de8d13aeb317a3919d2567/62019056/KhGIiGYKYhaHuM3_c0Z6JI5g7fL_yHCy0EmJeJtiOCh596R0OPaYuGNBOcFNs5XOp7E6WbyduJY3JoaPpZCjMA%3D%3D?uid=0&filename=37.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (33, 'specialAchevi1', 'Специальное достижение номер 1', 'https://downloader.disk.yandex.ru/preview/a909bc9a35a1a9648a7a0c18888ee6df030668968a1b13e2482cb4f869cf89a5/62019056/UgDO06xkjs_KrXLxXfqvG45g7fL_yHCy0EmJeJtiOCgXP72feO7O7yPzqY0f4_ZFel0-JL_a9JX9Nm2X0FF5nA%3D%3D?uid=0&filename=39.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (34, 'specialAchevi2', 'Специальное достижение номер 2', 'https://downloader.disk.yandex.ru/preview/2885f8fdd834e70728c0b4b238891cecaca79fbe72e19c32d7df98ba653a89e6/62019056/PKmazAL-FZuTpYVEnftlnSsXuqBFA9x3JytaCkvhtXw2ndjf2niTLAErMJVVsbfaFQCnHMwNxj_HOj4rJdUnQQ%3D%3D?uid=0&filename=40.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (35, 'specialAchevi3', 'Специальное достижение номер 3', 'https://downloader.disk.yandex.ru/preview/0e7ea8a77ca51b7cdaad49d55d62564666e52d54dd2c71b081a0266c78fd103f/62019056/MsHBWxsU-gsHfSYV_AYICa9kMvFS1tR8KdnIFCUI-SRWtMK_A0CMbX0wsfGKocMwNoQttIXXBtsMVyW1NxRWlQ%3D%3D?uid=0&filename=16.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (36, 'specialAchevi4', 'Специальное достижение номер 4', 'https://downloader.disk.yandex.ru/preview/337a9c1d4210809b9390662efd2ce8804595a6143568e0e2c538258c6dd7d861/62019056/zrUWYAgUEtqGxOp6abk8sdDqTMrP6dpyLGDdckBuhnWp5eBAEmQFad-7zwGlLT_xELlrR3xgNRA6VhJXYAgtQg%3D%3D?uid=0&filename=38.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (37, 'specialAchevi5', 'Специальное достижение номер 5', 'https://downloader.disk.yandex.ru/preview/4c3a938d964dddced7f5052e4bd7a9bc4184a35f32d2851344ae16b08c9c113c/62019056/EXRWX8OGVtsqTsFB2_6kk035jKvjG8MbMr9fR7vUAYeWpMCpUg4bcjYlmHaYobtGPGRpyRBTcpjPL5Qy-684zg%3D%3D?uid=0&filename=13.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (38, 'specialAchevi6', 'Специальное достижение номер 6', 'https://downloader.disk.yandex.ru/preview/a8e40fdaf493f8f7c58438e0857e1225cab618597a87c76b713a8fe0bd4cd4c8/62019056/LixLwL_V5s8PmyVLXc5fipkPF2pQEh9nlUH2ISQ3dNwLSQ9HMeNWKz_M17g0yUEGvaoLXxLlIGpkmBFywEzNpA%3D%3D?uid=0&filename=9.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947'),
       (39, 'specialAchevi7', 'Специальное достижение номер 7', 'https://downloader.disk.yandex.ru/preview/9692b6bb9787b1561d6708649bfe8d18f86d55b2b379994985415f185e299f16/62019056/UVwpJcsUqtSrxIJQ58XvR_-y--Wz5vwVgHzy7jCpOgUJya0qwCN2wwIlpYQ0xWxBN0fMC3jVkMQgDsoL0uuRLA%3D%3D?uid=0&filename=21.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x947');
