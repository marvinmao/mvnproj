package com.llnqdx.mvnproj.enjoy.jvm03.ch01;

import java.nio.ByteBuffer;

public class DirectMem {

    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocateDirect(1024 * 1024 * 14);
    }

}
