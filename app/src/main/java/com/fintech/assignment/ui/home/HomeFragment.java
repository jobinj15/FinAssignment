package com.fintech.assignment.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.fintech.assignment.R;
import com.fintech.assignment.ui.dashboard.DashboardFragment;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ViewPager2 viewPager2;
    private int loopPos = 0;
    private MaterialCardView card1, card2, card3, card4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        setTabLayouts(root);
        return root;
    }

    private void setTabLayouts(View root) {
        View tab1Parent = root.findViewById(R.id.tab1);
        View tab2Parent = root.findViewById(R.id.tab2);
        View tab3Parent = root.findViewById(R.id.tab3);
        View tab4Parent = root.findViewById(R.id.tab4);

        card1 = tab1Parent.findViewById(R.id.mCard);
        card2 = tab2Parent.findViewById(R.id.mCard);
        card3 = tab3Parent.findViewById(R.id.mCard);
        card4 = tab4Parent.findViewById(R.id.mCard);

        card2.setCardBackgroundColor(getResources().getColor(R.color.yellow));
        card3.setCardBackgroundColor(getResources().getColor(R.color.green));
        card4.setCardBackgroundColor(getResources().getColor(R.color.red));

        setCardListeners();

        PagerAdapter pagerAdapter = new PagerAdapter(this);
        viewPager2 = root.findViewById(R.id.viewPager);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setUserInputEnabled(false);
        setCurrentPage(0);



    }


    private void setCardListeners() {
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentPage(0);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentPage(1);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentPage(2);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentPage(3);
            }
        });
    }

    private void setCurrentPage(int pos) {
        if (pos > 3)
            return;

        MaterialCardView[] cards = {card1, card2, card3, card4};
        int size = cards.length;
        MaterialCardView selectedCard;


        for (int i = 0; i < size; i++) {
            selectedCard = cards[i];
            if (i == pos)
                selectedCard.setCardElevation(15);
            else selectedCard.setCardElevation(0);
        }


        viewPager2.setCurrentItem(pos);
    }


    public class PagerAdapter extends FragmentStateAdapter {
        public PagerAdapter(Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment;

            if (position == 0)
                fragment = new HomeFragment1();
            else
                fragment = new DashboardFragment();

            Bundle args = new Bundle();
            args.putInt("pos", position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

}
