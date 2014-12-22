package tasks;

//READY
import java.io.*;
import java.util.*;

public class MapFile {

	private int[][] map = new int[10][10];
	private List<POI> POIlist = new ArrayList<>();
	protected POI base; 

	public void getMapFile() {
		Scanner inputStream = null;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Give the input file name: ");
		String inputFileName = keyboard.next();
		inputFileName = inputFileName.trim();

		try {
			inputStream = new Scanner(new FileInputStream(inputFileName));

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");// stops here why??????
			System.exit(0);
		}

		int i = 0;
		int j = 0;
		System.out.println(inputStream);
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(line);
			while (tokenizer.hasMoreTokens() && j < 10) {
				String s = tokenizer.nextToken();
				map[i][j] = Integer.parseInt(s);
				if (map[i][j]==1){
					base = new POI(i,j);
				}
				j++;
				if (j == 10) {
					j = 0;
				}
			}
			i++;
		}
		inputStream.close();
		keyboard.close();
	}

	public void echoMap() {
		// boolean oneDrone=true;
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				System.out.println("_________________________________________");
			}
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				if (map[i][j] == 0) {
					System.out.print(" ");
				} else if (map[i][j] == 1) {
					// check if 2 drones givven on map???
					System.out.print("X");
				} else if (map[i][j] == 2) {
					POI temp = new POI(i,j);
					POIlist.add(temp);
					System.out.print("O");
				}else if (map[i][j]==3){
					System.out.print("@");//Water..
				}else if (map[i][j]==5){
					System.out.print("*");//Route..				
				} else {
					System.out.println("Error On Map");// Stands for error
					System.exit(0);
				}

				System.out.print(" | ");

			}

			System.out.println("");
			System.out.println("_________________________________________");
		}
	}
	

	 //testing my class
	
//	 public static void main(String[] args) {
//	 MapFile map1 = new MapFile();
//	 map1.getMapFile();
//	 map1.echoMap();
//	 }
}
