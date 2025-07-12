package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class ChangeScaleFilter extends Filter {

    public ChangeScaleFilter() {
        this.vertPath = "shader/changeScale/txt.vert";
        this.fragPath = "shader/changeScale/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {

    }
}