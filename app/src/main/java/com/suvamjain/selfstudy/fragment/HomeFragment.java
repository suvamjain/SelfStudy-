package com.suvamjain.selfstudy.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.suvamjain.selfstudy.R;
import com.suvamjain.selfstudy.adapters.SubjectAdapter;
import com.suvamjain.selfstudy.modals.Subject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private View inflatedView;
    private RecyclerView mRecyclerView;
    private SubjectAdapter mAdapter;
    private ArrayList<Subject> allSubList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflatedView = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);

        TextView textView = (TextView)inflatedView.findViewById(R.id.msg);

        //use a loop to change text color
        Spannable WordtoSpan = new SpannableString(getString(R.string.trial_msg));
        WordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 27, 38, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(WordtoSpan);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        allSubList = new ArrayList<Subject>();

        allSubList.add(new Subject("Mental Ability", 68, R.drawable.mental));
        allSubList.add(new Subject("Physics", 0, R.drawable.phy));
        allSubList.add(new Subject("Chemistry", 10, R.drawable.chem));
        allSubList.add(new Subject("Mathematics", 45, R.drawable.math));
        allSubList.add(new Subject("Biology", 2, R.drawable.bio));

        mAdapter = new SubjectAdapter(getContext(), allSubList);
        mRecyclerView.setAdapter(mAdapter);
        loadSubjects(); //load all subjects
        return inflatedView;
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.scheduleLayoutAnimation();
    }

    private void loadSubjects() {
        if (allSubList.size() > 0) {
            mRecyclerView.setVisibility(View.VISIBLE);
            mRecyclerView.setHasFixedSize(true);
            runLayoutAnimation(mRecyclerView);
        }
        else  {
            mRecyclerView.setVisibility(View.GONE);
        }
    }

}
