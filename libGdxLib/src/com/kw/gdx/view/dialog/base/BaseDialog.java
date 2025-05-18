package com.kw.gdx.view.dialog.base;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.constant.Configuration;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.resource.annotation.AnnotationInfo;
import com.kw.gdx.resource.annotation.ScreenResource;
import com.kw.gdx.sound.AudioProcess;
import com.kw.gdx.sound.AudioType;
import com.kw.gdx.besier.BseInterpolation;
import com.kw.gdx.resource.cocosload.CocosResource;
import com.kw.gdx.view.dialog.DialogManager;

/**
 * Console.WriteLine(dt.ToString("HH:mm:ss.fffffff"))
 */
public class BaseDialog extends Group {
    protected DialogManager dialogManager;
    protected Group dialogGroup;
    protected DialogManager.Type type = DialogManager.Type.closeOldShowCurr;
    protected float offsetX;
    protected float offsetY;
    protected float shadowTime = 0.1667F;
    protected boolean playOpenAudio = false;
    protected String openMusic = AudioType.click;
    protected boolean playCloseAudio = false;
    protected String closeMusic = AudioType.click;
    protected Vector2 dialogSize = new Vector2();
    protected boolean backClose;
    protected float dialogShadowA = 0.85f;
    protected boolean isFont;
    protected String viewpath;
    protected Actor closeBg;
    protected boolean entered = false;
    protected boolean closeFlag = false;
    protected boolean closed;
    /**
     * 立即执行，把等弹窗打开就可以直接关闭
     */
    protected boolean executeImmediately;

    public void setFont(boolean font) {
        isFont = font;
    }

    public boolean isFont() {
        return isFont;
    }

    public boolean isBackClose() {
        return backClose;
    }

    public float getShadowTime() {
        return shadowTime;
    }

    public BaseDialog(){

        ScreenResource annotation = AnnotationInfo.checkClassAnnotation(this, ScreenResource.class);
        closeBg = new Actor();

        if (annotation!=null){
            viewpath = annotation.value();
            if (useTemp()) {
                viewpath = annotation.tempV();
            }
            dialogGroup = CocosResource.loadFile(viewpath);
        }else {
            dialogGroup = new Group();
            dialogGroup.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        }
        dialogSize.set(dialogGroup.getWidth(),dialogGroup.getHeight());
        setSize(dialogSize.x,dialogSize.y);
        closeBg.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        closeBg.setPosition(dialogSize.x/2.0f,dialogSize.y/2.0f,Align.center);
        addActor(closeBg);
        addActor(dialogGroup);
        setY(Constant.GAMEHIGHT/2, Align.center);
        setX(Constant.GAMEWIDTH/2,Align.center);
        offsetX = (Constant.GAMEWIDTH - Constant.WIDTH)/2;
        offsetY = (Constant.GAMEHIGHT - Constant.HIGHT) / 2;



        closeBg.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                closeFlag = true;
                if (entered){
                    closeDialog();
                }
            }
        });
    }

    protected boolean useTemp() {
        return false;
    }

    public void close(){
        dialogGroup.setOrigin(Align.center);
        playCloseAudio();
        dialogGroup.addAction(
                Actions.parallel(
                    Actions.sequence(
                        Actions.scaleTo(0.074F,0.074F,0.2667F * timeScale,
                                new BseInterpolation(0.25f,0,1,1)),
                        Actions.run(()->{
                            removeBefore();
                            remove();
                        })
                    ), Actions.sequence(Actions.alpha(0,0.2333F * timeScale))
                )
        );
    }

    protected void removeBefore(){

    }

    protected void playOpenAudio(){
        if (playOpenAudio){
            AudioProcess.playSound(openMusic);
        }
    }

    protected void playCloseAudio(){
        if (playCloseAudio){
            AudioProcess.playSound(closeMusic);
        }
    }

    public DialogManager.Type getType() {
        return type;
    }

    protected void initView(){}

    public void show() {
        playOpenAudio();
        initView();
        setOrigin(Align.center);
        enterAnimation();
    }

    protected float timeScale =0.7f;
    public void setAphlaZero(){
        dialogGroup.getColor().a = 0;
    }
    public void enterAnimation() {
        setAphlaZero();
        dialogGroup.setOrigin(Align.center);
        dialogGroup.addAction(Actions.parallel(
                Actions.sequence(
                        Actions.alpha(0,0),
                        Actions.alpha(1,0.1667F * timeScale),
                        Actions.run(()->{
                            //打开了
                            entered = true;
                            if (closeFlag) {
                                enterMethod();
                            }
                        })
                ), Actions.sequence(
                        Actions.scaleTo(0.074F,0.074F,0),
                        Actions.scaleTo(1.03F,1.03F,0.3333F * timeScale,
                                new BseInterpolation(0F,0F,0.75F,1.0F)),
                        Actions.scaleTo(1.0F,1.0F, 0.16667F *timeScale,
                                new BseInterpolation(0,0,1,0.99f)))

        ));
    }

    protected void enterMethod() {
        closeDialog();
    }

    public void hide() {
        addAction(Actions.scaleTo(0,0,0.2F));
    }

    protected boolean showShadow = true;

    public boolean isShadow() {
        return showShadow;
    }

    public void other() {

    }

    public void setType(DialogManager.Type type) {
        this.type = type;
    }

    public int shadowCloseType = 0;

    public void setShadowCloseType(int shadowCloseType) {
        this.shadowCloseType = shadowCloseType;
    }

    public int getShadowCloseType() {
        return shadowCloseType;
    }

    public void extendsMethod(){

    }

    public void setDialogManager(DialogManager dialogManager) {
        this.dialogManager = dialogManager;
    }

    public void closeDialog(){
        if (closed)return;
        closed = true;
        dialogManager.closeDialog(this);
    }

    public float getA() {
        return dialogShadowA;
    }

    public void touchDisable(){
        setTouchable(Touchable.disabled);
    }

    public void touchEnable(){
        setTouchable(Touchable.childrenOnly);
    }

    public void resize(float width, float height) {
        setY(Constant.GAMEHIGHT/2, Align.center);
        setX(Constant.GAMEWIDTH/2,Align.center);
    }


    public void closeDialog(Actor actor) {
        actor.setTouchable(Touchable.enabled);
        actor.setOrigin(Align.center);
        actor.clearListeners();
        actor.addListener(new OrdinaryButtonListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                actor.setTouchable(Touchable.disabled);
                closeDialog();
            }
        });
    }

    protected void hideRootView() {
        ScreenResource annotation = AnnotationInfo.checkClassAnnotation(this, ScreenResource.class);
        if (annotation!=null){
            viewpath = annotation.value();
            if (Configuration.device_state == Configuration.DeviceState.good) {
                CocosResource.unLoadFile(viewpath);
            }
        }
    }

    public Group getDialogGroup() {
        return dialogGroup;
    }


    protected void btnAddListener(Actor closeBtn,Runnable runnable) {
        closeBtn.setOrigin(Align.center);
        closeBtn.setTouchable(Touchable.enabled);
        closeBtn.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                runnable.run();
            }
        });
    }


}
