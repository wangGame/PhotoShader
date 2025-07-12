package com.tony.photoshader.doubletexture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class DoubleTexture extends Image {
    private Texture otherTexture;
    float time = 0;
    private ShaderProgram program;
    public DoubleTexture(Texture texture,Texture otherTexture){
        super(texture);
        this.otherTexture = otherTexture;
    }


//    = new ShaderProgram(Gdx.files.internal("shader/transform/txt.vert"),
//                    Gdx.files.internal("shader/transform/move2.glsl"));
//
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);


        int u_texture1 = program.getUniformLocation("u_texture1");
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
        otherTexture.bind();
        program.setUniformi(u_texture1,1);
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);

        extendsMethod();

        super.draw(batch, parentAlpha);
        batch.setShader(null);

    }

    public void extendsMethod(){
        int moveLeft = program.getUniformLocation("time");
        program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += Gdx.graphics.getDeltaTime();
    }
}
