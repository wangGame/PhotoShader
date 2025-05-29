package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.tony.photoshader.filter.ShaderChainProcessor;
import com.tony.photoshader.shader.ShaderType;
import com.tony.photoshader.shader.ShaderUtils;

public class PageView2 extends Group {
    private Texture texture;
    private ShaderChainProcessor processor;
    private TextureRegionDrawable drawable;
    private Image image;
    public PageView2() {
        texture = Asset.getAsset().getTexture("phtos/pre.png");
        processor = new ShaderChainProcessor((int) ((int) Constant.GAMEWIDTH/2.0f), (int) ((int) Constant.GAMEWIDTH/2.f));
//        processor.addShader(ShaderUtils.getManager().getType(ShaderType.GRAY).getProgram());
        processor.addShader(ShaderUtils.getManager().getType(ShaderType.A).getProgram());
//        processor.addShader(ShaderUtils.getManager().getType(ShaderType.COLOR).getProgram());
//        processor.addShader(ShaderUtils.getManager().getType(ShaderType.SCALE).getProgram());


        setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT - 100);
        region = new TextureRegion();
        image = new Image(region);
        drawable = (TextureRegionDrawable) image.getDrawable();
        addActor(image);
        image.setOrigin(Align.center);

        image.setSize(300,300);
        image.setPosition(getWidth() / 2f, getHeight() / 2f, Align.center);


    }

    private TextureRegion region;
    @Override
    public void draw(Batch batch, float parentAlpha) {
        processor.process(texture,batch);
        region.setTexture(processor.getResult());
        region.setRegion(0,0,texture.getWidth(),texture.getHeight());
        super.draw(batch, parentAlpha);
    }
}
