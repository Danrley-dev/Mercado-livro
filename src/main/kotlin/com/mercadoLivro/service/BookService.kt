package com.mercadoLivro.service

import com.mercadoLivro.controller.request.PutBookRequest
import com.mercadoLivro.enums.BookStatus
import com.mercadoLivro.model.BookModel
import com.mercadoLivro.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll():List<BookModel> {
       return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
    return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

}
