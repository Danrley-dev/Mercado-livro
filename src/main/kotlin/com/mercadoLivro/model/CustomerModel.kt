package com.mercadoLivro.model

import org.springframework.aop.interceptor.SimpleTraceInterceptor
import java.util.StringJoiner

data class CustomerModel(
    var id: String,
    var name: String,
    var email: String
)