package com.techno.springbootdasar.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_example")
data class ExampleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Int? = null,
    val name : String = ""

)
