import java.util.Scanner;
import java.util.Calendar;
import java.util.Hashtable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Enumeration;
import java.io.IOException;

public class Admin
{
	// Time 객체 생성
   Time time = new Time();
	
   static String startTime; // 시작시간
   String currentTime;      // 현재시간
   int repairChargeSum=0;   // 재부팅시 불러올 변수



   boolean b;					//시작여부 확인위한 변수 설정

   public boolean power=true;	//콘솔에서 프로그램 시간이 시작되었을 때

	

	// 재료, 거스름돈 초기설정
   private static int bean =0;
   private static int bubble=100;
   private static int water=100; 
   private static int chocosyrup=100;
   private static int syrup=100;
   private static int milk=100;
   private static int teabag=100;
   private static int icetea=100;
   private static int cocoa=100;
   private static int whipping=100;
   private static int cass=100;
   private static int hite=100;
   private static int terra=100;
   private static int heineken=100;
   private static int guiness=100;
   private static int stockType;
   private static int stockNum;
   private static int stockCup=100;
   private static int ice=100;
   private static int manwon=100;
   private static int chunwon5=100;
   private static int chunwon1=0;
   private static int bakwon5=100;
   private static int bakwon1=100;
  
   // 초기 관리자 비밀번호 설정
   private static int ownerpass=7897;

   // 판매량 초기값 설정
   private static int americanosale=0;
   private static int iceteasale=0;
   private static int earlgreysale=0;
   private static int mochasale=0;
   private static int chocolatesale=0;
   private static int lattesale=0;
   private static int casssale=0;
   private static int hitesale=0;
   private static int terrasale=0;
   private static int guinesssale=0;
   private static int heinekensale=0;
    
   private static int tot=0; // 총 매출
   private static int payment=0; // 계산금액

   // 인증 번호 길이 설정
   private static int certCharLength=8;
  
   // 비밀번호 길이설정 메소드
   public void setcertCharLength(int certcharLength){this.certCharLength=certCharLength;}
  
   // 재료, 거스름 설정
   public void setBean(int bean){this.bean = bean;}
   public void setPayment(int payment){this.payment = payment;}
   public void setBubble(int bubble){this.bubble = bubble;}
   public void setWater(int water){this.water = water;}
   public void setChocosyrup(int chocosyrup){this.chocosyrup = chocosyrup;}
   public void setSyrup(int syrup){this.syrup = syrup;}
   public void setMilk(int milk){this.milk = milk;}
   public void setIce(int ice){this.ice = ice;}
   public void setTeabag(int teabag){this.teabag = teabag;}
   public void setIcetea(int icetea){this.icetea = icetea;}
   public void setCocoa(int cocoa){this.cocoa = cocoa;}
   public void setWhipping(int whipping){this.whipping = whipping;}
   public void setCass(int cass){this.cass = cass;}
   public void setHite(int hite){this.hite =  hite;}
   public void setTerra(int terra){this.terra =  terra;}
   public void setHeineken(int heineken){this.heineken =  heineken;}
   public void setGuiness(int guiness){this.guiness =  guiness;}
   public void setStockType(int stockType){this.stockType =  stockType;}
   public void setStockNum(int stockNum){this.stockNum =  stockNum;}
   public void setStockCup(int stockCup){this.stockCup =  stockCup;}
   public void setmanWon(int manwon)
	   {
	   this.manwon =  manwon;
	   }
   public void setchunWon5(int chunwon5)
	   {
	   this.chunwon5 =  chunwon5;
	   }
   public void setchunWon1(int chunwon1)
	   {
	   this.chunwon1 = chunwon1;
	   }
   public void setbakWon5(int bakwon5)
	   {
	   this.bakwon5 =  bakwon5;
	   }
   public void setbakWon1(int bakwon1)
	   {
	   this.bakwon1 =  bakwon1;
	   }

   // 비밀번호 변경
   public void setownerPass(int ownerpass){this.ownerpass =  ownerpass;}
   
   
   
   
   // 판매량 설정
   public void setTot(int tot) { this.tot = tot; }
   public void setAmericanoSale(int americanosale){this.americanosale = americanosale;}
   public void setLatteSale(int lattesale){this.lattesale = lattesale;}
   public void setIceteaSale(int iceteasale){this.iceteasale = iceteasale;}
   public void setMochaSale(int mochasale){this.mochasale = mochasale;}
   public void setChocolateSale(int chocolatesale){this.chocolatesale = chocolatesale;}
   public void setEarlgreySale(int earlgreysale){this.earlgreysale = earlgreysale;}

