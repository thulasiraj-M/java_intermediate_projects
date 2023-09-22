package com.recharge.nirbhay.rechargewallete.adapter;

import android.graphics.Bitmap;

public class CoupanListModel {

	private  String col="";
    private  String col1="";
    private  String col2="";
    private String col3="";
    private String urlimg="";
    private String name;
    
    private String imgUrl;
 
    private Bitmap image;
    /*********** Set Methods ******************/
     
    public void setcol(String col)
    {
        this.col = col;
    }
     
    public void setcol1(String col1)
    {
        this.col1 = col1;
    }
     
    public void setcol2(String col2)
    {
        this.col2 = col2;
    }
    public void setcol3(String col3)
    {
        this.col3 = col3;
    }
     
    
    /*********** Get Methods ****************/
     
    public String getcol()
    {
        return this.col;
    }
     
    public String getcol1()
    {
        return this.col1;
    }
 
    public String getcol2()
    {
        return this.col2;
    } 
    public String getcol3()
    {
        return this.col3;
    } 
	
   public void setimgurl(String url)
   {
	urlimg=url;   
   }
    
   public String getimgurl()
   {
	   return urlimg;
   }
    
   
    
    
    
    
    
}
