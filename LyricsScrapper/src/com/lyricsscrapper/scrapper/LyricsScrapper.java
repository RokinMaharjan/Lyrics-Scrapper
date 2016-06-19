/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper.scrapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;



/**
 *
 * @author rokin
 */
public class LyricsScrapper {
    
    public void grabContent() throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(new File("/home/rokin/NetBeansProjects/LyricsScrapper/Songs to be scrapped.csv")));
        String songList = "";
        StringBuilder builder = new StringBuilder();
        SongListScrapper songListScrapper = new SongListScrapper(builder);
        
        
        while((songList = fileReader.readLine()) != null)
        {
            String[] tokens = songList.split(",");
            
            builder = songListScrapper.grabSongList(tokens);
            LyricsGrabber lyricsGrabber = new LyricsGrabber(builder);
            
            lyricsGrabber.grabLyrics(tokens);

            
        }
    }
}
