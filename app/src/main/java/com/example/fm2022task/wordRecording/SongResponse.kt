package com.example.fm2022task.wordRecording

data class SongResponse (val created:String,
                         val count:Int,
                         val offset:Int,
                         val recordings:List<SongModel>)