package com.example.tpeniandroid.question

class QuestionaryManager{

    var questions : ArrayList<Question> = arrayListOf()
    var score = 0
    var scoreString = "0"
    var currentQuestionIndex = 0

    init {
        // 3 Questions
        questions = arrayListOf(
            Question("Crevette Nutelle c'est bon ?", true),
            Question("Kotlin est très explicite", false),
            Question("Suis-je mauvais ?", true))
    }

    fun isFinished() : Boolean {
        return (currentQuestionIndex >= questions.size)
    }

    fun getCurrentQuestion() : Question {
        return questions.get(currentQuestionIndex)
    }
    fun checkAnwser(userAnwser :Boolean) : Boolean{

        // Ai-je bien répondu (reponse attentu = reponse user
        if (getCurrentQuestion().anwser == userAnwser){
            // Je rajoute 1 point
            score += 1
            scoreString = score.toString()

            // Passer à la question suivante
            currentQuestionIndex += 1

            // J'ai bien repondu donc return true
            return true
        }
        // Sinon  question suivante quand même
        currentQuestionIndex += 1

        // par contre retour faux
        return false
    }
}