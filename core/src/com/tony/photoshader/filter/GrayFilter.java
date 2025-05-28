package com.tony.photoshader.filter;

public class GrayFilter extends Filter{

    public GrayFilter(){
            this.vertPath = "shader/txt.vert";
            this.fragPath = "shader/txt.frag";
    }

    @Override
    public void extendsExecute() {

    }
}
