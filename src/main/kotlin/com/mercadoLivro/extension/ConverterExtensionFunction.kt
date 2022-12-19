package com.mercadoLivro.extension

import com.mercadoLivro.controller.request.PostBookRequest
import com.mercadoLivro.controller.request.PostCustomerRequest
import com.mercadoLivro.controller.request.PutCustomerRequest
import com.mercadoLivro.enums.BookStatus
import com.mercadoLivro.model.BookModel
import com.mercadoLivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
        return CustomerModel(name = this.name, email = this.email)
    }

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
        return CustomerModel(id = id, name = this.name, email = this.email)
    }

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}