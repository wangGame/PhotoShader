package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Texture;

public class ChangeAFilter extends Filter {

    public ChangeAFilter() {
        this.vertPath = "shader/changeA/txt.vert";
        this.fragPath = "shader/changeA/txt.frag";
    }

    @Override
    public void extendsExecute(float delta, Texture texture) {

    }
}