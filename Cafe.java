import java.util.Scanner;
import java.util.Vector;


//Ŀ�� �޴� �ɼ� Ŭ����(������ ���, ������ implements)
public class Cafe extends Admin implements Recipe
{
	int n;                  //ice �Ǵ� hot�� �����ϱ� ���� ����
	int t;                  //���� �߰��� �����ϱ� ���� ����
	int c;                  //Ŀ�� �޴��� �����ϱ� ���� ����
	int a;					//�ֹ��� �߰� ���θ� �����ϱ� ���� ����



	static int americano_num;		//�Ƹ޸�ī�� �ֹ� ����
	static int icetea_num;			//���̽�Ƽ �ֹ� ����
	static int latte_num;			//�� �ֹ� ����
	static int mocha_num;			//��ī �ֹ� ����
	static int earlgrey_num;		//��׷��� �ֹ� ����
	static int chocolate_num;		//���ݸ� �ֹ� ����
	static int ice_num;			//���ᰡ ���̽��� ��� ������ ������ ���� ���� ����
	static int i=0;
	static int syrup_num;
	static int bubble_num;
	static int whip_num;
	static int shot_num;

	//���� ������ ������ �ִ� Mprice Ŭ���� ��� �ν��Ͻ� ����
	Mprice m = new Mprice();

	Topping[] topping = new Topping[100];

	//Vector<Topping> v = new Vector<Topping>();
	

	//Ŀ�� �޴� ���� �޼ҵ�
	void choiceCafe() 
	{
		Scanner sc = new Scanner(System.in);

		//�߸��� ��ȣ�� �����ϸ� �ݺ�
		do
		{
		System.out.println();
			String a1="��";
			String r1="��";
			String m1="��";
			String e1="��";
			String c1="��";
			String i1="��";
			//��

		//Cafe c = new Cafe();
		//�Ƹ�
		if(getBean()==0 || getWater()==0 || getStockcup()==0)
		{
			a1="��";
		}
		//��
		if (getBean()==0 || getMilk()==0 || getStockcup()==0)
		{
			r1="��";
		}
		//��ī
		if (getBean()==0 || getMilk()==0 || getChocosyrup()==0 || getStockcup()==0)
		{
			m1="��";
		}
		//��׷���
		if (getWater()==0 || getTeabag()==0 || getStockcup()==0 )	
		{
			e1="��";
		}
		//���ݸ�
		if (getMilk()==0 || getChocosyrup()==0 || getWhipping()==0 || getCocoa()==0 || getStockcup()==0)
		{
			c1="��";
		}
		//���̽�Ƽ
		if (getMilk()==0 || getChocosyrup()==0 || getWhipping()==0 || getCocoa()==0 || getStockcup()==0)
		{
			i1="��";
		}
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t   �ְ��� Cafe �� Pub");
			System.out.println();
			System.out.printf("1.�Ƹ޸�ī��  \t%d\t%s \t2.���̽�Ƽ\t%d\t%s\n", m.americano,a1, m.icetea,i1);
			System.out.printf("3.ī���\t%d \t%s \t4.ī���ī\t%d\t%s\n", m.latte,r1,m.mocha,m1);
			System.out.printf("5.��׷���\t%d \t%s \t6.���ݸ�\t%d\t%s\n", m.earlgrey,e1,m.chocolate,c1);
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t\t\t    (�ֹ����� : �� ǰ�� :��)");
			System.out.println();
			System.out.println("�� ���Ͻô� �޴��� �Է����ּ���. ");
			System.out.print("   �� ");
			c = sc.nextInt();	
		}
		while (c<1 || c>6);

		//1��, �Ƹ޸�ī�븦 ������ ���
		if(c==1)
		{
			topping[i] = new Topping(); //���� Ŭ���� ��� �ν��Ͻ� ����
			topping[i].name = "�Ƹ޸�ī��";
			americano();				//�Ƹ޸�ī�� �޼ҵ� ȣ��
			dispTopping();				//���� �޴� ��� �޼ҵ�
			
			choiceTopping();			//���� �߰� �޼ҵ� ȣ��
		}
			
		//2��, ���̽�Ƽ�� ������ ���
		if(c==2)
		{
				topping[i] = new Topping();	//���� Ŭ���� ��� �ν��Ͻ� ����
			topping[i].name = "���̽�Ƽ";
			icetea();					//���̽�Ƽ �޼ҵ� ȣ��
			dispTopping();				//���� �޴� ��� �޼ҵ�
		
			choiceTopping();   //���� �߰� �޼ҵ� ȣ��
			
		}
		//3��, �󶼸� ������ ���
		if(c==3)
		{
			topping[i] = new Topping();	//���� Ŭ���� ��� �ν��Ͻ� ����
			topping[i].name = "ī���";
			latte();					//�� �޼ҵ� ȣ��
			dispTopping();				//���� �޴� ��� �޼ҵ�
			
			choiceTopping();   //���� �߰� �޼ҵ� ȣ��
	
		}
		//4��, ��ī�� ������ ���
		if(c==4)
		{
			topping[i] = new Topping();	//���� Ŭ���� ��� �ν��Ͻ� ����
			topping[i].name = "ī���ī";
			mocha();					//��ī �޼ҵ� ȣ��
			dispTopping();				//���� �޴� ��� �޼ҵ�
		
			choiceTopping();   //���� �߰� �޼ҵ� ȣ��

		}
		//5��, ��׷��� ������ ���
		if(c==5)
		{
			topping[i] = new Topping();	//���� Ŭ���� ��� �ν��Ͻ� ����
			topping[i].name = "��׷���";
			earlgrey();					//��׷��� �޼ҵ� ȣ��
			dispTopping();				//���� �޴� ��� �޼ҵ�
			
			choiceTopping();   //���� �߰� �޼ҵ� ȣ��

		}
		//6��, ���ݸ� ������ ���
		if(c==6)
		{
			topping[i] = new Topping();	//���� Ŭ���� ��� �ν��Ͻ� ����
			topping[i].name = "���ݸ�";
			chocolate();				//���ݸ� �޼ҵ� ȣ��
			dispTopping();				//���� �޴� ��� �޼ҵ�
			
			choiceTopping();   //���� �߰� �޼ҵ� ȣ��

		}
		
	} //end choicCafe()


