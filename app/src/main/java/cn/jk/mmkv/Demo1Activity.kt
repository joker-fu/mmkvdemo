package cn.jk.mmkv

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.IntentUtils.getLaunchAppIntent
import com.blankj.utilcode.util.SPUtils
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class Demo1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo1)

        lifecycleScope.launch {
            DataCleanUtils.cleanApplicationData(this@Demo1Activity)
            val result = MMKVUtils.saveStr("test1", "bbbbbbbbbbb")
            println("===============> 读写测试 写入：  bbbbbbbbbbb 写入结果：$result")
            delay(2000)
            getLaunchAppIntent(packageName)?.let {
                it.addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            or Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
                startActivity(it)
                killAppProcess()
            }
        }
    }

    private fun killAppProcess() {
        // 不能先杀掉主进程，否则逻辑代码无法继续执行，需先杀掉相关进程最后杀掉主进程
        val mActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val mList = mActivityManager.runningAppProcesses
        for (runningAppProcessInfo in mList) {
            if (runningAppProcessInfo.pid != Process.myPid()) {
                Process.killProcess(runningAppProcessInfo.pid)
            }
        }
        Process.killProcess(Process.myPid())
        exitProcess(0)
    }


}