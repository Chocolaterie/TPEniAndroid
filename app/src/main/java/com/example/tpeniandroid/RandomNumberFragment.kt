package com.example.tpeniandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentFirstBinding
import com.example.tpeniandroid.model.Matiere
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RandomNumberFragment : Fragment() {

    /*
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun generateNumber(view: View) {

        // Récupérer les valeurs saisies
        val min = view.findViewById<EditText>(R.id.edt_min).text.toString().toInt()
        val max = view.findViewById<EditText>(R.id.edt_max).text.toString().toInt()

        // Result  = (normalize(0-1) * (max-min)) + min
        // Example si max = 40 et min = 20
        // -- Result  = (normalize(0-1) * 40-20) + 20
        val result = (Random.nextFloat() * (max - min)) + min

        // Afficher le résultat
        view.findViewById<TextView>(R.id.tv_result).text = result.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnResult = view.findViewById<Button>(R.id.btn_generate)

        btnResult.setOnClickListener {
            generateNumber(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    */
}