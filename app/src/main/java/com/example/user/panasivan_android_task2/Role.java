package com.example.user.panasivan_android_task2;

public enum Role {
    ACTOR("Actor"), WRITER("Writer"), DIRECTOR("Director");

    private String description;

    private final String val;

    private Role(String val) {
        this.val = val;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s %s",val, description);
    }
}
