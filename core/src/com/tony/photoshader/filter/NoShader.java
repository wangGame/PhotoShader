package com.tony.photoshader.filter;

public class NoShader extends Filter{

    public NoShader(){
        this.vertPath = "shader/no/txt.vert";
        this.fragPath = "shader/no/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {

    }
}
