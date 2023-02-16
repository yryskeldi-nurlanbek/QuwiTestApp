package com.chyngyz.quwitestapp.common.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chyngyz.quwitestapp.common.view.BaseFragment;

public abstract class BaseMvpFragment<V extends MvpView, P extends MvpPresenter<V>>
        extends BaseFragment implements MvpView {

    private P presenter;

    protected void setPresenter(P presenter){
        this.presenter = presenter;
    }

    @CallSuper
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attach((V) this);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detach();
    }

    @Override
    public void showErrorMessage(@Nullable Throwable throwable) {
        Toast.makeText(requireContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(int message) {
        Toast.makeText(requireContext(), getString(message), Toast.LENGTH_SHORT).show();
    }
}