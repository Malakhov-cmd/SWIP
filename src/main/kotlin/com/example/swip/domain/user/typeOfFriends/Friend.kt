package com.example.swip.domain.user.typeOfFriends

import com.example.swip.domain.user.User
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "usrFriend")
@Data
class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "usr_id")
    var usrOwner: User? = null

    var friendId: String = ""
    var friendname: String? = null
    var frienduserpic: String? = null
    var friendemail: String? = null
    var friendlocale: String? = null
}