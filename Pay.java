import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;


public class Pay extends Admin
{
	static int money;					// 투입된 총 금액
	static int balance;					// 거스름 돈 = 투입 금액 - 결제 금액
	String cardNum;						// 카드 번호
	String cvc;							// cvc 번호

	static int man1;					// 10000 원 변수
	static int chun5;					// 5000 원 변수
	static int chun1;					// 1000 원 변수
	static int bak5;					// 500 원 변수
	static int bak1;					// 100 원 변수

	static int phonenum;				// 쿠폰 - 휴대폰번호
	static int ncoupon;					// 보유 쿠폰 개수
	static int rescoupon;				// 쿠폰 적용 후 금액
	String n;							// 스탬프 적립 여부를 저장
	static int stamp;					// 스탬프 적립
	
	static int sum;						// 자판기 내에 있는 총 금액

	Mprice mp = new Mprice();
	Mainmachine m = new Mainmachine();
	
	Cafe ca =new Cafe(); //카페 인스턴스 생성
	Beer be =new Beer(); //맥주 인스턴스 생성

	Scanner sc = new Scanner(System.in);

	// 결제 수단 처리 메소드
	void paysel()
	{
		int select;		// 결제 수단 선택된 번호를 저장할 변수
		try
		{
			do
				{
					
					System.out.println("▶ 결제 수단을 선택해주세요. ");
					System.out.println("-----------------------------------");
					System.out.println(" 1. 현금   2. 카드   3. 쿠폰 사용");
					System.out.println("-----------------------------------");
					System.out.print("  : ");
					select = sc.nextInt();
				}
				while (select<1 && select>3);	// 1번부터 3번을 입력하지 않은 경우 계속 반복

				if(select==1)		// 1번 입력 시 현금 메소드
					cash();
				if(select==2)		// 2번 입력 시 카드 메소드
					card();
				if(select==3)		// 3번 입력 시 쿠폰 메소드
					coupon();
			}


		catch (Exception e)
		{
		}
	}
		
	
	// 현금 결제 시 처리 메소드
	void cash()	throws Exception
	{
		String selreceipt;		// 현금영수증 여부 담을 변수


		System.out.println();
		System.out.println("▶ 현금 결제 시작하겠습니다.");


		System.out.println();
		System.out.println("▶ 넣으실 금액을 입력해주세요.\n");
		System.out.print("    10000 원 : ");
		man1 = sc.nextInt();					// 투입된 만원 담는 변수에 저장
		System.out.print("     5000 원 : ");
		chun5 = sc.nextInt();					// 투입된 오천원 담는 변수에 저장
		System.out.print("     1000 원 : ");
		chun1 = sc.nextInt();					// 투입된 천원 담는 변수에 저장
		System.out.print("      500 원 : ");
		bak5 = sc.nextInt();					// 투입된 오백원 담는 변수에 저장
		System.out.print("      100 원 : ");
		bak1 = sc.nextInt();					// 투입된 백원 담는 변수에 저장

			
		// 투입된 화폐 단위 당 금액 계산을 위한 변수에 저장
		int M1=man1*10000;
		int C5=chun5*5000;
		int C1=chun1*1000;
		int B5=bak5*500;
		int B1=bak1*100;


		money = M1+C5+C1+B5+B1;			// 투입된 총 금액

        
		balance=money-getPayment();		// 거스름돈 = 투입금액 - 결제금액
		int balance2=balance;			// 현재 거스름돈을 새로운 변수에 저장

		balance();						// 거스름돈 메소드 호출

		System.out.println();
		System.out.println("▶ 투입하신 금액을 확인해주세요.\n");
		System.out.printf("   ☞ %d 원을 투입하셨습니다.\n", money);
		System.out.printf("   ☞ 거스름돈 금액 : %d\n\n", balance2);

		System.out.print("▶ 현금 영수증 하시겠습니까? (Y/N) : ");
		selreceipt = sc.next();			// 현금 영수증 여부
		

		// y 또는 Y를 눌렀을 경우 현금영수증 처리 → 스탬프 처리 메소드
		if (selreceipt.equals("Y") || selreceipt.equals("y"))
		{
			System.out.print("▶ 휴대폰 번호를 입력해주세요.(- 제외) : ");
			String phone = sc.next();
			System.out.println("※ 현금 영수증 처리 되었습니다. ※");
			stamp();
		}
		// 그렇지 않으면 스탬프 처리 메소드 수행
		else
			stamp();

		// 모두 수행하고 나면 메뉴 화면 출력
		m.dispMenu();
	}

