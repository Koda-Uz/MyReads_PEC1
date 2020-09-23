package edu.uoc.android.myreads_pec1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.myreads_pec1.BookDetailActivity
import edu.uoc.android.myreads_pec1.BookDetailFragment
import edu.uoc.android.myreads_pec1.R
import kotlinx.android.synthetic.main.view_holder.view.*

/**
 * This class implements a simple adapter for the RecyclerView
 * Will be improved later with more features
 * Receives an array of data, a boolean indicating if app is un two-pane mode
 * and a FragmentManager for loading the details fragment into the view if that is the case
 * @param myData: data to be displayed
 * @param twoPane: Boolean indicating app mode
 * @param fragmentManager: Fragment manager for loading details fragment
 */
class RecyclerViewAdapter(private val myData: Array<String>,
                          private val twoPane: Boolean,
                          private val fragmentManager: FragmentManager) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // OnClickListener
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            /**
             * Load [BookDetailFragment] into view
             */
            if (twoPane) {
                val fragment = BookDetailFragment()
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.book_detail_container, fragment)
                    .commit()
            }
            /**
             * Launches [BookDetailActivity]
             */
            else {
                val intent = Intent(v.context, BookDetailActivity::class.java)
                v.context.startActivity(intent)
            }
        }
    }

    /**
     * Inner class with view holder specification
     * More data will be added later
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.text
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder, parent, false) as View

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /**
         * Gets item from [myData] and displays binds it to view holder
         */
        holder.textView.text = myData[position]
        with(holder.itemView) {
            setOnClickListener(onClickListener)
        }
    }

    /**
     * Returns size of [myData]
     */
    override fun getItemCount() = myData.size
}