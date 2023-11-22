package com.practice.reactivepractice.stream;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPub implements Publisher<Integer> {

    Iterable<Integer> its = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        System.out.println("cus : subscribe newspaper");
        System.out.println("com : ok --- please wait for you sub info");
        MySubscription subscription = new MySubscription(s, its);
        System.out.println("com : complete creating sub info");
        s.onSubscribe(subscription);
    }
}
