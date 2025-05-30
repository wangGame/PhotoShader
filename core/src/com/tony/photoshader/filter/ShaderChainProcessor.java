package com.tony.photoshader.filter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.kw.gdx.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class ShaderChainProcessor {
    private final int width, height;
    private final SpriteBatch batch;
    private final FrameBuffer fboA, fboB;
    private List<ShaderProgram> shaders;
    private Texture result;

    public ShaderChainProcessor(int width, int height) {
        this.width = width;
        this.height = height;
        this.batch = new SpriteBatch();
        this.shaders = new ArrayList<>();
        fboA = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        fboB = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
    }

    public Texture process(Texture inputTexture) {
        Texture currentInput = inputTexture;
        FrameBuffer currentOutput;
        for (int i = 0; i < shaders.size(); i++) {
            ShaderProgram shader = shaders.get(i);
            currentOutput = (i % 2 == 0) ? fboA : fboB;
            currentOutput.begin();
            Gdx.gl.glClearColor(0, 0, 0, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.setShader(shader);
            batch.begin();
            Matrix4 projectionMatrix1 = batch.getProjectionMatrix();
            projectionMatrix1.idt().setToOrtho2D(0, 0, width, height);
            // FBO 输出是上下翻转的
            currentInput.bind();
            batch.draw(currentInput, 0, 0, width, height, 0, 1, 1, 0);
            currentInput.bind(-1);
            batch.setShader(null);
            batch.end();
            currentOutput.end();
            currentInput = currentOutput.getColorBufferTexture();
        }
        // 保存最后结果
        result = currentInput;
        return result;
    }

    public Texture getResult() {
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

    public List<ShaderProgram> getShaders() {
        return shaders;
    }

    public void removeShader(ShaderProgram program) {
        shaders.remove(program);
    }

    public void addShader(ShaderProgram shaderProgram){
        shaders.add(shaderProgram);
    }
}