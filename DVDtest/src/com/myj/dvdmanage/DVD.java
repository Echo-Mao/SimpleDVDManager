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
		
		//初始化
		dvds[0] = new DVD(1,"可借","逃避可耻但有用",23,null,null);
		dvds[1] = new DVD(2,"已借出","神盾局特工",46,"2018-07-23", null);
		dvds[2] = new DVD(3,"已借出","铁雨",26,"2018-07-25", null);
		dvds[3] = new DVD(4,"可借","信号",19,null,null);
		
	}
	
	//DVD菜单
	public void dvdMune(){
		
		String goback = null;
		Scanner input = new Scanner(System.in);
		
		
		do{
			
			//DVD界面生成
			int[] no = {0,1,2,3,4,5,6,7};
			String[] action = {"","新增","查看","人气","删除","借出","归还","退出"} ;
			System.out.println("欢迎使用迷你DVD管理器");
			System.out.println("-----------------------------");
			for(int i=1;i<=7;i++){
				System.out.println(no[i]+"、"+action[i]+"DVD");
			}
			System.out.println("-----------------------------\n");
			
			//选择下一步动作
			int option;
			System.out.print("请选择：");
			
			//多分支选择，switch
			if(input.hasNextInt()){
				option = input.nextInt();
				switch(option){
					case 1:		//新增DVD
						addDVD();
						break;
					case 2:		//查看DVD
						showAllDVD();
						break;
					case 3:		//人气DVD
						dvdRank();
						break;
					case 4:		//删除DVD
						delDVD();
						break;
					case 5:		//借出DVD
						loanDVD();
						break;
					case 6:		//归还DVD
						backDVD();
						break;
					case 7:		//退出DVD
						System.out.println("谢谢使用!");
						System.exit(0);
					default:
						System.out.println("指令无法接受!");
						break;
				}
			}else{
				System.out.println("指令无法接受!");
			}
			
			//输入0返回
			System.out.println("****************************************\n");
			System.out.print("请输入0返回首页：");
			goback = input.next();
			
		}while(goback.equals("0"));
		
		System.out.println("您输入的内容有误!");
		
	}
	
	//新增DVD
	public void addDVD(){
		
		System.out.println("----->新增DVD");
		System.out.println("请输入新增DVD的名字：");
		String newDVDName = input.next();
		dvd.setDvdName(newDVDName);
		boolean flag1 = false;
		for(int i=0;i<dvds.length;i++){		//找到可以添加内容的空位
			if(dvds[i]==null){
				dvds[i] = new DVD(i+1,"可借",newDVDName,0,null,null); //保存dvd名到 第i个位置
				flag1 = true;
				System.out.println("添加"+"《"+newDVDName+"》"+"成功!");
				break;
			}
		}				
		if(flag1==false){
			System.out.println("增加失败:货架已满!");
		}
		
	}
	
	//查看DVD
	public void showAllDVD(){
		System.out.println("----->查看DVD");
		System.out.println("DVD编号"+"\t"+"借出状态"+"\t"+"DVD名字"+"\t\t"+"借出次数"+"\t"+"借出日期"+"\t\t"+"归还日期");
		for(int i=0;i<dvds.length;i++){
			if(dvds[i]!=null){
				System.out.println(dvds[i].getDvdNum()+"\t"+dvds[i].getStatus()+"\t"+dvds[i].getDvdName()+"\t\t"+dvds[i].getTimes()+"\t"+dvds[i].getLoanDate()+"\t\t"+dvds[i].getBackDate());
			}
		}
	}
	
	//DVD排行
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
	
	//删除DVD
	public void delDVD(){
		
		System.out.println("----->删除DVD");
		System.out.println("请输入要删除的DVD名称:");
		String delDVD=input.next();
		boolean flag = false;
		int index = -1;
		for(int i=0;i<dvds.length;i++){
			if(dvds[i].getDvdName()!=null && delDVD.equals(dvds[i].getDvdName())){	//找到该DVD
				if(dvds[i].getStatus().equals("可借")){
					System.out.println("即将删除:"+delDVD+"!您确定吗?(输入y继续删除,任意键取消):");
					String reconf = input.next();
					if(reconf.equalsIgnoreCase("y")){							//五连嵌套if,我觉得我有病
						flag = true;
						index = i;
						if(flag == true){
							for(int j=index;j<dvds.length-1;j++){	//后面元素将前面元素依次覆盖
								dvds[j] = dvds[j+1];
							}
							if(dvds[dvds.length-1]!=null){	//若末尾不为空,则将其置为空
								dvds[dvds.length-1]=null;
							}
							System.out.println("删除"+"《"+delDVD+"》"+"成功!");
						}else{
							System.out.println("删除失败：未找到您要删除的DVD!");
						}
					}else{
						System.out.println("删除动作已取消!");
					}
				}else{
					System.out.println("该DVD已借出,不可删除!");
				}
				break;	//不加break,for循环会继续匹配dvdname,造成空指针异常
			}
		}
		
		
	}
	
	//借出DVD
	public void loanDVD(){
		
		System.out.println("----->借出DVD");
		System.out.println("请输入要借出的DVD名称:");
		String loanDVD=input.next();
		try{
			for(int i=0;i<dvds.length;i++){
				if(loanDVD.equals(dvds[i].getDvdName())){	//判断是否存在该dvd
					if(dvds[i].getStatus().equals("可借")){	//判断当前借出状态
						System.out.println("已成功借出"+loanDVD+",租金为0.1元/日");
						dvds[i].setStatus("已借出");
						dvds[i].setTimes(dvds[i].getTimes()+1);
						String loanDate = DVDDate.dateToString(new Date());
						dvds[i].setLoanDate(loanDate);
						break;
					}else{
						System.out.println("该DVD已借出!不可重复借取!");
					}
				}
			}
		}catch(Exception e){
			System.out.println("未找到您输入的dvd!");
		}
		//System.out.println("未找到您输入的dvd!");	
	}
	
	//归还DVD
	public void backDVD(){
		
		System.out.println("----->归还DVD");
		System.out.println("请输入要归还的DVD名称:");
		String backDVD=input.next();
		try{
			for(int i=0;i<dvds.length;i++){
				if(backDVD.equals(dvds[i].getDvdName())){	//判断是否存在该dvd
					if(dvds[i].getStatus().equals("已借出")){	//判断归还时的借出状态
						
						//计算租金
						Date loanTime = DVDDate.stringToDate(dvds[i].getLoanDate());
						Date backTime = new Date();	//将归还时间设为当前时间
						int day = DVDDate.timeInterval(loanTime, backTime);
						//double rent = day*0.1;
						
						System.out.println("已成功归还"+backDVD+",租金为"+day+"元");
						dvds[i].setStatus("可借");
						dvds[i].setLoanDate(null);
						String backDate = DVDDate.dateToString(new Date());
						dvds[i].setBackDate(backDate);
						break;
					}else{
						System.out.println("该DVD未被借出!不可归还!");
					}
				}
			}
		}catch(Exception e){
			System.out.println("未找到您输入的dvd!");
		}
		
	}
	
	
	
}

