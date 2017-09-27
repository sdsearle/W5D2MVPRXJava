package com.example.admin.w5d2mvprxjava.view.mainactivity;

import com.example.admin.w5d2mvprxjava.BasePresenter;
import com.example.admin.w5d2mvprxjava.BaseView;

/**
 * Created by admin on 9/26/2017.
 */

public interface MainActivityContract {
    interface  View extends BaseView {
        void onObserverClicked(String s);
    }

    interface Presenter extends BasePresenter<View> {
        void validateJust();

        void validateRange();

        void validateRepeat();

        void validateMap();

        void validateScan();

        void validateBuffer();

        void validateTake();

        void validateSkip();

        void validateDebounce();

        void validateStartwith();

        void validateCombine();

        void validateMerge();

        void validateSort();

        void validateConcat();

        void validateReduce();
    }

}
