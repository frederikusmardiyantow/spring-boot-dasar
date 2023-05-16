package com.techno.springbootdasar.service

import com.techno.springbootdasar.dto.CrudDto

interface CrudService {
    fun exampleSave(name: String)
    fun exampleGetById(id: Int): CrudDto
    fun exampleGetAll(): List<CrudDto>
    fun exampleUpdate(id: Int, name: String)
    fun exampleDelete(id: Int)
}
