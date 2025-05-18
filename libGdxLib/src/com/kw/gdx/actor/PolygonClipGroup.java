package com.kw.gdx.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Group;

public class PolygonClipGroup extends Group {
    private Polygon polygon;
    private ShapeRenderer sr;
//    private ShaperRenerInteface shapeRenderer;
    private int blendSrcFunc = GL20.GL_SRC_ALPHA;
    private int blendDstFunc = GL20.GL_ONE_MINUS_SRC_ALPHA;
    private int blendSrcFuncAlpha = GL20.GL_SRC_ALPHA;
    private int blendDstFuncAlpha = GL20.GL_ONE_MINUS_SRC_ALPHA;
    private float value;

    public PolygonClipGroup(ShaperRenerInteface shapeRenderer){
//        this.shapeRenderer = shapeRenderer;
        polygon = new Polygon();
        polygon.setVertices(new float[]{0,0,0,100,100,100,100,0});
        setPosition(200,200);
        sr = new ShapeRenderer();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        value += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (isTransform()) applyTransform(batch, computeTransform());
        batch.end();
        Gdx.gl.glEnable(GL20.GL_STENCIL_TEST);
        Gdx.gl.glStencilOp(GL20.GL_KEEP, GL20.GL_KEEP, GL20.GL_REPLACE);//第一次绘制的像素的模版值 0+1 = 1
        Gdx.gl.glStencilFunc(GL20.GL_ALWAYS, 1, 0xFF);
        sr.setProjectionMatrix(batch.getProjectionMatrix());
        sr.setTransformMatrix(batch.getTransformMatrix());
        sr.setColor(Color.valueOf("FF000000"));
        sr.begin(ShapeRenderer.ShapeType.Filled);
        drawPoly();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFuncSeparate(blendSrcFunc, blendDstFunc, blendSrcFuncAlpha, blendDstFuncAlpha);

        sr.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
        Gdx.gl.glStencilFunc(GL20.GL_NOTEQUAL, 0x1, 0xFF);//等于1 通过测试 ,就是上次绘制的图 的范围 才通过测试。
        Gdx.gl.glStencilOp(GL20.GL_KEEP, GL20.GL_KEEP, GL20.GL_KEEP);//没有通过测试的，保留原来的，也就是保留上一次的值。
        batch.begin();
        drawChildren(batch, parentAlpha);
        batch.flush();
        Gdx.gl.glDisable(Gdx.gl.GL_STENCIL_TEST);
        Gdx.gl.glClear(GL20.GL_DEPTH_WRITEMASK);
        if (isTransform()) resetTransform(batch);
    }

    protected void drawPoly(){

    }
}
