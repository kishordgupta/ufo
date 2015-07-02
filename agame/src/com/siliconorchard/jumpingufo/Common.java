package com.siliconorchard.jumpingufo;

import java.util.ArrayList;

import org.cocos2d.actions.base.CCAction;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGSize;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Common
{
	public static String g_username = "";
	public static SoundEngine sound_engine;
	//SCALE
	public static GameLayer game_layer = null;

	public static float kXForIPhone = 1;
	public static float kYForIPhone = 1;
	
	public static float SCREEN_WIDTH = 480;
	public static float SCREEN_HEIGHT = 320;
	public static final float START_ACTIVITY_TIME = 2.0f;
	
	//////////////// GameLayer parameter////////////////////
	public static final float STAGE_COUNT  =  4.0f;
	
	public static float[][] cloudPos = {
		{0, 50},
	    {300, 200},
	    {500, 70},
	    {750, 140},
	    {850, 80}
	};

	public enum GameState {
	    GameState_start,
	    GameState_gaming,
	    GameState_gameover
	    };
	 
	    public static final int Bird_Type_bird1 = 0;
	    public static final int Bird_Type_bird2 = 1;
	    public static final int Bird_Type_bird3 = 2;

		public enum FoodType {
		    FoodType_bomb,
		    FoodType_protect,
		    FoodType_rainbow,
		    FoodType_fast,
		    FoodType_sun
		    };
	static float gameTime = 0;
	static int genBirdCount = 0;
////////////////////////////////////////////////////
	public static class ztag_In_camera {
		public static final int ztag_min = -1;
		public static final int ztag_land = 0;
		public static final int ztag_body1 = 1;
		public static final int ztag_body2 = 2;
		public static final int ztag_food = 3;
		public static final int ztag_player = 4;
		public static final int ztag_cloud = 5;
		public static final int ztag_river = 6; 
		public static final int ztag_gameover = 7;
		public static final int ztag_menu = 8;
	};
	
	public static class PlayerInfo
	{
	    public int rankNum;
	    public String name = new String();
	    public int score;	
	};
	
	public static class sPlayerInfo {
		public int rankNum;
		public String name = new String();
		public int score;
	}
	
	public static class GameInfo{
	    public float totalDistance;
	    public int coinCount;
	    public String name=new String();
	    //public char name[] = new char[256];
	}
	
	// GAME INFO
	
	public static GameInfo g_gamePlayerInfo = null;
	public static ArrayList<PlayerInfo> gameInfo = null;
	public static int g_stageNum;
	public static int g_coinNum;
	// sound
	
	public static boolean g_soundMute = false;
//	public static AVAudioPlayer gamebg;
//	public static AVAudioPlayer fly;
//	public static AVAudioPlayer bounce;
//	public static AVAudioPlayer death;
//	public static AVAudioPlayer jumppad;
//	public static AVAudioPlayer bomb;
//	
	// ANIMATIONS
	
	public static CCAction ani_line = null;
	
	public static CCAction ani_seed_leaf_up = null;
	public static CCAction ani_seed_leaf_down = null;
	public static CCAction ani_seed_leaf_fast = null;
	
	public static CCAction ani_seed_face_fast = null;
	public static CCAction ani_seed_face_none = null;
	public static CCAction ani_seed_face_rainbow = null;
	public static CCAction ani_seed_face_fail = null;
	
	public static CCAction ani_bird1 = null;
	public static CCAction ani_bird2 = null;
	public static CCAction ani_bird3 = null;
	
	   
	public static String IMG_LINE[] = {
	    "line.png",
	    "line1.png",
	    "line3.png",
	    "line2.png",
	};
	
	public static String IMG_BG1_BACK1[] = {
	    "bga1_1.png",
	    "bga1_2.png",
	    "bga1_3.png",
	  
	};
	public static String IMG_BG1_BACK2[] = {
	    "bga2_1.png",
	    "bga2_2.png",
	    "bga2_3.png",
	    "bga2_4.png",
	  
	};
	public static String IMG_BG2_BACK1[] = {
	    "bga1_1.png",
	    "bga1_2.png",
	    "bga1_3.png",
	  
	
	};
	public static String IMG_BG2_BACK2[] = {
	    "bga2_1.png",
	    "bga2_2.png",
	    "bga2_3.png",
	    "bga2_4.png",
	  
	
	};
	public static String IMG_BG3_BACK1[] = {
	    "bgc3_1.png",
	    "bgc3_2.png",
	    "bgc3_3.png",
	    "bgc3_4.png",
	  
	};
	public static String IMG_BG3_BACK2[] = {
	    "bgc4_1.png",
	    "bgc4_2.png",
	    "bgc4_3.png",
	  
	};
	public static String IMG_BG4_BACK1[] = {
	    "bgd1_1.png",
	    "bgd1_2.png",
	  
	};
	public static String IMG_BG4_BACK2[] = {
	    "bgd2_1.png",
	    "bgd2_2.png",
	    "bgd2_3.png",
	    "bgd2_4.png",
	  
	};
	
	public static String IMG_BG1_CLOUD[] = {
	    "bga_cloud_1.png",
	    "bga_cloud_2.png",
	  
	};
	public static String IMG_BG2_CLOUD[] = {
	    "bga_cloud_1.png",
	    "bga_cloud_2.png",
	  
	
	};
	public static String IMG_BG3_CLOUD[] = {
	    "bgc_cloud_1.png",
	    "bgc_cloud_2.png",
	  
	
	};
	public static String IMG_BG4_CLOUD[] = {
	    "bgd_cloud_1.png",
	    "bgd_cloud_2.png",
	  
	
	};
	
	public static String IMG_BACK[] = {
	    "bga0.png",
	    "bgb0.png",
	    "bgc0.png",
	    "bgd0.png",
	  
	};
	
	public static String IMG_LAND[] = {
	    "bga_land.png",
	    "bgb_land.png",
	    "bgc_land.png",
	    "bgd_land.png",
	  
	};
	
	public static String IMG_LIVER[] = {
	    "bga_river.png",
	    "bgb_river.png",
	    "bgc_river.png",
	    "bgd_river.png",
	  
	};
	
	public static void effectPlay( int resId ) {
		if( !g_soundMute )
			sound_engine.playEffect(CCDirector.sharedDirector().getActivity(), resId);
	}
	
	public static Boolean loadActions()
	{
	    String fileName;
	    ArrayList<CCSpriteFrame> expArray0 = new ArrayList<CCSpriteFrame>();
	    CCAnimation animation;
	    
	    for (int i = 0; i<4; i ++) {
	        fileName = IMG_LINE[i];
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(0, 0, texture.getContentSize().width, texture.getContentSize().height), CGPoint.zero());
	    	expArray0.add(frame0);

	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_line = CCAnimate.action(animation, true);
	    expArray0.removeAll(expArray0);

	    float width = 56;
	    float height = 43;
	    
	    float startX = 336;
	    float startY = 43;
	    
	    fileName = "hero_leaf.png";
	    // Indian
	    for (int num = 0; num < 4; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        if (startX <= 0) {
	            startX = 56 * 17;
	            startY = 0;
	        }
	        else
	        {
	            startX -= width;
	        }
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_leaf_fast = CCAnimate.action(animation, false);
//	    animation = CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_seed_leaf_fast = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];
	    expArray0.removeAll(expArray0);

	    for (int num = 0; num < 11; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        if (startX <= 0) {
	            startX = 56 * 17;
	            startY = 0;
	        }
	        else
	        {
	            startX -= width;
	        }

	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_leaf_up = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_seed_leaf_up = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    for (int num = 0; num < 10; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        if (startX <= 0) {
	            startX = 56 * 17;
	            startY = 0;
	        }
	        else
	        {
	            startX -= width;
	        }
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_leaf_down = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_seed_leaf_down = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    width = 46;
	    height = 33;
	    startX = 328 - 49;
	    startY = 0;
	    fileName = "bird1.png";
	    
	    for (int num = 0; num < 7; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_bird1 = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_bird1 = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    width = 54;
	    height = 39;
	    startX = 382 - 56;
	    startY = 0;
	    fileName = "bird2.png";
	    
	    for (int num = 0; num < 7; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_bird2 = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_bird2 = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    width = 51;
	    height = 39;
	    startX = 377;
	    startY = 0;
	    fileName = "bird3.png";
	    
	    for (int num = 0; num < 7; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_bird3 = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_bird3 = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];
	    
	    width = 55;
	    height = 54;
	    startX = width * 5;
	    startY = 54;
	    fileName = "hero.png";
	    
	    for (int num = 0; num < 17; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;

	        if (startX <= 0) {
	            startY -= height;
	            startX = width * 17;
	        }
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_face_none = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_seed_face_none = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    width = 55;
	    height = 54;
	    startX = width * 17;
	    startY = 0;
	    
	    for (int num = 0; num < 7; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;
	        
	        if (startX <= 0) {
	            startY -= height;
	            startX = width * 17;
	        }
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_face_rainbow = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_seed_face_rainbow = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    width = 55;
	    height = 54;
	    startX = width * 6;
	    startY = 0;
	    
	    for (int num = 0; num < 7; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;
	        
	        if (startX <= 0) {
	            startY -= height;
	            startX = width * 17;
	        }
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_face_fast = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.05f];
//	    ani_seed_face_fast = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    width = 55;
	    height = 54;
	    startX = width * 9;
	    startY = height;
	    
	    for (int num = 0; num < 4; num ++) {
	        CCTexture2D texture = CCTextureCache.sharedTextureCache().addImage(fileName);
	    	
	    	// manually add frames to the frame cache
	    	CCSpriteFrame frame0 = CCSpriteFrame.frame(texture, 
	    			CGRect.make(startX, startY, width, height), CGPoint.zero());
	    	expArray0.add(frame0);
	    	
	        startX -= width;
	        
	        if (startX <= 0) {
	            startY -= height;
	            startX = width * 17;
	        }
	        
	    }
	    animation = CCAnimation.animation("", 0.05f, expArray0);
	    ani_seed_face_fail = CCAnimate.action(animation, false);
	    expArray0.removeAll(expArray0);
//	    animation = [CCAnimation animationWithFrames:expArray0 delay:0.1f];
//	    ani_seed_face_fail = [[CCAnimate actionWithAnimation:animation restoreOriginalFrame:NO] retain];
//	    [expArray0 removeAllObjects];

	    return true;
	}
	
	public static boolean loadGameInfo()
	{
		
	    gameInfo = new ArrayList<PlayerInfo>();
	    g_gamePlayerInfo = new GameInfo();
	    
	    SharedPreferences p = CCDirector.sharedDirector().getActivity().getApplicationContext().getSharedPreferences("score", 0);
		
		int n = 0;
	    
		int nFirst = 0;
		nFirst = p.getInt("First", 0);
		PlayerInfo playerInfo;
		if (nFirst == 0)
		{
			g_gamePlayerInfo.coinCount = 0;
	        g_gamePlayerInfo.totalDistance = 0;
	      
	        for (int i = 0; i < 20; i ++) {
	            playerInfo = new PlayerInfo();
	            playerInfo.rankNum = i;
	            gameInfo.add(playerInfo);
	        }
		}
		else 
		{
			g_gamePlayerInfo.totalDistance = p.getFloat("totalDistance", 0);
		    g_gamePlayerInfo.coinCount=p.getInt("coinCount", 0);
		    g_gamePlayerInfo.name = p.getString("name", "0");
			    
			sPlayerInfo tempSPlayer = new sPlayerInfo();
			String str;
	        for (int i = 0; i < 20; i ++) {
	            playerInfo = new PlayerInfo();
	            //sPlayerInfo
	            //fread(&tempSPlayer, sizeof(tempSPlayer), 1, fp);
	        	str=String.format("rankName%d", i);
	    		tempSPlayer.rankNum = p.getInt(str, 0);
	    		
	    		str=String.format("name%d", i);
	    		tempSPlayer.name = p.getString(str, "0");
	    		
	    		str=String.format("score%d", i);
	    		tempSPlayer.score =p.getInt(str, 0);
	    		
	            playerInfo.rankNum = tempSPlayer.rankNum;
	            playerInfo.name = tempSPlayer.name;
	            //playerInfo.name = [String stringWithCString:tempSPlayer.name encoding:NSASCIIStringEncoding);
	            playerInfo.score = tempSPlayer.score;
	
	            gameInfo.add(playerInfo);
	        }
		}
		
		return true;
	}
	
	public static Boolean saveGameInfo()
	{
	    SharedPreferences p = CCDirector.sharedDirector().getActivity().getApplicationContext().getSharedPreferences("score", 0);
		
		int nFirst = 1;
		Editor ed = p.edit();
		ed.putInt("First", nFirst);
		
//		if (fp == nil)
//			return FALSE;
	    
	   // fwrite(&g_gamePlayerInfo, sizeof(g_gamePlayerInfo), 1, fp);
	
	    ed.putFloat("totalDistance", g_gamePlayerInfo.totalDistance);
	    ed.putInt("coinCount", g_gamePlayerInfo.coinCount);
	    ed.putString("name", g_gamePlayerInfo.name);
	    
	    
	    
	    sPlayerInfo tempSPlayer =new sPlayerInfo();
	    String str;
	    for (int i = 0; i < 20; i ++) {
	        PlayerInfo playerInfo = gameInfo.get(i);
	        tempSPlayer.rankNum = playerInfo.rankNum;
	        tempSPlayer.name = playerInfo.name;
	        tempSPlayer.score = playerInfo.score;
	        
	       // fwrite(&tempSPlayer, sizeof(tempSPlayer), 1, fp);
	        str=String.format("rankName%d", i);
	        ed.putInt(str, tempSPlayer.rankNum);
    		
    		str=String.format("name%d", i);
    		ed.putString(str, tempSPlayer.name);
    		
    		str=String.format("score%d", i);
    		ed.putInt(str, tempSPlayer.score);
    		
           
	    }
	    ed.commit();
	    
	    return true;
	}
	
	public static boolean game_initialize()
	{
		CGSize winSize = CCDirector.sharedDirector().winSize();
//		CGSize winSize = [[CCDirector sharedDirector] winSize);
		SCREEN_WIDTH = winSize.width;
		SCREEN_HEIGHT = winSize.height;
		
		if ( SCREEN_WIDTH == 1024 && SCREEN_HEIGHT == 768)
		{
	        kXForIPhone = 1024.0f / 480.0f;
			kYForIPhone = 768.0f / 320.0f;
	        
		}
		else {
	        kYForIPhone = 1.0f;
			kXForIPhone = 1.0f;
	        
		}
	    
	    if ( loadActions() == false)
	    {
	        return false;
	    }
		
	    if (loadGameInfo() == false) {
	        return false;
	    }
//	    if ( loadSounds() == false) {
//	    	return false;
//	    }
	//	
	//    //  load GameInfo
	//    {
	//        NSArray paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
	//        String documentsDirectory = [paths objectAtIndex:0);
	//        String szFile = [documentsDirectory stringByAppendingPathComponent: "gameinfo.dat");
	//        
	//        FILE fp = fopen([szFile cStringUsingEncoding:NSASCIIStringEncoding],"rb+");
	//        
	//        if (fp != nil) 
	//        {
	//            fread(g_itemSuccesInfo, sizeof(g_itemSuccesInfo), 1, fp);
	//            fclose(fp);	
	//            
	//        }
	//    }
	    
		return true;
	}
	
//	BOOL game_release()
//	{
//	    saveGameInfo();
//	    
//	    for (int i = 0; i < 20; i ++) {
//	        PlayerInfo playerInfo = [gameInfo objectAtIndex:i);
//	        [playerInfo release);
//	    }
//	    [gameInfo removeAllObjects);
//	
//	    [fly release);
//	    [gamebg release);
//	    [bounce release);
//	    [death release);
//	    [jumppad release);
//	    [bomb release);
//	    
//		return TRUE;
//	}
	
//	void soundActive(bool flag)
//	{
//	    if (flag == false)
//	    {
//	        [fly setVolume:1.0f);
//	        [gamebg setVolume:1.0f);
//	        [bounce setVolume:1.0f);
//	        [death setVolume:1.0f);
//	        [jumppad setVolume:1.0f);
//	        [bomb setVolume:1.0f);
//	        
//	    }
//	    else
//	    {
//	        [fly setVolume:0.0f);
//	        [gamebg setVolume:0.0f);
//	        [bounce setVolume:0.0f);
//	        [death setVolume:0.0f);
//	        [jumppad setVolume:0.0f);
//	        [bomb setVolume:0.0f);
//	        
//	    }
//	    
//	}

	static CGPoint FoodPosInfo_1[] = {
		CGPoint.ccp(240, 74), CGPoint.ccp(240, 107), CGPoint.ccp(243, 140), CGPoint.ccp(247, 173), CGPoint.ccp(255, 203), CGPoint.ccp(264, 236),
		CGPoint.ccp(290,125), CGPoint.ccp(318, 154), CGPoint.ccp(348, 188), CGPoint.ccp(385, 223),
		CGPoint.ccp(279, 86), CGPoint.ccp(318, 98),  CGPoint.ccp(360, 112), CGPoint.ccp(406, 122), CGPoint.ccp(457, 130), 
		CGPoint.ccp(0, 0)
	};

	static CGPoint FoodPosInfo_2[] = {
	    CGPoint.ccp(240, 138), CGPoint.ccp(275, 138), CGPoint.ccp(310, 138), CGPoint.ccp(345, 138), CGPoint.ccp(380, 138), 
	    CGPoint.ccp(240, 176), CGPoint.ccp(275, 176), CGPoint.ccp(310, 176), CGPoint.ccp(345, 176), CGPoint.ccp(380, 176), 
	    CGPoint.ccp(228, 289), CGPoint.ccp(265, 289), CGPoint.ccp(291, 247), CGPoint.ccp(342, 247), CGPoint.ccp(371, 289), 
	    CGPoint.ccp(409, 289), CGPoint.ccp(0, 0)
	};

	static CGPoint FoodPosInfo_3[] = {
	    CGPoint.ccp(255, 187), CGPoint.ccp(279, 210), CGPoint.ccp(304, 231), 
	    CGPoint.ccp(338, 252), CGPoint.ccp(376, 272), CGPoint.ccp(417, 283),
	    CGPoint.ccp(461, 281), CGPoint.ccp(499, 279),CGPoint.ccp(537, 263), 
	    CGPoint.ccp(570, 238), CGPoint.ccp(501, 214), CGPoint.ccp(530, 187),
	    CGPoint.ccp(0, 0)
	};

	static CGPoint FoodPosInfo_4[] = {
	    CGPoint.ccp(267, 97), CGPoint.ccp(304, 108), CGPoint.ccp(335, 128), 
	    CGPoint.ccp(358, 154), CGPoint.ccp(378, 187), CGPoint.ccp(391, 218),
	    CGPoint.ccp(404, 251), CGPoint.ccp(414, 287), CGPoint.ccp(451, 287), 
	    CGPoint.ccp(486, 287), CGPoint.ccp(519, 287), CGPoint.ccp(533, 250), 
	    CGPoint.ccp(545, 218), CGPoint.ccp(559, 187), CGPoint.ccp(576, 153), 
	    CGPoint.ccp(500, 128), CGPoint.ccp(528, 107), CGPoint.ccp(563, 94), 
	    CGPoint.ccp(441, 250), CGPoint.ccp(494, 250), CGPoint.ccp(0, 0)
	};

	static CGPoint FoodPosInfo_5[] = {
	    CGPoint.ccp(292, 250), CGPoint.ccp(330, 250), CGPoint.ccp(365, 250), CGPoint.ccp(400, 250), CGPoint.ccp(435, 250), 
	    CGPoint.ccp(435, 217), CGPoint.ccp(435, 186), CGPoint.ccp(435, 154), CGPoint.ccp(435, 120), CGPoint.ccp(435, 86), 
	    CGPoint.ccp(395, 102), CGPoint.ccp(360, 124), CGPoint.ccp(335, 152), CGPoint.ccp(316, 184), CGPoint.ccp(302, 217), 
	    CGPoint.ccp(0, 0)
	}; 
}