package com.ferbajoo.tiktokclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()

    }

    /**
     *  Si es el child 1 se bloquea la navegacion vertical
     */
    fun setLockFragment(child: String) {
        viewpager?.setEnableSwipe(child != "1")
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = viewPagerAdapter
    }


}
