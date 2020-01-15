package com.openshift.demo;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.io.*;
import java.util.ArrayList;

public class Fet {
    private ArrayList<String> list;
    private final String path = "src/main/java/com/openshift/demo/poem";

    public Fet(){
        this.list = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String poem = "";
            String line = reader.readLine();
            while (line != null) {
                if(line.equals("")) {
                    list.add(poem);
                    poem = "";
                }
                else {
                    poem += line + "<br>";
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRow(int number){
        if(number < 0 || number >= list.size()) return "Потому что есть Алёшка у тебя";

        return list.get(number);
    }
}
