package com.cbaek.museums;

import com.google.auto.value.AutoValue;

/**
 * A Museum entity class
 */
@AutoValue
public abstract class Museum {

    public abstract String name();

    public abstract String imageUrl();

    public static Museum create(final String name, final String imageUrl) {
        return new AutoValue_Museum(name, imageUrl);
    }

}
