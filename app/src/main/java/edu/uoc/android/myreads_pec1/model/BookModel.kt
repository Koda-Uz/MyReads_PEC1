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
            "Description", "https://i.pinimg.com/564x/34/21/2f/34212ff03e2a23088069b29db4279495.jpg"
        )
        val book2 = BookItem(1, "Title2", "Author5", Date(),
            "Description2", "https://i.pinimg.com/564x/6f/b9/e9/6fb9e9e096809265089a19daaa7abf41.jpg")
        val book3 = BookItem(2, "Title6", "Author4", Date(),
            "Description3", "https://i.pinimg.com/564x/59/92/84/599284d78be7af2f165c3d46d00aa65b.jpg"
        )
        val book4 = BookItem(3, "Title5", "Author3", Date(),
            "Description4", "https://i.pinimg.com/236x/29/ea/80/29ea808fb111652135a0f87c30a5c3f2.jpg")
        val book5 = BookItem(4, "Title4", "Author2", Date(),
            "Description5", "https://i.pinimg.com/236x/47/e2/34/47e234fdafb6d4e111cd7efefb2d936e.jpg"
        )
        val book6 = BookItem(5, "Title3", "Author1", Date(),
            "Description6", "https://i.pinimg.com/564x/c5/43/9d/c5439df8dfc01c82b9f3d6353711398b.jpg")
        val book7 = BookItem(6, "Title8", "Author7", Date(),
            "Description7", "https://i.pinimg.com/564x/52/68/c0/5268c09f8091da6eb47203dd102fc67d.jpg"
        )
        val book8 = BookItem(7, "Title7", "Author8", Date(),
            "Description8", "https://i.pinimg.com/564x/3e/a8/d5/3ea8d5f726091d881dafee19807b64c0.jpg")

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