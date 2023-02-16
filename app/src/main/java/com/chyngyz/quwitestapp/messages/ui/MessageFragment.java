package com.chyngyz.quwitestapp.messages.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chyngyz.quwitestapp.databinding.FragmentMessagesBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MessageFragment
        extends BaseMvpFragment<MessagesContract.View, MessagesContract.Presenter>
        implements MessagesContract.View {

    @Inject
    MessagesPresenter presenter;
    private FragmentMessagesBinding binding;

    public static MessageFragment create() {
        return new MessageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentMessagesBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setPresenter(presenter);
        super.onViewCreated(view, savedInstanceState);
        presenter.loadChats();
    }

    @Override
    public void showLoading(Boolean isLoading) {
        if (isLoading) {
            binding.recyclerView.setVisibility(View.GONE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.recyclerView.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showChats(Object o) {

    }
}
