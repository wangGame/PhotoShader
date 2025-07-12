package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.filter.ShaderChainProcessor;
import com.tony.photoshader.shader.ShaderType;
import com.tony.photoshader.shader.ShaderUtils;

import java.util.List;

public class SingleGameView extends BaseGameView {
    public SingleGameView() {
        texture = Asset.getAsset().getTexture("phtos/demo_0.jpg");
        processor = new ShaderChainProcessor(texture.getWidth(), texture.getHeight());
        setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);
        region = new TextureRegion();
        image = new Image(region);
        image.setSize(texture.getWidth(), texture.getHeight());
        image.setOrigin(Align.center);
        image.setDebug(true);
        image.setPosition(getWidth()/2f,getHeight()/2f+500,Align.center);
        addActor(image);

        float ws = Constant.GAMEWIDTH / image.getWidth();
        float hs = Constant.GAMEWIDTH / image.getHeight();
        image.setScale(Math.min(ws,hs));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // 处理一次纹理并设置到 region（如果频繁处理可以缓存）
        Texture processed = processor.process(texture,delta);
        region.setTexture(processed);
        region.setRegion(0, 0, processed.getWidth(), processed.getHeight());
        if (processor.getShaders().size() % 2 != 0) {
            region.flip(false, true); // FBO 纹理默认是颠倒的
        }
        image.setSize(region.getRegionWidth(),region.getRegionHeight());
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