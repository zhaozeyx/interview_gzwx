package com.demon.guangzhiweixin

import kotlinx.coroutines.*

/**
 * <p>
 * 基于协程的Timer
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
class CoroutineTimerActivity : BaseTimerActivity() {

    private lateinit var job: Job

    override fun startTimer() {
        // 在IO线程启动协程
        job = GlobalScope.launch(Dispatchers.IO) {
            while (true) {
                // 延迟一秒后在主线程切换背景
                GlobalScope.launch(Dispatchers.Main) {
                    updateUI()
                }
                delay(1000L)
            }
        }
    }

    override fun destroyTimer() {
        job.cancel()
    }
}