package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;


public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    Context context;
    List<Tweet> tweets;

    public TweetsAdapter(Context context, final List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }
//


   //for each row inflate layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
       return new ViewHolder(view);
    }
  //Bind values based on position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get data at position
        Tweet tweet = tweets.get(position);
        //bind dat a at viewholder

        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }
    ///On refresh ..Clean items in recycler
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }
    public void addAll(List<Tweet>tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }
//Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);


        }

    public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
        }



    }



}

//public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {
//
//
//    Context context;
//    List<Tweet> tweets;
//
//    public TweetsAdapter(Context contex, final List<Tweet> tweets) {
//        this.context = context;
//        this.tweets = tweets;
//    }
//    //pass in context and list of tweets
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
//        return new ViewHolder(view);
//
//    }
//
//    //bingd values based on position
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        //get data at position
//        Tweet tweet = tweets.get(position);
//        //bind dat a at viewholder
//
//        holder.bind(tweet);
//
//        @Override
//        public int getItemCount () {
//            return tweets.size();
//        }
//
//
//    }
//
//    ///Define a view holder
//    //
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//
//        ImageView ivProfileImage;
//        TextView tvBody;
//        TextView tvScreenName;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
//            tvBody = itemView.findViewById(R.id.tvBody);
//            tvScreenName = itemView.findViewById(R.id.tvScreenName);
//        }
//
//
//        public void bind(Tweet tweet) {
//            tvBody.setText(tweet.body);
//            tvScreenName.setText(tweet.user.screenName);
//            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
//        }
//
//
//    }
//}
//
//
//
//
