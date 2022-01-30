package com.example.swip.service.userCreation

import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.user.User
import com.example.swip.domain.postBoard.HomeWall
import com.example.swip.repo.*
import com.example.swip.repo.postBoard.HomeWallRepo
import com.example.swip.service.ChapterFuller
import com.example.swip.service.userCreation.userDTO.UserData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.Principal
import java.time.LocalDateTime

@Service
class UserCreation(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var javaLanguagesRepo: JavaLanguagesRepo,
        @Autowired
        var chapterRepo: ChapterRepo,
        @Autowired
        var chapterFuller: ChapterFuller,
        @Autowired
        var homeWallRepo: HomeWallRepo
) {
    private val userIdRegex = """(sub=)\d*""".toRegex()
    private val nameRegex = """\s(name=)[А-Яа-яA-Za-z0-9�]*\s*[А-Яа-яA-Za-z0-9�]*""".toRegex()
    private val emailRegex = """\s(email=)\S*""".toRegex()
    private val localeRegex = """\s(locale=)\w*""".toRegex()
    private val userpicRegex = """\s(picture=)\S*""".toRegex()

    fun createUser(principal: Principal): User {
        val userInDTFormat: UserData = parserFromPrincipal(principal)
        return createAndSaveUser(userInDTFormat)
    }

    private fun parserFromPrincipal(principal: Principal): UserData {
        val principalSTR: String = principal.toString()

        val userId: String = userIdRegex.find(principalSTR)!!.value.substring(4)

        val userName = nameRegex.find(principalSTR)?.value!!.substring(6)

        val preUserEmail = emailRegex.find(principalSTR)?.value!!.substring(7)
        val userEmail = preUserEmail?.substring(0, preUserEmail.length - 3)

        val userLocale = localeRegex.find(principalSTR)?.value!!.substring(8)

        val preuserPic = userpicRegex.find(principalSTR)?.value
        val userPic = preuserPic!!.substring(9, preuserPic.length - 1)

        return UserData(userId, userName, userEmail, userLocale, userPic)
    }

    private fun createAndSaveUser(userDTO: UserData): User {
        val user: User = userDetailsRepo.findById(userDTO.userId).orElseGet {
            val newUser = User()
            newUser.id = userDTO.userId
            newUser.name = userDTO.userName
            newUser.email = userDTO.userEmail
            newUser.locale = userDTO.userLocale
            newUser.userpic = userDTO.userPic

            val homeWall = HomeWall()
            homeWall.owner = newUser

            val javaLanguage = JavaLanguage()
            javaLanguage.name = "java"
            javaLanguage.progress = 0.0
            javaLanguage.owner = newUser

            userDetailsRepo.save<User>(newUser)

            homeWallRepo.save(homeWall)

            chapterFuller.chapterInitial(javaLanguagesRepo.save(javaLanguage).id)
            newUser
        }

        user.lastVisit = LocalDateTime.now()
        userDetailsRepo.save<User>(user)

        return user
    }
}