package com.example.swip.repo.postBoard

import com.example.swip.domain.postBoard.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepo: JpaRepository<Comment, Long> {
}