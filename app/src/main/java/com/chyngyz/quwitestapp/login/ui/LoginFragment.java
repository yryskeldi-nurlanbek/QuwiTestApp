package com.chyngyz.quwitestapp.login.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chyngyz.quwitestapp.R;
import com.chyngyz.quwitestapp.databinding.FragmentLoginBinding;
import com.chyngyz.quwitestapp.messages.ui.MessageFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseMvpFragment<LoginContract.View, LoginContract.Presenter>
        implements LoginContract.View {

    @Inject
    LoginPresenter presenter;
    private FragmentLoginBinding binding;

    public static LoginFragment create() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setPresenter(presenter);
        super.onViewCreated(view, savedInstanceState);

        binding.buttonAction.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = binding.editTextEmail.getText().toString();
                        String password = binding.passwordTextEmail.getText().toString();
                        presenter.login(email, password);
                    }
                }
        );
    }

    @Override
    public void showLoading(Boolean isLoading) {
        Log.d("__________", "____________ showLoading");
        if (isLoading) {
            binding.buttonAction.setVisibility(View.GONE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.buttonAction.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoginConfirmed() {
        Log.d("__________", "____________ showLoginConfirmed");
        replace(MessageFragment.create(), R.id.content);
    }
}
