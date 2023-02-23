package com.example.tpeniandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tpeniandroid.databinding.FragmentFirstBinding
import com.example.tpeniandroid.model.Matiere
import com.example.tpeniandroid.question.QuestionaryManager
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    var questionaryManager = QuestionaryManager()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    fun checkAnwser(userAnwser: Boolean) {
        // Check anwser du manager
        questionaryManager.checkAnwser(userAnwser)

        // Si c'est terminé
        if (questionaryManager.isFinished()) {
            // cacher le formulaire
            binding.llQuestionary.visibility = View.INVISIBLE
            // Afficher le resultat
            binding.tvQuestionResultat.text =
                "Terrminé vous avez " + questionaryManager.score + " / " + questionaryManager.questions.size
        }
        // c'est encore en cours
        else {
            // Met a jour la question
            binding.currentQuestion = questionaryManager.getCurrentQuestion()
            binding.questionaryManager = questionaryManager
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Quand je clique sur Vrai
        binding.btnAnwserTrue.setOnClickListener {
            checkAnwser(true)
        }

        // Quand je clique Faux
        binding.btnAnwserFalse.setOnClickListener {
            checkAnwser(false)
        }

        // Par défaut afficher la réponse
        binding.questionaryManager = questionaryManager
        binding.currentQuestion = questionaryManager.getCurrentQuestion()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}