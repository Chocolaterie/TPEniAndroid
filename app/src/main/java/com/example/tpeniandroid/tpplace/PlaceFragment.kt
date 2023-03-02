package com.example.tpeniandroid.tpplace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentFormArticleBinding
import com.example.tpeniandroid.databinding.FragmentPlaceBinding
import com.example.tpeniandroid.model.ArticleViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PlaceFragment : Fragment() {

    private var _binding: FragmentPlaceBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlaceBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Instancier adapter
        var placeAdapter = ListPlaceAdapter()

        // View model
        var placeViewModel = ListPlaceViewModel(activity!!.application)

        // Lier l'adapter
        binding.rvPlaces.adapter = placeAdapter

        // Ecouter le view  model
        placeViewModel.places.observe(viewLifecycleOwner, Observer {
            it?.let {
                // Mettre à jour les données dans l'adapteur
                placeAdapter.submitList(it)
            }
        })

        // Alimenter depuis le mock
        placeViewModel.mock()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}