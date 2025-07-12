package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class ChangeColorFilter extends Filter {

    public ChangeColorFilter() {
        this.vertPath = "shader/changeColor/txt.vert";
        this.fragPath = "shader/changeColor/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {

    }
}