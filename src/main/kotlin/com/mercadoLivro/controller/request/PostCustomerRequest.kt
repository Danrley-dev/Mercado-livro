package com.mercadoLivro.controller.request

import com.mercadoLivro.model.CustomerModel

data class PostCustomerRequest (
    var name: String,
    var email: String
    )