	// 카드 결제 시 처리 메소드
	void card()	throws Exception
	{
		// 현재 디렉토리 위치를 appDir 에 저장
		String appDir = System.getProperty("user.dir");

		// appDir 위치에 fcard.txt 파일 생성
		File fcard = new File(appDir, "\\card\\fcard.txt");
		
		// 파일이 존재하지 않는다면
		if(!fcard.getParentFile().exists())
			fcard.getParentFile().mkdirs();		// 디렉토리 생성

		// Hashtable 사용하여 카드번호(key)와 카드cvc번호(value) 담기 위한 변수 선언
		Hashtable<String, String> h1 = new Hashtable<String, String>();

		h1.put("12345678", "1234");		// 카드번호와 cvc번호를 미리 입력하여 h1 에 넣어놓음
		h1.put("78945612", "7894");

		// 파일 쓰기
		FileOutputStream fos = new FileOutputStream(fcard);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(h1);
		oos.close();
		fos.close();

		System.out.println();
		System.out.println("▶ 카드 결제 시작하겠습니다.");

		//카드 번호 입력받기
		System.out.println();
		System.out.println("▶ 카드 번호를 입력해주세요. ");
		System.out.print(" ☞ ");
		cardNum = sc.next();

		//cvc 번호 입력받기
		System.out.println();
		System.out.println("▶ CVC번호를 입력해주세요 (4자리)");
		System.out.print(" ☞ ");
		cvc = sc.next();
		System.out.println();

		// 생성된 파일 존재하면
		if (fcard.exists())	
		{
			FileInputStream fis = new FileInputStream(fcard);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Hashtable h2 = (Hashtable)ois.readObject();

			fis.close();
			ois.close();

			String key;
			String value;

			Enumeration e = h1.keys();

			//읽어온 파일 출력
			while (e.hasMoreElements())
			{
				key = (String)e.nextElement();

				value = (String)h1.get(key);

				//파일에 저장된 카드번호와 cvc번호가 일치하면
				if(key.equals(cardNum) && value.equals(cvc))
				{
					//메시지 출력
					System.out.println("=====카드 인증 성공 ~!!!=====");
					System.out.println("▶ 결제가 완료 되었습니다.\n");
					System.out.println("▶ 스탬프 적립 화면으로 이동합니다.\n");
					//stamp 메소드 호출
					stamp();
				}

				//카드번호나 cvc번호가 틀리다면
				else if(!key.equals(cardNum) || !value.equals(cvc) && e.hasMoreElements()==false)
				{
					System.out.println("▶ 사용하실 수 없는 카드입니다.");
					System.out.println("   결제 수단을 다시 선택해주세요.\n");
					//결제 메소드 호출하여 다시 결제 수단 선택
					paysel();
				}
			}
		}

		//메뉴판 메소드 호출
		m.dispMenu();
	}

