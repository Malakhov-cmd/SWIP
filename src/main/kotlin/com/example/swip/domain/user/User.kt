package com.example.swip.domain.user

import com.example.swip.domain.user.typeOfFriends.Friend
import com.fasterxml.jackson.annotation.JsonFormat
import lombok.Data
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "usr")
@Data
class User : Serializable {
    @Id
    var id: String = ""
    var name: String? = null
    var userpic: String? = null
    var email: String? = null
    var locale: String? = null

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "usr_friend_list",
            joinColumns = [JoinColumn(name = "usr_friend_list_id")])
    var friendList = mutableListOf<Friend>()

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "usr_income_friend_list",
            joinColumns = [JoinColumn(name = "usr_income_friend_list_id")])
    var friendIncomingRequestList = mutableListOf<Friend>()

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "usr_outgo_friend_list",
            joinColumns = [JoinColumn(name = "usr_outgo_friend_list_id")])
    var friendOutgoingRequestList = mutableListOf<Friend>()

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var lastVisit: LocalDateTime? = null
}