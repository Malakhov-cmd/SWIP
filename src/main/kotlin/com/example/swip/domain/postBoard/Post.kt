package com.example.swip.domain.postBoard

import com.example.swip.domain.postBoard.like.LikePost
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "homeWallPosts")
@Data
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "wall_id")
    var wall: HomeWall? = null

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "post_comments",
            joinColumns = [JoinColumn(name = "post_comments_id")])
    var comments: MutableList<Comment> = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "post_likes",
            joinColumns = [JoinColumn(name = "post_likes_id")])
    var likes: MutableList<LikePost> = mutableListOf()

    var authorId: String = ""

    var header: String = ""
    var text: String= ""

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var postDate: LocalDateTime? = null
}