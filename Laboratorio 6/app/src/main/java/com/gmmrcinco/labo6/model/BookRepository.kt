package com.gmmrcinco.labo6.model

import kotlinx.coroutines.delay

object BookRepository {
    suspend fun getBooks(): List<Book> {
        delay(3000)
        return listOf(
            Book(1,"El Quijote", "Francisco de Robles"),
            Book(2,"Cien Años de Soledad", "Editorial Sudamericana"),
            Book(3,"La Sombra del Viento", "Planeta"),
            Book(4,"48 Leyes del poder", "Francisco de Robles"),
            Book(5,"El arte de la guerra", "Editorial Sudamericana"),
            Book(6,"Los Miserables", "Planeta")


        )
    }
}
