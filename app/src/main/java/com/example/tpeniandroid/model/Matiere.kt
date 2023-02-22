package com.example.tpeniandroid.model

import kotlin.random.Random

class Matiere (val name: String) {

    var notes : ArrayList<Float> = arrayListOf()

    // Appeler lors de l'instance (comme un constructeur)
    init {
        for (i in 1..8){
            val noteRandom = (Random.nextFloat() * 20.0f)
            notes.add(noteRandom) // generer une notre entre 0 et 20
        }
    }

    fun getAverage() : Float{
        var totalNote = 0f;
        for (value in notes){
            totalNote += value
        }

        val moyenne = totalNote / notes.size // total de note / nombre de note

        return moyenne
    }

    override fun toString(): String {
        return "Moyenne de la matière " + name + " = "+ getAverage()
    }
}