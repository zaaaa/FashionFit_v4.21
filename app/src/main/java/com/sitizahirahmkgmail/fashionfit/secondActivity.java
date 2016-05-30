package com.sitizahirahmkgmail.fashionfit;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class secondActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    private ImageView imageView;
    Spinner s1, s2;
    String [] user_info;
    String gender;
    String username;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    public void saveButton(View view){
        //sound effect
        MediaPlayer mpstart = MediaPlayer.create(this, R.raw.bertrofcorrect);
        mpstart.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mpstart.start();

        String sub_type=String.valueOf(s2.getSelectedItem());
        String type= String.valueOf(s1.getSelectedItem());
        String [] collect1={type, sub_type};
        Intent nextActivity= new Intent(secondActivity.this, thirdActivity.class);
        nextActivity.putExtra( "user", user_info);
        nextActivity.putExtra( "collect1",collect1 );
        startActivity(nextActivity);
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }
    public void takePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }
    public  void gallery(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "content://media/internal/images/media"));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //retrieving value from intent
        user_info = getIntent().getExtras().getStringArray("user");
        username= user_info[0];
        gender= user_info[2];

        //instructions to user
        Toast.makeText(this, "Hello "+username+"! Step 1: Add clothes to your gallery", Toast.LENGTH_LONG).show();

        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clothes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setOnItemSelectedListener(this);

        //clothesView.setAdapter(adapter);
        ImageButton img = (ImageButton) findViewById(R.id.imageButton);
        this.imageView = (ImageView)this.findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create Intent to take a picture and return control to the calling application
                Intent img = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
                img.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

                // start the image capture Intent
                startActivityForResult(img, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }


        });}

    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        String sp1= String.valueOf(s1.getSelectedItem());
        Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Top")) {

            List<String> list = new ArrayList<String>();
            list.add("T-shirt");
            list.add("Shirt");
            if (gender.equals("female")) {list.add("Blouse");}
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Bottom")) {
            imageView.setImageResource(R.drawable.bottom);
            List<String> list = new ArrayList<String>();
            list.add("Long Pants");
            list.add("Jeans");
            if (gender.equals("female")) {list.add("mini Skirt");}
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }
        if(sp1.contentEquals("Shoes")) {
            imageView.setImageResource(R.drawable.shoes);
            List<String> list = new ArrayList<String>();
            list.add("Sneakers");
            if (gender.equals("male")) list.add("Dress Shoes");
            if (gender.equals("female")) {list.add("High Heels");}
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }
        if(sp1.contentEquals("Accessories")) {
            imageView.setImageResource(R.drawable.accessories);
            List<String> list = new ArrayList<String>();
            list.add("Watch");
            list.add("Cap");
            list.add("Jewellery");
            if (gender.equals("female")) {list.add("Stockings");}
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(this, "Please select clothes type", Toast.LENGTH_LONG).show();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

}



