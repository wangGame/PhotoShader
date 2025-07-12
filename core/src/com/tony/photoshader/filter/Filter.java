package com.tony.photoshader.filter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.tony.photoshader.tetu.TeTuBean;

public abstract class Filter {
    protected ShaderProgram program;
    protected String vertPath;
    protected String fragPath;
    protected Array<TeTuBean> teTuBeans;


    public ShaderProgram createShderProgram(){
        if (vertPath == null || fragPath == null){
            throw new GdxRuntimeException("vert or frag path is null!");
        }
        program = new ShaderProgram(Gdx.files.internal(vertPath),Gdx.files.internal(fragPath));
        return program;
    }

    public void extendsExecute(float delta){}

    public void extendsExecute(float delta, Texture texture){}

    public ShaderProgram getProgram() {
        return program;
    }

    public void dispose() {
        program.dispose();
    }

    protected float width;
    protected float height;
    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Array<TeTuBean> getTiTu() {
        return teTuBeans;
    }
}
