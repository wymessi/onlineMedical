package cn.hdu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.po.Doctor;
import cn.hdu.po.Hospital;
import cn.hdu.po.Illness;
import cn.hdu.po.Patient;
import cn.hdu.service.HospitalService;
import cn.hdu.service.IllnessService;
import cn.hdu.service.UserService;

@Controller
public class IndexController {

	/**
	 * 此方法用于从其他页面返回首页
	 * 
	 * @param model
	 *            模型，将数据带到页面
	 * @param session
	 *            会话 存储用户信息
	 * @return 视图名
	 */
	
	@Autowired
	@Qualifier("userService") // 根据名称注入
	private UserService userService;

	@Autowired
	@Qualifier("hospitalService")
	private HospitalService hospitalService;
	
	@Autowired
	@Qualifier("illnessService")
	private IllnessService illnessService;
	
	@RequestMapping("/index.action")
	public String index(Model model, HttpSession session) throws Exception{
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor != null) {
			model.addAttribute("doctor", doctor);
		} else {
			Patient patient = (Patient) session.getAttribute("patient");
			if (patient != null)
				model.addAttribute("patient", patient);
		}
		
		List<Doctor> hotDoctors = userService.findHotDoctors();
		model.addAttribute("hotDoctors", hotDoctors);
		List<Hospital> hotHospitals = hospitalService.findHotHospitals();
		model.addAttribute("hotHospitals", hotHospitals);
		List<Illness> hotIllnesses = illnessService.findHotIllnesses();
		model.addAttribute("hotIllnesses", hotIllnesses);
		return "index";
	}

	// 根据搜索框中的内容将请求转发给对应的Controller,避免每次都搜索所有表
	@RequestMapping("/search.action")
	public String search(String name) throws Exception{
		String firstName = "赵钱孙李 周吴郑王 冯陈诸卫 蒋沈韩杨 朱秦尤许 何吕施张 孔曹严华 金魏陶姜 戚谢邹喻 柏水窦章 云苏潘葛 奚范彭郎 鲁韦昌马 苗凤花方 俞任袁柳 酆鲍史唐 费廉岑薛 雷贺倪汤 滕殷罗毕 郝邬安常 乐于时傅 皮卡齐康 伍余元卜 顾孟平黄 和穆萧尹 姚邵堪汪 祁毛禹狄 米贝明臧 计伏成戴 谈宋茅庞 熊纪舒屈 项祝董粱 杜阮蓝闵 席季麻强 贾路娄危 江童颜郭 梅盛林刁 钟徐邱骆 高夏蔡田 樊胡凌霍 虞万支柯 咎管卢莫 经房裘缪 干解应宗 丁宣贲邓 郁单杭洪 包诸左石 崔吉钮龚 程嵇邢滑 裴陆荣翁 荀羊於惠 甄魏家封 芮羿储靳 汲邴糜松 井段富巫 乌焦巴弓 牧隗山谷 车侯宓蓬 全郗班仰 秋仲伊宫 宁仇栾暴 甘钭厉戎 祖武符刘 景詹束龙 叶幸司韶 郜黎蓟薄 印宿白怀 蒲台从鄂 索咸籍赖 卓蔺屠蒙 池乔阴郁 胥能苍双 闻莘党翟 谭贡劳逄 姬申扶堵 冉宰郦雍 却璩桑桂 濮牛寿通 边扈燕冀 郏浦尚农 温别庄晏 柴翟阎充 慕连茹习 宦艾鱼容 向古易慎 戈廖庚终 暨居衡步 都耿满弘 匡国文寇 广禄阙东 殴殳沃利 蔚越夔隆 师巩厍聂 晁勾敖融 冷訾辛阚 那简饶空 曾毋沙乜 养鞠须丰 巢关蒯相 查后荆红 游竺权逯 盖后桓公 万俟司马 上官欧阳 夏侯诸葛 闻人东方 赫连皇甫 尉迟公羊 澹台公冶 宗政濮阳 淳于单于 太叔申屠 公孙仲孙 轩辕令狐 钟离宇文 长孙慕容 鲜于闾丘 司徒司空 亓官司寇 仉督子车 颛孙端木 巫马公西 漆雕乐正 壤驷公良 拓拔夹谷 宰父谷粱 晋楚闫法 汝鄢涂钦 段干百里 东郭南门 呼延归海 羊舌微生 岳帅缑亢 况后有琴 梁丘左丘 东门西门 商牟佘佴 伯赏南宫 墨哈谯笪 年爱阳佟 第五言福 百家姓终";
		if (name.contains("医院")) {
			return "forward:findHospitalByName.action";
		}else if(firstName.contains(name.substring(0,1))){
			return "forward:findDoctorsByName.action";
		}else{
			return "forward:findillnessByName.action";
		}
	}
}
