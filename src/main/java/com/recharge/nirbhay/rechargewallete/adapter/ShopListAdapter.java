package com.recharge.nirbhay.rechargewallete.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.recharge.nirbhay.rechargewallete.R;
import com.recharge.nirbhay.rechargewallete.StaupActivity;
import com.recharge.nirbhay.rechargewallete.fragmetsclass.FragmentHistory;
import com.recharge.nirbhay.rechargewallete.fragmetsclass.FragmentHistoryWalletTransfer;
import com.recharge.nirbhay.rechargewallete.fragmetsclass.MapFrag;
import com.recharge.nirbhay.rechargewallete.globalobject.Globaldata;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ShopListAdapter extends ArrayAdapter<String> {

	ArrayList<String>ArrId=new ArrayList<String>();
	ArrayList<String>ArrName=new ArrayList<String>();
	ArrayList<String>ArrImage=new ArrayList<String>();


	ArrayList<String>Arropentim=new ArrayList<String>();
	ArrayList<String>Arrclosetim=new ArrayList<String>();
	ArrayList<String>Arrmobile=new ArrayList<String>();


	ArrayList<String>Arrlat=new ArrayList<String>();
	ArrayList<String>Arrlng=new ArrayList<String>();


	ImageView bannershop;
	TextView cmpName;
	private  Activity context;
	private FragmentManager fmgCommnet;
	Globaldata obje;


	//String name2[]={"Event Service","Home Services"};
	public ShopListAdapter(Activity context, FragmentManager fmg, ArrayList<String>ArrIdtxt, ArrayList<String>ArrNameTxt, ArrayList<String>ArrImgTxt, ArrayList<String>Arropentim1, ArrayList<String>Arrclosetim1, ArrayList<String>Arrmobile1, ArrayList<String>Arrlat1, ArrayList<String>Arrlng1) {
		super(context,R.layout.transectiondetailrow,ArrIdtxt);
		// TODO Auto-generated constructor stub
		this.context=context;
		ArrId=ArrIdtxt;
		ArrName=ArrNameTxt;
		ArrImage=ArrImgTxt;
		this.fmgCommnet=fmg;
		obje=(Globaldata)context.getApplicationContext();

		Arropentim=Arropentim1;
		Arrclosetim=Arrclosetim1;
		Arrmobile=Arrmobile1;
		Arrlat=Arrlat1;
		Arrlng=Arrlng1;


	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.shop_list_row, null,true);

		TextView statustxt=(TextView)rowView.findViewById(R.id.cmpName);
		TextView openclos1=(TextView)rowView.findViewById(R.id.openclos);
		TextView shopmob=(TextView)rowView.findViewById(R.id.shopmob);
		TextView tmtxt=(TextView)rowView.findViewById(R.id.tmtxt);

		openclos1.setText(Arropentim.get(position)+" to "+Arrclosetim.get(position));
		shopmob.setText(Arrmobile.get(position));
		ImageView mapclick=(ImageView)rowView.findViewById(R.id.mapclick);
		bannershop=(ImageView)rowView.findViewById(R.id.bannershop);
		Picasso.with(context)
				.load(ArrImage.get(position))
				.placeholder(R.drawable.noimg) //this is optional the image to display while the url image is downloading
				.error(R.drawable.noimg)         //this is also optional if some error has occurred in downloading the image this image would be displayed
				.into(bannershop);
		statustxt.setText(ArrName.get(position));

		String opentm=Arropentim.get(position).toString();
		String opentmampmLess=opentm.substring(0,3);
		String closetm=Arrclosetim.get(position).toString();
		String closetmamLess=opentm.substring(0,5);



		boolean flg1=getCurrentTime(opentm,closetm);
		if(flg1)
		{
			tmtxt.setText("Open");
			tmtxt.setTextColor(Color.WHITE);
			tmtxt.setBackgroundResource(R.drawable.radiuscolor);
		}
		else {
			tmtxt.setText("Close");
			tmtxt.setTextColor(Color.WHITE);

			tmtxt.setBackgroundResource(R.drawable.radiuscolor_red);
		}
		bannershop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		mapclick.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent hm=new Intent(context, MapFrag.class);
				context.startActivity(hm);
				obje.setShoplat(Arrlat.get(position));
				obje.setShoplong(Arrlng.get(position));

			}
		});
		return rowView;
	}


	public void getDetailsFrag(Fragment callFrag)
	{
		Intent hm=new Intent(context, StaupActivity.class);
		context.startActivity(hm);
		FragmentManager req_mnt=fmgCommnet;
		FragmentTransaction req_transion=req_mnt.beginTransaction();
		req_transion.replace(R.id.content_frame, callFrag);
		req_transion.commit();

	}

	public boolean getCurrentTime(String tm, String clostm)
	{boolean flg=false;
		Date date1 = null;
		Date date2 = null;

/*
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

		SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");

		SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");

		//System.out.println(date24Format.format(date12Format.parse(time)));


		Date date = new Date();
		System.out.println(dateFormat.format(date));*/

			/*String data22= date24Format.format(date12Format.parse(clostm));                                    //displayFormat.format(date1);
			String data23= date24Format.format(date12Format.parse(tm));                                                                                  //displayFormat.format(date2);

			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String s = sdf.format(new Date());

*/

		try {
			String now = new SimpleDateFormat("hh:mm aa").format(new java.util.Date().getTime());
			System.out.println("time in 12 hour format : " + now);
			SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm aa");
			SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm");
			String etime24 = outFormat.format(inFormat.parse(tm));

			String stime24 = outFormat.format(inFormat.parse(clostm));
			String nw = outFormat.format(inFormat.parse(now));
			//String etime24 = outFormat.format(inFormat.parse(tm));
			//String ntim = outFormat.format(inFormat.parse(now));
			System.out.println("time in 24 hour format : " + stime24);
			System.out.println("Hello World!"); // Display the string.
			String sTartTime =etime24 ;
			String eNdTime =stime24 ;
			String nowTime = nw;

				String string1 = eNdTime;
				Date endDate =  new SimpleDateFormat("HH:mm").parse(string1);
				String string2 = sTartTime;
				Date beforeDate = new SimpleDateFormat("HH:mm").parse(string2);
				String someRandomTime = nowTime;
				Date inBeforeDate =  new SimpleDateFormat("HH:mm").parse(someRandomTime);
				if((inBeforeDate.after(beforeDate)) &&(inBeforeDate.before(endDate))) {

					System.out.println("log_tag" + "Time check today True " );
					flg=true;
				}else{
					System.out.println("log_tag" + "Time check today false " );
					flg=false;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}








		Calendar c = Calendar.getInstance();
		int seconds = c.get(Calendar.SECOND);
		int hr = c.get(Calendar.HOUR);
		return flg;
	}


}
