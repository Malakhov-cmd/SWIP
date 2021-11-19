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

    var nameChapter: String? = null

    @OneToOne
    @JoinColumn(name = "lang_id")
    var language: JavaLanguage?= null

    @OneToMany
    @JoinColumn(name = "lang_theme_id")
    var listThemes: List<Theme>? = null

    var chapterProgress: Double = 0.0
    var numberChapter: Int?= null
}