package kr.ac.kookmin.cs.hud;

import kr.ac.kookmin.cs.BSA.BSAController;
import kr.ac.kookmin.cs.Navigation.NaviActionEvent;
import kr.ac.kookmin.cs.Navigation.NaviController;
import kr.ac.kookmin.cs.call.CallController;
import kr.ac.kookmin.cs.call.CallModel;
import kr.ac.kookmin.cs.call.CallView;
import kr.ac.kookmin.cs.hud.menu.HUDMenuView;
import kr.ac.kookmin.cs.music.MusicController;
import kr.ac.kookmin.cs.music.MusicList;
import kr.ac.kookmin.cs.music.MusicListController;
import kr.ac.kookmin.cs.music.MusicListView;
import kr.ac.kookmin.cs.music.MusicModel;
import kr.ac.kookmin.cs.music.MusicPlayer;
import kr.ac.kookmin.cs.music.MusicPlayerController;
import kr.ac.kookmin.cs.music.MusicPlayerView;
import kr.ac.kookmin.cs.music.MusicView;
import kr.ac.kookmin.cs.sms.SMSController;
import kr.ac.kookmin.cs.sms.SMSModel;
import kr.ac.kookmin.cs.sms.SMSView;
import eu.opends.main.Simulator;

public class HUDMain {
  
  private static HUDMain hudMain = new HUDMain();
  private Simulator sim;
  private HUDController hudController = HUDController.getInstance();
  
  private HUDMain() {}
  
  public void init(Simulator sim)
  {
    this.sim = sim;
    
    HUDMenuView hudMenuView = new HUDMenuView(sim);
    
    NaviController naviController = new NaviController(sim);
    BSAController bsaController = new BSAController(sim);
    
    SMSModel smsModel = new SMSModel();
    SMSView smsView = new SMSView(sim);
    SMSController smsController = new SMSController(smsModel, smsView);
    
    CallModel callModel = new CallModel();
    CallView callView = new CallView(sim);
    CallController callController = new CallController(callModel, callView);
    
    MusicList musicList = new MusicList();
    MusicListView musicListView = new MusicListView(sim);
    MusicListController musicListController = new MusicListController(musicList, musicListView);
    MusicPlayer musicPlayer = new MusicPlayer();
    MusicPlayerView musicPlayerView = new MusicPlayerView(sim);
    MusicPlayerController musicPlayerController = new MusicPlayerController(musicPlayer, musicPlayerView);
    musicPlayer.setMusicPlayerController(musicPlayerController);
    MusicModel musicModel = new MusicModel(musicPlayerView, musicPlayerController, musicListView, musicListController);
    MusicView musicView = new MusicView(sim);
    MusicController musicController = new MusicController(musicModel, musicView);
    
    HUDModel hudModel = new HUDModel();
    hudModel.addNavi(naviController.getNaviView(), naviController);
    hudModel.addBSA(bsaController.getBSAView(), bsaController);
    
    hudModel.addAppView(smsView);
    hudModel.addAppController(smsController);
    hudMenuView.addMenuIcon(smsView.getEnableIcon(), smsView.getDisableIcon());
    
    hudModel.addAppView(musicView);
    hudModel.addAppController(musicController);
    hudMenuView.addMenuIcon(musicView.getEnableIcon(), musicView.getDisableIcon());
    
    hudModel.addAppView(callView);
    hudModel.addAppController(callController);
    
    HUDView hudView = new HUDView(sim, hudModel);
    hudController.init(hudModel, hudView, hudMenuView);
    
  }
  
  public void update()
  {
    hudController.eventHandler(new NaviActionEvent("UpdateCurrentSpeed","NaviController",String.valueOf((int)sim.getCar().getCurrentSpeedKmh())));
    
  }
  
  public static HUDMain getInstance() { return hudMain; }

}
