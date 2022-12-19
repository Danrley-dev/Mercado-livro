package com.mercadoLivro.repository

import com.mercadoLivro.model.BookModel
import com.mercadoLivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

}