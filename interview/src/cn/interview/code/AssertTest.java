package cn.interview.code;

/**
 * 
 * 1.eclipse、myeclipse开启assert(断言)，默认是关闭，如下：
 * 说白了就是设置一下jvm的参数，参数是-ea或者-enableassertions
 * run->run configuration -> Argument -> Jvm 添加-enableassertions
 * @author 	30456
 * @date 	2018年10月11日
 * @Copyright zhanjiang Lai Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * 30456			2018年10月11日			新增
 *
 * </pre>
 */
public class AssertTest {

	public static void main(String[] args) {
		int i = 0;
		for (i = 0; i < 5; i++) {
			System.out.println(i);
		}
		//假设程序不小心多了一句--i,实际不应该多的,触发断言
		--i;
		assert i==5;
	}
}
