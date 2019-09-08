import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;



class Adult extends Admin
{
 
   Scanner sc=new Scanner (System.in);
	
    

	public void injeung()
	{
	  Mainmachine c=new Mainmachine();
	  String a;
	  String b;
	  int d;
	  //랜덤 인증번호 변수
	  final char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
                                            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
                                            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	  Random random = new Random();	
	  int tablelength = characterTable.length;
      StringBuffer buf = new StringBuffer();

	  for(int i = 0; i < certCharLength(); i++) 
	  {
        buf.append(characterTable[random.nextInt(tablelength)]);//문자열 끝에 characterTable 문자열들을 추가해서 반환.
      
       }
       a= buf.toString();	//저장된 buf값을 a에 넣기.

	  System.out.println("(랜덤 인증번호) : "+ a);	
	  System.out.println();
	  System.out.println("휴대폰으로 인증번호를 보냈습니다 화면에 입력해주세요.(2회 남음)" );
	  System.out.print("인증번호 : ");
	  b=sc.next();

	  if(a.equals(b))	//랜덤발생한 인증번호가 사용자가 입력한 인증번호와 일치하면
		{
		
			System.out.print("인증번호가 인증되었습니다 ~!! ");	//안내메세지 출력

		}
		else{
			//do-while 반복문
			do	
			{	
				System.out.println();
				System.out.println("인증번호가 옳바르지 않습니다. 옳바른 인증번호를 입력해주세요.(1회 남음)");
				System.out.print("인증번호 : ");
				b=sc.next();

				if (!b.equals(a))	//1회남았을때 입력한 인증번호가 랜덤인증번호와 일치하지 않으면
				{
					System.out.println();
					System.out.println("마지막 기회입니다. 옳바른 인증번호를 입력해주세요(0회 남음)");
					System.out.print("인증번호 : ");
					b=sc.next();

					if (b.equals(a))//인증번호가 일치하면 계속진행
					{
					}
					else			//일치하지 않으면
					{
						System.out.println();
						System.out.println("처음부터 다시 시작해주세요~!");
						c.dispMenu();//메뉴로 
					}

				}
					
				
			}
			while (!b.equals(a));	//인증번호 일치하지 않으면 반복

		}


	}


     public void jumin() //throws Exception
   {
     String name;
   
     String jumin;               //주민등록번호
     String phone;               //핸드폰 번호
	 int frontone;				 //주민번호 앞자리중 첫번째자리
	 int fronttwo;				 //주민번호 앞 자리중 두 번째 자리
	 int backnumber;			 //2000년생 이후 뒷자리가 3,4구별해주는 변수
	 
	 Mainmachine br = new Mainmachine();		// 메인 인스턴스 생성

     // 주민등록번호 유효성 검사에 필요한 변수들
      int sum=0;
      int[] num = {2,3,4,5,6,7,0,8,9,2,3,4,5};
      int namuji;
	 // int n,a;   


      try
      {
		 System.out.println("------------------------------------------------------------");
		 System.out.println("  성인인증이 필요합니다. 소중한 고객님의 정보를 입력해주세요.\n");
	     System.out.print("▶ 성함을 입력하세요 : ");
	     name=sc.next();
	     System.out.print("▶ 핸드폰 번호를 입력하세요 : ");
	     phone=sc.next();

	     System.out.print("▶ 주민등록 번호를 입력하세요 : ");
	     jumin=sc.next();
		 System.out.println("------------------------------------------------------------");



		 frontone=Integer.parseInt(jumin.substring(0,1));			// ex) 입력받은 주민번호의 1번째 자리를 int형으로 변환 후 저장
		 fronttwo=Integer.parseInt(jumin.substring(1,2));			// ex) 입력받은 주민번호의 2번째 자리를 int형으로 변환 후 저장

		 

		 backnumber=Integer.parseInt(jumin.substring(7,8));		// ex) 2000년생 이후 출생자중 뒷자리가 3과 4인사람 구별 하기 위해 저장 

	 
	 	if((frontone==0 && fronttwo==0) && (backnumber==3 || backnumber==4) )	//2000년생이면서 뒷자리가 3는 4인사람
		{
			System.out.print("성인인증 되었습니다~!");							//즉 만19세면 통과
			

		}
		
		if((frontone==0 && fronttwo>=1) && (backnumber==1 || backnumber==2))	//1901년생은 통과
		  {
			System.out.print("성인인증 되었습니다 ~!");
			
			injeung();
		  }

		
		if((frontone==0 && fronttwo>=1) && (backnumber==3 || backnumber==4))	//이후 01년생이후 출생자 이면서 뒷자리가 3또는4인사람 = 미성년자
		  {
			System.out.print("미성년자입니다. 112에 신고접수되었습니다~!!^^");
			br.dispMenu();														//메인으로 이동
		  }

		
          		  
		if((frontone==1 && fronttwo>=0) && (backnumber==3 || backnumber==4))	//2010년생 이후 출신자를 미성년자
		  {
			System.out.print("미성년자입니다. 112에 신고접수되었습니다~!!^^");
			br.dispMenu();
		  }
		  
		if((frontone==2 && fronttwo>=0) && (backnumber==3 || backnumber==4))    //2020년생 이후 출신자를 미성년자
		  {
			System.out.print("미성년자입니다. 112에 신고접수되었습니다~!!^^");
			br.dispMenu();
		  }
   
      
      if(jumin.length()!=14)													//입력받은 주민번호가 14자리가 아닐 경우 오류 ( - 포함 )
        {

         System.out.println("입력 오류 ~!!!, 자릿수를 확인하세요~!");
		 br.dispMenu();
	
		}
      
	  
																				//입력한 주민번호 * num 배열하는 부분 주민번호 유효성 검사하는부분
      for(int i=0; i<num.length;i++)
      {
         if(i==6)																//-가 문자열이기 때문에 -가 나오면 무시하고 계속 진행
            continue;
         sum += num[i] * Integer.parseInt(jumin.substring(i,i+1));
      }   

				


      namuji = (11-sum%11)%10;													//나머지에 주민등록 유효성 검사 수식
      
      if(namuji==Integer.parseInt(jumin.substring(13)))							//성인인증이 완료되면 다음 메뉴로
		  {
         System.out.println(">>성인인증 완료~!!!");
		
		  }
	  else
		  {
		  System.out.println("유효하지 않은 주민번호입니다.!");
		  br.dispMenu();
		  }

		

		
      }
      catch (Exception e)														//올바른 문자열이 입력되지 않으면 출력
      {
        System.out.println("올바른 문자를 입력해주세요 ! ");
		br.dispMenu();
      }


   }

}