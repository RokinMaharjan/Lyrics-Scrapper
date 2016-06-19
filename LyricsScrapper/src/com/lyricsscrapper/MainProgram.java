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
import java.io.IOException;


public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try {
            LyricsScrapper lyricsScrapper = new LyricsScrapper();       
            lyricsScrapper.grabContent();
            
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
            
    }
               
}
    

