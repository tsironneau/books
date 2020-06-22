package com.greglturnquist.learningspringboot.learningspringboot;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Flux.just("alpha", "bravo", "charlie")
            .map(String::toUpperCase)
            .flatMap(s -> Flux.fromArray(s.split("")))
            .groupBy(String::toString)
            .sort(Comparator.comparing(GroupedFlux::key))
            .flatMap(group -> Mono.just(Objects.requireNonNull(group.key())).zipWith(group.count()))
            .map(keyAndCount -> keyAndCount.getT1() + "=>" + keyAndCount.getT2())
            .subscribe(System.out::println);
    }
}
