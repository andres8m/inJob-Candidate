package com.example.inin.injob;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inin.injob.cv.AcademicExp;
import com.example.inin.injob.cv.AcademicExperienceList;
import com.example.inin.injob.cv.ExtraInfo;
import com.example.inin.injob.cv.JobInterest;
import com.example.inin.injob.cv.Languages;
import com.example.inin.injob.cv.LanguagesList;
import com.example.inin.injob.cv.PersonalInfo;
import com.example.inin.injob.cv.ProfessionalExp;
import com.example.inin.injob.cv.ProfessionalExperienceList;
import com.example.inin.injob.cv.References;
import com.example.inin.injob.cv.ReferencesList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepsFragment extends Fragment {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public StepsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_steps, container, false);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position){
                case 0:
                    PersonalInfo cv1 = new PersonalInfo();
                    return cv1;

                case 1:
                    JobInterest cv2 = new JobInterest();
                    return cv2;

                case 2:
                    ProfessionalExperienceList cv3 = new ProfessionalExperienceList();
                    return cv3;

                case 3:
                    AcademicExperienceList cv4 = new AcademicExperienceList();
                    return cv4;

                case 4:
                    LanguagesList cv5 = new LanguagesList();
                    return cv5;

                case 5:
                    ExtraInfo cv6 = new ExtraInfo();
                    return cv6;

                case 6:
                    ReferencesList cv7 = new ReferencesList();
                    return cv7;

                default:
                    MainFragment mainFragment3 = new MainFragment();
                    return mainFragment3;

            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 7;
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) view.findViewById(R.id.containercv);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Datos guardados exitosamente!", Snackbar.LENGTH_LONG)
                        .setAction("Continua en el siguiente paso", null).show();
            }
        });

    }

}
