import java.util.Scanner;
import java.util.Calendar;
import java.util.Hashtable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Enumeration;
import java.io.IOException;

public class Admin
{
	// Time ��ü ����
   Time time = new Time();
	
   static String startTime; // ���۽ð�
   String currentTime;      // ����ð�
   int repairChargeSum=0;   // ����ý� �ҷ��� ����



   boolean b;					//���ۿ��� Ȯ������ ���� ����

   public boolean power=true;	//�ֿܼ��� ���α׷� �ð��� ���۵Ǿ��� ��

	

	// ���, �Ž����� �ʱ⼳��
   private static int bean =0;
   private static int bubble=100;
   private static int water=100; 
   private static int chocosyrup=100;
   private static int syrup=100;
   private static int milk=100;
   private static int teabag=100;
   private static int icetea=100;
   private static int cocoa=100;
   private static int whipping=100;
   private static int cass=100;
   private static int hite=100;
   private static int terra=100;
   private static int heineken=100;
   private static int guiness=100;
   private static int stockType;
   private static int stockNum;
   private static int stockCup=100;
   private static int ice=100;
   private static int manwon=100;
   private static int chunwon5=100;
   private static int chunwon1=0;
   private static int bakwon5=100;
   private static int bakwon1=100;
  
   // �ʱ� ������ ��й�ȣ ����
   private static int ownerpass=7897;

   // �Ǹŷ� �ʱⰪ ����
   private static int americanosale=0;
   private static int iceteasale=0;
   private static int earlgreysale=0;
   private static int mochasale=0;
   private static int chocolatesale=0;
   private static int lattesale=0;
   private static int casssale=0;
   private static int hitesale=0;
   private static int terrasale=0;
   private static int guinesssale=0;
   private static int heinekensale=0;
    
   private static int tot=0; // �� ����
   private static int payment=0; // ���ݾ�

   // ���� ��ȣ ���� ����
   private static int certCharLength=8;
  
   // ��й�ȣ ���̼��� �޼ҵ�
   public void setcertCharLength(int certcharLength){this.certCharLength=certCharLength;}
  
   // ���, �Ž��� ����
   public void setBean(int bean){this.bean = bean;}
   public void setPayment(int payment){this.payment = payment;}
   public void setBubble(int bubble){this.bubble = bubble;}
   public void setWater(int water){this.water = water;}
   public void setChocosyrup(int chocosyrup){this.chocosyrup = chocosyrup;}
   public void setSyrup(int syrup){this.syrup = syrup;}
   public void setMilk(int milk){this.milk = milk;}
   public void setIce(int ice){this.ice = ice;}
   public void setTeabag(int teabag){this.teabag = teabag;}
   public void setIcetea(int icetea){this.icetea = icetea;}
   public void setCocoa(int cocoa){this.cocoa = cocoa;}
   public void setWhipping(int whipping){this.whipping = whipping;}
   public void setCass(int cass){this.cass = cass;}
   public void setHite(int hite){this.hite =  hite;}
   public void setTerra(int terra){this.terra =  terra;}
   public void setHeineken(int heineken){this.heineken =  heineken;}
   public void setGuiness(int guiness){this.guiness =  guiness;}
   public void setStockType(int stockType){this.stockType =  stockType;}
   public void setStockNum(int stockNum){this.stockNum =  stockNum;}
   public void setStockCup(int stockCup){this.stockCup =  stockCup;}
   public void setmanWon(int manwon)
	   {
	   this.manwon =  manwon;
	   }
   public void setchunWon5(int chunwon5)
	   {
	   this.chunwon5 =  chunwon5;
	   }
   public void setchunWon1(int chunwon1)
	   {
	   this.chunwon1 = chunwon1;
	   }
   public void setbakWon5(int bakwon5)
	   {
	   this.bakwon5 =  bakwon5;
	   }
   public void setbakWon1(int bakwon1)
	   {
	   this.bakwon1 =  bakwon1;
	   }

   // ��й�ȣ ����
   public void setownerPass(int ownerpass){this.ownerpass =  ownerpass;}
   
   
   
   
   // �Ǹŷ� ����
   public void setTot(int tot) { this.tot = tot; }
   public void setAmericanoSale(int americanosale){this.americanosale = americanosale;}
   public void setLatteSale(int lattesale){this.lattesale = lattesale;}
   public void setIceteaSale(int iceteasale){this.iceteasale = iceteasale;}
   public void setMochaSale(int mochasale){this.mochasale = mochasale;}
   public void setChocolateSale(int chocolatesale){this.chocolatesale = chocolatesale;}
   public void setEarlgreySale(int earlgreysale){this.earlgreysale = earlgreysale;}

