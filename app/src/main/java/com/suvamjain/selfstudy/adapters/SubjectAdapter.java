package com.suvamjain.selfstudy.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;
import com.squareup.picasso.Picasso;
import com.suvamjain.selfstudy.R;
import com.suvamjain.selfstudy.modals.Subject;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Subject> mSubList;

    public SubjectAdapter(Context context, ArrayList<Subject> mSubList) {
        this.context = context;
        this.mSubList = mSubList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carditem_subject, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Subject sub = mSubList.get(position);
        holder.subName.setText(sub.getName());
        holder.subBar.animateProgress(2000, 0, sub.getPercentCompleted());
        holder.subPercent.setText(sub.getPercentCompleted() + "%");
        Picasso.with(context).load(sub.getImgResid()).resize(200,200).into(holder.subThumb);
    }

    @Override
    public int getItemCount() {
        return mSubList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView subName;
        public TextView subPercent;
        public ImageView subThumb;
        public RoundedHorizontalProgressBar subBar;

        public ViewHolder(View itemView) {
            super(itemView);
            subName = itemView.findViewById(R.id.item_name);
            subPercent = itemView.findViewById(R.id.item_perc);
            subThumb = itemView.findViewById(R.id.item_thumb);
            subBar = itemView.findViewById(R.id.item_prog);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Subject: " + subName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
