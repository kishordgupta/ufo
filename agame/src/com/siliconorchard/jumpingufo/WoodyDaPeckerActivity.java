package com.siliconorchard.jumpingufo;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrameCache;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.sound.SoundEngine;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.ironsource.mobilcore.CallbackResponse;
import com.ironsource.mobilcore.MobileCore;
import com.ironsource.mobilcore.OnReadyListener;
import com.ironsource.mobilcore.CallbackResponse.TYPE;
import com.ironsource.mobilcore.MobileCore.AD_UNITS;
import com.ironsource.mobilcore.MobileCore.LOG_TYPE;
import com.jindongfeng.scor.ScoreViewManager;
import com.jindongfeng.scor.SharedPref;

public class WoodyDaPeckerActivity extends Activity {
    /** Called when the activity is first created. */
	public static CCGLSurfaceView mGLSurfaceView;
	private boolean isCreated = false; 
	public static FrameLayout m_rootLayout;
	private static Handler mHandler;
	    
	
	public static WoodyDaPeckerActivity instance; 
	 public static Handler GetHandler(){
			return mHandler;
		}
	 
	@Override
    public void onCreate(Bundle savedInstanceState) {
//		if( !isCreated ){
//			isCreated = true;
//		} else {
//			return;
//		}
        
//		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//       
//        mGLSurfaceView = new CCGLSurfaceView(this);
//        setContentView(mGLSurfaceView);
//   		CCDirector.sharedDirector().attachInView(mGLSurfaceView); 
        
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
 
		 mHandler = new Handler();

		 m_rootLayout = new FrameLayout(this);
        m_rootLayout.setLayoutParams(
       		new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)); 
        setContentView(m_rootLayout);
        
        mGLSurfaceView = new CCGLSurfaceView(this);
        
        CCDirector.sharedDirector().attachInView(mGLSurfaceView); 
        CCDirector.sharedDirector().setDisplayFPS(false);
        MobileCore.init(this,"8YKF89U9YHXZUIMHFEQ0UDC1T9TOY", LOG_TYPE.DEBUG, AD_UNITS.ALL_UNITS);
		
		// Look up the AdView as a resource and load a request.
		 MobileCore.setStickeezReadyListener(new OnReadyListener()
		 { @Override 
			 public void onReady(AD_UNITS adUnit) {
			 if (adUnit.equals(AD_UNITS.STICKEEZ)){
				 //do something 
			
		 }
		 } }
		 );
		 MobileCore.showStickee(this);
		
        
        
       
//        LinearLayout layout = (LinearLayout) findViewById(R.id.admob);
      //  layout.addView(adView);
        final FrameLayout.LayoutParams adViewLayoutParams =
                new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                                             FrameLayout.LayoutParams.WRAP_CONTENT,
                                             Gravity.CENTER_HORIZONTAL|Gravity.TOP);
        final FrameLayout.LayoutParams frameLayoutLayoutParams =
                new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                             FrameLayout.LayoutParams.MATCH_PARENT);


        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
      

        // Start loading the ad in the background.
      //  adView.loadAd(adRequest);
      
        // SURFACE layout ? //
        final android.widget.FrameLayout.LayoutParams surfaceViewLayoutParams =
                new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT);
        m_rootLayout.addView(mGLSurfaceView);
        // ADD the surface view and adView to the frame //
     //   m_rootLayout.addView(adView, adViewLayoutParams);
        
        
        
        
       	Common.game_initialize();
       	SharedPref.initialize();
   		getScaledCoordinate();
        // attach the OpenGL view to a window
		Common.sound_engine = SoundEngine.sharedEngine();
		loadSound();//jinjin

		//ParseAnalytics.trackAppOpened(getIntent());
		
		instance = this;
		CCScene scene = CCScene.node();
        scene.addChild(new StartView(), -1);
        CCDirector.sharedDirector().runWithScene(scene);
        
      //  revmob = RevMob.start(this);
        //fillUserInfo();
      //  showFullscreen();
   }
   
	  
	    
   @Override
   public void onStart() {
       super.onStart();
   }
   
    @Override    
    public void onPause() {
    	super.onPause();
    	
		MediaGlobal._shared().pauseMusic();
//		
		if(GameLayer.sharedGameLayer() != null){
			GameLayer.sharedGameLayer().onPause(null);
		}
        CCDirector.sharedDirector().pause();
	}

    @Override
    public void onResume() {
        super.onResume();
        
		MediaGlobal._shared().resumeMusic();
		if(GameLayer.sharedGameLayer() != null){
			GameLayer.sharedGameLayer().onResume(null);
		}
		CCDirector.sharedDirector().onResume();
    }

    @Override
    public void onDestroy() {
    	isCreated = false;
    	
		MediaGlobal._shared().stopMusic();
		Common.sound_engine.realesAllEffects();

		CCDirector.sharedDirector().end();       

        CCTextureCache.sharedTextureCache().removeAllTextures();
        CCSpriteFrameCache.sharedSpriteFrameCache().removeAllSpriteFrames();
		      
        super.onDestroy();
    }
    
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
        	exitGameDialog();
			return false;
        }
		return super.onKeyDown(keyCode, event);
	}

    public void exitGameDialog()
    {
		Builder builder = new AlertDialog.Builder(WoodyDaPeckerActivity.this)
    	.setIcon(R.drawable.ic_launcher)		
        .setTitle("Exit the Game?")
        .setMessage("Are you sure?")
        .setNegativeButton("No", new DialogInterface.OnClickListener(){
        	public void onClick(DialogInterface dialog, int whichButton)
        	{}
        	}
        )
        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int whichButton) 
            {
//            	CCActionManager.sharedManager().removeAllActions();
//        		CCSpriteFrameCache.sharedSpriteFrameCache().removeAllSpriteFrames();
//        		CCTextureCache.sharedTextureCache().removeAllTextures();
//
//            	CCDirector.sharedDirector().end();
            	 MobileCore.showOfferWall(WoodyDaPeckerActivity.this, 
						 new CallbackResponse() { @Override
					 public void onConfirmation(TYPE type) {	WoodyDaPeckerActivity.this.finish(); } });
            
            }
        }
        );
		builder.create().show();
    }

    private void loadSound() {
		SoundEngine.purgeSharedEngine();
		
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.bird1);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.bird2);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.bomb);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.bounce);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.coin);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.death);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.fish1);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.fish2);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.fly);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.fly6);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.gameover);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.hop);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.jumppad);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.mega_jump);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.score_finish);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.score_tick);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.splash);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.spring_01);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.spring_02);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.spring_03);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.spring_04);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.spring_05);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.spring_06);
		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.tiny_wings_item);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.wind);
