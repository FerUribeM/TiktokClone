package com.ferbajoo.tiktokclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HorizontalViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var parentId: String? = null

    fun setParentID(parentID: String) {
        this.parentId = parentID
    }

    override fun getItem(position: Int): Fragment {
        return ChildFragment.newInstance(parentId?: "", position.toString())
    }

    override fun getCount() = 2

}
