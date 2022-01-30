package com.example.swip.repo

import com.example.swip.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserDetailsRepo: JpaRepository<User, String> {
    fun findByName(name: String): MutableList<User>
}