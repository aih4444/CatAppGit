package com.example.catapp.ui.dogs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.catapp.databinding.BreedItemViewBinding
import com.example.catapp.model.CatBreed
import com.example.catapp.model.DogBreed

class DogBreedAdapter(private var data: List<DogBreed>, private val listener: (DogBreed) -> Unit) :
    RecyclerView.Adapter<DogBreedAdapter.BreedViewHolder>() {


    class BreedViewHolder(private val binding: BreedItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dogBreed: DogBreed) {
            binding.apply {
                with(dogBreed) {
                    imageView.load(this.image?.url)
                    textView.text = this.id.toString()
                    textView2.text = this.name
                    textView3.text = this.origin
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

    fun updateData(newData: List<DogBreed>) {
        data = newData
        notifyDataSetChanged()
    }

}