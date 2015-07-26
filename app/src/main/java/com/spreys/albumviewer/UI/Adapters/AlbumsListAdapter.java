package com.spreys.albumviewer.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.R;

import java.util.List;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 26/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class AlbumsListAdapter extends ArrayAdapter<Album> {
    private List<Album> mAlbums;

    public AlbumsListAdapter(Context context, List<Album> albums){
        super(context, 0, albums);
        mAlbums = albums;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflate view if required
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.album_list_item, parent, false);
        }

        //Fill up the date
        //TODO use view holder design pattern
        Album album = mAlbums.get(position);
        ((TextView) convertView.findViewById(R.id.album_list_item_title)).setText(album.getTitle());
        //TODO replace id with a username
        ((TextView) convertView.findViewById(R.id.album_list_item_username)).setText(String.valueOf(album.getId()));

        return convertView;
    }

    @Override
    public int getCount() {
        return mAlbums.size();
    }
}
