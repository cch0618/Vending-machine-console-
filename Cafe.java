import java.util.Scanner;
import java.util.Vector;


//커피 메뉴 옵션 클래스(관리자 상속, 레시피 implements)
public class Cafe extends Admin implements Recipe
{
	int n;                  //ice 또는 hot을 선택하기 위한 변수
	int t;                  //토핑 추가시 선택하기 위한 변수
	int c;                  //커피 메뉴를 선택하기 위한 변수
	int a;					//주문의 추가 여부를 선택하기 위한 변수



	static int americano_num;		//아메리카노 주문 개수
	static int icetea_num;			//아이스티 주문 개수
	static int latte_num;			//라떼 주문 개수
	static int mocha_num;			//모카 주문 개수
	static int earlgrey_num;		//얼그레이 주문 개수
	static int chocolate_num;		//초콜릿 주문 개수
	static int ice_num;			//음료가 아이스일 경우 얼음의 개수를 세기 위한 변수
	static int i=0;
	static int syrup_num;
	static int bubble_num;
	static int whip_num;
	static int shot_num;

	//가격 정보를 가지고 있는 Mprice 클래스 기반 인스턴스 생성
	Mprice m = new Mprice();

	Topping[] topping = new Topping[100];

	//Vector<Topping> v = new Vector<Topping>();
	

	//커피 메뉴 선택 메소드
	void choiceCafe() 
	{
		Scanner sc = new Scanner(System.in);

		//잘못된 번호를 선택하면 반복
		do
		{
		System.out.println();
			String a1="○";
			String r1="○";
			String m1="○";
			String e1="○";
			String c1="○";
			String i1="○";
			//빛

		//Cafe c = new Cafe();
		//아메
		if(getBean()==0 || getWater()==0 || getStockcup()==0)
		{
			a1="●";
		}
		//라떼
		if (getBean()==0 || getMilk()==0 || getStockcup()==0)
		{
			r1="●";
		}
		//모카
		if (getBean()==0 || getMilk()==0 || getChocosyrup()==0 || getStockcup()==0)
		{
			m1="●";
		}
		//얼그레이
		if (getWater()==0 || getTeabag()==0 || getStockcup()==0 )	
		{
			e1="●";
		}
		//초콜릿
		if (getMilk()==0 || getChocosyrup()==0 || getWhipping()==0 || getCocoa()==0 || getStockcup()==0)
		{
			c1="●";
		}
		//아이스티
		if (getMilk()==0 || getChocosyrup()==0 || getWhipping()==0 || getCocoa()==0 || getStockcup()==0)
		{
			i1="●";
		}
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t   쌍강교 Cafe ＆ Pub");
			System.out.println();
			System.out.printf("1.아메리카노  \t%d\t%s \t2.아이스티\t%d\t%s\n", m.americano,a1, m.icetea,i1);
			System.out.printf("3.카페라떼\t%d \t%s \t4.카페모카\t%d\t%s\n", m.latte,r1,m.mocha,m1);
			System.out.printf("5.얼그레이\t%d \t%s \t6.초콜릿\t%d\t%s\n", m.earlgrey,e1,m.chocolate,c1);
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t\t\t    (주문가능 : ○ 품절 :●)");
			System.out.println();
			System.out.println("▶ 원하시는 메뉴를 입력해주세요. ");
			System.out.print("   ☞ ");
			c = sc.nextInt();	
		}
		while (c<1 || c>6);

		//1번, 아메리카노를 선택할 경우
		if(c==1)
		{
			topping[i] = new Topping(); //토핑 클래스 기반 인스턴스 생성
			topping[i].name = "아메리카노";
			americano();				//아메리카노 메소드 호출
			dispTopping();				//토핑 메뉴 출력 메소드
			
			choiceTopping();			//토핑 추가 메소드 호출
		}
			
		//2번, 아이스티를 선택할 경우
		if(c==2)
		{
				topping[i] = new Topping();	//토핑 클래스 기반 인스턴스 생성
			topping[i].name = "아이스티";
			icetea();					//아이스티 메소드 호출
			dispTopping();				//토핑 메뉴 출력 메소드
		
			choiceTopping();   //토핑 추가 메소드 호출
			
		}
		//3번, 라떼를 선택할 경우
		if(c==3)
		{
			topping[i] = new Topping();	//토핑 클래스 기반 인스턴스 생성
			topping[i].name = "카페라떼";
			latte();					//라떼 메소드 호출
			dispTopping();				//토핑 메뉴 출력 메소드
			
			choiceTopping();   //토핑 추가 메소드 호출
	
		}
		//4번, 모카를 선택할 경우
		if(c==4)
		{
			topping[i] = new Topping();	//토핑 클래스 기반 인스턴스 생성
			topping[i].name = "카페모카";
			mocha();					//모카 메소드 호출
			dispTopping();				//토핑 메뉴 출력 메소드
		
			choiceTopping();   //토핑 추가 메소드 호출

		}
		//5번, 얼그레이 선택할 경우
		if(c==5)
		{
			topping[i] = new Topping();	//토핑 클래스 기반 인스턴스 생성
			topping[i].name = "얼그레이";
			earlgrey();					//얼그레이 메소드 호출
			dispTopping();				//토핑 메뉴 출력 메소드
			
			choiceTopping();   //토핑 추가 메소드 호출

		}
		//6번, 초콜릿 선택할 경우
		if(c==6)
		{
			topping[i] = new Topping();	//토핑 클래스 기반 인스턴스 생성
			topping[i].name = "초콜릿";
			chocolate();				//초콜릿 메소드 호출
			dispTopping();				//토핑 메뉴 출력 메소드
			
			choiceTopping();   //토핑 추가 메소드 호출

		}
		
	} //end choicCafe()


