package com.recharge.nirbhay.rechargewallete.globalobject;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;

public class Globaldata extends Application{
	
	private String url_registration="https://www.bribhoorecharge.com/bwebservice/register-action.php?";
	private String url_login="https://www.bribhoorecharge.com/bwebservice/login-action.php?";
	private String url_forget_password="https://www.bribhoorecharge.com/bwebservice/forgot-pw.php?";
	private String url_select_oprator="https://www.bribhoorecharge.com/bwebservice/mobile-operator.php?";
	private String url_gas_service_charge="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Gas%20Bill";
	private String url_electicity_service_charge="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Electricity%20Bill";
	private String url_landline_service_charge="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Land%20line%20Bill";
	private String url_datacard_service_charge="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Datacard%20Bill";
	private String url_insurance_service_charge="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Insurance";
	private String url_mobole_bill_service_charge="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Mobile%20Bill";
	private String url_datacard="https://www.bribhoorecharge.com/bwebservice/service-charge.php?service_select=Datacard%20Bill";
	private String url_gasprovider="https://www.bribhoorecharge.com/bwebservice/postpaid-operator-Gas.php";
	private String url_mobile_provider_list="https://www.bribhoorecharge.com/bwebservice/postpaid-operator-mobile.php";
	private String url_dth_provider="https://www.bribhoorecharge.com/bwebservice/prepaid-operator-dth.php";
	private String url_prepadi_frg="https://www.bribhoorecharge.com/bwebservice/prepaid-operator-datacard.php";
	private String url_landline_provider="https://www.bribhoorecharge.com/bwebservice/postpaid-operator-landline.php";
	private String url_Electicity_provider="https://www.bribhoorecharge.com/bwebservice/postpaid-operator-electricity.php";
	private String url_insur="https://www.bribhoorecharge.com/bwebservice/postpaid-operator-insurance.php";
	private String url_wallet_cash_add="https://www.bribhoorecharge.com/bwebservice/add-wallet.php?";
	private String url_cash_transfer="https://www.bribhoorecharge.com/bwebservice/wallet-transfer-name.php?";
	private String url_cashtransfer_bal="https://www.bribhoorecharge.com/bwebservice/wallet-transfer-money.php?receiver-mobile=9000000000&transfer-amt=10";
	private String url_saller="https://www.bribhoorecharge.com/bwebservice/become-seller-action.php?bs_nane=vaibhavi&bs_num=9022171522&bs_email=test@gmail.com&bs_city=Mumbai&bs_bname=test&bs_badd=India&bs_category=test";
	private String url_trasactionlist="https://www.bribhoorecharge.com/bwebservice/transaction-history.php?uemail=vaibhavi@webishq.com";
	private String url_wallet_detail="https://www.bribhoorecharge.com/bwebservice/addcash-getdetails.php?email=vaibhavi@webishq.com";
	private String url_updatepassword="https://www.bribhoorecharge.com/bwebservice/change-pd-action.php?";
	private String url_wallet_history="https://www.bribhoorecharge.com/bwebservice/wallet-history.php?uemail=vaibhavi@webishq.com";
	private String url_become_saller_catagies="https://www.bribhoorecharge.com/bwebservice/become-seller-category.php";
	private String url_state="https://www.bribhoorecharge.com/bwebservice/Profile-setting-state.php";
	private String url_city="https://www.bribhoorecharge.com/bwebservice/Profile-setting-city.php";
	private String url_getprofile="https://www.bribhoorecharge.com/bwebservice/get-profile-data.php?udata=vaibhavi@webishq.com";
	private String url_profile_update="https://www.bribhoorecharge.com/bwebservice/profile-action.php?";
    private String url_brawseplan_catag="https://www.bribhoorecharge.com/bwebservice/prepaid-operator-mobile.php";
	
	
	//****************************************Payment servics*********************************************************************
	private String url_datacardpayment="https://www.bribhoorecharge.com/bwebservice/postpaid-datacard-action.php?";
	private String url_electicitypayment="https://www.bribhoorecharge.com/bwebservice/postpaid-electricity-action.php?";
	private String url_gaspayment="https://www.bribhoorecharge.com/bwebservice/postpaid-gas-action.php?";
	private String url_landlinepayment="https://www.bribhoorecharge.com/bwebservice/postpaid-landline-action.php?";
	private String url_mobilerechargepayment="https://www.bribhoorecharge.com/bwebservice/prepaid-mobile-action.php?";
	private String url_dthpayment="https://www.bribhoorecharge.com/bwebservice/prepaid-dth-action.php?";
	private String url_brawseplan="https://www.bribhoorecharge.com/bwebservice/browse-plan.php?data=Mobile-RELIANCE%20GSM-MUMBAI";
	private String url_selectiondata="https://www.bribhoorecharge.com/bwebservice/getcouponListByCategory.php?    ";
	private String url_populate="https://www.bribhoorecharge.com/bwebservice/getCouponList.php";
	private String url_apply="https://www.bribhoorecharge.com/bwebservice/check-promocode-amount.php?";
	private String url_pick="https://www.bribhoorecharge.com/bwebservice/pickCouponAmt.php?";
	private String url_insurance="https://www.bribhoorecharge.com/bwebservice/postpaid-insurance-action.php?";
	private String url_getway="https://www.bribhoorecharge.com/bwebservice/debit-action.php?dcard-number=6060606060606060&dcard-exp-month=03&dcard-exp-year=2015&dcard-cvv=123&action-amount=10&action-payment-type=Recharge&service=Mobile&action-opertor=Aircel&plan-amount=10&voucher-id=1234556&promocode_id=123445&service-type=mobile&$action-number=9022171522&service_charges=0";
	private String paymentgetway="https://www.bribhoorecharge.com/bwebservice/wallet-action.php?";
	private String billpay="https://www.bribhoorecharge.com/bwebservice/postpaid-mobile-action.php?";
	
