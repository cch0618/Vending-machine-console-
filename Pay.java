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
	static int money;					// ���Ե� �� �ݾ�
	static int balance;					// �Ž��� �� = ���� �ݾ� - ���� �ݾ�
	String cardNum;						// ī�� ��ȣ
	String cvc;							// cvc ��ȣ

	static int man1;					// 10000 �� ����
	static int chun5;					// 5000 �� ����
	static int chun1;					// 1000 �� ����
	static int bak5;					// 500 �� ����
	static int bak1;					// 100 �� ����

	static int phonenum;				// ���� - �޴�����ȣ
	static int ncoupon;					// ���� ���� ����
	static int rescoupon;				// ���� ���� �� �ݾ�
	String n;							// ������ ���� ���θ� ����
	static int stamp;					// ������ ����
	
	static int sum;						// ���Ǳ� ���� �ִ� �� �ݾ�

	Mprice mp = new Mprice();
	Mainmachine m = new Mainmachine();
	
	Cafe ca =new Cafe(); //ī�� �ν��Ͻ� ����
	Beer be =new Beer(); //���� �ν��Ͻ� ����

	Scanner sc = new Scanner(System.in);

	// ���� ���� ó�� �޼ҵ�
	void paysel()
	{
		int select;		// ���� ���� ���õ� ��ȣ�� ������ ����
		try
		{
			do
				{
					
					System.out.println("�� ���� ������ �������ּ���. ");
					System.out.println("-----------------------------------");
					System.out.println(" 1. ����   2. ī��   3. ���� ���");
					System.out.println("-----------------------------------");
					System.out.print("  : ");
					select = sc.nextInt();
				}
				while (select<1 && select>3);	// 1������ 3���� �Է����� ���� ��� ��� �ݺ�

				if(select==1)		// 1�� �Է� �� ���� �޼ҵ�
					cash();
				if(select==2)		// 2�� �Է� �� ī�� �޼ҵ�
					card();
				if(select==3)		// 3�� �Է� �� ���� �޼ҵ�
					coupon();
			}


		catch (Exception e)
		{
		}
	}
		
	
	// ���� ���� �� ó�� �޼ҵ�
	void cash()	throws Exception
	{
		String selreceipt;		// ���ݿ����� ���� ���� ����


		System.out.println();
		System.out.println("�� ���� ���� �����ϰڽ��ϴ�.");


		System.out.println();
		System.out.println("�� ������ �ݾ��� �Է����ּ���.\n");
		System.out.print("    10000 �� : ");
		man1 = sc.nextInt();					// ���Ե� ���� ��� ������ ����
		System.out.print("     5000 �� : ");
		chun5 = sc.nextInt();					// ���Ե� ��õ�� ��� ������ ����
		System.out.print("     1000 �� : ");
		chun1 = sc.nextInt();					// ���Ե� õ�� ��� ������ ����
		System.out.print("      500 �� : ");
		bak5 = sc.nextInt();					// ���Ե� ����� ��� ������ ����
		System.out.print("      100 �� : ");
		bak1 = sc.nextInt();					// ���Ե� ��� ��� ������ ����

			
		// ���Ե� ȭ�� ���� �� �ݾ� ����� ���� ������ ����
		int M1=man1*10000;
		int C5=chun5*5000;
		int C1=chun1*1000;
		int B5=bak5*500;
		int B1=bak1*100;


		money = M1+C5+C1+B5+B1;			// ���Ե� �� �ݾ�

        
		balance=money-getPayment();		// �Ž����� = ���Աݾ� - �����ݾ�
		int balance2=balance;			// ���� �Ž������� ���ο� ������ ����

		balance();						// �Ž����� �޼ҵ� ȣ��

		System.out.println();
		System.out.println("�� �����Ͻ� �ݾ��� Ȯ�����ּ���.\n");
		System.out.printf("   �� %d ���� �����ϼ̽��ϴ�.\n", money);
		System.out.printf("   �� �Ž����� �ݾ� : %d\n\n", balance2);

		System.out.print("�� ���� ������ �Ͻðڽ��ϱ�? (Y/N) : ");
		selreceipt = sc.next();			// ���� ������ ����
		

		// y �Ǵ� Y�� ������ ��� ���ݿ����� ó�� �� ������ ó�� �޼ҵ�
		if (selreceipt.equals("Y") || selreceipt.equals("y"))
		{
			System.out.print("�� �޴��� ��ȣ�� �Է����ּ���.(- ����) : ");
			String phone = sc.next();
			System.out.println("�� ���� ������ ó�� �Ǿ����ϴ�. ��");
			stamp();
		}
		// �׷��� ������ ������ ó�� �޼ҵ� ����
		else
			stamp();

		// ��� �����ϰ� ���� �޴� ȭ�� ���
		m.dispMenu();
	}

	// ī�� ���� �� ó�� �޼ҵ�
	void card()	throws Exception
	{
		// ���� ���丮 ��ġ�� appDir �� ����
		String appDir = System.getProperty("user.dir");

		// appDir ��ġ�� fcard.txt ���� ����
		File fcard = new File(appDir, "\\card\\fcard.txt");
		
		// ������ �������� �ʴ´ٸ�
		if(!fcard.getParentFile().exists())
			fcard.getParentFile().mkdirs();		// ���丮 ����

		// Hashtable ����Ͽ� ī���ȣ(key)�� ī��cvc��ȣ(value) ��� ���� ���� ����
		Hashtable<String, String> h1 = new Hashtable<String, String>();

		h1.put("12345678", "1234");		// ī���ȣ�� cvc��ȣ�� �̸� �Է��Ͽ� h1 �� �־����
		h1.put("78945612", "7894");

		// ���� ����
		FileOutputStream fos = new FileOutputStream(fcard);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(h1);
		oos.close();
		fos.close();

		System.out.println();
		System.out.println("�� ī�� ���� �����ϰڽ��ϴ�.");

		//ī�� ��ȣ �Է¹ޱ�
		System.out.println();
		System.out.println("�� ī�� ��ȣ�� �Է����ּ���. ");
		System.out.print(" �� ");
		cardNum = sc.next();

		//cvc ��ȣ �Է¹ޱ�
		System.out.println();
		System.out.println("�� CVC��ȣ�� �Է����ּ��� (4�ڸ�)");
		System.out.print(" �� ");
		cvc = sc.next();
		System.out.println();

		// ������ ���� �����ϸ�
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

			//�о�� ���� ���
			while (e.hasMoreElements())
			{
				key = (String)e.nextElement();

				value = (String)h1.get(key);

				//���Ͽ� ����� ī���ȣ�� cvc��ȣ�� ��ġ�ϸ�
				if(key.equals(cardNum) && value.equals(cvc))
				{
					//�޽��� ���
					System.out.println("=====ī�� ���� ���� ~!!!=====");
					System.out.println("�� ������ �Ϸ� �Ǿ����ϴ�.\n");
					System.out.println("�� ������ ���� ȭ������ �̵��մϴ�.\n");
					//stamp �޼ҵ� ȣ��
					stamp();
				}

				//ī���ȣ�� cvc��ȣ�� Ʋ���ٸ�
				else if(!key.equals(cardNum) || !value.equals(cvc) && e.hasMoreElements()==false)
				{
					System.out.println("�� ����Ͻ� �� ���� ī���Դϴ�.");
					System.out.println("   ���� ������ �ٽ� �������ּ���.\n");
					//���� �޼ҵ� ȣ���Ͽ� �ٽ� ���� ���� ����
					paysel();
				}
			}
		}

		//�޴��� �޼ҵ� ȣ��
		m.dispMenu();
	}

	// ���� ��� ���� �� ó�� �޼ҵ�
	void coupon() throws Exception
	{
	
		ncoupon=1;
		System.out.println();
		System.out.println("�� ���� ��� ���� �����ϰڽ��ϴ�.");

		//�޴��� ��ȣ �Է¹ޱ�
		System.out.println();
		System.out.println("�� �޴��� ��ȣ�� �Է����ּ���.");
		System.out.print(" �� ");
		phonenum = sc.nextInt();

		//����ڰ� ������ ���� �ż� ���
		System.out.println();
		System.out.printf("�� ���� �����Ͻ� ���� �ż��� %d�� �Դϴ�.", ncoupon);
			
		if (ncoupon == 0)		// ������ ������ �ϳ��� ���� ���
		{
			System.out.println();
			System.out.println("�� ����Ͻ� �� �ִ� ������ �������� �ʽ��ϴ�. ");
			System.out.println("   ó������ �ٽ� ���� ���ּ���.");

			//���� �޼ҵ带 ȣ���Ͽ� �ٽ� �������� ����
			paysel();
		}
		else if(ncoupon >= 1)	// ������ 1�� �̻��� ���
		{
			
			rescoupon = getPayment()- 3000;		// ���� ��� �� �ݾ� = ���� �ݾ� - 3000
			setPayment(rescoupon);

			ncoupon--;							// ������ ���� 1 ����

			System.out.println();

			if (rescoupon <= 0)					// ���� ��� �� �ݾ��� 0 , 0���� ���� ���
			{
				System.out.print("�� ���� ���� �� �ݾ��� 0 �� �Դϴ�.");		// ������ ���� ��� �� �ݾ� 0 �� ���
				System.out.printf("   ���� ���� ������ %d �� �Դϴ�.", ncoupon);
				System.out.println();
			}

			else if (rescoupon > 0)				// ���� ��� �� �ݾ��� 0���� ū ���
			{
				System.out.printf("�� ���� ���� �� �ݾ��� %d �� �Դϴ�.", rescoupon);
				System.out.printf("   ���� ���� ������ %d �� �Դϴ�.", ncoupon);
				System.out.println();

				System.out.println("�� �߰� ���� �ݾ��� �����ֽ��ϴ�.");
				System.out.println("   �߰� ���� �������� �̵��մϴ�.");

				//���� �޼ҵ� ȣ��(�߰� �ݾ�)
				paysel();
			}
 
			//���� �� stamp�޼ҵ� ȣ��
			stamp();
		}
	}

	// �Ž����� ó�� �޼ҵ�
	void balance()  throws Exception
	{
		Beer br = new Beer();		// Beer Ŭ���� �ν��Ͻ� ����
		Cafe cf = new Cafe();		// Cafe Ŭ���� �ν��Ͻ� ����

		//System.out.println("�Ž����� ó�� �޼ҵ� ����");
		
		
		int g1=getmanWon()*10000;	// ���Ǳ⿡ �ִ� ���� �ż� �����ͼ� g1 �� ����
		int g2=getchunWon5()*5000;	// ���Ǳ⿡ �ִ� ��õ�� �ż� �����ͼ� g2 �� ����
		int g3=getchunWon1()*1000;	// ���Ǳ⿡ �ִ� õ�� �ż� �����ͼ� g3 �� ����
		int g4=getbakWon5()*500;	// ���Ǳ⿡ �ִ� ����� ���� �����ͼ� g4 �� ����
		int g5=getbakWon1()*100;	// ���Ǳ⿡ �ִ� ��� ���� �����ͼ� g5 �� ����

		sum = g1 + g2 + g3 + g4 + g5;	// ���Ǳ� ���� �ִ� �� �ݾ�
	
        int cbalance = balance;			// cbalance ������ ���� �Ž����� ����

		chun5 = balance / 5000;			// ���� �Ž��������� �Ž��� ����� 5000�� �ż� ����

		balance -= (chun5 * 5000);		// ���� �Ž��������� 5000�� �ż��� ���� �ݾ׸�ŭ ����

		chun1 = balance / 1000;			// ���� �Ž��������� �Ž��� ����� 1000�� �ż� ����

		balance -= (chun1 * 1000);		// �Ž��������� 1000�� �ż��� ���� �ݾ׸�ŭ ����

		bak5 = balance / 500;			// ���� �Ž��������� �Ž��� ����� 500�� ���� ����

		balance -= (bak5 * 500);		// �Ž��������� 500�� ������ ���� �ݾ׸�ŭ ����

		bak1 = balance / 100;			// ���� �Ž��������� �Ž��� ����� 100�� ���� ����

		balance -= (bak1  * 100);		// �Ž��������� 100�� ������ ���� �ݾ׸�ŭ ����

	
			

		// ī�� �Ž����� ���
		if(sum < cbalance)	// (��迡 ���� �ݾ׺��� ��ٱ��� �ݾ��� ū ��� ��ȯ X) 
		{
			System.out.println();
			System.out.println("�� ��ȯ ������ ȭ�� �������� �ʽ��ϴ�.");
			System.out.println("   �ٸ� ���� ������ �̿����ּ���. ");
			paysel();
		}

		if(getPayment() < money) // (��迡 ȭ�� ����Ѱ��)
		{
			// (��� ȭ�� ��ȯ ����) ���Ǳ� ���� �ִ� ȭ�� ���� �� �ż��� �Ž��� ����� ȭ�� �ż����� Ŭ ���
			if(getchunWon5()>=chun5 && getchunWon1()>=chun1 && getbakWon5()>=bak5 && getbakWon1()>=bak1)
			{
				System.out.println();
				System.out.println("�� ��ȯ ������ ȭ�� �����ֽ��ϴ�.");
				// ��ȯ�� ȭ�� �ż� ���
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");

				// ���Ǳ� ���� ȭ�� �ż����� �Ž��� ��� �� �ż��� ���� ������ set
				if(getchunWon5() > 0)
					setchunWon5(getchunWon5()-chun5);
				if(getchunWon1() > 0)
					setchunWon1(getchunWon1()-chun1);
				if(getbakWon5() > 0)
					setbakWon5(getbakWon5()-bak5);
				if(getbakWon1() > 0)
					setbakWon1(getbakWon1()-bak1);
			}
			// ���� ���Ǳ⿡ 5õ���� ������ ���
			else if(getchunWon5()<chun5)
			{
				chun1 += (chun5 * 5);	// �Ž��� �� 5õ�� �ż��� ��� õ������ �ٲ���.
				chun5 = 0;				// �Ž��� �� 5õ�� 0���� �������
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");
				setchunWon5(getchunWon5()-chun5);
				setchunWon1(getchunWon1()-chun1);
				setbakWon5(getbakWon5()-bak5);
				setbakWon1(getbakWon1()-bak1);
			}
			// ���� ���Ǳ⿡ 1õ���� ������ ���
			else if(getchunWon1()<chun1)
			{
				bak5 += (chun1 * 2);	// �Ž��� �� õ�� �ż��� ��� ��������� �ٲ���.
				chun1 = 0;				// �Ž��� �� õ�� 0����
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");

				// ���Ǳ� ���� ȭ�� �ż����� �Ž��� ��� �� �ż��� ���� ������ set
				setchunWon5(getchunWon5()-chun5);
				setchunWon1(getchunWon1()-chun1);
				setbakWon5(getbakWon5()-bak5);
				setbakWon1(getbakWon1()-bak1);
			}
			// ���� ���Ǳ⿡ 5����� ������ ���
			else if(getbakWon5()<bak5)
			{
				bak1 += (bak5 * 5);		// �Ž��� �� 5��� ������ ��� ������� �ٲ���
				bak5 = 0;				// �Ž��� �� ����� 0����
				System.out.println("------------------------------------------------");
				System.out.println("   5000 : " + chun5 + "  1000 : " + chun1 + "  500 : " + bak5 + "  100 : " + bak1);
				System.out.println("------------------------------------------------");

				// ���Ǳ� ���� ȭ�� �ż����� �Ž��� ��� �� �ż��� ���� ������ set
				setchunWon5(getchunWon5()-chun5);
				setchunWon1(getchunWon1()-chun1);
				setbakWon5(getbakWon5()-bak5);
				setbakWon1(getbakWon1()-bak1);
			}
			// ���� ���Ǳ⿡ � ȭ�� �������� �ʴ� ���
			else
			{
				System.out.println(" �� ��ȯ ������ ȭ�� �������� �ʽ��ϴ�.");
				System.out.println("    �ٸ� ���� ������ �������ּ���.");
				// ��ȯ �Ұ� ǥ�� �� �ٸ� ���� ����
				paysel();
			}
		}
		else
		{
			System.out.println(" �� ���Աݾ��� ���ڶ��ϴ�.");
			System.out.println("    �ٸ� ���� ������ �������ּ���.");
			paysel();
		}
	}


	// ������ ���� ó�� �޼ҵ�
	void stamp() throws Exception
	{
		//HashMap Ŭ���� ��� �ν��Ͻ� ����
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		System.out.println();
		System.out.print("�� �������� �����Ͻðڽ��ϱ�? (Y/N) : " );
		n = sc.next();
		System.out.println();


		//�������� ������ ���
		if(n.equals("y") || n.equals("Y"))
		{
			System.out.println("�� ������ ������ ���͵帮�ڽ��ϴ�.");

			System.out.print("������ �޴��� ��ȣ�� �Է����ּ���." );
			phonenum = sc.nextInt();

			//�ܸ��� stamp ����
			stamp++;

			
			//���� stamp�� 10������� ���̸� ���� ���� ����
			if(stamp%10 == 0)
			{
				ncoupon+=(stamp/10);
				stamp=0;
			}
		}

			//HashMap�� �޴��� ��ȣ�� key��, �������� value������ ����
			map.put(phonenum, stamp);
			
			//������ ���� ��Ȳ ���
			System.out.println();
			System.out.println("�� ������ ������ �Ϸ�Ǿ����ϴ�.");
			System.out.println("---------------------------------------");
			System.out.println("	���� ���� ������ �� ���� Ȯ��");
			System.out.printf("		�� ������ : %d / 3\n" , stamp);
			System.out.printf("		�� ���� : %d ��\n", ncoupon);
			System.out.println("---------------------------------------");

			//����ڰ� ���ָ� ������ ���
            if (ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num==0)
            {
					//���� ������ �޼ҵ� ȣ��
					be.receipt();
					//basekt_yes(��� ����)�޼ҵ� ȣ��
					basket_yes();
            }
			//����ڰ� Ŀ�Ǹ� ������ ���
			else
			{
					//ī�� ������ �޼ҵ� ȣ��
					ca.receipt();
					//basket_yes(��� ����)�޼ҵ� ȣ��
					basket_yes();
			}	
			

		//�������� �������� ���� ���
		if(n.equals("n") ||  n.equals("N"))
		{
		
			//����ڰ� ���ָ� ������ ���
			if (ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num==0)
			{
				be.receipt();
				basket_yes();
				m.dispMenu();
			}
			//����ڰ� Ŀ�Ǹ� ������ ���
			else 
			{
				ca.receipt();
				basket_yes();
				m.dispMenu();
			}
		}

	} // end stamp()

	//��ٱ��� ��� ���� �޼ҵ�
	void basket_yes()	
	{
		//MainmachineŬ���� ��� �ν��Ͻ� ����
		Mainmachine mc = new Mainmachine();
		//MpriceŬ���� ��� �ν��Ͻ� ����
		Mprice m = new Mprice();
		
		
		//��ٱ��Ͽ� ����ִ� �ֹ�����
		int order= ca.latte_num + ca.mocha_num + ca.chocolate_num + ca.americano_num + ca.earlgrey_num + ca.icetea_num
			+ be.cass_num + be.hite_num + be.terra_num + be.heineken_num + be.guiness_num;


		 //���� ����� �翡�� ���̴� ������ �����Ŀ�(���� ��������) �ٽ� ��ᷮ ����

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


		 //����
		 if(getSyrup() > 0)
			setSyrup(getSyrup() - ca.syrup_num);
		 if(getBubble() > 0)
			setBubble(getBubble() - ca.bubble_num);
		 if(getWhipping() > 0)
			setWhipping(getWhipping() - ca.whip_num);


		 //����
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

		 //��
		 if(getStockcup() > 0)
			setStockCup(getStockcup()- ca.latte_num - ca.mocha_num - ca.chocolate_num - ca.americano_num - ca.earlgrey_num - ca.icetea_num);


		 //���� �Ǹ� ����
		 setCassSale(getCassSale()+be.cass_num);	 
		 setHiteSale(getHiteSale()+be.hite_num);
		 setTerraSale(getTerraSale()+be.terra_num);
		 setHeinekenSale(getHeinekenSale()+be.heineken_num);
		 setGuinessSale(getCassSale()+be.guiness_num);

		 //Ŀ�� �Ǹ� ����
		 setAmericanoSale(getAmericanoSale() + ca.americano_num);
		 setIceteaSale(getIceteaSale() + ca.icetea_num);
		 setLatteSale(getLatteSale() + ca.latte_num);
		 setMochaSale(getMochaSale() + ca.mocha_num);
		 setEarlgreySale(getEarlgreySale() + ca.earlgrey_num);
		 setChocolateSale(getChocolateSale() + ca.chocolate_num);


		 //Ŀ�� �� ����
		 setTot(getTot()+m.americano*ca.americano_num);	   
		 setTot(getTot()+m.icetea);							
		 setTot(getTot()+m.latte*ca.latte_num);			  	
		 setTot(getTot()+m.mocha*ca.mocha_num);			   
		 setTot(getTot()+m.earlgrey*ca.earlgrey_num);		   
		 setTot(getTot()+m.chocolate*ca.chocolate_num);		  
		
		 //���� �� ����
		 setTot(getTot()+m.addshot*ca.shot_num);		  	
		 setTot(getTot()+m.addwhip*ca.whip_num);	
		 setTot(getTot()+m.addsyrup*ca.syrup_num);
		 setTot(getTot()+m.addbub*ca.bubble_num);

		 //���� �� ����
		 setTot(getTot()+m.terra*be.terra_num);
	     setTot(getTot()+m.heineken*be.heineken_num);
		 setTot(getTot()+m.guiness*be.guiness_num);	 
		 setTot(getTot()+m.hite*be.hite_num);
		 setTot(getTot()+m.cass*be.cass_num);


		 //�Ѹ��� ���� �ֹ� �Ϸ� �� �޴� ���� �ʱ�ȭ
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

		//�迭�� �ε����� ���� �ʱ�ȭ
		ca.i=0;
		setPayment(0);

		//�޴��� �޼ҵ� ȣ��
		mc.dispMenu();

	}
	
	//��ٱ��� ��� �޼ҵ�
	void basket_no()  
	{		
			
		 //Mainmachine Ŭ���� ��� �ν��Ͻ� ����
		 Mainmachine m = new Mainmachine();
		
     	 //���� ����� �翡�� ���̴� ������ ������ �Ŀ�(���� ��������) �ٽ� ��ᷮ ����
		 //����� �ִ� ���� 100�̹Ƿ� 100�� ������ ���� ����
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


		 //�迭�� �ε����� ���� �ʱ�ȭ
		 ca.i=0;
		 setPayment(0);

		 //�޴��� �޼ҵ� ȣ��
		 m.dispMenu();


	}
}