package com.spreys.albumviewer.UI.Fragments;


import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Network.ApiWrapper;
import com.spreys.albumviewer.R;
import com.spreys.albumviewer.UI.Activities.ThumbnailsActivity;
import com.spreys.albumviewer.UI.Adapters.ThumbnailsAdapter;

import java.util.List;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 26/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class ThumbnailsFragment extends Fragment {
    private ApiWrapper mApiWrapper;
    private List<Photo> mPhotos;

    public ThumbnailsFragment() {
        mApiWrapper = new ApiWrapper();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thumbnails, container, false);
        ((GridView)view.findViewById(R.id.fragment_thumbnails_grid_view))
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ImageDetailsFragment fragment = new ImageDetailsFragment();

                        Bundle args = new Bundle();
                        args.putInt(ThumbnailsActivity.KEY_PHOTO_ID, mPhotos.get(position).getId());

                        fragment.setArguments(args);
                        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                        fragment.show(getActivity().getSupportFragmentManager(), null);
                    }
                });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new GetThumbnails().execute(getArguments().getInt(ThumbnailsActivity.KEY_ALBUM_ID));
    }

    class GetThumbnails extends AsyncTask<Integer, Void, List<Photo>> {

        @Override
        protected List<Photo> doInBackground(Integer... params) {
            return mApiWrapper.getPhotos(params[0]);
        }

        @Override
        protected void onPostExecute(List<Photo> photos) {
            super.onPostExecute(photos);

            mPhotos = photos;
            ((GridView)getActivity().findViewById(R.id.fragment_thumbnails_grid_view))
                    .setAdapter(new ThumbnailsAdapter(getActivity(), mPhotos));
        }
    }
}