   public void setCassSale(int casssale){this.casssale = casssale;}
   public void setHiteSale(int hitesale){this.hitesale = hitesale;}
   public void setGuinessSale(int guinesssale){this.guinesssale = guinesssale;}
   public void setTerraSale(int terrasale){this.terrasale = terrasale;}
   public void setHeinekenSale(int heinekensale){this.heinekensale = heinekensale;}
 

   //setter완료

   //재료, 거스름
   public int getBean(){return bean;}
   public int getBubble(){return bubble;}
   public int getWater(){return water;}
   public int getIce(){return ice;}
   public int getChocosyrup(){return chocosyrup;}
   public int getSyrup(){return syrup;}
   public int getMilk(){return milk;}
   public int getTeabag(){return teabag;}
   public int getIcetea(){return icetea;}
   public int getCocoa(){return cocoa;}
   public int getWhipping(){return whipping;}
   public int getCass(){return cass;}
   public int getHite(){return hite;}
   public int getTerra(){return terra;}
   public int getHeineken(){return heineken;}
   public int getGuiness(){return guiness;}
   public int getStockType(){return stockType;}
   public int getStockNum(){return stockNum;}
   public int getStockcup(){return stockCup;}
   public int getmanWon(){return manwon;}
   public int getchunWon5(){return chunwon5;}
   public int getchunWon1(){return chunwon1;}
   public int getbakWon5(){return bakwon5;}
   public int getbakWon1(){return bakwon1;}

   // 관리자 비밀번호
   public int getownerPass(){return ownerpass;}
  
   
   // 총 매출
   public int getTot() {return tot;}

   // 내야할 금액
   public int getPayment(){return payment;}

	
   // 맥주, 커피 판매량
   public int getAmericanoSale(){return americanosale;}
   public int getLatteSale(){return lattesale;}
   public int getIceteaSale(){return iceteasale;}
   public int getMochaSale(){return mochasale;}
   public int getChocolateSale(){return chocolatesale;}
   public int getEarlgreySale(){return earlgreysale;}

   public int getCassSale(){return casssale;}
   public int getHiteSale(){return hitesale;}
   public int getTerraSale(){return terrasale;}
   public int getGuinessSale(){return guinesssale;}
   public int getHeinekenSale(){return heinekensale;}
   
   // 보안 인증번호 길이
	public int certCharLength(){return certCharLength;}
   //getter완료



	

	public void disp()  // 메뉴 출력
	{
	Mainmachine n1=new Mainmachine(); // 메인 객체 생성
	try
	{
			int n;
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t   <관리자 모드>");
			System.out.println();
			System.out.printf("\t\t 1.총 매출  \n");  
			System.out.printf("\t\t 2.재고 관리\n");
			System.out.printf("\t\t 3.거스름돈 관리\n");
			System.out.printf("\t\t 4.가격 설정\n");
			System.out.printf("\t\t 5.비밀번호 변경\n");
			System.out.printf("\t\t 6.사용시간(고장율) 확인\n");
			System.out.printf("\t\t 7.재부팅 시작\n");
			System.out.printf("\t\t 8.처음으로\n");
			System.out.println("------------------------------------------------------------");
			System.out.println();
			System.out.print("이용하실 메뉴를 입력해주세요 : ");
			n=sc.nextInt();
	
			switch (n)
			{
			case 1 : totalmoney(); disp();break;
			case 2 : stock(); disp();break;
			case 3 : change(); disp();break;
			case 4 : reprice(); disp();break;
			case 5 : repass(); disp();break;
			case 6 : reboot3(); disp();break;
			case 7 : reboot4(); disp(); break;
			case 8 : n1.dispMenu(); break;
			}	
	} // end try

		catch (Exception e)
		{
		}
	}// end disp

   	public void totalmoney() // 오늘의 매출
	{	
		System.out.printf("오늘 매출은 %d원 입니다\n",getTot());
		System.out.printf("아메리카노의 판매량은 %d \n",getAmericanoSale());
		System.out.printf("카페라떼의 판매량은 %d \n",getLatteSale());
		System.out.printf("카페모카의 판매량은 %d \n",getMochaSale());
		System.out.printf("아이스티의 판매량은 %d \n",getIceteaSale());
		System.out.printf("초콜렛의 판매량은 %d \n",getChocolateSale());
		System.out.printf("얼그레이의 판매량은 %d \n",getEarlgreySale());
		System.out.printf("카스의 판매량은 %d \n",getCassSale());
		System.out.printf("하이트의 판매량은 %d \n",getHiteSale());
		System.out.printf("기네스의 판매량은 %d \n",getGuinessSale());
		System.out.printf("하이네켄의 판매량은 %d \n",getHeinekenSale());
		System.out.printf("테라의 판매량은 %d \n",getTerraSale());
	} // end totalmoney


