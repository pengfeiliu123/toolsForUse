package com.lpf.tools.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by lpf on 2018/7/30 08:06.
 */
public abstract class BasePresenter<T> {

    protected Reference<T> mViewRef;    // View接口类型的弱引用

    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    public T getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView(T view) {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
