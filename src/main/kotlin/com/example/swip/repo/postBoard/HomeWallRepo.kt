package com.example.swip.repo.postBoard

import com.example.swip.domain.User
import com.example.swip.domain.postBoard.HomeWall
import org.springframework.data.jpa.repository.JpaRepository

interface HomeWallRepo: JpaRepository<HomeWall, Long> {
    fun findByOwner(owner: User): HomeWall
}