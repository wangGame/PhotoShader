package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.shader.ShaderType;

public class FilterGroup extends Group {
    private Label label;
    public FilterGroup(){
        setSize(100,100);
        setDebug(true);
        setOrigin(Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                remove();
            }
        });

        label= new Label("xxxxxx",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("font/font32.fnt");
        }});
        addActor(label);  label.setAlignment(Align.center);
        label.setPosition(50,50,Align.center);

    }
    public void setFilter(ShaderType shaderType){
        label.setText(shaderType.name());
    }
}
