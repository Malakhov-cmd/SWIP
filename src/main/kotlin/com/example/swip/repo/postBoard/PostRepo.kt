package com.example.swip.repo.postBoard

import com.example.swip.domain.postBoard.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepo: JpaRepository<Post, Long> {
}