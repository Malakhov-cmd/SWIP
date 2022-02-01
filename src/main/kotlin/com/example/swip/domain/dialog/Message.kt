package com.example.swip.domain.dialog

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "dialog_message")
@Data
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "dialog_message_root_id")
    var dialog: Dialog? = null

    @OneToOne()
    @JoinColumn(name = "dialog_message_member_id")
    var author: Member? = null

    var text: String = ""

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var timeSent: LocalDateTime? = null
}