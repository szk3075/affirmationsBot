package com.fabrikam;

import java.io.*;

public class Affirmation {
    String affirmationForToday;
    int fileLines = 10; //changes depending on how many lines are in the text file

    public String getAffirmation() throws IOException {

        //open and read the file
        FileInputStream fileIN = null;
        BufferedReader br = null;
        try {
            File f = new File("filelocation.txt");
            fileIN=new FileInputStream(f);
             br = new BufferedReader(new InputStreamReader(fileIN));

           int lineNum = (int)(Math.random() * fileLines);

            //retrieve correct line from file
            for(int i=1;i<=lineNum;i++){
                br.readLine();
            }
            affirmationForToday = br.readLine();


        } finally {
            if (fileIN != null) {
                fileIN.close();
                br.close();
            }
        }

        return String.format("\n\nHere's your affirmation for today: \n\n%s",affirmationForToday);
    }

}
