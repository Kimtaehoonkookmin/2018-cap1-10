package com.kookmin.jongmin.kookimincommunity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by JongMin on 2018-03-14.
 */

public class ListViewMoreButton {
    public static View set(Activity activity, ListView listView, View.OnClickListener onClickListener) {
        View footer = activity.getLayoutInflater().inflate(R.layout.add_page_button_layout, null) ;
        Button addButton = footer.findViewById(R.id.more_button);
        addButton.setOnClickListener(onClickListener);
        listView.addFooterView(footer);
        return addButton;
    }
}
