package robert.custom.tablayout

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

/**
 * Created by Robert on 2018 May 03
 */
class CustomTabLayoutActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager_container_layout)

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = findViewById(R.id.viewPager)
        val pagerAdapter = SampleFragmentPagerAdapter(supportFragmentManager, this@CustomTabLayoutActivity)
        viewPager!!.adapter = pagerAdapter

        // Give the TabLayout the ViewPager
        tabLayout = findViewById(R.id.sliding_tabs)
        tabLayout!!.setupWithViewPager(viewPager)
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        // Iterate over all tabs and set the custom view
        for (i in 0 until tabLayout!!.tabCount) {
            val tab = tabLayout!!.getTabAt(i)
            tab!!.customView = pagerAdapter.getTabView(i)
            //tab.getCustomView().findViewById(R.id.tab_badge);
        }
    }

    public override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putInt(POSITION, tabLayout!!.selectedTabPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewPager!!.currentItem = savedInstanceState.getInt(POSITION)
    }

    companion object {

        var POSITION = "POSITION"
    }

}

