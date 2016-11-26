package com.example.guitar.testrealm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guitar.testrealm.Recipe.ShowRecipe;

import java.util.List;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;


/**
 * Created by guitar on 25.11.16.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.UserViewHolder> implements RealmChangeListener{
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView userName;
        TextView userId;
        TextView description1;
        TextView description2;
        TextView description3;
        UserViewHolder(View itemView) {

            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            userName = (TextView) itemView.findViewById(R.id.person_name);
            userId = (TextView) itemView.findViewById(R.id.person_age);
            description1 = (TextView) itemView.findViewById(R.id.desription1);
            description2 = (TextView) itemView.findViewById(R.id.desription2);
            description3 = (TextView) itemView.findViewById(R.id.desription3);

        }

    }

    private Context context;

    List<User> users;
//    RVAdapter(List<User> users, Context context) {
//        this.users = users;
//        this.context = context;
//    }
    RVAdapter(RealmResults<User> users, Context context) {
        this.users = users;
        this.context = context;
    }
    /* Required */
    @Override
    public int getItemCount() {
        return users.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    /* Create Holder - Required*/
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup, false);
        UserViewHolder uvh = new UserViewHolder(v);
        return uvh;
    }

    /** Requests **/
    static String USER_REQUEST = "user";


    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
        userViewHolder.userName.setText(users.get(i).getName());
        userViewHolder.userId.setText(users.get(i).getId());
        String dest1 = users.get(i).getDescriptionfirst();
        String dest2 = users.get(i).getDescriptionfirst();
        String dest3 = users.get(i).getDescriptionfirst();

        userViewHolder.description1.setText(dest1);
        userViewHolder.description2.setText(dest2);
        userViewHolder.description3.setText(dest3);

        userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShowRecipe.class);
                intent.putExtra(USER_REQUEST,User.class);
                context.startActivity(intent);
            }
        });

    }

    //TODO REALM Only

    /* OnChange For ChangeListener*/
    public void onChange() { notifyDataSetChanged();}

}
