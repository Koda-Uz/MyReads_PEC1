package edu.uoc.android.myreads_pec1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import kotlinx.android.synthetic.main.activity_book_detail.*

/**
 * This activity represents a single Book detail screen.
 * Only used in phone-size devices. On tablets, book details
 * are represented side-by-side with the corresponding recyclerView
 * in a [BookListActivity]
 */

// Uses Kotlin Android extensions in order to avoid findViewById

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        setSupportActionBar(toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // book id
        val bookId = intent.getIntExtra(BookDetailFragment.ARG_ITEM_ID, 0)


        /**
         * savedInstanceState is non-null when there is fragment state
         * saved from previous configurations of this activity
         * If savedInstanceState is null we must manually add the [BookDetailFragment]
         */
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = BookDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(BookDetailFragment.ARG_ITEM_ID, bookId)
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.book_detail_container, fragment)
                .commit()
        }
    }

    // Sets the Up button
    // NavUtils to allow users to navigate up one level in the application structure.
    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {

                NavUtils.navigateUpTo(this, Intent(this, BookListActivity::class.java))

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}