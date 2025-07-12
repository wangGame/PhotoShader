package com.tony.photoshader.filter;

public class BlurFilter extends Filter{

    private float[] xx = new float[2];
    public BlurFilter(){
        this.vertPath = "shader/blur/txt.vert";
        this.fragPath = "shader/blur/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {
        xx[0] = width;
        xx[1] = height;
        program.setUniform2fv("resolution",xx,0,2);
        program.setUniformf("blurRadius",42);
        program.setUniformf("sampleNum",14);

    }
}
