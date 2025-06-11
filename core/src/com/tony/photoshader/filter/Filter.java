package com.tony.photoshader.filter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class Filter {
    protected ShaderProgram program;
    protected String vertPath;
    protected String fragPath;

    public ShaderProgram createShderProgram(){
        if (vertPath == null || fragPath == null){
            throw new GdxRuntimeException("vert or frag path is null!");
        }
        program = new ShaderProgram(Gdx.files.internal(vertPath),Gdx.files.internal(fragPath));
        return program;
    }

    public abstract void extendsExecute(float delta);

    public ShaderProgram getProgram() {
        return program;
    }

    public void dispose() {
        program.dispose();
    }
}
