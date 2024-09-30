package ch.heigvd.dai.ios.binary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import ch.heigvd.dai.ios.Writable;

/**
 * A class that writes binary files. This implementation writes the file byte
 * per byte. It manages
 * the file output stream properly with a try-catch-finally block.
 */
public class BinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    try (OutputStream fos = new FileOutputStream(filename);) {
      for (int i = 0; i < sizeInBytes; ++i) {
        fos.write(i);
      }
    } catch (IOException e) {
      System.err.println("Exception: " + e);
    }
  }
}
