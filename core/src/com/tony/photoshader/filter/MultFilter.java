package com.tony.photoshader.filter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.kw.gdx.asset.Asset;

public class MultFilter extends Filter{
    private Texture otherTexture;
    private float time;
    public MultFilter(){
        otherTexture = Asset.getAsset().getTexture("phtos/pre.png");
        vertPath = "shader/transform/txt.vert";
        fragPath = "shader/transform/move2.glsl";
    }

    @Override
    public void extendsExecute(float delta) {
        time += delta;
        int moveLeft = program.getUniformLocation("time");
        program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));

        int u_texture1 = program.getUniformLocation("u_texture1");
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
        otherTexture.bind();
        program.setUniformi(u_texture1, 1);
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
    }
}
