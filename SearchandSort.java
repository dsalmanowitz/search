import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSort {
	
	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		SearchAndSort search = new SearchAndSort();
		Scanner in = new Scanner(System.in);
		
		String[] list = null;
		int[] numlist = null;
		ArrayList<String> list1 = new ArrayList<String>();
		
		System.out.println("What algorithm would you like to execute?");
		String operation = in.nextLine().toLowerCase();
		if (!operation.equals("bubble") && !operation.equals("selection") && !operation.equals("insertion") && !operation.equals("merge") && !operation.equals("linear") && !operation.equals("binary") && !operation.equals("quit")) {
			System.out.println("Invalid input. Acceptable responses: bubble, selection, insertion, merge, linear, binary, quit.");
			return;
		} else if (operation.equals("quit")) {
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
		if (type.equals("integers")) {
			if (storage.equals("array")) {
				numlist = new int[list.length];
				for (int i = 0; i < list.length; i++) {
					numlist[i] = Integer.valueOf(list[i]);
				}
				switch (operation) {
				case "bubble": 
					search.bubble(numlist);
					break;
				case "selection":
					search.selection(numlist);
					break;
				case "insertion":
					search.insertion(numlist);
					break;
				case "merge" :
					search.merge(numlist);
					break;
				case "linear" : 
					search.linear(numlist, target);
					break;
				case "binary" :
					search.binary(numlist, target);
					break;
				}
				
			} else {
				Integer[] numlist2 = new Integer[list.length];
				for (int i = 0; i < list.length; i++) {
					numlist2[i] = Integer.valueOf(list[i]);
				}
				ArrayList<Integer> numlist1 = new ArrayList<Integer>();
				numlist1 = (ArrayList<Integer>) Arrays.asList(numlist2);
				switch (operation) {
				case "bubble": 
					search.bubble(numlist1);
					break;
				case "selection":
					search.selection(numlist1);
					break;
				case "insertion":
					search.insertion(numlist1);
					break;
				case "merge" :
					search.merge(numlist1);
					break;
				case "linear" : 
					search.linear(numlist1, target);
					break;
				case "binary" :
					search.binary(numlist1, target);
					break;
				}
			}
		} else {
			if (storage.equals("array")) {
				switch (operation) {
				case "bubble": 
					search.bubble(list);
					break;
				case "selection":
					search.selection(list);
					break;
				case "insertion":
					search.insertion(list);
					break;
				case "merge" :
					search.merge(list);
					break;
				case "linear" : 
					search.linear(list, target);
					break;
				case "binary" :
					search.binary(list, target);
					break;
				}
			} else {
				ArrayList<String> list2 = new ArrayList<String>((ArrayList<String>) Arrays.asList(list));
				switch (operation) {
				case "bubble": 
					search.bubbles(list2);
					break;
				case "selection":
					search.selections(list2);
					break;
				case "insertion":
					search.insertions(list2);
					break;
				case "merge" :
					search.merges(list2);
					break;
				case "linear" : 
					search.linears(list2, target);
					break;
				case "binary" :
					search.binarys(list2, target);
					break;
				}
			}
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
	
	public int[] selection(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int min = i;
			for (int j = i+1; j < list.length-1; j++) {
				if (list[j] < list[min]) {
					min = j;
				}
			}
			int temp = list[min];
			list[min] = list[i];
			list[i] = temp;
		}
		return list;
	}
	
	public String[] selection(String[] list) {
		for (int i = 0; i < list.length; i++) {
			int min = i;
			for (int j = i+1; j < list.length-1; j++) {
				if (list[j].compareTo(list[min]) < 0) {
					min = j;
				}
			}
			String temp = list[min];
			list[min] = list[i];
			list[i] = temp;
		}
		return list;
	}
	
	public ArrayList<Integer> selection(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i+1; j < list.size()-1; j++) {
				if (list.get(j) < list.get(min)) {
					min = j;
				}
			}
			Integer temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}
		return list;
	}
	
	public ArrayList<String> selections(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i+1; j < list.size()-1; j++) {
				if (list.get(j).compareTo(list.get(min)) < 0) {
					min = j;
				}
			}
			String temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}
		return list;
	}
	
	public int[] insertion(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int j = i-1;
			int val = list[i];
			while (j >= 0 && list[j] > val) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
		return list;
	}
	
	public String[] insertion(String[] list) {
		for (int i = 0; i < list.length; i++) {
			int j = i-1;
			String val = list[i];
			while (j >= 0 && list[j].compareTo(val) > 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
		return list;
	}
	
	public ArrayList<Integer> insertion(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int j = i-1;
			int val = list.get(i);
			while (j >= 0 && list.get(j) > val) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, val);
		}
		return list;
	}
	
	public ArrayList<String> insertions(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			int j = i-1;
			String val = list.get(i);
			while (j >= 0 && list.get(j).compareTo(val) > 0) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, val);
		}
		return list;
	}
	
	public int[] merge(int[] list) {
		
	}
	
	public String[] merge(String[] list) {
		
	}
	
	public ArrayList<Integer> merge(ArrayList<Integer> list) {
		
	}
	
	public ArrayList<String> merges(ArrayList<String> list) {
		
	}
 	
}
