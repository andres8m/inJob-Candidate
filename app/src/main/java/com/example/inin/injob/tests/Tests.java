package com.example.inin.injob.tests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.inin.injob.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tests extends Fragment {


    public Tests() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tests, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        WebView webView = (WebView) view.findViewById(R.id.webViewPs);
        webView.loadUrl("https://app.inin.global/");
        webView.getSettings().setJavaScriptEnabled(true);
    }

}
