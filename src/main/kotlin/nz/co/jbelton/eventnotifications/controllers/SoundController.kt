package nz.co.jbelton.eventnotifications.controllers

import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import java.io.File
import javax.sound.sampled.AudioFileFormat
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.DataLine
import javax.sound.sampled.LineEvent
import javax.sound.sampled.LineListener

class SoundController : LineListener {

    private lateinit var audioClip: Clip
    private lateinit var audioInputStream: AudioInputStream
    fun playAudio(string: String) {
        val audioFile: File = File(string);
        audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        val audioFormat = audioInputStream.format
        val dataInfo = DataLine.Info(Clip::class.java, audioFormat)

        audioClip = AudioSystem.getLine(dataInfo) as Clip

        audioClip.addLineListener(this)

        audioClip.open(audioInputStream)
    }


    override fun update(lineEvent: LineEvent) {
        when(lineEvent.type) {
            LineEvent.Type.OPEN -> audioClip.start()
            LineEvent.Type.STOP -> {
                audioClip.close()
                audioInputStream.close()
            }
        }
    }
}