package projet_ayala_jouveneaux;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer extends JFrame {

    public MusicPlayer() {
        JButton playButton = new JButton("Play Music");
        playButton.addActionListener(e -> playMusic());

        getContentPane().add(playButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Appeler la m?thode playMusic() ici pour que la musique d?marre automatiquement
        playMusic();
    }

    private void playMusic() {
        try {
            File audioFile = new File("Test/Musique/ambiant.mp3");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicPlayer().setVisible(true);
        });
    }
}
