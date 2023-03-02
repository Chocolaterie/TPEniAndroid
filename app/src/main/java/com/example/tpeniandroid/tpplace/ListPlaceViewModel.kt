package com.example.tpeniandroid.tpplace

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ListPlaceViewModel (application: Application) : AndroidViewModel(application) {

    var places = MutableLiveData<List<Place>>()

    fun mock() {
        val placesMock = listOf(Place("Warehouse", "Attention derriere toi"), Place("CO2", "Attention devant toi"), Place("Kebab du coin", "La maladie"));
        places.value = placesMock
    }
}