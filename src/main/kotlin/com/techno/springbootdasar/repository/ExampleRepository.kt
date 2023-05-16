package com.techno.springbootdasar.repository

import com.techno.springbootdasar.entity.ExampleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ExampleRepository : JpaRepository<ExampleEntity, Int> {

}