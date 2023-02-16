package com.chyngyz.quwitestapp.messages.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chyngyz.quwitestapp.R;
import com.chyngyz.quwitestapp.common.mvp.BaseMvpFragment;
import com.chyngyz.quwitestapp.databinding.FragmentMessagesBinding;
import com.chyngyz.quwitestapp.login.ui.LoginFragment;
import com.chyngyz.quwitestapp.messages.model.Message;
import com.chyngyz.quwitestapp.messages.ui.adapter.ChannelAdapter;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MessageFragment extends BaseMvpFragment<MessagesContract.View, MessagesContract.Presenter>
        implements MessagesContract.View {

    @Inject
    MessagesPresenter presenter;
    private FragmentMessagesBinding binding;
    private ChannelAdapter adapter = new ChannelAdapter();

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
        setupRecyclerView();

        binding.toolbar.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.menu_logout) {
                            presenter.logout();
                        }
                        return false;
                    }
                }
        );
    }

    @Override
    public void showLoading(Boolean isLoading) {
        binding.progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showChats(List<Message> items) {
        adapter.submit(items);
    }

    @Override
    public void showErrorMessage(@Nullable Throwable throwable) {
        Toast.makeText(this.getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLogoutConfirmed() {
        replace(LoginFragment.create(), R.id.content);
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);
    }
}
