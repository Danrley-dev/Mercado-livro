package com.mercadoLivro.controller

import com.mercadoLivro.controller.request.PostBookRequest
import com.mercadoLivro.controller.request.PostCustomerRequest
import com.mercadoLivro.controller.request.PutCustomerRequest
import com.mercadoLivro.extension.toBookModel
import com.mercadoLivro.extension.toCustomerModel
import com.mercadoLivro.model.CustomerModel
import com.mercadoLivro.service.BookService
import com.mercadoLivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest){
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }
}