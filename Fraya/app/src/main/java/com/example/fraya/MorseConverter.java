package com.example.fraya;

import android.annotation.SuppressLint;

public class MorseConverter {
	
	
	
	@SuppressLint("DefaultLocale")
	public static String Converter(String glib)
	{
		//reason for adding space to glib, making for one more than glib is that to get one letter you 
		//gotta do substring(letterIndex, letterIndex + 1) so this should prevent an out of bounds 
		//exception while allowing me to not miss the last letter in glib.

		String mc = "";    	

		for(int i = 0; i < glib.length(); i++)
		{
			String ch = glib.substring(i, i + 1);
                        switch (ch.toUpperCase()) {
                            case "A":
                                mc += ".- ";
                                break;
                            case "B":
                                mc += "-... ";
                                break;
                            case "C":
                                mc += "-.-. ";
                                break;
                            case "D":
                                mc += "-.. ";
                                break;
                            case "E":
                                mc += ". ";
                                break;
                            case "F":
                                mc += "..-. ";
                                break;
                            case "G":
                                mc += "--. ";
                                break;
                            case "H":
                                mc += ".... ";
                                break;
                            case "I":
                                mc += ".. ";
                                break;
                            case "J":
                                mc += ".--- ";
                                break;
                            case "K":
                                mc += "-.- ";
                                break;
                            case "L":
                                mc += ".-.. ";
                                break;
                            case "M":
                                mc += "-- ";
                                break;
                            case "N":
                                mc += "-. ";
                                break;
                            case "O":
                                mc += "--- ";
                                break;
                            case "P":
                                mc += ".--. ";
                                break;
                            case "Q":
                                mc += "--.- ";
                                break;
                            case "R":
                                mc += ".-. ";
                                break;
                            case "S":
                                mc += "... ";
                                break;
                            case "T":
                                mc += "- ";
                                break;
                            case "U":
                                mc += "..- ";
                                break;
                            case "V":
                                mc += "...- ";
                                break;
                            case "W":
                                mc += ".-- ";
                                break;
                            case "X":
                                mc += "-..- ";
                                break;
                            case "Y":
                                mc += "-.-- ";
                                break;
                            case "Z":
                                mc += "--.. ";
                                break;
                            case " ":
                                mc += "\t";
                                break;
                            case ".":
                                mc += "\t.-.-.- ";
                                break;
                            case ",":
                                mc += "\t--..-- ";
                                break;
                            case "!":
                                mc += "\t..--. ";
                                break;
                            case "?":
                                mc += "\t..--.. ";
                                break;
                            case "1":
                                mc += ".---- ";
                                break;
                            case "2":
                                mc += "..--- ";
                                break;
                            case "3":
                                mc += "...-- ";
                                break;
                            case "4":
                                mc += "....- ";
                                break;
                            case "5":
                                mc += "..... ";
                                break;
                            case "6":
                                mc += "-.... ";
                                break;
                            case "7":
                                mc += "--... ";
                                break;
                            case "8":
                                mc += "---.. ";
                                break;
                            case "9":
                                mc += "----. ";
                                break;
                            case "0":
                                mc += "----- ";
                                break;
                        }
			
			
			
		}
		glib += " ";			
		return mc;
	}
	
}
