package com.example.tpeniandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentFormArticleBinding
import com.example.tpeniandroid.model.ArticleViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FormArticleFragment : Fragment() {

    private var _binding: FragmentFormArticleBinding? = null
    private lateinit var articleViewModel : ArticleViewModel;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFormArticleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //
        articleViewModel = ViewModelProvider(activity!!).get(ArticleViewModel::class.java)

        // Mettre a jour au moins 1 fois
        binding.articleViewModel = articleViewModel

        //
        binding.btnSaveArticle.setOnClickListener {
            // Récupèrer les données saisies
            val title = binding.edtTitle.text.toString()
            val price = binding.edtPrice.text.toString().toInt()
            // Appliquer les modifications dans le view model
            articleViewModel.update(title, price)

            // On ouvre le fragment detail
            findNavController().navigate(R.id.DetailArticleFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}