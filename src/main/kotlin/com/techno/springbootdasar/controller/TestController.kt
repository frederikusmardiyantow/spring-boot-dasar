package com.techno.springbootdasar.controller

import com.techno.springbootdasar.dto.ReqNumberDto
import com.techno.springbootdasar.service.LogicService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/v1/api")
class TestController(val logicService : LogicService) {

    @Value("\${name.first}")
    val firstName : String = ""
    @Value("\${name.last}")
    val lastName : String = ""

    @GetMapping("/test")
    fun testGetMapping() : ResponseEntity<Any> {
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        return ResponseEntity.ok(response)
    }

    @GetMapping("/user")
    fun getName(@RequestParam("age") age : String ) : ResponseEntity<Any>{
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        response["age"] = age
        return ResponseEntity.ok(response)
    }

    @GetMapping("/user/{role}")
    fun getUser(@PathVariable("role") role : String) : ResponseEntity<Any> {
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        response["role"] = role
        return ResponseEntity.ok(response)
    }

    @PostMapping("/oddsOrEvent")
    fun getOddsOrEvent(@RequestBody request : ReqNumberDto): ResponseEntity<Any>{
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["result"] = logicService.OddOrEven(request.number)
        return ResponseEntity.ok(response)
    }

}