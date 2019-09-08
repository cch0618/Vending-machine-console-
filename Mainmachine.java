import java.util.Scanner;
public class Mainmachine extends Admin
{
	static int b=10000;		    //startTime을 찍기위한 변수를 10000으로 선언
	Adult au = new Adult();		//Adult클래스 기반 인스턴스 생성

	//메뉴출력 메소드
	public void dispMenu()     
	{
		Mprice m = new Mprice();	//Mprice클래스 기반 인스턴스 생성
		Cafe ca = new Cafe();		//Cafe클래스 기반 인스턴스 생성
		Beer be = new Beer();		//Beer클래스 기반 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		int n;						//카테고리 선택 변수 1.카페 2.맥주 3.관리자

		//모든 재고가 차있는걸로 초기화 
		String a1="○";				
		String r1="○";
		String m1="○";
		String e1="○";
		String c1="○";
		String i1="○";
		String ca1="○";
		String h1="○";
		String t1="○";
		String hi1="○";
		String g1="○";

	
		//아메
		if(getBean()==0 || getWater()==0 || getStockcup()==0)		//메뉴 재고가 떨어졌을시, 불빛이 들어옴
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
		if (getWater()==0 || getIcetea()==0 || getStockcup()==0 || getIce()==0)
		{
			i1="●";
		}
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
		
		//메뉴 출력(메뉴와 재고 품절여부 알려줌)
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t   쌍강교 Cafe ＆ Pub");
		System.out.println();
		System.out.printf("1.아메리카노  \t%d\t%s \t1.카스\t\t%d\t%s\n", m.americano,a1,m.cass,ca1);
		System.out.printf("2.아이스티\t%d \t%s \t2.하이트\t%d\t%s\n", m.icetea,i1,m.hite,h1);
		System.out.printf("3.카페라떼\t%d \t%s \t3.테라\t\t%d\t%s\n", m.latte,r1,m.terra,t1);
		System.out.printf("4.카페모카\t%d \t%s \t4.기네스\t%d\t%s\n", m.mocha,m1,m.guiness,g1);
		System.out.printf("5.얼그레이\t%d \t%s \t5.하이네켄\t%d\t%s\n", m.earlgrey,e1,m.heineken,hi1);
		System.out.printf("6.초콜릿\t%d\t%s\n", m.chocolate,c1);
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t\t\t    (주문가능 : ○ 품절 :●)");
		System.out.println();
		System.out.print("▶ 원하시는 서비스를 선택해주세요 1.커피 2.맥주 3.관리자 : "  );
		n=sc.nextInt();

		if(b==10000)   //b가 10000이 되면
		{
		reboot2();	   //startTime을 찍는다
		b--;		   //10000에서 1씩 감소
		}	
		
	
		switch(n)	//카테고리 선택
		{
			case 1:		//1번 누르면
			{
				ca.choiceCafe(); break;	//카페메뉴로 들어가기
			}
			
			case 2:      //2번 누르면
			{
				au.jumin();				//휴대폰 인증검사후
				au.injeung();			//성인인증 검사

				be.choiceBeer();		//맥주메뉴로 들어가기
				break;
			}

			case 3:		//3번 누르면
			{

				System.out.print("관리자 비밀번호를 입력해주세요 : "); 
				int pass = sc.nextInt(); // 비밀번호 입력

				if (pass==getownerPass()) //관리자 비밀번호와 내가 입력한 번호가 같으면
				{
					disp();		//관리자 모드로 
			    }
				
				else
				{
					System.out.println("비밀번호가 틀렸습니다"); //비밀번호가 틀리다면
					dispMenu();	//메뉴출력 메소드 호출
				}
				   break;
			}
			
		} //end switch

	} //end dispMenu

	public static void main(String []args)  throws Exception
	{ 
		Mainmachine mc = new Mainmachine(); //Mainmachine클래스 기반 인스턴스 생성
		do
		{
			mc.dispMenu();		//메뉴출력 메소드호출
		}
		while (true);
	}
}