package com.example.swip.controller.dataChange

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
        var dataChangeService: DataChangeService,
        @Autowired
        var dataChangerImgService: DataChangerImgService
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
}