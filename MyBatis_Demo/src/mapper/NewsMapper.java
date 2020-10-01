package mapper;

public interface NewsMapper {
	public int saveNews(News news);
	public int updateNews(News news);
	public int deleteNews(int a);
	public News getNews(int id);
	
}