   //토핑 메뉴 출력
   void dispTopping()
   {
         //판매여부 확인을 위한 초기화 ○ -> 판매가능, ● -> 매진
		 String sh1="○";   //shot 
         String wh1="○";   //whip 
         String sy1="○";   //syrup 
         String bu1="○";   //bubble

	 //원두(샷) 매진되었을 경우
		if(getBean()==0)
            sh1="●";
		//시럽
		if(getSyrup()==0)
            sy1="●";
		//휘핑
		if(getWhipping()==0)
            wh1="●";
		//버블
		if(getBubble()==0)
            bu1="●";
	
		 System.out.println();
         System.out.println("▶ 추가할 토핑을 선택하세요.");
		 System.out.println("----------------------------");
		 System.out.println("       < 추가 옵션 > ");
		 System.out.printf("1.샷 추가  \t%d\t%s\n", m.addshot,sh1);
		 System.out.printf("2.시럽 추가\t%d \t%s\n", m.addsyrup,sy1);
		 System.out.printf("3.휘핑 추가\t%d \t%s\n", m.addwhip,wh1);
		 System.out.printf("4.버블 추가\t%d \t%s\n", m.addbub,bu1);
		 System.out.println("5.없음");
		 System.out.println("----------------------------");
	
   }


    //토핑 선택 메소드
	public void choiceTopping()
	{

		Scanner sc = new Scanner(System.in);


		//토핑 추가 여부 묻기
		System.out.println("▶ 토핑을 추가 하시겠습니까? (1) 예 (2) 아니요  ");
		System.out.print("   ☞ ");
	    t = sc.nextInt();
		System.out.println();

		//토핑을 추가한다면
		if(t==1)
		{
			//추가할 토핑 선택, 잘못된 번호 입력 시 반복
			do
			{
				System.out.println("▶ 추가하실 토핑 1~5 ? " );
				System.out.print("   ☞ ");
				t = sc.nextInt();
				System.out.println();
			}
			while (t<1 || t>5);
		 
		   //1번, 샷을 추가
		   if(t==1)
		   {
			  addShot();
			  choiceTopping();
		   }
		   //2번, 시럽 추가
		   if(t==2)
		   {
			  addSyrup();
			  choiceTopping();
		   }
		   //3번, 휘핑 추가
		   if(t==3)
		   {
			  addWhip();
			  choiceTopping();
		   }
		   //4번, 버블 추가
		   if(t==4)
		   {
			  addBubble();
			  choiceTopping();
		   }
		   //5번 추가 종료
		   if(t==5)
		   {
			   i++;    //이때 토핑 클래스기반 배열의 인덱스를 증가시켜준다. i=0이면 첫번째 잔 i=1이면 두번째 잔
		   }
			
		} //end if

		if (t==2)
		{
			i++;
		}

		
		//주문 추가 여부 묻기
		System.out.println("▶ 주문을 더 추가하시겠습니까? (1)추가 (2)결제");
		System.out.print("   ☞ ");
		a = sc.nextInt();

		//주문을 추가한다면
		if(a==1)
			choiceCafe();	//커피 선택 메뉴 메소드 호출
		//주문을 추가하지 않는다면
		try
		{
			if(a==2) 
				basket();	//장바구니 메소드 호출
		}
		catch (Exception e)
		{
		}


	}// end choiceTopping()


