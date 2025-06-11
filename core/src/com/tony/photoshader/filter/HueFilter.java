package com.tony.photoshader.filter;

public class HueFilter extends Filter{
    private float timeAll;
    public HueFilter(){
        this.vertPath = "shader/hue/txt.vert";
        this.fragPath = "shader/hue/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {
        this.timeAll += delta;
        program.setUniformf("hueAdjust",timeAll);
    }
}
