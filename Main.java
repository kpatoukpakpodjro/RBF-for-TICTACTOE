package com.lsi.csv;

import java.io.FileWriter;

public class Main {

  public static void main(String[] args) {

	  String filePath = "tictactoe.csv";
	  
	  System.out.println("starting write user.csv file: " + filePath);
       

    Maker maker = new Maker();
        maker.getPossibleBoards().forEach(Main::printBoard);
        FileWriter fileWriter = null;
        try {
         fileWriter = new FileWriter(filePath);
         fileWriter.append("i1,i2,i3,i4,i5,i6,i7,i8,i9,a1,a2,a3,a4,a5,a6,a7,a8,a9\n");
        for (int i = 0; i < maker.getPossibleBoards().size(); i++) {
            System.out.println(""+i+"| "+printBoard(maker.getPossibleBoards().get(i)));
        
            fileWriter.append(printBoard(maker.getPossibleBoards().get(i))+"\n");
        }}catch (Exception ex) {
        	   ex.printStackTrace();
        }
        finally {
        	   try {
        	    fileWriter.flush();
        	    fileWriter.close();
        	   } catch (Exception e) {
        	    e.printStackTrace();
        	   }}

    //      System.out.println(maker.getPossibleBoards().size());
    //    for (int i = 0; i < maker.getPossibleBoards().size(); i++) {
    //      System.out.println(printChoice(maker.getOptimalMoves().get(i)));
    //    }
    //      System.out.println(maker.getOptimalMoves().size());
    //  }
   
  }

  public static String getRepresentation(byte b) {
    if (b == Maker.EMPTY) {
      return "0.2";
    } else if (b == Maker.COMPUTER) {
      return "0.4";
    } else {
      return "0.8"; // Maker.PLAYER_ONE
    }
  }

  public static String printBoard(Byte[] board) {
    StringBuilder stringBuilder = new StringBuilder();
//    stringBuilder.append('[');
    for (int i = 0; i < 9; i++) {
      stringBuilder.append(getRepresentation(board[i]));
      stringBuilder.append(", ");
    }
//    stringBuilder.append(getRepresentation(board[8]));
//    stringBuilder.append("]");
    return stringBuilder.toString();
  }

  public static String printChoice(Byte[] choices) {
    StringBuilder stringBuilder = new StringBuilder();
//    stringBuilder.append('[');
    for (int i = 0; i < 8; i++) {
      stringBuilder.append(choices[i]);
      stringBuilder.append(", ");
    }
    stringBuilder.append(choices[8]);
//    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
