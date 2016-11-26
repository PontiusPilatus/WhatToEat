package com.example.guitar.testrealm.Recipe;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guitar.testrealm.R;
import com.example.guitar.testrealm.User;

import java.util.List;

/**
 * Created by guitar on 26.11.16.
 */

public class RVRecipeAdapter extends RecyclerView.Adapter<RVRecipeAdapter.UserViewHolder> {
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView number;
        ImageView action;
        TextView description;

        UserViewHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.cv_cook);
            number = (TextView) itemView.findViewById(R.id.number_action);
            action = (ImageView) itemView.findViewById(R.id.image_view_cook_adapter);
            description = (TextView) itemView.findViewById(R.id.description_recipe_adapter_cook);

        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private User user;

    RVRecipeAdapter(User user) {
        this.user = user;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    /* Create Holder - Required*/
    @Override
    public RVRecipeAdapter.UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cook,viewGroup, false);
        RVRecipeAdapter.UserViewHolder uvh = new RVRecipeAdapter.UserViewHolder(v);
        return uvh;
    }


    /**
     *  CardView cv;
        TextView number;
        ImageView action;
        TextView description;
     **/

    @Override
    public void onBindViewHolder(RVRecipeAdapter.UserViewHolder userViewHolder, int i) {
        userViewHolder.number.setText(i);
    }

}
