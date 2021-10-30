package com.yquery.gdsc_players_webview

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.AudioAttributes
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.StyledPlayerView
import com.yquery.gdsc_players_webview.databinding.ActivityAudioPlayerBinding
import java.io.File

@SuppressLint("UnsafeOptInUsageError")
class AudioPlayerActivity : AppCompatActivity() {

    private lateinit var exoPlayer: ExoPlayer

    private lateinit var binding: ActivityAudioPlayerBinding

    @SuppressLint("UnsafeOptInUsageError", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exoPlayer = ExoPlayer.Builder(this).build()

        binding.myplayer.player = exoPlayer

        val mediaItem: MediaItem =
//            MediaItem.fromUri("https://firebasestorage.googleapis.com/v0/b/my-quran-5d513.appspot.com/o/001.mp3?alt=media&token=8031c5e5-8169-4dc7-a11d-0a5fb10fca35")
//            MediaItem.fromUri("https://drive.google.com/file/d/1Yk3cvxESaSA8sl8YtmPlOmiRlqyB-59G/view?usp=sharing")
//            MediaItem.fromUri("https://bestvpn.org/html5demos/assets/dizzy.mp4")
//            MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
        MediaItem.fromUri(Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + File.pathSeparator + File.separator + File.separator + this.packageName + File.separator + R.raw.music))

        exoPlayer.addMediaItem(mediaItem)

        exoPlayer.setAudioAttributes(AudioAttributes.DEFAULT, /* handleAudioFocus= */ true)
        exoPlayer.prepare()
        exoPlayer.play()
//        exoPlayer.setPlayWhenReady(true);

    }


    override fun onStop() {
        super.onStop()
        exoPlayer.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer.release()
    }
}