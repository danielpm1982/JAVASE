/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Daniel
 */
public class MyMusicPlayer {
    
    private Clip clip;
    private URL url;
    private AudioInputStream ais;
    
    public MyMusicPlayer(String fileName) {
        this.clip=null;
        this.ais=null;
        try {
            url = this.getClass().getResource(fileName);
            ais = AudioSystem.getAudioInputStream(url);
            DataLine.Info info = new DataLine.Info(Clip.class,ais.getFormat());
            clip = (Clip)AudioSystem.getLine(info);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.open(ais);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(System.err);
        } finally{
            try {
                ais.close();
            } catch (IOException ex) {
                Logger.getLogger(MyMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            clip.close();
        }
    }
}
