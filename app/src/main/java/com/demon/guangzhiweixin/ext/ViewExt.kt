package com.demon.guangzhiweixin.ext

import android.app.Activity
import android.content.Intent
import android.view.View


/**
 * 扩展函数  view 跳转Activity
 */
fun View.startActivity(clazz: Class<out Activity>) {
    context.startActivity(Intent(context, clazz))
}