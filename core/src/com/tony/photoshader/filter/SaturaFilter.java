package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class SaturaFilter extends Filter{
    private float timeAll;
    public SaturaFilter(){
        this.vertPath = "shader/satura/txt.vert";
        this.fragPath = "shader/satura/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {
        this.timeAll += delta;
        program.setUniformf("saturation",timeAll);
    }
}
