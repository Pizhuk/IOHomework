package main.com;

import main.com.ioservices.IOService;

import java.io.File;

public class Main {
    public static void main(String[] args) throws IOService.NullFileArrayException, IOService.TooManyFilesInArrayException {
        File file1 = new File("C:\\Users\\1\\Desktop\\~javaProjects\\IOHomework\\src\\files\\file1.txt");
        File file2 = new File("C:\\Users\\1\\Desktop\\~javaProjects\\IOHomework\\src\\files\\file2.txt");
        File file3 = new File("C:\\Users\\1\\Desktop\\~javaProjects\\IOHomework\\src\\files\\file3.txt");

        File[] files = new File[]{file1, file2};

        IOService ioService = new IOService(files, file3);
        ioService.writeInTheBegin();
    }
}
