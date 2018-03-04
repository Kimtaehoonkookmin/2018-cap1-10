package com.kookmin.jongmin.kookimincommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JongMin on 2018-02-19.
 */

public class MainFragment extends BackAbleFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button community_button = getView().findViewById(R.id.community_button);
        Button campus_button = getView().findViewById(R.id.campus_button);
        Button campus_life_button = getView().findViewById(R.id.campus_life_button);
        Button class_information_button = getView().findViewById(R.id.class_information_button);
        Button life_information_button = getView().findViewById(R.id.life_information_button);
        Button sitemap_button = getView().findViewById(R.id.sitemap_button);

        community_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new CommunityFragment(), "BACK");
                TextView title_text = getActivity().findViewById(R.id.title_text_view);
                title_text.setText("커뮤니티");
            }
        });

        campus_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new CampusFragment(), "BACK");
                TextView title_text = getActivity().findViewById(R.id.title_text_view);
                title_text.setText("캠퍼스");
            }
        });

        campus_life_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new CampusLifeFragment(), "BACK");
                TextView title_text = getActivity().findViewById(R.id.title_text_view);
                title_text.setText("대학생활");
            }
        });

        class_information_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new ClassInformationFragment(), "BACK");
                TextView title_text = getActivity().findViewById(R.id.title_text_view);
                title_text.setText("강의정보");
            }
        });

        life_information_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new LifeInformationFragment(), "BACK");
                TextView title_text = getActivity().findViewById(R.id.title_text_view);
                title_text.setText("생활정보");
            }
        });

        sitemap_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(getActivity(), R.id.main_fragment, new SitemapFragment(), "BACK");
                TextView title_text = getActivity().findViewById(R.id.title_text_view);
                title_text.setText("학교 주요 사이트");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onBackPressed() {
        getActivity().finish();
    }
}
