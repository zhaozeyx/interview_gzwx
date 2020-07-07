package com.demon.guangzhiweixin

/**
 * <p>
 * [类说明]
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
class ThreadTimerActivity : BaseTimerActivity() {

    private var mIsRunning = false

    private lateinit var mThread: Thread

    private val countDownRunnable = Runnable {
        while (mIsRunning) {
            // 通知主线程更新UI
            runOnUiThread {
                updateUI()
            }
            Thread.sleep(TIMER_INTERVAL)
        }
    }


    override fun startTimer() {
        mThread = Thread(countDownRunnable)
        mIsRunning = true
        mThread.start()
    }

    override fun destroyTimer() {
        mIsRunning = false
    }
}