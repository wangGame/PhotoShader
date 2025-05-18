package com.tony.photoshader.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.kw.gdx.view.dialog.base.BaseDialog;

public class SelectPhotoDialog extends BaseDialog {
    @Override
    protected void initView() {
        super.initView();
        Table table = new Table(){{
            FileHandle phtos = Gdx.files.internal("phtos");
            int index = 0;
            for (FileHandle fileHandle : phtos.list()) {
                index ++;
                Group group = new Group();
                group.setSize(200,200);
                add(group).pad(10);
                Image image = new Image(Asset.getAsset().getTexture(fileHandle.path()));
                group.addActor(image);
                image.setOrigin(Align.center);
                group.setDebug(true);
                float min = Math.max(image.getWidth() / group.getWidth(), image.getHeight() / group.getHeight());
                image.setScale(1.0f/min);
                image.setPosition(group.getWidth()/2f,group.getHeight()/2f,Align.center);
                if (index >=4){
                    index = 0;
                    row();
                }
            }
        }};
        ScrollPane scrollPane = new ScrollPane(table);
        scrollPane.setSize(980,980);
        addActor(scrollPane);
        scrollPane.setPosition(540,960, Align.center);
    }
}
