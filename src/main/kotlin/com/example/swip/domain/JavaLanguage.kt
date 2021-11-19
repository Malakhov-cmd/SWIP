package com.example.swip.domain

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "javaLanguageRoad")
@Data
class JavaLanguage : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    var name: String = "Java"
    var progress: Double = 0.0

    @OneToMany
    @JoinColumn(name = "lang_chapter_id")
    var chapters: List<Chapter>? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    var owner: User? = null
}