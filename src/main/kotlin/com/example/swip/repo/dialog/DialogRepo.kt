package com.example.swip.repo.dialog

import com.example.swip.domain.dialog.Dialog
import org.springframework.data.jpa.repository.JpaRepository

interface DialogRepo: JpaRepository<Dialog, Long> {
}