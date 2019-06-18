package org.academiadecodigo.joaoribeiro.fileManager;

import org.academiadecodigo.joaoribeiro.grid.GridAccessController;
import org.academiadecodigo.joaoribeiro.grid.GridPosition;

import java.io.*;

public class FileManager {

    private GridAccessController gridAccessController;

    public FileManager(GridAccessController gridAccessController) {
        this.gridAccessController = gridAccessController;
    }

    public void saveStatus(String file) throws IOException {

        FileWriter writer = new FileWriter(file);

        BufferedWriter bWriter = new BufferedWriter(writer);

        // first line is related to the user

        bWriter.write(gridAccessController.getUser().getPos().getCol() + " " + gridAccessController.getUser().getPos().getRow());
        bWriter.newLine();
        bWriter.flush();

        GridPosition[][] layout = gridAccessController.getGrid().getLayout();

        for (int i = 0; i < gridAccessController.getGrid().getLayout().length; i++) {
            for (int j = 0; j < gridAccessController.getGrid().getLayout()[0].length; j++) {

                GridPosition cell = layout[i][j];

                if(cell.isActive()) {
                    bWriter.write(cell.getCol() + " " + cell.getRow());
                    bWriter.newLine();
                    bWriter.flush();
                }
            }
        }

        bWriter.flush();
        bWriter.close();
    }

    public void loadStatus(String file) {
        // TODO Load text file
    }


}
