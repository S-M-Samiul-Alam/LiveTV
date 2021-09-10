package com.example.citytv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.citytv.Activity.Video;
import com.example.citytv.Model.Item;
import com.example.citytv.R;

import java.util.List;

public class VideoDetailsAdapter extends RecyclerView.Adapter<VideoDetailsAdapter.VideoDetailsViewHolder> {
    private Context context;
    private List<Item> videoDetailsList;
    public VideoDetailsAdapter(Context context,List<Item> videoDetailsList)
    {
    this.context = context;
    this.videoDetailsList = videoDetailsList;
    }
    @NonNull
    @Override
    public VideoDetailsAdapter.VideoDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_listitem,parent,false);
        return new VideoDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoDetailsAdapter.VideoDetailsViewHolder holder, int position) {
        Glide.with(context).
                load(videoDetailsList.
                        get(position)
                       .getSnippet().getThumbnails().getMedium().getUrl()).into(holder.thumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Video.class);
                intent.putExtra("videoID", videoDetailsList.get(position).getId().getVideoId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoDetailsList.size();
    }

    public class VideoDetailsViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        public VideoDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.image_view);
        }
    }
}
