package com.example.swip.repo

import com.example.swip.domain.JavaLanguage
import org.springframework.data.jpa.repository.JpaRepository

interface JavaLanguagesRepo: JpaRepository<JavaLanguage, Long> {
}