package com.example.swip.domain.postBoard.like

import com.example.swip.domain.postBoard.Comment
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "homeWallPostLikes")
@Data
class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "comment_id")
    var comment: Comment? = null

    var liker: String = ""
}