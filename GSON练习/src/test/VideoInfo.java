package test;

public class VideoInfo {
	private int media_type;
	private boolean has_dash_audio;
	private boolean is_completed;
	private int total_bytes;
	private int downloaded_bytes;
	
	
	private String title;
	private String type_tag;
	private String cover;
	private int video_quality;
	private int prefered_video_quality;
	private int guessed_total_bytes;
	private int total_time_milli;
	private int danmaku_count;
	private long time_update_stamp;
	private long time_create_stamp;
	private boolean can_play_in_advance;
	private boolean interrupt_transform_temp_file;
	private String quality_pithy_description;
	private String quality_superscript;
	private int cache_version_code;
	
	
	private int avid;
	private int spid;
	private int seasion_id;
	private String bvid;
	private int owner_id;
	private Page_data page_data;
	private Source source;
	private Ep ep;
	
	
	public int getMedia_type() {
		return media_type;
	}
	public void setMedia_type(int media_type) {
		this.media_type = media_type;
	}
	public boolean isHas_dash_audio() {
		return has_dash_audio;
	}
	public void setHas_dash_audio(boolean has_dash_audio) {
		this.has_dash_audio = has_dash_audio;
	}
	public boolean isIs_completed() {
		return is_completed;
	}
	public void setIs_completed(boolean is_completed) {
		this.is_completed = is_completed;
	}
	public int getTotal_bytes() {
		return total_bytes;
	}
	public void setTotal_bytes(int total_bytes) {
		this.total_bytes = total_bytes;
	}
	public int getDownloaded_bytes() {
		return downloaded_bytes;
	}
	public void setDownloaded_bytes(int downloaded_bytes) {
		this.downloaded_bytes = downloaded_bytes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType_tag() {
		return type_tag;
	}
	public void setType_tag(String type_tag) {
		this.type_tag = type_tag;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getPrefered_video_quality() {
		return prefered_video_quality;
	}
	public void setPrefered_video_quality(int prefered_video_quality) {
		this.prefered_video_quality = prefered_video_quality;
	}
	public int getGuessed_total_bytes() {
		return guessed_total_bytes;
	}
	public void setGuessed_total_bytes(int guessed_total_bytes) {
		this.guessed_total_bytes = guessed_total_bytes;
	}
	public int getTotal_time_milli() {
		return total_time_milli;
	}
	public void setTotal_time_milli(int total_time_milli) {
		this.total_time_milli = total_time_milli;
	}
	public int getDanmaku_count() {
		return danmaku_count;
	}
	public void setDanmaku_count(int danmaku_count) {
		this.danmaku_count = danmaku_count;
	}
	public long getTime_update_stamp() {
		return time_update_stamp;
	}
	public void setTime_update_stamp(long time_update_stamp) {
		this.time_update_stamp = time_update_stamp;
	}
	public long getTime_create_stamp() {
		return time_create_stamp;
	}
	public void setTime_create_stamp(long time_create_stamp) {
		this.time_create_stamp = time_create_stamp;
	}
	public boolean isCan_play_in_advance() {
		return can_play_in_advance;
	}
	public void setCan_play_in_advance(boolean can_play_in_advance) {
		this.can_play_in_advance = can_play_in_advance;
	}
	public boolean isInterrupt_transform_temp_file() {
		return interrupt_transform_temp_file;
	}
	public void setInterrupt_transform_temp_file(boolean interrupt_transform_temp_file) {
		this.interrupt_transform_temp_file = interrupt_transform_temp_file;
	}
	public String getQuality_pithy_description() {
		return quality_pithy_description;
	}
	public void setQuality_pithy_description(String quality_pithy_description) {
		this.quality_pithy_description = quality_pithy_description;
	}
	public String getQuality_superscript() {
		return quality_superscript;
	}
	public void setQuality_superscript(String quality_superscript) {
		this.quality_superscript = quality_superscript;
	}
	public int getCache_version_code() {
		return cache_version_code;
	}
	public void setCache_version_code(int cache_version_code) {
		this.cache_version_code = cache_version_code;
	}
	public int getAvid() {
		return avid;
	}
	public void setAvid(int avid) {
		this.avid = avid;
	}
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public int getSeasion_id() {
		return seasion_id;
	}
	public void setSeasion_id(int seasion_id) {
		this.seasion_id = seasion_id;
	}
	public String getBvid() {
		return bvid;
	}
	public void setBvid(String bvid) {
		this.bvid = bvid;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public Page_data getPage_data() {
		return page_data;
	}
	public void setPage_data(Page_data page_data) {
		this.page_data = page_data;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Ep getEp() {
		return ep;
	}
	public void setEp(Ep ep) {
		this.ep = ep;
	}
	@Override
	public String toString() {
		return "VideoInfo [media_type=" + media_type + ", has_dash_audio=" + has_dash_audio + ", is_completed="
				+ is_completed + ", total_bytes=" + total_bytes + ", downloaded_bytes=" + downloaded_bytes + ", title="
				+ title + ", type_tag=" + type_tag + ", cover=" + cover + ", video_quality=" + video_quality
				+ ", prefered_video_quality=" + prefered_video_quality + ", guessed_total_bytes=" + guessed_total_bytes
				+ ", total_time_milli=" + total_time_milli + ", danmaku_count=" + danmaku_count + ", time_update_stamp="
				+ time_update_stamp + ", time_create_stamp=" + time_create_stamp + ", can_play_in_advance="
				+ can_play_in_advance + ", interrupt_transform_temp_file=" + interrupt_transform_temp_file
				+ ", quality_pithy_description=" + quality_pithy_description + ", quality_superscript="
				+ quality_superscript + ", cache_version_code=" + cache_version_code + ", avid=" + avid + ", spid="
				+ spid + ", seasion_id=" + seasion_id + ", bvid=" + bvid + ", owner_id=" + owner_id + ", page_data="
				+ page_data + "]";
	}
	
	

}
