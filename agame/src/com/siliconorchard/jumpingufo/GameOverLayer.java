package com.siliconorchard.jumpingufo;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCLabelAtlas;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;

public class GameOverLayer extends CCLayer {

	public final float GAMEOVER_ALLLENGHT_X   = (81 * Common.kXForIPhone);
	public final float GAMEOVER_ALLLENGHT_Y   = (188 * Common.kYForIPhone);
	public final float GAMEOVER_PLAYERNAME_X  = (290 * Common.kXForIPhone);
	public final float GAMEOVER_PLAYERNAME_Y  = (98 * Common.kYForIPhone);
	public final float GAMEOVER_RANK_X        = (210 * Common.kXForIPhone);
	public final float GAMEOVER_RANK_Y        = (175 * Common.kYForIPhone);
	public final float GAMEOVER_RANK_LABEL_X  = (237 * Common.kXForIPhone);
	public final float GAMEOVER_RANK_LABEL_Y  = (163 * Common.kYForIPhone);
	public final float GAMEOVER_SUN_X         = (106 * Common.kXForIPhone);
	public final float GAMEOVER_SUN_Y         = (140 * Common.kYForIPhone);
	public final float GAMEOVER_SUN_LABEL_X   = (137 * Common.kXForIPhone);
	public final float GAMEOVER_SUN_LABEL_Y   = (121 * Common.kYForIPhone);
	public final float GAMEOVER_COIN_X        = (104 * Common.kXForIPhone);
	public final float GAMEOVER_COIN_Y        = (97 * Common.kYForIPhone);
	public final float GAMEOVER_COIN_LABEL_X  = (137 * Common.kXForIPhone);
	public final float GAMEOVER_COIN_LABEL_Y  = (85 * Common.kYForIPhone);
	public final float GAMEOVER_TXT_X         = (340 * Common.kXForIPhone);
	public final float GAMEOVER_TXT_Y         = (158 * Common.kYForIPhone);
	public final float GAMEOVER_TXT_DISTANCE_X= (353 * Common.kXForIPhone);
	public final float GAMEOVER_TXT_DISTANCE_Y= (188 * Common.kYForIPhone);
	public final float GAMEOVER_TXT_TIME_X    = (326 * Common.kXForIPhone);
	public final float GAMEOVER_TXT_TIME_Y    = (169 * Common.kYForIPhone);
	public final float GAMEOVER_TXT_BIRD_X    = (362 * Common.kXForIPhone);
	public final float GAMEOVER_TXT_BIRD_Y    = (152 * Common.kYForIPhone);
	public final float GAMEOVER_TXT_TOTAL_X   = (388 * Common.kXForIPhone);
	public final float GAMEOVER_TXT_TOTAL_Y   = (131 * Common.kYForIPhone);
	public final float GAMEOVER_TXT_SPEED_X   = (341 * Common.kXForIPhone);
	public final float GAMEOVER_TXT_SPEED_Y   = (112 * Common.kYForIPhone);
	public final float GAMEOVER_RETRY_X       = (170 * Common.kXForIPhone);
	public final float GAMEOVER_RETRY_Y       = (43 * Common.kYForIPhone);
	public final float GAMEOVER_MENU_X        = (330 * Common.kXForIPhone);
	public final float GAMEOVER_MENU_Y        = (43 * Common.kYForIPhone);

	private CCSprite background;
	private CCSprite gameOver;
	private CCLabelAtlas lblAllLength;
	private CCSprite sunCount;
	private CCSprite coinSprite;
	private CCLabelAtlas lblSunCount;
	private CCLabelAtlas lblCoinCount;
	private CCSprite txtSprite;
	private CCLabel lblDistance;
	private CCLabel lblTime;
	private CCLabel lblBirdsHits;
	private CCLabel lblTotalDistance;
	private CCLabel lblSpeed;
	private CCSprite rankSprite;
	private CCLabelAtlas lblLank;
	public CCMenuItemImage retry;
	public CCMenuItemImage menu;

	public GameOverLayer() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
        background = CCSprite.sprite("alphaBlack.png");
        background.setScaleX(Common.kXForIPhone);
        background.setScaleY(Common.kYForIPhone);
        background.setPosition(Common.SCREEN_WIDTH / 2, Common.SCREEN_HEIGHT / 2);
        addChild(background, 0);
        
        gameOver = CCSprite.sprite("gameover.png");
        gameOver.setScale(Common.kXForIPhone);
        gameOver.setScaleY(Common.kYForIPhone);
        gameOver.setPosition(Common.SCREEN_WIDTH / 2, Common.SCREEN_HEIGHT - gameOver.getContentSize().height / 2 * Common.kYForIPhone);
        addChild(gameOver, 0);
        
