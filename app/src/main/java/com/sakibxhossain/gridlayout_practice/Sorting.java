package com.sakibxhossain.gridlayout_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.sakibxhossain.gridlayout_practice.helper.Sorting_Adapter;
import com.sakibxhossain.gridlayout_practice.helper.Sorting_ClickListener;

public class Sorting extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;

    String[] algo_title = {
           "Selection Sort",
           "Insertion Sort", "Marge Sort"
    };

    String[] algo_difficulty = {
            "Easy", "Easy",
            "Medium"
    };


    ImageView text_ber_back_button;
    GridView sorting_gridview;
    Sorting_Adapter sorting_adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting);

        firebaseFirestore = FirebaseFirestore.getInstance();

        text_ber_back_button = findViewById(R.id.sorting_bar_button);
        sorting_gridview = findViewById(R.id.sorting_Section_gridView);


        sorting_adapter = new Sorting_Adapter(this, algo_title, algo_difficulty, new Sorting_ClickListener() {
            @Override
            public void onItemClicked(int position) {
//                if(position==0){
//                    Intent intent = new Intent(Sorting.this, Selection_Sort_Description.class);
//                    startActivity(intent);
//                }

                switch (position) {
                    case 0:
                        Intent selection = new Intent(Sorting.this, Selection_Sort_Description.class);
                        startActivity(selection);
                        break;
                    case 1:
                        Intent insertion = new Intent(Sorting.this, Insertion_Sort_Description.class);
                        startActivity(insertion);
                        break;
                    case 2:
                        Intent Marge = new Intent(Sorting.this, Marge_Sort_Description.class);
                        startActivity(Marge);
                        break;
                    default:
                        System.out.println("Looking forward to the Weekend");
                }

            }
        });
        sorting_gridview.setAdapter(sorting_adapter);


        text_ber_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sorting.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left,R.anim.slideout_from_right);
            }
        });
    }
}