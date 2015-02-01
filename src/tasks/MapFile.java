package tasks;

//READY
import java.io.*;
import java.util.*;

public class MapFile implements iBBox, iMap {

	private int[][] map = new int[10][10];
	public List<POI> POIlist = new ArrayList<>();
	private POI base;

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
				if (map[i][j] == 1) {
					setBase(new POI(i, j));
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
					//System.out.print("X");
					POI temp = new POI(i, j);//?????
					setBase(temp);
				} else if (map[i][j] == 2) {//POI
					POI temp = new POI(i, j);
					POIlist.add(temp);
					System.out.print("O");
				} else if (map[i][j] == 3) {
					System.out.print("@");// Water..
				} else if (map[i][j] == 4) {
					System.out.print("$");// Visited POI
				} else if (map[i][j] == 5) {
					System.out.print("*");// Route so far..
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

	public POI getNextPOI() {
		if (!POIlist.isEmpty()) {
			return POIlist.get(0);
		}else if(POIlist.size()==0){
			System.out.println("Mission Complete!!!Returning home...");
			POIlist.add(null);
			return base;
		}
		else{
			
			System.out.println("Home reached...");
			
			return null;
		}
	}

	public void rmTopPOI() {
		POIlist.remove(0);
	}

	public void refreshMap(int x, int y) {
		if (map[x][y] == 0 || map[x][y] == 5) {
			map[x][y] = 5;
		}
		if (map[x][y] == 2) {
			map[x][y] = 4;
		}
		System.out.println("Moved to: " + "(" + x + "," + y + ")");
		bbx.logActivity("Moved to: " + "(" + x + "," + y + ")");
	}

	public POI getBase() {
		return base;
	}

	public void setBase(POI base) {
		this.base = base;
	}

	public void appendPoint(POI z){
		POIlist.add(z);
	}
	// testing my class

	// public static void main(String[] args) {
	// MapFile map1 = new MapFile();
	// map1.getMapFile();
	// map1.echoMap();
	// }
}
