package com.example.recyclerviewhttprequests.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhttprequests.R;
import com.example.recyclerviewhttprequests.adapters.AlbumsAdapter;
import com.example.recyclerviewhttprequests.adapters.MyAdapter;
import com.example.recyclerviewhttprequests.fragments.F1;
import com.example.recyclerviewhttprequests.fragments.F2;
import com.example.recyclerviewhttprequests.models.Album;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    private TextView title;

    public AlbumViewHolder(@NonNull View view) {
        super(view);
        title = view.findViewById(R.id.album_name);

    }

    public void bind(Album album) {
        title.setText(album.getName());

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F2.albumId = album.getId();
                if (AlbumsAdapter.onAlbumItemClick != null)
                    AlbumsAdapter.onAlbumItemClick.onClick(album);
            }
        });
    }

}
