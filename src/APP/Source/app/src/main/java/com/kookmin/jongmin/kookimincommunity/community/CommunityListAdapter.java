package com.kookmin.jongmin.kookimincommunity.community;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kookmin.jongmin.kookimincommunity.FragmentNavigator;
import com.kookmin.jongmin.kookimincommunity.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JongMin on 2018-03-14.
 */

public class CommunityListAdapter extends BaseAdapter {
    private List<CommunityListItem> communityListItems = new LinkedList<>();
    protected Activity activity;

    public CommunityListAdapter(Activity activity) {
        this.activity = activity;
    }

    public CommunityListAdapter addItem(CommunityListItem communityListItem) {
        communityListItems.add(communityListItem);
        return this;
    }

    @Override
    public int getCount() {
        return communityListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return communityListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_community_layout, parent, false);

        final CommunityListItem item = communityListItems.get(position);

        TextView noTextView = convertView.findViewById(R.id.community_number_text_view);
        TextView titleTextView = convertView.findViewById(R.id.community_title_text_view);
        TextView dateTextView = convertView.findViewById(R.id.community_date_text_view);
        TextView authorTextView = convertView.findViewById(R.id.community_author_text_view);
        // TextView hitsTextView = convertView.findViewById(R.id.annotation_list_hits_text_view);

        noTextView.setText(position+1+"");
        titleTextView.setText(item.getTitle());
        dateTextView.setText(item.getDate());
        authorTextView.setText(item.getAuthor());
        // hitsTextView.setText(""+item.getHits());

        setLayout(convertView, item);

        return convertView;
    }

    protected void setLayout(final View view, final CommunityListItem item) {
        LinearLayout layout = view.findViewById(R.id.community_list_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   ImageView imageView = activity.findViewById(R.id.home_top_bar_right_image_view2);
             //   imageView.setVisibility(View.GONE);
             //   FragmentNavigator.replaceFragment(activity, R.id.home_fragment
             //           , AnnotationShowFragment.newInstance(item.getId()), "BACK");
            }
        });
    }

}
