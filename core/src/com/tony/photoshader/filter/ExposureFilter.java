package com.tony.photoshader.filter;

public class ExposureFilter extends Filter{
    private float timeAll;
    public ExposureFilter(){
        this.vertPath = "shader/exposure/txt.vert";
        this.fragPath = "shader/exposure/txt.frag";
    }
    @Override
    public void extendsExecute(float delta) {
        this.timeAll += delta;
        program.setUniformf("exposure",timeAll);
    }
}
