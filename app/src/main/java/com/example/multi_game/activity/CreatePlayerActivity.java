package com.example.multi_game.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import com.example.multi_game.R;
import com.example.multi_game.databinding.ActivityCreatePlayerBinding;
import com.squareup.picasso.Picasso;

public class CreatePlayerActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE = 1001;
    private static final int REQUEST_LOCALISATION_PERMISSION = 2001;
    private ActivityCreatePlayerBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_player);

        binding.createPlayerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                //startActivityForResult(Intent.createChooser(intent, "Choix de la photo"), REQUEST_IMAGE);
                startActivityForResult(intent, REQUEST_IMAGE);

            }
        });

        binding.createPlayerLocalisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(CreatePlayerActivity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(CreatePlayerActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CreatePlayerActivity.this, new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, REQUEST_LOCALISATION_PERMISSION);

                }else {
                    getUserLocation();

                }
                }
            });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        if (requestCode == REQUEST_LOCALISATION_PERMISSION &&
                ActivityCompat.checkSelfPermission(CreatePlayerActivity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(CreatePlayerActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            getUserLocation();
        }
    }

    private void getUserLocation(){

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK){
            Picasso.get().load(data.getData()).into(binding.createPlayerImage);
        }
    }

}

