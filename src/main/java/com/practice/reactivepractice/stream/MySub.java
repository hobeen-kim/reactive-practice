package com.practice.reactivepractice.stream;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;
    private int bufferSize = 3;


    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("cus : got sub info!");
        this.s = s;
        System.out.println("cus : give me 1 everyday");
        s.request(bufferSize); // 신문 한개씩 매일 매일 줘!!
    }

    @Override
    public void onNext(Integer t) {
        System.out.println("onNext() : " + t);
        bufferSize--;
        if(bufferSize == 0) {
            System.out.println("next day");
            bufferSize = 3;
            s.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("구독 중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
