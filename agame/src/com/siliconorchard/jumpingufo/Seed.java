package com.siliconorchard.jumpingufo;

import java.util.Date;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCIntervalAction;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCSpriteSheet;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGSize;

import com.siliconorchard.jumpingufo.R;
import com.siliconorchard.jumpingufo.Common.PlayerInfo;

import android.graphics.Bitmap;

public class Seed extends CCSprite {

	enum DirectState {
	    DirectState_up,
	    DirectState_down
	};

	public final long EFFECT_TIME = 1000;
	public final float FAST_VEL  =  (50 * Common.kXForIPhone);

	public static final int SeedState_start = -1;
	public static final int SeedState_none = 0;
	public static final int SeedState_rainbow = 1;
	public static final int SeedState_fast = 2;
	public static final int SeedState_fail = 3;
	public static final int SeedState_protect = 4;
	
	public static final float GRAVITY = (-400 * Common.kYForIPhone);
	 
	public CCSprite life;
	public CCSprite face;
	public CCSprite tail;
	public CGPoint velocity;
	public String playerName;
	public int coinCount;
	public float totalDistance;
	public DirectState stateDirect;
	public int state;
	public long startTime_fast = 0;
	public int flayLength;
	public long startTime_rainbow = 0;
	public long startTime_protect = 0;
	public int sleepUp = 0;
	public int sleepDown = 0;
	public float realHeight;
	public int rank;
	public int birdCount;
	public int sunCount;
	public float endTime = 0.0f;
	public float startTime = 0.0f;

	public Seed(CCTexture2D texture) {
		super(texture);
		// TODO Auto-generated constructor stub
	}

	public Seed(CCTexture2D texture, CGRect rect) {
		super(texture, rect);
		// TODO Auto-generated constructor stub
	}

	public Seed(CCSpriteFrame spriteFrame) {
		super(spriteFrame);
		// TODO Auto-generated constructor stub
	}

	public Seed(String spriteFrameName, boolean isFrame) {
		super(spriteFrameName, isFrame);
		// TODO Auto-generated constructor stub
	}

	public Seed(String filepath) {
		super(filepath);
		// TODO Auto-generated constructor stub
	}

	private static Seed _seed = null;
	public static Seed initSeed() {
		// TODO Auto-generated constructor stub
		_seed = new Seed("ufo_pastel.png");
        
		_seed.setScaleX(Common.kXForIPhone * 0.5f);
		_seed.setScaleY(Common.kXForIPhone * 0.5f);

		_seed.life = CCSprite.sprite("hero_leaf.png", CGRect.make(0, 0, 56, 43));
		_seed.life.setPosition(_seed.getContentSize().width / 2, _seed.getContentSize().height);
		_seed.addChild(_seed.life);
        
        _seed.face = CCSprite.sprite("hero.png", CGRect.make(0, 0, 55, 54));
        _seed.face.setPosition(_seed.getContentSize().width / 2, _seed.getContentSize().height / 2);
    //    _seed.addChild(_seed.face);
        
        _seed.tail = CCSprite.sprite("tear1.png");
        _seed.tail.setAnchorPoint(1f, 0.5f);
        _seed.tail.setPosition(_seed.getContentSize().width / 2, _seed.getContentSize().height / 2);
        _seed.tail.setScaleX(0.1f);
        _seed.tail.setScaleY(0.5f);
       // _seed.addChild(_seed.tail, -1);

        _seed.velocity = CGPoint.ccp(0, 0);
        _seed.playerName = Common.g_gamePlayerInfo.name;
        _seed.coinCount = Common.g_gamePlayerInfo.coinCount;
        _seed.totalDistance = Common.g_gamePlayerInfo.totalDistance;
        _seed.stateDirect = DirectState.DirectState_down;
        _seed.state = SeedState_none;
        
        return _seed;
	}

	public Seed(String filepath, CGRect rect) {
		super(filepath, rect);
		// TODO Auto-generated constructor stub
	}

	public Seed(Bitmap image, String key) {
		super(image, key);
		// TODO Auto-generated constructor stub
	}

	public Seed(CCSpriteSheet spritesheet, CGRect rect) {
		super(spritesheet, rect);
		// TODO Auto-generated constructor stub
	}

	public CGRect rect()
	{
		CGSize s = this.getTexture().getContentSize();
		CGRect rt = CGRect.make(-s.width * getScaleX() / 2 + getPosition().x,
							   -s.height * getScaleY() / 2 + getPosition().y, 
							   s.width * getScaleX(), 
							   s.height * getScaleY());
		return rt;
	}
	
