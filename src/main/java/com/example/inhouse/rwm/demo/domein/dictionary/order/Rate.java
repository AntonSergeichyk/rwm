package com.example.inhouse.rwm.demo.domein.dictionary.order;

import lombok.Getter;

@Getter
public enum Rate {
    FULL(1.0),
    REDUCED(0.8);

    Rate(double v) {
        this.val = v;
    }

    private final double val;
}