	// 쿠폰 사용 결제 시 처리 메소드
	void coupon() throws Exception
	{
	
		ncoupon=1;
		System.out.println();
		System.out.println("▶ 쿠폰 사용 결제 시작하겠습니다.");

		//휴대폰 번호 입력받기
		System.out.println();
		System.out.println("▶ 휴대폰 번호를 입력해주세요.");
		System.out.print(" ☞ ");
		phonenum = sc.nextInt();

		//사용자가 보유한 쿠폰 매수 출력
		System.out.println();
		System.out.printf("▶ 현재 보유하신 쿠폰 매수는 %d매 입니다.", ncoupon);
			
		if (ncoupon == 0)		// 보유한 쿠폰이 하나도 없을 경우
		{
			System.out.println();
			System.out.println("▶ 사용하실 수 있는 쿠폰이 존재하지 않습니다. ");
			System.out.println("   처음부터 다시 결제 해주세요.");

			//결제 메소드를 호출하여 다시 결제수단 선택
			paysel();
		}
		else if(ncoupon >= 1)	// 쿠폰이 1장 이상일 경우
		{
			
			rescoupon = getPayment()- 3000;		// 쿠폰 사용 후 금액 = 결제 금액 - 3000
			setPayment(rescoupon);

			ncoupon--;							// 보유한 쿠폰 1 감소

			System.out.println();

			if (rescoupon <= 0)					// 쿠폰 사용 후 금액이 0 , 0보다 작은 경우
			{
				System.out.print("▶ 쿠폰 적용 후 금액은 0 원 입니다.");		// 무조건 쿠폰 사용 후 금액 0 원 출력
				System.out.printf("   현재 남은 쿠폰은 %d 매 입니다.", ncoupon);
				System.out.println();
			}

			else if (rescoupon > 0)				// 쿠폰 사용 후 금액이 0보다 큰 경우
			{
				System.out.printf("▶ 쿠폰 적용 후 금액은 %d 원 입니다.", rescoupon);
				System.out.printf("   현재 남은 쿠폰은 %d 매 입니다.", ncoupon);
				System.out.println();

				System.out.println("▶ 추가 결제 금액이 남아있습니다.");
				System.out.println("   추가 결제 페이지로 이동합니다.");

				//결제 메소드 호출(추가 금액)
				paysel();
			}
 
			//결제 후 stamp메소드 호출
			stamp();
		}
	}

	// 거스름돈 처리 메소드
	void balance()  throws Exception
	{
		Beer br = new Beer();		// Beer 클래스 인스턴스 생성
		Cafe cf = new Cafe();		// Cafe 클래스 인스턴스 생성

		//System.out.println("거스름돈 처리 메소드 시작");
		
		
		int g1=getmanWon()*10000;	// 자판기에 있는 만원 매수 가져와서 g1 에 담음
		int g2=getchunWon5()*5000;	// 자판기에 있는 오천원 매수 가져와서 g2 에 담음
		int g3=getchunWon1()*1000;	// 자판기에 있는 천원 매수 가져와서 g3 에 담음
		int g4=getbakWon5()*500;	// 자판기에 있는 오백원 개수 가져와서 g4 에 담음
		int g5=getbakWon1()*100;	// 자판기에 있는 백원 개수 가져와서 g5 에 담음

		sum = g1 + g2 + g3 + g4 + g5;	// 자판기 내에 있는 총 금액
	
        int cbalance = balance;			// cbalance 변수에 현재 거스름돈 저장

		chun5 = balance / 5000;			// 현재 거스름돈에서 거슬러 줘야할 5000원 매수 저장

		balance -= (chun5 * 5000);		// 현재 거스름돈에서 5000원 매수에 따른 금액만큼 빼줌

		chun1 = balance / 1000;			// 계산된 거스름돈에서 거슬러 줘야할 1000원 매수 저장

		balance -= (chun1 * 1000);		// 거스름돈에서 1000원 매수에 따른 금액만큼 빼줌

		bak5 = balance / 500;			// 계산된 거스름돈에서 거슬러 줘야할 500원 개수 저장

		balance -= (bak5 * 500);		// 거스름돈에서 500원 개수에 따른 금액만큼 빼줌

		bak1 = balance / 100;			// 계산된 거스름돈에서 거슬러 줘야할 100원 개수 저장

		balance -= (bak1  * 100);		// 거스름돈에서 100원 개수에 따른 금액만큼 빼줌

	
			

		// 카페 거스름돈 계산
		if(sum < cbalance)	// (기계에 남은 금액보다 장바구니 금액이 큰 경우 반환 X) 
		{
			System.out.println();
			System.out.println("☞ 반환 가능한 화폐가 남아있지 않습니다.");
			System.out.println("   다른 결제 수단을 이용해주세요. ");
			paysel();
		}

		if(getPayment() < money) // (기계에 화폐가 충분한경우)
		{
			// (모든 화폐 반환 가능) 자판기 내에 있는 화폐 단위 당 매수가 거슬러 줘야할 화폐 매수보다 클 경우
			if(getchunWon5()>=chun5 && getchunWon1()>=chun1 && getbakWon5()>=bak5 && getbakWon1()>=bak1)
			{
				System.out.println();
				System.out.println("▶ 반환 가능한 화폐가 남아있습니다.");
				// 반환될 화폐 매수 출력
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");

				// 자판기 내에 화폐 매수에서 거슬러 줘야 할 매수를 빼준 값으로 set
				if(getchunWon5() > 0)
					setchunWon5(getchunWon5()-chun5);
				if(getchunWon1() > 0)
					setchunWon1(getchunWon1()-chun1);
				if(getbakWon5() > 0)
					setbakWon5(getbakWon5()-bak5);
				if(getbakWon1() > 0)
					setbakWon1(getbakWon1()-bak1);
			}
			// 현재 자판기에 5천원이 부족한 경우
			else if(getchunWon5()<chun5)
			{
				chun1 += (chun5 * 5);	// 거슬러 줄 5천원 매수를 모두 천원으로 바꿔줌.
				chun5 = 0;				// 거슬러 줄 5천원 0개로 만들어줌
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");
				setchunWon5(getchunWon5()-chun5);
				setchunWon1(getchunWon1()-chun1);
				setbakWon5(getbakWon5()-bak5);
				setbakWon1(getbakWon1()-bak1);
			}
			// 현재 자판기에 1천원이 부족한 경우
			else if(getchunWon1()<chun1)
			{
				bak5 += (chun1 * 2);	// 거슬러 줄 천원 매수를 모두 오백원으로 바꿔줌.
				chun1 = 0;				// 거슬러 줄 천원 0개로
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");

				// 자판기 내에 화폐 매수에서 거슬러 줘야 할 매수를 빼준 값으로 set
				setchunWon5(getchunWon5()-chun5);
				setchunWon1(getchunWon1()-chun1);
				setbakWon5(getbakWon5()-bak5);
				setbakWon1(getbakWon1()-bak1);
			}
			// 현재 자판기에 5백원이 부족한 경우
			else if(getbakWon5()<bak5)
			{
				bak1 += (bak5 * 5);		// 거슬러 줄 5백원 개수를 모두 백원으로 바꿔줌
				bak5 = 0;				// 거슬러 줄 오백원 0개로
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");

				// 자판기 내에 화폐 매수에서 거슬러 줘야 할 매수를 빼준 값으로 set
				setchunWon5(getchunWon5()-chun5);
				setchunWon1(getchunWon1()-chun1);
				setbakWon5(getbakWon5()-bak5);
				setbakWon1(getbakWon1()-bak1);
			}
			// 현재 자판기에 어떤 화폐도 존재하지 않는 경우
			else
			{
				System.out.println(" ☞ 반환 가능한 화폐가 남아있지 않습니다.");
				System.out.println("    다른 결제 수단을 선택해주세요.");
				// 반환 불가 표시 후 다른 수단 선택
				paysel();
			}
		}
		else
		{
			System.out.println(" ☞ 투입금액이 모자랍니다.");
			System.out.println("    다른 결제 수단을 선택해주세요.");
			paysel();
		}
	}


