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

/**
 *
 * @author rokin
 */
public class SongListScrapper {
    
    private StringBuilder builder;

    public SongListScrapper(StringBuilder builder) {
        this.builder = builder;
    }
    
    
    
    public StringBuilder grabSongList(String[] tokens) throws IOException
    {
        FormURL formURL = new FormURL();
        
        
        URL url = new URL("http://search.azlyrics.com/search.php?q=" + formURL.URLBuilder(tokens));
        URLConnection urlConnection = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line = "";
        builder.delete(0, builder.length());

        while ((line = reader.readLine()) != null)
        {
            builder.append(line + "\n");
        }
        reader.close();
        
        return builder;
    }
}
