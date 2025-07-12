package com.tony.photoshader.filter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class OutLineFilter extends Filter{

    public OutLineFilter(){
        this.vertPath = "shader/outline/txt.vert";
        this.fragPath = "shader/outline/txt.frag";
    }

    @Override
    public void extendsExecute(float delta) {

    }

    @Override
    public void extendsExecute(float delta, Texture texture) {
        super.extendsExecute(delta, texture);
        Vector2 texelSize = new Vector2(1f / texture.getWidth(), 1f / texture.getHeight());
        program.setUniformf("u_texelSize", texelSize);
        program.setUniformf("u_outlineColor", Color.RED); // 或 Color.YELLOW
        program.setUniformf("u_thickness", 42);
    }
}
