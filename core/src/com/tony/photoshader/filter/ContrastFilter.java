package com.tony.photoshader.filter;

public class ContrastFilter extends Filter{
    private float timeAll;
    public ContrastFilter(){
        this.vertPath = "shader/contrast/txt.vert";
        this.fragPath = "shader/contrast/txt.frag";
    }
    @Override
    public void extendsExecute(float delta) {
        this.timeAll += delta;
        program.setUniformf("contrast",timeAll);
    }
}