   //���� �޴� ���
   void dispTopping()
   {
         //�Ǹſ��� Ȯ���� ���� �ʱ�ȭ �� -> �ǸŰ���, �� -> ����
		 String sh1="��";   //shot 
         String wh1="��";   //whip 
         String sy1="��";   //syrup 
         String bu1="��";   //bubble

	 //����(��) �����Ǿ��� ���
		if(getBean()==0)
            sh1="��";
		//�÷�
		if(getSyrup()==0)
            sy1="��";
		//����
		if(getWhipping()==0)
            wh1="��";
		//����
		if(getBubble()==0)
            bu1="��";
	
		 System.out.println();
         System.out.println("�� �߰��� ������ �����ϼ���.");
		 System.out.println("----------------------------");
		 System.out.println("       < �߰� �ɼ� > ");
		 System.out.printf("1.�� �߰�  \t%d\t%s\n", m.addshot,sh1);
		 System.out.printf("2.�÷� �߰�\t%d \t%s\n", m.addsyrup,sy1);
		 System.out.printf("3.���� �߰�\t%d \t%s\n", m.addwhip,wh1);
		 System.out.printf("4.���� �߰�\t%d \t%s\n", m.addbub,bu1);
		 System.out.println("5.����");
		 System.out.println("----------------------------");
	
   }


    //���� ���� �޼ҵ�
	public void choiceTopping()
	{

		Scanner sc = new Scanner(System.in);


		//���� �߰� ���� ����
		System.out.println("�� ������ �߰� �Ͻðڽ��ϱ�? (1) �� (2) �ƴϿ�  ");
		System.out.print("   �� ");
	    t = sc.nextInt();
		System.out.println();

		//������ �߰��Ѵٸ�
		if(t==1)
		{
			//�߰��� ���� ����, �߸��� ��ȣ �Է� �� �ݺ�
			do
			{
				System.out.println("�� �߰��Ͻ� ���� 1~5 ? " );
				System.out.print("   �� ");
				t = sc.nextInt();
				System.out.println();
			}
			while (t<1 || t>5);
		 
		   //1��, ���� �߰�
		   if(t==1)
		   {
			  addShot();
			  choiceTopping();
		   }
		   //2��, �÷� �߰�
		   if(t==2)
		   {
			  addSyrup();
			  choiceTopping();
		   }
		   //3��, ���� �߰�
		   if(t==3)
		   {
			  addWhip();
			  choiceTopping();
		   }
		   //4��, ���� �߰�
		   if(t==4)
		   {
			  addBubble();
			  choiceTopping();
		   }
		   //5�� �߰� ����
		   if(t==5)
		   {
			   i++;    //�̶� ���� Ŭ������� �迭�� �ε����� ���������ش�. i=0�̸� ù��° �� i=1�̸� �ι�° ��
		   }
			
		} //end if

		if (t==2)
		{
			i++;
		}

		
		//�ֹ� �߰� ���� ����
		System.out.println("�� �ֹ��� �� �߰��Ͻðڽ��ϱ�? (1)�߰� (2)����");
		System.out.print("   �� ");
		a = sc.nextInt();

		//�ֹ��� �߰��Ѵٸ�
		if(a==1)
			choiceCafe();	//Ŀ�� ���� �޴� �޼ҵ� ȣ��
		//�ֹ��� �߰����� �ʴ´ٸ�
		try
		{
			if(a==2) 
				basket();	//��ٱ��� �޼ҵ� ȣ��
		}
		catch (Exception e)
		{
		}


	}// end choiceTopping()