	//매출 데이터 파일에 쓰기
	@SuppressWarnings("unchecked") // 오류 처리
	public void out() throws Exception
	{
		Cafe ca = new Cafe();
		Beer be = new Beer();
		//캘린더 클래스 기반 인스턴스 생성
		Calendar c = Calendar.getInstance();

		//오늘의 연도, 달, 날짜
		int y = (c.get(Calendar.YEAR)); 
		int m = (c.get(Calendar.MONTH)+1);
		int d = (c.get(Calendar.DATE));
		//연도, 달, 날짜 합쳐서 문자열로 변환
		String today = Integer.toString(y) + "-" + Integer.toString(m) + "-" +Integer.toString(d);
	
		//경로 찾기
		String appDir = System.getProperty("user.dir");

		//해당 경로에 list폴더에 list.txt파일 생성
		File list = new File(appDir, "\\list\\list.txt");

		
		//파일이 존재하지 않는다면 생성
		if(!list.getParentFile().exists())
			list.getParentFile().mkdirs();


		//입력순대로 출력하기 위해 LinkedHashMap 사용
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		

		//map에 값 저장하기
		map.put(today, tot);
		map.put("아메리카노 판매량 :", getAmericanoSale());
		map.put("아이스티 판매량 :", getIceteaSale());
		map.put("카페라떼 판매량 :", getLatteSale());
		map.put("카페모카 판매량 :", getMochaSale());
		map.put("얼그레이 판매량 :", getEarlgreySale());
		map.put("초콜렛 판매량 :", getChocolateSale());
		map.put("카스 판매량 :", getCassSale());
		map.put("하이트 판매량 :", getHiteSale());
		map.put("기네스 판매량 :", getGuinessSale());
		map.put("하이네켄 판매량 :", getHeinekenSale());
		map.put("테라 판매량 :", getTerraSale());

		//파일 쓰기
		FileOutputStream fos = new FileOutputStream(list);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		oos.writeObject(map);
		oos.close();
		fos.close();

		//생성되 파일 읽어와서 확인하기
		//만약 해당 파일이 존재한다면
		if (list.exists())
		{
				FileInputStream fis = new FileInputStream(list);
				ObjectInputStream ois = new ObjectInputStream(fis);

				Map map2 = (LinkedHashMap)ois.readObject();
		
				fis.close(); // InputStream 종료
				ois.close(); // ObjectInputStream 종료

				//해당 파일 내용 출력
				Set<String> set = map2.keySet();
				Iterator<String> it = set.iterator();

				while(it.hasNext())
				{
					String key = ((String)it.next());
					int value = ((Integer)map2.get(key));

					System.out.println(key + "  ->  " + value);
				}

		} //end if

	} // end out


