package com.problem1.sorting;

import java.io.*;
import java.util.*;

/**
 * http://www.ashishsharma.me/2011/08/external-merge-sort.html
 */
public class ExternalSort {

    String inputFile;
    String outputFile;
    Comparator<String> stringComparator;
    static final int MAXTEMPFILES = 1024;

    ExternalSort(String inputFile, String outputFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //System.out.println("Enter input file name");
        String inputFile = "/Users/sowmyaparameshwara/passion/AlgorithmsAndDataStructure/input.txt";
        System.out.println("Enter output file name");
        String outputFile = in.nextLine();
        ExternalSort externalSort = new ExternalSort(inputFile,outputFile);
        externalSort.sortFiles();
    }

    private void sortFiles() throws IOException {
        List<File> files = sortInBatch();
        mergeSortedFiles(files);

    }

    private void mergeSortedFiles(List<File> files) throws IOException {
        PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<>(new Comparator<BinaryFileBuffer>() {
            @Override
            public int compare(BinaryFileBuffer o1, BinaryFileBuffer o2) {
                return stringComparator.compare(o1.peek(),o2.peek());
            }
        });
        for(File file: files){
            pq.add(new BinaryFileBuffer(file));
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        try{
            while(pq.size()>0){
                BinaryFileBuffer binaryFileBuffer = pq.poll();
                String word = binaryFileBuffer.poll();
                bufferedWriter.write(word);
                bufferedWriter.newLine();
                if(binaryFileBuffer.empty){
                    binaryFileBuffer.bufferedReader.close();
                    binaryFileBuffer.file.delete();
                }else{
                    pq.add(binaryFileBuffer);
                }
            }
        } finally {
            bufferedWriter.close();
            for(BinaryFileBuffer binaryFileBuffer: pq){
                binaryFileBuffer.close();
            }
        }

    }

    private List<File> sortInBatch() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        long blockSize = calculateBlockSize(inputFile.length());
        List<File> sortedFiles = new ArrayList<>();
        String line="";
        List<String> tempData = new ArrayList<>();
        try{
            while(line!=null){
                long currentBlockSize=0;
                while(currentBlockSize<blockSize && (line=bufferedReader.readLine())!=null){
                    tempData.add(line);
                    currentBlockSize += line.length();
                }
                sortedFiles.add(sortAndSave(tempData));
                tempData.clear();
            }
        } catch(EOFException oef) {
                if(tempData.size()>0) {
                    sortedFiles.add(sortAndSave(tempData));
                    tempData.clear();
                }
        } finally {
                bufferedReader.close();
        }
        return sortedFiles;
    }

    private File sortAndSave(List<String> tempData) throws IOException {
        Collections.sort(tempData);
        File tempFile = File.createTempFile("batch","tempFile");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
        try{
            for(String l: tempData){
                bufferedWriter.write(l);
                bufferedWriter.newLine();
            }
        } finally {
            bufferedWriter.close();
        }

        return tempFile;
    }

    private long calculateBlockSize(int fileSize) {
        long blockSize = fileSize / MAXTEMPFILES;
        long freeMemory = Runtime.getRuntime().freeMemory();
        if(blockSize<freeMemory/2){
            blockSize = freeMemory/2;
        }else{
            if(blockSize>freeMemory){
                System.err.println("We will run out of memory");
            }
        }
        return blockSize;
    }
}

class BinaryFileBuffer{

    public static int BUFFERSIZE=2048;
    BufferedReader bufferedReader;
    boolean empty;
    String cache;
    File file;

    BinaryFileBuffer(File file) throws IOException {
        this.file = file;
        bufferedReader = new BufferedReader(new FileReader(file),BUFFERSIZE);
        reload();

    }

    private void reload() throws IOException {
        try {
            if((cache=bufferedReader.readLine())==null){
                empty = true;
                cache = null;
            }else{
                empty = false;
            }
        } catch (EOFException e) {
            empty = true;
            cache = null;
        }

    }

    void close() throws IOException {
        bufferedReader.close();
    }

    String peek(){
        if(empty)
            return null;
        else
            return cache;
    }

    String poll() throws IOException {
        String result = peek();
        reload();
        return result;
    }

}
