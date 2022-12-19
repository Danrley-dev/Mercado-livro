package com.mercadoLivro.controller

import com.mercadoLivro.controller.request.PostCustomerRequest
import com.mercadoLivro.controller.request.PutCustomerRequest
import com.mercadoLivro.extension.toCustomerModel
import com.mercadoLivro.model.CustomerModel
import com.mercadoLivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name:String?): List<CustomerModel>{
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomerId(@PathVariable id: Int): CustomerModel {
        return customerService.getById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){
        customerService.create(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        customerService.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}