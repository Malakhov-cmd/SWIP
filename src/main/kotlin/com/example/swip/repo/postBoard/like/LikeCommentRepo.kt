package com.example.swip.repo.postBoard.like

import com.example.swip.domain.postBoard.like.LikeComment
import org.springframework.data.jpa.repository.JpaRepository

interface LikeCommentRepo: JpaRepository<LikeComment, Long> {
}