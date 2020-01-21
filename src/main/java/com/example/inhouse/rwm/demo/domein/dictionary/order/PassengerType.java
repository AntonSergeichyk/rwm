package com.example.inhouse.rwm.demo.domein.dictionary.order;

import lombok.Getter;

@Getter
public enum PassengerType {
    ADULT(1.0),
    CHILD(0.9);

    PassengerType(double v) {
        this.val = v;
    }

    private final double val;
}