	public void move(float delta)
	{
	    GameLayer gameLayer = (GameLayer)this.parent_;

//	    NSTimeInterval curTime = [NSDate timeIntervalSinceReferenceDate];
	    long curTime = new Date().getTime();
	    
	    switch (state) {
	        case SeedState_fast:
	        {
	            if (curTime - startTime_fast > EFFECT_TIME) {
	                state = SeedState_none;
	                face.stopAllActions();
	                face.runAction(CCRepeatForever.action((CCIntervalAction) Common.ani_seed_face_none.copy()));
	                life.stopAllActions();

	            }
	            else
	            {
	                setPosition(Common.SCREEN_WIDTH / 3, Common.SCREEN_HEIGHT * 2 / 3);
	                gameLayer.moveLayer.bodysMove(-FAST_VEL);
	                gameLayer.moveLayer.foodsMove(-FAST_VEL);
	                gameLayer.moveLayer.birdsMove(-FAST_VEL);
	                gameLayer.dotMove(-FAST_VEL);
	                
	                tail.setRotation(0);
	                tail.setScaleX(6.0f);
	                
	                flayLength += (int)FAST_VEL;
	                return;

	            }
	            break;
	        }
	        case SeedState_rainbow:
	            if (curTime - startTime_rainbow > EFFECT_TIME) {
	                state = SeedState_none;
	                face.stopAllActions();
	                face.runAction(CCRepeatForever.action((CCIntervalAction) Common.ani_seed_face_none.copy()));
	            }

	            break;
	        case SeedState_protect:
	            if (curTime - startTime_protect > EFFECT_TIME) {
	                state = SeedState_none;
	                face.stopAllActions();
	                face.runAction(CCRepeatForever.action((CCIntervalAction) Common.ani_seed_face_none.copy()));
	            }

	            break;
	  
	        default:
	            break;
	    }
	    

	    velocity.y = velocity.y + GRAVITY * delta;
	    
	    float velLength = CGPoint.ccpLength(velocity);
	    float alpha = (float) Math.atan2(velocity.y, velocity.x );
	    alpha = (float) (alpha * 180 / Math.PI);

	    
	    tail.setRotation(-alpha);
	    tail.setScaleX(velLength / 150);
	    
	    if (velocity.y > 0 ) {
	        if (stateDirect == DirectState.DirectState_down) {
	            stateDirect = DirectState.DirectState_up;
	            life.stopAllActions();
	            life.runAction(Common.ani_seed_leaf_up.copy());
	            
	            sleepUp  = 0;
	        }
	    }
	    else
	    {
	        if (stateDirect == DirectState.DirectState_up) {
	            stateDirect = DirectState.DirectState_down;
	            life.stopAllActions();
	            life.runAction(Common.ani_seed_leaf_down.copy());
	            
	            sleepDown  = 0;
	        }
	    }
	    
	    if (gameLayer.tipNum < 0) {
	        realHeight = realHeight + velocity.y * delta * 2;
	    }
	    else
	    {
	        realHeight = realHeight + velocity.y * delta;

	    }
	    
	    if (realHeight > Common.SCREEN_HEIGHT / 3 * 2) {
	        
	        gameLayer.cameraMove();
	        
	    }
	    else if (realHeight <= -20)
	    {
	        gameLayer.gameOver();
	    }
	    else
	    {
	        if (gameLayer.tipNum < 0) {
	            setPosition(CGPoint.ccpAdd(getPosition(), CGPoint.ccp(0, velocity.y * delta * 2)));
	        }
	        else
	        {
	            setPosition(CGPoint.ccpAdd(getPosition(), CGPoint.ccp(0, velocity.y * delta)));
	        }
	        
	        realHeight = getPosition().y;
	    }
	    
	    float moveDelta_X = velocity.x * delta;
	    
	    if (moveDelta_X > 0) {
	        if (getPosition().x > Common.SCREEN_WIDTH / 3) {
	            gameLayer.moveLayer.bodysMove(-moveDelta_X);
	            gameLayer.moveLayer.foodsMove(-moveDelta_X);
	            gameLayer.moveLayer.birdsMove(-moveDelta_X);
	            gameLayer.dotMove(-moveDelta_X);
	            gameLayer.tutorialMove(-moveDelta_X);
	            
	            flayLength += (int)moveDelta_X;

	            alpha = (float) (alpha * 180 / Math.PI);
	        }
	        else
	        {
	            setPosition(CGPoint.ccpAdd(getPosition(), CGPoint.ccp(moveDelta_X, 0)));
	            flayLength += (int)moveDelta_X;
	        }
	    }
	    else
	    {
	        setPosition(CGPoint.ccpAdd(getPosition(), CGPoint.ccp(moveDelta_X, 0)));
	        
	        flayLength += (int)moveDelta_X;
	        
	        if (getPosition().x < 0) {
	            velocity = CGPoint.ccp( -velocity.x, velocity.y);
	        }
	    }
	    
	}

