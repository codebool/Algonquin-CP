/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-08-09
 * Modified: 2024-08-09
 * Description: Test 02
 */

package Test02;

import java.io.*;

public class SplitLargeFile {
    public static void main(String[] args) {
        // Check usage of this program
        if (args.length != 2) {
            System.out.println("Usage: java SplitLargeFile sourceFile numberOfPieces");
            System.exit(1);
        }

        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(args[0])));
            int numberOfPieces = Integer.parseInt(args[1]);
            long fileSize = input.available();
            System.out.println("File size: " + fileSize + " bytes");
            int splitFileSize = (int) Math.ceil(1.0 * fileSize / numberOfPieces);
            for (int i = 1; i <= numberOfPieces; i++) {
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(args[0] + "." + i)));
                int value;
                int count = 0;
                while (count++ < splitFileSize && (value = input.read()) != -1) {
                    output.write(value);
                }
                output.close();
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
