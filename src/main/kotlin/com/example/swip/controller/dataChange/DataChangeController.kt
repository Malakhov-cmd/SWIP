package com.example.swip.controller.dataChange

import com.example.swip.service.dataChange.DataChangeSelfDescriptionService
import com.example.swip.service.dataChange.DataChangeService
import com.example.swip.service.dataChange.DataChangerImgService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data/change")
class DataChangeController(
        @Autowired
        var dataChangeService: DataChangeService,
        @Autowired
        var dataChangerImgService: DataChangerImgService,
        @Autowired
        var dataChangeSelfDescriptionService: DataChangeSelfDescriptionService
) {
    @GetMapping("/name")
    fun changeName(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newName: String
    ) = dataChangeService.changeName(userId, newName)

    @GetMapping("/img")
    fun changeImg(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newIngLink: String
    ) = dataChangerImgService.changeImg(userId, newIngLink)

    @GetMapping("/self/description")
    fun changeSelfDescription(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newDescription: String
    ) = dataChangeSelfDescriptionService.changeDescription(userId, newDescription)

    @GetMapping("/git")
    fun changeGit(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newGitLink: String
    ) = dataChangeSelfDescriptionService.changeGitLink(userId, newGitLink)

    @GetMapping("/insta")
    fun changeInsta(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newInstaLink: String
    ) = dataChangeSelfDescriptionService.changeInstaLink(userId, newInstaLink)

    @GetMapping("/facebook")
    fun changeFacebook(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newFaceBookLink: String
    ) = dataChangeSelfDescriptionService.changeFaceBookLink(userId, newFaceBookLink)
}