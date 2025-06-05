package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.constant.Constant;
import com.tony.photoshader.shader.ShaderType;

public class FilterShowGroup extends Group {
    private ScrollPane filterPane;
    private Table table;
    public FilterShowGroup(){
        setSize(Constant.GAMEWIDTH,100);
        table = new Table() {{

        }};
        table.align(Align.left);
        filterPane = new ScrollPane(table);
        addActor(filterPane);
        filterPane.setSize(getWidth(),getHeight());

        for (int i = 0; i < 7; i++) {
            FilterGroup filterGroup = new FilterGroup();
            table.add(filterGroup);
        }
    }

    public void fliter(ShaderType type){

    }
}
