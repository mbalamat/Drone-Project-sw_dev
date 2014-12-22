package tasks;

public class PhotoShoot implements iBBox {
	private int normalPhotos=0;
	private int irPhotos=0;
	private int video=0;
	
	public void shootRphoto(){
		normalPhotos+=1;
		bbx.logActivity("Normal Photo Taken");
	}
	
	public void shootIRphoto(){
		irPhotos+=1;
		bbx.logActivity("IR Photo Taken");
	}
	
	public void shootVideo(){
		video+=1;
		bbx.logActivity("Video Taken");
	}
	
	public void getAll(){
		System.out.println(normalPhotos);
		System.out.println(irPhotos);
		System.out.println(video);
		bbx.logActivity("Photos Taken");
	}
	
	//testing
	
//	public static void main(String args[]){
//		PhotoShoot ph = new PhotoShoot();
//		ph.shootIRphoto();
//		ph.shootIRphoto();
//		ph.shootIRphoto();
//		ph.shootRphoto();
//		ph.shootRphoto();
//		ph.shootRphoto();
//		ph.getAll();
//		ph.shootVideo();
//		ph.shootVideo();
//		ph.shootVideo();
//		ph.shootVideo();
//		ph.shootVideo();
//		ph.shootVideo();
//		ph.getAll();
//	}
}