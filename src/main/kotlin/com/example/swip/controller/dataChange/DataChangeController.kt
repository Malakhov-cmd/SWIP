package com.example.swip.controller.dataChange

import com.example.swip.service.api.DataChangeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data/change")
class DataChangeController(
        var dataChangeService: DataChangeService
) {
    @GetMapping("/name")
    fun changeName(
            @RequestParam(required = true) userId: String,
            @RequestParam(required = true) newName: String
    ) = dataChangeService.changeName(userId, newName)
}