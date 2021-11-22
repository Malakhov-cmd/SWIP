package com.example.swip.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*


@Entity
@Table(name = "javaLanguageRoadTask")
@Data
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "theme_id")
    var theme: Theme? = null

    var answer: String? = null
}