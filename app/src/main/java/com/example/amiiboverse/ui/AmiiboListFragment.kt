package com.example.amiiboverse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.amiiboverse.R
import com.example.amiiboverse.adapter.AmiiboAdapter
import com.example.amiiboverse.adapter.AmiiboListener
import com.example.amiiboverse.databinding.FragmentAmiiboListBinding
import com.example.amiiboverse.model.AmiiboViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [AmiiboListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AmiiboListFragment : Fragment() {

    private val viewModel: AmiiboViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAmiiboListBinding.inflate(inflater)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this
        binding.recyclerView.adapter = AmiiboAdapter(AmiiboListener { amiibo ->
            viewModel.onAmiiboClicked(amiibo)
            findNavController()
                .navigate(R.id.amiiboListFragment_to_amiiboDetailsFragment)
        })

        //binding.recyclerView.adapter = AmiiboAdapter()
        // Inflate the layout for this fragment
        return binding.root
    }

}