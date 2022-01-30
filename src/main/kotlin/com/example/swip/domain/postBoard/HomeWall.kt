package com.example.swip.domain.postBoard

import com.example.swip.domain.user.User
import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "homeWall")
@Data
class HomeWall : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "posts_list",
            joinColumns = [JoinColumn(name = "posts_list_id")])
    var posts: MutableList<Post> = mutableListOf()

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    var owner: User? = null
}