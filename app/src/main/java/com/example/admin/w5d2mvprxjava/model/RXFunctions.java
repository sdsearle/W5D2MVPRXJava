package com.example.admin.w5d2mvprxjava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by admin on 9/26/2017.
 */

public class RXFunctions {
    private Observer<Integer> integerObserver;

    public RXFunctions(Observer<Integer> integerObserver) {
        this.integerObserver = integerObserver;
    }

    public void just() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);



        integerObservable.
                subscribe(integerObserver);
    }

    public void range() {
        Observable<Integer> integerObservable = Observable.range(1, 11);
        integerObservable.subscribe(integerObserver);
    }

    public void repeat() {
        Observable<Integer> integerObservable = Observable.just(33, 2, 5, 7, 9, 20).repeat(3);
        integerObservable.subscribe(integerObserver);
    }

    public void map() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).
                map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        return integer * (10 / integer);
                    }
                });
        integerObservable.subscribe(integerObserver);
    }

    public void scan() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        integerObservable.subscribe(integerObserver);
    }

    public void buffer() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .buffer(4,5).flatMapIterable(new Function<List<Integer>, Iterable<? extends Integer>>() {
                    @Override
                    public Iterable<? extends Integer> apply(@NonNull List<Integer> integers) throws Exception {
                        return integers;
                    }
                }, new BiFunction<List<Integer>, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull List<Integer> integers, @NonNull Integer integer) throws Exception {
                        return integer;
                    }
                });
        integerObservable.subscribe(integerObserver);
    }

    public void take() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).take(5);
        integerObservable.subscribe(integerObserver);
    }

    public void skip() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).skip(5);
        integerObservable.subscribe(integerObserver);
    }

    public void debounce() throws InterruptedException {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).debounce(1, TimeUnit.SECONDS);
        integerObservable.subscribe(integerObserver);

        Thread.sleep(1000);
    }

    public void startWith() {
        Observable<Integer> oneObservable = Observable.just(33, 2, 5, 7, 9, 20);
        Observable<Integer> twoObservable = Observable.just(10, 5, 8, 61, 46);
        Observable<Integer> integerObservable = Observable.just(0,1,2).startWith(oneObservable).startWith(twoObservable);
        integerObservable.subscribe(integerObserver);
    }

    public void combineLatest() {
        Observable<Integer> oneObservable = Observable.just(33, 2, 5, 7, 9, 20);
        Observable<Integer> twoObservable = Observable.just(10, 5, 8, 61, 46);
        Observable<Integer> integerObservable = Observable.combineLatest(oneObservable, twoObservable, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        integerObservable.subscribe(integerObserver);
    }

    public void merge() {
        Observable<Integer> oneObservable = Observable.just(33, 2, 5, 7, 9, 20);
        Observable<Integer> twoObservable = Observable.just(10, 5, 8, 61, 46);
        Observable<Integer> integerObservable = Observable.merge(oneObservable, twoObservable);
        integerObservable.subscribe(integerObserver);
    }

    public void sort() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        integerObservable.sorted();
        integerObservable.subscribe(integerObserver);
    }

    public void concat() {
        Observable<Integer> oneObservable = Observable.just(33, 2, 5, 7, 9, 20);
        Observable<Integer> twoObservable = Observable.just(10, 5, 8, 61, 46);
        Observable<Integer> integerObservable = Observable.concat(oneObservable,twoObservable);
        integerObservable.subscribe(integerObserver);
    }

    public void reduce() {
        Observable<Integer> oneObservable = Observable.just(33, 2, 5, 7, 9, 20);
        Observable<Integer> twoObservable = Observable.just(10, 5, 8, 61, 46);
        Observable<Integer> integerObservable = Observable.merge(oneObservable, twoObservable).reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return (integer+integer2)/integer2;
            }
        }).toObservable();
        integerObservable.subscribe(integerObserver);
    }

}
