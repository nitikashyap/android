package com.huntinggame.utils.Common;

import android.graphics.BitmapFactory;

import com.sokolov.androidsizes.ISize;

public class SizeFromImage implements ISize {
    private String path;
    private int width;
    private int height;

    public SizeFromImage(String path) {
        this.path = path;
        width = -1;
        height = -1;
    }

    @Override
    public int width() {
        if (width == -1) {
            init();
        }
        return width;
    }

    @Override
    public int height() {
        if (height == -1) {
            init();
        }
        return height;
    }

    private void init() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        width = options.outWidth;
        height = options.outHeight;
    }


}
