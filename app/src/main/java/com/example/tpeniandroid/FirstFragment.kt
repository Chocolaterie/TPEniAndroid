package com.example.tpeniandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentFirstBinding
import com.example.tpeniandroid.model.Matiere
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Executer tp 1
        tp1()
    }

    fun tp1() {
        // ----
        var matiereMath  = Matiere("Math")
        var matiereFrench = Matiere("French")
        var matiereSport = Matiere("Sport")
        var matiereInfo = Matiere("Info")
        var matiereStory = Matiere("Story")

        val matieres = arrayListOf(matiereMath, matiereFrench, matiereSport, matiereInfo, matiereStory)
        var totalAverageMatiere = 0.0f

        // Pour chaque matiere ajouter leur moyenne dans le total
        for (matiere in matieres){
            // Afficher la moyenne de la matiere
            println(matiere)
            // Ajouter dans le total des moyennes
            totalAverageMatiere += matiere.getAverage();
        }

        // Moyenne = Toutes les moyennes / nombre de matière
        val generalAverage = totalAverageMatiere / matieres.size

        println("Moyenne generale : " + generalAverage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}