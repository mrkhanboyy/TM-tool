import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.Random;


// main class/ Driver code.
public class TT {
	public static void main(String args[]) throws IOException {
		System.out.println("--------------  WELCOME TO TEXT MANIPULATION TOOL --------------");
		System.out.println("-------------------------------------------v 1.0----------------");
		System.out.println();
		System.out.println("1. Text-File manipulation.");
		System.out.println("2. Text manipulation.");
		System.out.println("3. exit.");
		System.out.println("input option and press Enter....");
		
		Scanner sc = new Scanner(System.in);
		String option;
		
		do {
		option = sc.next();
		if(option.equals("1")) {
			fileBasedManipulation();
			break;
		}else if(option.equals("2")){
			textBasedManipulation();
			break;
		}else if(option.equals("3")){
			System.out.println("Exiting...");
			sc.close();
		}else{
			System.out.print("option-not found.");
			System.out.println("Please Enter correct option.");
		}
		}while(!option.equals("3"));
	}
	
	
//text-file manipulation----------------------------------------------------------------------------------------------------
	private static void fileBasedManipulation() throws IOException {
		System.out.println("---------TEXT-FILE MANIPULATION---------");
		System.out.println();
		System.out.println("!!!!!WARNING!!!!!--------Original file will be modified kindly keep a copy.......");
		System.out.println();
		System.out.println("1).Add prefix/suffix to each line.");
		System.out.println("2).Count characters,words and lines.");
		System.out.println("3).Find and replace word/text");
		System.out.println("4).Remove duplicate lines.");
		System.out.println("5).Remove blank lines.");
		System.out.println("6).Remove lines containing specific word/text.");
		System.out.println("7).Remove lines not-containing specific word/text.");
		System.out.println("8).Sort lines of file in Dictionary order.");
		System.out.println("9).Exit");
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		int option;
		String path;
		
		do {
			System.out.println("choose the option and press enter or 9 to exit.");
			option=scan.nextInt();
			scan.nextLine();
			switch(option) {
			case 1:{
				System.out.println("1).Add prefix only.");
				System.out.println("2).Add Suffix only.");
				System.out.println("3).Add prefix and suffix both.");
				System.out.println();
				System.out.println("choose the option and press Enter:");
				int option1;
				String prefix,suffix;
				option1=scan.nextInt();
				scan.nextLine();
				switch(option1) {
					
				case 1:{
					System.out.println("Enter file path or drag and drop yout file here : ");
					path=scan.nextLine();
					System.out.println("Enter prefix");
					prefix=scan.nextLine();
					TextFileManipulationFunctions.addPrefixSuffix(path, prefix,"");
					break;
				}
				case 2:{
					System.out.println("Enter file path or drag and drop yout file here : ");
					path=scan.nextLine();
					System.out.println("Enter suffix");
					suffix=scan.nextLine();
					TextFileManipulationFunctions.addPrefixSuffix(path,"", suffix);
					break;
				}
				case 3:{
					System.out.println("Enter file path or drag and drop yout file here : ");
					path=scan.nextLine();
					System.out.println("Enter prefix");
					prefix=scan.nextLine();
					System.out.println("Enter suffix");
					suffix=scan.nextLine();
					TextFileManipulationFunctions.addPrefixSuffix(path, prefix, suffix);
					break;
				}
				default :{
					System.out.println(" entered option is not correct ");
				}
				}break;
				
			}
			case 2:{
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				TextFileManipulationFunctions.countCharactersWordsLines(path);
				break;
			}
			case 3:{
				
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				String oldText,newText;
				System.out.println("Enter text to be replaced.");
				oldText=scan.nextLine();
				System.out.println("Enter new text to put.");
				newText=scan.nextLine();
				TextFileManipulationFunctions.findAndReplace(path, oldText, newText);
				break;
			}
			case 4:{
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				TextFileManipulationFunctions.removeDuplicateLines(path);
				break;
			}
			case 5 :{
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				TextFileManipulationFunctions.removeBlankLines(path);
				break;
			}
			case 6:{
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				System.out.println("Enter text/word.");
				String text;
				text=scan.nextLine();
				TextFileManipulationFunctions.removeLinesWithSpecificWord(path, text);
				break;
			}
			case 7:{
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				System.out.println("Enter text/word.");
				String text;
				text=scan.nextLine();
				TextFileManipulationFunctions.removeLinesNotWithSpecificWord(path, text);
				break;
			}
			case 8:{
				System.out.println("Enter file path or drag and drop yout file here : ");
				path=scan.nextLine();
				TextFileManipulationFunctions.sortLines(path);
				break;
			}
			case 9:{
				System.out.println("Exit successfully......");
				scan.close();
				break;
			}
			default:{
				System.out.println("incorrect option...");
			}
				
			}
			
		}while(option!=9);
		
	}

	
	
	
	
	

//text manipulation------------------------------------------------------------------------------------------
private static void textBasedManipulation() {
	System.out.println("---------TEXT MANIPULATION---------");
	System.out.println();
	System.out.println("1).Repeat text several times.");
	System.out.println("2).Generate random text.");
	System.out.println("3).Reverse text.");
	System.out.println("4).Check if text is Palindrome.");
	System.out.println("5).Convert to upper-case.");
	System.out.println("6).Convert to lower-case.");
	System.out.println("7).Convert to camel-case.");
	System.out.println("8).Remove specific character from text.");
	System.out.println("9).Count occurence of a specific character.");
	System.out.println("10).Count occurence of words which starts with certain character.");
	System.out.println("11).Text-detail generator. will give you following text details.");
	System.out.println("                 => Length of text.");
	System.out.println("                 => Total characters.");
	System.out.println("                 => count of Vowels.");
	System.out.println("                 => count of Consonants.");
	System.out.println("                 => count of spaces.");
	System.out.println("                 => count of digits.");
	System.out.println("                 => count of punctuation characters.");
	System.out.println("12).Exit");
	
	System.out.println();
	
	Scanner scan = new Scanner(System.in);
	
	int option;
	String text;
	String target;
	int numberOfTimes;
	String ch;
	
	
	do {
	System.out.println("choose the option and press enter or 12 to exit");
	option=scan.nextInt();
	scan.nextLine();
	switch(option) {
	case 1:{
		System.out.println("Enter text:");
		text=scan.nextLine();
		System.out.println("Enter how many times you wanna repeat text.");
		numberOfTimes=scan.nextInt();
		TextManipulationFunctions.repeatText(text, numberOfTimes);
		break;
	}
	case 2:{
		System.out.println("Enter length to generate random text:");
		numberOfTimes=scan.nextInt();
		TextManipulationFunctions.generateRandomText(numberOfTimes);
		break;
	}
	case 3:{
		System.out.println("Enter Text");
		text=scan.nextLine();
		TextManipulationFunctions.reverseText(text);
		break;
	}
	case 4:{
		System.out.println("Enter Text");
		text=scan.nextLine();
		TextManipulationFunctions.checkPalindrome(text);
		break;
	}
	case 5:{
		System.out.println("Enter Text");
		text=scan.nextLine();
		TextManipulationFunctions.convertToUpperCase(text);
		break;
	}
	case 6:{
		System.out.println("Enter Text");
		text=scan.nextLine();
		TextManipulationFunctions.convertToLowerCase(text);
		break;
	}
	case 7:{
		System.out.println("Enter Text");
		text=scan.nextLine();
		TextManipulationFunctions.toCamelCase(text);
		break;
	}
	case 8:{
		System.out.println("Enter Text");
		text=scan.nextLine();
		System.out.println("Enter character to be removed");
		ch=scan.nextLine();
		ch=ch.charAt(0)+"";
		TextManipulationFunctions.removeCharacter(text,ch);
		System.out.println("successfully removed character '"+ ch +"' from text.");
		break;
	}
	case 9:{
		System.out.println("Enter text");
		text = scan.nextLine();
		System.out.println("Enter charcter to be counted");
		target = scan.nextLine();
		System.out.println(TextManipulationFunctions.countOccurence(text, target.charAt(0)));
		break;
	}
	case 10:{
		System.out.println("Enter text");
		text=scan.nextLine();
		System.out.println("Enter starting character of words");
		target=scan.nextLine();
		System.out.println(TextManipulationFunctions.countWords(text, target.charAt(0)));
		break;
	}
	case 11:{
		System.out.println("Enter text");
		text=scan.nextLine();
		TextManipulationFunctions.textDetailGenerate(text);
		break;
	}
	case 12:{
		System.out.println(" exit successfully.........");
		scan.close();
		break;
	}
	default:{
		System.out.println("incorrect option....");
	}
		
	  }
	}while(option!=12);
	}
}

