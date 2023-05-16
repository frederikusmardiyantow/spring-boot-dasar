package com.techno.springbootdasar.config

import com.techno.springbootdasar.service.LogicService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

//@Component
//class ContohConfig {
//    @Bean
//    fun printName(){
//        println("Nama : Frederik")
//    }
//}

@Component
class ContohConfig(val logicService : LogicService) {
    @Bean
    fun printName(){
        println("Nama : Frederik")
    }

    @Bean
    fun OddOrEvent(){
        val result = logicService.OddOrEven(5)
        println("Number result is $result")
    }
}