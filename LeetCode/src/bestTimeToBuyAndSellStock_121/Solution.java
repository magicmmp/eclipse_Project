package bestTimeToBuyAndSellStock_121;

public class Solution {
	
	public int maxProfit(int[] prices) 
	{
		int max=0;
		//��¼����i��Ϊֹ�����ֵĹ�Ʊ��ͼ�
		int minPrice=Integer.MAX_VALUE;
		int tmp;
		for(int i=0;i<prices.length;i++)
		{
			if(prices[i]<minPrice)
				minPrice=prices[i];
			tmp=prices[i]-minPrice;
			if(tmp>max)
				max=tmp;
		}		
		return max;		
    }

}
