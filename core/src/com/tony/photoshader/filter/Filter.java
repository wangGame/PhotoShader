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
    protected Array<TeTuBean> tiTu;

    public Filter(){
        this.vertPath = "shader/normal/txt.vert";
        this.fragPath = "shader/normal/txt.frag";
    }

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

    public Array<TeTuBean> getTiTu() {
        return tiTu;
    }

    public void extendsExecute(float delta,Texture texture){}

}
