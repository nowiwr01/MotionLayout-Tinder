package com.nowiwr01.motionlayout_sample.view.tinder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nowiwr01.motionlayout_sample.R

class TinderViewModel: ViewModel() {

    private val personList = MutableLiveData<TinderCard>()
    fun getPersonList() = personList

    private val data = listOf(
        Person(
            name = "Melanie Cross",
            age = 17,
            info = "Girl with your favorite name",
            photo = R.drawable.girl1
        ),
        Person(
            name = "Darina Temnova",
            age = 21,
            info = "Love to dance and send you nudes",
            photo = R.drawable.girl2
        )
    )

    private var currentIndex = 0

    private val topCard
        get() = data[currentIndex % data.size]
    private val bottomCard
        get() = data[(currentIndex + 1) % data.size]

    init {
        updateCards()
    }

    fun swipe() {
        currentIndex += 1
        updateCards()
    }

    private fun updateCards() {
        personList.value = TinderCard(topCard, bottomCard)
    }
}