//		Common.sound_engine.preloadEffect(CCDirector.sharedDirector().getActivity().getApplication(), R.raw.wings);
    }
    
    
    private void getScaledCoordinate()
	{
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		Common.SCREEN_WIDTH = displayMetrics.widthPixels;
		Common.SCREEN_HEIGHT = displayMetrics.heightPixels;
		Common.kXForIPhone = Common.SCREEN_WIDTH / 480.0f;
		Common.kYForIPhone = Common.SCREEN_HEIGHT / 320.0f;
		
		//Common.initScore();
	}
    
    public class StartView extends CCLayer
    {
    	
//    	@Override
//    	public void onExit() {
//    		removeAllChildren(true);
//    		super.onExit();
//    	}
    	
    	public StartView()
    	{
//			CCTextureCache.sharedTextureCache().removeAllTextures();
//			CCActionManager.sharedManager().removeAllActions();
			
    		CCSprite spStart = CCSprite.sprite("default.png");
//    		spStart.setRotation(-90);
    		spStart.setScaleX(Common.kXForIPhone);
    		spStart.setScaleY(Common.kYForIPhone);
    		spStart.setPosition(Common.SCREEN_WIDTH/2, Common.SCREEN_HEIGHT/2);
    		addChild(spStart, 0);
//    		this.unscheduleAllSelectors();
//    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//    		this.unschedule("timerEvent");

    		this.schedule("timerEvent", 1.0f);
    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	}
		
    	public void timerEvent(float dt)
    	{

    		this.unschedule("timerEvent");

    		ScoreViewManager.showUserNameDialog();
    		CCScene scene = CCScene.node();
        	scene.addChild(new HelloWorldLayer(), 1);
        	CCDirector.sharedDirector().replaceScene(scene);
    	}
    	
        
//    	private void releaseSprite( CCSprite sp )
//    	{
//    	    CCTexture2D tex = sp.getTexture();
//    	    CCTextureCache.sharedTextureCache().removeTexture(tex);
//    	}

//    	private void releaseResources(){
//    		releaseSprite((CCSprite)getChildByTag(0));
//    	}
//    	
    	@Override
    	public void onExit(){
//    		releaseResources();
//    		removeAllChildren(true);
    		unscheduleAllSelectors();
    		removeAllChildren(true);
    		super.onExit();
    	}
    }   
}