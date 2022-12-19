package com.mercadoLivro.service

import com.mercadoLivro.model.BookModel
import com.mercadoLivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}
