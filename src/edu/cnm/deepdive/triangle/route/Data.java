/**
 * 
 */
package edu.cnm.deepdive.triangle.route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author natedaag
 *
 */
class Data { //package private
  
  int[][] nodes = null;
  
  Data(String file) {
    File inputFile = new File(file);
    try (
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        ) {
          LinkedList<int[]> work = new LinkedList<>();
          String line;
          while ((line = buffer.readLine()) != null) {
             if (line.trim().length() > 0) {
               String[] values = line.trim().split("\\s+");
               int[] intValues = new int[values.length];
               for (int i = 0; i < values.length; i++) {
                 intValues[i] = Integer.parseInt(values[i]);
               }
               work.add(intValues);
             }   
          }
          nodes = work.toArray(new int[0][]); // 0 gives at least one dimension. w/o something can't be done.
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