	//�Ƹ޸�ī�� ���� �޼ҵ�(���� 1, �� 1)
	@Override
	public void americano()
	{
		Scanner sc = new Scanner(System.in);    

		//ice hot ���� ����
		System.out.println();
		System.out.print("�� (1) ice (2) hot : " );
		n = sc.nextInt();

		//���� ice ���
		if(n==1)
			ice_num++;			   //������ ���� ����

		americano_num++;		   //�Ƹ޸�ī�� �ֹ� ���� ����

		setPayment(getPayment()+m.americano);
	}

	//���̽�Ƽ ���� �޼ҵ�(���̽�Ƽ1, ��1, ����1)
	@Override
	public void icetea()
	{
		
		ice_num++;				  //������ ���� ����
		icetea_num++;			  //���̽�Ƽ �ֹ� ���� ����
	
		setPayment(getPayment()+m.icetea);			  //price�� ���̽�Ƽ ���� ����
	}

	//�� ���� �޼ҵ�(���� 1, ����2)
	@Override
	public void latte()
	{
		Scanner sc = new Scanner(System.in);

		//ice hot ���� ����
	    System.out.println();
		System.out.print("�� (1) ice (2) hot : " );
		n = sc.nextInt();

		//���� ice ���
		if(n==1)
			ice_num++;			   //������ ���� ����

		latte_num++;			   //�� �ֹ� ���� ����

		setPayment(getPayment()+m.latte);			   //price�� �� ���� ����
	}

	//��ī ���� �޼ҵ�(����1, ���ڽ÷�1, ����2)
	@Override
	public void mocha()
	{
		Scanner sc = new Scanner(System.in);

try
{
	//ice hot ���� ����
		System.out.println();
		System.out.print("�� (1) ice (2) hot : " );
		n = sc.nextInt();

		//���� ice ���
		if(n==1)
			ice_num++;			   //������ ���� ����

		mocha_num++;			   //��ī �ֹ� ���� ����

		setPayment(getPayment()+m.mocha);			   //price�� ��ī ���� ����
}
catch (Exception e)
{
}
		

	}

	//��׷��� ���� �޼ҵ�(Ƽ��1, ��1)
	@Override
	public void earlgrey()
	{
		Scanner sc = new Scanner(System.in);
try
{
	//ice hot ���� ����
		System.out.println();
		System.out.print("�� (1) ice (2) hot : " );
		n = sc.nextInt();

		//���� ice ���
		if(n==1)
			ice_num++;			   //������ ���� ����

		earlgrey_num++;			   //��׷��� �ֹ� ���� ����

		setPayment(getPayment()+m.earlgrey);		   //price�� ��׷��� ���� ����
}
catch (Exception e)
{
}
		


	}

	//���ݸ� ���� �޼ҵ�(���ھ�1, ����2, ���ڽ÷�1, ����1)
	@Override
	public void chocolate()
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			//ice hot ���� ����
		System.out.println();
		System.out.print("�� (1) ice (2) hot : " );
		n = sc.nextInt();

		//���� ice ���
		if(n==1)
			ice_num++;			   //������ ���� ����

		chocolate_num++;		   //���ݸ� �ֹ� ���� ����

