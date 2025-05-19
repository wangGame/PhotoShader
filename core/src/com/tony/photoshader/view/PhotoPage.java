package com.tony.photoshader.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.kw.gdx.asset.Asset;
import com.tony.photoshader.filter.Filter;

public class PhotoPage extends Group {
    private Array<Filter> shaderPrograms;
    public PhotoPage() {
        setDebug(true);
        setSize(1080,1080);
        Image image = new Image(Asset.getAsset().getTexture("phtos/demo_0.jpg"));
        addActor(image);
        image.setOrigin(Align.center);
        float min = Math.max(image.getWidth() / getWidth(), image.getHeight() / getHeight());
        image.setScale(1.0f/min);
        image.setPosition(getWidth()/2f,getHeight()/2f, Align.center);
        shaderPrograms = new Array<>();
    }

    public void setShader(Filter program) {
        shaderPrograms.add(program);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (shaderPrograms.size>0) {
            for (Filter filter : shaderPrograms) {
                batch.flush();
                batch.setShader(filter.getProgram());
                filter.extendsExecute();
                super.draw(batch, parentAlpha);
                batch.setShader(null);
                batch.flush();
            }
        }else {
            super.draw(batch, parentAlpha);
        }
    }
}
