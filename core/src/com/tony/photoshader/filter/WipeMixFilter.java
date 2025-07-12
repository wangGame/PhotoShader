package com.tony.photoshader.filter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.kw.gdx.asset.Asset;

public class WipeMixFilter extends Filter {
    private float time;
    private Texture texture;

    public WipeMixFilter(){
        this.vertPath = "shader/wipemix/txt.vert";
        this.fragPath = "shader/wipemix/txt.frag";
        this.texture = Asset.getAsset().getTexture("phtos/pre.png");
    }
    @Override
    public void extendsExecute(float delta, Texture texture) {

        time  += delta;
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
        texture.bind();
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
        program.setUniformi("u_texture1", 1);
        program.setUniformf("time", (float) Math.sin(time));
    }
}
