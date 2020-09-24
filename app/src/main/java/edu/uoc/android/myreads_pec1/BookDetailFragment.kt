package edu.uoc.android.myreads_pec1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.CollapsingToolbarLayout
import edu.uoc.android.myreads_pec1.model.BookModel
import kotlinx.android.synthetic.main.fragment_book_detail.view.*
import java.text.SimpleDateFormat

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [BookListActivity]
 * in two-pane mode (on tablets) or a [BookDetailActivity]
 * on handsets.
 */
class BookDetailFragment : Fragment() {

    private var book: BookModel.BookItem? = null
    private val formatter = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Retrieves book index from arguments
         * with [ARG_ITEM_ID] key
         */
        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                book = BookModel.ITEMS[it.getInt(ARG_ITEM_ID)]
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
            rootView.author.text = it.author
            rootView.date.text = formatter.format(it.publicationDate)
            rootView.description.text = it.description
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