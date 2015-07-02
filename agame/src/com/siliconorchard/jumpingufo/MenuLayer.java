package com.siliconorchard.jumpingufo;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.menus.CCMenuItemToggle;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabelAtlas;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import com.jindongfeng.scor.ScoreViewManager;


public class MenuLayer extends CCLayer {

	private float TOP_Y =  (25 * Common.kYForIPhone);
	private float TOP_X  = (38 * Common.kXForIPhone);
	private float ACH_X  = (96 * Common.kXForIPhone);

	private float SOUND_Y= (297 * Common.kYForIPhone);
	private float SOUND_X= (25 * Common.kXForIPhone);
	private float COIN_X = (405 * Common.kXForIPhone);
	private float LEAF_X = (144 * Common.kXForIPhone);
	private float LEAF_Y = (216 * Common.kYForIPhone);

	private float COIN_LABEL_X = (426 * Common.kXForIPhone);
	private float COIN_LABEL_Y = (288 * Common.kYForIPhone);
	private CCSprite back;
	private CCSprite land;
	private CCSprite index_leaf;
	private CCMenuItemImage topMenuItem;
//	private CCMenuItemImage AchieveMenuItem;
	private CCMenuItemImage soundOnMenuItem;
	private CCMenuItemImage soundOffMenuItem;
	private CCMenuItemToggle soundMenuItem;
	private CCMenuItemImage playMenuItem;
	private CCSprite coinSprite;
	private CCLabelAtlas coinLabel;
	
	public MenuLayer() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init() {
        back = CCSprite.sprite("bga0.png");
        back.setScaleX(Common.kXForIPhone);
        back.setScaleY(Common.kYForIPhone);
        back.setPosition(Common.SCREEN_WIDTH / 2, Common.SCREEN_HEIGHT / 2);
        addChild(back, Common.ztag_In_camera.ztag_min);
        
        land = CCSprite.sprite("bga_land.png");
        land.setScaleX(Common.kXForIPhone);
        land.setScaleY(Common.kYForIPhone);
        land.setPosition(Common.SCREEN_WIDTH / 2, land.getContentSize().height / 2 * Common.kYForIPhone);
        addChild(land, Common.ztag_In_camera.ztag_min);
        
        index_leaf = CCSprite.sprite("index_leaf.png");
        index_leaf.setScaleX(Common.kXForIPhone);
        index_leaf.setScaleY(Common.kYForIPhone);
        index_leaf.setPosition(LEAF_X, LEAF_Y);
        addChild(index_leaf, Common.ztag_In_camera.ztag_menu);
                
        topMenuItem = CCMenuItemImage.item("top.png", "top.png", this, "onTop");
        topMenuItem.setScale(Common.kXForIPhone);
        topMenuItem.setPosition(TOP_X, TOP_Y);
      
        CCSprite tempSprite = (CCSprite) topMenuItem.getSelectedImage();
        tempSprite.setScale(1.1f);
        
        soundOnMenuItem = CCMenuItemImage.item("sound_on.png", "sound_on.png");
        soundOffMenuItem = CCMenuItemImage.item("sound_off.png", "sound_off.png");
        soundMenuItem = CCMenuItemToggle.item(this, "onSound", soundOnMenuItem, soundOffMenuItem);
        soundMenuItem.setScaleX(Common.kXForIPhone);
        soundMenuItem.setScaleY(Common.kYForIPhone);
        soundMenuItem.setPosition(SOUND_X, SOUND_Y);
        
        playMenuItem = CCMenuItemImage.item("play.png", "play.png", this, "onPlay");
        playMenuItem.setScaleX(Common.kXForIPhone);
        playMenuItem.setScaleY(Common.kYForIPhone);
        playMenuItem.setPosition(Common.SCREEN_WIDTH / 2, Common.SCREEN_HEIGHT / 2);
        
        tempSprite = (CCSprite) playMenuItem.getSelectedImage();
        tempSprite.setScaleX(1.1f);

        if (Common.g_soundMute == false) {
            soundMenuItem.setSelectedIndex(0);
        }
        else
            soundMenuItem.setSelectedIndex(1);

        CCMenu menu = CCMenu.menu(topMenuItem,  /*ShopMenuItem,
                        faceBookMenuItem, twitterMenuItem, moreMenuItem,*/ soundMenuItem, 
                        playMenuItem);//AchieveMenuItem ,
        menu.setPosition(CGPoint.zero());
        addChild(menu, Common.ztag_In_camera.ztag_menu);
        
        coinSprite = CCSprite.sprite("coin.png");
        coinSprite.setScaleX(Common.kXForIPhone);
        coinSprite.setScaleY(Common.kYForIPhone);
        coinSprite.setPosition(COIN_X, SOUND_Y);
        addChild(coinSprite, Common.ztag_In_camera.ztag_menu);
        
        coinLabel = CCLabelAtlas.label("0123456789", "num4.png", 18, 24, '0');
        String string = String.format("%d", Common.g_coinNum);
        coinLabel.setScaleX(Common.kXForIPhone);
        coinLabel.setScaleY(Common.kYForIPhone);
        coinLabel.setString(string);
        coinLabel.setPosition(COIN_LABEL_X, COIN_LABEL_Y);
        addChild(coinLabel, Common.ztag_In_camera.ztag_menu);
	}
	
