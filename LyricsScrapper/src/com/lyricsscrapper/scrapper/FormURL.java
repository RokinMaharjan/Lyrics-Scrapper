/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyricsscrapper.scrapper;

/**
 *
 * @author rokin
 */
public class FormURL {
    
    public String URLBuilder(String[] tokens)
    {
        String completeURL = "";
        if(tokens[0].contains(" "))
            {
                String[] fixURL = tokens[0].split(" ");
                completeURL = fixURL[0];
                for(int i = 1; i<fixURL.length;i++)
                {
                    completeURL = completeURL + "+" + fixURL[i];
                }
            }
            else
            {
                completeURL = tokens[0];
            }
            
            if(tokens[1].contains(" "))
            {
                String[] fixURL = tokens[1].split(" ");
                for(int i = 1; i<fixURL.length;i++)
                {
                    completeURL = completeURL + "+" + fixURL[i];
                }
            }
            else
            {
                completeURL = completeURL + "+" + tokens[1];
            }
            
            return completeURL;
    }
}
