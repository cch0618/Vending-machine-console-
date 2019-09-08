import java.util.Scanner;

//맥주 클래스(관리자 상속)
public class Beer extends Admin
{
	int n;      //사용자가 선택한 메뉴 번호를 저장할 변수
	char b;     //장바구니 여부를 선택을 저장할 변수
	
	static int cass_num;	//장바구니에서 사용할 맥주갯수 변수
	static int hite_num;
	static int terra_num;
	static int guiness_num;
	static int heineken_num;
	

	Admin ad = new Admin();
	Mprice m = new Mprice();


	//맥주 선택 메소드
	void choiceBeer() 
	{
		Pay pay = new Pay();											   // Pay인스턴스 생성
		Cafe ca = new Cafe();											   // Cafe인스턴스 생성
        int c;															   // 입력받을 변수 선언
		Scanner sc = new Scanner(System.in);
	try
{
	//잘못된 번호를 선택하면 반복
		do
		{String ca1="○";
		 String h1="○";
		 String t1="○";
		 String hi1="○";
		 String g1="○";//빛

		//Cafe c = new Cafe();
		
		//카스
		if (getCass()==0)
		{
			ca1="●";
		}
		//하이트
		if (getHite()==0)
		{
			h1="●";
		}
		//테라
		if (getTerra()==0)
		{
			t1="●";
		}
		//하이네켄
		if (getHeineken()==0)
		{
			hi1="●";
		}
		//기네스
		if (getGuiness()==0)
		{
			g1="●";
		}

	
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t   쌍강교 Cafe ＆ Pub");
		System.out.println();
		System.out.printf("1.카스\t\t%d\t%s \t2.하이트\t%d\t%s\n",m.cass,ca1,m.hite,h1);
		System.out.printf("3.테라\t\t%d\t%s \t4.기네스\t%d\t%s\n",m.terra,t1,m.guiness,g1);
		System.out.printf("5.하이네켄\t%d\t%s\n",m.heineken,hi1);
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t\t\t    (주문가능 : ○ 품절 :●)");
		System.out.println();
		System.out.print("▶ 원하시는 메뉴를 입력해주세요. : ");
		c = sc.nextInt();
		}
		while (c<1 || c>5);

																			
		if(c==1)															//1번, 카스를 선택할 경우
		{
			
			cass_num++;														//카스 주문 개수 증가
		    										//총 누적 금액 증가 set
			setPayment(getPayment()+m.cass);								//현재 결제금액 set
			setCassSale(getCassSale()+1);
		}
			
																			//2번, 하이트를 선택할 경우
		if(c==2)
		{
			hite_num++;														//하이트 주문 개수 증가
		    
			setPayment(getPayment()+m.hite);
			setHiteSale(getHiteSale()+1);
			
		}
																			
		if(c==3)
		{
			terra_num++;													
		    	
			setPayment(getPayment()+m.terra);
			setTerraSale(getTerraSale()+1);
	
		}
		
		if(c==4)
		{
			guiness_num++;		  
		   
			setPayment(getPayment()+m.guiness);
			setGuinessSale(getGuinessSale()+1);

		}
		
		if(c==5)
		{
			heineken_num++;		   
		
			setPayment(getPayment()+m.heineken);
			setHeinekenSale(getHeinekenSale()+1);
		}
		
		String chu;															 //추가주문 여부확인 string변수 선언
		System.out.println();
		System.out.print("▶ 추가주문 하시겠습니까? (Y/N) : ");
		chu = sc.next();
		
		if (chu.equals("y") || chu.equals("Y"))
		{
			choiceBeer();	//추가 맥주 선택
		}//end if
		
		else if (chu.equals("N") || chu.equals("n"))
	    {
			
			
			System.out.println();
			System.out.print("현재 주문 목록은 ");

			String cas=("Cass "+Integer.toString(cass_num));			//정수형인 cass_num을 문자열인 cas에 더하기 위하여 Integer.toString()으로 형변환 후 결합
			String hit=("Hite "+Integer.toString(hite_num));			
			String gui=("Guiness "+Integer.toString(guiness_num));
			String ter=("Terra "+Integer.toString(terra_num));
			String hei=("Heineken "+Integer.toString(heineken_num));
		
		
				if (cass_num==0)										// 이용자가 구매하지 않았을때, ""로 초기화
				{
					cas="";
				}
				
				if (hite_num==0)
				{
					hit="";
				}
				
				if (guiness_num==0)
				{
				    gui="";
				}
				
				if (terra_num==0)
				{
					ter="";
				}

				if (heineken_num==0)
				{
					hei="";
				}

		   System.out.printf("▶%s %s %s %s %s",cas,hit,gui,ter,hei);		// 위에서 각 주류들의 수를 출력
           System.out.println();
           System.out.println("--------------------------------------");
		   System.out.println("   ☞ 결제 예상 금액 : " + getPayment());		// 지금까지 주문한 금액을 출력
		   System.out.println();
		
			System.out.println("주문목록을 확인해주세요! 결제 하시겠습니까?(Y/N)");
			String ch = sc.next();
         try{
             if (ch.equals("y") || ch.equals("Y"))							// Y를 입력받으면 다음 결제 진행
             {
                pay.paysel();
             }
             else if (ch.equals("n") || ch.equals("N"))						// N을 입력받으면 주문 취소 주류메뉴로 이동
             {
				 Mainmachine mc = new Mainmachine();
	     		System.out.println("☆★☆★ 처음부터 다시 선택해주세요~!! ☆★☆★");
                cass_num = 0;
				hite_num = 0;
				guiness_num = 0;
				heineken_num = 0;
				terra_num = 0;
				mc.dispMenu();
             }
             }
             catch(Exception e)
             {
    
             }
		}
	}
		catch (Exception e)
		{

		}
		





} // end choice beer


