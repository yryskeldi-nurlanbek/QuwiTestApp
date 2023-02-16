package com.chyngyz.quwitestapp.common.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    protected void popBackStack() {
        if (this.requireActivity().getSupportFragmentManager().getBackStackEntryCount() < 2) {
            this.requireActivity().finish();
        } else {
            this.requireActivity().getSupportFragmentManager().popBackStack();
        }
    }

    protected void replace(Fragment target, @IdRes int containerId) {
        FragmentTransaction fragmentTransaction =
                this.requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerId, target, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
