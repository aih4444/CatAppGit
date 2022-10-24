package com.example.catapp.ui.breeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavAction
import androidx.navigation.NavActionBuilder
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catapp.R
import com.example.catapp.databinding.FragmentBreedListBinding
import com.example.catapp.model.CatBreed
import com.example.catapp.util.LoadState
import org.koin.android.ext.android.inject

class BreedListFragment : Fragment() {

    companion object {
        fun newInstance() = BreedListFragment()
    }

    private val viewModel: BreedListViewModel by inject()
    private lateinit var binding: FragmentBreedListBinding
    private var adapter = BreedAdapter(emptyList()) {
       val bundle = Bundle()
        bundle.putParcelable("CatBreed", it)
        findNavController().navigate(R.id.action_breedListFragment_to_detailFragment, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBreedlist.adapter = adapter
        binding.rvBreedlist.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.listOfBreeds.observe(viewLifecycleOwner) {
            when (it) {
                is LoadState.Error<*> -> {}
                is LoadState.Success<*> -> {
                    adapter.updateData(it.response as List<CatBreed>)
                }
                else -> {}
            }
        }
        viewModel.updateList()
    }

}