   public void setCassSale(int casssale){this.casssale = casssale;}
   public void setHiteSale(int hitesale){this.hitesale = hitesale;}
   public void setGuinessSale(int guinesssale){this.guinesssale = guinesssale;}
   public void setTerraSale(int terrasale){this.terrasale = terrasale;}
   public void setHeinekenSale(int heinekensale){this.heinekensale = heinekensale;}
 

   //setter�Ϸ�

   //���, �Ž���
   public int getBean(){return bean;}
   public int getBubble(){return bubble;}
   public int getWater(){return water;}
   public int getIce(){return ice;}
   public int getChocosyrup(){return chocosyrup;}
   public int getSyrup(){return syrup;}
   public int getMilk(){return milk;}
   public int getTeabag(){return teabag;}
   public int getIcetea(){return icetea;}
   public int getCocoa(){return cocoa;}
   public int getWhipping(){return whipping;}
   public int getCass(){return cass;}
   public int getHite(){return hite;}
   public int getTerra(){return terra;}
   public int getHeineken(){return heineken;}
   public int getGuiness(){return guiness;}
   public int getStockType(){return stockType;}
   public int getStockNum(){return stockNum;}
   public int getStockcup(){return stockCup;}
   public int getmanWon(){return manwon;}
   public int getchunWon5(){return chunwon5;}
   public int getchunWon1(){return chunwon1;}
   public int getbakWon5(){return bakwon5;}
   public int getbakWon1(){return bakwon1;}

   // ������ ��й�ȣ
   public int getownerPass(){return ownerpass;}
  
   
   // �� ����
   public int getTot() {return tot;}

   // ������ �ݾ�
   public int getPayment(){return payment;}

	
   // ����, Ŀ�� �Ǹŷ�
   public int getAmericanoSale(){return americanosale;}
   public int getLatteSale(){return lattesale;}
   public int getIceteaSale(){return iceteasale;}
   public int getMochaSale(){return mochasale;}
   public int getChocolateSale(){return chocolatesale;}
   public int getEarlgreySale(){return earlgreysale;}

   public int getCassSale(){return casssale;}
   public int getHiteSale(){return hitesale;}
   public int getTerraSale(){return terrasale;}
   public int getGuinessSale(){return guinesssale;}
   public int getHeinekenSale(){return heinekensale;}
   
   // ���� ������ȣ ����
	public int certCharLength(){return certCharLength;}
   //getter�Ϸ�



	

	public void disp()  // �޴� ���
	{
	Mainmachine n1=new Mainmachine(); // ���� ��ü ����
	try
	{
			int n;
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t   <������ ���>");
			System.out.println();
			System.out.printf("\t\t 1.�� ����  \n");  
			System.out.printf("\t\t 2.��� ����\n");
			System.out.printf("\t\t 3.�Ž����� ����\n");
			System.out.printf("\t\t 4.���� ����\n");
			System.out.printf("\t\t 5.��й�ȣ ����\n");
			System.out.printf("\t\t 6.���ð�(������) Ȯ��\n");
			System.out.printf("\t\t 7.����� ����\n");
			System.out.printf("\t\t 8.ó������\n");
			System.out.println("------------------------------------------------------------");
			System.out.println();
			System.out.print("�̿��Ͻ� �޴��� �Է����ּ��� : ");
			n=sc.nextInt();
	
			switch (n)
			{
			case 1 : totalmoney(); disp();break;
			case 2 : stock(); disp();break;
			case 3 : change(); disp();break;
			case 4 : reprice(); disp();break;
			case 5 : repass(); disp();break;
			case 6 : reboot3(); disp();break;
			case 7 : reboot4(); disp(); break;
			case 8 : n1.dispMenu(); break;
			}	
	} // end try

		catch (Exception e)
		{
		}
	}// end disp

