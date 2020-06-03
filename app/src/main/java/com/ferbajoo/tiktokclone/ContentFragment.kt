package com.ferbajoo.tiktokclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.parent_fragment_vertical_pager.*

class ContentFragment : Fragment(){

    companion object{
        fun newInstance(parent: String) : ContentFragment{
            val fragment = ContentFragment()

            val args = Bundle()
            args.putString("parent", parent)

            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.parent_fragment_vertical_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupHorizontalPager()
    }

    private fun setupHorizontalPager() {
        val adapter = HorizontalViewPagerAdapter(childFragmentManager)
        adapter.setParentID(getChildPosition())
        vp_horizontal.adapter = adapter
    }

    private fun getChildPosition() = arguments?.getString("parent", "") ?: ""

}
