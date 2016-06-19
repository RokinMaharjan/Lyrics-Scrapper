/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper.scrapper;

import com.lyricsscrapper.scrapper.downloadcontent.ContentDownloader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rokin
 */
public class LyricsGrabber {

    private StringBuilder builder;

    public LyricsGrabber(StringBuilder builder) {
        this.builder = builder;
    }

    public void grabLyrics(String[] tokens) throws IOException
    
    {
        ContentDownloader contentDownloader = new ContentDownloader();
        
        
        String regex = "<a href=\"(.*?)\"\\starget=\"_blank\"><b>(.*?)</b></a>(.*?)<b>(.*?)</b>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(builder.toString());

//            if(!matcher.find())
//            {
//                System.out.println("No songs found");
//                System.exit(0);
//            }
//
//
        matcher.reset();

        while (matcher.find()) 
        {
            System.out.println(matcher.group(2) + "and" + matcher.group(4));
            if (matcher.group(2).contains(tokens[0]) && matcher.group(4).equalsIgnoreCase(tokens[1])) 
            {
                URL url2 = new URL(matcher.group(1));
                URLConnection urlGrab = url2.openConnection();

                BufferedReader lyricsReader = new BufferedReader(new InputStreamReader(urlGrab.getInputStream()));
                String line = "";
                builder.delete(0, builder.length());

                while ((line = lyricsReader.readLine()) != null)
                {
                    builder.append(line);
                }
                lyricsReader.close();


                String regex2 = "<div><(.*?)>(.*?)</div>";
                pattern = Pattern.compile(regex2);
                
                matcher.reset();
                matcher = pattern.matcher(builder.toString());

                builder.delete(0, builder.length());
                if (matcher.find())
                {
                    builder.append(matcher.group(2).replace("<br>", "\n"));
                }

                System.out.println(builder.toString());

                System.out.println("\n\n");

                contentDownloader.downloader(builder.toString(), tokens[0], tokens[1]);
                break;
            }

        }
    }
}