class TextFileManipulationFunctions {
	
	//add prefix/suffix
public static void  addPrefixSuffix(String path,String prefix,String suffix) throws IOException {
	path=path.replace("\"","");
	List <String> list = new ArrayList <String> ();
	BufferedReader reader = new BufferedReader(new FileReader(path));
	String line;
	while((line=reader.readLine())!=null) {
		list.add(prefix+line+suffix);
	}
	reader.close();
	
	BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	for(String line2:list) {
		writer.write(line2);
		writer.newLine();
	}
	writer.close();
	System.out.println("Added prefix/Syffix successfully");
	}


	//count characters,words,lines
	public static void countCharactersWordsLines(String path) throws IOException {
		path=path.replace("\"","");
		int charsCount=0;
		int wordsCount=0;
		int linesCount=0;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while((line=reader.readLine())!=null) {
			linesCount++;
			wordsCount += 	line.split(" +").length;
			charsCount +=	line.length();
		}
		reader.close();
		System.out.println("Lines : "+linesCount);
		System.out.println("Total Words : "+wordsCount);
		System.out.println("Total characters : "+charsCount);
	}
	
	//find and replace word / text in a file.
	public static void findAndReplace(String path,String target,String value) throws IOException {
		path=path.replace("\"","");
		List <String> list = new ArrayList();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while((line=reader.readLine())!=null) {
			list.add(line);
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter (new FileWriter(path));
		for(String lines:list) {
			writer.write(lines.replaceAll(target,value));
			writer.newLine();
		}writer.close();
		System.out.println("replaced successfully...............");
	}
	
	//remove duplicate lines from a file
	public static void removeDuplicateLines(String path) throws IOException {
		path=path.replace("\"","");
		Set<String> set = new LinkedHashSet<String>();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		int noOfLines=0;
		while((line=reader.readLine())!=null) {
			if(set.contains(line.trim())) {
				noOfLines++;
			}else {
			set.add(line.trim());
			}
		}reader.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for(String lines:set) {
			writer.write(lines);
			writer.newLine();
		}writer.close();
		System.out.println("removed "+noOfLines+" Duplicate lines successfully..........");
	}
	
	//removing blank lines from a file
	public static void removeBlankLines(String path) throws IOException {
		path=path.replace("\"","");
		List <String> list = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		int noOfLines=0;
		while((line=reader.readLine())!=null) {
			list.add(line);
		}reader.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for(String lines:list) {
			if(lines.trim().equals("")) {
				noOfLines++;
			}else {
				writer.write(lines);
				writer.newLine();
			}
		}writer.close();
		System.out.println("removed "+ noOfLines+" lines successfully..........");
		
	}
	
	//Remove lines containing certain word/text.
	public static void removeLinesWithSpecificWord(String path,String target) throws IOException {
		path=path.replace("\"","");
		List <String> list = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		int noOfLines=0;
		while((line=reader.readLine())!=null) {
			if(line.contains(target)) {
				noOfLines++;
			}else {
			list.add(line);
			}
		}reader.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for(String lines:list) {
			writer.write(lines);
			writer.newLine();
		}writer.close();
		System.out.println("removed "+noOfLines +" lines succesfully................");
		
	}
	
	//Remove lines not-containing specific word/text.
		public static void removeLinesNotWithSpecificWord(String path,String target) throws IOException {
			path=path.replace("\"","");
			List <String> list = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			int noOfLines=0;
			while((line=reader.readLine())!=null) {
				if(line.contains(target)!=true) {
					noOfLines++;
				}else {
				list.add(line);
				}
			}reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			for(String lines:list) {
				writer.write(lines);
				writer.newLine();
			}writer.close();
			System.out.println("removed "+noOfLines +" lines succesfully................");
			
		}
		
		//sort lines in dictionary order
		public static void sortLines(String path) throws IOException {
			path=path.replace("\"","");
			List <String> list = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line=reader.readLine())!=null) {
				list.add(line);
			}reader.close();
			Collections.sort(list);
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			for(String lines:list) {
				writer.write(lines);
				writer.newLine();
			}writer.close();
			System.out.println("sorted succesfully.............");
		}	
}

