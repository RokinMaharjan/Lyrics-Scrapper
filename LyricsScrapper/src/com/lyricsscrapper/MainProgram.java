/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper;

/**
 *
 * @author rokin
 */

import com.lyricsscrapper.scrapper.LyricsScrapper;
import com.lyricsscrapper.scrapper.downloadcontent.ContentDownloader;
import java.io.IOException;
import java.util.Scanner;

public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        LyricsScrapper lyricsScrapper = new LyricsScrapper();
        ContentDownloader contentDownloader = new ContentDownloader();
        
        try
        {
            while(true)
            {
                String content = lyricsScrapper.grabContent();
                if(content!=null)
                {
                    System.out.println("The lyrics has been scrapped \n");

                    contentDownloader.downloader(content);

                    System.out.println("\nSave another lyrics? (Y/N)");
                    if(input.next().equalsIgnoreCase("N"))
                    {
                        System.exit(0);
                    }
                }
            }
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
