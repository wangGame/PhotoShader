package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.utils.Layer;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.shader.ShaderType;
import com.tony.photoshader.shader.ShaderUtils;

public class NavItem extends Group {
    private Filter filter;
    private boolean addEd;
    private Label label;
    public NavItem(PageView photoPage){
        setSize(200,200);
        Image bgImg = Layer.getShadow();
        bgImg.setSize(getWidth(),getHeight());
        addActor(bgImg);
        label= new Label("xxxxxx",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("font/font32.fnt");
        }});
        label.setColor(Color.BLACK);
        addActor(label);
        label.setAlignment(Align.center);
        label.setPosition(100,100,Align.center);
        setOrigin(Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                addEd = !addEd;
                if (addEd) {
                    photoPage.setShader(filter);
                }else {
                    photoPage.removeShader(filter);
                }
            }
        });
    }

    public void setShaderType(ShaderType value) {
        filter = ShaderUtils.getManager().getType(value);
        label.setText(value.name());
    }
}
