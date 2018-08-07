package com.myj.dvdmanage;


import java.util.Date;
import java.util.Scanner;

public class DVD {
	
	private int dvdNum;
	private String status;
	private String dvdName;
	private int times;
	private String loanDate;
	private String backDate;
	
	public DVD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DVD(int dvdNum, String status, String dvdName, int times,
			String loanDate, String backDate) {
		super();
		this.dvdNum = dvdNum;
		this.status = status;
		this.dvdName = dvdName;
		this.times = times;
		this.loanDate = loanDate;
		this.backDate = backDate;
	}
	
	public int getDvdNum() {
		return dvdNum;
	}
	public void setDvdNum(int dvdNum) {
		this.dvdNum = dvdNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	
	@Override
	public String toString() {
		return "DVD [dvdNum=" + dvdNum + ", status=" + status + ", dvdName="
				+ dvdName + ", times=" + times + ", loanDate=" + loanDate
				+ ", backDate=" + backDate + "]";
	}
	

}
class DVDManage {
	
	Scanner input = new Scanner(System.in);
	DVD[] dvds = new DVD[6];
	DVD dvd = new DVD();
	
	public void init(){
		
		//��ʼ��
		dvds[0] = new DVD(1,"�ɽ�","�ӱܿɳܵ�����",23,null,null);
		dvds[1] = new DVD(2,"�ѽ��","��ܾ��ع�",46,"2018-07-23", null);
		dvds[2] = new DVD(3,"�ѽ��","����",26,"2018-07-25", null);
		dvds[3] = new DVD(4,"�ɽ�","�ź�",19,null,null);
		
	}
	
	//DVD�˵�
	public void dvdMune(){
		
		String goback = null;
		Scanner input = new Scanner(System.in);
		
		
		do{
			
			//DVD��������
			int[] no = {0,1,2,3,4,5,6,7};
			String[] action = {"","����","�鿴","����","ɾ��","���","�黹","�˳�"} ;
			System.out.println("��ӭʹ������DVD������");
			System.out.println("-----------------------------");
			for(int i=1;i<=7;i++){
				System.out.println(no[i]+"��"+action[i]+"DVD");
			}
			System.out.println("-----------------------------\n");
			
			//ѡ����һ������
			int option;
			System.out.print("��ѡ��");
			
			//���֧ѡ��switch
			if(input.hasNextInt()){
				option = input.nextInt();
				switch(option){
					case 1:		//����DVD
						addDVD();
						break;
					case 2:		//�鿴DVD
						showAllDVD();
						break;
					case 3:		//����DVD
						dvdRank();
						break;
					case 4:		//ɾ��DVD
						delDVD();
						break;
					case 5:		//���DVD
						loanDVD();
						break;
					case 6:		//�黹DVD
						backDVD();
						break;
					case 7:		//�˳�DVD
						System.out.println("ллʹ��!");
						System.exit(0);
					default:
						System.out.println("ָ���޷�����!");
						break;
				}
			}else{
				System.out.println("ָ���޷�����!");
			}
			
			//����0����
			System.out.println("****************************************\n");
			System.out.print("������0������ҳ��");
			goback = input.next();
			
		}while(goback.equals("0"));
		
		System.out.println("���������������!");
		
	}
	
	//����DVD
	public void addDVD(){
		
		System.out.println("----->����DVD");
		System.out.println("����������DVD�����֣�");
		String newDVDName = input.next();
		dvd.setDvdName(newDVDName);
		boolean flag1 = false;
		for(int i=0;i<dvds.length;i++){		//�ҵ�����������ݵĿ�λ
			if(dvds[i]==null){
				dvds[i] = new DVD(i+1,"�ɽ�",newDVDName,0,null,null); //����dvd���� ��i��λ��
				flag1 = true;
				System.out.println("���"+"��"+newDVDName+"��"+"�ɹ�!");
				break;
			}
		}				
		if(flag1==false){
			System.out.println("����ʧ��:��������!");
		}
		
	}
	
	//�鿴DVD
	public void showAllDVD(){
		System.out.println("----->�鿴DVD");
		System.out.println("DVD���"+"\t"+"���״̬"+"\t"+"DVD����"+"\t\t"+"�������"+"\t"+"�������"+"\t\t"+"�黹����");
		for(int i=0;i<dvds.length;i++){
			if(dvds[i]!=null){
				System.out.println(dvds[i].getDvdNum()+"\t"+dvds[i].getStatus()+"\t"+dvds[i].getDvdName()+"\t\t"+dvds[i].getTimes()+"\t"+dvds[i].getLoanDate()+"\t\t"+dvds[i].getBackDate());
			}
		}
	}
	
