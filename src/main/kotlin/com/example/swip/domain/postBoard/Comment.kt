package com.example.swip.domain.postBoard

import com.example.swip.domain.postBoard.like.LikeComment
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "homeWallPostComment")
@Data
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "post_id")
    var post: Post? = null

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "post_comments_likes",
            joinColumns = [JoinColumn(name = "post_comments_likes_id")])
    var likes: MutableList<LikeComment> = mutableListOf()

    var author: String = ""
    var authorImg: String = ""
    var authorId: String = ""

    var text: String = ""

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var commentDate: LocalDateTime? = null
}