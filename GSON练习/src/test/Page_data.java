package test;

public class Page_data {
	private int cid;
	private int page;
	private String from;
	private String part;
	private String link;
	private String vid;
	private boolean has_alias;
	private int tid;
	private int width;
	private int height;
	private int rotate;
	private String download_title;
	private String download_subtitle;
	
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public boolean isHas_alias() {
		return has_alias;
	}
	public void setHas_alias(boolean has_alias) {
		this.has_alias = has_alias;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
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
	public int getRotate() {
		return rotate;
	}
	public void setRotate(int rotate) {
		this.rotate = rotate;
	}
	public String getDownload_title() {
		return download_title;
	}
	public void setDownload_title(String download_title) {
		this.download_title = download_title;
	}
	public String getDownload_subtitle() {
		return download_subtitle;
	}
	public void setDownload_subtitle(String download_subtitle) {
		this.download_subtitle = download_subtitle;
	}
	@Override
	public String toString() {
		return "Page_data [cid=" + cid + ", page=" + page + ", from=" + from + ", part=" + part + ", link=" + link
				+ ", vid=" + vid + ", has_alias=" + has_alias + ", tid=" + tid + ", width=" + width + ", height="
				+ height + ", rotate=" + rotate + ", download_title=" + download_title + ", download_subtitle="
				+ download_subtitle + "]";
	}
	
	

}
