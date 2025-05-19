package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.tony.photoshader.shader.ShaderType;

public class ControllView extends Group {
    private ScrollPane scrollPane;
    public ControllView(PhotoPage photoPage){
        setSize(1000,600);

        scrollPane = new ScrollPane(new Table(){{
            for (ShaderType value : ShaderType.values()) {
                for (int i = 0; i < 10; i++) {
                    NavItem navItem = new NavItem(photoPage);
                    add(navItem).pad(10);
                }
            }
        }});
        scrollPane.setSize(1080,320);
        addActor(scrollPane);
        scrollPane.setPosition(getWidth()/2f,getHeight()/2f, Align.center);
    }
}
