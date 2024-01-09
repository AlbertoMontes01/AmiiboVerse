package com.example.amiiboverse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.amiiboverse.R
import com.example.amiiboverse.databinding.FragmentAmiiboDetailsBinding
import com.example.amiiboverse.model.AmiiboViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [AmiiboDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AmiiboDetailsFragment : Fragment() {

    private val viewModel: AmiiboViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAmiiboDetailsBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root

    }

}