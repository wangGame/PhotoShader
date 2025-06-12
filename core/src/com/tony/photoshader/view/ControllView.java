package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.tony.photoshader.shader.ShaderType;

public class ControllView extends Group {
    private ScrollPane scrollPane;
    public ControllView(PageView photoPage, FilterShowGroup filterShowGroup){
        setSize(Constant.GAMEWIDTH,410);

        scrollPane = new ScrollPane(new Table(){{
            align(Align.left);
            int i = 1;
            for (ShaderType value : ShaderType.values()) {
                NavItem navItem = new NavItem(photoPage,filterShowGroup);
                navItem.setShaderType(value);
                add(navItem).pad(10);
                if (i == 5){
                    row();
                    i = 0;
                }
                i ++;
            }
        }});
        scrollPane.setSize(getWidth(),getHeight());
        addActor(scrollPane);
        scrollPane.setPosition(0,getHeight()/2f, Align.left);
    }
}