        lblAllLength = CCLabelAtlas.label("0123456789", "num1.png", 33, 42, '0');
        lblAllLength.setScale(Common.kXForIPhone);
        lblAllLength.setPosition(GAMEOVER_ALLLENGHT_X, GAMEOVER_ALLLENGHT_Y);
        lblAllLength.setString("0");
        addChild(lblAllLength, 0);
        
//        playerName =  UITextField alloc initWithFrame:CGRectMake(GAMEOVER_PLAYERNAME_X, GAMEOVER_PLAYERNAME_Y, 100 * Common.kXForIPhone, 20 * Common.kYForIPhone);
//        playerName.font = UIFont fontWithName:"Arial" size:15 * Common.kYForIPhone;
//        playerName.textColor = UIColor whiteColor;
//        playerName.backgroundColor = UIColor clearColor;
//        playerName setEnabled:YES;
//        
//        
//        UIView* glView = CCDirector sharedDirector openGLView;
//        glView addSubview:playerName; 
//        AppDelegate* delegate = AppDelegate sharedDelegate;
//        
//        playerName setDelegate:delegate;
//        playerName release;
        
        sunCount = CCSprite.sprite("oversun.png");
        sunCount.setScale(Common.kXForIPhone);
        sunCount.setPosition(GAMEOVER_SUN_X, GAMEOVER_SUN_Y);
        addChild(sunCount, 0);
        
        coinSprite = CCSprite.sprite("coin.png");
        coinSprite.setScale(Common.kXForIPhone);
        coinSprite.setPosition(GAMEOVER_COIN_X, GAMEOVER_COIN_Y);
        addChild(coinSprite, 0);
        
        lblSunCount = CCLabelAtlas.label("0123456789", "num2.png", 23, 33, '0');
        lblSunCount.setScale(Common.kXForIPhone);
        lblSunCount.setPosition(GAMEOVER_SUN_LABEL_X, GAMEOVER_SUN_LABEL_Y);
        lblSunCount.setString("0");
        addChild(lblSunCount, 0);
        
        lblCoinCount = CCLabelAtlas.label("0123456789", "num6.png", 18, 23, '0');
        lblCoinCount.setScale(Common.kXForIPhone);
        lblCoinCount.setPosition(GAMEOVER_COIN_LABEL_X, GAMEOVER_COIN_LABEL_Y);
        lblCoinCount.setString("0");
        addChild(lblCoinCount, 0);
        
        txtSprite = CCSprite.sprite("txt.png");
        txtSprite.setScaleX(Common.kXForIPhone);
        txtSprite.setScaleY(Common.kYForIPhone);
        txtSprite.setPosition(GAMEOVER_TXT_X, GAMEOVER_TXT_Y);
        addChild(txtSprite, 0);
        
//        lblDistance = CCLabelAtlas.label("0123456789", "num5.png", 9, 13, '0');
        lblDistance = CCLabel.makeLabel(" ", "Arial", 13);
        lblDistance.setScale(Common.kXForIPhone);
        lblDistance.setAnchorPoint(0, 0);
        lblDistance.setPosition(GAMEOVER_TXT_DISTANCE_X, GAMEOVER_TXT_DISTANCE_Y);
        lblDistance.setString(String.format("%d", 0));
        addChild(lblDistance, 0);
        
//        lblTime = CCLabelAtlas.label("0123456789", "num5.png", 9, 13, '0');
        lblTime = CCLabel.makeLabel(" ", "Arial", 13);
        lblTime.setScale(Common.kXForIPhone);
        lblTime.setAnchorPoint(0, 0);
        lblTime.setPosition(GAMEOVER_TXT_TIME_X, GAMEOVER_TXT_TIME_Y);
        lblTime.setString(String.format("%d", 0));
        addChild(lblTime, 0);
        
//        lblBirdsHits = CCLabelAtlas.label("0123456789", "num5.png", 9, 13, '0');
        lblBirdsHits = CCLabel.makeLabel(" ", "Arial", 13);
        lblBirdsHits.setScale(Common.kXForIPhone);
        lblBirdsHits.setAnchorPoint(0, 0);
        lblBirdsHits.setPosition(GAMEOVER_TXT_BIRD_X, GAMEOVER_TXT_BIRD_Y);
        lblBirdsHits.setString(String.format("%d", 0));
        addChild(lblBirdsHits, 0);
        
//        lblTotalDistance = CCLabelAtlas.label("0123456789", "num5.png", 9, 13, '0');
        lblTotalDistance = CCLabel.makeLabel(" ", "Arial", 13);
        lblTotalDistance.setScale(Common.kXForIPhone);
        lblTotalDistance.setAnchorPoint(0, 0);
        lblTotalDistance.setPosition(GAMEOVER_TXT_TOTAL_X, GAMEOVER_TXT_TOTAL_Y);
        lblTotalDistance.setString(String.format("%.01f", 0.0f));
        addChild(lblTotalDistance, 0);
        
//        lblSpeed = CCLabelAtlas.label("0123456789", "num5.png", 9, 13, '0');
        lblSpeed = CCLabel.makeLabel(" ", "Arial", 13);
        lblSpeed.setScale(Common.kXForIPhone);
        lblSpeed.setAnchorPoint(0, 0);
        lblSpeed.setPosition(GAMEOVER_TXT_SPEED_X, GAMEOVER_TXT_SPEED_Y);
        lblSpeed.setString(String.format("%d", 0));
        addChild(lblSpeed, 0);
        
