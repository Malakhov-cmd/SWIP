package com.example.swip.service.dataChange

import com.example.swip.domain.user.User
import com.example.swip.repo.UserDetailsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataChangeSelfDescriptionService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo
) {
    fun changeDescription(userId: String, newDescription: String) : User{
        val user = userDetailsRepo.findById(userId).get()

        user.selfDescription = newDescription
        return userDetailsRepo.save(user)
    }
}