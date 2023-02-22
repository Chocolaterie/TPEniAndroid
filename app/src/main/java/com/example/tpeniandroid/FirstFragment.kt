package com.example.tpeniandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentFirstBinding
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

    fun calculAverage(matiere : ArrayList<Float>) : Float{
        for (i in 1..8){
            val noteRandom = (Random.nextFloat() * 20.0f)
            println(noteRandom)
            matiere.add(noteRandom) // generer une notre entre 0 et 20
        }

        // -- moyenne
        // Plusieurs manières d'itérer
        /*
        for ((index, value) in averageMath.withIndex()){
            totalNote += value
        }

        for (i in 1.. averageMath.size){
            totalNote += averageMath.get(i)
        }
        */
        var totalNote = 0f;

        for (value in matiere){
            totalNote += value
        }

        val moyenne = totalNote / matiere.size // total de note / nombre de note

        return moyenne
    }

    fun tp1(){
        // TP Moyenne
        var averageMath : ArrayList<Float> = arrayListOf()
        var averageFrench : ArrayList<Float> = arrayListOf()
        var averageSport : ArrayList<Float> = arrayListOf()
        var averageInfo : ArrayList<Float> = arrayListOf()
        var averageStory : ArrayList<Float> = arrayListOf()

        /*
        val moyenneMath = calculAverage(averageMath);
        val moyenneFrench = calculAverage(averageFrench);
        val moyenneSport = calculAverage(averageSport);
        val moyenneInfo = calculAverage(averageInfo);
        val moyenneStory = calculAverage(averageStory);

        println("Moyenne de la matière Math : " + moyenneMath)
        println("Moyenne de la matière french : " + moyenneFrench)
        println("Moyenne de la matière Sport : " + moyenneSport)
        println("Moyenne de la matière Info : " + moyenneInfo)
        println("Moyenne de la matière Story : " + moyenneStory)

        val generalAverage = (moyenneMath + moyenneFrench + moyenneSport + moyenneInfo + moyenneStory) / 5
        */
        val matieres = arrayListOf(averageMath, averageFrench, averageSport, averageInfo, averageStory)
        var totalAverageMatiere = 0.0f

        // Pour chaque matiere ajouter leur moyenne dans le total
        for (matiere in matieres){
            val moyenneMatiere = calculAverage(matiere)
            // Afficher la moyenne de la matiere
            println("Moyenne de la matière X : " +  moyenneMatiere)
            // Ajouter dans le total des moyennes
            totalAverageMatiere += moyenneMatiere;
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