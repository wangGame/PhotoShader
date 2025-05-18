package com.tony.photoshader.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.screen.BaseScreen;
import com.tony.photoshader.dialog.SelectPhotoDialog;
import com.tony.photoshader.view.ControllView;
import com.tony.photoshader.view.PhotoPage;

public class PhotoScreen extends BaseScreen {
    private PhotoPage photoPage;
    private ControllView controllView;
    public PhotoScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void initView() {
        super.initView();
        this.photoPage = new PhotoPage();
        addActor(photoPage);
        photoPage.setPosition(540,1360, Align.center);
        this.controllView = new ControllView(photoPage);
        addActor(controllView);
        controllView.setPosition(540,100, Align.bottom);
    }
}
