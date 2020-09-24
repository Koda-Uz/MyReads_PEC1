package edu.uoc.android.myreads_pec1.model

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Object [BookModel] Contains static array of books
 * and [BookItem] data class
 */
object BookModel {

    /**
     * Book list, can be sorted
     */
    val BOOKS: MutableList<BookItem> = ArrayList()

    /**
     * Book map, used for obtaining book data with an id
     */
    val BOOK_MAP: MutableMap<Int, BookItem> = HashMap()

    /**
     * Initializes model with mock Data
     */
    init {

        val book1 = BookItem(0, "Title1", "Author6", Date(),
            "Description", null
        )
        val book2 = BookItem(1, "Title2", "Author5", Date(),
            "Description2", null)
        val book3 = BookItem(2, "Title6", "Author4", Date(),
            "Description3", null
        )
        val book4 = BookItem(3, "Title5", "Author3", Date(),
            "Description4", null)
        val book5 = BookItem(4, "Title4", "Author2", Date(),
            "Description5", null
        )
        val book6 = BookItem(5, "Title3", "Author1", Date(),
            "Description6", null)
        val book7 = BookItem(6, "Title8", "Author7", Date(),
            "Description7", null
        )
        val book8 = BookItem(7, "Title7", "Author8", Date(),
            "Description8", null)

        addBook(book1)
        addBook(book2)
        addBook(book3)
        addBook(book4)
        addBook(book5)
        addBook(book6)
        addBook(book7)
        addBook(book8)
    }

    /**
     * Adds [bookItem] to [BOOKS] and [BOOK_MAP]
     */
    private fun addBook(bookItem: BookItem) {
        BOOKS.add(bookItem)
        BOOK_MAP[bookItem.id] = bookItem
    }

    /**
     * Data class [BookItem] defines Book properties
     */
    data class BookItem(val id: Int, val title: String, val author: String,
                        val publicationDate: Date, val description: String,
                        val imageUrl: String?) {}
}