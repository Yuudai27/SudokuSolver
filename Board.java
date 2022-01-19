import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * The Board class provides the main function and can call the layout and field classes and their functions.
 */
public class Board {

    public static void main(String[] args) {
        Layout layout = new Layout();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    layout.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Waiting to be cleared before restarting
        while (!layout.clearState()) {
            layout.setClearState();
            boolean inputError = true;
            int[][][] layoutNumber = new int[9][3][3];
            Field[][] sudokuBoard = new Field[3][3]; //A field array to structure the sudoku board out of 3 times 3 fields
            long timeStart = 0;
            while (inputError) {
                //Waiting until the solve- button gets pressed.
                while (!layout.startSolving()) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                layout.resetSolving();
                //initialize the start time
                Date timer = new Date();
                inputError = false;
                timeStart = timer.getTime();
                layoutNumber = layout.readInput(); //An integer array which reads the input values of the layout
                //checks if the input didn't cause an error, otherwise it returns to wait for solving
                for (int x = 0; x < 9; x++) {
                    for (int y = 0; y < 3; y++) {
                        for (int z = 0; z < 3; z++) {
                            if (layoutNumber[x][y][z] == 11) {
                                inputError = true;
                                break;
                            }
                        }
                    }
                }
            }

            //fieldMatrix arrays define the row and column connection of the single fields
            int[][] fieldMatrixRow = {{3, 6}, {4, 7}, {5, 8}, {0, 6}, {1, 7}, {2, 8}, {0, 3}, {1, 4}, {2, 5}};
            int[][] fieldMatrixColumn = {{1, 2}, {0, 2}, {0, 1}, {4, 5}, {3, 5}, {3, 4}, {7, 8}, {6, 8}, {6, 7}};
            //creating array to get the values for each field separate and pushing it in and initialize them
            int[][] numberPusher = new int[3][3];
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        numberPusher[y][z] = layoutNumber[x][y][z];
                    }
                }
                sudokuBoard[x % 3][x / 3] = new Field(numberPusher);
            }
            //initialization process
            //looping numbers 1 to 9 through the single field, getting there position
            //and updating fields around
            for (int fieldID = 0; fieldID < 9; fieldID++) {
                int searchPosX = 3;
                int searchPosY = 3;
                for (int searchNumber = 1; searchNumber < 10; searchNumber++) {
                    if (sudokuBoard[fieldID % 3][fieldID / 3].valueInRow(searchNumber) != 3) {
                        searchPosX = sudokuBoard[fieldID % 3][fieldID / 3].valueInRow(searchNumber);
                        searchPosY = sudokuBoard[fieldID % 3][fieldID / 3].valueInColumn(searchNumber);
                        //search loop through the row connection matrix of this field-ID and updating this numbers
                        for (int rowMatrix = 0; rowMatrix < fieldMatrixRow[fieldID].length; rowMatrix++) {
                            sudokuBoard[(fieldMatrixRow[fieldID][rowMatrix] % 3)][(fieldMatrixRow[fieldID][rowMatrix] / 3)].updateMarksInRow(searchNumber, searchPosX);
                        }
                        //search loop through the column connection matrix of this field-ID and updating this numbers
                        for (int columnMatrix = 0; columnMatrix < fieldMatrixColumn[fieldID].length; columnMatrix++) {
                            sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(searchNumber, searchPosY);
                        }
                    }
                }
            }
            //checks if the field are already filled and stops as soon as there is a field left which is not completely filled
            boolean readyState = true;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (!sudokuBoard[x][y].fieldReady()) {
                        readyState = false;
                        break;
                    }
                }
            }

            while (!readyState) {
                //start checking for single markers!
                int sumSingleMarkers = 0;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        for (int z = 0; z < 9; z++) {
                            if (sudokuBoard[x][y].sizeMarkers[z] == 1) {
                                sumSingleMarkers++;
                            }
                        }
                    }
                }

                while (sumSingleMarkers > 0) {
                    for (int fieldID = 0; fieldID < 9; fieldID++) {
                        //search positions gets initialized with 3. So its later easier to check if a value got overwritten.
                        int searchPosX = 3;
                        int searchPosY = 3;
                        int singleMarkersCt = 0;
                        //checking for single markers values in the field
                        for (int x = 0; x < 9; x++) {
                            if (sudokuBoard[fieldID % 3][fieldID / 3].sizeMarkers[x] == 1) {
                                singleMarkersCt++;
                            }
                        }
                        //if there is a single marker value left, then continuing checkAllMarks() function
                        while (singleMarkersCt > 0) {
                            //updateArray contains row, column and value a single marker result
                            int[] updateArray = sudokuBoard[fieldID % 3][fieldID / 3].checkAllMarks();
                            if (updateArray[2] != 0) {
                                searchPosX = updateArray[0];
                                searchPosY = updateArray[1];
                                layout.writeInput(fieldID, searchPosX, searchPosY, updateArray[2]);
                                //search loop through the row connection matrix of this field-ID and updating this numbers
                                for (int rowMatrix = 0; rowMatrix < fieldMatrixRow[fieldID].length; rowMatrix++) {
                                    sudokuBoard[fieldMatrixRow[fieldID][rowMatrix] % 3][fieldMatrixRow[fieldID][rowMatrix] / 3].updateMarksInRow(updateArray[2], searchPosX);
                                }
                                //search loop through the column connection matrix of this field-ID and updating this numbers
                                for (int columnMatrix = 0; columnMatrix < fieldMatrixColumn[fieldID].length; columnMatrix++) {
                                    sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(updateArray[2], searchPosY);
                                }
                            }
                            singleMarkersCt--;
                        }
                    }
                    sumSingleMarkers = 0;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            for (int z = 0; z < 9; z++) {
                                if (sudokuBoard[x][y].sizeMarkers[z] == 1) {
                                    sumSingleMarkers++;
                                }
                            }
                        }
                    }
                }

                /**
                 //*************************************************************
                 //print markers again
                 System.out.println("After checking for single markers!");
                 for(int x = 0; x < 9; x++) {
                 System.out.println("*********"+x);
                 sudokuBoard[x%3][x/3].printMarkers();
                 }
                 //wait function for testing steps!
                 while(layout.startSolving() == false) {
                 try
                 {
                 Thread.sleep(2000);
                 }
                 catch(InterruptedException ex)
                 {
                 Thread.currentThread().interrupt();
                 }
                 }
                 layout.resetSolving();
                 //*************************************************************
                 **/

                //check for single appearing numbers
                for (int fieldID = 0; fieldID < 9; fieldID++) {
                    int[] updateArray = sudokuBoard[fieldID % 3][fieldID / 3].checkForSingleAppearingNumbers();
                    if (updateArray[2] != 0) {
                        layout.writeInput(fieldID, updateArray[0], updateArray[1], updateArray[2]);
                        //search loop through the row connection matrix of this field-ID and updating this numbers
                        for (int rowMatrix = 0; rowMatrix < fieldMatrixRow[fieldID].length; rowMatrix++) {
                            sudokuBoard[fieldMatrixRow[fieldID][rowMatrix] % 3][fieldMatrixRow[fieldID][rowMatrix] / 3].updateMarksInRow(updateArray[2], updateArray[0]);
                        }
                        //search loop through the column connection matrix of this field-ID and updating this numbers
                        for (int columnMatrix = 0; columnMatrix < fieldMatrixColumn[fieldID].length; columnMatrix++) {
                            sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(updateArray[2], updateArray[1]);
                        }
                    }
                }

                /**
                 //*************************************************************
                 //print markers again
                 System.out.println("After checking for single appearing markers!");
                 for(int x = 0; x < 9; x++) {
                 System.out.println("*********"+x);
                 sudokuBoard[x%3][x/3].printMarkers();
                 }
                 //wait function for testing steps!
                 while(layout.startSolving() == false) {
                 try
                 {
                 Thread.sleep(2000);
                 }
                 catch(InterruptedException ex)
                 {
                 Thread.currentThread().interrupt();
                 }
                 }
                 layout.resetSolving();
                 //*************************************************************
                 **/

                //checking for double markers and updating all
                for (int fieldID = 0; fieldID < 9; fieldID++) {
                    int[] searchArray = {9, 9, 0, 0};
                    int doubleMarkersCt = 0;
                    //checking for double markers values in the field
                    for (int x = 0; x < 9; x++) {
                        if (sudokuBoard[fieldID % 3][fieldID / 3].sizeMarkers[x] == 2) {
                            doubleMarkersCt++;
                        }
                    }
                    //if there is a single marker value left, then continuing checkAllMarks() function
                    if (doubleMarkersCt > 0) {
                        searchArray = sudokuBoard[fieldID % 3][fieldID / 3].checkDoubleMarks();

                        if (searchArray[0] != 9 && searchArray[1] != 9) {
                            //checking if both values have the same row
                            if (searchArray[0] % 3 == searchArray[1] % 3) {
                                //search loop through the column connection matrix of this field-ID and updating this numbers
                                for (int rowMatrix = 0; rowMatrix < fieldMatrixRow[fieldID].length; rowMatrix++) {
                                    sudokuBoard[fieldMatrixRow[fieldID][rowMatrix] % 3][fieldMatrixRow[fieldID][rowMatrix] / 3].updateMarksInRow(searchArray[2], searchArray[0] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][rowMatrix] % 3][fieldMatrixRow[fieldID][rowMatrix] / 3].updateMarksInRow(searchArray[3], searchArray[0] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][rowMatrix] % 3][fieldMatrixRow[fieldID][rowMatrix] / 3].updateMarksInRow(searchArray[2], searchArray[1] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][rowMatrix] % 3][fieldMatrixRow[fieldID][rowMatrix] / 3].updateMarksInRow(searchArray[3], searchArray[1] % 3);
                                }
                            }
                            //checking if both values have the same column
                            else if (searchArray[0] / 3 == searchArray[1] / 3) {
                                //search loop through the column connection matrix of this field-ID and updating this numbers
                                for (int columnMatrix = 0; columnMatrix < fieldMatrixColumn[fieldID].length; columnMatrix++) {
                                    sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(searchArray[2], searchArray[0] / 3);
                                    sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(searchArray[3], searchArray[0] / 3);
                                    sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(searchArray[2], searchArray[1] / 3);
                                    sudokuBoard[(fieldMatrixColumn[fieldID][columnMatrix] % 3)][(fieldMatrixColumn[fieldID][columnMatrix] / 3)].updateMarksInColumn(searchArray[3], searchArray[1] / 3);
                                }
                            }
                            //checking through the other field if there is a second time this double marker
                            else {
                                //checking through the rows
                                if (sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].checkDoubleMarksInRow(searchArray[0] % 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].updateMarksInRow(searchArray[2], searchArray[0] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].updateMarksInRow(searchArray[3], searchArray[0] % 3);
                                } else if (sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].checkDoubleMarksInRow(searchArray[0] % 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].updateMarksInRow(searchArray[2], searchArray[0] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].updateMarksInRow(searchArray[3], searchArray[0] % 3);
                                }
                                if (sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].checkDoubleMarksInRow(searchArray[1] % 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].updateMarksInRow(searchArray[2], searchArray[1] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].updateMarksInRow(searchArray[3], searchArray[1] % 3);
                                } else if (sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].checkDoubleMarksInRow(searchArray[1] % 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].updateMarksInRow(searchArray[2], searchArray[1] % 3);
                                    sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].updateMarksInRow(searchArray[3], searchArray[1] % 3);
                                }
                                //checking through the columns
                                if (sudokuBoard[(fieldMatrixColumn[fieldID][0] % 3)][(fieldMatrixColumn[fieldID][0] / 3)].checkDoubleMarksInColumn(searchArray[0] / 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixColumn[fieldID][1] % 3][fieldMatrixColumn[fieldID][1] / 3].updateMarksInColumn(searchArray[2], searchArray[0] / 3);
                                    sudokuBoard[fieldMatrixColumn[fieldID][1] % 3][fieldMatrixColumn[fieldID][1] / 3].updateMarksInColumn(searchArray[3], searchArray[0] / 3);
                                } else if (sudokuBoard[(fieldMatrixColumn[fieldID][1] % 3)][(fieldMatrixColumn[fieldID][1] / 3)].checkDoubleMarksInColumn(searchArray[0] / 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixColumn[fieldID][0] % 3][fieldMatrixColumn[fieldID][0] / 3].updateMarksInColumn(searchArray[2], searchArray[0] / 3);
                                    sudokuBoard[fieldMatrixColumn[fieldID][0] % 3][fieldMatrixColumn[fieldID][0] / 3].updateMarksInColumn(searchArray[3], searchArray[0] / 3);
                                }
                                if (sudokuBoard[(fieldMatrixColumn[fieldID][0] % 3)][(fieldMatrixColumn[fieldID][0] / 3)].checkDoubleMarksInColumn(searchArray[1] / 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixColumn[fieldID][1] % 3][fieldMatrixColumn[fieldID][1] / 3].updateMarksInColumn(searchArray[2], searchArray[1] / 3);
                                    sudokuBoard[fieldMatrixColumn[fieldID][1] % 3][fieldMatrixColumn[fieldID][1] / 3].updateMarksInColumn(searchArray[3], searchArray[1] / 3);
                                } else if (sudokuBoard[(fieldMatrixColumn[fieldID][1] % 3)][(fieldMatrixColumn[fieldID][1] / 3)].checkDoubleMarksInColumn(searchArray[1] / 3, searchArray[2], searchArray[3])) {
                                    sudokuBoard[fieldMatrixColumn[fieldID][0] % 3][fieldMatrixColumn[fieldID][0] / 3].updateMarksInColumn(searchArray[2], searchArray[1] / 3);
                                    sudokuBoard[fieldMatrixColumn[fieldID][0] % 3][fieldMatrixColumn[fieldID][0] / 3].updateMarksInColumn(searchArray[3], searchArray[1] / 3);
                                }
                            }
                        } else if (searchArray[0] != 9 && searchArray[1] == 9) {
                            //testing single double values
                            //checking through the rows
                            if (sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].checkDoubleMarksInRow(searchArray[0] % 3, searchArray[2], searchArray[3])) {
                                sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].updateMarksInRow(searchArray[2], searchArray[0] % 3);
                                sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].updateMarksInRow(searchArray[3], searchArray[0] % 3);
                            } else if (sudokuBoard[fieldMatrixRow[fieldID][1] % 3][fieldMatrixRow[fieldID][1] / 3].checkDoubleMarksInRow(searchArray[0] % 3, searchArray[2], searchArray[3])) {
                                sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].updateMarksInRow(searchArray[2], searchArray[0] % 3);
                                sudokuBoard[fieldMatrixRow[fieldID][0] % 3][fieldMatrixRow[fieldID][0] / 3].updateMarksInRow(searchArray[3], searchArray[0] % 3);
                            }
                            //checking through the columns
                            if (sudokuBoard[(fieldMatrixColumn[fieldID][0] % 3)][(fieldMatrixColumn[fieldID][0] / 3)].checkDoubleMarksInColumn(searchArray[0] / 3, searchArray[2], searchArray[3])) {
                                sudokuBoard[fieldMatrixColumn[fieldID][1] % 3][fieldMatrixColumn[fieldID][1] / 3].updateMarksInColumn(searchArray[2], searchArray[0] / 3);
                                sudokuBoard[fieldMatrixColumn[fieldID][1] % 3][fieldMatrixColumn[fieldID][1] / 3].updateMarksInColumn(searchArray[3], searchArray[0] / 3);
                            } else if (sudokuBoard[(fieldMatrixColumn[fieldID][1] % 3)][(fieldMatrixColumn[fieldID][1] / 3)].checkDoubleMarksInColumn(searchArray[0] / 3, searchArray[2], searchArray[3])) {
                                sudokuBoard[fieldMatrixColumn[fieldID][0] % 3][fieldMatrixColumn[fieldID][0] / 3].updateMarksInColumn(searchArray[2], searchArray[0] / 3);
                                sudokuBoard[fieldMatrixColumn[fieldID][0] % 3][fieldMatrixColumn[fieldID][0] / 3].updateMarksInColumn(searchArray[3], searchArray[0] / 3);
                            }
                        }
                    }
                }

                /**
                 //*************************************************************
                 //print markers again
                 System.out.println("After checking for double markers!");
                 for(int x = 0; x < 9; x++) {
                 System.out.println("*********"+x);
                 sudokuBoard[x%3][x/3].printMarkers();
                 }
                 //wait function for testing steps!
                 while(layout.startSolving() == false) {
                 try
                 {
                 Thread.sleep(2000);
                 }
                 catch(InterruptedException ex)
                 {
                 Thread.currentThread().interrupt();
                 }
                 }
                 layout.resetSolving();
                 //*************************************************************
                 **/
                //The ready state of the fields will be rechecked once again, if all field are already filled
                readyState = true;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (!sudokuBoard[x][y].fieldReady()) {
                            readyState = false;
                            break;
                        }
                    }
                    if (!readyState) {
                        break;
                    }
                }
                Date testTimer = new Date();
                long testTime = testTimer.getTime();
                if ((testTime - timeStart) / 1000 > 15) {
                    JOptionPane.showMessageDialog(null, "The solving process unfortunately failed! We'll work on that.", "Timeout Error", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            //The end timer gets initialized and written into the text field in the layout.
            Date endTimer = new Date();
            long endTime = endTimer.getTime();
            layout.setTime(endTime - timeStart);
            //Waiting for pressed clear button
            while (layout.clearState()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
