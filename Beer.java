import java.util.Scanner;

//���� Ŭ����(������ ���)
public class Beer extends Admin
{
	int n;      //����ڰ� ������ �޴� ��ȣ�� ������ ����
	char b;     //��ٱ��� ���θ� ������ ������ ����
	
	static int cass_num;	//��ٱ��Ͽ��� ����� ���ְ��� ����
	static int hite_num;
	static int terra_num;
	static int guiness_num;
	static int heineken_num;
	

	Admin ad = new Admin();
	Mprice m = new Mprice();


	//���� ���� �޼ҵ�
	void choiceBeer() 
	{
		Pay pay = new Pay();											   // Pay�ν��Ͻ� ����
		Cafe ca = new Cafe();											   // Cafe�ν��Ͻ� ����
        int c;															   // �Է¹��� ���� ����
		Scanner sc = new Scanner(System.in);
	try
{
	//�߸��� ��ȣ�� �����ϸ� �ݺ�
		do
		{String ca1="��";
		 String h1="��";
		 String t1="��";
		 String hi1="��";
		 String g1="��";//��

		//Cafe c = new Cafe();
		
		//ī��
		if (getCass()==0)
		{
			ca1="��";
		}
		//����Ʈ
		if (getHite()==0)
		{
			h1="��";
		}
		//�׶�
		if (getTerra()==0)
		{
			t1="��";
		}
		//���̳���
		if (getHeineken()==0)
		{
			hi1="��";
		}
		//��׽�
		if (getGuiness()==0)
		{
			g1="��";
		}

	
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t   �ְ��� Cafe �� Pub");
		System.out.println();
		System.out.printf("1.ī��\t\t%d\t%s \t2.����Ʈ\t%d\t%s\n",m.cass,ca1,m.hite,h1);
		System.out.printf("3.�׶�\t\t%d\t%s \t4.��׽�\t%d\t%s\n",m.terra,t1,m.guiness,g1);
		System.out.printf("5.���̳���\t%d\t%s\n",m.heineken,hi1);
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t\t\t    (�ֹ����� : �� ǰ�� :��)");
		System.out.println();
		System.out.print("�� ���Ͻô� �޴��� �Է����ּ���. : ");
		c = sc.nextInt();
		}
		while (c<1 || c>5);

																			
		if(c==1)															//1��, ī���� ������ ���
		{
			
			cass_num++;														//ī�� �ֹ� ���� ����
		    										//�� ���� �ݾ� ���� set
			setPayment(getPayment()+m.cass);								//���� �����ݾ� set
			setCassSale(getCassSale()+1);
		}
			
																			//2��, ����Ʈ�� ������ ���
		if(c==2)
		{
			hite_num++;														//����Ʈ �ֹ� ���� ����
		    
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
		
		String chu;															 //�߰��ֹ� ����Ȯ�� string���� ����
		System.out.println();
		System.out.print("�� �߰��ֹ� �Ͻðڽ��ϱ�? (Y/N) : ");
		chu = sc.next();
		
		if (chu.equals("y") || chu.equals("Y"))
		{
			choiceBeer();	//�߰� ���� ����
		}//end if
		
		else if (chu.equals("N") || chu.equals("n"))
	    {
			
			
			System.out.println();
			System.out.print("���� �ֹ� ����� ");

			String cas=("Cass "+Integer.toString(cass_num));			//�������� cass_num�� ���ڿ��� cas�� ���ϱ� ���Ͽ� Integer.toString()���� ����ȯ �� ����
			String hit=("Hite "+Integer.toString(hite_num));			
			String gui=("Guiness "+Integer.toString(guiness_num));
			String ter=("Terra "+Integer.toString(terra_num));
			String hei=("Heineken "+Integer.toString(heineken_num));
		
		
				if (cass_num==0)										// �̿��ڰ� �������� �ʾ�����, ""�� �ʱ�ȭ
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

		   System.out.printf("��%s %s %s %s %s",cas,hit,gui,ter,hei);		// ������ �� �ַ����� ���� ���
           System.out.println();
           System.out.println("--------------------------------------");
		   System.out.println("   �� ���� ���� �ݾ� : " + getPayment());		// ���ݱ��� �ֹ��� �ݾ��� ���
		   System.out.println();
		
			System.out.println("�ֹ������ Ȯ�����ּ���! ���� �Ͻðڽ��ϱ�?(Y/N)");
			String ch = sc.next();
         try{
             if (ch.equals("y") || ch.equals("Y"))							// Y�� �Է¹����� ���� ���� ����
             {
                pay.paysel();
             }
             else if (ch.equals("n") || ch.equals("N"))						// N�� �Է¹����� �ֹ� ��� �ַ��޴��� �̵�
             {
				 Mainmachine mc = new Mainmachine();
	     		System.out.println("�١ڡ١� ó������ �ٽ� �������ּ���~!! �١ڡ١�");
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


	// ���� ���� Ȯ�� / ������ ��� �޼ҵ� 
	void receipt() throws Exception
	{
		Scanner sc = new Scanner (System.in);
		int a;																			//������ ��� ���θ� �Է¹��� ���� ����
		System.out.println();
		System.out.println("�� ���� ���� ���� Ȯ�� / ������ ���");
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
		System.out.printf("��%s   %s   %s   %s   %s",cas,hit,gui,ter,hei); 
        System.out.printf("\n�� ���� ���� �ݾ� : %d\n",getPayment());
		System.out.println("-----------------------------------------");
		System.out.println("�� ������ ����� ���Ͻø� 1���� �����ּ���. ");
		System.out.print("   �� ");
		a = sc.nextInt();
		System.out.println();

		setPayment(0);																			//setPaymet ���� �����ݾ� �ʱ�ȭ.
		if (a==1)																				//������ ����� ���Ѵٸ� ������ִ� �κ�
			
			
			System.out.println(">>>>�������� ��� �Ϸ�Ǿ����ϴ�.");

			System.out.println("�� �ֹ��� �Ϸ�Ǿ����ϴ�. �����մϴ�.\n");


		
		Mainmachine mc = new Mainmachine();														//�����ֹ� �Ϸ� ��. ó���޴��� �̵�
		mc.dispMenu();

		

		
	}

} // end beer

