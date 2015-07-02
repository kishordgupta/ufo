package com.siliconorchard.jumpingufo;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.transitions.CCFadeTransition;

import com.siliconorchard.jumpingufo.R;


public class HelloWorldLayer extends CCLayer {

	private CCSprite back;

	public HelloWorldLayer() {
		init();
	}
	
//	@Override
//	public void onExit() {
//		removeCache();
//		removeAllChildren(true);
//		unscheduleAllSelectors();
//		super.onExit();
//	}
    	
	private void init() {
        back = CCSprite.sprite("loading.png");
        back.setScaleX(Common.kXForIPhone);
        back.setScaleY(Common.kYForIPhone);
        back.setPosition(Common.SCREEN_WIDTH / 2, Common.SCREEN_HEIGHT / 2);
        addChild(back, 1);
        MediaGlobal._shared().playMusic(R.raw.gamebg, true);//jinjin
        schedule("selUpdateLayer", 2.0f);
    }

	public void selUpdateLayer( float dt )
	{
        unschedule("selUpdateLayer");
		CCScene scene = CCScene.node();
	 	scene.addChild(new MenuLayer(), 1);
	 	CCDirector.sharedDirector().replaceScene(new CCFadeTransition(3.0f, scene));
//	 	CCDirector.sharedDirector().replaceScene(scene);
	}

	private void removeSprite( CCSprite sp )
	{
	    CCTexture2D tex = sp.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    sp.removeFromParentAndCleanup(true);
	}

	private void removeCache()
	{
	    removeSprite(back);
	}
}
