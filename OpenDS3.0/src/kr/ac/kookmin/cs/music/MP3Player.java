/**
* @file MusicPlayer.java
* @brief This file , run the MusicPlayer function
* @details This file is composed of MusicPlayer class.
*/

package kr.ac.kookmin.cs.music;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
* @brief This class is a core class associated with the music player
* @details There are basic methods necessary to music playback such as run,resume,pause,next,previous function
* @author Lee-MinJae , Im-GiSung
*/
public class MP3Player {
	private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int FINISHED = 3;
    
    private static int indexMp3List = 0;
    private static ArrayList<Path> mp3FileList = new ArrayList<Path>();

    // the player actually doing all the work
    private Player player;

    // locking object used to communicate with player thread
    private final Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    private int playerStatus = NOTSTARTED;
	private MusicView musicHud;
    
//    private MusicHud musicHud;
    
    private static FileInputStream fileInputStream = null;
    
    public MP3Player(MusicView musicHud){
    	this.musicHud = musicHud;
    }

    public boolean isPlaying(){
    	return playerStatus == PLAYING;
    }
    
    public boolean isPaused(){
    	return playerStatus == PAUSED;
    }

    /**
     * Starts playback (resumes if paused)
     */
    public void play() throws JavaLayerException {
        synchronized (playerLock) {
            switch (playerStatus) {
                case NOTSTARTED:
                	player = new Player(fileInputStream);
                    final Runnable r = new Runnable() {
                        public void run() {
                            playInternal();
                        }
                    };
                    final Thread t = new Thread(r);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                case PLAYING:
                case FINISHED:
                default:
                    break;
            }
        }
    }

    /**
     * Pauses playback. Returns true if new state is PAUSED.
     */
    public void pause() {
        synchronized (playerLock) {
            if (playerStatus == PLAYING) {
                playerStatus = PAUSED;
            }
//            return playerStatus == PAUSED;
        }
    }

    /**
     * Resumes playback. Returns true if the new state is PLAYING.
     */
    public void resume() {
        synchronized (playerLock) {
            if (playerStatus == PAUSED) {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
//            return playerStatus == PLAYING;
        }
    }

    /**
     * Stops playback. If not playing, does nothing
     */
    public void stop() {
        synchronized (playerLock) {
            playerStatus = NOTSTARTED;
            fileInputStream = null;
            playerLock.notifyAll();
        }
    }

    private void playInternal() {
//    	System.out.println("start");
//    	System.out.println(playerStatus);
        while (playerStatus != FINISHED) {
            try {
                if (!player.play(1)) {
                    break;
                }
            } catch (final JavaLayerException e) {
                break;
            }
            // check if paused or terminated
            synchronized (playerLock) {
                while (playerStatus == PAUSED) {
                    try {
                        playerLock.wait();
                    } catch (final InterruptedException e) {
                        // terminate player
                        break;
                    }
                }
            }
        }
        close();
        next();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
        }
        try {
            player.close();
//            System.out.println("close");
        } catch (final Exception e) {
            // ignore, we are terminating anyway
        }
    }
    
    /**
     * 
     */
    public void next() {
    	synchronized (playerLock) {
    		if(playerStatus != FINISHED)
    			close();
    		playerStatus = NOTSTARTED;
    		//get next mp3 directory
    	}
    	try {
//    		Path p;
//    		System.out.println("next");
//    		p = musicHud.getNextMp3();
//    		System.out.println(p);
//    		setPath(p);
    		setPath(musicHud.getPreviousMp3());
			play();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 
     */
    public void previous() {
    	synchronized (playerLock) {
    		if(playerStatus != FINISHED)
    			close();
    		playerStatus = NOTSTARTED;
    		//get next mp3 directory
    	}
    	try {
//    		System.out.println("previous");

    		setPath(musicHud.getPreviousMp3());
			play();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void setPath(Path path) {
		try {
			fileInputStream = new FileInputStream(path.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	private Path getMp3File(){
//		
//	}
//	private void  
}