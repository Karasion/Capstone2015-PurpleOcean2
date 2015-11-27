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
import kr.ac.kookmin.cs.basic.AppModel;

/**
* @brief This class is a core class associated with the music player
* @details There are basic methods necessary to music playback such as run,resume,pause,next,previous function
* @author Lee-MinJae , Im-GiSung
*/
public class MusicPlayer implements AppModel {
	private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int FINISHED = 3;
    
    private int indexMp3List = 0;
    private ArrayList<Path> directoryList = new ArrayList<Path>();
    private ArrayList<Path> mp3FileList = new ArrayList<Path>();

    // the player actually doing all the work
    private Player player;

    // locking object used to communicate with player thread
    private final Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    private int playerStatus = NOTSTARTED;
    
//    private MusicHud musicHud;
    
    private static FileInputStream fileInputStream = null;
    
    private MusicPlayerController musicPlayerController;
    
    public void setMusicPlayerController(MusicPlayerController musicPlayerController)
    {
    	this.musicPlayerController = musicPlayerController;
    }
    
    public void setList(ArrayList<Path> directoryList, ArrayList<Path> mp3FileList, int indexMp3List){
    	this.directoryList = directoryList;
    	this.mp3FileList = mp3FileList;
    	this.indexMp3List = indexMp3List;
    	close();
    	setPath(mp3FileList.get(indexMp3List));
    	try {
			play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    		setPath(getNextMp3());
    		musicPlayerController.changeMusicName();
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
    		setPath(getPreviousMp3());
			play();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	private void setPath(Path path) {
		try {
			fileInputStream = new FileInputStream(path.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Path getNextMp3() {
		Path path;
		Path pathName;
		indexMp3List++;
		if(indexMp3List >= mp3FileList.size())
			indexMp3List = 0;
//		System.out.println("Index : " + mp3FileListIndex);
		path = mp3FileList.get(indexMp3List);
		pathName = path.getFileName();
		return path;
	}

	private Path getPreviousMp3() {
		Path path;
		Path pathName;
		indexMp3List--;
		if(indexMp3List <= 0)
			indexMp3List = mp3FileList.size()-1;
//		System.out.println(mp3FileListIndex);
		path = mp3FileList.get(indexMp3List);
		pathName = path.getFileName();
		return path;
	}

	public String getMusicName() {
		return mp3FileList.get(indexMp3List).toString();
	}
	
	public ArrayList<Path> getMp3List()
	{
		return mp3FileList;
	}
	
	public ArrayList<Path> getDirectoryList()
	{
		return directoryList;
	}
	
	public int getMp3Index()
	{
		return indexMp3List;
	}
}