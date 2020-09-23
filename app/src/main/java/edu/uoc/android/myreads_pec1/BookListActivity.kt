package edu.uoc.android.myreads_pec1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.myreads_pec1.adapter.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.book_list.*

/**
 * An activity representing a list of Books. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [BookDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class BookListActivity : AppCompatActivity() {

    /**
     * This value indicates whether or not the activity is in two-pane mode,
     */
    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        setSupportActionBar(toolbar)

        toolbar.title = title

        if (book_detail_container != null) {
            /**
             * The detail container will appear only in two-pane mode,
             * in tablet-size devices
             * If this view is present then the activity should be in two pane mode.
             */
            twoPane = true
        }

        setupRecyclerView(book_list)
    }

    /**
     * Sets up RecyclerView data
     * Currently using mock values
     */
    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = RecyclerViewAdapter(createMockData(),
            twoPane, supportFragmentManager)

    }

    /**
     * Creates a simple array of mock data
     * Will be replaced later
     */
    private fun createMockData() : Array<String> {
        val count = 25
        val data = Array(count) { "it = $it" }
        for (i in 0 until count) {
            data[i] = "Book $i"
        }
        return data
    }

}