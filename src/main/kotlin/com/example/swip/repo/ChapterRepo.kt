package com.example.swip.repo

import com.example.swip.domain.Chapter
import org.springframework.data.jpa.repository.JpaRepository

interface ChapterRepo: JpaRepository<Chapter, Long> {
}