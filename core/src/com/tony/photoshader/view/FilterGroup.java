package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.listener.OrdinaryButtonListener;

public class FilterGroup extends Group {
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
    }
}
