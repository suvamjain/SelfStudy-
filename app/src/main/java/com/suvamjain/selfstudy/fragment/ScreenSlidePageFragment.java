package com.suvamjain.selfstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suvamjain.selfstudy.R;

public class ScreenSlidePageFragment extends Fragment {
    
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE = "arg_title";
    private static final String ARG_BG_COLOR = "arg_bg_color";

    // TODO: Rename and change types of parameters
    private String title;
    private int bgColorResId;
    private View inflatedView;

//    private OnFragmentInteractionListener mListener;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Title parameter
     * @param bgColorId Background Color
     * @return A new instance of fragment ScreenSlidePageFragment.
     */
    public static ScreenSlidePageFragment newInstance(String title, int bgColorId) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_BG_COLOR, bgColorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            bgColorResId = getArguments().getInt(ARG_BG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflatedView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inflatedView.setBackgroundColor(ContextCompat.getColor(getContext(),bgColorResId));
        TextView screen_slide_title = (TextView)inflatedView.findViewById(R.id.screen_slide_title);
        screen_slide_title.setText(title);
    }
}
