package ch.heigvd.dai.ios.binary;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import ch.heigvd.dai.ios.Writable;

/**
 * A class that writes binary files. This implementation writes the file using a
 * buffered output
 * stream. It manages the file output stream properly with a try-with-resources
 * block.
 */
public class BufferedBinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    try (OutputStream fos = new FileOutputStream(filename); OutputStream bos = new BufferedOutputStream(fos)) {
      for (int i = 0; i < sizeInBytes; ++i) {
        bos.write(i);
      }
      bos.flush();
    } catch (IOException e) {
      System.err.println("Exception: " + e);
    }
  }
}
