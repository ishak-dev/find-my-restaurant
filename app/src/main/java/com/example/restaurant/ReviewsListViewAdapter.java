package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ReviewsListViewAdapter extends BaseAdapter {

    private List<Review> reviewList;
    private Context context;

    public ReviewsListViewAdapter(List<Review> reviewList, Context context) {
        this.reviewList = reviewList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return reviewList.size();
    }

    @Override
    public Object getItem(int i) {
        return reviewList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return reviewList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.review_list_view,viewGroup,false);
        Review review = reviewList.get(i);

        TextView reviewUsername = view.findViewById(R.id.review_username);
        TextView reviewComment = view.findViewById(R.id.review_comment);

        reviewUsername.setText(review.getUsername());
        reviewComment.setText(review.getReviewMessage());


        return view;
    }
}
