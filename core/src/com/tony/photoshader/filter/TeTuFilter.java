package com.tony.photoshader.filter;

import com.badlogic.gdx.utils.Array;
import com.kw.gdx.asset.Asset;
import com.tony.photoshader.tetu.TeTuBean;

public class TeTuFilter extends Filter{
    public TeTuFilter(){

        teTuBeans = new Array<>();
        TeTuBean bean = new TeTuBean();
        bean.setTexture(Asset.getAsset().getTexture("phtos/pre.png"));
        bean.setX(200);
        bean.setY(500);
        teTuBeans.add(bean);
    }

    @Override
    public void extendsExecute(float delta) {

    }
}
