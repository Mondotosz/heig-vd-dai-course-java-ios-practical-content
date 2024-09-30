package ch.heigvd.dai.ios.binary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import ch.heigvd.dai.ios.Readable;

/**
 * A class that reads binary files. This implementation reads the file byte per
 * byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    try (
        InputStream fis = new FileInputStream(filename);) {
      while (fis.read() != -1)
        ;
    } catch (IOException e) {
      System.err.println("Exception: " + e);
    }
  }
}
