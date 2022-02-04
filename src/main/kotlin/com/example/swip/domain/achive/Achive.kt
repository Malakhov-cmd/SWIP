package com.example.swip.domain.achive

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "achive")
@Data
class Achive {
    @Id
    var id: Long? = null

    var name = ""
    var description = ""

    var imgLink = ""
}