	//*************************************************************************************************************
	String datacard;
	String balance;
	String balanceservice;
	String recharge_bal;
	String no;
	String opt;
	
	//*************************************Coupan services************************************************************************
	String url_coupan_category="https://www.bribhoorecharge.com/bwebservice/coupon-category.php";
	
	
//	*****************Mobile Recharge data Varibles************************************************************
	String Mob_no;
	int operators;
	String amount;
//	*****************************Activity Name Variables****************************************************************************
	
	String currentpossion;
//	String mobilerechargeActivity;
//	String mobilebillActivity;
//	String dthActivity;
//	String prepaidActivity;
//	String 
	
	
	// get method impoliment here 
	public String getregister()
	{
		return url_registration;
	}
	public String getlogin()
	{
		return url_login;
	}
	public String getforgetpassword()
	{
		return url_forget_password;
	}
	public String getmobilebillpay()
	{
		return url_select_oprator;
	}
	public String getbillservice()
	{
		return url_gas_service_charge;
	}
	public String headerchangedata()
	{
		return url_gas_service_charge;
	}
	public String getElecticityservice()
	{
		return url_electicity_service_charge;
	}
	public String getlandlineservice()
	{
		return url_landline_service_charge;
	}
	public String getdatacardservice()
	{
		return url_datacard_service_charge;
	}
	public String getinsuranceservice()
	{
		return url_insurance_service_charge;
	}
	public String getmobilebillservice()
	{
		return url_mobole_bill_service_charge;
	}
	public String getprepaidservice()
	{
		return url_datacard;
	}
	
	public String getGasprovider()
	{
		return url_gasprovider;
	}
	public String getmobile_provider()
	{
		return url_mobile_provider_list;
	}
	public String getdthprovider()
	{
		return url_dth_provider;
	}
	public String getprepaid_serv()
	{
		return url_prepadi_frg;
	}
	public String getlandline_provider_serv()
	{
		return url_landline_provider;
	}
	public String getElecticity_prov()
	{
		return url_Electicity_provider;
	}
	public String getinsur()
	{
		return url_insur;
	}
	public String add_cash_wallet()
	{
		return url_wallet_cash_add;
	}
	
	
	public String transfer_cash_wallet()
	{
		return url_cash_transfer;
	}
	public String cashtransfer()
	{
		return url_cashtransfer_bal;
	}
	public String getsaller()
	{
		return url_saller;
	}
	public String gettranscationdata()
	{
		return url_trasactionlist;
	}
	
	
	public String getwalletdetail()
	{
		return url_wallet_detail;
	}
	
	public String getupadetpass()
	{
		return url_updatepassword;
	}
	
	
	public String getwallethistory()
	{
		return url_wallet_history;
	}
	
