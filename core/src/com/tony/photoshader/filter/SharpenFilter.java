package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class SharpenFilter extends Filter{

    public SharpenFilter(){
        this.vertPath = "shader/sharpen/txt.vert";
        this.fragPath = "shader/sharpen/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {
        program.setUniformf("sharpness",0.81f);
        program.setUniformf("imageWidthFactor",0.01f);
        program.setUniformf("imageHeightFactor",0.01f);

    }
}
