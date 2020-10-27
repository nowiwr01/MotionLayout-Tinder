package com.nowiwr01.motionlayout_sample.view.tinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.nowiwr01.motionlayout_sample.R
import com.nowiwr01.motionlayout_sample.extensions.setSwipeCardsAnimation
import kotlinx.android.synthetic.main.activity_tinder.*

class TinderActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tinder)

        val viewModel = ViewModelProviders.of(this).get(TinderViewModel::class.java)

        viewModel.getPersonList().observe(this) {
            bindCard(it)
        }

        motionLayout.setSwipeCardsAnimation {
            viewModel.swipe()
        }

        likeB.setOnClickListener {
            motionLayout.transitionToState(R.id.likeB)
        }
        dislike.setOnClickListener {
            motionLayout.transitionToState(R.id.dislike)
        }
    }

    private fun bindCard(cards: TinderCard) {
        photo.setImageResource(cards.topCard.photo)
        description.text = cards.topCard.info
        name.text = String.format("%s, %s", cards.topCard.name, cards.topCard.age)

        photo2.setImageResource(cards.bottomCard.photo)
        description2.text = cards.bottomCard.info
        name2.text = String.format("%s, %s", cards.bottomCard.name, cards.bottomCard.age)
    }
}