	//아메리카노 제조 메소드(원두 1, 물 1)
	@Override
	public void americano()
	{
		Scanner sc = new Scanner(System.in);    

		//ice hot 여부 묻기
		System.out.println();
		System.out.print("▶ (1) ice (2) hot : " );
		n = sc.nextInt();

		//만약 ice 라면
		if(n==1)
			ice_num++;			   //얼음의 개수 증가

		americano_num++;		   //아메리카노 주문 개수 증가

		setPayment(getPayment()+m.americano);
	}

	//아이스티 제조 메소드(아이스티1, 물1, 얼음1)
	@Override
	public void icetea()
	{
		
		ice_num++;				  //얼음의 개수 증가
		icetea_num++;			  //아이스티 주문 개수 증가
	
		setPayment(getPayment()+m.icetea);			  //price에 아이스티 가격 증가
	}

	//라떼 제조 메소드(원두 1, 우유2)
	@Override
	public void latte()
	{
		Scanner sc = new Scanner(System.in);

		//ice hot 여부 묻기
	    System.out.println();
		System.out.print("▶ (1) ice (2) hot : " );
		n = sc.nextInt();

		//만약 ice 라면
		if(n==1)
			ice_num++;			   //얼음의 개수 증가

		latte_num++;			   //라떼 주문 개수 증가

		setPayment(getPayment()+m.latte);			   //price에 라떼 가격 증가
	}

	//모카 제조 메소드(원두1, 초코시럽1, 우유2)
	@Override
	public void mocha()
	{
		Scanner sc = new Scanner(System.in);

try
{
	//ice hot 여부 묻기
		System.out.println();
		System.out.print("▶ (1) ice (2) hot : " );
		n = sc.nextInt();

		//만약 ice 라면
		if(n==1)
			ice_num++;			   //얼음의 개수 증가

		mocha_num++;			   //모카 주문 개수 증가

		setPayment(getPayment()+m.mocha);			   //price에 모카 가격 증가
}
catch (Exception e)
{
}
		

	}

	//얼그레이 제조 메소드(티백1, 물1)
	@Override
	public void earlgrey()
	{
		Scanner sc = new Scanner(System.in);
try
{
	//ice hot 여부 묻기
		System.out.println();
		System.out.print("▶ (1) ice (2) hot : " );
		n = sc.nextInt();

		//만약 ice 라면
		if(n==1)
			ice_num++;			   //얼음의 개수 증가

		earlgrey_num++;			   //얼그레이 주문 개수 증가

		setPayment(getPayment()+m.earlgrey);		   //price에 얼그레이 가격 증가
}
catch (Exception e)
{
}
		


	}

	//초콜릿 제조 메소드(코코아1, 우유2, 초코시럽1, 휘핑1)
	@Override
	public void chocolate()
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			//ice hot 여부 묻기
		System.out.println();
		System.out.print("▶ (1) ice (2) hot : " );
		n = sc.nextInt();

		//만약 ice 라면
		if(n==1)
			ice_num++;			   //얼음의 개수 증가

		chocolate_num++;		   //초콜릿 주문 개수 증가

