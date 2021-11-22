package com.example.swip.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "javaLanguageRoadChapter")
@Data
class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "lang_id")
    var language: JavaLanguage? = null

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "java_chapter_themes_list",
            joinColumns = [JoinColumn(name = "java_chapter_themes_list_id")])
    var listThemes: MutableList<Theme> = mutableListOf()

    var chapterProgress: Double = 0.0
    var numberChapter: Int?= null
}