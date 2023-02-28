//prima clasa care se mosteneste din clasa abstracta
package packWork;

public class Image extends AbstractImage{
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Image(){
		AbstractImage.setName("");
		width = 0;
		height = 0;
	}
	public Image(String name, int width, int height){
		setName(name);
		this.height = height;
		this.width = width;
	}
	
	
	@Override
	public void size() {//implementarea metodei care se mosteneste din clasa abstracta
		// TODO Auto-generated method stub
		System.out.println("Imaginea originala are width: "+getWidth()+", height: "+getHeight());
	}

}
