package com.justo.justoapp.ui.randomlist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justo.justoapp.R
import com.justo.justoapp.adapters.RandomUserAdapter
import com.justo.justoapp.adapters.RandomUserClick
import com.justo.justoapp.common.ViewState
import com.justo.justoapp.databinding.RandomListActivityBinding
import java.util.*

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
class RandomListActivity : AppCompatActivity() {

    private lateinit var binding: RandomListActivityBinding

    private lateinit var viewModel: RandomListViewModel

    private var randomUserAdapter: RandomUserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RandomListActivityBinding.inflate(layoutInflater)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(RandomListViewModel::class.java)
        setContentView(view)
        initRecyclerView()
        initObservers(this)
        viewModel.fetchRandomUsers()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        randomUserAdapter = RandomUserAdapter(ArrayList()) {
            when(it) {
                is RandomUserClick.Detailed -> {
                }
                is RandomUserClick.Map -> {
                    val mapIntentUri: Uri?
                    it.location.coordinates.let { c ->
                        mapIntentUri = Uri.parse("geo:${c.latitude},${c.longitude}")
                    }
                    val mapIntent = Intent(Intent.ACTION_VIEW, mapIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)
                }
                is RandomUserClick.Email -> {
                    val emailIntentUri: Uri = Uri.parse("mailto:${it.email}")
                    val emailIntent = Intent(Intent.ACTION_SENDTO, emailIntentUri)
                    startActivity(emailIntent)
                }
                is RandomUserClick.Phone -> {
                    val phoneIntentUri = Uri.parse("tel:${it.phone}")
                    val phoneIntent = Intent(Intent.ACTION_DIAL, phoneIntentUri)
                    startActivity(phoneIntent)
                }
            }
        }
        binding.let {
            it.recyclerView.layoutManager = layoutManager
            it.recyclerView.adapter = randomUserAdapter
        }
    }

    private fun initObservers(activity: RandomListActivity) = with(viewModel) {
        randomUserList.observe(activity) { randomUserList ->
            randomUserList?.let {
                randomUserAdapter?.let {
                    it.list = randomUserList
                    it.notifyDataSetChanged()
                }
            }
        }
        state.observe(activity) {
            when(it) {
                ViewState.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                ViewState.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                }
                ViewState.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                            activity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}