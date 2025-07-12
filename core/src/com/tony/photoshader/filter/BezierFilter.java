package com.tony.photoshader.filter;

public class BezierFilter extends Filter{
    public BezierFilter(){
        this.vertPath = "shader/bezier/txt.vert";
        this.fragPath = "shader/bezier/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {

    }
}
