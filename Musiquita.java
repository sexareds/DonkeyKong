import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Musiquita {
    void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if(!musicPath.exists()) {
                System.out.println("Couldn't find audio file");
                return;
            }
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            JOptionPane.showMessageDialog(null, "Headbang!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String filePath = "PeaceSells.wav";

        Musiquita music = new Musiquita();
        music.playMusic(filePath);
    }
}
