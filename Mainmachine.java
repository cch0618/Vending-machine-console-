import java.util.Scanner;
public class Mainmachine extends Admin
{
	static int b=10000;		    //startTime�� ������� ������ 10000���� ����
	Adult au = new Adult();		//AdultŬ���� ��� �ν��Ͻ� ����

	//�޴���� �޼ҵ�
	public void dispMenu()     
	{
		Mprice m = new Mprice();	//MpriceŬ���� ��� �ν��Ͻ� ����
		Cafe ca = new Cafe();		//CafeŬ���� ��� �ν��Ͻ� ����
		Beer be = new Beer();		//BeerŬ���� ��� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);
		int n;						//ī�װ� ���� ���� 1.ī�� 2.���� 3.������

		//��� ��� ���ִ°ɷ� �ʱ�ȭ 
		String a1="��";				
		String r1="��";
		String m1="��";
		String e1="��";
		String c1="��";
		String i1="��";
		String ca1="��";
		String h1="��";
		String t1="��";
		String hi1="��";
		String g1="��";

	
		//�Ƹ�
		if(getBean()==0 || getWater()==0 || getStockcup()==0)		//�޴� ��� ����������, �Һ��� ����
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
		if (getWater()==0 || getIcetea()==0 || getStockcup()==0 || getIce()==0)
		{
			i1="��";
		}
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
		
		//�޴� ���(�޴��� ��� ǰ������ �˷���)
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t   �ְ��� Cafe �� Pub");
		System.out.println();
		System.out.printf("1.�Ƹ޸�ī��  \t%d\t%s \t1.ī��\t\t%d\t%s\n", m.americano,a1,m.cass,ca1);
		System.out.printf("2.���̽�Ƽ\t%d \t%s \t2.����Ʈ\t%d\t%s\n", m.icetea,i1,m.hite,h1);
		System.out.printf("3.ī���\t%d \t%s \t3.�׶�\t\t%d\t%s\n", m.latte,r1,m.terra,t1);
		System.out.printf("4.ī���ī\t%d \t%s \t4.��׽�\t%d\t%s\n", m.mocha,m1,m.guiness,g1);
		System.out.printf("5.��׷���\t%d \t%s \t5.���̳���\t%d\t%s\n", m.earlgrey,e1,m.heineken,hi1);
		System.out.printf("6.���ݸ�\t%d\t%s\n", m.chocolate,c1);
		System.out.println("------------------------------------------------------------");
		System.out.println("\t\t\t\t    (�ֹ����� : �� ǰ�� :��)");
		System.out.println();
		System.out.print("�� ���Ͻô� ���񽺸� �������ּ��� 1.Ŀ�� 2.���� 3.������ : "  );
		n=sc.nextInt();

		if(b==10000)   //b�� 10000�� �Ǹ�
		{
		reboot2();	   //startTime�� ��´�
		b--;		   //10000���� 1�� ����
		}	
		
	
		switch(n)	//ī�װ� ����
		{
			case 1:		//1�� ������
			{
				ca.choiceCafe(); break;	//ī��޴��� ����
			}
			
			case 2:      //2�� ������
			{
				au.jumin();				//�޴��� �����˻���
				au.injeung();			//�������� �˻�

				be.choiceBeer();		//���ָ޴��� ����
				break;
			}

			case 3:		//3�� ������
			{

				System.out.print("������ ��й�ȣ�� �Է����ּ��� : "); 
				int pass = sc.nextInt(); // ��й�ȣ �Է�

				if (pass==getownerPass()) //������ ��й�ȣ�� ���� �Է��� ��ȣ�� ������
				{
					disp();		//������ ���� 
			    }
				
				else
				{
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�"); //��й�ȣ�� Ʋ���ٸ�
					dispMenu();	//�޴���� �޼ҵ� ȣ��
				}
				   break;
			}
			
		} //end switch

	} //end dispMenu

	public static void main(String []args)  throws Exception
	{ 
		Mainmachine mc = new Mainmachine(); //MainmachineŬ���� ��� �ν��Ͻ� ����
		do
		{
			mc.dispMenu();		//�޴���� �޼ҵ�ȣ��
		}
		while (true);
	}
}