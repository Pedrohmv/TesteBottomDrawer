package serveloja.com.br.testebottomdrawer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            drawer.clearAnimation()
            if (flag) {
                drawer.animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.from_bottom).apply {
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {
                            drawer.visibility = View.VISIBLE
                        }

                        override fun onAnimationEnd(animation: Animation) {

                        }

                        override fun onAnimationRepeat(animation: Animation) {}
                    })
                }
            } else {
                drawer.animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.from_top).apply {
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {}

                        override fun onAnimationEnd(animation: Animation) {
                            drawer.visibility = View.GONE
                        }

                        override fun onAnimationRepeat(animation: Animation) {}
                    })
                }
            }
            flag = !flag
        }

        profileImage.loadImageUrl("https://avatars3.githubusercontent.com/u/8125098?s=460&v=4")

        drawer.animation = AnimationUtils.loadAnimation(this, R.anim.from_bottom)
    }
}
