package com.example.recyclerviewhttprequests.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhttprequests.R;
import com.example.recyclerviewhttprequests.models.Album;
import com.example.recyclerviewhttprequests.models.Image;
import com.example.recyclerviewhttprequests.viewholders.AlbumViewHolder;
import com.example.recyclerviewhttprequests.viewholders.ImageViewHolder;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private ArrayList<Image> images;
    private Context context;

    public ImagesAdapter(Context context, ArrayList<Image> images) {
        this.context = context;
        this.images = images;
    }

    public ImagesAdapter(ArrayList<Image> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.photo_cell, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Image image = images.get(position);

        holder.bind(image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

}
