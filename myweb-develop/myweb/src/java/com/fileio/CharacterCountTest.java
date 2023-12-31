package com.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author t
 */
public class CharacterCountTest {

    public static void main(String[] args) {
        String fileName = "file/說明.txt";
        File file = new File(fileName);
        Reader reader = null;
        try {
            List<Character> chars = new ArrayList<Character>();
            long charCount = 0;
            // 一次讀一个字符
            reader = new InputStreamReader(new FileInputStream(file), "gbk");
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                charCount++;

                Character ch = (char) tempchar;
                if (!chars.contains(ch)) {
                    chars.add(ch);
                }
            }

            Collections.sort(chars);

            System.out.print("总字數" + charCount);
            System.out.println("，共有" + chars.size() + "個不同的字：");
            int index = 0;
            for (Character ch : chars) {
                index++;
                System.out.print(ch);
                if (index % 100 == 0) {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
