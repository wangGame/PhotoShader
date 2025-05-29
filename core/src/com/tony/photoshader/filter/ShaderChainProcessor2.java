package com.tony.photoshader.filter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;

import java.util.ArrayList;
import java.util.List;

public class ShaderChainProcessor2 {
    private final int width, height;
    private final SpriteBatch batch;
    private final FrameBuffer fboA, fboB;
    private final List<ShaderProgram> shaders;
    private Texture result;

    public ShaderChainProcessor2(int width, int height) {
        this.width = width;
        this.height = height;
        this.batch = new SpriteBatch();
        this.shaders = new ArrayList<>();

        fboA = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        fboB = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
    }

    public void addShader(ShaderProgram shaderProgram) {
        shaders.add(shaderProgram);
    }

    public Texture process(Texture inputTexture) {
        Texture currentInput = inputTexture;
        FrameBuffer currentOutput;

        Matrix4 oldMatrix = batch.getProjectionMatrix().cpy();

        for (int i = 0; i < shaders.size(); i++) {
            ShaderProgram shader = shaders.get(i);
            currentOutput = (i % 2 == 0) ? fboA : fboB;

            currentOutput.begin();
            Gdx.gl.glClearColor(0, 0, 0, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            batch.setProjectionMatrix(new Matrix4().setToOrtho2D(0, 0, width, height));
            batch.setShader(shader);
            batch.begin();
            batch.draw(currentInput, 0, 0, width, height);
            batch.end();

            currentOutput.end();
            currentInput = currentOutput.getColorBufferTexture();
            currentInput.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        }

        batch.setShader(null);
        batch.setProjectionMatrix(oldMatrix);
        result = currentInput;
        return result;
    }

    public void dispose() {
        batch.dispose();
        fboA.dispose();
        fboB.dispose();
        for (ShaderProgram shader : shaders) {
            shader.dispose();
        }
    }
}
