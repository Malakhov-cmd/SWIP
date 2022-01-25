package com.example.swip.repo.postBoard.like

import com.example.swip.domain.postBoard.like.LikePost
import org.springframework.data.jpa.repository.JpaRepository

interface LikePostRepo: JpaRepository<LikePost, Long> {
}