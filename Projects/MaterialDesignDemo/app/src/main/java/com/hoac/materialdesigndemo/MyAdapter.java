package com.hoac.materialdesigndemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lbibera on 5/18/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card_demo, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int i) {
        vh.mTextView.setText(mDataset[i]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(LinearLayout v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
}
