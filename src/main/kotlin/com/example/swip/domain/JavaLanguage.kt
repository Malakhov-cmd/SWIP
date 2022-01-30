package com.example.swip.domain

import com.example.swip.domain.user.User
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

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "java_language_chapters",
            joinColumns = [JoinColumn(name = "java_language_chapters_id")])
    var chapters: MutableList<Chapter> =  mutableListOf()

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    var owner: User? = null
}