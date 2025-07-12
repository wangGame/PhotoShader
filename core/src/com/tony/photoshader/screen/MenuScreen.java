package com.tony.photoshader.screen;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kw.gdx.BaseGame;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.screen.BaseScreen;
import com.tony.photoshader.doubletexture.DoubleTexture;

public class MenuScreen extends BaseScreen {
    public MenuScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void initView() {
        super.initView();
//        addActor(new Table(){{
//            Image singleBtn = new Image(Asset.getAsset().getTexture(""));
//            add(singleBtn);
//
//            Image multBtn = new Image(Asset.getAsset().getTexture(""));
//            add(multBtn);
//
//        }});
        DoubleTexture doubleTexture = new DoubleTexture(Asset.getAsset().getTexture("phtos/demo_0.jpg"),
                Asset.getAsset().getTexture("phtos/pre.png"));
        addActor(doubleTexture);
        doubleTexture.setSize(400,400);
    }
}