   	public void totalmoney() // ������ ����
	{	
		System.out.printf("���� ������ %d�� �Դϴ�\n",getTot());
		System.out.printf("�Ƹ޸�ī���� �Ǹŷ��� %d \n",getAmericanoSale());
		System.out.printf("ī����� �Ǹŷ��� %d \n",getLatteSale());
		System.out.printf("ī���ī�� �Ǹŷ��� %d \n",getMochaSale());
		System.out.printf("���̽�Ƽ�� �Ǹŷ��� %d \n",getIceteaSale());
		System.out.printf("���ݷ��� �Ǹŷ��� %d \n",getChocolateSale());
		System.out.printf("��׷����� �Ǹŷ��� %d \n",getEarlgreySale());
		System.out.printf("ī���� �Ǹŷ��� %d \n",getCassSale());
		System.out.printf("����Ʈ�� �Ǹŷ��� %d \n",getHiteSale());
		System.out.printf("��׽��� �Ǹŷ��� %d \n",getGuinessSale());
		System.out.printf("���̳����� �Ǹŷ��� %d \n",getHeinekenSale());
		System.out.printf("�׶��� �Ǹŷ��� %d \n",getTerraSale());
	} // end totalmoney


	//���� ������ ���Ͽ� ����
	@SuppressWarnings("unchecked") // ���� ó��
	public void out() throws Exception
	{
		Cafe ca = new Cafe();
		Beer be = new Beer();
		//Ķ���� Ŭ���� ��� �ν��Ͻ� ����
		Calendar c = Calendar.getInstance();

		//������ ����, ��, ��¥
		int y = (c.get(Calendar.YEAR)); 
		int m = (c.get(Calendar.MONTH)+1);
		int d = (c.get(Calendar.DATE));
		//����, ��, ��¥ ���ļ� ���ڿ��� ��ȯ
		String today = Integer.toString(y) + "-" + Integer.toString(m) + "-" +Integer.toString(d);
	
		//��� ã��
		String appDir = System.getProperty("user.dir");

		//�ش� ��ο� list������ list.txt���� ����
		File list = new File(appDir, "\\list\\list.txt");

		
		//������ �������� �ʴ´ٸ� ����
		if(!list.getParentFile().exists())
			list.getParentFile().mkdirs();


		//�Է¼���� ����ϱ� ���� LinkedHashMap ���
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		

		//map�� �� �����ϱ�
		map.put(today, tot);
		map.put("�Ƹ޸�ī�� �Ǹŷ� :", getAmericanoSale());
		map.put("���̽�Ƽ �Ǹŷ� :", getIceteaSale());
		map.put("ī��� �Ǹŷ� :", getLatteSale());
		map.put("ī���ī �Ǹŷ� :", getMochaSale());
		map.put("��׷��� �Ǹŷ� :", getEarlgreySale());
		map.put("���ݷ� �Ǹŷ� :", getChocolateSale());
		map.put("ī�� �Ǹŷ� :", getCassSale());
		map.put("����Ʈ �Ǹŷ� :", getHiteSale());
		map.put("��׽� �Ǹŷ� :", getGuinessSale());
		map.put("���̳��� �Ǹŷ� :", getHeinekenSale());
		map.put("�׶� �Ǹŷ� :", getTerraSale());

		//���� ����
		FileOutputStream fos = new FileOutputStream(list);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		oos.writeObject(map);
		oos.close();
		fos.close();

		//������ ���� �о�ͼ� Ȯ���ϱ�
		//���� �ش� ������ �����Ѵٸ�
		if (list.exists())
		{
				FileInputStream fis = new FileInputStream(list);
				ObjectInputStream ois = new ObjectInputStream(fis);

				Map map2 = (LinkedHashMap)ois.readObject();
		
				fis.close(); // InputStream ����
				ois.close(); // ObjectInputStream ����

				//�ش� ���� ���� ���
				Set<String> set = map2.keySet();
				Iterator<String> it = set.iterator();

				while(it.hasNext())
				{
					String key = ((String)it.next());
					int value = ((Integer)map2.get(key));

					System.out.println(key + "  ->  " + value);
				}

		} //end if

	} // end out


