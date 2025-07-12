package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class BrightnessFilter extends Filter{
    private float timeAll;
    public BrightnessFilter(){
        this.vertPath = "shader/brightness/txt.vert";
        this.fragPath = "shader/brightness/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {
        this.timeAll += delta;
        program.setUniformf("brightness",timeAll);
    }
}
