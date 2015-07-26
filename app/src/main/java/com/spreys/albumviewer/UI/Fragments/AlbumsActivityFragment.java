package com.spreys.albumviewer.UI.Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Network.ApiWrapper;
import com.spreys.albumviewer.R;
import com.spreys.albumviewer.UI.Activities.ThumbnailsActivity;
import com.spreys.albumviewer.UI.Adapters.AlbumsListAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlbumsActivityFragment extends Fragment {
    private ApiWrapper mApiWrapper;
    private List<Album> mAlbums;

    public AlbumsActivityFragment() {
        mApiWrapper = new ApiWrapper();
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        ((ListView)view.findViewById(R.id.fragment_albums_listview))
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Navigate to the next activity
                Intent intent = new Intent(getActivity(), ThumbnailsActivity.class);
                intent.putExtra(ThumbnailsActivity.KEY_ALBUM_ID, mAlbums.get(position).getId());
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new GetAlbums().execute();
    }

    class GetAlbums extends AsyncTask<String, Void, List<Album>> {

        @Override
        protected List<Album> doInBackground(String... params) {
            return mApiWrapper.getAlbums();
        }

        @Override
        protected void onPostExecute(final List<Album> albums) {
            super.onPostExecute(albums);
            mAlbums = albums;
            AlbumsListAdapter albumsListAdapter = new AlbumsListAdapter(getActivity(), albums);
            ((ListView) getActivity().findViewById(R.id.fragment_albums_listview))
                    .setAdapter(albumsListAdapter);
        }
    }
}
