package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.tony.photoshader.filter.ShaderChainProcessor;
import com.tony.photoshader.filter.ShaderChainProcessor1;
import com.tony.photoshader.shader.ShaderType;
import com.tony.photoshader.shader.ShaderUtils;

public class PageView2 extends Group {
    private Texture texture;
    private ShaderChainProcessor processor;
    private Image image;
    private TextureRegion region;

    public PageView2() {
        texture = Asset.getAsset().getTexture("phtos/pre.png");
        processor = new ShaderChainProcessor(texture.getWidth(), texture.getHeight());
//        processor.addShader(ShaderUtils.getManager().getType(ShaderType.GRAY).getProgram());
        processor.addShader(ShaderUtils.getManager().getType(ShaderType.A).getProgram());
        processor.addShader(ShaderUtils.getManager().getType(ShaderType.COLOR).getProgram());
        processor.addShader(ShaderUtils.getManager().getType(ShaderType.SCALE).getProgram());
        setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT - 100);
        region = new TextureRegion();
        image = new Image(region);
        addActor(image);
        image.setOrigin(Align.center);
        image.setSize(1000,1000);
        image.setDebug(true);
//        image.setPosition(getWidth() / 2f, getHeight() / 2f, Align.center);

        region.setTexture(texture);
        region.setRegion(0,0,texture.getWidth(),texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Texture process = processor.process(texture);
        region.setTexture(process);
//        region.flip(false, true);
        super.draw(batch, parentAlpha);
    }
}
