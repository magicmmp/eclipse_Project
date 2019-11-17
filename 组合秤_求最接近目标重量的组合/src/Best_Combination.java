import java.util.Random;

public class Best_Combination 
{
	static int dp_array_length=1000;
	static int dp_array[]=new int[dp_array_length];
	
	
	static int   nHoppers;//有几个斗
	static float weights[];//每个斗的重量
	static float target_weight;//目标重量
	static float target_weight_min;//目标重量下限
	static float target_weight_max;//目标重量上限
	
	
	//根据斗数和目标重量，给斗初始化一个重量值
	public static void init_hopper_weights(float weights[] ,int nHopper,float target_weight)
	{
		int i;
		float D_ratio=(float)0.5;
		//期望参与组合的斗是总斗数的三分一
		//由此得出每个斗应该初始化的重量
		float hopper_weight=target_weight*3/nHopper;
		float D_value=hopper_weight*D_ratio;//斗初始化重量的上限偏差
		for(i=0;i<nHopper;i++)		
		{
			Random random = new Random();
			float f=random.nextFloat();//产生0到1之间均匀分布的小数
			weights[i]=hopper_weight-D_value+D_value*2*f;
		}
	}
	
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		nHoppers=15;//有几个斗
		weights=new float[nHoppers];//每个斗的重量
		target_weight=100;//目标重量
		target_weight_min=95;//目标重量下限
		target_weight_max=105;//目标重量上限
		
		init_hopper_weights(weights,nHoppers,target_weight);
		
		for(int i=0;i<weights.length;i++)
			System.out.print(weights[i]+" ");
		
		
		
		
		

	}

}
