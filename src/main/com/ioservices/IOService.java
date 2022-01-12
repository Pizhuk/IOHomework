package main.com.ioservices;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOService {
    private File[] files;
    private File fileChange;

    public IOService(File[] files, File fileChange) throws NullFileArrayException, TooManyFilesInArrayException {
        if (files.length >= 1 && files.length <= 127){
            this.files = files;
            this.fileChange = fileChange;
        }
        else if(files.length == 0){
            throw new NullFileArrayException("THERE ARE NO FILES IN ARRAY");
        }
        else {
            throw new TooManyFilesInArrayException("THERE TOO MANY FILES IN ARRAY");
        }

    }

    public File[] getFiles() {
        return files;
    }

    public File getFileChange() {
        return fileChange;
    }

    public void clearAndWrite(){
        try {
            FileOutputStream fos = new FileOutputStream(getFileChange());
            byte[] buffer = "".getBytes();
            fos.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < getFiles().length; i++){
            try {
                FileInputStream fis = new FileInputStream(getFiles()[i]);
                int integer=-1;
                String str = "";
                while((integer=fis.read())!=-1){
                    str = str + (char)integer;
                }

                FileOutputStream fos = new FileOutputStream(getFileChange(), true);
                byte[] buffer = str.getBytes();
                fos.write(buffer, 0, buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeInTheBegin(){
        String helpStr = "";
        try {
            FileInputStream fis = new FileInputStream(getFileChange());
            int integer=-1;
            while((integer=fis.read())!=-1){
                helpStr = helpStr + (char)integer;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream(getFileChange());
            byte[] buffer = "".getBytes();
            fos.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < getFiles().length; i++){
            try {
                FileInputStream fis = new FileInputStream(getFiles()[i]);
                int integer=-1;
                String str = "";
                while((integer=fis.read())!=-1){
                    str = str + (char)integer;
                }

                FileOutputStream fos = new FileOutputStream(getFileChange(), true);
                byte[] buffer = str.getBytes();
                fos.write(buffer, 0, buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(getFileChange(), true);
            byte[] buffer = helpStr.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInTheEnd(){
        for (int i = 0; i < getFiles().length; i++){
            try {
                FileInputStream fis = new FileInputStream(getFiles()[i]);
                int integer=-1;
                String str = "";
                while((integer=fis.read())!=-1){
                    str = str + (char)integer;
                }

                FileOutputStream fos = new FileOutputStream(getFileChange(), true);
                byte[] buffer = str.getBytes();
                fos.write(buffer, 0, buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class NullFileArrayException extends Exception{
        public NullFileArrayException(String message){
            super(message);
        }
    }

    public class TooManyFilesInArrayException extends Exception{
        public TooManyFilesInArrayException(String message){
            super(message);
        }
    }
}
