package com.demon.guangzhiweixin

import android.os.Handler


/**
 * <p>
 * 通过Handler通知主线程刷新的Timer
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
class ThreadHandlerTimerActivity : BaseTimerActivity() {

    private var mIsRunning = false
    private lateinit var mThread: Thread
    private lateinit var mHandler: Handler

    private val countDownRunnable = Runnable {
        while (mIsRunning) {
            // 通过主线程的Handler通知界面刷新
            mHandler.post {
                updateUI()
            }
            Thread.sleep(TIMER_INTERVAL)
        }
    }

    override fun startTimer() {
        // 创建主线程Handler
        mHandler = Handler(mainLooper)
        mThread = Thread(countDownRunnable)
        mIsRunning = true
        mThread.start()
    }

    override fun destroyTimer() {
        mIsRunning = false
        mHandler.removeCallbacksAndMessages(null)
    }
}