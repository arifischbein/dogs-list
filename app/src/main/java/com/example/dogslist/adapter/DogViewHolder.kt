package com.example.dogslist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dogslist.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(private val binding: ItemDogBinding) : ViewHolder(binding.cardDog) {

    fun render(dogImage: String) {
        Picasso.get().load(dogImage).into(binding.imgDog)
    }
}
