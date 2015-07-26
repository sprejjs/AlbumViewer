package com.spreys.albumviewer.UI.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Network.ApiWrapper;
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
    private Activity mActivity;

    public AlbumsListAdapter(Activity activity, List<Album> albums){
        super(activity, 0, albums);
        mAlbums = albums;
        mActivity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflate view if required
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.album_list_item, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.item_title = ((TextView) convertView.findViewById(R.id.album_list_item_title));
            viewHolder.item_username = ((TextView) convertView.findViewById(R.id.album_list_item_username));

            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        //Fill up the data
        Album album = mAlbums.get(position);
        viewHolder.item_title.setText(album.getTitle());
        ApiWrapper apiWrapper = new ApiWrapper();
        apiWrapper.placeUserNameIntoTextView(mActivity, album.getUserId(), viewHolder.item_username);

        return convertView;
    }

    @Override
    public int getCount() {
        return mAlbums.size();
    }

    static class ViewHolder {
        TextView item_title;
        TextView item_username;
    }
}
