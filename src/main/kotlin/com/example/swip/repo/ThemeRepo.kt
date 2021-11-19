package com.example.swip.repo

import com.example.swip.domain.Theme
import org.springframework.data.jpa.repository.JpaRepository

interface ThemeRepo : JpaRepository<Theme, Long> {
}