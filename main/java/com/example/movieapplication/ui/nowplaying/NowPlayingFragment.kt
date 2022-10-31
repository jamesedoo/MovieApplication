package com.example.movieapplication.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.Movie
import com.example.movieapplication.R
import com.example.movieapplication.ReviewAdapter
import com.example.movieapplication.databinding.FragmentNowPlayingBinding

class NowPlayingFragment : Fragment() {

    private var _binding: FragmentNowPlayingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var nowPlayingRV: RecyclerView
    lateinit var nowPlayingRVAdapter: ReviewAdapter
    lateinit var nowPlayingList: ArrayList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val nowPlayingViewModel =
            ViewModelProvider(this).get(NowPlayingViewModel::class.java)

        _binding = FragmentNowPlayingBinding.inflate(inflater, container, false)
        val root: View = binding.root


        nowPlayingViewModel.text.observe(viewLifecycleOwner) {

        }

        nowPlayingRV = binding.idRVCourses

        nowPlayingList = ArrayList()

        val layoutManager = GridLayoutManager(context, 2)

        nowPlayingRV.layoutManager = layoutManager

        nowPlayingRVAdapter = ReviewAdapter(nowPlayingList)

        nowPlayingRV.adapter = nowPlayingRVAdapter

        nowPlayingList.add(Movie("Movie A", R.drawable.ic_home_black_24dp))
        nowPlayingList.add(Movie("Movie B", R.drawable.ic_home_black_24dp))
        nowPlayingList.add(Movie("Movie C", R.drawable.ic_home_black_24dp))
        nowPlayingList.add(Movie("Movie D", R.drawable.ic_home_black_24dp))
        nowPlayingList.add(Movie("Movie E", R.drawable.ic_home_black_24dp))
        nowPlayingList.add(Movie("Movie F", R.drawable.ic_home_black_24dp))

        nowPlayingRVAdapter.notifyDataSetChanged()

        nowPlayingViewModel.postReview()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}