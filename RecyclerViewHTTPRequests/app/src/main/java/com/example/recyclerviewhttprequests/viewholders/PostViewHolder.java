package com.example.recyclerviewhttprequests.viewholders;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhttprequests.R;
import com.example.recyclerviewhttprequests.models.Post;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class PostViewHolder extends ChildViewHolder {
    public TextView mTextView;
    private ImageView imageView;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.textView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }

    public void bind(Post post) {
        mTextView.setText(post.getTitle());
    }
}
