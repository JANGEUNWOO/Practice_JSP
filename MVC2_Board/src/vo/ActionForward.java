package vo;

//이동경로를 확인하고 지정해 주는 클래스
public class ActionForward {
	
	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}	
	public void setRedirect(boolean b){
		isRedirect = b;
	}	
	public void setPath(String string){
		path = string;
	}
}