package com.mercadoLivro.service

import com.mercadoLivro.controller.request.PostCustomerRequest
import com.mercadoLivro.controller.request.PutCustomerRequest
import com.mercadoLivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name:String?): List<CustomerModel>{
        name?.let {
            return customers.filter { it.name.contains(name, ignoreCase = true) }
        }
        return customers
    }

    fun getCustomerId(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun create(customer: PostCustomerRequest){

        val id = if (customers.isEmpty()){
            1
        }else{
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    fun update(id: String,customer: PutCustomerRequest) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.name
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}