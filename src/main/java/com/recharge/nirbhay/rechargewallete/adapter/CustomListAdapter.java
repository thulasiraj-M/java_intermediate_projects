package com.recharge.nirbhay.rechargewallete.adapter;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.recharge.nirbhay.rechargewallete.R;

public class CustomListAdapter extends ArrayAdapter<String> {
 
	Typeface sonictonicfonts;
private View rowView;
private final Activity context;
private final String[] itemname;
private final Integer[] imgid;
public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
super(context, R.layout.mylist, itemname);
// TODO Auto-generated constructor stub
this.context=context;
this.itemname=itemname;
this.imgid=imgid;
sonictonicfonts = Typeface.createFromAsset(context.getAssets(), "fonts/avenir-light.ttf");
}

public View getView(int position,View view,ViewGroup parent) {
	
	try{
LayoutInflater inflater=context.getLayoutInflater();
rowView=inflater.inflate(R.layout.mylist, null,true);
TextView txtTitle = (TextView) rowView.findViewById(R.id.Itemname);

ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

txtTitle.setText(itemname[position]);
txtTitle.setTypeface(sonictonicfonts);
imageView.setImageResource(imgid[position]);
	}catch(Exception e){
		//crashreposrMail("getView Custome Adapter block"+e);
	}
return rowView;
};

public void crashreposrMail(String str){
	   
	   
	   Intent i = new Intent(Intent.ACTION_SEND);
	   i.setType("message/rfc822");
	   i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"nirbhayiise@gmail.com"});
	   i.putExtra(Intent.EXTRA_SUBJECT, "ArpitAlbumCrashReport");
	   i.putExtra(Intent.EXTRA_TEXT   , str);
	   try {
	       context.startActivity(Intent.createChooser(i, "Send mail..."));
	   } catch (android.content.ActivityNotFoundException ex) {
	       Toast.makeText(context, "not send Crash Report.", Toast.LENGTH_SHORT).show();
	   }
	   
	   
}
}