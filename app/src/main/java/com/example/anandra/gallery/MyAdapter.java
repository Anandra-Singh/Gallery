package com.example.anandra.gallery;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.VideoView;

/**
 * Created by Anandra on 05-Aug-17.
 */

class MyAdapter extends BaseAdapter {
    MainActivity mActivity; String path; String[] files;

    public MyAdapter(MainActivity mActivity, String path, String[] files) {

        this.mActivity=mActivity;
        this.path=path;
        this.files=files;

    }

    @Override
    public int getCount() {
        return files.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(mActivity);
        View v=inflater.inflate(R.layout.indiview,null);
        final VideoView Vview=(VideoView)v.findViewById(R.id.Vview1);
        CheckBox cb1=(CheckBox)v.findViewById(R.id.cb1);
        Vview.setVideoPath(path+files[i]);
        cb1.setText(files[i]);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Vview.start();
                }
                else {
                    Vview.stopPlayback();

                }

            }
        });


        return v;
    }
}
