package com.mercadoLivro.repository

import com.mercadoLivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>
}