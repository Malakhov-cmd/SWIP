package com.example.swip.controller

import com.example.swip.domain.Chapter
import com.example.swip.domain.JavaLanguage
import com.example.swip.domain.User
import com.example.swip.repo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal
import java.time.LocalDateTime
import java.util.function.Supplier


@Controller
@RequestMapping()
class MainController(@Autowired
                     var userDetailsRepo: UserDetailsRepo,
                     @Autowired
                     var javaLanguagesRepo: JavaLanguagesRepo,
                     @Autowired
                     var chapterRepo: ChapterRepo,
                     @Autowired
                     var themeRepo: ThemeRepo,
                     @Autowired
                     var taskRepo: TaskRepo) {
    @Value("\${spring.profiles.active}")
    private val profile: String? = null

    @GetMapping("/")
    fun initialIndex(model: Model,
                     principal: Principal): String {

        val principalSTR: String = principal.toString()

        val userIdRegex = """(sub=)\d*""".toRegex()
        val nameRegex = """\s(name=)[А-Яа-яA-Za-z0-9�]*\s*[А-Яа-яA-Za-z0-9�]*""".toRegex()
        val emailRegex = """\s(email=)\S*""".toRegex()
        val localeRegex = """\s(locale=)\w*""".toRegex()
        val userpicRegex = """\s(picture=)\S*""".toRegex()

        val userId: String = userIdRegex.find(principalSTR)!!.value.substring(4)
        val userName = nameRegex.find(principalSTR)?.value?.substring(6)
        val preUserEmail = emailRegex.find(principalSTR)?.value?.substring(7)
        val userEmail = preUserEmail?.substring(0, preUserEmail.length - 3)
        val userLocale = localeRegex.find(principalSTR)?.value?.substring(8)
        val preuserpic = userpicRegex.find(principalSTR)?.value
        val userpic = preuserpic?.substring(9, preuserpic.length - 1)

        val user: User = userDetailsRepo.findById(userId).orElseGet(Supplier {
            val newUser = User()
            newUser.id = userId
            newUser.name = userName
            newUser.email = userEmail
            newUser.locale = userLocale
            newUser.userpic = userpic

            val javaLanguage = JavaLanguage()
            javaLanguage.name = "java"
            javaLanguage.progress = 0.0
            chapterInitial(javaLanguage)
            javaLanguage.owner = newUser

            userDetailsRepo.save<User>(newUser)
            javaLanguagesRepo.save(javaLanguage)

            newUser
        })
        user.lastVisit = LocalDateTime.now()
        userDetailsRepo.save<User>(user)

        val data = HashMap<Any, Any>()

        data["profile"] = user

        model.addAttribute("frontendData", data)
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index"
    }

    fun chapterInitial(lang: JavaLanguage) {
        var chapters: MutableList<Chapter>
       for(i in 1..14){
           var chapter = Chapter()
           chapter.nameChapter = "ВВведение в Java"
           chapter.numberChapter = 1
           chapter.chapterProgress = 0.0
           
        }

    }
}