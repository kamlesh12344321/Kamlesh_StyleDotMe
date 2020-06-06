package com.styledotme.kamlesh_task.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class PicassoUtil {

    public static void loadImage(final ImageView imageView, String url, int placeholderResId) {
        Picasso picasso = Picasso.get();
        picasso.load(url)
                .placeholder(placeholderResId)
                .error(placeholderResId)
                .into(imageView);
    }


}