class TextManipulationFunctions {
	
	// function to repeat text several times
	public static void repeatText(String text,int n){
		for(int i=0;i<n;i++) {
			System.out.println(text);
		}
	}
	
	//function to generate random text
	public static void generateRandomText(int lengthOfText) {
		StringBuilder sb = new StringBuilder("");
		Random random = new Random(); 
		for(int i=0;i<lengthOfText;i++) {
			sb.append((char)(random.nextInt(126)+1));
		}
		System.out.println(sb);
	}
	
	//function to reverse text
	public static void reverseText(String text) {
		StringBuilder sb = new StringBuilder(text);
		System.out.println(sb.reverse());
	}
	
	//wrapper function for isPalindrome
	public static void checkPalindrome(String text) {
		System.out.println("Palindrome status : "+TextManipulationFunctions.isPalindrome(text,0,text.length()-1));
	}
	
	//function to check text is palindrome or not
	private static boolean isPalindrome(String text,int start,int end) {
		if(start<end) {
			if(text.charAt(start)!=text.charAt(end)) {
				return false;
			}
			isPalindrome(text,start+1,end-1);
		}return true;
	}
	
	//function to convert text to upperCase
	public static void convertToUpperCase(String text) {
		System.out.println(text.toUpperCase());
	}
	
	//function to convert text to lowerCase
	public static void convertToLowerCase(String text) {
			System.out.println(text.toLowerCase());
	}
	
