package com.example.swip.domain

import lombok.Data
import javax.persistence.*


@Entity
@Table(name = "javaLanguageRoadThemes")
@Data
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @OneToOne
    @JoinColumn(name = "theme_id")
    var theme: Theme? = null

    var answer: String? = null
}