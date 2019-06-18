package org.academiadecodigo.joaoribeiro.fileManager;

import org.academiadecodigo.joaoribeiro.grid.GridAccessController;
import org.academiadecodigo.joaoribeiro.grid.GridPosition;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private GridAccessController gridAccessController;

    public FileManager(GridAccessController gridAccessController) {
        this.gridAccessController = gridAccessController;
    }

    public void saveStatus(String file) throws IOException {

        FileWriter writer = new FileWriter(file);

        BufferedWriter bWriter = new BufferedWriter(writer);

        for (int i = 0; i < gridAccessController.gridWidth(); i++) {
            for (int j = 0; j < gridAccessController.gridWidth() ; j++) {

                if(gridAccessController.checkIfCellIsActive(i, j)) {
                    bWriter.write(i + " " + j);
                    bWriter.newLine();
                    bWriter.flush();
                }
            }
        }

        bWriter.flush();
        bWriter.close();
    }

    public void loadStatus(String file) throws IOException {
        // TODO Load text file

        List<int[]> loadedCellsList = new ArrayList<>();

        FileReader reader = new FileReader(file);

        BufferedReader bReader = new BufferedReader(reader);

        String line = bReader.readLine();

        loadedCellsList.add(checkValidData(line.split(" ")));

        while ( (line = bReader.readLine()) != null ) {
            loadedCellsList.add(checkValidData(line.split(" ")));
        }

        if(loadedCellsList.size() == 0) {
            System.out.println("No data to read.");
        } else {
            Object[] arrayFromList = loadedCellsList.toArray();
            int[][] loadedCellsArray = convertList(arrayFromList);
            System.out.println(loadedCellsArray[1][0]);
            gridAccessController.resetCellStatus(loadedCellsArray);
        }

        bReader.close();
    }


    private int[][] convertList(Object[] arr) {

        int[][] mArray = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            mArray[i] = (int[])arr[i];
        }

        return mArray;
    }

    private int[] checkValidData(String[] line) {

        int[] lineInt = new int[2];

        try {
            lineInt[0] = Integer.parseInt(line[0]);
            lineInt[1] = Integer.parseInt(line[1]);
        } catch (Exception ex) {
            System.out.println("Saved data is corrupt.");
        }

        return lineInt;
    }

}
