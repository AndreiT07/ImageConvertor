//clasa abstracta
//din aceasta se mostenesc inca 2 clase
package packWork;

abstract public  class AbstractImage {
	protected static String name;
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		AbstractImage.name = name;
	}
	public void imageName(){//metoda implementata
		System.out.println("Image name: "+name);
	}
	abstract public void size();//metoda abstracta care va fi implementat in clasa care se 
								//va mosteni
}
