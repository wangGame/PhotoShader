package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class BezierFilter extends Filter{
    public BezierFilter(){
        this.vertPath = "shader/bezier/txt.vert";
        this.fragPath = "shader/bezier/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {

    }
}
