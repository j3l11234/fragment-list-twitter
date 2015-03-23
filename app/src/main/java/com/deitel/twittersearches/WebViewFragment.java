package com.deitel.twittersearches;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

/**
	* A simple Fragment subclass.
	* Activities that contain this fragment must implement the
	* @link interface
	* to handle interaction events.
	* Use the @link factory method to
	* create an instance of this fragment.
*/
public class WebViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "url";

    // TODO: Rename and change types of parameters
    private String url;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param positon Parameter 1.
     * @return  A new instance of fragment TipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        	url = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View myView = inflater.inflate(R.layout.fragment_webview, container, false);
    	WebView webview = (WebView) myView.findViewById(R.id.webView_webView);
    	webview.loadUrl(url);
    	TextView textView = (TextView) myView.findViewById(R.id.webView_url);
    	textView.setText(url);
        return myView;
    }
}