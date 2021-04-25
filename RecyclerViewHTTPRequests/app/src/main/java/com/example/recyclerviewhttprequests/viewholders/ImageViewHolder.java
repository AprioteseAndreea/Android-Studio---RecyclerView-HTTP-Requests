package com.example.recyclerviewhttprequests.viewholders;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.recyclerviewhttprequests.R;
import com.example.recyclerviewhttprequests.VolleyConfigSingleton;
import com.example.recyclerviewhttprequests.models.Image;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public ImageViewHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.image);
    }

    public void bind(Image image) {
        //am adaugat o extensie pentru ca altfel nu-mi recunoastea poza
        String imageViewUrl = image.getImageUrl()+".png";

        ImageLoader imageLoader = VolleyConfigSingleton.getInstance(imageView.getContext().
                getApplicationContext()).getImageLoader();
        imageLoader.get(imageViewUrl, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
