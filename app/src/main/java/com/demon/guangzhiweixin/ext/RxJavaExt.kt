package com.demon.guangzhiweixin.ext

import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * <p>
 * [类说明]
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}