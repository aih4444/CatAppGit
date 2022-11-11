package com.example.catapp.ui.dogs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catapp.R
import com.example.catapp.databinding.FragmentBreedListBinding
import com.example.catapp.databinding.FragmentDogsListBinding
import com.example.catapp.model.CatBreed
import com.example.catapp.model.DogBreed
import com.example.catapp.util.LoadState
import org.koin.android.ext.android.inject

class DogsListFragment : Fragment() {

    companion object {
        fun newInstance() = DogsListFragment()
    }

    private val viewModel: DogsListViewModel by inject()
    private lateinit var binding: FragmentDogsListBinding
    private val adapter = DogBreedAdapter(emptyList()){}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogsListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        binding.rvBreedlist.adapter = adapter
        binding.rvBreedlist.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)

        viewModel.listOfBreeds.observe(viewLifecycleOwner){
            when (it) {
                is LoadState.Error<*> -> {}
                is LoadState.Success<*> -> {
                    adapter.updateData(it.response as List<DogBreed>)
                }
                else -> {}
            }
        }
        viewModel.updateList()
    }

}