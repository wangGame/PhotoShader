package com.tony.photoshader.filter;

public class FlightFilter extends Filter{

    public FlightFilter(){
        this.vertPath = "shader/flight/txt.vert";
        this.fragPath = "shader/flight/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {


    }
}
