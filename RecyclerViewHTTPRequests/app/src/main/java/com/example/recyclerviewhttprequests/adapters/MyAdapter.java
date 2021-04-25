package com.example.recyclerviewhttprequests.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerviewhttprequests.R;
import com.example.recyclerviewhttprequests.interfaces.OnUserItemClick;
import com.example.recyclerviewhttprequests.models.Post;
import com.example.recyclerviewhttprequests.models.User;
import com.example.recyclerviewhttprequests.viewholders.PostViewHolder;
import com.example.recyclerviewhttprequests.viewholders.UserViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ExpandableRecyclerViewAdapter<UserViewHolder, PostViewHolder> {
    public Context context;
    public static OnUserItemClick onUserItemClick;
    public MyAdapter(List<? extends ExpandableGroup> groups, OnUserItemClick onUserItemClick){

        super(groups);
        this.onUserItemClick=onUserItemClick;
    }



    @Override
    public List<? extends ExpandableGroup> getGroups() {
        return super.getGroups();
    }

    @Override
    public UserViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public PostViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_post, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(PostViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Post post = (Post) group.getItems().get(childIndex);
        holder.bind(post);
        holder.mTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected : " + post.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public void onBindGroupViewHolder(UserViewHolder holder, int flatPosition, ExpandableGroup group) {
        final User user = (User) group;
        holder.bind(user);
    }




}
