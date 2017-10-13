package com.example.joseph.codingtestweek3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joseph.codingtestweek3.model.FlickrImages;
import com.example.joseph.codingtestweek3.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/13/17.
 */

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    List<Item> images = new ArrayList<>();
    Context context;

    public ImageListAdapter(List<Item> images) {
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, ImageActivity.class);
//                intent.putExtra("title", view);
////                intent.putExtra("imagelink", );
//                context.startActivity(intent);
//            }
//        });
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = images.get(position);
        holder.item = item;

        holder.tvTitle.setText(item.getTitle());
        holder.tvAuthor.setText(item.getAuthor());
        Glide.with(context).load(item.getMedia().getM()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvAuthor;
        Item item;
        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("imagelink", item.getMedia().getM());
                    intent.putExtra("item", item);
                    context.startActivity(intent);
                }
            });
        }
    }
}
