package com.chyngyz.quwitestapp.common.mvp;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public interface MvpView {
    void showErrorMessage(@Nullable Throwable throwable);
    void showErrorMessage(@StringRes int message);
}