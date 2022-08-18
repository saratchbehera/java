package com.sarat.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadLargeFiles {



    private void copyUsingChannel(String source, String target) throws IOException {

        try (
                FileChannel inputChannel = new FileInputStream(source).getChannel();
                FileChannel outputChannel = new FileOutputStream(target).getChannel();
        ) {


            ByteBuffer buffer = ByteBuffer.allocateDirect(4 * 1024);
            while (inputChannel.read(buffer) != -1) {
                buffer.flip();
                outputChannel.write(buffer);
                buffer.clear();
            }
        }
    }
}
