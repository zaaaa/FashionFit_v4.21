package com.sitizahirahmkgmail.fashionfit;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class thirdActivity extends AppCompatActivity {

    String[] user_info;
    String[] collect1;
    String gender;
    Spinner s1, s2, s3, s4;

    public void submitB(View view) {
        //sound effect
        MediaPlayer mpstart = MediaPlayer.create(this, R.raw.bertrofcorrect);
        mpstart.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mpstart.start();

        //inserting value to pass through intent extra
        RadioGroup radioGroup= (RadioGroup)this.findViewById(R.id.radioGroup);
        String occasion = String.valueOf(radioGroup.getCheckedRadioButtonId());
        String top = String.valueOf(s1.getSelectedItem());
        String bottom = String.valueOf(s2.getSelectedItem());
        String shoes = String.valueOf(s3.getSelectedItem());
        String acc = String.valueOf(s4.getSelectedItem());
        String[] collect2 = {top, bottom, shoes, acc, occasion};
        Intent nextActivity = new Intent(thirdActivity.this, outfitcheckActivity.class);
        nextActivity.putExtra("user", user_info);
        nextActivity.putExtra("collect1", collect2);
        startActivity(nextActivity);
    }

    public void imgDisplay(View view){
        //retrieving value from spinners
        String sp1 = String.valueOf(s1.getSelectedItem());
        String sp2 = String.valueOf(s2.getSelectedItem());
        String sp3 = String.valueOf(s3.getSelectedItem());
        String sp4 = String.valueOf(s4.getSelectedItem());

        //referring to imageviews on view
        ImageView imageView = (ImageView)this.findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView)this.findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView)this.findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView)this.findViewById(R.id.imageView4);

        if (sp1.contentEquals("T-shirt")) imageView.setImageResource(R.drawable.accessories);
        else if (sp1.contentEquals("Shirt")) imageView.setImageResource(R.drawable.accessories);
        else if (sp1.contentEquals("Blouse")) imageView.setImageResource(R.drawable.accessories);
        else if (sp2.contentEquals("Long Pants")) imageView2.setImageResource(R.drawable.accessories);
        else if (sp2.contentEquals("Jeans")) imageView2.setImageResource(R.drawable.accessories);
        else if (sp2.contentEquals("Mini Skirt")) imageView2.setImageResource(R.drawable.accessories);
        else if (sp3.contentEquals("Sneakers")) imageView3.setImageResource(R.drawable.accessories);
        else if (sp3.contentEquals("Dress Shoes")) imageView3.setImageResource(R.drawable.accessories);
        else if (sp3.contentEquals("High Heels")) imageView3.setImageResource(R.drawable.accessories);
        else if (sp4.contentEquals("Watch")) imageView4.setImageResource(R.drawable.accessories);
        else if (sp4.contentEquals("Cap")) imageView4.setImageResource(R.drawable.accessories);
        else if (sp4.contentEquals("Jewellery")) imageView4.setImageResource(R.drawable.accessories);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //retrieve extras from intent
        user_info = getIntent().getExtras().getStringArray("user");
        collect1 = getIntent().getExtras().getStringArray("collect1");
        gender = user_info[2];

        //instructions to user
        Toast.makeText(this, " Step 2: Choose what to wear ", Toast.LENGTH_LONG).show();



        //Referring to spinners on View and load list of items
        s1 = (Spinner) findViewById(R.id.spinner);
            List<String> list1 = new ArrayList<String>();
            list1.add("T-shirt");
            list1.add("Shirt");
            if (gender.equals("female")) {list1.add("Blouse");}
            ArrayAdapter<String> l1_adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list1);
            l1_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            l1_adapter.notifyDataSetChanged();
            s1.setAdapter(l1_adapter);

        s2 = (Spinner) findViewById(R.id.spinner2);
       // imageView.setImageResource(R.drawable.bottom);
            List<String> list2 = new ArrayList<String>();
            list2.add("Long Pants");
            list2.add("Jeans");
            if (gender.equals("female")) {list2.add("Mini Skirt");}
                ArrayAdapter<String> l2_adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list2);
                l2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                l2_adapter.notifyDataSetChanged();
                s2.setAdapter(l2_adapter);

        s3 = (Spinner) findViewById(R.id.spinner3);
            List<String> list3 = new ArrayList<String>();
        list3.add("Sneakers");
        if (gender.equals("male")) list3.add("Dress Shoes");
        if (gender.equals("female")) {list3.add("High Heels");}
            ArrayAdapter<String> l3_adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list3);
            l3_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            l3_adapter.notifyDataSetChanged();
            s3.setAdapter(l3_adapter);

        s4 = (Spinner) findViewById(R.id.spinner4);
            List<String> list4 = new ArrayList<String>();
            list4.add("Watch");
            list4.add("Cap");
            list4.add("Jewellery");
            ArrayAdapter<String> l4_adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list4);
            l4_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            l4_adapter.notifyDataSetChanged();
            s4.setAdapter(l4_adapter);


    }


}