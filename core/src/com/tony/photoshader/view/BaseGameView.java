package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.filter.ShaderChainProcessor;

import java.util.List;

public class BaseGameView extends Group {
    protected Texture texture;
    protected ShaderChainProcessor processor;
    protected Image image;
    protected TextureRegion region;

    public BaseGameView() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    public void setShader(Filter filter) {
        processor.addShader(filter);
    }

    public void removeShader(Filter filter) {
        processor.removeShader(filter);
    }

    public List<Filter>  getAllUserFilter(){
        return processor.getShaders();
    }
}