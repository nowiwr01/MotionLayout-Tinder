package com.nowiwr01.motionlayout_sample.extensions

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.nowiwr01.motionlayout_sample.R

fun MotionLayout.setSwipeCardsAnimation(doOnEnd: () -> Unit) {
    setTransitionListener(object : TransitionAdapter() {
        override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
            when (currentId) {
                R.id.offScreenDislike, R.id.offScreenLike -> {
                    motionLayout.progress = 0f
                    motionLayout.setTransition(R.id.start, currentId)
                    doOnEnd.invoke()
                }
            }
        }
    })
}