package com.example.catapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.catapp.databinding.FragmentDetailsBinding
import com.example.catapp.model.CatBreed

class DetailFragment : Fragment() {

    companion object {
    }

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catBreed = arguments?.getParcelable<CatBreed>("CatBreed")

        binding.imageView.load(catBreed?.image?.url)
        binding.textView.text = catBreed?.name
        binding.textView2.text = catBreed?.description
        binding.textView3.text = catBreed?.origin
    }

}