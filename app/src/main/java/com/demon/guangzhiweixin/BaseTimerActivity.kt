package com.demon.guangzhiweixin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base_timer.*
import kotlinx.android.synthetic.main.content_base_timer.*


/**
 * 计时器Activity基类
 */
abstract class BaseTimerActivity : AppCompatActivity() {

    private var colorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_timer)
        setSupportActionBar(findViewById(R.id.toolbar))

        startTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyTimer()
    }

    /**
     * 启动计时器
     */
    abstract fun startTimer()

    /**
     * 销毁计时器
     */
    abstract fun destroyTimer()

    /**
     * 切换背景
     */
    fun updateUI() {
        content_layout.setBackgroundColor(resources.getColor(backGroundColor[colorIndex % backGroundColor.size]))
        timer_text.text = resources.getString(R.string.timer_text, colorIndex)
        colorIndex++
    }

    companion object {
        const val TIMER_INTERVAL = 1000L
        val backGroundColor = arrayOf(
            android.R.color.holo_blue_bright,
            android.R.color.holo_blue_dark,
            android.R.color.holo_green_light,
            android.R.color.holo_green_dark
        )
    }
}