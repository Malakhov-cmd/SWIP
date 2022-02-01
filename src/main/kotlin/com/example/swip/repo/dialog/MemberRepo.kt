package com.example.swip.repo.dialog

import com.example.swip.domain.dialog.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepo: JpaRepository<Member, Long> {
    fun getByMemberId(memberId: String): Member
}