        rankSprite = CCSprite.sprite("rank.png");
        rankSprite.setScale(Common.kXForIPhone);
        rankSprite.setPosition(GAMEOVER_RANK_X, GAMEOVER_RANK_Y);
        addChild(rankSprite, 0);
        
        lblLank = CCLabelAtlas.label("0123456789", "num6.png", 18, 23, '0');
        lblLank.setScale(Common.kXForIPhone);
        lblLank.setPosition(GAMEOVER_RANK_LABEL_X, GAMEOVER_RANK_LABEL_Y);
        lblLank.setString(String.format("0", 0));
        addChild(lblLank, 0);
        
        retry = CCMenuItemImage.item("retry.png", "retry.png", this, "onRetry");
        retry.setScale(Common.kXForIPhone);
        retry.setPosition(GAMEOVER_RETRY_X, GAMEOVER_RETRY_Y);
        retry.setVisible(false);
        
        menu = CCMenuItemImage.item("menu.png", "menu.png", this, "onMenu");
        menu.setScale(Common.kXForIPhone);
        menu.setPosition(GAMEOVER_MENU_X, GAMEOVER_MENU_Y);
        menu.setVisible(false);
        
        CCMenu menus = CCMenu.menu(retry, menu);
        menus.setPosition(0, 0);
        addChild(menus, 0);
	}

	public void updateLabels()
	{
	    GameLayer gameLayer = (GameLayer)this.parent_;
	    
	    String string = String.format("%d", gameLayer.player.flayLength / 3);
	    lblAllLength.setString(string);
	    
	    string = String.format("%d", gameLayer.player.sunCount);
	    lblSunCount.setString(string);
	    
	    string = String.format("%d", gameLayer.player.coinCount);
	    lblCoinCount.setString(string);
	    
//	    playerName setText:gameLayer.player.playerName;

	    string = String.format("%d m", gameLayer.player.flayLength / 3);
	    lblDistance.setString(string);
	    
	    string = String.format("%d s", (int)(gameLayer.player.endTime - gameLayer.player.startTime));
	    lblTime.setString(string);
	    
	    string = String.format("%d", gameLayer.player.birdCount);
	    lblBirdsHits.setString(string);
	    
	    string = String.format("%.01f km", gameLayer.player.totalDistance / 1000);
	    lblTotalDistance.setString(string);
	    
	    string = String.format("%.03f m/s", (float)gameLayer.player.flayLength / 3 / (gameLayer.player.endTime - gameLayer.player.startTime));
	    lblSpeed.setString(string);
	    
	    string = String.format("%d", gameLayer.player.rank + 1);
	    lblLank.setString(string);
	    
	}

	public void onRetry( Object sender )
	{
	    GameLayer gameLayer = (GameLayer)this.parent_;
	    
	    Common.g_coinNum += gameLayer.player.coinCount;

	    retry.setVisible(false);
	    menu.setVisible(false);
//	    playerName setHidden:YES;
	    
//	    gameLayer.player.playerName = playerName.text;
	    
	    gameLayer.player.saveUserInfo();

	    gameLayer.onRetry(sender);
	}
	
	public void onMenu( Object sender )
	{
	    GameLayer gameLayer = (GameLayer)this.parent_;
	    
//	    gameLayer.player.playerName = playerName.text;
//	    playerName setHidden:YES;
	    
	    gameLayer.player.saveUserInfo();

	    gameLayer.onMenu(sender);
	}

	private void removeSprite( CCSprite sp )
	{
	    CCTexture2D tex = sp.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    sp.removeFromParentAndCleanup(true);
	}

	private void removeCache()
	{
	    removeSprite(background);
	    removeSprite(gameOver);
	    removeSprite(sunCount);
	    removeSprite(coinSprite);
	    removeSprite(txtSprite);
	    removeSprite(rankSprite);
	    
	    CCTexture2D tex = lblAllLength.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    lblAllLength.removeFromParentAndCleanup(true);
	    
	    tex = lblSunCount.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    lblSunCount.removeFromParentAndCleanup(true);

	    tex = lblCoinCount.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    lblCoinCount.removeFromParentAndCleanup(true);

	    tex = lblLank.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    lblLank.removeFromParentAndCleanup(true);

	    removeSprite((CCSprite)retry.getNormalImage());
	    removeSprite((CCSprite)retry.getSelectedImage());
	    retry.removeFromParentAndCleanup(true);

	    removeSprite((CCSprite)menu.getNormalImage());
	    removeSprite((CCSprite)menu.getSelectedImage());
	    menu.removeFromParentAndCleanup(true);

	}
	
	public void onExit() {
		removeCache();
		super.onExit();
	}
}