	//DVD����
	public void dvdRank(){
		
		for(int i=0;i<=dvds.length-1;i++){
			for(int j=0;j<dvds.length-1-i;j++){
				if((dvds[j]!=null && dvds[j+1]!=null) && (dvds[j].getTimes()<dvds[j+1].getTimes())){
					DVD temp = dvds[j];
					dvds[j] = dvds[j+1];
					dvds[j+1] = temp;
				}
			}
		}
		showAllDVD();
	}
	
	//ɾ��DVD
	public void delDVD(){
		
		System.out.println("----->ɾ��DVD");
		System.out.println("������Ҫɾ����DVD����:");
		String delDVD=input.next();
		boolean flag = false;
		int index = -1;
		for(int i=0;i<dvds.length;i++){
			if(dvds[i].getDvdName()!=null && delDVD.equals(dvds[i].getDvdName())){	//�ҵ���DVD
				if(dvds[i].getStatus().equals("�ɽ�")){
					System.out.println("����ɾ��:"+delDVD+"!��ȷ����?(����y����ɾ��,�����ȡ��):");
					String reconf = input.next();
					if(reconf.equalsIgnoreCase("y")){							//����Ƕ��if,�Ҿ������в�
						flag = true;
						index = i;
						if(flag == true){
							for(int j=index;j<dvds.length-1;j++){	//����Ԫ�ؽ�ǰ��Ԫ�����θ���
								dvds[j] = dvds[j+1];
							}
							if(dvds[dvds.length-1]!=null){	//��ĩβ��Ϊ��,������Ϊ��
								dvds[dvds.length-1]=null;
							}
							System.out.println("ɾ��"+"��"+delDVD+"��"+"�ɹ�!");
						}else{
							System.out.println("ɾ��ʧ�ܣ�δ�ҵ���Ҫɾ����DVD!");
						}
					}else{
						System.out.println("ɾ��������ȡ��!");
					}
				}else{
					System.out.println("��DVD�ѽ��,����ɾ��!");
				}
				break;	//����break,forѭ�������ƥ��dvdname,��ɿ�ָ���쳣
			}
		}
		
		
	}
	
	//���DVD
	public void loanDVD(){
		
		System.out.println("----->���DVD");
		System.out.println("������Ҫ�����DVD����:");
		String loanDVD=input.next();
		try{
			for(int i=0;i<dvds.length;i++){
				if(loanDVD.equals(dvds[i].getDvdName())){	//�ж��Ƿ���ڸ�dvd
					if(dvds[i].getStatus().equals("�ɽ�")){	//�жϵ�ǰ���״̬
						System.out.println("�ѳɹ����"+loanDVD+",���Ϊ0.1Ԫ/��");
						dvds[i].setStatus("�ѽ��");
						dvds[i].setTimes(dvds[i].getTimes()+1);
						String loanDate = DVDDate.dateToString(new Date());
						dvds[i].setLoanDate(loanDate);
						break;
					}else{
						System.out.println("��DVD�ѽ��!�����ظ���ȡ!");
					}
				}
			}
		}catch(Exception e){
			System.out.println("δ�ҵ��������dvd!");
		}
		//System.out.println("δ�ҵ��������dvd!");	
	}
	
	//�黹DVD
	public void backDVD(){
		
		System.out.println("----->�黹DVD");
		System.out.println("������Ҫ�黹��DVD����:");
		String backDVD=input.next();
		try{
			for(int i=0;i<dvds.length;i++){
				if(backDVD.equals(dvds[i].getDvdName())){	//�ж��Ƿ���ڸ�dvd
					if(dvds[i].getStatus().equals("�ѽ��")){	//�жϹ黹ʱ�Ľ��״̬
						
						//�������
						Date loanTime = DVDDate.stringToDate(dvds[i].getLoanDate());
						Date backTime = new Date();	//���黹ʱ����Ϊ��ǰʱ��
						int day = DVDDate.timeInterval(loanTime, backTime);
						//double rent = day*0.1;
						
						System.out.println("�ѳɹ��黹"+backDVD+",���Ϊ"+day+"Ԫ");
						dvds[i].setStatus("�ɽ�");
						dvds[i].setLoanDate(null);
						String backDate = DVDDate.dateToString(new Date());
						dvds[i].setBackDate(backDate);
						break;
					}else{
						System.out.println("��DVDδ�����!���ɹ黹!");
					}
				}
			}
		}catch(Exception e){
			System.out.println("δ�ҵ��������dvd!");
		}
		
	}
	
	
	
}

