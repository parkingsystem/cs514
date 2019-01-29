import java.util.HashMap;

import javax.xml.stream.events.ProcessingInstruction;

public class ChessBoard  {

  
   //	TODO
  private ChessPiece[][] board;
  
  //a=0
  private HashMap<String, Integer> hashmap = new HashMap<>();
  
  public HashMap<String, Integer> getHashmap() {
	return hashmap;
}

public ChessBoard()
  {
	  this.board = new ChessPiece [8][8];
	  
	  hashmap.put("a", 0);
	  hashmap.put("b", 1);
	  hashmap.put("c", 2);
	  hashmap.put("d", 3);
	  hashmap.put("e", 4);
	  hashmap.put("f", 5);
	  hashmap.put("g", 6);
	  hashmap.put("h", 7);
  }
  
  public void intialize() throws IllegalPositionExcelption {
	  //call contstructor of all pieces
	
    ChessPiece whiteRook = new Rook(this, ChessPiece.Color.BLACK);

	 boolean validPlacement=  this.placePiece(whiteRook, "d8") ;
	 
	 //ROOK legal moves
	 
	System.out.println("--Legal moves--");
	for( String s  : whiteRook.legalMoves())
	{
		System.out.println(s);
	}
	System.out.println("--Legal moves--");  
	  
	 //no two same pieces on the SAME spot
	// boolean validPlacement1=  this.placePiece(whiteRook, "d8") ;
	 
  
   

   
}
  
  

  public ChessPiece[][] getBoard() {
	return board;
}

public ChessPiece getPiece(String position) throws IllegalPositionExcelption
  {
      String newpos = position.substring(0,1);
	  
	  int getIndex= this.hashmap.get(newpos);
	  
	  Integer newpos1 = Character.getNumericValue(position.charAt(position.length() - 1));
	  
	  return this.board[getIndex][newpos1];
	  
	  
  }

  
  
  public boolean placePiece(ChessPiece piece,String position) throws IllegalPositionExcelption 
   
  {
	  int columnIndex= -1;	  
	  int rowIndex = -1;
	  boolean validPostion=false;
	  
	  System.out.println(position.length());
	  
	  if(position!=null && position.length()==2  && this.hashmap.containsKey(position.substring(0,1)) )
	  
	  {
	  
	   	  
	  
	  String newpos = position.substring(0,1);

	 // System.out.println(this.hashmap.containsKey(position.substring(0,1)));
	
	  
	  columnIndex= this.hashmap.get(newpos);
	  
		  
	  rowIndex= Character.getNumericValue(position.charAt(position.length() - 1));
	  
	  rowIndex=rowIndex-1;
	  
	  
	  if(this.board[rowIndex][columnIndex] !=null)
	  {
		  throw new IllegalPositionExcelption("spot is alreay occupied");
	  }
	  
	  
	  
	  if(rowIndex>=0 && rowIndex<=8)
	  {
  
		  piece.column= columnIndex ;  //rowIndex;
		  piece.row= rowIndex;        //ColumnIndex;
		  this.board[rowIndex][columnIndex] = piece;
		  validPostion = true;
	  }
	  	  
	  else
	  {
		  validPostion= false;
	  }
	  
  
	}
	  
	return validPostion;
	  
  }
  
  /*
  public void move(String fromPosition, String toPosition) throws IllegalMoceException
  {
	  
  }
  */
  
  
  public String tostring()
  {
	  String chess="";
	    String upperLeft = "\u250C";
	    String upperRight = "\u2510";
	    String horizontalLine = "\u2500";
	    String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
	    String verticalLine = "\u2502";
	    String upperT = "\u252C";
	    String bottomLeft = "\u2514";
	    String bottomRight = "\u2518";
	    String bottomT = "\u2534";
	    String plus = "\u253C";
	    String leftT = "\u251C";
	    String rightT = "\u2524";

	    String topLine = upperLeft;
	    
	    for (int i = 0; i<7; i++){
	        topLine += horizontal3 + upperT;
	    }
	    topLine += horizontal3 + upperRight;

	    String bottomLine = bottomLeft;
	    for (int i = 0; i<7; i++){
	        bottomLine += horizontal3 + bottomT;
	    }
	    bottomLine += horizontal3 + bottomRight;
	    chess+=topLine + "\n";

	    for (int row = 7; row >=0; row--){
	        String midLine = "";
	        for (int col = 0; col < 8; col++){
	            if(board[row][col]==null) {
	                midLine += verticalLine + " \u3000 ";
	            } else {midLine += verticalLine + " "+board[row][col]+" ";}
	        }
	        midLine += verticalLine;
	        String midLine2 = leftT;
	        for (int i = 0; i<7; i++){
	            midLine2 += horizontal3 + plus;
	        }
	        midLine2 += horizontal3 + rightT;
	        chess+=midLine+ "\n";
	        if(row>=1)
	            chess+=midLine2+ "\n";
  }
	    
	    return chess;
  }




}
