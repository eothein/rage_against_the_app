package be.equality.dualpane

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.equality.dualpane.domain.Comic
import kotlinx.android.synthetic.main.activity_ragecomic_detail.*
import kotlinx.android.synthetic.main.ragecomic_detail.view.*

/**
 * A fragment representing a single Rage comic detail screen.
 * This fragment is either contained in a [RagecomicListActivity]
 * in two-pane mode (on tablets) or a [RagecomicDetailActivity]
 * on handsets.
 */
class RagecomicDetailFragment : Fragment() {

    /**
     * The comic this fragment is representing
     */
    private lateinit var comic: Comic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_COMIC)) {
                // Load the comic specified by the fragment
                // arguments.
                comic = it.getSerializable(ARG_COMIC) as Comic
                activity?.toolbar_layout?.title = comic.name
            }
        }
    }

    /**
     * Creating the view for this fragment.
     * The Let calls the specified function block with this value as its argument
     * and returns its result.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.ragecomic_detail, container, false)

        // Show the comic content
        comic?.let {
            rootView.name.text = it.name
            rootView.description.text = it.description
            rootView.comic_image.setImageResource(it.imageResId)
        }
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_COMIC = "item_id"

        fun newInstance(comic: Comic): RagecomicDetailFragment {
            val args = Bundle()
            args.putSerializable(ARG_COMIC, comic)
            val fragment = RagecomicDetailFragment()
            fragment.arguments = args

            return fragment
        }
    }
}
