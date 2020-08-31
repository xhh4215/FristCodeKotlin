package com.example.thefristcode.jetpackproject.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_intents.*

/***
 * 每个Activity的生命周期状态
 *  1 运行态
 *  2 暂停态  不处于栈顶，但仍然可见
 *  3 停止态  不处于栈顶，并且完全不可见
 *  4 销毁态  从返回栈中移除
 *
 *  启动一个Activity  onCreate()  -> onStart()  -> onResume() -> onPause()  ->onStop()  -> onDestory()
 *                                                               | 另一个Activity来到前台可见
 *                                                              另一个Actiivty的onResume()  .......
 *                                                               | 另一个Activity来到前台不可见
 *                                                              onRestart() -> onStart()->onResume() .....
 *
 */
class IntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)
        IntentBtn.setOnClickListener {
            //显示使用Intent
//            Intent(this, MenuActivity::class.java).apply {
//                startActivity(this)
//            }
            // 隐式使用intent
            Intent("com.example.intent.menuactivity").apply {
                this.putExtra("name", "栾桂明")
                this.putExtra("age", "26")
                startActivity(this)
            }
        }

    }
}