	//function to convert text to camel-case
	public static void toCamelCase(String text) {
		char[] ch=text.toCharArray();
		StringBuilder sb= new StringBuilder();
		sb.append(Character.toUpperCase(ch[0]));
		for(int i=1;i<ch.length;i++) {
			if(ch[i]==' ') {
				ch[i+1]=Character.toUpperCase(ch[i+1]);
				
			}
			sb.append(ch[i]);
			
		}System.out.println(sb);
	}
	
	//function to Remove specific character/word from text.
	public static void removeCharacter(String text,String target) {
		text = text.replace(target,"");
		System.out.println(text);
	}
	
	//function to count occurence of a specific character
	public static int countOccurence(String text,Character target) {
		int count=0;
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)==target) {
				count++;
			}
		}
		return count;
	}
	
	//function to count occurence of words starts with a specific Character
	public static int countWords(String text,Character target) {
		int count=0;
		String str[]=text.split("[ ]+");
		for(int i=0;i<str.length;i++) {
			if(str[i].charAt(0)==target) {
				count++;
			}
		}return count;
	}
	
	//funt=ction to generate text Details
	public static void textDetailGenerate(String text) {
		System.out.println("Entered Text is : "+text);
		System.out.println("Text Length : "+text.length());
		System.out.println("Total characters : "+text.length());
		int noOfVowels=0,noOfConsonants=0,noOfDigits=0,noOfSpaces=0,noOfPunctuations=0;
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)=='a'||text.charAt(i)=='A'||text.charAt(i)=='e'||text.charAt(i)=='E'||text.charAt(i)=='i'||
					text.charAt(i)=='I'||text.charAt(i)=='o'||text.charAt(i)=='O'||text.charAt(i)=='u'||text.charAt(i)=='U') {
				noOfVowels++;
			}else if(Character.isAlphabetic(text.charAt(i))) {
				noOfConsonants++;
			}else if(Character.isDigit(text.charAt(i))) {
				noOfDigits++;
			}else if(text.charAt(i)==' ') {
				noOfSpaces++;
			}else {
				noOfPunctuations++;
			}
		}
		System.out.println("no of Vowels : "+noOfVowels);
		System.out.println("no of Consonants : "+noOfConsonants);
		System.out.println("no of Digits : "+noOfDigits);
		System.out.println("no of Spaces : "+noOfSpaces);
		System.out.println("no of Punctuation characters : "+noOfPunctuations);
	}
}




