package com.example.swip.repo

import com.example.swip.domain.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepo: JpaRepository<Task, Long> {
}