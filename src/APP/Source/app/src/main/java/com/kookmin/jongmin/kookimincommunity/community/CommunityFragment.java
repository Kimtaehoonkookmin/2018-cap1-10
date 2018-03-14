package com.kookmin.jongmin.kookimincommunity.community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.kookmin.jongmin.kookimincommunity.BackAbleFragment;
import com.kookmin.jongmin.kookimincommunity.FragmentNavigator;
import com.kookmin.jongmin.kookimincommunity.ListViewMoreButton;
import com.kookmin.jongmin.kookimincommunity.MainFragment;
import com.kookmin.jongmin.kookimincommunity.R;

/**
 * Created by JongMin on 2018-02-19.
 */

public class CommunityFragment extends BackAbleFragment {
    protected View listFooter;

    protected ListView listView;
    protected CommunityListAdapter adapter;
    protected int[] pageNumber = {1};
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapter();
        listView = getView().findViewById(R.id.community_list_view);
    }

    protected void setAdapter() {
        adapter = new CommunityListAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listFooter = ListViewMoreButton.set(getActivity(), listView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageNumber[0]++;
                setListView();
            }
        });
        setListView();
    }

    protected void setListView() {
        for (int i=0; i<9; i++) {
            String title = "title";
            String author = "김종민";
            int hits = 1233;
            String date = "date";
            int id = 101;

            adapter.addItem(new CommunityListItem(id, author, title, date, hits));
        }

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new MainFragment(), "BACK");
        TextView title_text = getActivity().findViewById(R.id.title_text_view);
        title_text.setText("국민대학교 커뮤니티");
    }
}
