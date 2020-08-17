package com.main.MusicAndroid.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.main.MusicAndroid.R
import kotlinx.android.synthetic.main.fragment_detail.*

class FragmentDetail : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val musicTitle = arguments?.getString("Title")
        val musicArtistName = arguments?.getString("ArtistName")
        val musicImageURL = arguments?.getString("ImageURL")
        musicImageDetail.load(musicImageURL)
        musicArtistNameDetail.text = musicArtistName
        musicTitleDetail.text = musicTitle
    }
}
