package com.demon.guangzhiweixin

import kotlinx.android.synthetic.main.activity_base_timer.*


/**
 * <p>
 * 通过View.post()方法通知主线程刷新的Timer
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
class ThreadViewPostTimerActivity : BaseTimerActivity() {

    private var mIsRunning = false

    private val countDownRunnable = Runnable {
        while (mIsRunning) {
            content_layout.post {
                updateUI()
            }
            Thread.sleep(TIMER_INTERVAL)
        }
    }

    override fun startTimer() {
        val thread = Thread(countDownRunnable)
        mIsRunning = true
        thread.start()
    }

    override fun destroyTimer() {
        mIsRunning = false
    }
}