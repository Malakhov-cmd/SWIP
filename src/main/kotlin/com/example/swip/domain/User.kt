package com.example.swip.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonTypeInfo
import lombok.Data
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var lastVisit: LocalDateTime? = null
}