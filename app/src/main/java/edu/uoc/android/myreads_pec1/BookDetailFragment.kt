package edu.uoc.android.myreads_pec1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.squareup.picasso.Picasso
import edu.uoc.android.myreads_pec1.model.BookModel
import kotlinx.android.synthetic.main.fragment_book_detail.*
import kotlinx.android.synthetic.main.fragment_book_detail.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [BookListActivity]
 * in two-pane mode (on tablets) or a [BookDetailActivity]
 * on handsets.
 */
class BookDetailFragment : Fragment() {

    private var book: BookModel.BookItem? = null
    private val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.UK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Retrieves book index from arguments
         * with [ARG_ITEM_ID] key
         */
        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                /**
                 * Locates book in [BookModel.BOOK_MAP]
                 * Book id is not always equal to position in [BookModel.BOOKS]
                 */
                book = BookModel.BOOK_MAP[it.getInt(ARG_ITEM_ID)]
                activity?.findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar_layout)?.title = book?.title
            }
        }
    }

    /**
     * Creates the view with book data
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_book_detail, container, false)

        // if book != null
        book?.let {
            rootView.bookAuthor.text = it.author
            rootView.bookDate.text = formatter.format(it.publicationDate)
            rootView.bookDescription.text = it.description
            Picasso.with(context)
                .load(it.imageUrl)
                .placeholder(R.drawable.book)
                .into(rootView.bookImage)
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}