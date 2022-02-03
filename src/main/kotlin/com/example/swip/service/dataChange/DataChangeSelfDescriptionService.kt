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
    fun changeDescription(userId: String, newDescription: String): User {
        val user = userDetailsRepo.findById(userId).get()

        user.selfDescription = newDescription
        return userDetailsRepo.save(user)
    }

    fun changeGitLink(userId: String, newGitLink: String): User {
        val user = userDetailsRepo.findById(userId).get()

        user.gitLink = newGitLink
        return userDetailsRepo.save(user)
    }

    fun changeInstaLink(userId: String, newInstaLink: String): User {
        val user = userDetailsRepo.findById(userId).get()

        user.instagramLink = newInstaLink
        return userDetailsRepo.save(user)
    }

    fun changeFaceBookLink(userId: String, newFaceBookLink: String): User {
        val user = userDetailsRepo.findById(userId).get()

        user.faceBookLink = newFaceBookLink
        return userDetailsRepo.save(user)
    }
}