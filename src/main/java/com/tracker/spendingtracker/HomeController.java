package com.tracker.spendingtracker;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.model.Users;
import com.tracker.model.bankAccount;
import com.tracker.model.creditcard;
import com.tracker.model.recurringLog;
import com.tracker.model.recurringTransaction;
import com.tracker.model.transaction;
import com.tracker.dao.BankAccountDao;
import com.tracker.dao.CreditCardDao;
import com.tracker.dao.LoginDao;
import com.tracker.dao.RecurringLogDao;
import com.tracker.dao.RecurringTransDao;
import com.tracker.dao.TransactionDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private BankAccountDao badao;
	
	@Autowired
	private CreditCardDao ccdao;
	
	
	@Autowired
	private TransactionDao tdao;
	
	@Autowired
	private RecurringTransDao rtdao;
	
	@Autowired
	private RecurringLogDao rldao;
	
	
	private Users loggedUser;
	private List<bankAccount> accounts;
	private List<creditcard> cards;
	private List<transaction> transactions;
	private HashMap<Integer, String> accountMap= new HashMap<Integer, String>();
	private HashMap<Integer, String> cardMap = new HashMap<Integer, String>();
	private HashMap<String, Integer> accountMapRev= new HashMap<String, Integer>();
	private HashMap<String, Integer> cardMapRev = new HashMap<String, Integer>();
	private ArrayList<String> accnames;
	private ArrayList<String> cardnames;
	private List<recurringLog> recurrLog;
	private List<recurringTransaction> recurrTrans;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value="trylogin", method=RequestMethod.POST)
	public String tryLogin(Model model, @RequestParam("lusername")String userName, @RequestParam("lpassword")String passWord) throws InterruptedException {
		//System.out.println("here");
		Users users = loginDao.queryByUserName(userName, passWord);
		if(users==null) {
			//JOptionPane.showMessageDialog(null, "failure");
			model.addAttribute("errormessage","Error: Invalid Credentials. Please login with the valid username and password");
			return "home";
		} else {
			loggedUser=users;
			//JOptionPane.showMessageDialog(null, "success");
			//model.addAttribute("errormessage","Success");
			//wait(10);
			setPageDefaults(model);
			return "dashboard";
		}
	}
	
	public void setPageDefaults(Model model) {
		model.addAttribute("firstname",loggedUser.getFirstName());
		model.addAttribute("lastname", loggedUser.getLastName());
		accounts= badao.fetchAllAccounts(loggedUser.getUserID());
		cards=ccdao.fetchAllCards(loggedUser.getUserID());
		transactions=tdao.fetchAllTransactions(loggedUser.getUserID());
		accnames = new ArrayList<String>();
		cardnames = new ArrayList<String>();
		double sum=0.0;
		for(bankAccount ba : accounts) {
			sum+=ba.getAccountBalance();
			accountMap.put(ba.getAccountID(), ba.getAccountName());
			accountMapRev.put(ba.getAccountName(), ba.getAccountID());
			accnames.add(ba.getAccountName());
		}
		double clinesum=0.0;
		double clineusablesum=0.0;
		for(creditcard cc : cards) {
			double usable = (double)cc.getUsePercentage() * cc.getCreditLimit()/100;
			clinesum+=cc.getCreditLimit();
			clineusablesum+=usable;
			cardMap.put(cc.getCardID(), cc.getCardName());
			cardMapRev.put(cc.getCardName(), cc.getCardID());
			cardnames.add(cc.getCardName());
		}
		
		double cardgap = tdao.getTotalCreditIncomes(loggedUser.getUserID()) - tdao.getTotalCreditExpenses(loggedUser.getUserID());
		double incomes = tdao.getTotalIncomes(loggedUser.getUserID());
		double expenses = tdao.getTotalExpenses(loggedUser.getUserID());
		model.addAttribute("expenses",expenses);
		model.addAttribute("incomes", incomes);
		model.addAttribute("creditline", clinesum + cardgap);
		model.addAttribute("creditusable", clineusablesum + cardgap);
		model.addAttribute("bankbalance",sum);
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String signUp(Model model, @RequestParam("rusername")String userName, @RequestParam("rpassword1")String passWord1,
			@RequestParam("rpassword2")String passWord2,
			@RequestParam("age")int age,
			@RequestParam("currency")String currency,
			@RequestParam("remail")String email,
			@RequestParam("rfname")String firstName,
			@RequestParam("rmname")String middleName,
			@RequestParam("rlname")String lastName,
			@RequestParam("dob")String dob){
		//System.out.println("here");
		loginDao.addUser(userName, passWord1, email, age, currency,firstName, middleName, lastName, dob);
		model.addAttribute("regmessage", "Successfully created credentials. Please navigate to login tab and login");
		return "home";
	}
	
	@RequestMapping(value="checkusername", method=RequestMethod.POST)
	public String checkUser(Model model, @RequestParam("rusername")String userName) {
		System.out.println("here");
		boolean flag = loginDao.checkValidUser(userName);
		if(flag) {
			model.addAttribute("uservalidity","Username Available");
		} else 
			model.addAttribute("uservalidity", "Username not available");
		return "home";
	}
	
	@RequestMapping(value="profile", method=RequestMethod.GET)
	public String profilePage(Model model) {
		model.addAttribute("firstname",loggedUser.getFirstName());
		model.addAttribute("lastname", loggedUser.getLastName());
		if(loggedUser.getMiddleName()==null) {
			model.addAttribute("middlename", "");
		} else {
			model.addAttribute("middlename",loggedUser.getMiddleName());
		}
		
		model.addAttribute("email", loggedUser.getEmailID());
		model.addAttribute("currency",loggedUser.getCurrency());
		model.addAttribute("dob",loggedUser.getDob());
		model.addAttribute("age", loggedUser.getAge());
		model.addAttribute("password",loggedUser.getPassWord());
		model.addAttribute("uname", loggedUser.getUserName());
		model.addAttribute("uid",loggedUser.getUserID());
		return "profile";
	}
	
	@RequestMapping(value="updateprofile", method=RequestMethod.POST)
	public String saveProfile(Model model, 
			@RequestParam("uname")String userName,
			@RequestParam("password")String passWord1,
			@RequestParam("age")int age,
			@RequestParam("currency")String currency,
			@RequestParam("email")String email,
			@RequestParam("fname")String firstName,
			@RequestParam("mname")String middleName,
			@RequestParam("lname")String lastName,
			@RequestParam("dob")String dob,
			@RequestParam("uid")int uid){
		System.out.println("fetched data");
		//JOptionPane.showMessageDialog(null, userName+passWord1+age+currency+email+firstName+middleName+lastName+dob+uid);
		Users user = loginDao.updateUser(uid, userName, passWord1, email, age, currency, firstName, middleName, lastName, dob);
		//System.out.println("updated user");
		loggedUser=user;
		model.addAttribute("firstname",loggedUser.getFirstName());
		model.addAttribute("lastname", loggedUser.getLastName());
		if(loggedUser.getMiddleName()==null) {
			model.addAttribute("middlename", "");
		} else {
			model.addAttribute("middlename",loggedUser.getMiddleName());
		}
		
		model.addAttribute("email", loggedUser.getEmailID());
		model.addAttribute("currency",loggedUser.getCurrency());
		model.addAttribute("dob",loggedUser.getDob());
		model.addAttribute("age", loggedUser.getAge());
		model.addAttribute("password",loggedUser.getPassWord());
		model.addAttribute("uname", loggedUser.getUserName());
		model.addAttribute("uid",loggedUser.getUserID());
		model.addAttribute("message","Changes have been saved successufully");
		return "profile";
	}
	
	
	@RequestMapping(value="signout", method=RequestMethod.GET)
	public String signout(Model model) {
		loggedUser=null;
		return "home";
	}
	
	@RequestMapping(value="addbankaccount", method=RequestMethod.GET)
	public String addBankaccount(Model model) {
		
		return "addbankaccount";
	}
	
	@RequestMapping(value="addcreditcard", method=RequestMethod.GET)
	public String addCreditCard(Model model) {
		setPageDefaults(model);
		return "addcreditcard";
	}
	
	@RequestMapping(value="addtrans", method=RequestMethod.GET)
	public String addExpense(Model model) {
		setPageDefaults(model);
		
		model.addAttribute("cardlist", cardnames);
		model.addAttribute("accountlist",accnames);
		return "addtrans";
	}
	
	@RequestMapping(value="dashboard", method=RequestMethod.GET)
	public String gotoDashboard(Model model) {
		setPageDefaults(model);
		return "dashboard";
	}
	
	@RequestMapping(value="addbaccount", method=RequestMethod.POST)
	public String addbaccount(Model model, @RequestParam("accntname")String accntName, @RequestParam("accntbalance")double balance,
			@RequestParam("accnttype")String accntType, @RequestParam("accntbank")String bankName) {
		badao.addBankAccount(accntName, balance, accntType, bankName,loggedUser.getUserID());
		model.addAttribute("message", "Successfully added the bank account");
		
		return "addbankaccount";
	}
	
	
	@RequestMapping(value="addcc", method=RequestMethod.POST)
	public String addCC(Model model, @RequestParam("cname")String cName, @RequestParam("climit")double limit,
			@RequestParam("pddate")int due, @RequestParam("cissuer")String issuer,@RequestParam("cperc")int perc ) {
		System.out.println("here");
		ccdao.addCreditCard(cName, limit, due, loggedUser.getUserID(), issuer, perc);
		model.addAttribute("message", "Successfully added the credit card");
		return "addcreditcard";
	}
	
	@RequestMapping(value="updatebankaccounts") 
	public String updatebapage(Model model) {
		model.addAttribute("accountlist",accounts);
		return "updatebankaccounts";
	}
	
	@RequestMapping(value="summary") 
	public String displaySummary(Model model,Locale locale) {
		ArrayList<transaction> bankexpense = new ArrayList<transaction>();
		ArrayList<transaction> bankincome = new ArrayList<transaction>();
		ArrayList<transaction> cardexpense = new ArrayList<transaction>();
		ArrayList<transaction> cardincome = new ArrayList<transaction>();
		double betot=0.0, bitot=0.0, cetot=0.0, citot=0.0;
		for(transaction trans : transactions) {
			transaction temp=tdao.clone(trans);
			if(trans.getTransMethod().equalsIgnoreCase("expense")) {
				if(trans.getTransType().equalsIgnoreCase("bank")) {
					temp.setTransMethod(accountMap.get(trans.getTransTypeID()));
					bankexpense.add(temp);
					betot+=trans.getTransAmount();
				} else {
					temp.setTransMethod(cardMap.get(trans.getTransTypeID()));
					cardexpense.add(temp);
					cetot+=trans.getTransAmount();
				}
			} else if(trans.getTransMethod().equalsIgnoreCase("income")) {
				if(trans.getTransType().equalsIgnoreCase("bank")) {
					temp.setTransMethod(accountMap.get(trans.getTransTypeID()));
					bankincome.add(temp);
					bitot+=trans.getTransAmount();
				} else {
					temp.setTransMethod(cardMap.get(trans.getTransTypeID()));
					cardincome.add(temp);
					citot+=trans.getTransAmount();
				}
			}
		}
		Date date = new Date();
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
				String formattedDate = dateFormat.format(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		JOptionPane.showMessageDialog(null,cal.get(Calendar.MONTH));
		
		model.addAttribute("serverTime", formattedDate );
		
		model.addAttribute("bankexpenselist", bankexpense);
		model.addAttribute("cardexpenselist", cardexpense);
		model.addAttribute("bankincomelist", bankincome);
		model.addAttribute("cardincomelist", cardincome);
		model.addAttribute("betot", betot);
		model.addAttribute("bitot", bitot);
		model.addAttribute("cetot", cetot);
		model.addAttribute("citot", citot);
		return "summary";
	}
	
	@RequestMapping(value="updatebankaccount", method=RequestMethod.POST) 
	public String updateBAAccount(Model model, @RequestParam(value="accntid")String[] accIDLst,
			@RequestParam(value="accntname")String[] accNameLst,
			@RequestParam(value="accntuid")String[] accUIDLst,
			@RequestParam(value="accntbal")String[] accBalLst,
			@RequestParam(value="accnttype")String[] accTypeLst,
			@RequestParam(value="accntbname")String[] accBLst){
		for(int i=0;i<accIDLst.length;i++) {
			bankAccount ba = new bankAccount();
			ba.setAccountBalance(Double.parseDouble(accBalLst[i]));
			ba.setAccountBank(accBLst[i]);
			ba.setAccountHolderID(Integer.parseInt(accUIDLst[i]));
			ba.setAccountID(Integer.parseInt(accIDLst[i]));
			ba.setAccountName(accNameLst[i]);
			ba.setAccountType(accTypeLst[i]);
			if(!accounts.get(i).objectEquals(ba)) {
				badao.updateBankAccount(ba);
			}	
		}
		setPageDefaults(model);
		model.addAttribute("accountlist", accounts);
		return "updatebankaccounts";
	}
	
	@RequestMapping(value="addtrans", method=RequestMethod.POST) 
	public String addnewTrans(Model model, @RequestParam(value="etype")String type, 
			@RequestParam(value="ename")String name,
			@RequestParam(value="atype")String account,
			@RequestParam(value="eba")String baname,
			@RequestParam(value="ecc")String ccname,
			@RequestParam(value="edate")Date date,
			@RequestParam(value="eamount")double amount,
			@RequestParam(value="edesc")String desc) {
		
		int bankid=0;
		bankAccount accnt=null;
		for(bankAccount ba : accounts) {
			if(ba.getAccountName().equalsIgnoreCase(baname)) {
				bankid=ba.getAccountID();
				accnt=ba;
				break;
			}
		}
		int ccid=0;
		creditcard ccard=null;
		for(creditcard cc : cards) {
			if(cc.getCardName().equalsIgnoreCase(ccname)) {
				ccid=cc.getCardID();
				ccard=cc;
				break;
			}
		}
		
		int transtypeid=0;
		if(account.equalsIgnoreCase("card")) {
			transtypeid=ccid;
		} else {
			if(type.equalsIgnoreCase("income")) {
				accnt.setAccountBalance(accnt.getAccountBalance()+amount);
			} else {
				accnt.setAccountBalance(accnt.getAccountBalance()-amount);
			}
			badao.updateBankAccount(accnt);
			transtypeid=bankid;
		}
		
		
		
		transaction t = new transaction();
		t.setTransAmount(amount);
		
		t.setTransDesc(desc);
		t.setTransMethod(type);
		t.setTransType(account);
		t.setTransName(name);
		t.setTransTypeID(transtypeid);
		t.setTransUserID(loggedUser.getUserID());
		t.setTransDate(date);
		tdao.addTransaction(t);
		setPageDefaults(model);
		ArrayList<String> accnames = new ArrayList<String>();
		for(bankAccount ba : accounts) {
			accnames.add(ba.getAccountName());
		}
		ArrayList<String> cardnames = new ArrayList<String>();
		for(creditcard cc : cards) {
			cardnames.add(cc.getCardName());
		}
		model.addAttribute("cardlist", cardnames);
		model.addAttribute("accountlist",accnames);
		model.addAttribute("Transaction details have been updated successfully");
		
		return "addtrans";
	}
	
	@RequestMapping(value="addrecurtrans")
	public String gotoRecurPage(Model model) throws ParseException {
		setPageDefaults(model);
		ArrayList<Integer> monthLst = new ArrayList<Integer>();
		ArrayList<Integer> dayLst = new ArrayList<Integer>();
		for(int i=1;i<=12;i++) {
			monthLst.add(i);
		}
		
		for(int i=1;i<=31;i++){
			dayLst.add(i);
		}
		updateTablesRecurrence();
		model.addAttribute("accountlist", accnames);
		model.addAttribute("cardlist", cardnames);
		model.addAttribute("daylist", dayLst);
		model.addAttribute("monthlist", monthLst);
		return "addrecurtrans";
	}
	
	@RequestMapping(value="addrecurtrans", method=RequestMethod.POST)
	public String addRecurTrans(Model model,
			@RequestParam(value="type")String type,
			@RequestParam(value="account")String account,
			@RequestParam(value="name")String name,
			@RequestParam(value="bankaccounts")String bankaccount,
			@RequestParam(value="creditcards")String creditcard,
			@RequestParam(value="amount")double amount,
			@RequestParam(value="period")String period,
			@RequestParam(value="day")int day,
			@RequestParam(value="month")int month,
			@RequestParam(value="desc")String desc) throws ParseException {
		setPageDefaults(model);
		ArrayList<Integer> monthLst = new ArrayList<Integer>();
		ArrayList<Integer> dayLst = new ArrayList<Integer>();
		recurringTransaction rt = new recurringTransaction();
		int acid=0;
		if(account.equalsIgnoreCase("card")) {
			acid=cardMapRev.get(creditcard);
		} else {
			acid=accountMapRev.get(bankaccount);
		}
		if(period.equalsIgnoreCase("monthly")) {
			month=0;
		}
		JOptionPane.showMessageDialog(null, account);
		rt.setAccountID(acid);
		rt.setAccountType(account);
		rt.setAmount(amount);
		rt.setDay(day);
		rt.setMonth(month);
		rt.setDescp(desc);
		rt.setRecurringType(period);
		rt.setTransType(type);
		rt.setUserID(loggedUser.getUserID());
		rt=rtdao.addRecurTrans(rt);
		rldao.addRecurringTransaction(rt);
		JOptionPane.showMessageDialog(null, rt.getId());
		for(int i=1;i<=12;i++) {
			monthLst.add(i);
		}
		
		for(int i=1;i<=31;i++){
			dayLst.add(i);
		}
		model.addAttribute("daylist", dayLst);
		model.addAttribute("monthlist", monthLst);
		updateTablesRecurrence();
		model.addAttribute("message", "Recurring transaction has been recorded. Accounts will get updated automatically based on the data provided.");
		return "addrecurtrans";
	}
	
	public void updateTablesRecurrence() throws ParseException {
		//ArrayList<recurringTransaction> rts = rtdao.getAllRecurTrans(loggedUser.getUserID());
		ArrayList<recurringLog> rls = rldao.getAllRecurLogs(loggedUser.getUserID());
		for(recurringLog rl :rls) {
			Date d = new java.util.Date();
			//JOptionPane.showMessageDialog(null, d.toString() + "/n" + rl.getRecurDate().toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date nd = sdf.parse(sdf.format(d));
			Date rldate = rl.getRecurDate();
			if(rldate.compareTo(nd)==0 && rl.getStatus().equalsIgnoreCase("unpaid")) {
				JOptionPane.showMessageDialog(null, "yeah");
				rl.setStatus("paid");
				transaction t = new transaction();
				rldao.updateLog(rl);
				t.setTransAmount(rl.getAmount());
				t.setTransDate(nd);
				t.setTransDesc("Recurring transaction: " + rl.getDescp());
				t.setTransMethod(rl.getTransType());
				//t.setTransMonth(Calendar.getInstance().get(Calendar.MONTH));
				t.setTransName("Recurring transaction: " + rl.getDescp());
				t.setTransType(rl.getAccountType());
				t.setTransUserID(loggedUser.getUserID());
				t.setTransTypeID(rl.getAccountID());
				
				tdao.addTransaction(t);
				int transtypeid=0;
				bankAccount accnt=null;
				for(bankAccount ba : accounts) {
					if(ba.getAccountID()==rl.getAccountID()) {
						//bankid=ba.getAccountID();
						accnt=ba;
						break;
					}
				}
				
				if(rl.getAccountType().equalsIgnoreCase("card")) {
					
				} else {
					if(rl.getTransType().equalsIgnoreCase("income")) {
						accnt.setAccountBalance(accnt.getAccountBalance()+rl.getAmount());
					} else {
						accnt.setAccountBalance(accnt.getAccountBalance()-rl.getAmount());
					}
					badao.updateBankAccount(accnt);
					
				}
				
			}
		}
		
	}
	
	
	
	
	
	
	
}
