package com.torque.patel.basicscience

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.gms.ads.MobileAds

class SplashActivity : AppCompatActivity() {
    private lateinit var appOpenAdManager: AppOpenAdManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize AdMob
        MobileAds.initialize(this)

        // Initialize App Open Ad Manager
        appOpenAdManager = (application as MyApplication).appOpenAdManager
        appOpenAdManager.loadAd()


        motionLayoutFunction()
    }

    private fun motionLayoutFunction() {
        val motionLayout = findViewById<MotionLayout>(R.id.splash_motion_layout)
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {

            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                showAdAndNavigate()

            }

            private fun showAdAndNavigate() {
                appOpenAdManager.showAdIfAvailable(this@SplashActivity, object : AppOpenAdManager.OnShowAdCompleteListener {
                    override fun onShowAdComplete() {
                        navigateToMainMenu()
                        //Toast.makeText(application,"Ad is showing", Toast.LENGTH_SHORT).show()

                    }
                })
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {

            }
        })
    }




    private fun navigateToMainMenu() {
        startActivity(Intent(this@SplashActivity, MainMenu::class.java))
        finish()
    }
}