	// 스탬프 적립 처리 메소드
	void stamp() throws Exception
	{
		//HashMap 클래스 기반 인스턴스 생성
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		System.out.println();
		System.out.print("▶ 스탬프를 적립하시겠습니까? (Y/N) : " );
		n = sc.next();
		System.out.println();


		//스탬프를 적립할 경우
		if(n.equals("y") || n.equals("Y"))
		{
			System.out.println("▶ 스탬프 적립을 도와드리겠습니다.");

			System.out.print("고객님의 휴대폰 번호를 입력해주세요." );
			phonenum = sc.nextInt();

			//잔마다 stamp 증가
			stamp++;

			
			//만약 stamp가 10장단위로 모이면 쿠폰 개수 증가
			if(stamp%10 == 0)
			{
				ncoupon+=(stamp/10);
				stamp=0;
			}
		}

			//HashMap에 휴대폰 번호를 key값, 스탬프를 value값으로 삽입
			map.put(phonenum, stamp);
			
			//스탬프 적립 현황 출력
			System.out.println();
			System.out.println("▶ 스탬프 적립이 완료되었습니다.");
			System.out.println("---------------------------------------");
			System.out.println("	현재 보유 스탬프 및 쿠폰 확인");
			System.out.printf("		→ 스탬프 : %d / 3\n" , stamp);
			System.out.printf("		→ 쿠폰 : %d 매\n", ncoupon);
			System.out.println("---------------------------------------");

			//사용자가 맥주를 시켰을 경우
            if (ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num==0)
            {
					//맥주 영수증 메소드 호출
					be.receipt();
					//basekt_yes(재고 감소)메소드 호출
					basket_yes();
            }
			//사용자가 커피를 시켰을 경우
			else
			{
					//카페 영수증 메소드 호출
					ca.receipt();
					//basket_yes(재고 감소)메소드 호출
					basket_yes();
			}	
			

		//스탬프를 적립하지 않을 경우
		if(n.equals("n") ||  n.equals("N"))
		{
		
			//사용자가 맥주를 시켰을 경우
			if (ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num==0)
			{
				be.receipt();
				basket_yes();
				m.dispMenu();
			}
			//사용자가 커피를 시켰을 경우
			else 
			{
				ca.receipt();
				basket_yes();
				m.dispMenu();
			}
		}

	} // end stamp()

