package com.spreys.albumviewer.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Network.ApiWrapper;
import com.spreys.albumviewer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 26/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class ThumbnailsAdapter extends ArrayAdapter<Photo> {
    List<Photo> mPhotos;

    public ThumbnailsAdapter(Context context, List<Photo> photos) {
        super(context, 0, photos);
        mPhotos = photos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.thumbnail_item, parent, false);
        }

        //TODO apply view holder design patter
        ImageView imageView = (ImageView)convertView.findViewById(R.id.thumbnails_item_image_view);

        //Download a new image with Glide
        Glide.with(getContext()).load(mPhotos.get(position).getThumbnailUrl())
                .placeholder(R.drawable.loading).into(imageView);
        return convertView;
    }

    @Override
    public int getCount() {
        return mPhotos.size();
    }
}
