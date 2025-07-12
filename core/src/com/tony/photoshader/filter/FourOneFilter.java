package com.tony.photoshader.filter;

public class FourOneFilter extends Filter{

    public FourOneFilter(){
        this.vertPath = "shader/fourone/txt.vert";
        this.fragPath = "shader/fourone/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {

    }
}
