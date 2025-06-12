package com.tony.photoshader.filter;

public class SplitFilter extends Filter{
    private int splitNum;
    public SplitFilter(int splitNum){
        this.splitNum = splitNum;
        this.vertPath = "shader/split/txt.vert";
        this.fragPath = "shader/split/txt.frag";
    }


    @Override
    public void extendsExecute(float delta) {
        program.setUniformf("splitX",splitNum);
        program.setUniformf("splitY",splitNum);
    }
}