	//장바구니 재고 감소 메소드
	void basket_yes()	
	{
		//Mainmachine클래스 기반 인스턴스 생성
		Mainmachine mc = new Mainmachine();
		//Mprice클래스 기반 인스턴스 생성
		Mprice m = new Mprice();
		
		
		//장바구니에 담겨있는 주문개수
		int order= ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num
			+ be.cass_num + be.hite_num + be.terra_num + be.heineken_num + be.guiness_num;


		 //원래 재료의 양에서 쓰이는 재료양을 빼준후에(음료 종류마다) 다시 재료량 세팅

		 if(getMilk() > 0)
			setMilk(getMilk()-ca.latte_num*2-ca.mocha_num*2-ca.chocolate_num*2);
		 if(getWater() > 0)
			setWater(getWater()-ca.icetea_num*1-ca.americano_num*1-ca.earlgrey_num*1);
		 if(getChocosyrup() > 0)
			setChocosyrup(getChocosyrup()-ca.chocolate_num*1-ca.mocha_num*1);	
		 if(getIce() > 0)
			setIce(getIce()-ca.icetea_num*1-ca.ice_num);
		 if(getTeabag() > 0)
			setTeabag(getTeabag()-ca.earlgrey_num*1);
		 if(getIcetea() > 0)
			setIcetea(getIcetea()-ca.icetea_num*1);
		 if(getCocoa() > 0)
			setCocoa(getCocoa()-ca.chocolate_num*1);
		 if(getBean() > 0)
			setBean(getBean()-ca.americano_num-ca.latte_num-ca.mocha_num-ca.shot_num);


		 //토핑
		 if(getSyrup() > 0)
			setSyrup(getSyrup() - ca.syrup_num);
		 if(getBubble() > 0)
			setBubble(getBubble() - ca.bubble_num);
		 if(getWhipping() > 0)
			setWhipping(getWhipping() - ca.whip_num);


		 //맥주
		 if(getCass() > 0)
			setCass(getCass()-be.cass_num);
		 if(getHite() > 0)
			setHite(getHite()-be.hite_num);
		 if(getTerra() > 0)
			setTerra(getTerra()-be.terra_num);
		 if(getHeineken() > 0)
			setHeineken(getHeineken()-be.heineken_num);
		 if(getGuiness() > 0)
			setGuiness(getGuiness()-be.guiness_num);

		 //컵
		 if(getStockcup() > 0)
			setStockCup(getStockcup()- ca.latte_num - ca.mocha_num - ca.chocolate_num - ca.americano_num - ca.earlgrey_num - ca.icetea_num);


		 //맥주 판매 수량
		 setCassSale(getCassSale()+be.cass_num);	 
		 setHiteSale(getHiteSale()+be.hite_num);
		 setTerraSale(getTerraSale()+be.terra_num);
		 setHeinekenSale(getHeinekenSale()+be.heineken_num);
		 setGuinessSale(getCassSale()+be.guiness_num);

		 //커피 판매 수량
		 setAmericanoSale(getAmericanoSale() + ca.americano_num);
		 setIceteaSale(getIceteaSale() + ca.icetea_num);
		 setLatteSale(getLatteSale() + ca.latte_num);
		 setMochaSale(getMochaSale() + ca.mocha_num);
		 setEarlgreySale(getEarlgreySale() + ca.earlgrey_num);
		 setChocolateSale(getChocolateSale() + ca.chocolate_num);


		 //커피 총 매출
		 setTot(getTot()+m.americano*ca.americano_num);	   
		 setTot(getTot()+m.icetea);							
		 setTot(getTot()+m.latte*ca.latte_num);			  	
		 setTot(getTot()+m.mocha*ca.mocha_num);			   
		 setTot(getTot()+m.earlgrey*ca.earlgrey_num);		   
		 setTot(getTot()+m.chocolate*ca.chocolate_num);		  
		
		 //토핑 총 매출
		 setTot(getTot()+m.addshot*ca.shot_num);		  	
		 setTot(getTot()+m.addwhip*ca.whip_num);	
		 setTot(getTot()+m.addsyrup*ca.syrup_num);
		 setTot(getTot()+m.addbub*ca.bubble_num);

		 //맥주 총 매출
		 setTot(getTot()+m.terra*be.terra_num);
	     setTot(getTot()+m.heineken*be.heineken_num);
		 setTot(getTot()+m.guiness*be.guiness_num);	 
		 setTot(getTot()+m.hite*be.hite_num);
		 setTot(getTot()+m.cass*be.cass_num);


		 //한명의 고객이 주문 완료 후 메뉴 개수 초기화
		 ca.americano_num = 0;
		 ca.mocha_num = 0;
		 ca.latte_num = 0;
		 ca.icetea_num = 0;
		 ca.earlgrey_num = 0;
		 ca.chocolate_num = 0;

		 ca.syrup_num = 0;
		 ca.bubble_num = 0;
		 ca.shot_num = 0;
		 ca.whip_num = 0;

		 be.cass_num = 0;
		 be.hite_num = 0;
		 be.terra_num = 0;
		 be.heineken_num = 0;
		 be.guiness_num = 0;

		//배열의 인덱스와 가격 초기화
		ca.i=0;
		setPayment(0);

		//메뉴판 메소드 호출
		mc.dispMenu();

	}
	
