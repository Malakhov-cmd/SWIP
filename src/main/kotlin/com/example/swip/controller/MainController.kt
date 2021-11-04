package com.example.swip.controller

import com.example.swip.domain.User
import com.example.swip.repo.UserDetailsRepo
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
                     var userDetailsRepo: UserDetailsRepo) {
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
        val userEmail = preUserEmail?.substring(0, preUserEmail.length-3)
        val userLocale = localeRegex.find(principalSTR)?.value?.substring(8)
        val preuserpic = userpicRegex.find(principalSTR)?.value
        val userpic = preuserpic?.substring(9, preuserpic.length-1)

        val user: User = userDetailsRepo.findById(userId).orElseGet( Supplier {
            val newUser = User()
            newUser.id = userId
            newUser.name = userName
            newUser.email = userEmail
            newUser.locale = userLocale
            newUser.userpic = userpic
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
}