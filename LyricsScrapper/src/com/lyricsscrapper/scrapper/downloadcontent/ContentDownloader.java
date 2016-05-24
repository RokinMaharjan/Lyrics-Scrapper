/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper.scrapper.downloadcontent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author rokin
 */
public class ContentDownloader {
    
    public void downloader(String content) throws IOException 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the path and file name to save the lyrics (eg. d:/lyrics.html)");
        BufferedWriter writer = new BufferedWriter(new FileWriter(input.nextLine()));
        writer.write(content);
        writer.close();
    }
    
}
