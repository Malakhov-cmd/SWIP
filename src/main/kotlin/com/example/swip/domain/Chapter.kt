package com.example.swip.domain

import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "javaLanguageRoadChapter")
@Data
class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @OneToOne()
    @JoinColumn(name = "lang_id")
    var language: JavaLanguage? = null

    @OneToMany()
    @JoinColumn(name = "lang_theme_id")
    var listThemes: MutableList<Theme>? = null

    var chapterProgress: Double = 0.0
    var numberChapter: Int?= null
}