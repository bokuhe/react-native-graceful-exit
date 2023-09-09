package net.sleiv.rn.gracefulexit

import android.content.Intent
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class GracefulExitModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @DelicateCoroutinesApi
  @ReactMethod
  fun exit(promise: Promise) {
    try {
      val homeIntent = Intent(Intent.ACTION_MAIN).apply {
        addCategory(Intent.CATEGORY_HOME)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      currentActivity?.startActivity(homeIntent) ?: run {
        promise.reject("NO_CURRENT_ACTIVITY", "No current activity found")
        return
      }

      GlobalScope.launch {
        delay(1000)
        //android.os.Process.killProcess(android.os.Process.myPid())
        exitProcess(0)
      }
      promise.resolve(null)
    } catch (e: Exception) {
      promise.reject("ERROR", e.message, e)
    }
  }

  companion object {
    const val NAME = "GracefulExit"
  }
}
