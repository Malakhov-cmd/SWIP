package com.example.swip.domain.dialog

import com.example.swip.domain.user.User
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "dialog_member")
@Data
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "usr_id")
    var usr: User? = null

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "dialog_member_id")
    var dialog: Dialog? = null

    var memberId: String = ""
    var membername: String? = null
    var memberuserpic: String? = null
    var memberemail: String? = null
    var memberlocale: String? = null
}