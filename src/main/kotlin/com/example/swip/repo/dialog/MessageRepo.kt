package com.example.swip.repo.dialog

import com.example.swip.domain.dialog.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepo: JpaRepository<Message, Long> {
}