package edu.uoc.android.myreads_pec1.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.myreads_pec1.BookDetailActivity
import edu.uoc.android.myreads_pec1.BookDetailFragment
import edu.uoc.android.myreads_pec1.R
import edu.uoc.android.myreads_pec1.model.BookModel
import kotlinx.android.synthetic.main.view_holder_odd.view.*

/**
 * This class implements a simple adapter for the RecyclerView
 * Will be improved later with more features
 * Receives an array of data, a boolean indicating if app is un two-pane mode
 * and a FragmentManager for loading the details fragment into the view if that is the case
 * @param myData: data to be displayed
 * @param twoPane: Boolean indicating app mode
 * @param fragmentManager: Fragment manager for loading details fragment
 */
class RecyclerViewAdapter(private val myData: MutableList<BookModel.BookItem>,
                          private val twoPane: Boolean,
                          private val fragmentManager: FragmentManager) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // OnClickListener
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            // Retrieves book item
            val book = v.tag as BookModel.BookItem
            /**
             * Load [BookDetailFragment] into view
             */
            if (twoPane) {
                val fragment = BookDetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(BookDetailFragment.ARG_ITEM_ID, book.id)
                    }
                }
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.book_detail_container, fragment)
                    .commit()
            }
            /**
             * Launches [BookDetailActivity]
             */
            else {
                val intent = Intent(v.context, BookDetailActivity::class.java).apply {
                    putExtra(BookDetailFragment.ARG_ITEM_ID, book.id)
                }
                v.context.startActivity(intent)
            }
        }
    }

    /**
     * Creates new views
     * Will create different views for even and odd numbers
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val view = if (viewType == ODD) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_odd, parent, false) as View
        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_even, parent, false) as View
        }

        return ViewHolder(view)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /**
         * Gets item from [myData] and displays binds it to view holder
         */
        val book = myData[position]
        holder.title.text = book.title
        holder.author.text = book.author
        holder.id = position
        with(holder.itemView) {
            tag = book
            setOnClickListener (onClickListener)
        }
    }

    /**
     * Returns 0 for even items, 1 for odd items
     */
    override fun getItemViewType(position: Int): Int {
        return  position % 2
    }

    /**
     * Returns size of [myData]
     */
    override fun getItemCount() = myData.size

    /**
     * Inner class with view holder specification
     * More data will be added later
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        var id = 0
    }

    /**
     * Companion Object with ViewType specification
     */
    companion object {
        const val EVEN = 0
        const val ODD = 1
    }
}