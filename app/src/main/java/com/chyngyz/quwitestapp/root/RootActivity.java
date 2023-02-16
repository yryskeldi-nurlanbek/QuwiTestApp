package com.chyngyz.quwitestapp.root;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.chyngyz.quwitestapp.R;
import com.chyngyz.quwitestapp.login.ui.LoginFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replace(LoginFragment.create(), R.id.content);
    }

    private void replace(Fragment target, @IdRes int containerId) {
        FragmentTransaction fragmentTransaction =
                this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerId, target, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}