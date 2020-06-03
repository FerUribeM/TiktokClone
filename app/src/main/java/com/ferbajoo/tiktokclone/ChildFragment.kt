package com.ferbajoo.tiktokclone

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.child_fragment_horizontal_pager.*

class ChildFragment : Fragment() {


    companion object {
        fun newInstance(parentId: String, child: String): ChildFragment {
            val fragment = ChildFragment()

            val args = Bundle()
            args.putString("parentId", parentId)
            args.putString("child", child)

            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.child_fragment_horizontal_pager, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.setLockFragment(getChild())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionMenuView.setOnClickListener {
            val popupMenu = PopupMenu(context,actionMenuView)
            popupMenu.menuInflater.inflate(R.menu.menu_child, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {

                return@setOnMenuItemClickListener true
            }
            popupMenu.show()
        }
    }


    private fun getParentId() = arguments?.getString("parentId") ?: ""
    private fun getChild() = arguments?.getString("child") ?: ""

}
