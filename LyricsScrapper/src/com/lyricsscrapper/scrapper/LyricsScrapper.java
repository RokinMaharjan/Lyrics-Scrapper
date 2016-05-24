/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper.scrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author rokin
 */
public class LyricsScrapper {
    public String grabContent() throws IOException
    {
        List<String> urlList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the name of the song");
        URL url = new URL("http://search.azlyrics.com/search.php?q=" + input.nextLine());
        URLConnection urlConnection = url.openConnection();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line = "";
        StringBuilder builder = new StringBuilder();

        while ((line = reader.readLine()) != null)
        {
            builder.append(line + "\n");
        }
        reader.close();

        String regex = "<a href=\"(.*?)\"\\starget=\"_blank\"><b>(.*?)</b></a>(.*?)<b>(.*?)</b>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(builder.toString());
       
        
        if(!matcher.find())
        {
            System.out.println("No songs found");
            System.exit(0);
        }
        
        
        matcher.reset();
        int i = 1;
        while (matcher.find())
        {   
            System.out.println(i + ") Song Title: " + matcher.group(2));
            System.out.println("Artist: " + matcher.group(4));
            System.out.println("Link: " + matcher.group(1) + "\n");
            urlList.add(matcher.group(1));
            i++; 
        }
        
        
        System.out.println("Select the song [1-" + (i-1) + "]");
        int choice = input.nextInt();
        if(choice>0 && choice<i)
        {
            url = new URL(urlList.get(choice-1));
            URLConnection urlGrab = url.openConnection();

            BufferedReader lyricsReader = new BufferedReader(new InputStreamReader(urlGrab.getInputStream()));
            line = "";
            StringBuilder builder1 = new StringBuilder();
            while ((line = lyricsReader.readLine()) != null)
            {
                builder1.append(line + "\n");
            }
            lyricsReader.close();

            System.out.println("\n");
            return builder1.toString();
        }
        else
        {
            System.out.println("Invalid choice");
            return null;
        } 
    }
}
