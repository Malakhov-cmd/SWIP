package com.example.swip.domain.dialog

import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "dialog")
@Data
class Dialog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "dialog_members",
            joinColumns = [JoinColumn(name = "dialog_members_id")])
    var members: MutableList<Member> = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "dialog_messages",
            joinColumns = [JoinColumn(name = "dialog_messages_id")])
    var messageList: MutableList<Message> = mutableListOf()
}