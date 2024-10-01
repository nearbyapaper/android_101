package com.example.neardroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.model.Music

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomNavFavouriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomNavFavouriteFragment : Fragment() {
    private var rcView: RecyclerView ?= null
    private val activity by lazy { requireActivity() as TestMaterialDesignActivity }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_nav_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcView = view.findViewById(R.id.favouriteRCView)
        var favList: List<Music> = listOf(
            Music(
                "HYUKOH",
                "Wi Ing Wi Ing",
                "20"
            ),
            Music(
                "HYUKOH",
                "TOMBOY",
                "23"
            ),
            Music(
                "eaJ",
                "Car Crash",
                "-"
            )
        )

        rcView?.layoutManager = LinearLayoutManager(activity)
        rcView?.adapter = MusicListAdapter(favList,activity)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BottomNavFavouriteFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}