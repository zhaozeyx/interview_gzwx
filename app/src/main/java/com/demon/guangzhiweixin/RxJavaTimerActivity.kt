package com.demon.guangzhiweixin

import com.demon.guangzhiweixin.ext.add
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * <p>
 * RxJava版本的Timer
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
class RxJavaTimerActivity : BaseTimerActivity() {
    private val compositeDisposable = CompositeDisposable()
    override fun startTimer() {
        // 启动一个子线程的计时器
        Flowable.interval(TIMER_INTERVAL, TimeUnit.MILLISECONDS, Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                // 在注册的时候更新UI
                updateUI()
            }
            .subscribe {
                // 更新UI
                updateUI()
            }.add(compositeDisposable)
    }

    override fun destroyTimer() {
        compositeDisposable.clear()
    }
}