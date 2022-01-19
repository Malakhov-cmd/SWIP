package com.example.swip.controller

import com.example.swip.repo.JavaLanguagesRepo
import com.example.swip.service.userCreation.UserCreation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal


@Controller
@RequestMapping()
class MainController(
        @Autowired
        var userCreation: UserCreation,
        @Autowired
        var javaLanguagesRepo: JavaLanguagesRepo,
) {
    @Value("\${spring.profiles.active}")
    private val profile: String? = null

    @GetMapping("/")
    fun initialIndex(model: Model,
                     principal: Principal): String {
        val user = userCreation.createUser(principal)

        val data = HashMap<Any, Any>()

        data["profile"] = user
        data["language"] = javaLanguagesRepo.findByOwner(user)

        model.addAttribute("frontendData", data)
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index"
    }
}