	public String getbecomesallercatagies()
	{
		return url_become_saller_catagies;
	}
	
	public String getslectstate()
	{
		return url_state;
	}
	public String getcityselection()
	{
		return url_city;
	}
	
	public String getprofile()
	{
		return url_getprofile;
	}
	
	public String getupdatepro()
	{
		return url_profile_update;
	}
	
	
	public String brawseplanmumbai()
	{
		return url_brawseplan_catag;
	}
	
	public String brawseplan()
	{
		return url_brawseplan;
	}
	public String billpay()
	{
		return billpay;
	}
	//**********************Recharge Balnace ******************************************************
	public String balanceshow()
	{
		return balance;
	}
	public void balanceserviceset(String bal)
	{
		balanceservice=bal;
	}
	public String balanceserviceshow()
	{
		return balanceservice;
	}
	public void balanceset(String bal)
	{
		balance=bal;
	}
	
	//**********************Recharge Balnace ******************************************************
	public String rech_balanceshow()
	{
		return recharge_bal;
	}
	public void rech_balanceset(String bal)
	{
		recharge_bal=bal;
	}
	
	
	
	
	
	
	
	//****************************************Payment web service Methods deffination*********************************************************************	
	public String paymentdatacard()
	{
		return url_datacardpayment;
	}
	public String paymentelecity()
	{
		return url_electicitypayment;
	}
	public String paymentgas()
	{
		return url_gaspayment;
	}
	
	public String paymentlandline()
	{
		return url_landlinepayment;
	}
	
	public String paymentmobile()
	{
		return url_mobilerechargepayment;
	}
	
	
	public String paymentdth()
	{
		return url_dthpayment;
	}
	
	public String paymentinsurance()
	{
		return url_insurance;
	}
	
	public String paymengetway()
	{
		return url_getway;
	}
	
	
	public String paymentpopulate()
	{
		return url_populate;
	}
	public String getway()
	{
		return paymentgetway;
	}
	
//*********************************************getmobile number & operator***********************************************************************************	
	public void setno(String no)
	{
		no=no;
	}
	public String no()
	{
		return no;
	}
	public void setopt(String opt)
	{
		opt=opt;
	}
	public String opt()
	{
		return opt;
	}
	
	
//*********************************************Check Internet Connection***********************************************************************************	
//	public  boolean isNetworkAvailable() {
//	    ConnectivityManager connectivityManager 
//	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//	}
	
	
	
	
	
	
	
	
	
	
	//	**********************Coupan category methode deffination**********************************************
	public String getcoupancategory()
	{
		return url_coupan_category;
	}
	
	public String getSelectiondata()
	{
		return url_selectiondata;
	}
	
	
	
	public String getapply()
	{
		return url_apply;
	}
	
	public String getpick()
	{
		return url_pick;
	}
	
	
	
	
	
	
	
	
	
	
//	********************************************************************
	public void setcarddata(String data) {
        
	       datacard = data;
	         
	    }
	
	public String getdatacard() {
        
	      return datacard;
	         
	    }
	public void setcurrentpossionSignup(String data) {
        
		currentpossion=data;
	         
	    }
public String getsignuppossion() {
        
		return currentpossion;
	         
	    }
	
	
	
	
	
	
	
	
	
	
	
//	**************set data from Temp Store for Session**************************************************************
	public void setMobileno(String mNo) {
        
	       Mob_no = mNo;
	         
	    }
	public void setoperator(int opratornames) {
        
	       operators = opratornames;
	         
	    }
	
	public void setAmountdata(String amt) {
        
	       amount = amt;
	         
	    }
	public void setActivityFrom(String from) {
        
	       amount = from;
	         
	    }
	
//	**************get data from Mobile Recharge data**************************************************************
	public String getmobileno()
	{
		return Mob_no;
	}
	public int getopratorservice()
	{
		return operators;
	}
	public String getamount()
	{
		return amount;
	}




	String selectUserStr="";
String loginUserName;

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getSelectUserStr() {
		return selectUserStr;
	}

	public void setSelectUserStr(String selectUserStr) {
		this.selectUserStr = selectUserStr;
	}
















// Creditpay


