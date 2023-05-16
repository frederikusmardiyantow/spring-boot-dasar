package com.techno.springbootdasar.controller

import com.techno.springbootdasar.dto.BaseResponseDto
import com.techno.springbootdasar.dto.CrudDto
import com.techno.springbootdasar.service.CrudService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/crud")
class CrudController(
    val crudService: CrudService
) {
    @PostMapping
    fun createNewUser(@RequestBody request : CrudDto) : ResponseEntity<BaseResponseDto<Any>>{
        crudService.exampleSave(request.name)
        return ResponseEntity.ok(
            BaseResponseDto(
                status = "T",
                message = "Success Save New Data.."
            )
        )
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id : Int) : ResponseEntity<BaseResponseDto<Any>>{
        val result = crudService.exampleGetById(id)
        return ResponseEntity.ok(
            BaseResponseDto(
                status = "T",
                message = "Success Get Data",
                result = result
            )
        )
    }

    @GetMapping
    fun getAll() : ResponseEntity<BaseResponseDto<List<CrudDto>>>{
        val result = crudService.exampleGetAll()
        return ResponseEntity.ok(
            BaseResponseDto(
                status = "T",
                message = "Success Get Data",
                result = result
            )
        )
    }

    @PutMapping
    fun updateData(@RequestParam("id") id: Int, @RequestBody crudDto: CrudDto) : ResponseEntity<BaseResponseDto<Any>>{
        crudService.exampleUpdate(id, crudDto.name)
        return ResponseEntity.ok(
            BaseResponseDto(
                status = "T",
                message = "Success Update Date"
            )
        )
    }

    @DeleteMapping
    fun deleteData(@RequestParam("id") id: Int) : ResponseEntity<BaseResponseDto<Any>>{
        crudService.exampleDelete(id)
        return ResponseEntity.ok(
            BaseResponseDto(
                status = "T",
                message = "Success Delete Data"
            )
        )
    }
}