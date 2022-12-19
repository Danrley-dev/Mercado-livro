package com.mercadoLivro.service

import com.mercadoLivro.model.CustomerModel
import com.mercadoLivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val repository: CustomerRepository
        ) {

    fun getAll(name:String?): List<CustomerModel>{
        name?.let {
            return repository.findByNameContaining(name)
        }
        return repository.findAll().toList()
    }

    fun getById(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow()
    }

    fun create(customer: CustomerModel){
        repository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if (!repository.existsById(customer.id!!)){
            throw Exception("O Id não existe")
        }
        repository.save(customer)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)){
            throw Exception("O Id não existe")
        }
        repository.deleteById(id)
    }
}