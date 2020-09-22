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

class RecyclerViewAdapter(private val myData: Array<String>,
                          private val twoPane: Boolean,
                          private val fragmentManager: FragmentManager) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            if (twoPane) {
                val fragment = BookDetailFragment()
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.book_detail_container, fragment)
                    .commit()
            } else {
                val intent = Intent(v.context, BookDetailActivity::class.java)
                v.context.startActivity(intent)
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.text
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder, parent, false) as View
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = myData[position]
        with(holder.itemView) {
            setOnClickListener(onClickListener)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myData.size
}