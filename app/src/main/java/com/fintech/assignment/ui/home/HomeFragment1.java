package com.fintech.assignment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.fintech.assignment.R;

public class HomeFragment1 extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home1, container, false);
        setRightArrowIcon(root);
        return root;
    }


    private void setRightArrowIcon(View root){
        float d = getResources().getDisplayMetrics().density;
        int margin = (int)(20 * d);

        View imageParent = root.findViewById(R.id.layout_right_arrow);
        ImageView image = imageParent.findViewById(R.id.image);
        image.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right));

        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)image.getLayoutParams();
        lp.setMargins(margin, 0, 0, 0);
        image.setLayoutParams(lp);
    }


}
