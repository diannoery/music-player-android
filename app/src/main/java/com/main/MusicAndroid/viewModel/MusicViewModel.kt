package com.main.MusicAndroid.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MusicViewModel : ViewModel() {
    val musicList = mutableListOf<SongList>(
        SongList(   "Bara Suara",
            "Sendu Melagu",
            "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG"),
        SongList( "Danilla",
            "Berdistraksi",
            "https://pophariini.com/wp-content/uploads/2019/10/danillafingers-1.jpg"),
        SongList( ".feast",
            "Padi Milik Rakyat",
            "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2018/09/27/170962345.jpg"),
        SongList(  "FourTwnty",
            "Nematomorpha",
            "https://pophariini.com/wp-content/uploads/2018/09/Fourtwnty.jpg")
    )

    val musicLiveData: MutableLiveData<MutableList<SongList>> = MutableLiveData(musicList)

    fun addMusicList(musicArtistName: String, musicTitle: String, musicImage: String) {
        musicList.add(
            SongList(
                musicArtistName,
                musicTitle,
                musicImage
            )
        )
        musicLiveData.value = musicList
    }
}

class SongList(title: String, artis: String, image: String) {

    var title = title
    var artis = artis
    var imageUrl = image

}