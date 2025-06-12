package com.tony.photoshader.filter;

public class ChangeScaleFilter extends Filter {

    public ChangeScaleFilter() {
        this.vertPath = "shader/changeScale/txt.vert";
        this.fragPath = "shader/changeScale/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {

    }
}