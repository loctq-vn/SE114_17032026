package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {
    private Context context;
    private List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, 0, posts);
        this.context = context;
        this.posts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        }

        Post currentPost = posts.get(position);

        ImageView ivAvatar = convertView.findViewById(R.id.ivPostAvatar);
        TextView tvName = convertView.findViewById(R.id.tvPostName);
        TextView tvDate = convertView.findViewById(R.id.tvPostDate);
        TextView tvContent = convertView.findViewById(R.id.tvPostContent);

        ivAvatar.setImageResource(currentPost.getImageResId());
        tvName.setText(currentPost.getName());
        tvDate.setText(currentPost.getDate());
        tvContent.setText(currentPost.getContent());

        return convertView;
    }
}
