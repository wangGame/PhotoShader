package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.utils.Layer;

public class NavItem extends Group {
    private PhotoPage photoPage;
    private ShaderProgram program;
    public NavItem(PhotoPage photoPage){
        setSize(300,300);
        Image bgImg = Layer.getShadow();
        bgImg.setSize(getWidth(),getHeight());
        addActor(bgImg);

        setOrigin(Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                photoPage.setShader();
            }
        });
    }
}
