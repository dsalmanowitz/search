import java.util.ArrayList;
import java.util.Scanner;

public class SearchAndSort {
	
	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String[] list;
		ArrayList<String> list1 = new ArrayList<String>();
		
		System.out.println("What algorithm would you like to execute?");
		String merge = in.nextLine().toLowerCase();
		if (!merge.equals("bubble") && !merge.equals("selection") && !merge.equals("insertion") && !merge.equals("merge") && !merge.equals("linear") && !merge.equals("binary") && !merge.equals("quit")) {
			System.out.println("Invalid input. Acceptable responses: bubble, selection, insertion, merge, linear, binary, quit.");
			return;
		} else if (merge.equals("quit")) {
			return;
		}
		
		System.out.println("What type of data?");
		String type = in.nextLine().toLowerCase();
		if (!type.equals("integers") && !type.equals("strings")) {
			System.out.println("Invalid input. Acceptable responses: strings, integers. Please try again.");
			return;
		}
		System.out.println("How is it stored?");
		String storage = in.nextLine().toLowerCase();
		if (!storage.equals("array") && !storage.equals("list")) {
			System.out.println("Invalid input. Acceptable responses: array, list.");
			return;
		}
		System.out.println("Enter the data.");
		String data = in.nextLine();
		if (storage.equals("array") || storage.equals("list")) {
			list = data.split(",", 0);
			for (int n = 0; n < list.length; n++) {
				System.out.print(list[n] + " ");
			}
			for (String val : list) {
				if(type.equals("integers")) {
					for (int j = 0; j < val.length(); j++) {
						if (!Character.isDigit(val.charAt(j))) {
							System.out.println("Invalid input.");
							return;
						}
					}
				} else {
					if (val.trim().equals(null)) {
						System.out.println("Invalid input.");
						return;
					}
					val = val.trim();
				}
			}
		}
		if (merge.equals("bubble") && storage.equals("array")) {
			bubble(list);
		}
	}
	
	public int[] bubble(int[] list) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.length; i++) {
				if (list[i] < list[i-1]) {
					temp = list[i];
					list[i] = list[i-1];
					list[i-1] = temp;
					sorted = false;
				}
			}
		}
		for (int n = 0; n < list.length; n++) {
			System.out.print(list[n] + " ");
		}
		return list;
	}
	
	public String[] bubble(String[] list) {
		boolean sorted = false;
		String temp;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.length; i++) {
				if (list[i].compareTo(list[i-1]) < 0) {
					temp = list[i];
					list[i] = list[i-1];
					list[i-1] = temp;
					sorted = false;
				}
			}
		}
		return list;
	}
	
	public ArrayList<Integer> bubble(ArrayList<Integer> list) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.size(); i++) {
				if(list.get(i) < list.get(i-1)) {
					temp = list.get(i);
					list.set(i, list.get(i-1));
					list.set(i-1, temp);
					sorted = false;
				}
			}
		}
		return list;
	}
	
	public ArrayList<String> bubbles(ArrayList<String> list) {
		boolean sorted = false;
		String temp;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.size(); i++) {
				if(list.get(i).compareTo(list.get(i-1)) < 0) {
					temp = list.get(i);
					list.set(i, list.get(i-1));
					list.set(i-1, temp);
					sorted = false;
				}
			}
		}
		return list;
	}
	
}