	public void stock()  // 재고 관리
	{   
		Mainmachine n1=new Mainmachine();
	try
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("\t<현재 재고>");
		System.out.println("재료\t\t\t재고");
		
		System.out.printf("1.원두\t\t\t%d\n",bean);
		System.out.printf("2.물\t\t\t%d\n",water);
		System.out.printf("3.초코시럽\t\t%d\n",chocosyrup);
		System.out.printf("4.시럽\t\t\t%d\n",syrup);
		System.out.printf("5.우유\t\t\t%d\n",milk);
		System.out.printf("6.휘핑크림\t\t%d\n",whipping);
		System.out.printf("7.카스\t\t\t%d\n",cass);
		System.out.printf("8.하이트\t\t%d\n",hite);
		System.out.printf("9.테라\t\t\t%d\n",terra);
		System.out.printf("10.하이네켄\t\t%d\n",heineken);
		System.out.printf("11.기네스\t\t%d\n",guiness);
		System.out.printf("12.컵\t\t\t%d\n",stockCup);
		System.out.printf("13.티백\t\t\t%d\n",teabag);
		System.out.printf("14.코코아가루\t\t%d\n",cocoa);
		System.out.printf("15.아이스티\t\t%d\n",icetea);
		
		System.out.println("재고 추가하시겠습니까? (Y/N)");
		String ch = sc.next();

		if (ch.equals("y") || ch.equals("Y")) // 재료를 추가한다면        
        {
		  System.out.print("재고를 채워 넣을 품목의 번호를 입력하세요 : ");
		  int num = sc.nextInt();
          System.out.print("채워 넣을 재고의 양을 입력하세요 : ");
		  int add = sc.nextInt();
		  
		  	switch (num)
			{
				case 1 : bean= bean+add; System.out.println("추가 되었습니다!"); break; 
				case 2 : setWater(getWater() + add); System.out.println("추가 되었습니다!"); break;
				case 3 : chocosyrup += add; System.out.println("추가 되었습니다!"); break;
				case 4 : syrup += add; System.out.println("추가 되었습니다!"); break;
				case 5 : milk += add; System.out.println("추가 되었습니다!"); break;
				case 6 : whipping += add; System.out.println("추가 되었습니다!"); break;
				case 7 : cass += add; System.out.println("추가 되었습니다!"); break;
				case 8 : hite += add; System.out.println("추가 되었습니다!"); break;
				case 9 : terra += add; System.out.println("추가 되었습니다!"); break;
				case 10 : heineken += add; System.out.println("추가 되었습니다!"); break;
				case 11 : guiness += add; System.out.println("추가 되었습니다!"); break;
				case 12 : stockCup += add; System.out.println("추가 되었습니다!"); break;
				case 13 : teabag += add; System.out.println("추가 되었습니다!"); break;
				case 14 : cocoa += add; System.out.println("추가 되었습니다!"); break;
				case 15 : icetea += add; System.out.println("추가 되었습니다!"); break;
				default : System.out.println("다시 시도해주세요"); 
			
			}
		
         }
    	else if (ch.equals("n") || ch.equals("N"))
			{
				disp();
			}
		}
		catch (Exception e)
		{
		}
	
		
	}// end stock()

	public void change() throws Exception  // 거스름돈 관리
	{
		
		Scanner sc = new Scanner(System.in);

		System.out.println("\t<현재 거스름돈>");
		System.out.println("화폐\t\t\t매(개)수");
		
		System.out.printf("1.5000원\t\t%d\n",chunwon5);
		System.out.printf("2.1000원\t\t%d\n",chunwon1);
		System.out.printf("3.500원\t\t\t%d\n",bakwon5);
		System.out.printf("4.100원\t\t\t%d\n",bakwon1);

		System.out.println("화폐매수을 추가하시겠습니까? (Y/N)");
		String ch = sc.next();
		
		if (ch.equals("y") || ch.equals("Y")) // 추가한다면
        {
		  System.out.print("화폐품목의 번호를 입력하세요 : ");
		  setStockType(sc.nextInt());
          System.out.print("화폐매수를 입력하세요 : ");
		  setStockNum(sc.nextInt()); 

		 switch (stockType)
        {
        case 1 : chunwon5 += stockNum; System.out.println("추가 되었습니다!"); break;
        case 2 : chunwon1 += stockNum; System.out.println("추가 되었습니다!"); break;
        case 3 : bakwon5 += stockNum; System.out.println("추가 되었습니다!"); break;
        case 4 : bakwon1 += stockNum; System.out.println("추가 되었습니다!"); break;
        default : System.out.println("다시 시도해주세요"); 
        }
			  
		 }
        else if (ch.equals("n") || ch.equals("N")) // 추가 안한다면
        {
		  disp(); // 관리자 메뉴로 돌아가기
		}
		
		
	} // end change

	public void reprice() throws Exception// 가격 재설정
	{
		Scanner sc = new Scanner(System.in);
		 Mprice mp = new Mprice();
		System.out.print("가격을 재설정할 메뉴의 번호를 입력해주세요 : ");
        int choice = sc.nextInt(); // 재설정할 메뉴 선택
        
		System.out.print("설정할 가격을 입력해 주세요 : ");
		int price = sc.nextInt();  // 재설정할 가격 입력

        switch (choice)
        {
        case 1 : mp.americano = price; System.out.println("재설정 되었습니다!"); break;
        case 2 : mp.icetea = price; System.out.println("재설정 되었습니다!"); break;
        case 3 : mp.latte = price; System.out.println("재설정 되었습니다!"); break;
        case 4 : mp.mocha = price; System.out.println("재설정 되었습니다!"); break;
        case 5 : mp.earlgrey = price; System.out.println("재설정 되었습니다!"); break;
        case 6 : mp.chocolate = price; System.out.println("재설정 되었습니다!"); break;
        case 7 : mp.addshot = price; System.out.println("재설정 되었습니다!"); break;
        case 8 : mp.addsyrup = price; System.out.println("재설정 되었습니다!"); break;
        case 9 : mp.addwhip = price; System.out.println("재설정 되었습니다!"); break;
        case 10 : mp.addbub = price; System.out.println("재설정 되었습니다!"); break;
        case 11 : mp.cass = price; System.out.println("재설정 되었습니다!"); break;
        case 12 : mp.hite = price; System.out.println("재설정 되었습니다!"); break;
        case 13 : mp.terra = price; System.out.println("재설정 되었습니다!"); break;
        case 14 : mp.guiness = price; System.out.println("재설정 되었습니다!"); break;
        case 15 : mp.heineken = price; System.out.println("재설정 되었습니다!"); break;
        default : System.out.println("다시 시도해주세요"); 
        }
	} // end reprice

	
	public  void repass()		//관리자 비밀번호 변경
	{
		//Mainmachine n1 = new Mainmachine();
		Scanner sc = new Scanner(System.in);
		int npass,pass,nnpass;
		System.out.print("현재 비밀번호를 입력해주세요 : ");
		pass=sc.nextInt();
		if(pass==getownerPass()) // 현재 비밀번호가 입력한 비밀번호와 일치한다면
		{
			System.out.print("변경하실 비밀번호를 입력해주세요 : "); 
			npass=sc.nextInt();
			

			System.out.println("비밀번호를 한번 더 입력해주세요!");
			nnpass=sc.nextInt();
			
			if (npass==nnpass) // 변경할 비밀번호와 재입력한 비밀번호가 같다면
			{
				setownerPass(npass);
				System.out.println("비밀번호 변경이 완료되었습니다");
			}
			else
			{
				System.out.println("비밀번호가 일치하지 않습니다");
			}
		}
		
		else
		{
			System.out.println("비밀번호가 일치하지 않습니다");
			//n1.dispMenu();
		}
		
		
	} // end repass


	public void reboot2() // 재부팅 2   ==>> 프로그램이 시작되었을때 위에서 선언한 정수를 한번 일치하면
	{					  //				 시작시간이 찍히게 설정.
		
		int a=1;

		if(a==1){

		startTime = time.currentDateTime(); // 자판기 가동시작시간 저장

		}
		else{
	
			currentTime = time.currentDateTime();
			System.out.println(time.diffDateTime(startTime, currentTime));
			System.exit(1);
		}

	} // end reboot2

	public void reboot3() //스타트 타임 기점으로 시간차계산 ==>> 5번 사용시간(고장율) 확인부분
	{	
		currentTime = time.currentDateTime();	//현재시간을 time.currentDateTime()으로 적용시킴
		
		int s; //	Y/N값 입력할 변수.
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------\n");
        System.out.println("자판기 전원 : On");
        System.out.println("자판기 On 시간 : " + startTime);
        System.out.println("현재 시간 : " + currentTime);
        System.out.println("자판기 작동 시간(초) : " + time.diffDateTime(startTime,currentTime)+"초");
	    System.out.println("현재 고장확률 : " + failureRate() +"%");
		System.out.println("------------------------------\n");
	    System.out.println();	
		
	} // end reboot3

	public void reboot4()	//6번 재부팅 시작에 해당하는 부분
	{	
	    
		currentTime = time.currentDateTime(); // 현재시간 저장

	try
	{
		System.out.println("------------------------------\n");
        System.out.println("자판기 전원 : On");
        System.out.println("자판기 On 시간 : " + startTime);
        System.out.println("현재 시간 : " + currentTime);
        System.out.println("자판기 작동 시간(초) : " + time.diffDateTime(startTime,currentTime)+"초");
	    System.out.println("현재 고장확률 : " + failureRate() +"%");
	    System.out.println();
		System.out.println("재부팅 하겠습니다~!!!");

			System.out.print("재부팅 중입니다");

   		    Thread.sleep(500);

		    for(int i=0; i<10; i++) 
				{

					System.out.print(".");

					Thread.sleep(500);
				}
			System.out.println();

	} // end try
	catch(Exception e)
	{
	     System.out.println("[Error] 메시지를 확인하세요.");

         System.out.println(e);
	}

		// 재부팅후 값을 초기화 해주는 부분
		int repairCharge = failureRate();
		repairChargeSum += failureRate();
		startTime = time.currentDateTime();
		System.out.println("\n- 재부팅이 완료되었습니다.");
		System.out.println("- 재부팅후 고장률 : " + failureRate() +"%");
	} // end reboot4

	public int failureRate()	// 고장율 계산하는 부분
	{
		currentTime = time.currentDateTime(); // 현재시간 저장

		int failureRate =((int) time.diffDateTime(startTime, currentTime)/10);
		if(failureRate<100) {
			return failureRate;
		}
		return 100;
	} // end failureRate 


 } // end Admin

