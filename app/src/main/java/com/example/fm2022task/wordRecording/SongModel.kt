package com.example.fm2022task.wordRecording

import com.google.gson.annotations.SerializedName

data class SongModel (val title:String, val id:String,
                      @SerializedName("artist-credit")
                      val artistCredit:List<ArtistModel>,
                      val releases:List<ReleaseModel>)