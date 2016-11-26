package com.example.guitar.testrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity {
    /* Recycler View*/
    RecyclerView rv;
    /* Realm */
    private Realm   mRealm;
    RealmResults<User> results;
    /* Main Activity */
    EditText name;
    EditText id;
    EditText description_1;
    EditText description_2;
    EditText description_3;
    boolean search = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Realm*/
        mRealm = Realm.getInstance(getApplicationContext());

        /** Clear Realm BD **/
//        mRealm.beginTransaction();
//        RealmResults<User> books = mRealm.allObjects(User.class);
//        if(!books.isEmpty()) {
//            for(int i = books.size() - 1; i >= 0; i--) {
//                books.get(i).removeFromRealm();
//            }
//        }
//        mRealm.commitTransaction();
        /** Widgets **/
        name = (EditText)findViewById(R.id.edit_main);
        id = (EditText)findViewById(R.id.edit_main1);
        description_1 = (EditText)findViewById(R.id.main_desc1);
        description_2 = (EditText)findViewById(R.id.main_desc2);
        description_3 = (EditText)findViewById(R.id.main_desc3);
    }

    private String getTrimmedName() {
        return name.getText().toString().trim();
    }
    private String getTrimmedId() {
        return id.getText().toString().trim();
    }
    private String getTrimmedDescription_3() {
        return description_3.getText().toString().trim();
    }
    private String getTrimmedDescription_2() {
        return description_2.getText().toString().trim();
    }
    private String getTrimmedDescription_1() {
        return description_1.getText().toString().trim();
    }

    // OnClicks
    public void add(View v){
        /** Realm Magic **/

        // User Object in DB
        //Required
        mRealm.beginTransaction();
        User user = mRealm.createObject(User.class);
        user.setName(getTrimmedName());
        user.setId(getTrimmedId());
        user.setDescriptionfirst(getTrimmedDescription_1());
        user.setDescriptionsecond(getTrimmedDescription_2());
        user.setDescriptionthird(getTrimmedDescription_3());
        // Required
        mRealm.commitTransaction();
    }
    // Создание списка Объектов удв. условию поиска
    public void find(View v) {
        results =  mRealm.where(User.class)
                                            .equalTo("name",getTrimmedName())
                                            .or()
                                            .equalTo("name",getTrimmedId())
                                            .findAll();
        search = true;
    }

    /* Requests */
    static String USER = "123";
    public void toDB (View v){
        setContentView(R.layout.recyclerview_activity);
        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(new RVAdapter(mRealm.allObjects(User.class),getApplicationContext()));

    }

    public void toMenu(View v){
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.edit_main);
        id = (EditText)findViewById(R.id.edit_main1);
    }
}
