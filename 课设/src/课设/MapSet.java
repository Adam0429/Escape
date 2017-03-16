package 课设;

public class MapSet {								//这个mapset不行，还是会溢出,放弃这个方法
	public static Map Current;
	public static Map map1303;
	public static Map mapCorridor1;
	public static Map mapCorridor2;
	public MapSet(MainFrame mf,hero h){
		map1303=new Map1303(mf,h);
		mapCorridor1=new MapCorridor1(mf,h);
		mapCorridor2=new MapCorridor2(mf,h);
	}
}
