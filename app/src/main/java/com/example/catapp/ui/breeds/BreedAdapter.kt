package com.example.catapp.ui.breeds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.catapp.databinding.BreedItemViewBinding
import com.example.catapp.model.CatBreed

class BreedAdapter(private var data: List<CatBreed>, private val listener: (CatBreed) -> Unit) :
    RecyclerView.Adapter<BreedAdapter.BreedViewHolder>() {


    class BreedViewHolder(private val binding: BreedItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catBreed: CatBreed) {
            binding.apply {
                with(catBreed) {
                    imageView.load(this.image?.url)
                    textView.text = this.id
                    textView2.text = this.name
                    textView3.text = this.description
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val binding =
            BreedItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BreedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            listener.invoke(data[position])
        }
    }

    override fun getItemCount() = data.size

    fun updateData(newData: List<CatBreed>) {
        data = newData
        notifyDataSetChanged()
    }

}