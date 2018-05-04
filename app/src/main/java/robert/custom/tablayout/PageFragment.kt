package robert.custom.tablayout;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Created by robert on 4/17/18.
 */
// In this case, the fragment displays simple text based on the page
class PageFragment : Fragment() {

    private var mPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPage = arguments.getInt(ARG_PAGE)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_page, container, false)
        val textView = view as TextView
        textView.text = "Fragment " + mPage
        return view
    }

    companion object {
        val ARG_PAGE = "ARG_FRAG_PAGE"

        fun newInstance(page: Int): PageFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = PageFragment()
            fragment.arguments = args

            return fragment
        }
    }
}