package com.techno.springbootdasar.service

import com.techno.springbootdasar.dto.CrudDto
import com.techno.springbootdasar.entity.ExampleEntity
import com.techno.springbootdasar.repository.ExampleRepository
import org.springframework.stereotype.Service

@Service
class CrudServiceImpl(
    val exampleRepository: ExampleRepository
) : CrudService {
    override fun exampleSave(name: String) {
        val exampleEntity = ExampleEntity(name = name)
        exampleRepository.save(exampleEntity)
    }

    override fun exampleGetById(id: Int): CrudDto {
        val exampleEntity = exampleRepository.findById(id)
        return CrudDto(exampleEntity.get().name)
    }

    override fun exampleGetAll(): List<CrudDto> {
        val exampleEntities = exampleRepository.findAll()
        val result = mutableListOf<CrudDto>()
        for (r in exampleEntities){
            result.add(CrudDto(r.name))
        }
        return result
    }

    override fun exampleUpdate(id: Int, name: String) {
        val exampleEntity = exampleRepository.findById(id)
        val newEntity = exampleEntity.get().copy(name = name)
        exampleRepository.save(newEntity)
    }

    override fun exampleDelete(id: Int) {
        exampleRepository.deleteById(id)
    }

}