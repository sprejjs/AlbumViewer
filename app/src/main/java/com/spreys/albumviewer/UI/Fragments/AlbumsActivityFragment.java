package com.spreys.albumviewer.UI.Fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Network.ApiWrapper;
import com.spreys.albumviewer.R;
import com.spreys.albumviewer.UI.Adapters.AlbumsListAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlbumsActivityFragment extends Fragment {
    private ApiWrapper apiWrapper;

    public AlbumsActivityFragment() {
        apiWrapper = new ApiWrapper();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_albums, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        new GetAlbums().execute();
    }

    class GetAlbums extends AsyncTask<String, Void, List<Album>> {

        @Override
        protected List<Album> doInBackground(String... params) {
            return apiWrapper.getAlbums();
        }

        @Override
        protected void onPostExecute(final List<Album> albums) {
            super.onPostExecute(albums);
            AlbumsListAdapter albumsListAdapter = new AlbumsListAdapter(getActivity(), albums);
            ((ListView) getActivity().findViewById(R.id.fragment_albums_listview))
                    .setAdapter(albumsListAdapter);
        }
    }
}
