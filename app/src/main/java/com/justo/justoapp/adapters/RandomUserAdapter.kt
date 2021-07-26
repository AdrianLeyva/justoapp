package com.justo.justoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justo.justoapp.R
import com.justo.justoapp.common.CircleTransform
import com.justo.justoapp.databinding.RandomUserItemBinding
import com.justo.justoapp.model.RandomUser
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.random_user_item.view.*
import kotlin.coroutines.coroutineContext

/**
 * @author adrianleyvasanchez
 * @since 7/24/21
 */
class RandomUserAdapter(
    var list: List<RandomUser>,
    val onClickListener: (RandomUserClick) -> Unit
) : RecyclerView.Adapter<RandomUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.random_user_item, parent, false)
        return RandomUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val randomUser = list[position]
        holder.let {
            Picasso.get().load(randomUser.picture.medium)
                .transform(CircleTransform()).into(it.photoImageView)
            it.nameTextView.text =
                "${randomUser.name.title} ${randomUser.name.first} ${randomUser.name.last}"
            it.genderTextView.text = randomUser.gender
            it.mapImageView.setOnClickListener {
                onClickListener(RandomUserClick.Map(randomUser.location))
            }
            it.mailImageView.setOnClickListener {
                onClickListener(RandomUserClick.Email(randomUser.email))
            }
            it.phoneImageView.setOnClickListener {
                onClickListener(RandomUserClick.Phone(randomUser.phone))
            }
        }
    }

    override fun getItemCount(): Int = list.size
}

class RandomUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RandomUserItemBinding.bind(view)

    val photoImageView = binding.root.userPhotoImageView
    val nameTextView = binding.root.nameUserTextView
    val genderTextView = binding.root.genderUserTextView
    val mapImageView = binding.root.mapImageView
    val mailImageView = binding.root.mailImageView
    val phoneImageView = binding.root.phoneImageView
}