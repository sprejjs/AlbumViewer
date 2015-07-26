package com.spreys.albumviewer.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.spreys.albumviewer.R;
import com.spreys.albumviewer.UI.Fragments.ThumbnailsFragment;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 26/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class ThumbnailsActivity extends AppCompatActivity {
    public static final String KEY_ALBUM_ID = "key_album_id";
    public static final String KEY_PHOTO_ID = "key_image_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumbnails);

        //Create the fragment
        ThumbnailsFragment fragment = new ThumbnailsFragment();

        Bundle args = new Bundle();
        args.putInt(KEY_ALBUM_ID, getIntent().getIntExtra(KEY_ALBUM_ID, -1));

        fragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.thumbnails_container, fragment)
                .commit();
    }
}
