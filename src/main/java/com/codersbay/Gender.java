package com.codersbay;

public enum Gender {
    MALE,
    FEMALE,
    OTHER;


    public static Gender[] getGenders() {
        return new Gender[]{MALE, FEMALE, OTHER};

    }
}
