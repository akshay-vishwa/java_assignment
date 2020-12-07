package student;

class students {
   private int id;
   private String name;
   private int clas;
   
   students(int id,String name,int clas){
	   this.id=id;
	   this.name=name;
	   this.clas=clas;
   }
   
   public void display() {
	   System.out.println(id+" "+name+" "+clas);
   }
}
