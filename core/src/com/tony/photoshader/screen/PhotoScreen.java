package com.tony.photoshader.screen;

import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import com.tony.photoshader.view.ControllView;
import com.tony.photoshader.view.PageView;

public class PhotoScreen extends BaseScreen {
    private PageView pageView;
    private ControllView controllView;
    public PhotoScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void initView() {
        super.initView();
        pageView = new PageView();
        addActor(pageView);

        this.controllView = new ControllView(pageView);
        addActor(controllView);
        controllView.setPosition(540,100, Align.bottom);
    }
}
