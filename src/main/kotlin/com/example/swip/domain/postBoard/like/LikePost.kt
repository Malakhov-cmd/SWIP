package com.example.swip.domain.postBoard.like

import com.example.swip.domain.postBoard.Post
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "homeWallPostLikes")
@Data
class LikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "post_id")
    var post: Post? = null

    var liker: String = ""
}