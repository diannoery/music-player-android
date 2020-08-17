package com.main.MusicAndroid.recycleViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.main.MusicAndroid.R
import com.main.MusicAndroid.viewModel.SongList

import kotlinx.android.synthetic.main.music_list_layout.view.*

class MusicRecycleView(
    private val musicList: MutableList<SongList>
) :
    RecyclerView.Adapter<MusicViewHolder>() {
    lateinit var navController: NavController
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_list_layout, parent, false)
        return MusicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val judul = musicList[position].title
        val artis = musicList[position].artis
        val imageUrl = musicList[position].imageUrl
        holder.Judul.text = judul
        holder.Artis.text = artis
        holder.Image.load(imageUrl)
        holder.itemView.musicClick.setOnClickListener {
            navController = Navigation.findNavController(it)
            navController.navigate(
                R.id.action_musicHomeFragment_to_detailMusicFragment, bundleOf(
                    "Title" to judul,
                    "ArtistName" to artis,
                    "ImageURL" to imageUrl
                )
            )
        }
    }
}

class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val Image = v.findViewById<ImageView>(R.id.musicImage)
    val Judul = v.findViewById<TextView>(R.id.musicTitle)
    val Artis = v.findViewById<TextView>(R.id.musicArtistName)

}