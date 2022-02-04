package com.example.swip.repo.achive

import com.example.swip.domain.achive.Achive
import org.springframework.data.jpa.repository.JpaRepository

interface AchiveRepo: JpaRepository<Achive, Long> {
    fun findByName(name: String): Achive
}