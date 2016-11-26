package com.example.guitar.testrealm.Recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guitar.testrealm.R;
import com.example.guitar.testrealm.RVAdapter;
import com.example.guitar.testrealm.User;

import io.realm.Realm;

import static com.example.guitar.testrealm.R.id.rv;

public class ShowRecipe extends AppCompatActivity {
    /** Requests **/
    static String USER_REQUEST = "user";
    RecyclerView rv;

    Realm mRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_recipe);

    }
}
