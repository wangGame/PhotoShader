package com.tony.photoshader.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ArrayMap;
import com.kw.gdx.constant.Constant;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.shader.ShaderType;

public class FilterShowGroup extends Group {
    private ScrollPane filterPane;
    private Table table;
    private ArrayMap<ShaderType,FilterGroup> arrayMap;
    public FilterShowGroup(){
        this.arrayMap = new ArrayMap<>();
        setSize(Constant.GAMEWIDTH,100);
        table = new Table() {{

        }};
        table.align(Align.left);
        filterPane = new ScrollPane(table);
        addActor(filterPane);
        filterPane.setSize(getWidth(),getHeight());
}

    public void fliter(ShaderType type){
        FilterGroup filterGroup = new FilterGroup();
        table.add(filterGroup);
        this.arrayMap.put(type,filterGroup);
        filterGroup.setFilter(type);
    }

    public void removeFliter(ShaderType shaderType) {
        if (this.arrayMap.containsKey(shaderType)) {
            FilterGroup filterGroup = arrayMap.get(shaderType);
            table.removeActor(filterGroup);
        }
    }
}
