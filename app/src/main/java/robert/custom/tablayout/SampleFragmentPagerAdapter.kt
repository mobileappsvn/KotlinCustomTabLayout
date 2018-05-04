package robert.custom.tablayout;

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView


class SampleFragmentPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    private val tabTitles = arrayOf("Tab 1", "Tab 2", "Tab 3")

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position + 1)
    }

    fun getTabView(position: Int): View {

        val v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null)
        val tabName = v.findViewById<View>(R.id.tab_title) as TextView
        tabName.text = tabTitles[position]

        val tabBadge = v.findViewById<View>(R.id.tab_badge) as TextView
        tabBadge.text = (position + 1).toString()

        return v
    }

}