	public void onTop( Object sender )
	{
		ScoreViewManager.showScoreView();
		/*
		CCScene scene = CCScene.node();
	 	scene.addChild(new ScoreLayer(), 1);
	 	CCDirector.sharedDirector().replaceScene(new CCFadeTransition(0.5f, scene));
	 	*/
	}

	public void onSound( Object sender )
	{
	    Common.g_soundMute = !Common.g_soundMute;
	    if( Common.g_soundMute ) MediaGlobal._shared().setMute(true);
	    else MediaGlobal._shared().setMute(false);
//	    Common.soundActive(Common.g_soundMute);

	}
	
	public void onPlay( Object sender )
	{
		CCScene scene = CCScene.node();
	 	scene.addChild(new GameLayer(), 1);
	 	CCDirector.sharedDirector().replaceScene(scene);
	}

	public void removeSprite( CCSprite sp )
	{
	    CCTexture2D tex = sp.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    sp.removeFromParentAndCleanup(true);
	}

	public void removeCache()
	{
	    removeSprite(back);
	    removeSprite(index_leaf);
	    removeSprite(coinSprite);
	    removeSprite(land);
	    CCTexture2D tex = coinLabel.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    coinLabel.removeFromParentAndCleanup(true);
	    
	    removeSprite((CCSprite)topMenuItem.getNormalImage());
	    removeSprite((CCSprite)topMenuItem.getSelectedImage());
	    topMenuItem.removeFromParentAndCleanup(true);
	    
//	    removeSprite((CCSprite)AchieveMenuItem.getNormalImage());
//	    removeSprite((CCSprite)AchieveMenuItem.getSelectedImage());
//	    AchieveMenuItem.removeFromParentAndCleanup(true);

	    removeSprite((CCSprite)playMenuItem.getNormalImage());
	    removeSprite((CCSprite)playMenuItem.getSelectedImage());
	    playMenuItem.removeFromParentAndCleanup(true);

	    removeSprite((CCSprite)soundOnMenuItem.getNormalImage());
	    removeSprite((CCSprite)soundOnMenuItem.getSelectedImage());
	    soundOnMenuItem.removeFromParentAndCleanup(true);

	    removeSprite((CCSprite)soundOffMenuItem.getNormalImage());
	    removeSprite((CCSprite)soundOffMenuItem.getSelectedImage());
	    soundOffMenuItem.removeFromParentAndCleanup(true);
	    
	}
	
//	public void onExit() {
//		removeCache();
//		super.onExit();
//	}
}
