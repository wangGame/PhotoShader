package com.tony.photoshader.filter;

public class SineFilter extends Filter{

    public SineFilter(){
        this.vertPath = "shader/sine/txt.vert";
        this.fragPath = "shader/sine/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {

    }
}