		setPayment(getPayment()+m.chocolate);		   //price에 초콜릿 가격 증가
		}
		catch (Exception e)
		{
		}
		
	}

	//샷 추가 메소드
	public void addShot()
	{
		topping[i].shot++;		  //샷 추가 개수 증가
		shot_num++;
		setPayment(getPayment()+m.addshot);		  //price에 샷 추가 가격 누적		
	}

	//휘핑 추가 메소드
	public void addWhip()
	{
		topping[i].whip++;		  //휘핑 추가 개수 증가
		whip_num++;		  //price에 휘핑 추가 가격 누적
		setPayment(getPayment()+m.addwhip);			  //price에 휘핑 추가 가격 누적
	}

	//시럽 추가 메소드
	public void addSyrup()
	{
		topping[i].syrup++;		  //시럽 추가 개수 증가
		syrup_num++;
		setPayment(getPayment()+m.addsyrup);		  //price에 시럽 추가 가격 누적
	}

	//버블 추가 메소드
	public void addBubble()
	{
		topping[i].bubble++;	  //버블 추가 개수 증가
		bubble_num++;
		setPayment(getPayment()+m.addbub);		  //price에 버블 추가 가격 누적
	}

	
	
	
	void basket() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Beer be =new Beer(); //맥주 인스턴스 생성
		Pay pay = new Pay();
		

		int order = latte_num + mocha_num + chocolate_num + americano_num + earlgrey_num + icetea_num;
         
		System.out.println();
		System.out.println("▶ 주문 확인 도와드리겠습니다.");
		System.out.println("----------------------------------------------------------");
		try{
			for (int j=0; j<order; j++)
			{

				String shot ="샷 추가 : " + Integer.toString(topping[j].shot);
				String whip ="휘핑 추가 : " + Integer.toString(topping[j].whip);
				String bubble = "버블 추가 : " + Integer.toString(topping[j].bubble);
				String syrup = "시럽 추가 : " + Integer.toString(topping[j].syrup);
      
				if (topping[j].shot==0)
				{
					shot="";
				}
				
				if (topping[j].whip==0)
				{
					whip="";
				}
				
				if (topping[j].bubble==0)
				{
				     bubble="";
				}
				
				if (topping[j].syrup==0)
				{
					syrup="";
				}

		   System.out.printf("   【 %s 】\n",topping[j].name); 
           System.out.printf("   %s %s %s %s", shot, whip, syrup, bubble);
           System.out.println();
           
         }
         System.out.println("----------------------------------------------------------");
		 System.out.println("   ☞ 결제 예상 금액 : " + getPayment() );
		 System.out.println();

		}
		
		catch (Exception e)
		{
		}
			System.out.println("▶ 주문목록을 확인해주세요! 결제 하시겠습니까? (y/n)");
			System.out.print("   ☞ ");
			String ch = sc.next();
			System.out.println();

			if(ch.equals("y") || ch.equals("Y"))
				pay.paysel();
			if(ch.equals("n") || ch.equals("N"))
		   {
				Mainmachine mc = new Mainmachine();
			    System.out.println("☆★☆★ 처음부터 다시 선택해주세요~!! ☆★☆★");
						i=0;
				 setPayment(0);

				americano_num = 0;
				mocha_num = 0;
				latte_num = 0;
				icetea_num = 0;
				earlgrey_num = 0;
				chocolate_num = 0;

				syrup_num = 0;
				bubble_num = 0;
				shot_num = 0;
				whip_num = 0;
				mc.dispMenu();
		   }
	}

	void receipt() throws Exception
	{
		Mainmachine mc = new Mainmachine();
		Scanner sc = new Scanner (System.in);
		int a;
		System.out.println();
		System.out.println("▶ 최종 구매 내역 확인 / 영수증 출력");
		System.out.println("-----------------------------------------");
	    String cas=("아메리카노 "+Integer.toString(americano_num));
		String hit=("카페라떼 "+Integer.toString(latte_num));
		String gui=("카페모카 "+Integer.toString(mocha_num));
		String ter=("아이스티 "+Integer.toString(icetea_num));
		String hei=("얼그레이 "+Integer.toString(earlgrey_num));
		String cho=("초콜릿 "+Integer.toString(chocolate_num));
			if (americano_num==0)
			{
			cas="";
			}
				
			if (latte_num==0)
			{
				hit="";
			}
				
			if (mocha_num==0)
			{
			    gui="";		
			}
		
			if (icetea_num==0)
			{
				ter="";
			}

			if (earlgrey_num==0)
			{
				hei="";			
			}

			if (chocolate_num==0)
			{
				cho="";			
			}
			Pay d = new Pay();

		System.out.printf("▶%s   %s   %s   %s   %s   %s",cas,hit,gui,ter,hei,cho); 
		
		if (getPayment()>0)
		{
			System.out.printf("\n☞ 최종 결제 금액 : %d\n",getPayment());
		}

		else if(d.rescoupon<=0)
		{
			 System.out.printf("\n☞ 최종 결제 금액 : 0 원\n");
		}

		
		System.out.println("-----------------------------------------");
		System.out.println("★ 영수증 출력을 원하시면 1번을 눌러주세요. ");
		System.out.print("   ☞ ");
		a = sc.nextInt();
		System.out.println();
				
		 setPayment(0);
		 i=0;

		if (a==1)
			System.out.println(">>>>영수증이 출력 완료되었습니다.");

		System.out.println("▶ 주문이 완료되었습니다. 감사합니다.\n");
	
		

		
	}
}
