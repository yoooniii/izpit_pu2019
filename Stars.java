package izpit_pu2019;

import java.util.Scanner;

public class Stars {
	private String name="", cons="";
	private double dist, mass;//razstoqnie i masa
	private int clas;//klasifikaciq
	public Stars(String name, String cons, double dist, double mass, int clas) {
		this.name = name;
		this.cons = cons;
		this.dist = dist;
		this.mass = mass;
		this.clas = clas;
	}
	public void inp() {
		Scanner in=new Scanner(System.in);
		System.out.print("Star: ");
		name=in.nextLine();
		System.out.print("Constilation: ");
		cons=in.nextLine();
		System.out.print("Distance: ");
		dist=in.nextDouble();
		System.out.print("Mass: ");
		mass=in.nextDouble();
		System.out.print("Classification (1=хипергиганти,\r\n"
				+ "2=свръхгиганти, 3=ярки гиганти, 4=гиганти, 5=субгиганти, 6=джуджета,\r\n"
				+ "7=субджуджета, 8=червени джуджета, 9=кафяви джуджета): ");
		clas=in.nextInt();
		in.nextLine();
		in.close();
	}
	
	public Stars() {//prazen konstryktor za prazna zvezda
		this("","",0,0,0);//povikvame definiran konstruktor v drug konstruktor (nulira dannite ot drugiq(mai));THIS konstruktor suzdai go po THIS nachin
	}
	
	public static String classif(int clas) {  //statichen metod
		switch(clas) {
		case 1: return "хипергигант";
		case 2: return "свръхгигант";
		case 3: return "ярки гигант";
		case 4: return "гигант";
		case 5: return "субгигант";
		case 6: return "джудже";
		case 7: return "субджудже";
		case 8: return "червенo джудже";
		case 9: return "кафявo джудже";
		} return "";
	}
	public String classif() { //dinamichen metod
		return classif(this.clas); 
	}
	@Override
	public String toString() {
		return  name + ", " +Double.toString(dist).replace(',', '.') + "св.г., "+
	           classif(clas)+" "+Double.toString(mass).replace(',', '.') + "сл.м., "+ cons;
	}
	public int compare1(Stars s) {
		if (this.dist<s.dist) return -1;
		if (this.dist>s.dist) return 1;
		return 0;
	}
    public int compare2(Stars s) {
    	int t=this.cons.compareTo(s.cons);//sravnqvame tekushtiq obekt s parametura mu
    	if (t!=0) return t;
    	if (this.mass<s.mass) return 1;
		if (this.mass>s.mass) return -1;
		return 0;
	}
}
