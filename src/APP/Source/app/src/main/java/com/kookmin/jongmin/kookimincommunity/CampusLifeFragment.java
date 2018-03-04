package com.kookmin.jongmin.kookimincommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by JongMin on 2018-02-19.
 */

public class CampusLifeFragment extends BackAbleFragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_campus_life, container, false);
    }

    @Override
    public void onBackPressed() {
        FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new MainFragment(), "BACK");
        TextView title_text = getActivity().findViewById(R.id.title_text_view);
        title_text.setText("국민대학교 커뮤니티");
    }
}
