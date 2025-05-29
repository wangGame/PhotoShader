package com.tony.photoshader.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.tony.photoshader.filter.ShaderChainProcessor;
import com.tony.photoshader.shader.ShaderType;
import com.tony.photoshader.shader.ShaderUtils;

public class PageView3 extends Group {
    private Texture texture;
    private ShaderChainProcessor processor;
    private Image image;
    private TextureRegion region;

    public PageView3() {
        texture = Asset.getAsset().getTexture("phtos/pre.png");
//        texture = Asset.getAsset().getTexture("photos/pre.png"); // 请确保路径正确
        processor = new ShaderChainProcessor(texture.getWidth(), texture.getHeight());

        // 添加一个简单 shader（比如灰度或其他自定义）
        processor.addShader(ShaderUtils.getManager().getType(ShaderType.SCALE).getProgram());
        processor.addShader(ShaderUtils.getManager().getType(ShaderType.COLOR).getProgram());

        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        region = new TextureRegion();
        image = new Image(region);
        image.setSize(512, 512);
        image.setOrigin(Align.center);
        image.setDebug(true);
        addActor(image);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // 处理一次纹理并设置到 region（如果频繁处理可以缓存）
        Texture processed = processor.process(texture);

        region.setTexture(processed);
        region.setRegion(0, 0, processed.getWidth(), processed.getHeight());
        region.flip(false, true); // FBO 纹理默认是颠倒的
        image.setSize(region.getRegionWidth(), region.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha); // image 已持有 region，会被自动绘制
    }

//    @Override
//    public void dispose() {
//        texture.dispose();
//        processor.dispose();
//    }
}