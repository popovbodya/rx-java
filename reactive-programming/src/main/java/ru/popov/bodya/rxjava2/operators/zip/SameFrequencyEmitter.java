package ru.popov.bodya.rxjava2.operators.zip;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class SameFrequencyEmitter {

    public static void main(String[] args) {
        emitWithSameFreq();
    }

    private static void emitWithSameFreq() {

        Observable<Long> red = Observable.interval(10, TimeUnit.MILLISECONDS);
        Observable<Long> green = Observable.interval(10, TimeUnit.MILLISECONDS);

        Observable
                .zip(red.timestamp(), green.timestamp(), (redLongTimed, greenLongTimed) -> redLongTimed.time() - greenLongTimed.time())
                .blockingSubscribe(System.out::println);
    }

}
