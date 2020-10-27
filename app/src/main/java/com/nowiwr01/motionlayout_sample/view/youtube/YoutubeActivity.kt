package com.nowiwr01.motionlayout_sample.view.youtube

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.nowiwr01.motionlayout_sample.MotionActivity
import com.nowiwr01.motionlayout_sample.R
import com.nowiwr01.motionlayout_sample.view.youtube.data.FrontPhotosAdapter
import com.nowiwr01.motionlayout_sample.view.youtube.data.Item
import com.nowiwr01.motionlayout_sample.view.youtube.data.YouTubeAdapter
import kotlinx.android.synthetic.main.activity_youtube_end.*
import kotlinx.android.synthetic.main.activity_youtube_start.*
import kotlinx.android.synthetic.main.activity_youtube_start.recyclerview_front
import kotlinx.android.synthetic.main.activity_youtube_start.smallImage
import kotlinx.android.synthetic.main.activity_youtube_start.smallTitle

class YoutubeActivity: MotionActivity() {

    override val layoutResId = R.layout.activity_youtube_start

    private var title = ""
    private var image = 0

    private val sampleGridData = listOf(
        Item("Пухляшный TheDRZJ", R.drawable.thedrzj1),
        Item("Чёткий TheDRZJ", R.drawable.thedrzj2),
        Item("Динозавр TheDRZJ", R.drawable.thedrzj3),
        Item("Голенький TheDRZJ", R.drawable.thedrzj4),
        Item("Интересный TheDRZJ", R.drawable.thedrzj5),
        Item("Кидающий F TheDRZJ", R.drawable.thedrzj6),
        Item("Защищаюющий TheDRZJ", R.drawable.thedrzj7),
        Item("Объёбанный TheDRZJ", R.drawable.thedrzj8),
        Item("Интеллектульный TheDRZJ", R.drawable.thedrzj9),
        Item("Пухляшный Qwerty", R.drawable.thedrzj1)
    )

    override fun setViews() {
        mainRecycler.apply {
            adapter = YouTubeAdapter(sampleGridData) {
                title = it.title
                smallTitle.text = it.title
                smallImage.setImageResource(it.image)
            }
            layoutManager = LinearLayoutManager(this@YoutubeActivity)
        }
        recyclerview_front.apply {
            adapter = FrontPhotosAdapter(sampleGridData)
            layoutManager = LinearLayoutManager(this@YoutubeActivity)
        }
    }

    override fun whenTransitionStarted(motionLayout: MotionLayout?, startID: Int, endID: Int) {
        smallTitle.text = title
    }
}