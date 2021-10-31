package com.nick.blog.features.java17;

import java.util.Objects;
import java.util.random.RandomGeneratorFactory;

public class RandomNumberGenerator {
    public static void main(String... args) {
        RandomGeneratorFactory.all()
            .map(fac -> fac.group()+":"+fac.name()
                + " {"
                + (fac.isSplittable()?" splitable":"")
                + (fac.isStreamable()?" streamable":"")
                + (fac.isJumpable()?" jumpable":"")
                + (fac.isArbitrarilyJumpable()?" arbitrary-jumpable":"")
                + (fac.isLeapable()?" leapable":"")
                + (fac.isHardware()?" hardware":"")
                + (fac.isStatistical()?" statistical":"")
                + (fac.isStochastic()?" stochastic":"")
                + " stateBits: "+fac.stateBits()
                + " }"
            )
            .sorted().forEach(System.out::println);
    }
}