	public void calcRank()
	{
	    for (int i = 0; i < 20; i ++) {
	        PlayerInfo playerInfo = Common.gameInfo.get(i);
	        if (flayLength / 3 > playerInfo.score) {
	            rank = i;
	            return;
	        }
	    }
	    rank = 20;
	}

	public void saveUserInfo()
	{
	    for (int i = 0; i < 20; i ++) {
	        if (rank <= i) {
	            Common.gameInfo.remove(Common.gameInfo.size()-1);

	            PlayerInfo newPlayer = new PlayerInfo();
	            newPlayer.rankNum = rank;
	            newPlayer.name = playerName;
	            newPlayer.score = flayLength / 3;
	            
	            Common.gameInfo.add(i, newPlayer);
	            break;
	        }
	    }
	    
	    Common.g_gamePlayerInfo.coinCount = Common.g_coinNum;
	    Common.g_gamePlayerInfo.name = playerName;
	    Common.g_gamePlayerInfo.totalDistance = totalDistance;
	    
	    Common.saveGameInfo();
	}

	public void collisionWithBomb()
	{
	    if (state == SeedState_protect || state == SeedState_fast) {
	        return;
	    }
//	    bomb.play(); sound
	    Common.effectPlay(R.raw.bomb);
	    tail.setVisible(false);
	    
	    state = SeedState_fail;
	    face.stopAllActions();
	    face.runAction(Common.ani_seed_face_fail.copy());
	    velocity = CGPoint.ccp(0, 0);
	};

	public void collisionWithProtect()
	{
	    birdCount ++;
//	    [bounce play]; sound
	    Common.effectPlay(R.raw.bounce);
	    tail.setVisible(false);
	    
	    if (state == SeedState_fast) {
	        return;
	    }
	   
	    state = SeedState_protect;
	    startTime_protect = new Date().getTime();
//	    startTime_protect = 0;
//	    startTime_protect = [NSDate timeIntervalSinceReferenceDate];
	};

	public void collisionWithRainbow()
	{
//	    [bounce play];
	    tail.setVisible(true);
	    
	    if (state == SeedState_fast) {
	        return;
	    }
	    
	    state = SeedState_rainbow;
	    startTime_rainbow = new Date().getTime();
//	    startTime_rainbow = 0;
//	    startTime_rainbow = [NSDate timeIntervalSinceReferenceDate];
	    face.stopAllActions();
	    face.runAction(CCRepeatForever.action((CCIntervalAction) Common.ani_seed_face_rainbow.copy()));
	};

	public void collisionWithFast()
	{
	    birdCount ++;
	    
	    GameLayer gameLayer = (GameLayer )this.parent_;
//	    [fly play]; sound
	    Common.effectPlay(R.raw.fly);
	    tail.setVisible(true);
	    
	    gameLayer.streak.setVisible(true);
	    gameLayer.streak.setRotation(0);
	    
	    state = SeedState_fast;
//	    startTime_fast = 0;
//	    startTime_fast = [NSDate timeIntervalSinceReferenceDate];
	    startTime_fast = new Date().getTime();
	    face.stopAllActions();
	    face.runAction(CCRepeatForever.action((CCIntervalAction) Common.ani_seed_face_fast.copy()));
	    life.stopAllActions();
	    life.runAction(CCRepeatForever.action((CCIntervalAction) Common.ani_seed_leaf_fast.copy()));
	};

	private void removeSprite( CCSprite sp )
	{
	    CCTexture2D tex = sp.getTexture();
	    CCTextureCache.sharedTextureCache().removeTexture(tex);
	    sp.removeFromParentAndCleanup(true);
	}

	private void removeCache()
	{
	    life.stopAllActions();
	    removeSprite(life);
	    
	    face.stopAllActions();
	    removeSprite(face);
	    
	    CCTextureCache.sharedTextureCache().removeTexture("hero_leaf.png");
	}
	
	public void onExit() {
		removeCache();
		super.onExit();
	}
}
