package com.spreys.albumviewer.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.spreys.albumviewer.Network.ApiWrapper;
import com.spreys.albumviewer.R;
import com.spreys.albumviewer.UI.Activities.ThumbnailsActivity;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 26/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class ImageDetailsFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_details, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.fragment_image_details_image_view);

        ApiWrapper mApiWrapper = new ApiWrapper();
        Glide.with(getActivity()).load(mApiWrapper.getPhoto(getArguments()
                .getInt(ThumbnailsActivity.KEY_PHOTO_ID)).getUrl())
                .placeholder(R.drawable.loading_large)
                .into(imageView);

        return view;
    }
}
