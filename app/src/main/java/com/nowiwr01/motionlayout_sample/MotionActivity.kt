package com.nowiwr01.motionlayout_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

abstract class MotionActivity: AppCompatActivity(), MotionLayout.TransitionListener {

    abstract val layoutResId: Int

    protected open fun setViews() {}
    protected open fun setActions() {}

    protected open fun whenTransitionCompleted(p0: MotionLayout?, p1: Int) {}
    protected open fun whenTransitionStarted(motionLayout: MotionLayout?, startID: Int, endID: Int) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        setViews()
        setActions()
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
        whenTransitionStarted(p0, p1, p2)
    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        whenTransitionCompleted(p0, p1)
    }
}