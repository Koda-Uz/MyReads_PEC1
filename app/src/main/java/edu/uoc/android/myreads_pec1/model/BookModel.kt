package edu.uoc.android.myreads_pec1.model

import java.util.*
import kotlin.collections.ArrayList

/**
 * Object [BookModel] Contains static array of books
 * and [BookItem] data class
 */
object BookModel {

    val ITEMS: MutableList<BookItem> = ArrayList()

    /**
     * Initializes model with mock Data
     */
    init {
        val firstBook = BookItem(0, "Title1", "Author1", Date(),
            "Description", null
        )
        val secondBook = BookItem(1, "Title2", "Author2", Date(),
            "Description2", null)

        ITEMS.add(firstBook)
        ITEMS.add(secondBook)
    }

    /**
     * Data class [BookItem] defines Book properties
     */
    data class BookItem(val id: Int, val title: String, val author: String,
                        val publicationDate: Date, val description: String,
                        val imageUrl: String?) {}
}