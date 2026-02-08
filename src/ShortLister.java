import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    JFileChooser fileChooser = new JFileChooser();
    File selectedFile;
    String rec = "";
    ArrayList<String> lines = new ArrayList<>();
    ArrayList<String> filteredLines = new ArrayList<>();
    ShortWordFilter filter = new ShortWordFilter();

    void main(String[] args){
        GetFileFromUser();
        PrintFilteredList();

    }

    void PrintFilteredList(){
        for(String s: lines){//for each line in the file
            String[] Row = s.split(" ");
            for(String word: Row){//for each word in each line
                if(filter.accept(word)){//filter
                    filteredLines.add(word);
                }
            }
        }
        for(String s: filteredLines){
            System.out.println(s);
        }
    }





    public void GetFileFromUser(){
        boolean done = false;

        do {

            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);//set the current directory for the file chooser

            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){//open the chooser
                try {
                    selectedFile = fileChooser.getSelectedFile();
                    Path file = selectedFile.toPath();

                    InputStream in = null;
                    BufferedReader reader = null;

                    try {//attempt to set up the buffered reader and input
                        in =
                                new BufferedInputStream(Files.newInputStream(file, CREATE));
                        reader =
                                new BufferedReader(new InputStreamReader(in));
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    int line = 0;
                    if(reader != null){
                        while (reader.ready()) {
                            rec = reader.readLine();
                            lines.add(rec);  // read all the lines into memory in an array list
                            line++;
                        }
                        reader.close();
                        System.out.println("File read");
                        done = true;
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            if(!done){
                System.out.println("No file chosen! Please choose a file before moving forward.");
            }
        }while(!done);
    }
}
