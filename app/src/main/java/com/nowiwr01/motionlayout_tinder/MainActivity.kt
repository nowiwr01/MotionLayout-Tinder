package com.nowiwr01.motionlayout_tinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getPersonList().observe(this) {
            bindCard(it)
        }

        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenDislike, R.id.offScreenLike -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, currentId)
                        viewModel.swipe()
                    }
                }
            }
        })

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