	//장바구니 취소 메소드
	void basket_no()  
	{		
			
		 //Mainmachine 클래스 기반 인스턴스 생성
		 Mainmachine m = new Mainmachine();
		
     	 //원래 재료의 양에서 쓰이는 재료양을 더해준 후에(음료 종류마다) 다시 재료량 세팅
		 //재료의 최대 양이 100이므로 100이 넘으면 실행 안함
		 if(getMilk() < 100)
			setMilk(getMilk()+ca.latte_num*2+ca.mocha_num*2+ca.chocolate_num*2);
		 if(getBubble() < 100)
			setBubble(getBubble()+ca.bubble_num);
		 if(getWater() < 100)
			setWater(getWater()+ca.icetea_num*1+ca.americano_num*1+ca.earlgrey_num*1);
		 if(getChocosyrup() < 100)
			setChocosyrup(getChocosyrup()+ca.chocolate_num*1+ca.mocha_num*1);
		 if(getSyrup() < 100)
			setSyrup(getSyrup()+ca.syrup_num);
		 if(getIce() < 100)
			setIce(getIce()+ca.icetea_num*1+ca.ice_num);
		 if(getTeabag() < 100)
			setTeabag(getTeabag()+ca.earlgrey_num*1);
		 if(getIcetea() < 100)
			setIcetea(getIcetea()+ca.icetea_num*1);
		 if(getCocoa() < 100)
			setCocoa(getCocoa()+ca.chocolate_num*1);
		 if(getWhipping() < 100)
			setWhipping(getWhipping()+ca.chocolate_num*1+ca.whip_num);
		 if(getCass() < 100)
			setCass(getCass()+be.cass_num);
		 if(getHite() < 100)
			setHite(getHite()+be.hite_num);
		 if(getTerra() < 100)
			setTerra(getTerra()+be.terra_num);
		 if(getHeineken() < 100)
			setHeineken(getHeineken()+be.heineken_num);
		 if(getGuiness() < 100)
			setGuiness(getGuiness()+be.guiness_num);
		 if(getStockcup() < 100)
			setStockCup(getStockcup()+ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num);
		 if(getBean() < 100)
			setBean(getBean()+ca.americano_num*1+ca.latte_num*1+ca.mocha_num*1);


		 //배열의 인덱스와 가격 초기화
		 ca.i=0;
		 setPayment(0);

		 //메뉴판 메소드 호출
		 m.dispMenu();


	}
}