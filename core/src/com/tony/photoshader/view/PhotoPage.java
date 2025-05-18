package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.asset.Asset;

public class PhotoPage extends Group {
    public PhotoPage() {
        setDebug(true);
        setSize(1080,1080);
        Image image = new Image(Asset.getAsset().getTexture("phtos/demo_0.jpg"));
        addActor(image);
        image.setOrigin(Align.center);
        float min = Math.max(image.getWidth() / getWidth(), image.getHeight() / getHeight());
        image.setScale(1.0f/min);
        image.setPosition(getWidth()/2f,getHeight()/2f, Align.center);
    }

    public void setShader() {

    }
}
