package com.example.app_01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Exibe o Toast
        Toast toast = Toast.makeText(this, "Hello World", Toast.LENGTH_LONG);
        toast.show();

        // Reexibe o Toast após 2 segundos para totalizar ~5 segundos
        new Handler().postDelayed(() -> {
            Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
        }, 2000);
    }
}

