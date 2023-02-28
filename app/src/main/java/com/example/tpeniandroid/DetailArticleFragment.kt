package com.example.tpeniandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentDetailArticleBinding
import com.example.tpeniandroid.databinding.FragmentFormArticleBinding
import com.example.tpeniandroid.model.ArticleViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DetailArticleFragment : Fragment() {

    private var _binding: FragmentDetailArticleBinding? = null
    private lateinit var articleViewModel : ArticleViewModel;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailArticleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //articleViewModel.update("Test", 25)

        // Get le singleton du viewmodel
        articleViewModel = ViewModelProvider(activity!!).get(ArticleViewModel::class.java)

        // Mettre a jour au moins 1 fois
        binding.articleViewModel = articleViewModel

        // Ecouter les changements du viewmodel
        articleViewModel.title.observe(viewLifecycleOwner, Observer {
            binding.articleViewModel = articleViewModel
        })

        binding.btnBackArticleForm.setOnClickListener {
            findNavController().navigate(R.id.FormArticleFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}