		setPayment(getPayment()+m.chocolate);		   //price�� ���ݸ� ���� ����
		}
		catch (Exception e)
		{
		}
		
	}

	//�� �߰� �޼ҵ�
	public void addShot()
	{
		topping[i].shot++;		  //�� �߰� ���� ����
		shot_num++;
		setPayment(getPayment()+m.addshot);		  //price�� �� �߰� ���� ����		
	}

	//���� �߰� �޼ҵ�
	public void addWhip()
	{
		topping[i].whip++;		  //���� �߰� ���� ����
		whip_num++;		  //price�� ���� �߰� ���� ����
		setPayment(getPayment()+m.addwhip);			  //price�� ���� �߰� ���� ����
	}

	//�÷� �߰� �޼ҵ�
	public void addSyrup()
	{
		topping[i].syrup++;		  //�÷� �߰� ���� ����
		syrup_num++;
		setPayment(getPayment()+m.addsyrup);		  //price�� �÷� �߰� ���� ����
	}

	//���� �߰� �޼ҵ�
	public void addBubble()
	{
		topping[i].bubble++;	  //���� �߰� ���� ����
		bubble_num++;
		setPayment(getPayment()+m.addbub);		  //price�� ���� �߰� ���� ����
	}

	
	
	
	void basket() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Beer be =new Beer(); //���� �ν��Ͻ� ����
		Pay pay = new Pay();
		

		int order = latte_num + mocha_num + chocolate_num + americano_num + earlgrey_num + icetea_num;
         
		System.out.println();
		System.out.println("�� �ֹ� Ȯ�� ���͵帮�ڽ��ϴ�.");
		System.out.println("----------------------------------------------------------");
		try{
			for (int j=0; j<order; j++)
			{

				String shot ="�� �߰� : " + Integer.toString(topping[j].shot);
				String whip ="���� �߰� : " + Integer.toString(topping[j].whip);
				String bubble = "���� �߰� : " + Integer.toString(topping[j].bubble);
				String syrup = "�÷� �߰� : " + Integer.toString(topping[j].syrup);
      
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

		   System.out.printf("   �� %s ��\n",topping[j].name); 
           System.out.printf("   %s %s %s %s", shot, whip, syrup, bubble);
           System.out.println();
           
         }
         System.out.println("----------------------------------------------------------");
		 System.out.println("   �� ���� ���� �ݾ� : " + getPayment() );
		 System.out.println();

		}
		
		catch (Exception e)
		{
		}
			System.out.println("�� �ֹ������ Ȯ�����ּ���! ���� �Ͻðڽ��ϱ�? (y/n)");
			System.out.print("   �� ");
			String ch = sc.next();
			System.out.println();

			if(ch.equals("y") || ch.equals("Y"))
				pay.paysel();
			if(ch.equals("n") || ch.equals("N"))
		   {
				Mainmachine mc = new Mainmachine();
			    System.out.println("�١ڡ١� ó������ �ٽ� �������ּ���~!! �١ڡ١�");
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
		System.out.println("�� ���� ���� ���� Ȯ�� / ������ ���");
		System.out.println("-----------------------------------------");
	    String cas=("�Ƹ޸�ī�� "+Integer.toString(americano_num));
		String hit=("ī��� "+Integer.toString(latte_num));
		String gui=("ī���ī "+Integer.toString(mocha_num));
		String ter=("���̽�Ƽ "+Integer.toString(icetea_num));
		String hei=("��׷��� "+Integer.toString(earlgrey_num));
		String cho=("���ݸ� "+Integer.toString(chocolate_num));
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

		System.out.printf("��%s   %s   %s   %s   %s   %s",cas,hit,gui,ter,hei,cho); 
		
		if (getPayment()>0)
		{
			System.out.printf("\n�� ���� ���� �ݾ� : %d\n",getPayment());
		}

		else if(d.rescoupon<=0)
		{
			 System.out.printf("\n�� ���� ���� �ݾ� : 0 ��\n");
		}

		
		System.out.println("-----------------------------------------");
		System.out.println("�� ������ ����� ���Ͻø� 1���� �����ּ���. ");
		System.out.print("   �� ");
		a = sc.nextInt();
		System.out.println();
				
		 setPayment(0);
		 i=0;

		if (a==1)
			System.out.println(">>>>�������� ��� �Ϸ�Ǿ����ϴ�.");

		System.out.println("�� �ֹ��� �Ϸ�Ǿ����ϴ�. �����մϴ�.\n");
	
		

		
	}
}
