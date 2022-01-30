package com.example.swip.domain.component

import com.example.swip.domain.Chapter
import com.example.swip.domain.user.User

open class Language {
    open var name: String = ""
    open var owner: User? = null
    open var chapters: List<Chapter>? = null
    open var progress: Double = 0.0
}