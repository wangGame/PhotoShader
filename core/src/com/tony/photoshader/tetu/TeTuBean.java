package com.tony.photoshader.tetu;

import com.badlogic.gdx.graphics.Texture;

public class TeTuBean {

    private Texture texture;
    private float x;
    private float y;

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "TeTuBean{" +
                "texture=" + texture +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
