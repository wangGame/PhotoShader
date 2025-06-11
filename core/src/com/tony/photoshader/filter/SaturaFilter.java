package com.tony.photoshader.filter;

public class SaturaFilter extends Filter{
    private float timeAll;
    public SaturaFilter(){
        this.vertPath = "shader/satura/txt.vert";
        this.fragPath = "shader/satura/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {
        this.timeAll += delta;
        program.setUniformf("saturation",timeAll);
    }
}