	public static String  baseUrllink="http://demo.lannettechnology.net/test/rechargeapis/";
	//public static String  baseUrllink="http://192.206.6.82/~creditpe/apis/";
	//public static String bannerURL="http://192.206.6.82/~creditpe/apis/bannerImages/";
	public static String  bannerURL="http://demo.lannettechnology.net/test/rechargeapis/bannerImages/";
	String intOperatorType="";
	String intOperatorID="";
	String regionNameStr="";
	String uIDUser="";
	String balexisting="";
	ArrayList<String>bannerlist=new ArrayList<String>();

	public ArrayList<String> getBannerlist() {
		return bannerlist;
	}

	public void setBannerlist(ArrayList<String> bannerlist) {
		this.bannerlist = bannerlist;
	}

	//Transfer Balnce
	String mobileSho;
	String nameSho;
	String amountSho;
	boolean flgchek=false;
String userMob;
String ScanresultData;
	String otpStr;
String picUrl;
	String mobno;

	boolean otpIsAutofill;
	String otpAutofill;

	// get transfer detail
	String nameMar;
	String shopnameMar;
	String shopaddressMar;
	String amounttransferMar;
	String accountMar;
	String ifsc;
	String bnkMar;
    String shopId;
String LatStr;
	String longStr;

	String shoplat;
	String shoplong;

	public String getShoplong() {
		return shoplong;
	}

	public void setShoplong(String shoplong) {
		this.shoplong = shoplong;
	}

	public String getShoplat() {
		return shoplat;
	}

	public void setShoplat(String shoplat) {
		this.shoplat = shoplat;
	}

	public String getShopId() {
		return shopId;
	}

	public String getUrl_registration() {
		return url_registration;
	}

	public void setUrl_registration(String url_registration) {
		this.url_registration = url_registration;
	}

	public String getLongStr() {
		return longStr;
	}

	public void setLongStr(String longStr) {
		this.longStr = longStr;
	}

	public String getLatStr() {
		return LatStr;
	}

	public void setLatStr(String latStr) {
		LatStr = latStr;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getNameMar() {
		return nameMar;
	}

	public void setNameMar(String nameMar) {
		this.nameMar = nameMar;
	}

	public String getShopnameMar() {
		return shopnameMar;
	}

	public void setShopnameMar(String shopnameMar) {
		this.shopnameMar = shopnameMar;
	}

	public String getShopaddressMar() {
		return shopaddressMar;
	}

	public void setShopaddressMar(String shopaddressMar) {
		this.shopaddressMar = shopaddressMar;
	}

	public String getAmounttransferMar() {
		return amounttransferMar;
	}

	public void setAmounttransferMar(String amounttransferMar) {
		this.amounttransferMar = amounttransferMar;
	}

	public String getAccountMar() {
		return accountMar;
	}

	public void setAccountMar(String accountMar) {
		this.accountMar = accountMar;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBnkMar() {
		return bnkMar;
	}

	public void setBnkMar(String bnkMar) {
		this.bnkMar = bnkMar;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getOtpAutofill() {
		return otpAutofill;
	}

	public void setOtpAutofill(String otpAutofill) {
		this.otpAutofill = otpAutofill;
	}
	public String getScanresultData() {
		return ScanresultData;
	}

	public void setScanresultData(String scanresultData) {
		ScanresultData = scanresultData;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getOtpStr() {
		return otpStr;
	}

	public void setOtpStr(String otpStr) {
		this.otpStr = otpStr;
	}

	public boolean isFlgchek() {
		return flgchek;
	}

	public void setFlgchek(boolean flgchek) {
		this.flgchek = flgchek;
	}

	public String getAmountSho() {
		return amountSho;
	}

	public void setAmountSho(String amountSho) {
		this.amountSho = amountSho;
	}

	public String getNameSho() {
		return nameSho;
	}

	public void setNameSho(String nameSho) {
		this.nameSho = nameSho;
	}

	public String getMobileSho() {
		return mobileSho;
	}

	public void setMobileSho(String mobileSho) {
		this.mobileSho = mobileSho;
	}

	public String getuIDUser() {
		return uIDUser;
	}

	public void setuIDUser(String uIDUser) {
		this.uIDUser = uIDUser;
	}

	public String getIntOperatorType() {
		return intOperatorType;
	}

	public void setIntOperatorType(String intOperatorType) {
		this.intOperatorType = intOperatorType;
	}

	public String getBalexisting() {
		return balexisting;
	}

	public void setBalexisting(String balexisting) {
		this.balexisting = balexisting;
	}
}