	// 구매 내역 확인 / 영수증 출력 메소드 
	void receipt() throws Exception
	{
		Scanner sc = new Scanner (System.in);
		int a;																			//영수증 출력 여부를 입력받을 변수 선언
		System.out.println();
		System.out.println("▶ 최종 구매 내역 확인 / 영수증 출력");
		System.out.println("-----------------------------------------");
	    String cas=("Cass "+Integer.toString(cass_num));
		String hit=("Hite "+Integer.toString(hite_num));
		String gui=("Guiness "+Integer.toString(guiness_num));
		String ter=("Terra "+Integer.toString(terra_num));
		String hei=("Heineken "+Integer.toString(heineken_num));
			if (cass_num==0)
			{
			cas="";
			}
				
			if (hite_num==0)
			{
				hit="";
			}
				
			if (guiness_num==0)
			{
			    gui="";		
			}
		
			if (terra_num==0)
			{
				ter="";
			}

			if (heineken_num==0)
			{
				hei="";			
			}
		System.out.printf("▶%s   %s   %s   %s   %s",cas,hit,gui,ter,hei); 
        System.out.printf("\n☞ 최종 결제 금액 : %d\n",getPayment());
		System.out.println("-----------------------------------------");
		System.out.println("★ 영수증 출력을 원하시면 1번을 눌러주세요. ");
		System.out.print("   ☞ ");
		a = sc.nextInt();
		System.out.println();

		setPayment(0);																			//setPaymet 현재 결제금액 초기화.
		if (a==1)																				//영수증 출력을 원한다면 출력해주는 부분
			
			
			System.out.println(">>>>영수증이 출력 완료되었습니다.");

			System.out.println("▶ 주문이 완료되었습니다. 감사합니다.\n");


		
		Mainmachine mc = new Mainmachine();														//최종주문 완료 끝. 처음메뉴로 이동
		mc.dispMenu();

		

		
	}

} // end beer

