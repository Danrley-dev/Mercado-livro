package com.mercadoLivro.repository

import com.mercadoLivro.enums.BookStatus
import com.mercadoLivro.model.BookModel
import com.mercadoLivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>

}