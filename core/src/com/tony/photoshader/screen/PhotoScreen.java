package com.tony.photoshader.screen;

import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.screen.BaseScreen;
import com.tony.photoshader.view.ControllView;
import com.tony.photoshader.view.FilterShowGroup;
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

        FilterShowGroup filterShowGroup = new FilterShowGroup();
        addActor(filterShowGroup);
        filterShowGroup.setDebug(true);
        filterShowGroup.setPosition(Constant.GAMEWIDTH/2f,920,Align.center);

        this.controllView = new ControllView(pageView);
        addActor(controllView);
        controllView.setPosition(540,360, Align.bottom);
    }

}
