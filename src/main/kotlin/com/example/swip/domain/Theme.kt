package com.example.swip.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "javaLanguageRoadThemes")
@Data
class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "chapter_id")
    var chapter: Chapter? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "javaThemeTask")
    var task: Task? = null

    var number:Int? = null

    var isFinished = false
}