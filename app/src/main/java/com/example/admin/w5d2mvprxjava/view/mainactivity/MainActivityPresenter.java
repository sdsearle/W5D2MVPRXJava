package com.example.admin.w5d2mvprxjava.view.mainactivity;

import com.example.admin.w5d2mvprxjava.model.RXFunctions;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 9/26/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;


    private Observer<Integer> integerObserver = new Observer<Integer>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            System.out.println("onSubscribe: ");
        }

        @Override
        public void onNext(@NonNull Integer integer) {
            view.onObserverClicked(String.valueOf(integer));
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println("onError: ");
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete: ");
        }
    };

    RXFunctions rxFunctions = new RXFunctions(integerObserver);

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void validateJust() {
        rxFunctions.just();
    }

    @Override
    public void validateRange() {
        rxFunctions.range();
    }

    @Override
    public void validateRepeat() {
        rxFunctions.repeat();
    }

    @Override
    public void validateMap() {
        rxFunctions.map();
    }

    @Override
    public void validateScan() {
        rxFunctions.scan();
    }

    @Override
    public void validateBuffer() {
        rxFunctions.buffer();
    }

    @Override
    public void validateTake() {
        rxFunctions.take();
    }

    @Override
    public void validateSkip() {
        rxFunctions.skip();
    }

    @Override
    public void validateDebounce() {
        try {
            rxFunctions.debounce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void validateStartwith() {
        rxFunctions.startWith();
    }

    @Override
    public void validateCombine() {
        rxFunctions.combineLatest();
    }

    @Override
    public void validateMerge() {
        rxFunctions.merge();
    }

    @Override
    public void validateSort() {
        rxFunctions.sort();
    }

    @Override
    public void validateConcat() {
        rxFunctions.concat();
    }

    @Override
    public void validateReduce() {
        rxFunctions.reduce();
    }
}
