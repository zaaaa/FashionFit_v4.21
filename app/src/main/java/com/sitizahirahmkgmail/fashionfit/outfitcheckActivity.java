package com.sitizahirahmkgmail.fashionfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class outfitcheckActivity extends AppCompatActivity {

    String[] user_info;
    String[] collect1;
    String gender, username, top, bottom, shoes, acc, occ;
    String combination;

    public void Mmenu(View view){
        Intent nextActivity = new Intent(outfitcheckActivity.this, MainActivity.class);
        nextActivity.putExtra("user", user_info);
        nextActivity.putExtra("collect1", collect1);
        startActivity(nextActivity);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfitcheck);

        user_info = getIntent().getExtras().getStringArray("user");
        collect1 = getIntent().getExtras().getStringArray("collect1");
        gender = user_info[2];
        username = user_info[0];
        top = collect1[0];
        bottom = collect1[1];
        shoes = collect1[2];
        acc = collect1[3];//accessories
        occ = collect1[4];//occasion

        Toast.makeText(this,occ, Toast.LENGTH_SHORT).show();

        TextView comment= (TextView)this.findViewById(R.id.msg);

        if (occ=="Formal"){
            if(top=="Shirt" && bottom=="Long Pants" && shoes=="Dress Shoes" ){
                combination=" Simple and Classic! \nSuitable for presentations, meetings and formal events.";
            }
            else if (top=="Shirt" && bottom=="Long Pants" && shoes=="High Heels" ){
                combination=" Elegant and Classic! \nSuitable for presentations, meetings and formal events.";
            }
            else if (top=="Blouse" && bottom=="Long Pants" && shoes=="High Heels" ){
                combination=" Elegant and Classic! \nSuitable for presentations, meetings and formal events.";
            }
            else {
                combination="Oh no! A theme disaster!! :( \nPlease improve your selection.";
            }
        }
        else if (occ=="Casual"){
            if(top=="T-Shirt" && bottom=="Short Pants" && shoes=="Sneakers" ){
                combination=" Simple and Comfy! \nSuitable for free time group discussions, evening walk and doing classes.";
            }
            else if (top=="Blouse" && bottom=="Jeans" && shoes=="Sneakers" ){
                combination=" Simple and Classic! \nSuitable for normal classes, group discussions and normal events.";
            }
            else if (top=="Shirt" && bottom=="Mini skirt" && shoes=="High Heels" ){
                combination=" Simple and Classic! \nSuitable for classes, discussions and normal events.";
            }
            else {
                combination="Oh no! A theme disaster!! :( \nPlease improve your selection.";
            }
        }
        else if (occ=="Party"){
            if(top=="Blouse" && bottom=="Mini skirt" && shoes=="High heels" ){
                combination=" Simple and Comfy! \nSuitable for parties, and fun events.";
            }
            else if (top=="shirt" && bottom=="Long pants" && shoes=="Dress shoes" ){
                combination=" Simple and Classic! \nSuitable for parties, and fun events.";
            }
            else if (top=="Shirt" && bottom=="Mini skirt" && shoes=="High Heels" ){
                combination=" Simple and Classic! \nSuitable for classes, discussions and normal events.";
            }
            else {
                combination="Oh no! A theme disaster!! :( \nPlease improve your selection.";
            }

    }
        //comment.setText("Occasion: "+occ+" \n"+combination);
}}
