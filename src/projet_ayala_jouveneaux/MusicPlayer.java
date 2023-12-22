package projet_ayala_jouveneaux;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;


import javax.sound.sampled.*;

public class MusicPlayer {
    private Clip clip;

    public MusicPlayer(String filePath) {
        try {
            File audioFile = new File("./test/Musique/ambiant.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playMusic() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
