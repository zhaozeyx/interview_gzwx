package com.demon.guangzhiweixin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demon.guangzhiweixin.ext.startActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * <p>
 * 主页
 * </p>
 *
 * @author zhaozeyang
 * @since 2020/7/7
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        initView()
    }

    private fun initView() {

        val menuList = mutableListOf(
            MenuItem("通过RunOnUiThread更新UI", ThreadTimerActivity::class.java),
            MenuItem("通过Handler更新UI", ThreadHandlerTimerActivity::class.java),
            MenuItem("通过View.post()更新UI", ThreadViewPostTimerActivity::class.java),
            MenuItem("通过RxJava启动计时更新UI", RxJavaTimerActivity::class.java),
            MenuItem("通过协程启动计时更新UI", CoroutineTimerActivity::class.java)
        )

        menu_list.layoutManager = LinearLayoutManager(this)
        menu_list.adapter = MenuAdapter().apply {
            data.addAll(menuList)
        }

    }

    inner class MenuAdapter : RecyclerView.Adapter<MenuViewHolder>() {

        val data = mutableListOf<MenuItem>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.menu_list_item, parent, false)
            return MenuViewHolder(view)
        }

        override fun getItemCount(): Int = data.size

        override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
            data[position].apply {
                (holder.itemView as TextView).text = title
                holder.itemView.setOnClickListener {
                    it.startActivity(this.clazz)
                }
            }
        }

    }

    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view)

    inner class MenuItem(val title: String, val clazz: Class<out Activity>)
}