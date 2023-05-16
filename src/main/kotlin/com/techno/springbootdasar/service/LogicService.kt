package com.techno.springbootdasar.service

import org.springframework.stereotype.Service

@Service
class LogicService {

    fun OddOrEven(number: Int) : String{
        if (number % 2 == 0){
            return "Event"
        }else{
            return "Odd"
        }
    }
}