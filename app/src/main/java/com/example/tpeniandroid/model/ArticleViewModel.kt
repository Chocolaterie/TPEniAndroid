package com.example.tpeniandroid.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticleViewModel : ViewModel() {

    var title = MutableLiveData<String>()
    var price = MutableLiveData<Int>()

    fun update(_title : String, _price : Int){
        title.value = _title
        price.value = _price
    }
}