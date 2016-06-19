/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper.scrapper.downloadcontent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rokin
 */
public class ContentDownloader {
    
    public void downloader(String content, String songName, String artist ) throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(songName + " - " + artist + ".txt")));
        writer.write(content);
        writer.close();
    }
    
}
