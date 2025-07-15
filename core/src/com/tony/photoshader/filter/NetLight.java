package com.tony.photoshader.filter;

public class NetLight extends Filter{
    public NetLight(){
        this.vertPath = "shader/neilight/txt.vert";
        this.fragPath = "shader/neilight/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {


    }
}