	public void stock()  // ��� ����
	{   
		Mainmachine n1=new Mainmachine();
	try
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("\t<���� ���>");
		System.out.println("���\t\t\t���");
		
		System.out.printf("1.����\t\t\t%d\n",bean);
		System.out.printf("2.��\t\t\t%d\n",water);
		System.out.printf("3.���ڽ÷�\t\t%d\n",chocosyrup);
		System.out.printf("4.�÷�\t\t\t%d\n",syrup);
		System.out.printf("5.����\t\t\t%d\n",milk);
		System.out.printf("6.����ũ��\t\t%d\n",whipping);
		System.out.printf("7.ī��\t\t\t%d\n",cass);
		System.out.printf("8.����Ʈ\t\t%d\n",hite);
		System.out.printf("9.�׶�\t\t\t%d\n",terra);
		System.out.printf("10.���̳���\t\t%d\n",heineken);
		System.out.printf("11.��׽�\t\t%d\n",guiness);
		System.out.printf("12.��\t\t\t%d\n",stockCup);
		System.out.printf("13.Ƽ��\t\t\t%d\n",teabag);
		System.out.printf("14.���ھư���\t\t%d\n",cocoa);
		System.out.printf("15.���̽�Ƽ\t\t%d\n",icetea);
		
		System.out.println("��� �߰��Ͻðڽ��ϱ�? (Y/N)");
		String ch = sc.next();

		if (ch.equals("y") || ch.equals("Y")) // ��Ḧ �߰��Ѵٸ�        
        {
		  System.out.print("��� ä�� ���� ǰ���� ��ȣ�� �Է��ϼ��� : ");
		  int num = sc.nextInt();
          System.out.print("ä�� ���� ����� ���� �Է��ϼ��� : ");
		  int add = sc.nextInt();
		  
		  	switch (num)
			{
				case 1 : bean= bean+add; System.out.println("�߰� �Ǿ����ϴ�!"); break; 
				case 2 : setWater(getWater() + add); System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 3 : chocosyrup += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 4 : syrup += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 5 : milk += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 6 : whipping += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 7 : cass += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 8 : hite += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 9 : terra += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 10 : heineken += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 11 : guiness += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 12 : stockCup += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 13 : teabag += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 14 : cocoa += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				case 15 : icetea += add; System.out.println("�߰� �Ǿ����ϴ�!"); break;
				default : System.out.println("�ٽ� �õ����ּ���"); 
			
			}
		
         }
    	else if (ch.equals("n") || ch.equals("N"))
			{
				disp();
			}
		}
		catch (Exception e)
		{
		}
	
		
	}// end stock()

	public void change() throws Exception  // �Ž����� ����
	{
		
		Scanner sc = new Scanner(System.in);

		System.out.println("\t<���� �Ž�����>");
		System.out.println("ȭ��\t\t\t��(��)��");
		
		System.out.printf("1.5000��\t\t%d\n",chunwon5);
		System.out.printf("2.1000��\t\t%d\n",chunwon1);
		System.out.printf("3.500��\t\t\t%d\n",bakwon5);
		System.out.printf("4.100��\t\t\t%d\n",bakwon1);

		System.out.println("ȭ��ż��� �߰��Ͻðڽ��ϱ�? (Y/N)");
		String ch = sc.next();
		
		if (ch.equals("y") || ch.equals("Y")) // �߰��Ѵٸ�
        {
		  System.out.print("ȭ��ǰ���� ��ȣ�� �Է��ϼ��� : ");
		  setStockType(sc.nextInt());
          System.out.print("ȭ��ż��� �Է��ϼ��� : ");
		  setStockNum(sc.nextInt()); 

		 switch (stockType)
        {
        case 1 : chunwon5 += stockNum; System.out.println("�߰� �Ǿ����ϴ�!"); break;
        case 2 : chunwon1 += stockNum; System.out.println("�߰� �Ǿ����ϴ�!"); break;
        case 3 : bakwon5 += stockNum; System.out.println("�߰� �Ǿ����ϴ�!"); break;
        case 4 : bakwon1 += stockNum; System.out.println("�߰� �Ǿ����ϴ�!"); break;
        default : System.out.println("�ٽ� �õ����ּ���"); 
        }
			  
		 }
        else if (ch.equals("n") || ch.equals("N")) // �߰� ���Ѵٸ�
        {
		  disp(); // ������ �޴��� ���ư���
		}
		
		
	} // end change

	public void reprice() throws Exception// ���� �缳��
	{
		Scanner sc = new Scanner(System.in);
		 Mprice mp = new Mprice();
		System.out.print("������ �缳���� �޴��� ��ȣ�� �Է����ּ��� : ");
        int choice = sc.nextInt(); // �缳���� �޴� ����
        
		System.out.print("������ ������ �Է��� �ּ��� : ");
		int price = sc.nextInt();  // �缳���� ���� �Է�

        switch (choice)
        {
        case 1 : mp.americano = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 2 : mp.icetea = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 3 : mp.latte = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 4 : mp.mocha = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 5 : mp.earlgrey = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 6 : mp.chocolate = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 7 : mp.addshot = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 8 : mp.addsyrup = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 9 : mp.addwhip = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 10 : mp.addbub = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 11 : mp.cass = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 12 : mp.hite = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 13 : mp.terra = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 14 : mp.guiness = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        case 15 : mp.heineken = price; System.out.println("�缳�� �Ǿ����ϴ�!"); break;
        default : System.out.println("�ٽ� �õ����ּ���"); 
        }
	} // end reprice

	
	public  void repass()		//������ ��й�ȣ ����
	{
		//Mainmachine n1 = new Mainmachine();
		Scanner sc = new Scanner(System.in);
		int npass,pass,nnpass;
		System.out.print("���� ��й�ȣ�� �Է����ּ��� : ");
		pass=sc.nextInt();
		if(pass==getownerPass()) // ���� ��й�ȣ�� �Է��� ��й�ȣ�� ��ġ�Ѵٸ�
		{
			System.out.print("�����Ͻ� ��й�ȣ�� �Է����ּ��� : "); 
			npass=sc.nextInt();
			

			System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���!");
			nnpass=sc.nextInt();
			
			if (npass==nnpass) // ������ ��й�ȣ�� ���Է��� ��й�ȣ�� ���ٸ�
			{
				setownerPass(npass);
				System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�");
			}
			else
			{
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			}
		}
		
		else
		{
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			//n1.dispMenu();
		}
		
		
	} // end repass


	public void reboot2() // ����� 2   ==>> ���α׷��� ���۵Ǿ����� ������ ������ ������ �ѹ� ��ġ�ϸ�
	{					  //				 ���۽ð��� ������ ����.
		
		int a=1;

		if(a==1){

		startTime = time.currentDateTime(); // ���Ǳ� �������۽ð� ����

		}
		else{
	
			currentTime = time.currentDateTime();
			System.out.println(time.diffDateTime(startTime, currentTime));
			System.exit(1);
		}

	} // end reboot2

	public void reboot3() //��ŸƮ Ÿ�� �������� �ð������ ==>> 5�� ���ð�(������) Ȯ�κκ�
	{	
		currentTime = time.currentDateTime();	//����ð��� time.currentDateTime()���� �����Ŵ
		
		int s; //	Y/N�� �Է��� ����.
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------\n");
        System.out.println("���Ǳ� ���� : On");
        System.out.println("���Ǳ� On �ð� : " + startTime);
        System.out.println("���� �ð� : " + currentTime);
        System.out.println("���Ǳ� �۵� �ð�(��) : " + time.diffDateTime(startTime,currentTime)+"��");
	    System.out.println("���� ����Ȯ�� : " + failureRate() +"%");
		System.out.println("------------------------------\n");
	    System.out.println();	
		
	} // end reboot3

	public void reboot4()	//6�� ����� ���ۿ� �ش��ϴ� �κ�
	{	
	    
		currentTime = time.currentDateTime(); // ����ð� ����

	try
	{
		System.out.println("------------------------------\n");
        System.out.println("���Ǳ� ���� : On");
        System.out.println("���Ǳ� On �ð� : " + startTime);
        System.out.println("���� �ð� : " + currentTime);
        System.out.println("���Ǳ� �۵� �ð�(��) : " + time.diffDateTime(startTime,currentTime)+"��");
	    System.out.println("���� ����Ȯ�� : " + failureRate() +"%");
	    System.out.println();
		System.out.println("����� �ϰڽ��ϴ�~!!!");

			System.out.print("����� ���Դϴ�");

   		    Thread.sleep(500);

		    for(int i=0; i<10; i++) 
				{

					System.out.print(".");

					Thread.sleep(500);
				}
			System.out.println();

	} // end try
	catch(Exception e)
	{
	     System.out.println("[Error] �޽����� Ȯ���ϼ���.");

         System.out.println(e);
	}

		// ������� ���� �ʱ�ȭ ���ִ� �κ�
		int repairCharge = failureRate();
		repairChargeSum += failureRate();
		startTime = time.currentDateTime();
		System.out.println("\n- ������� �Ϸ�Ǿ����ϴ�.");
		System.out.println("- ������� ����� : " + failureRate() +"%");
	} // end reboot4

	public int failureRate()	// ������ ����ϴ� �κ�
	{
		currentTime = time.currentDateTime(); // ����ð� ����

		int failureRate =((int) time.diffDateTime(startTime, currentTime)/10);
		if(failureRate<100) {
			return failureRate;
		}
		return 100;
	} // end failureRate 


 } // end Admin

