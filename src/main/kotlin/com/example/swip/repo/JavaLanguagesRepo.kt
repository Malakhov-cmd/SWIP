package com.example.swip.repo

import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface JavaLanguagesRepo : JpaRepository<JavaLanguage, Long> {
    fun findByOwner(owner: User): JavaLanguage
}