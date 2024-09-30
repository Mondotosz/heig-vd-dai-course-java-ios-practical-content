package ch.heigvd.dai.ios.binary;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import ch.heigvd.dai.ios.Readable;

/**
 * A class that reads binary files. This implementation reads the file using a
 * buffered input
 * stream. It manages the input stream and the buffered input stream properly
 * with a
 * try-with-resources block.
 */
public class BufferedBinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    try (
        InputStream fis = new FileInputStream(filename);
        InputStream bis = new BufferedInputStream(fis)) {
      while (bis.read() != -1)
        ;
    } catch (IOException e) {
      System.err.println("Exception: " + e);
    }
  }
}
