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
	  //���� ������ȣ ����
	  final char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
                                            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
                                            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	  Random random = new Random();	
	  int tablelength = characterTable.length;
      StringBuffer buf = new StringBuffer();

	  for(int i = 0; i < certCharLength(); i++) 
	  {
        buf.append(characterTable[random.nextInt(tablelength)]);//���ڿ� ���� characterTable ���ڿ����� �߰��ؼ� ��ȯ.
      
       }
       a= buf.toString();	//����� buf���� a�� �ֱ�.

	  System.out.println("(���� ������ȣ) : "+ a);	
	  System.out.println();
	  System.out.println("�޴������� ������ȣ�� ���½��ϴ� ȭ�鿡 �Է����ּ���.(2ȸ ����)" );
	  System.out.print("������ȣ : ");
	  b=sc.next();

	  if(a.equals(b))	//�����߻��� ������ȣ�� ����ڰ� �Է��� ������ȣ�� ��ġ�ϸ�
		{
		
			System.out.print("������ȣ�� �����Ǿ����ϴ� ~!! ");	//�ȳ��޼��� ���

		}
		else{
			//do-while �ݺ���
			do	
			{	
				System.out.println();
				System.out.println("������ȣ�� �ǹٸ��� �ʽ��ϴ�. �ǹٸ� ������ȣ�� �Է����ּ���.(1ȸ ����)");
				System.out.print("������ȣ : ");
				b=sc.next();

				if (!b.equals(a))	//1ȸ�������� �Է��� ������ȣ�� ����������ȣ�� ��ġ���� ������
				{
					System.out.println();
					System.out.println("������ ��ȸ�Դϴ�. �ǹٸ� ������ȣ�� �Է����ּ���(0ȸ ����)");
					System.out.print("������ȣ : ");
					b=sc.next();

					if (b.equals(a))//������ȣ�� ��ġ�ϸ� �������
					{
					}
					else			//��ġ���� ������
					{
						System.out.println();
						System.out.println("ó������ �ٽ� �������ּ���~!");
						c.dispMenu();//�޴��� 
					}

				}
					
				
			}
			while (!b.equals(a));	//������ȣ ��ġ���� ������ �ݺ�

		}


	}


     public void jumin() //throws Exception
   {
     String name;
   
     String jumin;               //�ֹε�Ϲ�ȣ
     String phone;               //�ڵ��� ��ȣ
	 int frontone;				 //�ֹι�ȣ ���ڸ��� ù��°�ڸ�
	 int fronttwo;				 //�ֹι�ȣ �� �ڸ��� �� ��° �ڸ�
	 int backnumber;			 //2000��� ���� ���ڸ��� 3,4�������ִ� ����
	 
	 Mainmachine br = new Mainmachine();		// ���� �ν��Ͻ� ����

     // �ֹε�Ϲ�ȣ ��ȿ�� �˻翡 �ʿ��� ������
      int sum=0;
      int[] num = {2,3,4,5,6,7,0,8,9,2,3,4,5};
      int namuji;
	 // int n,a;   


      try
      {
		 System.out.println("------------------------------------------------------------");
		 System.out.println("  ���������� �ʿ��մϴ�. ������ ������ ������ �Է����ּ���.\n");
	     System.out.print("�� ������ �Է��ϼ��� : ");
	     name=sc.next();
	     System.out.print("�� �ڵ��� ��ȣ�� �Է��ϼ��� : ");
	     phone=sc.next();

	     System.out.print("�� �ֹε�� ��ȣ�� �Է��ϼ��� : ");
	     jumin=sc.next();
		 System.out.println("------------------------------------------------------------");



		 frontone=Integer.parseInt(jumin.substring(0,1));			// ex) �Է¹��� �ֹι�ȣ�� 1��° �ڸ��� int������ ��ȯ �� ����
		 fronttwo=Integer.parseInt(jumin.substring(1,2));			// ex) �Է¹��� �ֹι�ȣ�� 2��° �ڸ��� int������ ��ȯ �� ����

		 

		 backnumber=Integer.parseInt(jumin.substring(7,8));		// ex) 2000��� ���� ������� ���ڸ��� 3�� 4�λ�� ���� �ϱ� ���� ���� 

	 
	 	if((frontone==0 && fronttwo==0) && (backnumber==3 || backnumber==4) )	//2000����̸鼭 ���ڸ��� 3�� 4�λ��
		{
			System.out.print("�������� �Ǿ����ϴ�~!");							//�� ��19���� ���
			

		}
		
		if((frontone==0 && fronttwo>=1) && (backnumber==1 || backnumber==2))	//1901����� ���
		  {
			System.out.print("�������� �Ǿ����ϴ� ~!");
			
			injeung();
		  }

		
		if((frontone==0 && fronttwo>=1) && (backnumber==3 || backnumber==4))	//���� 01������� ����� �̸鼭 ���ڸ��� 3�Ǵ�4�λ�� = �̼�����
		  {
			System.out.print("�̼������Դϴ�. 112�� �Ű������Ǿ����ϴ�~!!^^");
			br.dispMenu();														//�������� �̵�
		  }

		
          		  
		if((frontone==1 && fronttwo>=0) && (backnumber==3 || backnumber==4))	//2010��� ���� ����ڸ� �̼�����
		  {
			System.out.print("�̼������Դϴ�. 112�� �Ű������Ǿ����ϴ�~!!^^");
			br.dispMenu();
		  }
		  
		if((frontone==2 && fronttwo>=0) && (backnumber==3 || backnumber==4))    //2020��� ���� ����ڸ� �̼�����
		  {
			System.out.print("�̼������Դϴ�. 112�� �Ű������Ǿ����ϴ�~!!^^");
			br.dispMenu();
		  }
   
      
      if(jumin.length()!=14)													//�Է¹��� �ֹι�ȣ�� 14�ڸ��� �ƴ� ��� ���� ( - ���� )
        {

         System.out.println("�Է� ���� ~!!!, �ڸ����� Ȯ���ϼ���~!");
		 br.dispMenu();
	
		}
      
	  
																				//�Է��� �ֹι�ȣ * num �迭�ϴ� �κ� �ֹι�ȣ ��ȿ�� �˻��ϴºκ�
      for(int i=0; i<num.length;i++)
      {
         if(i==6)																//-�� ���ڿ��̱� ������ -�� ������ �����ϰ� ��� ����
            continue;
         sum += num[i] * Integer.parseInt(jumin.substring(i,i+1));
      }   

				


      namuji = (11-sum%11)%10;													//�������� �ֹε�� ��ȿ�� �˻� ����
      
      if(namuji==Integer.parseInt(jumin.substring(13)))							//���������� �Ϸ�Ǹ� ���� �޴���
		  {
         System.out.println(">>�������� �Ϸ�~!!!");
		
		  }
	  else
		  {
		  System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�.!");
		  br.dispMenu();
		  }

		

		
      }
      catch (Exception e)														//�ùٸ� ���ڿ��� �Էµ��� ������ ���
      {
        System.out.println("�ùٸ� ���ڸ� �Է����ּ��� ! ");
		br.dispMenu();
      }


   }

}